package edu.pucrs.verval.entities;

import org.joda.time.LocalDate;

public class CollaboratorCostReservation {
	
	private Collaborator collab;
	
	private LocalDate init;
	
	private LocalDate end;
	
	private Double cost;
	
	public CollaboratorCostReservation(Collaborator collab, LocalDate i, LocalDate e) {
		this.collab = collab;
		this.init = i;
		this.end = e;
	}

	public LocalDate getInit() {
		return init;
	}

	public void setInit(LocalDate init) {
		this.init = init;
	}

	public LocalDate getEnd() {
		return end;
	}

	public void setEnd(LocalDate end) {
		this.end = end;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Collaborator getCollab() {
		return collab;
	}

	public void setCollab(Collaborator collab) {
		this.collab = collab;
	}
}
