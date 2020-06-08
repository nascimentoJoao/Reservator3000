package edu.pucrs.verval.utils;

public class SpaceUtils {
	
	public static Double calculatePriceBasedOnSpaceAndSeats(Double space, Integer value_meter, Integer seats, Double value_seats) {
		Double finalPrice = (space * value_meter) + (seats * value_seats);
		return finalPrice;
	}
	
}
