package com.onpassive.ocrm.sujith;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.codehaus.plexus.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Field;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onpassive.ocrm.model.EmployeeModel;
import com.onpassive.ocrm.model.TicketsModel;
import com.onpassive.ocrm.repository.AgentRepository;
import com.onpassive.ocrm.utility.HelperData;

import lombok.Data;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	MongoTemplate template;

	@Autowired
	AgentRepository agentRepository;

	@GetMapping("/{role}/{sort}")
	public List<RoleName> test(@PathVariable String role, @PathVariable int sort) {
		System.out.println("Role: " + role);
		return agentRepository.getList(role, sort);
	}

	@GetMapping("/V2/{role}/{sort}")
	public List<RoleName> testv2(@PathVariable String role, @PathVariable int sort) {
		System.out.println("Role: " + role);
		return agentRepository.getListV2(role, sort);
	}

	@GetMapping("/V3/{role}/{sort}")
	public List<RoleName> testv3(@PathVariable String role, @PathVariable int sort) {
		System.out.println("Role: " + role);
		Sort descending = Sort.by("first_name").descending();
		return agentRepository.getListV3(role, descending);
	}

	@GetMapping("/V4/{regex}")
	public List<EmployeeModel> testv4(@PathVariable String regex) {
		Query query = new Query();

		query.addCriteria(Criteria.where("first_name").regex(regex, "i"));
		Field fields = query.fields();
		fields.include("first_name", "last_name");

		List<EmployeeModel> find = template.find(query, EmployeeModel.class);

		return find;

	}

	@GetMapping("/V5/{searchKey}")
	public List<RoleName> testv5(@PathVariable String searchKey) {

		Criteria regex = Criteria.where("firstName").regex(searchKey, "i");
		Sort sort = Sort.by("firstName").descending();

		MatchOperation match = Aggregation.match(regex);
		SortOperation sort2 = Aggregation.sort(sort);

		List<AggregationOperation> operations = new ArrayList<>();
		operations.add(match);
		operations.add(sort2);

		Aggregation aggregation = Aggregation.newAggregation(operations);
		AggregationResults<RoleName> aggregate = template.aggregate(aggregation, EmployeeModel.class, RoleName.class);

		return aggregate.getMappedResults();

	}

	@PostMapping("/V6/reports")
	public List<RoleName> testv6(@RequestBody HelperData dto) {

		List<AggregationOperation> operations = new ArrayList<>();

		Criteria status = Criteria.where("status").is(dto.getStatus());
		Criteria priority = Criteria.where("priority").is(dto.getPriority());
		Sort sort = Sort.by("ticketId");
		// Criteria region = Criteria.where("firstName").is(dto.getRegion());
		// Criteria country = Criteria.where("firstName").is(dto.getCountry());

		operations.add(Aggregation.match(status));
		operations.add(Aggregation.match(priority));
		operations.add(Aggregation.skip(0L));
		operations.add(Aggregation.limit(10));
		operations.add(Aggregation.sort(sort));

		// operations.add(Aggregation.match(region));
		// operations.add(Aggregation.match(country));

		Aggregation.skip(0L);

		Aggregation aggregation = Aggregation.newAggregation(operations);

		AggregationResults<RoleName> aggregate = template.aggregate(aggregation, TicketsModel.class, RoleName.class);

		return aggregate.getMappedResults();

	}

	@PostMapping("/V7/reports")
	public List<RoleName> test7(@RequestBody HelperData dto) {
		
		List<AggregationOperation> operations = new ArrayList<>();
		
		if (StringUtils.isNotBlank(dto.getAgentId())) {
			Criteria product = Criteria.where("productId").is(dto.getProduct());
			operations.add(Aggregation.match(product));
		}

		if (StringUtils.isNotBlank(dto.getFromDt())) {
			Criteria product = Criteria.where("productId").is(dto.getProduct());
			operations.add(Aggregation.match(product));
		}

		if (StringUtils.isNotBlank(dto.getToDt())) {
			Criteria product = Criteria.where("productId").is(dto.getProduct());
			operations.add(Aggregation.match(product));
		}

		if (StringUtils.isNotBlank(dto.getStatus())) {
			Criteria status = Criteria.where("status").is(dto.getStatus());
			operations.add(Aggregation.match(status));
		}
		
		if (StringUtils.isNotBlank(dto.getPriority())) {
			Criteria priority = Criteria.where("priority").is(dto.getPriority());
			operations.add(Aggregation.match(priority));
		}
		
		if (StringUtils.isNotBlank(dto.getCountry())) {
			Criteria priority = Criteria.where("priority").is(dto.getCountry() );
			operations.add(Aggregation.match(priority));
		}

		return null;
	}

	@Data
	public static class RoleName {

		public RoleName() {
			System.out.println("public static class RoleName() consturctor!");
		}

		private String case_id;
	}

}
