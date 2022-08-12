package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mock.springboot.jsp.entity.Sick;
import com.mock.springboot.jsp.repository.SickRepository;

@Service
public class SickServiceImpl implements SickService {
	@Autowired
	private SickRepository sickRepository;

	@Override
	public Sick save(Sick sick) {
		return sickRepository.save(sick);
	}
	
	@Override
	public List<Sick> getSicks() {
		return (List<Sick>) sickRepository.findAll();
	}

	@Override
	public List<Sick> search(String name) {
		return sickRepository.findByNameContaining(name);
	}

	@Override
	public Page<Sick> getSickPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return sickRepository.findAll(pageable);
	}

	@Override
	public void deleteById(long id) {
		sickRepository.deleteById(id);
	}

	@Override
	public Optional<Sick> findById(long id) {
		return sickRepository.findById(id);
	}
}
