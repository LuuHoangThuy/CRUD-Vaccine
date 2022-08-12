package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mock.springboot.jsp.entity.Vaccine;
import com.mock.springboot.jsp.repository.VaccineRepository;

@Service
public class VaccineServiceImpl implements VaccineService{
	@Autowired
	private VaccineRepository vaccineRepository;

	@Override
	public Vaccine save(Vaccine vaccine) {
		return vaccineRepository.save(vaccine);
	}

	@Override
	public List<Vaccine> getVaccines() {
		return (List<Vaccine>) vaccineRepository.findAll();
	}

	@Override
	public List<Vaccine> search(String name) {
		return vaccineRepository.findByNameContaining(name);
	}

	@Override
	public Page<Vaccine> getVaccincePagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return vaccineRepository.findAll(pageable);
	}

	@Override
	public void deleteById(long id) {
		vaccineRepository.deleteById(id);
	}

	@Override
	public Optional<Vaccine> findById(long id) {
		return vaccineRepository.findById(id);
	}
}
