package edu.pucrs.verval.DTO;

import java.util.List;

public class NewReservationDTO {
	
	private Integer collaborator_id;
	
	private List<ResourcesDTO> resources;

	public Integer getCollaborator_id() {
		return collaborator_id;
	}

	public void setCollaborator_id(Integer collaborator_id) {
		this.collaborator_id = collaborator_id;
	}

	public List<ResourcesDTO> getResources() {
		return resources;
	}

	public void setResources(List<ResourcesDTO> resources) {
		this.resources = resources;
	}

}
