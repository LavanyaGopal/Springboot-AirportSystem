package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface Faa_DetailsRepo extends CrudRepository<Faa_Details, Integer> {

}