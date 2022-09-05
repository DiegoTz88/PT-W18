package com.pizza.Order_Controller;

import java.util.List;

public interface OrderService {

	//get all customers, READ
		public List<Order> getAllOrders();
		
		//get by specific id, READ
		public Order getOrderByID(int id);
		
		//Post a customer CREATE
		public Order saveOrder(Order order);
		
		//Update a customer, UPDATE
		public Order updateOrder(Order order, int Id);
		
		//Delete a customer, DELETE
		public void deleteOrder(int Id);
}
