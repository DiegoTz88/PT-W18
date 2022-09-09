package com.pizza.Location_Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pizza.exception.ResourceNotFoundException;

@Service
public class LocationServiceImp implements LocationService {
	private LocationRepository locationRepository;
	
	@Autowired
	public LocationServiceImp(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}
	
	@Override
	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

	@Override
	public Location getLocationByID(int id) {
		return locationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", id));
	}

	@Override
	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	@Override
	public Location updateLocation(Location location, int Id) {
		Location existingLocation = locationRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", Id));

		existingLocation.setAddress(location.getAddress());
		return existingLocation;
	}

	@Override
	public void deleteLocation(int Id) {
		Location existingLocation = locationRepository.findById(Id).orElseThrow(() -> new ResourceNotFoundException("Location", "id", Id));
		locationRepository.existsById(Id);
	}

}
