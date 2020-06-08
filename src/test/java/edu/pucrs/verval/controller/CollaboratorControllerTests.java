package edu.pucrs.verval.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class CollaboratorControllerTests {
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		final CollaboratorController collaboratorController = new CollaboratorController();
		
		mockMvc = MockMvcBuilders.standaloneSetup(collaboratorController).build();
	}
	
	@Test
	public void returnAllCollaboratorsShouldBeOk() throws Exception {
		this.mockMvc.perform(get("/api/collaborator"))
			.andExpect(status().isOk());
	}
	
	@Test
	public void returnCollaboratorByIdShouldReturnCollaborator() throws Exception {
		this.mockMvc.perform(get("/api/collaborator/1"))
		.andExpect(status().isOk());
	}
	
	@Test
	public void returnCollaboratorByIdWithInvalidIdShouldReturnBadRequest() throws Exception {
		this.mockMvc.perform(get("/api/collaborator/AAAA"))
		.andExpect(status().isBadRequest());
	}

}
