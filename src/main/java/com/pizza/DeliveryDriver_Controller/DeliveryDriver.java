package com.pizza.DeliveryDriver_Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import com.pizza.Customer_Controller.Customer;
import com.pizza.Order_Controller.Order;

import lombok.Data;

@Data
@Entity
@Table(name="delivery_driver")
public class DeliveryDriver {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int driver_id; //Primary key
	
	@Column(value="full_name")
	private String full_name;

}
