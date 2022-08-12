package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.mock.springboot.jsp.entity.VaccinePackage;
import com.mock.springboot.jsp.repository.VaccinePackageRepository;

@Service
public class VaccinePackageServiceImpl implements VaccinePackageService {
	
	@Autowired
	private VaccinePackageRepository vaccinePackageRepository;
	
	@Override
	public VaccinePackage save(VaccinePackage vaccinePackage) {
		return vaccinePackageRepository.save(vaccinePackage);
	}

	@Override
	public List<VaccinePackage> getVaccines() {
		return (List<VaccinePackage>) vaccinePackageRepository.findAll();
	}

	@Override
	public List<VaccinePackage> search(String name) {
		return vaccinePackageRepository.findByNameContaining(name);
	}

	@Override
	public Page<VaccinePackage> getVaccinePackagePagination(int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		return vaccinePackageRepository.findAll(pageable);
	}

	@Override
	public void DeleteById(long id) {
		vaccinePackageRepository.deleteById(id);
	}

	@Override
	public Optional<VaccinePackage> findById(long id) {
		return vaccinePackageRepository.findById(id);
	}

}
