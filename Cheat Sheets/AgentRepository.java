package com.onpassive.ocrm.repository;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.onpassive.ocrm.model.EmployeeModel;
import com.onpassive.ocrm.sujith.TestController.RoleName;

/*
 * this Repository for EmployeeModel mapped to agent_details in MongoD
 */
@Repository
public interface AgentRepository extends MongoRepository<EmployeeModel, String> {

//	@Query("{'_id' : ?0}")
//	public Optional<EmployeeModel> findById(String id);

	@Query("{'role' : ?0}")
	List<EmployeeModel> findByRole(String role);

	@Query("{'team' : ?0}")
	public List<EmployeeModel> findByTeam(ObjectId team);

	@Query("{'teamleader_id.$id' : ?0}")
	List<EmployeeModel> findByManagerId(ObjectId agentModel);

	@Query(value = "{$and:[{'role.$id': {$ne : ?0}} ,{'id':  {$ne : ?1}}]}")
	List<EmployeeModel> findAgents(ObjectId role, ObjectId role1);

	@Query("{'role.$id' : ?0}")
	List<EmployeeModel> listOfEmployeeBasedOnRole(ObjectId role);

	@Query(value = "{first_name:{$regex : RegExp(?0,'i')}}", fields = "{first_name :1, _id:0}")
	List<RoleName> getList(String searchKey, int sort);

	// Error
	@Query(value = "{first_name:{$regex : RegExp(?0,'i')}}", fields = "{first_name :1, _id:0}", sort = "{first_name : ?1 }")
	List<RoleName> getListV2(String searchKey, int sort);

	@Query(value = "{first_name:{$regex : RegExp(?0,'i')}}", fields = "{first_name :1, _id:0}")
	List<RoleName> getListV3(String searchKey, Sort sort);

	@Query(value = "{first_name:{$regex : RegExp(?0,'i')}}", fields = "{first_name :1, _id:0}")
	List<EmployeeModel> getListV4(String searchKey, Sort sort);

}
