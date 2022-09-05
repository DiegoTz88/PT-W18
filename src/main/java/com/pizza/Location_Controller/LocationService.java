package com.pizza.Location_Controller;

import java.util.List;

public interface LocationService {

	//CRUD METHODS
	
		//get all customers, READ
		public List<Location> getAllLocations();
		
		//get by specific id, READ
		public Location getLocationByID(int id);
		
		//Post a customer CREATE
		public Location saveLocation(Location location);
		
		//Update a customer, UPDATE
		public Location updateLocation(Location location, int Id);
		
		//Delete a customer, DELETE
		public void deleteLocation(int Id);
}
