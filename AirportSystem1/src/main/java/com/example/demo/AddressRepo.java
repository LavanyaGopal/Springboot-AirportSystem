package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service

public interface AddressRepo extends CrudRepository<Address, AddressID> {

	@Query("SELECT a from Address a where a.ssn = (:ssn)")
	public List<Address> getAddBasedOnSsn(@Param("ssn") Integer ssn);

	// public List<Address> getAddBasedOnSsn(Integer ssn);

}
