package com.pizza.Location_Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pizza.Customer_Controller.Customer;



@RestController
@RequestMapping("pizza/location")
public class LocationController {
	
	private LocationService locationService;
	
	public LocationController(LocationService locationService) {
		this.locationService = locationService;
	}
	
	@GetMapping
	public List<Location> getAllLocations(){
		return locationService.getAllLocations();
	}
	
	@GetMapping("{customer_id}")
	public ResponseEntity<Location> getLocationById(@PathVariable("customer_id") int locationId){
		return new ResponseEntity<Location>(locationService.getLocationByID(locationId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Location> saveLocation(@RequestBody Location location){
		return new ResponseEntity<Location>(locationService.saveLocation(location), HttpStatus.CREATED);
	}
	
//	@PutMapping("{customer_id}")
//	public ResponseEntity<Location> updateLocation(@PathVariable("customer_id") int locationId, @RequestBody Location location){
//		return new ResponseEntity<Location>(locationService.updateLocation(location, locationId), HttpStatus.OK);
//	}
//	
//	@DeleteMapping("{customer_id}")
//	public ResponseEntity<String> deleteLocation(@PathVariable("customer_id") int locationId){
//		locationService.deleteLocation(locationId);
//		return new ResponseEntity<String>("Location Deleted", HttpStatus.OK);
//	}
}
