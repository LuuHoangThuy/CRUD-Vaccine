package com.mock.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.springboot.jsp.entity.PackageDetails;

public interface PackageDetailsRepository extends JpaRepository<PackageDetails, Long> {
	List<PackageDetails> findByNameContaining(String name);
}
