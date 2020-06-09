package edu.pucrs.verval.response;

import org.joda.time.LocalDate;

import edu.pucrs.verval.entities.Resource;

public class ReservationGroupItems {

	private Resource resource;
	
	private LocalDate begin_date;
	
	private LocalDate end_date;
	
	private Integer amount;

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public LocalDate getBegin_date() {
		return begin_date;
	}

	public void setBegin_date(LocalDate begin_date) {
		this.begin_date = begin_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	
	
	
}
