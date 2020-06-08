package edu.pucrs.verval.data;

public class ReservationIdGen {
	
	private Integer reservation_count;
	
	private static ReservationIdGen instance = new ReservationIdGen();
	
	public ReservationIdGen() {
		this.reservation_count = 0;
	}
	
	public Integer get() {
		reservation_count++;
		return reservation_count;
	}
	
	public static ReservationIdGen getInstance() {
		return instance;
	}

}
