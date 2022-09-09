package com.pizza.Order_Controller;

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
import com.pizza.DeliveryDriver_Controller.DeliveryDriver;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id; //Primary key
	
	

	@Column(value="size")
	private String size;
	@Column(value="pizza_name")
	private String pizza_name;
	@Column(value="price")
	private float price;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="driver_id")
	private DeliveryDriver delivery_driver;
	
	
	public Order() {
	}


	public Order(int customer_id, String delivery_driver, String size, String pizza_name, String pizza_desc,
			float price) {
		super();

		this.size = size;
		this.pizza_name = pizza_name;
		this.price = price;
	}


	public Order(int order_id, int customer_id, String delivery_driver, String size, String pizza_name,
			String pizza_desc, float price) {
		super();
		this.order_id = order_id;
		this.size = size;
		this.pizza_name = pizza_name;
		this.price = price;
	}
	
	
	
}
