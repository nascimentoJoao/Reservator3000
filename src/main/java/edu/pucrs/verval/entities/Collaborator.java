package edu.pucrs.verval.entities;

public class Collaborator {
	
	private Integer collaborator_id;

	private String registration;
	
	private String name;
	
	private String email;

	public Collaborator(Integer collaborator_id, String registration, String name, String email) {
		super();
		this.collaborator_id = collaborator_id;
		this.registration = registration;
		this.name = name;
		this.email = email;
	}

	public Integer getcollaborator_id() {
		return collaborator_id;
	}

	public void setcollaborator_id(Integer collaborator_id) {
		this.collaborator_id = collaborator_id;
	}

	public String getRegistration() {
		return registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
