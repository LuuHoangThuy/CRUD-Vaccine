package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.mock.springboot.jsp.entity.VaccinePackage;

public interface VaccinePackageService {
	VaccinePackage save (VaccinePackage vaccinePackage);
	
	List<VaccinePackage> getVaccines();
	
	List<VaccinePackage> search(String name);
	
	Page<VaccinePackage> getVaccinePackagePagination(int page, int size);
	
	void DeleteById(long id);
	
	Optional<VaccinePackage> findById(long id);
}
