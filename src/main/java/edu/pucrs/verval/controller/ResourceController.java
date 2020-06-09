package edu.pucrs.verval.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pucrs.verval.data.ResourceGen;
import edu.pucrs.verval.entities.Resource;
import edu.pucrs.verval.response.ResourceTotalCost;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ResourceController {
	
	@GetMapping("/resources")
	public ResponseEntity<Iterable<Resource>> findAllResources() {
		List<Resource> resource_by_type = new ArrayList<>();
		
		 Iterator it = ResourceGen.getInstance().getResources().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        Resource res = (Resource) pair.getValue();	        
		        	resource_by_type.add(res);
		    }
		
		    
		return ResponseEntity.ok().body(resource_by_type);
	}
	
	@GetMapping("/resources/{type_of}")
	public ResponseEntity<Iterable<Resource>> findAllResourcesByType(@PathVariable("type_of") String type_of) {
		type_of = type_of.toLowerCase();
		List<Resource> resource_by_type = new ArrayList<>();
		
		 Iterator it = ResourceGen.getInstance().getResources().entrySet().iterator();
		    while (it.hasNext()) {
		        Map.Entry pair = (Map.Entry)it.next();
		        Resource res = (Resource) pair.getValue();	        
		        if(type_of.equals(res.getType().toLowerCase())) {
		        	resource_by_type.add(res);
		        }
		    }
		
		return ResponseEntity.ok().body(resource_by_type);
	}
	
	@GetMapping("/resources/{resource_id}/cost")
	public ResponseEntity<ResourceTotalCost> calculateCostByResourceId(@PathVariable("resource_id") String resource_id) {
		
		ResourceTotalCost rtc = new ResourceTotalCost();
		rtc.setTotal_cost(ResourceGen.getInstance().getResourcesCost().get(Integer.valueOf(resource_id)));
		rtc.setResource(ResourceGen.getInstance().getResources().get(Integer.valueOf(resource_id)));
		
		return ResponseEntity.ok().body(rtc);
	}

}
