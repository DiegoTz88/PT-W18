package com.pizza.Order_Controller;

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
@RequestMapping("pizza/orders")
public class OrderController {

	private OrderService orderService;
	
	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@GetMapping
	public List<Order> getAllOrders(){
		return orderService.getAllOrders();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Order> getOrderById(@PathVariable ("id") int orderId){
		return new ResponseEntity<Order>(orderService.getOrderByID(orderId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Order> saveOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.saveOrder(order), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable("id") int orderId, @RequestBody Order order){
		return new ResponseEntity<Order>(orderService.updateOrder(order, orderId), HttpStatus.OK);
	}	
	
	@DeleteMapping("{order_id}")
	public ResponseEntity<String> deleteOrder(@PathVariable("id") int orderId){
		orderService.deleteOrder(orderId);
		return new ResponseEntity<String>("Order Deleted", HttpStatus.OK);
	}
}
