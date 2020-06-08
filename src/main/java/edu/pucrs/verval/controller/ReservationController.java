package edu.pucrs.verval.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.joda.time.LocalDate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import edu.pucrs.verval.response.ReservationGroupItems;
import edu.pucrs.verval.response.ReservationSuccess;
import edu.pucrs.verval.utils.Utilitaries;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ReservationController {
		
	@PostMapping("/reservation")
	@ResponseBody
	public ResponseEntity reserveResourceForCollaborator(@RequestBody NewReservationDTO reservation) throws InvalidDateIntervalException{
	
		Collaborator collaborator = CollaboratorGen.getInstance().getCollaborators().get(reservation.getCollaborator_id());
		
		ReservationSuccess answer = new ReservationSuccess();
		ArrayList<ReservationGroupItems> items = new ArrayList<>();
		
		answer.setCollaborator_id(collaborator.getId());
		answer.setResources(items);
		answer.setCreation_date(new LocalDate());
		answer.setTotal_price(0.0);
		
		String generated_id = Utilitaries.generateResourceGroupId();
		
		answer.setReservation_group_id(generated_id);
		
		for(ResourcesDTO dto : reservation.getResources()) {
			
			ReservationGroupItems rgi = new ReservationGroupItems();
			rgi.setBegin_date(dto.getInitial_date());
			rgi.setEnd_date(dto.getEnd_date());
			
			Resource resource = ResourceGen.getInstance().getResources().get(dto.getResource_id());
			rgi.setResource(resource);
			
			//Check most recent reservation with the chosen initial date.
			ArrayList<ArrayList<CollaboratorCostReservation>> all_items_reservations = ReservationGen.getInstance().getItem_date().get(resource.getId());
			
			if(all_items_reservations.size() == 0) {
				
				//There is no reservations for this item.
				ArrayList<CollaboratorCostReservation> inner = new ArrayList<>();
				
				CollaboratorCostReservation info = new CollaboratorCostReservation(collaborator, dto.getInitial_date(), dto.getEnd_date());
				Double total_cost = 0.0;
				
				total_cost = Utilitaries.calculateCostForReservation(resource, dto.getAmount(), dto.getInitial_date(), dto.getEnd_date());
			
				info.setCost(total_cost);
				resource.setAvailable_amount(resource.getAvailable_amount() - 1);
				
				inner.add(info);
				
				all_items_reservations.add(inner);
			
				answer.getResources().add(rgi);
				answer.setTotal_price(answer.getTotal_price() + total_cost);
				
				ReservationGen.getInstance().getItem_date().put(dto.getResource_id(), all_items_reservations);
				
			} else {
				
				//There already is reservations for this item.
				//Starting total amount and date validations.
				ArrayList<CollaboratorCostReservation> most_recent = all_items_reservations.get(all_items_reservations.size() - 1);
				
				//Check if there is no problem with the selected date.
				if(Utilitaries.checkReservationDate(most_recent.get(most_recent.size() - 1).getEnd(), dto.getInitial_date())) {
					
					//If don't check if has available resources.
					if(Utilitaries.hasAvailableResource(resource)) {
					ArrayList<CollaboratorCostReservation> inner = new ArrayList<>();
					
					CollaboratorCostReservation info = new CollaboratorCostReservation(collaborator, dto.getInitial_date(), dto.getEnd_date());
					Double total_cost = 0.0;
					
					total_cost = Utilitaries.calculateCostForReservation(resource, dto.getAmount(), dto.getInitial_date(), dto.getEnd_date());
					
					info.setCost(total_cost);
					resource.setAvailable_amount(resource.getAvailable_amount() - 1);
					
					inner.add(info);
					
					all_items_reservations.add(inner);
					
					ReservationGen.getInstance().getItem_date().put(dto.getResource_id(), all_items_reservations);
					
					answer.getResources().add(rgi);
					answer.setTotal_price(answer.getTotal_price() + total_cost);
					} else {
						System.out.println("insuficient_amount");
					}
					
				}else {
					System.out.println("reservation_error");
				}
			}	
		}
		
		ReservationGen.getInstance().getHistory().put(generated_id, answer);
			
		return ResponseEntity.ok().body(answer);
	}
	
	@GetMapping("/reservation") 
	public ResponseEntity getAllReservations() {	
		return ResponseEntity.ok().body(ReservationGen.getInstance().getHistory());
	}
	
	@GetMapping("/reservation/from/{initial_date}/to/{end_date}")
	public ResponseEntity findAllReservationsBetweenDates(@PathVariable("initial_date") String initial_date, @PathVariable("end_date") String end_date) {
		//TODO - Check date
		
		
		return ResponseEntity.ok().body("todo_route");
	}


}
