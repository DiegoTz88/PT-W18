package com.pizza.DeliveryDriver_Controller;

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
@RequestMapping("pizza/delivery_driver")
public class DeliveryDriverController {

	private DeliveryDriverService deliveryDriverService;
	
	@Autowired
	public DeliveryDriverController(DeliveryDriverService deliveryDriverService) {
		this.deliveryDriverService = deliveryDriverService;
	}
	
	@GetMapping
	public List<DeliveryDriver> getAllDrivers(){
		return deliveryDriverService.getAllDrivers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<DeliveryDriver> getDriverById(@PathVariable("id") int driverId){
		return new ResponseEntity<DeliveryDriver>(deliveryDriverService.getDriverByID(driverId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DeliveryDriver> saveDriver(@RequestBody DeliveryDriver deliveryDriver){
		return new ResponseEntity<DeliveryDriver>(deliveryDriverService.saveDriver(deliveryDriver), HttpStatus.CREATED);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<DeliveryDriver> updateDriver(@PathVariable("id") int driverId, @RequestBody DeliveryDriver deliveryDriver){
		return new ResponseEntity<DeliveryDriver>(deliveryDriverService.updateDriver(deliveryDriver, driverId), HttpStatus.OK);
	}
	
	@DeleteMapping("{driver_id}")
	public ResponseEntity<String> deleteDriver(@PathVariable("id") int driverId){
		deliveryDriverService.deleteDriver(driverId);
		return new ResponseEntity<String>("Delivery Driver Deleted", HttpStatus.OK);
	}
}
