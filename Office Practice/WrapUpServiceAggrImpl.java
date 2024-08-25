package com.onpassive.odesk.admin.serviceimpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang.StringUtils;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.AddFieldsOperation.AddFieldsOperationBuilder;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.LimitOperation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SkipOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import com.onpassive.odesk.admin.dto.WrapUpAggrDTO;
import com.onpassive.odesk.admin.dto.WrapUpSearchDTO;
import com.onpassive.odesk.admin.entity.WrapUp;
import com.onpassive.odesk.admin.repository.SupportSubCategoryRepository;
import com.onpassive.odesk.dto.PaginationResponseDTO;
import com.onpassive.odesk.repository.OdeskCategoryRepository;
import com.onpassive.odesk.repository.OdeskProductRepository;
import com.onpassive.odesk.repository.OdeskSupportCategoryRepository;
import com.onpassive.odesk.service.TimeZoneService;
import com.onpassive.odesk.utility.CustomAggregationOperation;

/**
 * @author sujith.manchala
 */
@Service
public class WrapUpServiceAggrImpl {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private OdeskProductRepository productsRepository;

	@Autowired
	private TimeZoneService timeZoneService;

	@Autowired
	OdeskCategoryRepository categoryRepository;

	@Autowired
	private OdeskSupportCategoryRepository csCategoryRepository;

	@Autowired
	private SupportSubCategoryRepository supportSubCategoryRepository;

	public List<WrapUpAggrDTO> getWrapUpDetailsSample() {
		LookupOperation lookup = Aggregation.lookup("customers", "customer_id", "_id", "customer");
		UnwindOperation unwind = Aggregation.unwind("customer", true);

		AddFieldsOperationBuilder fields = Aggregation.addFields();
		fields.addFieldWithValue("customer_id", "$customer.customer_id");
		fields.addFieldWithValue("customer_name",
				new Document("$concat", Arrays.asList("$customer.first_name", " ", "$customer.last_name")));
		fields.addFieldWithValue("customer_email", "$customer.email");

		Aggregation aggregation = Aggregation.newAggregation(lookup, unwind, fields.build());

		AggregationResults<WrapUpAggrDTO> contentResults = mongoTemplate.aggregate(aggregation, WrapUp.class,
				WrapUpAggrDTO.class);

		return contentResults.getMappedResults();
	}

	public PaginationResponseDTO getWrapUpDetails___v2(WrapUpSearchDTO searchWrap) {

		// JwtDetails userDetails = timeZoneService.getPresentUserDetails();
		// userDetails.getOrgId();
		// searchWrap.setOrgId(userDetails.getOrgId().toString());

		searchWrap.setOrgId(null);

		var aggrList = new ArrayList<AggregationOperation>();

		// SortOperation sort = Aggregation.sort(Sort.by("firstName"));
		int pageNumber = searchWrap.getPageNumber() - 1;
		int pageSize = searchWrap.getPageSize();

		Optional<Criteria> optncriteria = createCriteria(searchWrap);
		if (optncriteria.isPresent()) {
			MatchOperation matchStage = Aggregation.match(optncriteria.get());
			aggrList.add(matchStage);
		}

		Aggregation aggregation = null;
		
		Integer totalElements = 0;

		// If export, no need to find total elements.
		if (!searchWrap.isExport()) {
			// Count state is used to count the results before pagination
			AggregationOperation countStage = Aggregation.group().count().as("count");
			aggrList.add(countStage);

			aggregation = Aggregation.newAggregation(aggrList);

			// Count total Elements
			AggregationResults<Document> countResults = mongoTemplate.aggregate(aggregation, WrapUp.class,
					Document.class);

			try {
				totalElements = countResults.getUniqueMappedResult().getInteger("count");
				System.out.println("Results: " + countResults.getUniqueMappedResult().getInteger("count"));
			} catch (Exception e) {
				totalElements = 0;
			}

			if (totalElements < 1) {
				PaginationResponseDTO response = new PaginationResponseDTO();
				response.setTotalRows(0);
				response.setList(List.of());
				response.setPage(searchWrap.getPageNumber());
				response.setNumberOfPages(0);
				response.setMessage("No results found...");
				return response;
			}

			aggrList.remove(aggrList.size() - 1);
		}
		
		SortOperation sort = Aggregation.sort(Sort.by(Sort.Direction.DESC, "updatedOn"));
		aggrList.add(sort);

		if (!searchWrap.isExport()) {
			SkipOperation skipStage = Aggregation.skip((long) pageNumber * pageSize);
			aggrList.add(skipStage);

			LimitOperation limitStage = Aggregation.limit(pageSize);
			aggrList.add(limitStage);
		}
		
		LookupOperation lookup = Aggregation.lookup("customers", "customer_id", "_id", "customer");
		aggrList.add(lookup);

		UnwindOperation unwind = Aggregation.unwind("customer", true);
		aggrList.add(unwind);

		AddFieldsOperationBuilder fields = Aggregation.addFields();
		fields.addFieldWithValue("customer_id", "$customer.customer_id");
		fields.addFieldWithValue("customer_name",
				new Document("$concat", Arrays.asList("$customer.first_name", " ", "$customer.last_name")));
		fields.addFieldWithValue("customer_email", "$customer.email");
		aggrList.add(fields.build());

		aggregation = Aggregation.newAggregation(aggrList);

		AggregationResults<WrapUpAggrDTO> contentResults = mongoTemplate.aggregate(aggregation, WrapUp.class,
				WrapUpAggrDTO.class);

		PaginationResponseDTO response = new PaginationResponseDTO();

		// Updating content
		List<WrapUpAggrDTO> list = contentResults.getMappedResults();
		//list = updateDataWithValues(list);
		response.setList(list);

		if (searchWrap.isExport()) {
			totalElements = list.size();
		} else {
			var totalPages = totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1;
			response.setNumberOfPages(totalPages);
			response.setPage(searchWrap.getPageNumber());
		}

		response.setTotalRows(totalElements);
		return response;
	}

	public PaginationResponseDTO getWrapUpDetails(WrapUpSearchDTO searchWrap) {

		// JwtDetails userDetails = timeZoneService.getPresentUserDetails();
		// userDetails.getOrgId();
		// searchWrap.setOrgId(userDetails.getOrgId().toString());
		searchWrap.setOrgId(null);

		String query = "{" + "    $lookup:" + "      {" + "        from: 'customers',"
				+ "        localField: 'customer_id'," + "        foreignField: '_id'," + "        as: 'customer',"
				+ "      }," + "  }";

		String query2 = "  {" + "    $unwind:" + "      {" + "        path: '$customer',"
				+ "        preserveNullAndEmptyArrays: true," + "      }," + "  }";

		Aggregation.lookup("customers", "customer_id", "_id", "customer");
		Aggregation.unwind("customer", true);

		// SortOperation sort = Aggregation.sort(Sort.by("firstName"));
		int pageNumber = searchWrap.getPageNumber() - 1;
		int pageSize = searchWrap.getPageSize();

		Optional<Criteria> optncriteria = createCriteria(searchWrap);
		var aggrList = new ArrayList<AggregationOperation>();

		if (optncriteria.isPresent()) {
			MatchOperation matchStage = Aggregation.match(optncriteria.get());
			aggrList.add(matchStage);
		}

		var aggr1 = new CustomAggregationOperation(query);
		aggrList.add(aggr1);

		var aggr2 = new CustomAggregationOperation(query2);
		aggrList.add(aggr2);

		Aggregation aggregation = Aggregation.newAggregation(aggrList);

		Integer totalElements = 0;

		// If export, no need to find total elements.
		if (!searchWrap.isExport()) {
			// Count state is used to count the results before pagination
			AggregationOperation countStage = Aggregation.group().count().as("count");
			aggrList.add(countStage);

			aggregation = Aggregation.newAggregation(aggrList);

			// Count total Elements
			AggregationResults<Document> countResults = mongoTemplate.aggregate(aggregation, WrapUp.class,
					Document.class);

			try {
				totalElements = countResults.getUniqueMappedResult().getInteger("count");
				System.out.println("Results: " + countResults.getUniqueMappedResult().getInteger("count"));
			} catch (Exception e) {
				totalElements = 0;
			}

			if (totalElements < 1) {
				PaginationResponseDTO response = new PaginationResponseDTO();
				response.setTotalRows(0);
				response.setList(List.of());
				response.setPage(searchWrap.getPageNumber());
				response.setNumberOfPages(0);
				response.setMessage("No results found...");
				return response;
			}

			aggrList.remove(aggrList.size() - 1);
		}

		SortOperation sort = Aggregation.sort(Sort.by(Sort.Direction.DESC, "updatedOn"));
		aggrList.add(sort);

		if (!searchWrap.isExport()) {
			SkipOperation skipStage = Aggregation.skip((long) pageNumber * pageSize);
			aggrList.add(skipStage);

			LimitOperation limitStage = Aggregation.limit(pageSize);
			aggrList.add(limitStage);
		}

		// Add projection
		String projection = "{" + "   $project: {" + "   	_id : 1," + "   	type : 1," + "   	chat_id : 1,"
				+ "   	chat_id_str : 1," + "     org_id : 1," + "     product_id: 1," + "     action :1,"
				+ "     remarks : 1," + "     reason : 1," + "     status : 1," + "     cs_sub_category : 1,"
				+ "     cs_category : 1," + "     created_by : 1," + "     updated_by : 1," + "     created_at : 1,"
				+ "     updated_at : 1, category_id : 1," + "     customer_id: '$customer.customer_id',"
				+ "     customer_email: '$customer.email',"
				+ "     customer_name : { $concat: ['$customer.first_name', ' ', '$customer.last_name'] }" + "    }"
				+ "}";

		var proj = new CustomAggregationOperation(projection);
		aggrList.add(proj);

		aggregation = Aggregation.newAggregation(aggrList);

		AggregationResults<WrapUpAggrDTO> contentResults = mongoTemplate.aggregate(aggregation, WrapUp.class,
				WrapUpAggrDTO.class);

		PaginationResponseDTO response = new PaginationResponseDTO();

		// Updating content
		List<WrapUpAggrDTO> list = contentResults.getMappedResults();
		list = updateDataWithValues(list);
		response.setList(list);

		if (searchWrap.isExport()) {
			totalElements = list.size();
		} else {
			var totalPages = totalElements % pageSize == 0 ? totalElements / pageSize : totalElements / pageSize + 1;
			response.setNumberOfPages(totalPages);
			response.setPage(searchWrap.getPageNumber());
		}

		response.setTotalRows(totalElements);
		return response;
	}

	public Optional<Criteria> createCriteria(WrapUpSearchDTO searchWrap) {

		List<Criteria> criteriaList = new ArrayList<>();

		if (StringUtils.isNotBlank(searchWrap.getProductId())) {
			criteriaList.add(Criteria.where("product_id").is(searchWrap.getProductId()));
		}

		if (StringUtils.isNotBlank(searchWrap.getCsCategory())) {
			criteriaList.add(Criteria.where("cs_category_id").is(searchWrap.getCsCategory()));
		}

		if (StringUtils.isNotBlank(searchWrap.getCsSubCategory())) {
			criteriaList.add(Criteria.where("cs_sub_category_id").is(searchWrap.getCsSubCategory()));
		}

		if (StringUtils.isNotBlank(searchWrap.getType())) {
			criteriaList.add(Criteria.where("type").is(searchWrap.getType()));
		}

		if (StringUtils.isNotBlank(searchWrap.getOrgId())) {
			criteriaList.add(Criteria.where("org_id").is(searchWrap.getOrgId()));
		}

		if (StringUtils.isNotBlank(searchWrap.getStatus())) {
			criteriaList.add(Criteria.where("status").is(searchWrap.getStatus()));
		}

		if (StringUtils.isNotBlank(searchWrap.getCategoryId())) {
			criteriaList.add(Criteria.where("category_id").is(searchWrap.getCategoryId()));
		}

		if (criteriaList.isEmpty()) {
			return Optional.ofNullable(null);
		}

		if (criteriaList.size() == 1) {
			return Optional.ofNullable(criteriaList.get(0));
		}

		Criteria combinedCriteria = new Criteria().andOperator(criteriaList.toArray(new Criteria[0]));

		return Optional.ofNullable(combinedCriteria);
	}

	public List<WrapUpAggrDTO> updateDataWithValues(List<WrapUpAggrDTO> data) {
		System.out.println();

		Map<String, String> products = productsRepository.findAll().stream().filter(w -> w.getProductName() != null)
				.collect(Collectors.toMap(w -> w.getProductId().toString(), w -> w.getProductName()));

		Map<String, String> csCategories = csCategoryRepository.findAll().stream()
				.filter(w -> w.getSupportCategoryName() != null)
				.collect(Collectors.toMap(s -> s.getSupportCategoryId().toString(), s -> s.getSupportCategoryName()));

		Map<String, String> subCategories = supportSubCategoryRepository.findAll().stream()
				.filter(w -> w.getSupportCategoryName() != null)
				.collect(Collectors.toMap(s -> s.getSupportCategoryId().toString(), s -> s.getSupportCategoryName()));

		Map<String, String> cats = categoryRepository.findAll().stream().filter(w -> w.getCategoryName() != null)
				.collect(Collectors.toMap(s -> s.getCategoryId().toString(), s -> s.getCategoryName()));

		products.forEach((k, v) -> System.out.println("Key " + k + ";Value " + v));

//		List<WrapUpAggrDTO> collect = data.stream().map(w -> {
//			w.setProduct_id(products.get(w.getProduct_id()));
//			w.setCs_category(csCategories.get(w.getCs_category()));
////			w.setCs_sub_category(subCategories.get(w.getCsSubCategory()));
////			w.setCs_sub_category(subCategories.get(w.getCsSubCategory()));
//			w.setCategory_id(cats.get(w.getCategory_id()));
//			return w;
//		}).collect(Collectors.toList());

		return null;
	}

}
