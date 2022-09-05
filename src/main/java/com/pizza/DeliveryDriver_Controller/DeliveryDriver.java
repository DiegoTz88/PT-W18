package com.pizza.DeliveryDriver_Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
@Entity
@Table(name="delivery_driver")
public class DeliveryDriver {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driver_id; //Primary key
	
	@Column(value="order_id")
	private String order_id;
	@Column(value="full_name")
	private String name;

}
