package edu.pucrs.verval.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.pucrs.verval.data.ResourceGen;
import edu.pucrs.verval.entities.Resource;
import edu.pucrs.verval.response.AdminConfig;
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
	
	@GetMapping("/resources/cost")
	public ResponseEntity<ArrayList<ResourceTotalCost>> calculateCostByResourceId() {
		
		ArrayList<ResourceTotalCost> response = new ArrayList<ResourceTotalCost>();
		
		Iterator it = ResourceGen.getInstance().getResources().entrySet().iterator();
		
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        
	        ResourceTotalCost rtc = new ResourceTotalCost();
	        
	        Resource res = (Resource) pair.getValue();
	        
			rtc.setTotal_cost(ResourceGen.getInstance().getResourcesCost().get(pair.getKey()));
			rtc.setResource(ResourceGen.getInstance().getResources().get(pair.getKey()));
	        
	        response.add(rtc);
	    }

		return ResponseEntity.ok().body(response);
	}
	
	@GetMapping("/admin")
	public ResponseEntity showPriceSeatAndMeter() {
		
	    AdminConfig configuration = new AdminConfig();
	    configuration.setMeter_price(ResourceGen.getInstance().getGlobal_meter_price());
	    configuration.setSeat_price(ResourceGen.getInstance().getGlobal_seat_price());
	    
	    return ResponseEntity.ok().body(configuration);
		
	}
	
	@PostMapping("/admin")
	public ResponseEntity changePriceSeatAndMeter(@RequestBody AdminConfig config) {
		
		ResourceGen.getInstance().setGlobal_meter_price(config.getMeter_price());
		ResourceGen.getInstance().setGlobal_seat_price(config.getSeat_price());
		
		Iterator it = ResourceGen.getInstance().getResources().entrySet().iterator();
		
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	       
	        Resource res = (Resource) pair.getValue();
	        
	        if(res.getType().equals("ROOM")) {
	        	res.setPrice_per_seat(config.getSeat_price());
	        	res.setPrice(config.getMeter_price());
	        }
	        
	    }
	    
	    return ResponseEntity.ok().body(true);
		
	}

}
