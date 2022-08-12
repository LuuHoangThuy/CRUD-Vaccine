package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mock.springboot.jsp.entity.Location;
import com.mock.springboot.jsp.repository.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {
	@Autowired
	private LocationRepository locationRepository;

	@Override
	public Location save(Location Location) {
		return locationRepository.save(Location);
	}

	@Override
	public List<Location> getLocations() {
		return (List<Location>) locationRepository.findAll();
	}

	@Override
	public Optional<Location> findById(long id) {
		return locationRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		locationRepository.deleteById(id);
	}

	@Override
	public Page<Location> getLocationPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return locationRepository.findAll(pageable);
	}

	@Override
	public List<Location> search(String name) {
		// TODO Auto-generated method stub
		return locationRepository.findByNameContaining(name);
	}
}
