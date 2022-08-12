package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mock.springboot.jsp.entity.Sick;

public interface SickService {
	Sick save(Sick sick);

	List<Sick> getSicks();

	List<Sick> search(String name);

	Page<Sick> getSickPagination(int page, int size);

	void deleteById(long id);

	Optional<Sick> findById(long id);
}
