package com.ecommerce.api.ControllerTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

public class CandidateControllerTest {

	
	@Autowired
    private MockMvc mockMvc;

    @Test
    void enterCandidate() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/entercandidate?name=Ajay"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void castVote() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/castvote?name=Ajay"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void countVote() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/countvote?name=Ajay"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void listVotes() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/listvotes"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void getWinner() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/getwinner"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}

