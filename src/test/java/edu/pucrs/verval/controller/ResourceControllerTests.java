package edu.pucrs.verval.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ResourceControllerTests {

	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		final ResourceController resourceController = new ResourceController();
		
		mockMvc = MockMvcBuilders.standaloneSetup(resourceController).build();
	}
	
	@Test
	public void returnAllResourcesShouldBeOk() throws Exception {
		this.mockMvc.perform(get("/api/resources"))
			.andExpect(status().isOk());
	}
	
}
