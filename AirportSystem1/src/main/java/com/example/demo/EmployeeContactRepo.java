package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service

public interface EmployeeContactRepo extends CrudRepository<Phone_Number, Phone_NumberID> {

	@Query("SELECT p.ph_no from Phone_Number p where p.ssn = (:ssn)")
	public List<Integer> allPhNoOfEmployee(@Param("ssn") Integer ssn);

}
