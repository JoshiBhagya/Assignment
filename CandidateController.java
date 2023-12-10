package com.ecommerce.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ecommerce.api.models.Candidate;
import com.ecommerce.api.service.CandidateService;

//http://localhost:8083/api/entercandidate?name=ajay

@RestController
@RequestMapping("/api")

public class CandidateController {
   
	//private final CandidateService candidateService;

    //public CandidateController(CandidateService candidateService) {
      //  this.candidateService = candidateService;
    //}
	
	@Autowired
	private  CandidateService candidateService;

    @PostMapping("/entercandidate")
    public void enterCandidate(@RequestParam String name) {
        candidateService.enterCandidate(name);
    }

 
    @PostMapping("/castvote")
   
    public int castVote(@RequestParam String name) {
        return candidateService.castVote(name);
   
    }


    @GetMapping("/countvote")
   
    public int countVote(@RequestParam String name) {
        return candidateService.countVote(name);
  
   

          
}

    @GetMapping("/listvotes")
    public List<Candidate> listVotes() {
        return candidateService.listVotes();
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        return candidateService.getWinner();
    }

}
