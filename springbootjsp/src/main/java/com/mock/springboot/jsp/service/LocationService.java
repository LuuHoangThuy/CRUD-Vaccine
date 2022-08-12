package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mock.springboot.jsp.entity.Location;

public interface LocationService {
	Location save(Location Location);

	List<Location> getLocations();

	List<Location> search(String name);

	Page<Location> getLocationPagination(int page, int size);

	void deleteById(long id);

	Optional<Location> findById(long id);
}
