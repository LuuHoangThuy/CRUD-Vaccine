package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mock.springboot.jsp.entity.Ward;

public interface WardService {
	Ward save(Ward Ward);

	List<Ward> getWards();

	List<Ward> search(String name);

	Page<Ward> getWardPagination(int page, int size);

	void deleteById(long id);

	Optional<Ward> findById(long id);
}
