package edu.pucrs.verval.response;

import java.util.List;

import org.joda.time.LocalDate;

public class ReservationSuccess {
	
	private String reservation_group_id;
	
	private Integer collaborator_id;
	
	private Double total_price;
	
	private List<ReservationGroupItems> resources;
	
	private LocalDate creation_date;
	

	public String getReservation_group_id() {
		return reservation_group_id;
	}

	public void setReservation_group_id(String reservation_group_id) {
		this.reservation_group_id = reservation_group_id;
	}

	public Integer getCollaborator_id() {
		return collaborator_id;
	}

	public void setCollaborator_id(Integer collaborator_id) {
		this.collaborator_id = collaborator_id;
	}

	public Double getTotal_price() {
		return total_price;
	}

	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public List<ReservationGroupItems> getResources() {
		return resources;
	}

	public void setResources(List<ReservationGroupItems> resources) {
		this.resources = resources;
	}

	public LocalDate getCreation_date() {
		return creation_date;
	}

	public void setCreation_date(LocalDate creation_date) {
		this.creation_date = creation_date;
	}
	
}
