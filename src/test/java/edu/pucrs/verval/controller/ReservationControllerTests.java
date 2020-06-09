package edu.pucrs.verval.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class ReservationControllerTests {

private MockMvc mockMvc;
	
	@Before
	public void setup() {
		final ReservationController reservationController = new ReservationController();
		
		mockMvc = MockMvcBuilders.standaloneSetup(reservationController).build();
	}
	
	@Test
	public void returnAllReservationsShouldBeOk() throws Exception {
		this.mockMvc.perform(get("/api/reservations"))
			.andExpect(status().isOk());
	}
	
}
