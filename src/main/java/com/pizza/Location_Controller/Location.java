package com.pizza.Location_Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
@Entity
@Table(name="location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int customer_id; //Primary key
	
	@Column(value="address")
	private String address;
}
