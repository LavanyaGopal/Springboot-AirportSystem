package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface ExpertInRepo extends CrudRepository<Expert_In, Expert_InID> {

//	void findAllById(Integer ssn);

//	@Query("SELECT e FROM Expense e WHERE e.amount >= :amount")
//	public List<Expense> listItemsWithPriceOver(@Param("amount") float amount);
//	
//	
//	@Query("SELECT e.model_id from Expert_In e where e.ssn = (:ssn) and e.model_id = (:model_id)")
//	public List<Integer> listExpertizeOfTechnician(@Param("ssn") Integer ssn , @Param("model_id") Integer model_id);
//	

	@Query("SELECT e.model_id from Expert_In e where e.ssn = (:ssn)")
	public List<Integer> listExpertizeOfTechnician1(@Param("ssn") Integer ssn);

//	@Query("INSERT into Expert_In  values(:ssn,:model_id)")
//	public String insertNewTech(@Param("ssn") Integer ssn,@Param("model_id") Integer model_id);
//	
}
