package edu.pucrs.verval.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.joda.time.LocalDate;

public class Reservation {

	private Integer id;
	
	private Integer collaboratorId;
	
	private List<Resource> resources;
	
	private Double total_cost;
	
	public Reservation(Integer id, Integer collaboratorId) {
		super();
		this.id = id;
		this.collaboratorId = collaboratorId;
		this.resources = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCollaboratorId() {
		return collaboratorId;
	}

	public void setCollaboratorId(Integer collaboratorId) {
		this.collaboratorId = collaboratorId;
	}
	
	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	public Double getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(Double total_cost) {
		this.total_cost = total_cost;
	}
}
