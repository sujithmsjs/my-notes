@Override
	public PaginationResponseDto<Break> findAllBreaks(PaginationRequestDto dto) {

		PageRequest pageRequest = PageRequest.of(dto.getPageNumber() - 1, dto.getPageSize());

		// Page<Break> page = breakRepository.findAll(pageRequest);

		// Create CriteriaBuilder
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		CriteriaQuery<Break> cq = cb.createQuery(Break.class);
		Root<Break> root = cq.from(Break.class);

		// Prepare List of Predicates
		List<Predicate> predicateList = new ArrayList<Predicate>();

		if (dto.getOrgId() != null) {
			Predicate pred = cb.equal(root.get("orgId"), dto.getOrgId());
			predicateList.add(pred);
		}

		Predicate pred = cb.equal(root.get("isActive"), dto.getActive());
		predicateList.add(pred);

		if (StringUtils.isNotBlank(dto.getSearchValue())) {
			String searchValue = dto.getSearchValue().toLowerCase();
			predicateList.add(cb.like(cb.lower(root.get("breakName")), "%" + searchValue + "%"));
		}

		// Convert list to array
		Predicate[] predicateArray = predicateList.toArray(new Predicate[predicateList.size()]);

		cq.select(root).where(predicateArray);

		TypedQuery<Break> typedQuery = entityManager.createQuery(cq);
		
		List<Break> list = typedQuery.getResultList();

		typedQuery.setFirstResult((dto.getPageNumber() - 1) * dto.getPageSize());
		typedQuery.setMaxResults(dto.getPageSize());

		List<Break> list2 = typedQuery.getResultList();

		PageImpl<Break> page = new PageImpl<Break>(list2, pageRequest, list.size());

		var dtoRes = new PaginationResponseDto<Break>();
		dtoRes.setData(page.getContent());
		dtoRes.setNumberOfPages(page.getTotalPages());
		dtoRes.setPage(page.getNumber() + 1);
		dtoRes.setTotalElements(page.getTotalElements());

		return dtoRes;
	}




---


@Override
	public PaginationResponseDto<Break> findAllBreaks(PaginationRequestDto dto) {
		PageRequest pageRequest = PageRequest.of(dto.getPageNumber() - 1, dto.getPageSize());

		// Create CriteriaBuilder
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();

		// Prepare CriteriaQuery and Root
		CriteriaQuery<Tuple> cq = cb.createTupleQuery();
		Root<Break> root = cq.from(Break.class);

		// Prepare List of Predicates
		List<Predicate> predicateList = new ArrayList<>();

		if (dto.getOrgId() != null) {
			Predicate pred = cb.equal(root.get("orgId"), dto.getOrgId());
			predicateList.add(pred);
		}

		Predicate pred = cb.equal(root.get("isActive"), dto.getActive());
		predicateList.add(pred);

		if (StringUtils.isNotBlank(dto.getSearchValue())) {
			String searchValue = dto.getSearchValue().toLowerCase();
			predicateList.add(cb.like(cb.lower(root.get("breakName")), "%" + searchValue + "%"));
		}

		// Convert list to array
		Predicate[] predicateArray = predicateList.toArray(new Predicate[0]);

		// Prepare the select clause using multiselect
		cq.multiselect(root.get("breakId"), root.get("breakName"), root.get("breakDuration"), root.get("isActive"),
				root.get("orgId")).where(predicateArray);

		// Create the typed query and execute it
		TypedQuery<Tuple> typedQuery = entityManager.createQuery(cq);

		if (! dto.getExport()) {
			typedQuery.setFirstResult((dto.getPageNumber() - 1) * dto.getPageSize());
			typedQuery.setMaxResults(dto.getPageSize());
		}

		List<Tuple> tupleList = typedQuery.getResultList();

		// Convert Tuple list to Break list
		List<Break> breakList = tupleList.stream().map(tuple -> {
			Break breakObj = new Break();

			breakObj.setBreakId(tuple.get(0, Integer.class));
			breakObj.setBreakName(tuple.get(1, String.class));
			breakObj.setBreakDuration(tuple.get(2, Integer.class));
			breakObj.setIsActive(tuple.get(3, Boolean.class));
			breakObj.setOrgId(tuple.get(4, Integer.class));

			return breakObj;

		}).collect(Collectors.toList());

		// Create and return the response DTO
		PageImpl<Break> page = null;
		if(dto.getExport()) {
			page = new PageImpl<Break>(breakList, PageRequest.of(0, breakList.size()), breakList.size());
		}else {
			page = new PageImpl<Break>(breakList, pageRequest, getCount(predicateArray));
		}

		PaginationResponseDto<Break> dtoRes = new PaginationResponseDto<>();
		dtoRes.setData(page.getContent());
		dtoRes.setNumberOfPages(page.getTotalPages());
		dtoRes.setPage(page.getNumber() + 1);
		dtoRes.setTotalElements(page.getTotalElements());
		return dtoRes;
	}

	private long getCount(Predicate[] predicateArray) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
		Root<Break> root = countQuery.from(Break.class);
		countQuery.select(cb.count(root)).where(predicateArray);
		return entityManager.createQuery(countQuery).getSingleResult();
	}



---


@Override
	public Map<String, Object> getVediosHistory(@Valid ContentPaginationRequest paginationRequest) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<ObsVideoActivityHistoryEntity> cq = cb.createQuery(ObsVideoActivityHistoryEntity.class);
		Root<ObsVideoActivityHistoryEntity> root = cq.from(ObsVideoActivityHistoryEntity.class);
		Map<String, Object> response = null;

		List<Predicate> predicates = new ArrayList<Predicate>();

		if (!paginationRequest.getSearchKey().isBlank()) {
			predicates.add(cb.or(cb.like(root.get("videoName"), "%" + paginationRequest.getSearchKey() + "%"),
					cb.like(root.get("emailId"), "%" + paginationRequest.getSearchKey() + "%")));
		}

		if (paginationRequest.getStartDate() != null) {
			predicates.add(cb.greaterThanOrEqualTo(root.get("updatedDate").as(java.sql.Date.class),
					paginationRequest.getStartDate()));
			predicates.add(cb.lessThanOrEqualTo(root.get("updatedDate").as(java.sql.Date.class),
					paginationRequest.getEndDate()));
		}
		if (paginationRequest.getId() != null) {
			predicates.add(cb.equal(root.get("videoId"), paginationRequest.getId()));
		}
		cq.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		cq.orderBy(cb.desc(root.get("videoHistoryId")));

		TypedQuery<ObsVideoActivityHistoryEntity> typeQuery = entityManager.createQuery(cq);
		Long totatlRecordsCount = count(predicates);
		if (paginationRequest.getPage() != null && paginationRequest.getSize() != null) {
			typeQuery.setFirstResult((paginationRequest.getPage() - 1) * paginationRequest.getSize());
			typeQuery.setMaxResults(paginationRequest.getSize());
		}
		List<ObsVideoActivityHistoryEntity> resultList = typeQuery.getResultList();
		if (!resultList.isEmpty()) {
			response = new HashMap<>();
			response.put("data", resultList);
			response.put("totatlRecordsCount", totatlRecordsCount);
			response.put("pageIndex", paginationRequest.getPage() - 1);
			response.put(CommonConstants.TOTAL_PAGES, totatlRecordsCount / paginationRequest.getSize());
		} else {
			response = new HashMap<>();
			response.put("data", null);
		}

		return response;
	}
	
	
	

	public Long count(List<Predicate> predicates) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
		Root<ObsVideoActivityHistoryEntity> rootCust = countQuery.from(ObsVideoActivityHistoryEntity.class);
		countQuery.select(cb.count(rootCust));
		countQuery.where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(countQuery).getSingleResult();
	}