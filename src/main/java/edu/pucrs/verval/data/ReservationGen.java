package edu.pucrs.verval.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import edu.pucrs.verval.entities.CollaboratorCostReservation;
import edu.pucrs.verval.entities.Reservation;
import edu.pucrs.verval.entities.Resource;
import edu.pucrs.verval.response.ReservationSuccess;

public class ReservationGen {

	private List<Reservation> reservations;
	
	private HashMap<Integer, ArrayList<ArrayList<CollaboratorCostReservation>>> item_date;
	
	private HashMap<String, ReservationSuccess> history;
	
	private static ReservationGen instance = new ReservationGen();
	
	public ReservationGen() {
		this.reservations = new ArrayList<>();
		this.item_date = new HashMap<>();
		this.history = new HashMap<>();
		
		Iterator it = ResourceGen.getInstance().getResources().entrySet().iterator();
		
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			ArrayList<CollaboratorCostReservation> in = new ArrayList<>();
			ArrayList<ArrayList<CollaboratorCostReservation>> inner = new ArrayList<>();
			this.item_date.put((Integer)pair.getKey(), inner);
		}
		
	}
	
	public static ReservationGen getInstance() {
		return instance;
	}
	
	public List<Reservation> getReservations() {
		return this.reservations;
	}

	public HashMap<Integer, ArrayList<ArrayList<CollaboratorCostReservation>>> getItem_date() {
		return item_date;
	}
	
	public HashMap<String, ReservationSuccess> getHistory() {
		return this.history;
	}

}
