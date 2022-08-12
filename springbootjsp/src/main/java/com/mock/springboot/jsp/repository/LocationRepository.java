package com.mock.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.springboot.jsp.entity.Location;

public interface LocationRepository extends JpaRepository<Location, Long> {
	List<Location> findByNameContaining(String name);
}
