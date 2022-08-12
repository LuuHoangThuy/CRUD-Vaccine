package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mock.springboot.jsp.entity.Ward;
import com.mock.springboot.jsp.repository.WardRepository;


@Service
public class WardServiceImpl implements WardService {
	@Autowired
	private WardRepository wardRepository;

	@Override
	public Ward save(Ward Ward) {
		return wardRepository.save(Ward);
	}

	@Override
	public List<Ward> getWards() {
		return (List<Ward>) wardRepository.findAll();
	}

	@Override
	public Optional<Ward> findById(long id) {
		return wardRepository.findById(id);
	}

	@Override
	public void deleteById(long id) {
		wardRepository.deleteById(id);
	}

	@Override
	public Page<Ward> getWardPagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return wardRepository.findAll(pageable);
	}

	@Override
	public List<Ward> search(String name) {
		// TODO Auto-generated method stub
		return wardRepository.findByNameContaining(name);
	}
}
