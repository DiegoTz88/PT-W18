package com.pizza.Customer_Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
@Entity
@Table(name="customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customer_id; //Primary key
	
	@Column(value="first_name")
	private String first_name;
	@Column(value="last_name")
	private String last_name;
	@Column(value="phone_number")
	private String phone_number;
	@Column(value="location")
	private String location;
	
	//default constructor
	public Customer() {
	}

	//constructor that accepts everything, but the primary key
	public Customer(String first_name, String last_name, String phone_number, String location) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.location = location;
	}

	//constructor that accepts everything
	public Customer(int customer_id, String first_name, String last_name, String phone_number, String location) {
		super();
		this.customer_id = customer_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_number = phone_number;
		this.location = location;
	}
	
	
	
	
}
