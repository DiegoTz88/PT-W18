package com.pizza.DeliveryDriver_Controller;

import java.util.List;

import com.pizza.Customer_Controller.Customer;

public interface DeliveryDriverService {
	//CRUD METHODS
	
		//get all customers, READ
		public List<DeliveryDriver> getAllDrivers();
		
		//get by specific id, READ
		public DeliveryDriver getDriverByID(int id);
		
		//Post a customer CREATE
		public DeliveryDriver saveDriver(DeliveryDriver driver);
		
		//Update a customer, UPDATE
		public DeliveryDriver updateDriver(DeliveryDriver driver, int Id);
		
		//Delete a customer, DELETE
		public void deleteDriver(int Id);
}
