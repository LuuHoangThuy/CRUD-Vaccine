package com.mock.springboot.jsp.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mock.springboot.jsp.entity.District;
import com.mock.springboot.jsp.entity.Location;
import com.mock.springboot.jsp.entity.Ward;
import com.mock.springboot.jsp.service.DistrictServiceImpl;
import com.mock.springboot.jsp.service.LocationServiceImpl;
import com.mock.springboot.jsp.service.WardServiceImpl;

@Controller
@RequestMapping(value = "/location")
public class LocationController {
	private int pageSize = 10;

	@Autowired
	private LocationServiceImpl locationServiceImpl;
	
	@Autowired
	private DistrictServiceImpl districtServiceImpl;
	
	@Autowired
	private WardServiceImpl wardServiceImpl;
	@GetMapping()
	public String getAll(Model model, @RequestParam(defaultValue = "1") Integer page) {

		Page<Location> locationPagination = locationServiceImpl.getLocationPagination(page - 1, pageSize);
		model.addAttribute("locations", locationPagination != null ? locationPagination.toList() : null);
		model.addAttribute("totalPages", locationPagination.getTotalPages());
		model.addAttribute("currentPage", page);
		List<Ward> wards = wardServiceImpl.getWards();
		model.addAttribute("wards", wards);
		return "locations";

	}

	@GetMapping(value = "/search")
	public String search(Model model, @RequestParam(defaultValue = "") String keySearch) {
		List<Location> locations = locationServiceImpl.search(keySearch);
		model.addAttribute("locations", locations);

		return "locations";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable long id) {

		Optional<Location> editLocation = locationServiceImpl.findById(id);
		if (editLocation.isPresent()) {
			model.addAttribute("location", editLocation.get());
			return "newLocation";
		}
		model.addAttribute("message", "Location not exists");
		List<Location> locations = locationServiceImpl.getLocations();
		model.addAttribute("locations", locations);
		return "locations";
	}

	@PostMapping(value = "/save")
	public String update(@ModelAttribute("location") @Valid Location location, BindingResult result) {
		if (result.hasErrors()) {
			return "newLocation";
		}
		locationServiceImpl.save(location);
		return "redirect:/location";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable long id) {
		locationServiceImpl.deleteById(id);
		return "redirect:/location";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.GET)
	public String addNew(Model model) {
		model.addAttribute("location", new Location());
		List<District> districts = districtServiceImpl.getDistricts();
		model.addAttribute("districts", districts);
		List<Ward> wards = wardServiceImpl.getWards();
		model.addAttribute("wards", wards);
		return "newLocation";
	}
}
