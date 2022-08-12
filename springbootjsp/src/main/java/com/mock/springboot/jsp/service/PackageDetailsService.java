package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mock.springboot.jsp.entity.PackageDetails;

public interface PackageDetailsService {
	PackageDetails save(PackageDetails packageDetails);
	
	List<PackageDetails> getPackageDetails();
	
	List<PackageDetails> search(String name);
	
	Page<PackageDetails> getPackagePagination(int page, int size);
	
	void deleteByID(long id);
	
	Optional<PackageDetails> findById(long id);
}
