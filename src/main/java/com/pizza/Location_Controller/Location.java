package com.pizza.Location_Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import com.pizza.Customer_Controller.Customer;

import lombok.Data;

@Data
@Entity
@Table(name="location")
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int location_id; //Primary key
	
	@Column(value="address")
	private String address;
}
