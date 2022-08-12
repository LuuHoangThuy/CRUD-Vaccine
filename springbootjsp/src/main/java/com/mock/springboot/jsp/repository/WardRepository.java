package com.mock.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.springboot.jsp.entity.Ward;

public interface WardRepository extends JpaRepository<Ward, Long> {
	List<Ward> findByNameContaining(String name);
}
