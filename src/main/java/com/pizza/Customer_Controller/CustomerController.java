package com.pizza.Customer_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


@RestController
@RequestMapping("pizza/customer")
public class CustomerController {

	private CustomerService customerService;
	
	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}
	
	@GetMapping
	public List<Customer> getAllCustomers(){
		return customerService.getAllCustomers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int customerId){
		return new ResponseEntity<Customer>(customerService.getCustomerByID(customerId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable("id") int customerId, @RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, customerId), HttpStatus.OK);
	}
	
	@DeleteMapping("{customer_id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("id") int customerId){
		customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>("Customer Deleted", HttpStatus.OK);
	}
	
}
