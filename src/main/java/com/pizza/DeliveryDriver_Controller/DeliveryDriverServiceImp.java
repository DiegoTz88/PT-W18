package com.pizza.DeliveryDriver_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.exception.ResourceNotFoundException;

@Service
public class DeliveryDriverServiceImp implements DeliveryDriverService{
	private DeliveryDriverRepository deliveryDriverRepository;

	@Autowired
	public DeliveryDriverServiceImp(DeliveryDriverRepository driverRepository) {
		this.deliveryDriverRepository = driverRepository;
	}
	
	@Override
	public List<DeliveryDriver> getAllDrivers() {
		// TODO Auto-generated method stub
		return deliveryDriverRepository.findAll();
	}

	@Override
	public DeliveryDriver getDriverByID(int id) {
		return deliveryDriverRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Driver", "id", id));
	}

	@Override
	public DeliveryDriver saveDriver(DeliveryDriver driver) {
		return deliveryDriverRepository.save(driver);
	}

	@Override
	public DeliveryDriver updateDriver(DeliveryDriver driver, int Id) {
		DeliveryDriver existingDriver = deliveryDriverRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Driver", "id", Id));

		existingDriver.setFull_name(driver.getFull_name());

		
		return existingDriver;
	}

	@Override
	public void deleteDriver(int Id) {
		DeliveryDriver existingDriver = deliveryDriverRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Driver", "id", Id));
		deliveryDriverRepository.deleteById(Id);
	}
}
