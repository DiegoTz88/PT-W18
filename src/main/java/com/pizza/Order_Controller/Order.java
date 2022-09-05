package com.pizza.Order_Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

@Data
@Entity
@Table(name="orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_id; //Primary key
	
	@Column(value="customer_id")
	private int customer_id;
	@Column(value="delivery_driver")
	private String delivery_driver;
	@Column(value="size")
	private String size;
	@Column(value="pizza_name")
	private String pizza_name;
	@Column(value="price")
	private float price;
	
	
	public Order() {
	}


	public Order(int customer_id, String delivery_driver, String size, String pizza_name, String pizza_desc,
			float price) {
		super();
		this.customer_id = customer_id;
		this.delivery_driver = delivery_driver;
		this.size = size;
		this.pizza_name = pizza_name;
		this.price = price;
	}


	public Order(int order_id, int customer_id, String delivery_driver, String size, String pizza_name,
			String pizza_desc, float price) {
		super();
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.delivery_driver = delivery_driver;
		this.size = size;
		this.pizza_name = pizza_name;
		this.price = price;
	}
	
	
	
}
