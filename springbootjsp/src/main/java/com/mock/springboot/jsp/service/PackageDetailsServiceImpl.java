package com.mock.springboot.jsp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.mock.springboot.jsp.entity.PackageDetails;
import com.mock.springboot.jsp.repository.PackageDetailsRepository;


@Service
public class PackageDetailsServiceImpl implements PackageDetailsService {
	
	@Autowired
	private PackageDetailsRepository packageDetailsRepository;
	
	@Override
	public PackageDetails save(PackageDetails packageDetails) {
		return packageDetailsRepository.save(packageDetails);
	}

	@Override
	public List<PackageDetails> getPackageDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PackageDetails> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<PackageDetails> getPackagePagination(int page, int size) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByID(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<PackageDetails> findById(long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

}
