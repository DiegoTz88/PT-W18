package com.pizza.Customer_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.exception.ResourceNotFoundException;

@Service
public class CustomerServiceImp implements CustomerService{
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerServiceImp(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	//get all generic
	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	//get by specific id
	@Override
	public Customer getCustomerByID(int id) {
		return customerRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
	}

	//posting a player
	@Override
	public Customer saveCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	
	@Override
	public Customer updateCustomer(Customer customer, int Id) {
		Customer existingCustomer = customerRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", Id));
		
		existingCustomer.setFirst_name(customer.getFirst_name());
		existingCustomer.setLast_name(customer.getLast_name());
		existingCustomer.setLocation(customer.getLocation());
		existingCustomer.setPhone_number(customer.getPhone_number());
		
		return existingCustomer;
	}

	@Override
	public void deleteCustomer(int Id) {
		Customer existingCustomer = customerRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Customer", "id", Id));
		customerRepository.deleteById(Id);
	}



}
