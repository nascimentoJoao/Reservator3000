package edu.pucrs.verval.utils;

import static org.junit.Assert.assertEquals;

import org.joda.time.LocalDate;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.pucrs.verval.entities.Resource;
import edu.pucrs.verval.exception.InvalidDateIntervalException;

@SpringBootTest
public class UtilitariesTests {
	
	@Test
	public void checkIfHasAvailableResourceWithNullObjectShouldThrowNullPointerException() {
		
		try {
			Resource mock_resource = null;
			Boolean result = Utilitaries.hasAvailableResource(mock_resource);
			assertEquals(result, false);
		} catch (NullPointerException exception) {
			assertEquals(exception.getClass(), NullPointerException.class);
		}
		
	}
	
	@Test
	public void checkIfHasAvailableResourceWithZeroAmountShouldReturnFalse() {
		Resource mock_resource = new Resource(1, "iPhone X 64GB", "ABC-123", 0, 300.0, "MOBILE", 0.0, 0, 0.0);
		Boolean result = Utilitaries.hasAvailableResource(mock_resource);
		assertEquals(result, false);
	}
	
	@Test
	public void checkIfHasAvailableResourceWithNegativeAmountShouldReturnFalse() {
		Resource mock_resource = new Resource(1, "iPhone X 64GB", "ABC-123", -1, 300.0, "MOBILE", 0.0, 0, 0.0);
		Boolean result = Utilitaries.hasAvailableResource(mock_resource);
		assertEquals(result, false);
	}
	
	@Test
	public void calculatingCostForAResourceReservationShouldReturnCorrectValue() {
		Resource mock_resource = new Resource(1, "iPhone X 64GB", "ABC-123", 1, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0);
		LocalDate initial_date = new LocalDate("2020-12-20");
		LocalDate end_date = new LocalDate("2020-12-24");
		Integer quantity = 1;
		
		Double total_cost = 0.0;
		
		try {
			total_cost = Utilitaries.calculateCostForReservation(mock_resource, quantity, initial_date, end_date);
		} catch(InvalidDateIntervalException exception) {
			System.out.println("Exception: " + exception.getMessage());
		}
		
		// Value should be (price * difference between days).
		// 4 days * 300.0 = 1.200
		
		// Since the method returns a Double (not a primitive type) this is a workaround to validate the method answer.
		assertEquals((total_cost == 1200.00), true);	
	}
	
	@Test
	public void calculatingCostForAResourceReservationEndDateBiggerThanInitialDateShouldThrowException() {
		Resource mock_resource = new Resource(1, "iPhone X 64GB", "ABC-123", 1, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0);
		LocalDate initial_date = new LocalDate("2020-12-20");
		LocalDate end_date = new LocalDate("2020-12-24");
		Integer quantity = 1;
		
		try {
			Utilitaries.calculateCostForReservation(mock_resource, quantity, end_date, initial_date);
		} catch (InvalidDateIntervalException exception) {
			assertEquals(exception.getClass(), InvalidDateIntervalException.class);
		}
	}
	
	

}
