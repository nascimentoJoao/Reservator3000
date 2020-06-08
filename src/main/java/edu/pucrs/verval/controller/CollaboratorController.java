package edu.pucrs.verval.controller;

import java.util.HashMap;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pucrs.verval.data.CollaboratorGen;
import edu.pucrs.verval.entities.Collaborator;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CollaboratorController {
	
	@GetMapping("/collaborator")
	public ResponseEntity<HashMap<Integer, Collaborator>> returnAllCollaborators() {
		return ResponseEntity.ok().body(CollaboratorGen.getInstance().getCollaborators());
	}
	
	@GetMapping("/collaborator/{collaborator_id}")
	public ResponseEntity returnCollaboratorById(@PathVariable("collaborator_id")String collaborator_id) {
		
		try {
			Integer collaborator_id_parse = Integer.parseInt(collaborator_id);
			return ResponseEntity.ok().body(CollaboratorGen.getInstance().getCollaborators().get(collaborator_id_parse));
			
		} catch (NumberFormatException exception) {
			return ResponseEntity.badRequest().body(400);
		}
		
	}
	

}
