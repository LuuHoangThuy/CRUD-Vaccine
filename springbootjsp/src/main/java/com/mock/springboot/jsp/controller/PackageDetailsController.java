package com.mock.springboot.jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mock.springboot.jsp.service.PackageDetailsServiceImpl;


@Controller
@RequestMapping(value = "/packagedetails")
public class PackageDetailsController {
	private int pageSize = 10;
	
	@Autowired
	PackageDetailsServiceImpl packageDetailsServiceImpl;
	
	@GetMapping()
	public String getAll(Model model, @RequestParam(defaultValue = "1") Integer page) {
		return "packagedetails";
	}
}
