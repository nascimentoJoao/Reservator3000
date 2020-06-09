package edu.pucrs.verval.data;

import java.util.HashMap;

import edu.pucrs.verval.entities.Resource;

public class ResourceGen {
		
	private HashMap<Integer, Resource> resources;
	private HashMap<Integer, Double> resource_cost;
	private HashMap<Integer, Double> resource_meter;
	private HashMap<Integer, Double> resource_seat;
	private Double global_meter_price;
	private Double global_seat_price;
	
	public static final ResourceGen instance = new ResourceGen();
	
	public ResourceGen() {
		this.resources = new HashMap<>();
		this.resource_cost = new HashMap<>();
		this.resource_meter = new HashMap<>();
		this.resource_seat = new HashMap<>();
		
		this.global_meter_price = 30.0;
		this.global_seat_price = 10.0;
				
		//Generate physical spaces (rooms)
		this.resources.put(1, new Resource(1, "Room 506", "R649-506", 1, global_meter_price, "ROOM", 40.0, 40, global_seat_price));
		this.resources.put(2, new Resource(2, "Room 301", "R649-301", 1, global_meter_price, "ROOM", 36.0, 20, global_seat_price));
		this.resources.put(3, new Resource(3, "Room 408", "R649-408", 1, global_meter_price, "ROOM", 28.0, 10, global_seat_price));
		this.resources.put(4, new Resource(4, "Room 700", "R649-700", 1, global_meter_price, "ROOM", 16.0, 10, global_seat_price));
		this.resources.put(5, new Resource(5, "Room 603", "R649-603", 1, global_meter_price, "ROOM", 32.0, 20, global_seat_price));
		this.resources.put(6, new Resource(6, "Room 202", "R649-202", 1, global_meter_price, "ROOM", 18.0, 10, global_seat_price));
		
		//Generate physical spaces (auditoriums)
		this.resources.put(7,  new Resource(7,  "Auditorium I",   "A441-506", 1, global_meter_price, "ROOM", 80.0, 60, global_seat_price));
		this.resources.put(8,  new Resource(8,  "Auditorium II",  "A441-203", 1, global_meter_price, "ROOM", 75.0, 40, global_seat_price));
		this.resources.put(9,  new Resource(9,  "Auditorium III", "A441-882", 1, global_meter_price, "ROOM", 49.0, 50, global_seat_price));
		this.resources.put(10, new Resource(10, "Auditorium IV",  "A441-405", 1, global_meter_price, "ROOM", 50.0, 60, global_seat_price));
		this.resources.put(11, new Resource(11, "Auditorium V",   "A441-240", 1, global_meter_price, "ROOM", 60.0, 80, global_seat_price));

		
		//Generate mobile resources (notebooks, smartphones, tablets)
		this.resources.put(12, new Resource(12, "Smartphone Samsung 8GB",         "M520-4FK", 5, 300.0,  "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(13, new Resource(13, "Tablet Acer Octa-Core",          "M539-41P", 5, 300.0,  "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(14, new Resource(14, "Smartphone iPhone X 128GB",      "M543-4HP", 5, 900.0,  "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(15, new Resource(15, "Smartphone Moto G8 Plus 32GB",   "M510-4Y6", 5, 250.0,  "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(16, new Resource(16, "USB Hub 4 Ports",                "M500-41P", 5,  20.0,  "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(17, new Resource(17, "Acces Point 100MBPS",            "M501-41P", 5, 200.0,  "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(18, new Resource(18, "Macbook Air 128GB 1TB SSD",      "M504-41P", 5, 2000.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(19, new Resource(19, "Notebook Samsung 64GB 500GB HD", "M509-41P", 5, 800.0,  "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		
		//Generate furniture resources (tables, chairs, desks)
		this.resources.put(20, new Resource(20, "Wooden Chair Kit x4",                        "F281-41P", 5, 100.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(21, new Resource(21, "Wooden Table with Golden Details",           "M520-41P", 5, 150.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(22, new Resource(22, "Steel Chair Kit x4",                         "M520-41P", 5, 500.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(23, new Resource(23, "Steel Table",                                "M520-41P", 5, 200.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(24, new Resource(24, "Glass Table With Platinum Decoration",       "M520-41P", 5, 800.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(25, new Resource(25, "Gigantic Lamp With Purple Details",          "M520-41P", 5, 300.0, "FURNITURE", 0.0, 0, 0.0));
		
		for(int i = 1; i <= 25; i++) {
			this.resource_cost.put(i, 0.0);
			this.resource_meter.put(i, 0.0);
			this.resource_seat.put(i, 0.0);
		}
		
		for(int i = 1; i <= 25; i++) {
			this.resource_meter.put(i, this.resources.get(i).getPrice());
			this.resource_seat.put(i, this.resources.get(i).getPrice_per_seat());
		}
	}

	public static ResourceGen getInstance() {
		return instance;
	}
	
	public HashMap<Integer, Resource> getResources() {
		return this.resources;
	}
	
	public HashMap<Integer, Double> getResourcesCost() {
		return this.resource_cost;
	}

	public Double getGlobal_meter_price() {
		return global_meter_price;
	}

	public void setGlobal_meter_price(Double global_meter_price) {
		this.global_meter_price = global_meter_price;
	}

	public Double getGlobal_seat_price() {
		return global_seat_price;
	}

	public void setGlobal_seat_price(Double global_seat_price) {
		this.global_seat_price = global_seat_price;
	}
	
	
}
