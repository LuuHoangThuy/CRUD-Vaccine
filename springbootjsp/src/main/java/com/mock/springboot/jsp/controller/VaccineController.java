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

import com.mock.springboot.jsp.entity.Sick;
import com.mock.springboot.jsp.entity.Vaccine;
import com.mock.springboot.jsp.service.SickServiceImpl;
import com.mock.springboot.jsp.service.VaccineServiceImpl;

@Controller
@RequestMapping(value = "/vaccine")
public class VaccineController {
	private int pageSize = 10;

	@Autowired
	private VaccineServiceImpl vaccineServiceImpl;

	@Autowired
	private SickServiceImpl sickServiceImpl;

	@GetMapping()
	public String getAll(Model model, @RequestParam(defaultValue = "1") Integer page) {

		Page<Vaccine> vaccinePagination = vaccineServiceImpl.getVaccincePagination(page - 1, pageSize);

		model.addAttribute("vaccines", vaccinePagination != null ? vaccinePagination.toList() : null);
		model.addAttribute("totalPages", vaccinePagination.getTotalPages());
		model.addAttribute("currentPage", page);

		return "vaccines";

	}

	@GetMapping(value = "/search")
	public String search(Model model, @RequestParam(defaultValue = "") String keySearch) {
		List<Vaccine> vaccines = vaccineServiceImpl.search(keySearch);
		model.addAttribute("vaccines", vaccines);

		return "vaccines";
	}

	@GetMapping(value = "/edit/{id}")
	public String edit(Model model, @PathVariable long id) {

		Optional<Vaccine> editVaccine = vaccineServiceImpl.findById(id);
		if (editVaccine.isPresent()) {
			List<Sick> sicks = sickServiceImpl.getSicks();
			model.addAttribute("sicks", sicks);
			model.addAttribute("vaccine", editVaccine.get());
			return "newVaccine";
		}
		model.addAttribute("message", "Vaccine not exists");
		List<Vaccine> vaccines = vaccineServiceImpl.getVaccines();
		model.addAttribute("vaccines", vaccines);
		return "vaccines";
	}

	@PostMapping(value = "/save")
	public String update(@ModelAttribute("vaccine") @Valid Vaccine vaccine, BindingResult result) {
		if (result.hasErrors()) {
			return "newVaccine";
		}
		vaccineServiceImpl.save(vaccine);
		return "redirect:/vaccine";
	}

	@GetMapping(value = "/delete/{id}")
	public String delete(Model model, @PathVariable long id) {
		vaccineServiceImpl.deleteById(id);
		return "redirect:/vaccine";
	}

	@RequestMapping(value = "/addnew", method = RequestMethod.GET)
	public String addNew(Model model) {
		model.addAttribute("vaccine", new Vaccine());
		List<Sick> sicks = sickServiceImpl.getSicks();
		model.addAttribute("sicks", sicks);
		return "newVaccine";
	}
}
