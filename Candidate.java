package com.ecommerce.api.models;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Candidate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String name;
    private int voteCount;
    
    public Candidate() {
        //  requires a default constructor
    }

    // Constructor with parameters
    public Candidate(String name) {
        this.name = name;
        this.voteCount=0;
    }
    
   // public void incrementVoteCount() {
     //   this.voteCount++;
    //}
}
