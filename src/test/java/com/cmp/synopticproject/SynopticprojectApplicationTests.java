package com.cmp.synopticproject;

import org.junit.jupiter.api.Test;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

/**
 * Class of unit tests for application.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class SynopticprojectApplicationTests {

	// Simulates app behaviour for testing
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void indexShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/index")).andExpect(status().isOk());
	}

	@Test
	public void ourGoalShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/ourGoal")).andExpect(status().isOk());
	}

	@Test
	public void reportShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/report")).andExpect(status().isOk());
	}

	@Test
	public void welcomeFShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/welcomeF")).andExpect(status().isOk());
	}

	@Test
	public void welcomeRShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/welcomeR")).andExpect(status().isOk());
	}
}

