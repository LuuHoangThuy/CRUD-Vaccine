package com.mock.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.springboot.jsp.entity.Sick;

public interface SickRepository extends JpaRepository<Sick, Long> {
	List<Sick> findByNameContaining(String name);
}