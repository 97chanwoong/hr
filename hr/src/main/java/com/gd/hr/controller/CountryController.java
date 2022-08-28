package com.gd.hr.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.ICountryService;
import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Controller
public class CountryController {
	@Autowired // 의존성 주입을 할 때 사용하는 Annotation으로 의존 객체의 타입에 해당하는 bean을 찾아 주입하는 역할
	IRegionService regionService;
	@Autowired
	ICountryService countryService;

	@GetMapping("/countryList")
	public String countryList(Model model) {
		List<Map<String, Object>> countryList = countryService.getCountryList();
		model.addAttribute("countryList", countryList);
		return "countryList"; // ("countryList").forward(request, response);
	}

	@GetMapping("/addCountry") // Form
	public String addCountry(Model model) {
		List<Region> regionList = countryService.addCountryForm();
		model.addAttribute("regionList", regionList);
		return "addCountry"; // <select><c:foreach var="region items="${regionList}"><option
	}

	@PostMapping("/addCountry") // Action
	public String addCountry(Country country) {
		// 디버깅
		System.out.println(country + "<-- addCountry country");

		int row = countryService.addCountry(country);

		if (row == 0) {
			System.out.println("--- add Country 실패 ---");
		} else {
			System.out.println("--- add Country 성공 ---");
		}
		return "redirect:/countryList";
	}

	@GetMapping("/modifyCountry")
	public String modifyCountry(Model model, @RequestParam(value = "countryId") String countryId) {
		List<Region> regionList = countryService.addCountryForm();
		model.addAttribute("regionList", regionList);

		Country country = countryService.getCountryOne(countryId);
		model.addAttribute("country", country);
		return "modifyCountry";
	}

	@PostMapping("/modifyCountry")
	public String modifyCountry(Country country) {
		// 디버깅
		System.out.println(country);

		int row = countryService.modifyCountry(country);
		if (row == 0) {
			System.out.println("--- modify country 실패 ---");
		} else {
			System.out.println("--- modify country 성공 ---");
		}
		return "redirect:/countryList";
	}

	@GetMapping("/removeCountry")
	public String removeCountry(@RequestParam(value = "countryId") String countryId) {
		int row = countryService.removeCountryByCountryId(countryId);
		if (row == 0) {
			System.out.println("--- remove country 실패 ---");
		} else {
			System.out.println("--- remove country 성공 ---");
		}
		return "redirect:/countryList";
	}

}
