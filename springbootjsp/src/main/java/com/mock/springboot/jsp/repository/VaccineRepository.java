package com.mock.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.springboot.jsp.entity.Vaccine;

public interface VaccineRepository extends JpaRepository<Vaccine, Long> {
	List<Vaccine> findByNameContaining(String name);
}
