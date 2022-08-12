package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mock.springboot.jsp.entity.District;
import com.mock.springboot.jsp.repository.DistrictRepository;

@Service
public class DistrictServiceImpl implements DistrictService {
	@Autowired
	private DistrictRepository DistrictRepository;

	@Override
	public District save(District District) {
		return DistrictRepository.save(District);
	}

	@Override
	public List<District> getDistricts() {
		return (List<District>) DistrictRepository.findAll();
	}

	@Override
	public Optional<District> findById(long id) {
		return DistrictRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		DistrictRepository.deleteById(id);
	}

	@Override
	public Page<District> getDistrictPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return DistrictRepository.findAll(pageable);
	}

	@Override
	public List<District> search(String name) {
		return DistrictRepository.findByNameContaining(name);
	}
}
