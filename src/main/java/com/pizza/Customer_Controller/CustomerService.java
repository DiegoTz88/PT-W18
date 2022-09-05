package com.pizza.Customer_Controller;

import java.util.List;

public interface CustomerService {

	//CRUD METHODS
	
	//get all customers, READ
	public List<Customer> getAllCustomers();
	
	//get by specific id, READ
	public Customer getCustomerByID(int id);
	
	//Post a customer CREATE
	public Customer saveCustomer(Customer customer);
	
	//Update a customer, UPDATE
	public Customer updateCustomer(Customer customer, int Id);
	
	//Delete a customer, DELETE
	public void deleteCustomer(int Id);
	
}
