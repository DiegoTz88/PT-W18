package com.pizza.Order_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.exception.ResourceNotFoundException;

@Service
public class OrderServiceImp implements OrderService {

	private OrderRepository orderRepository;
	
	@Autowired
	public OrderServiceImp(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public Order getOrderByID(int id) {
		return orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", id));
	}

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order updateOrder(Order order, int Id) {
		Order existingOrder = orderRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", Id));
		
		existingOrder.setPizza_name(order.getPizza_name());
		existingOrder.setSize(order.getSize());
		existingOrder.setPrice(order.getPrice());
		
		return existingOrder;
	}

	@Override
	public void deleteOrder(int Id) {
		Order existingOrder = orderRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Order", "id", Id));
		orderRepository.deleteById(Id);
	}

}
