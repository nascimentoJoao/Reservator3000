package edu.pucrs.verval.data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.pucrs.verval.entities.Resource;

public class ResourceGen {
		
	private HashMap<Integer, Resource> resources;
	private HashMap<Integer, Double> resource_cost;
	
	public static final ResourceGen instance = new ResourceGen();
	
	public ResourceGen() {
		this.resources = new HashMap<>();
		this.resource_cost = new HashMap<>();
				
		//Generate physical spaces (rooms)
		this.resources.put(1, new Resource(1, "Room 506", "R649-506", 1, 30.0, "ROOM", 40.0, 40, 10.0));
		this.resources.put(2, new Resource(2, "Room 301", "R649-301", 1, 25.0, "ROOM", 36.0, 20, 10.0));
		this.resources.put(3, new Resource(3, "Room 408", "R649-408", 1, 20.0, "ROOM", 28.0, 10, 10.0));
		this.resources.put(4, new Resource(4, "Room 700", "R649-700", 1, 28.0, "ROOM", 16.0, 10, 10.0));
		this.resources.put(5, new Resource(5, "Room 603", "R649-603", 1, 17.0, "ROOM", 32.0, 20, 10.0));
		this.resources.put(6, new Resource(6, "Room 202", "R649-202", 1, 10.0, "ROOM", 18.0, 10, 10.0));
		
		//Generate physical spaces (auditoriums)
		this.resources.put(7,  new Resource(7,  "Auditorium I",   "A441-506", 1, 45.0, "ROOM", 80.0, 60, 15.0));
		this.resources.put(8,  new Resource(8,  "Auditorium II",  "A441-203", 1, 39.0, "ROOM", 75.0, 40, 15.0));
		this.resources.put(9, new Resource(9,  "Auditorium III", "A441-882", 1, 39.0, "ROOM", 49.0, 50, 15.0));
		this.resources.put(10, new Resource(10, "Auditorium IV",  "A441-405", 1, 28.0, "ROOM", 50.0, 60, 15.0));
		this.resources.put(11, new Resource(11, "Auditorium V",   "A441-240", 1, 40.0, "ROOM", 60.0, 80, 15.0));

		
		//Generate mobile resources (notebooks, smartphones, tablets)
		this.resources.put(12, new Resource(12, "Smartphone Samsung 8GB", "M520-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(13, new Resource(13, "Tablet Acer Octa-Core",  "M539-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(14, new Resource(14, "Smartphone Samsung 8GB", "M520-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(15, new Resource(15, "Smartphone Samsung 8GB", "M520-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(16, new Resource(16, "Smartphone Samsung 8GB", "M520-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(17, new Resource(17, "Smartphone Samsung 8GB", "M520-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(18, new Resource(18, "Smartphone Samsung 8GB", "M520-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		this.resources.put(29, new Resource(19, "Smartphone Samsung 8GB", "M520-41P", 5, 300.0, "MOBILE_EQUIPMENT", 0.0, 0, 0.0));
		
		//Generate furniture resources (tables, chairs, desks)
		this.resources.put(20, new Resource(20, "Wooden Chair Kit x4",                        "F281-41P", 5, 300.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(21, new Resource(21, "Wooden Table with Golden Details",           "M520-41P", 5, 300.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(22, new Resource(22, "Steel Chair Kit x4",                         "M520-41P", 5, 300.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(23, new Resource(23, "Steel Table",                                "M520-41P", 5, 300.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(24, new Resource(24, "Glass Table With Platinum Decoration",       "M520-41P", 5, 300.0, "FURNITURE", 0.0, 0, 0.0));
		this.resources.put(25, new Resource(25, "Gigantic Lamp With Purple Details",          "M520-41P", 5, 300.0, "FURNITURE", 0.0, 0, 0.0));
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
}
