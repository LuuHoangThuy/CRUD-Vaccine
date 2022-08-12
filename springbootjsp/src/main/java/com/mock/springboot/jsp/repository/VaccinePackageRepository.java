package com.mock.springboot.jsp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.springboot.jsp.entity.VaccinePackage;

public interface VaccinePackageRepository extends JpaRepository<VaccinePackage, Long> {
	List<VaccinePackage> findByNameContaining(String name);
}
