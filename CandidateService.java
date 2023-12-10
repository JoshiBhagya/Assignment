package com.ecommerce.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.api.models.Candidate;
import com.ecommerce.api.repository.CandidateRepository;

import jakarta.transaction.Transactional;

@Service
public class CandidateService {
   

    @Autowired
    private  CandidateRepository candidateRepository;
    //public CandidateService(CandidateRepository candidateRepository) {
      //  this.candidateRepository = candidateRepository;}
    

    public Candidate enterCandidate(String name) {
        Candidate candidate = new Candidate(name);
        Candidate dbcandidate = candidateRepository.save(candidate);
        return dbcandidate;
    }
    
    @Transactional
    public int castVote(String name) {
        Candidate candidate = candidateRepository.findByName(name);
        if (candidate != null) {
        	 candidate.setVoteCount(candidate.getVoteCount()+ 1 );
        	// candidate.incrementVoteCount();
        	 candidateRepository.save(candidate);
        	 return candidate.getVoteCount();
        } else {
            return -1; // Invalid candidate
        }
    }

    public int countVote(String name) {
        Candidate candidate = candidateRepository.findByName(name);
        if (candidate != null) {
            return candidate.getVoteCount();
        } else {
            throw new IllegalArgumentException("Invalid candidate name");
        }
    }

    public List<Candidate> listVotes() {
        return candidateRepository.findAll();
    }

    public String getWinner() {
        List<Candidate> candidates = candidateRepository.findAll();
        Candidate winner = candidates.stream()
                .max((c1, c2) -> Integer.compare(c1.getVoteCount(), c2.getVoteCount()))
                .orElse(null);

        return (winner != null) ? winner.getName() : null;
    }

}
