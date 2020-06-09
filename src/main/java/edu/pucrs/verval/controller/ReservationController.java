package edu.pucrs.verval.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.joda.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.pucrs.verval.DTO.NewReservationDTO;
import edu.pucrs.verval.DTO.ResourcesDTO;
import edu.pucrs.verval.data.CollaboratorGen;
import edu.pucrs.verval.data.ReservationGen;
import edu.pucrs.verval.data.ResourceGen;
import edu.pucrs.verval.entities.Collaborator;
import edu.pucrs.verval.entities.CollaboratorCostReservation;
import edu.pucrs.verval.entities.Resource;
import edu.pucrs.verval.exception.InvalidDateIntervalException;
import edu.pucrs.verval.response.AdminConfig;
import edu.pucrs.verval.response.ReservationGroupItems;
import edu.pucrs.verval.response.ReservationSuccess;
import edu.pucrs.verval.utils.Utilitaries;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReservationController {
		
	@PostMapping("/reservations")
	@ResponseBody
	public ResponseEntity reserveResourceForCollaborator(@RequestBody NewReservationDTO reservation) throws InvalidDateIntervalException{
	
		Collaborator collaborator = CollaboratorGen.getInstance().getCollaborators().get(reservation.getCollaborator_id());
		
		ReservationSuccess answer = new ReservationSuccess();
		ArrayList<ReservationGroupItems> items = new ArrayList<>();
		
		answer.setCollaborator_id(collaborator.getcollaborator_id());
		answer.setResources(items);
		answer.setCreation_date(new LocalDate());
		answer.setTotal_price(0.0);
		
		String generated_id = Utilitaries.generateResourceGroupId();
		
		answer.setReservation_group_id(generated_id);
		
		for(ResourcesDTO dto : reservation.getResources()) {
			
			ReservationGroupItems rgi = new ReservationGroupItems();
			rgi.setBegin_date(dto.getBegin_date());
			rgi.setEnd_date(dto.getEnd_date());
			
			answer.setAmount(dto.getAmount());
			
			Resource resource = ResourceGen.getInstance().getResources().get(dto.getResource_id());
			rgi.setResource(resource);
			
			//Check most recent reservation with the chosen initial date.
			ArrayList<ArrayList<CollaboratorCostReservation>> all_items_reservations = ReservationGen.getInstance().getItem_date().get(resource.getId());
			
			if(all_items_reservations.size() == 0) {
				
				//There is no reservations for this item.
				ArrayList<CollaboratorCostReservation> inner = new ArrayList<>();
				
				CollaboratorCostReservation info = new CollaboratorCostReservation(collaborator, dto.getBegin_date(), dto.getEnd_date());
				Double total_cost = 0.0;
				
				total_cost = Utilitaries.calculateCostForReservation(resource, dto.getAmount(), dto.getBegin_date(), dto.getEnd_date());
			
				info.setCost(total_cost);
				resource.setAvailable_amount(resource.getAvailable_amount() - 1);
				
				inner.add(info);
				
				all_items_reservations.add(inner);
			
				answer.getResources().add(rgi);
				answer.setTotal_price(answer.getTotal_price() + total_cost);
				
				CollaboratorGen.getInstance().getCollaboratorCost().put(answer.getCollaborator_id(), 
						CollaboratorGen.getInstance().getCollaboratorCost().get(answer.getCollaborator_id()) +
						answer.getTotal_price());
				
				ReservationGen.getInstance().getItem_date().put(dto.getResource_id(), all_items_reservations);
				ResourceGen.getInstance().getResourcesCost().put(dto.getResource_id(), 
						ResourceGen.getInstance().getResourcesCost().get(dto.getResource_id()) + total_cost
						);
				
			} else {
				
				//There already is reservations for this item.
				//Starting total amount and date validations.
				ArrayList<CollaboratorCostReservation> most_recent = all_items_reservations.get(all_items_reservations.size() - 1);
				
				//Check if there is no problem with the selected date.
				if(Utilitaries.checkReservationDate(most_recent.get(most_recent.size() - 1).getEnd(), dto.getBegin_date())) {
					
					//If don't check if has available resources.
					if(Utilitaries.hasAvailableResource(resource) || dto.getAmount() > resource.getAvailable_amount()) {
					ArrayList<CollaboratorCostReservation> inner = new ArrayList<>();
					
					CollaboratorCostReservation info = new CollaboratorCostReservation(collaborator, dto.getBegin_date(), dto.getEnd_date());
					Double total_cost = 0.0;
					
					total_cost = Utilitaries.calculateCostForReservation(resource, dto.getAmount(), dto.getBegin_date(), dto.getEnd_date());
					
					info.setCost(total_cost);
					resource.setAvailable_amount(resource.getAvailable_amount() - 1);
					
					inner.add(info);
					
					all_items_reservations.add(inner);
					
					ReservationGen.getInstance().getItem_date().put(dto.getResource_id(), all_items_reservations);
					
					ResourceGen.getInstance().getResourcesCost().put(dto.getResource_id(), 
							ResourceGen.getInstance().getResourcesCost().get(dto.getResource_id()) + total_cost
							);
					
					answer.getResources().add(rgi);
					answer.setTotal_price(answer.getTotal_price() + total_cost);
					
					CollaboratorGen.getInstance().getCollaboratorCost().put(answer.getCollaborator_id(), 
							CollaboratorGen.getInstance().getCollaboratorCost().get(answer.getCollaborator_id()) +
							answer.getTotal_price());
					
					} else {
						System.out.println("insuficient_amount");
						return ResponseEntity.ok().body("insuficient_amount");
					}
					
				}else {
					System.out.println("reservation_error");
					return ResponseEntity.ok().body("reservation_error");
				}
			}	
		}
		
		ReservationGen.getInstance().getHistory().put(generated_id, answer);
			
		return ResponseEntity.ok().body(answer);
	}
	
	@GetMapping("/reservations") 
	public ResponseEntity getAllReservations() {	
		
		ArrayList<ReservationSuccess> all_reservations = new ArrayList<>();
		
		Iterator it = ReservationGen.getInstance().getHistory().entrySet().iterator();
	    while (it.hasNext()) {
	        Map.Entry pair = (Map.Entry)it.next();
	        ReservationSuccess res = (ReservationSuccess) pair.getValue();	        
	        all_reservations.add(res);
	    }
		
		return ResponseEntity.ok().body(all_reservations);
	}
	
	@GetMapping("/reservations?start={initial_date}&end={end_date}")
	public ResponseEntity findAllReservationsBetweenDates(@PathVariable("initial_date") String initial_date, @PathVariable("end_date") String end_date) {
		//TODO - Check date
		return ResponseEntity.ok().body("todo_route");
	}
	
	@DeleteMapping("/reservations/delete/{group_id}")
	public ResponseEntity deleteReservationId(@PathVariable("group_id") String group_id ) {
		
		ReservationGen.getInstance().getHistory().remove(group_id);
		
		return ResponseEntity.ok().body("deleted_"+group_id);
	}

}
