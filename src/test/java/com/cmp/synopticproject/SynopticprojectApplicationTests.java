package com.cmp.synopticproject;

import org.junit.jupiter.api.Test;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
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
	public void infoFShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/infoF").with(user("farmer").roles("Farmer"))).andExpect(status().isOk());
	}

	@Test
	public void infoRShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/infoR").with(user("resident").roles("Resident"))).andExpect(status().isOk());
	}

	@Test
	public void ourGoalFShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/ourGoalF").with(user("farmer").roles("Farmer"))).andExpect(status().isOk());
	}

	@Test
	public void ourGoalRShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/ourGoalR").with(user("resident").roles("Resident"))).andExpect(status().isOk());
	}

	@Test
	public void reportFShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/reportF").with(user("farmer").roles("Farmer"))).andExpect(status().isOk());
	}

	@Test
	public void reportRShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/reportR").with(user("resident").roles("Resident"))).andExpect(status().isOk());
	}

	@Test
	public void welcomeFShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/welcomeF").with(user("farmer").roles("Farmer"))).andExpect(status().isOk());
	}

	@Test
	public void welcomeRShouldReturnOkStatus() throws Exception {
		this.mockMvc.perform(get("/welcomeR").with(user("resident").roles("Resident"))).andExpect(status().isOk());
	}
}

