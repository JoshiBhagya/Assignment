package com.ecommerce.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ecommerce.api.models.Candidate;


public interface CandidateRepository  extends JpaRepository<Candidate,Integer>{
    
//public interface CandidateRepository extends JpaRepository<Candidate, String> {	
	
    Candidate findByName(String name);

    List<Candidate> findAll();
}