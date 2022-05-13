package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public interface TestedByRepo extends CrudRepository<Tested_By, Tested_ByID> {

	@Query("SELECT t.test_id from Tested_By t where t.ssn = (:ssn)")
	public List<Integer> testsDoneByTechnician(@Param("ssn") Integer ssn);

}
