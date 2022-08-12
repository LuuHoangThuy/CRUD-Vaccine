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

import com.mock.springboot.jsp.entity.VaccinePackage;
import com.mock.springboot.jsp.service.VaccinePackageServiceImpl;

@Controller
@RequestMapping(value = "/vaccinepackage")
public class VaccinePackageController {
	private int pageSize = 10;
	
	@Autowired
	private VaccinePackageServiceImpl vaccinePackageServiceImpl;


	@GetMapping()
	public String getAll(Model model, @RequestParam(defaultValue = "1") Integer page) {

		Page<VaccinePackage> vaccinePagination = vaccinePackageServiceImpl.getVaccinePackagePagination(page - 1, pageSize);

		model.addAttribute("vaccinepackages", vaccinePagination != null ? vaccinePagination.toList() : null);
		model.addAttribute("totalPages", vaccinePagination.getTotalPages());
		model.addAttribute("currentPage", page);

		return "vaccinepackages";

	}

	@GetMapping(value = "/search")
	public String search(Model model, @RequestParam(defaultValue = "") String keySearch) {
		List<VaccinePackage> vaccinePackages = vaccinePackageServiceImpl.search(keySearch);
		model.addAttribute("vaccinepackages", vaccinePackages);

		return "vaccinepackages";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable long id) {

		Optional<VaccinePackage> editVaccinePackage = vaccinePackageServiceImpl.findById(id);
		if (editVaccinePackage.isPresent()) {
			model.addAttribute("vaccine", editVaccinePackage.get());
			return "newVaccinePackage";
		}
		model.addAttribute("message", "Vaccine not exists");
		List<VaccinePackage> vaccinePackages = vaccinePackageServiceImpl.getVaccines();
		model.addAttribute("vaccinepackages", vaccinePackages);
		return "vaccinepackages";
	}
	
	@GetMapping(value = "/details/{id}")
	public String details(Model model, @PathVariable long id) {

		Optional<VaccinePackage> editVaccinePackage = vaccinePackageServiceImpl.findById(id);
		if (editVaccinePackage.isPresent()) {
			model.addAttribute("vaccine", editVaccinePackage.get());
			return "PackageDetails";
		}
		model.addAttribute("message", "Vaccine not exists");
		List<VaccinePackage> vaccinePackages = vaccinePackageServiceImpl.getVaccines();
		model.addAttribute("vaccinepackages", vaccinePackages);
		return "vaccinepackages";
	}

	@PostMapping(value = "/save")
	public String update(@ModelAttribute("vaccinepackage") @Valid VaccinePackage vaccinePackage, BindingResult result) {
		if (result.hasErrors()) {
			return "newVaccinePackage";
		}
		vaccinePackageServiceImpl.save(vaccinePackage);
		return "redirect:/vaccinepackage";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable long id) {
		vaccinePackageServiceImpl.DeleteById(id);
		return "redirect:/vaccinepackage";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.GET)
	public String addNew(Model model) {
		model.addAttribute("vaccinepackage", new VaccinePackage());
		return "newVaccinePackage";
	}
}
