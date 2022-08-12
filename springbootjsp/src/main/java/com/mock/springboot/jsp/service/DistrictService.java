package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mock.springboot.jsp.entity.District;

public interface DistrictService {
	District save(District District);

	List<District> getDistricts();

	List<District> search(String name);

	Page<District> getDistrictPagination(int page, int size);

	void deleteById(long id);

	Optional<District> findById(long id);
}
