package edu.pucrs.verval.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pucrs.verval.data.CollaboratorGen;
import edu.pucrs.verval.data.ResourceGen;
import edu.pucrs.verval.entities.Collaborator;
import edu.pucrs.verval.entities.Resource;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class CollaboratorController {
	
	@GetMapping("/collaborators")
	public ResponseEntity<ArrayList<Collaborator>> returnAllCollaborators() {
		
		ArrayList<Collaborator> collaborators = new ArrayList<>();
		
		 Iterator it = CollaboratorGen.getInstance().getCollaborators().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        Collaborator res = (Collaborator) pair.getValue();	        
		        collaborators.add(res);
		    }
		
		return ResponseEntity.ok().body(collaborators);
	}
	
	@GetMapping("/collaborators/{collaborator_id}")
	public ResponseEntity returnCollaboratorById(@PathVariable("collaborator_id")String collaborator_id) {
		try {
			Integer collaborator_id_parse = Integer.parseInt(collaborator_id);
			return ResponseEntity.ok().body(CollaboratorGen.getInstance().getCollaborators().get(collaborator_id_parse));
			
		} catch (NumberFormatException exception) {
			return ResponseEntity.badRequest().body(400);
		}
		
	}
	

}
