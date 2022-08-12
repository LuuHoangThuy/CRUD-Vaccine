package com.mock.springboot.jsp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.springboot.jsp.entity.Vaccine;
import com.mock.springboot.jsp.service.VaccineServiceImpl;

@RestController
public class HomeController {
	@Autowired
	private VaccineServiceImpl vaccineServiceImpl;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public List<Vaccine> index() {

		List<Vaccine> products = vaccineServiceImpl.getVaccines();
		return products;
	}
}
