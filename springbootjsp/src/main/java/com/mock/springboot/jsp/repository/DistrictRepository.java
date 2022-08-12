package com.mock.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.springboot.jsp.entity.District;

public interface DistrictRepository extends JpaRepository<District, Long> {
	List<District> findByNameContaining(String name);
}
