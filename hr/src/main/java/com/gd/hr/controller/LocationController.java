package com.gd.hr.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.ILocationService;
import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Location;

@Controller
public class LocationController {
	@Autowired
	IRegionService regionService;
	@Autowired
	ILocationService locationService;

	@GetMapping("/locationList")
	public String locationList(Model model) {
		List<Map<String, Object>> locationList = locationService.getLocationList();
		model.addAttribute("locationList", locationList);
		return "locationList"; // ("locationList").forward(request, response);
	}

	@GetMapping("/addLocation")
	public String addLocation(Model model) {
		Map<String, Object> map = locationService.addLocationForm();
		model.addAttribute("regionList", map.get("regionList"));
		return "addLocation";
	}

	@PostMapping("/addLocation")
	public String addLocation(Location location) {
		// 디버깅
		System.out.println(location + "<-- addLocation location");

		int row = locationService.addLocation(location);
		if (row == 0) {
			System.out.println("--- add Location 실패 ---");
		} else {
			System.out.println("--- add Location 성공 ---");
		}
		return "redirect:/locationList";
	}

	// modifyLocation Form
	@GetMapping("/modifyLocation")
	public String modifyLocation(Model model, @RequestParam(value = "locationId") int locationId) {
		// 디버깅
		System.out.println("<-- @GetMapping modifyLocation");
		model.addAttribute("locationMap", locationService.getLocationOne(locationId));

		// region 값 가져와서 폼에서 사용하기
		Map<String, Object> map = locationService.addLocationForm();
		model.addAttribute("regionList", map.get("regionList"));
		// 디버깅
		System.out.println(model + "<-- @GetMapping modifyLocation model");
		return "modifyLocation";
	}

	// modifyLocation Action
	@PostMapping("/modifyLocation")
	public String modifyLocation(Location location) {
		// 디버깅
		System.out.println("@PostMapping modifyLocation");
		int row = locationService.modifyLocation(location);
		// 디버깅
		if (row == 0) { 
			System.out.println("--- modify location 실패 ---");
		} else { 
			System.out.println("--- modify location 성공 ---");
		}

		return "redirect:/locationList";
	}

	@GetMapping("/removeLocation")
	public String removeLocation(@RequestParam(value = "locationId") int locationId) {
		int row = locationService.removeLocationByLocationId(locationId);
		if (row == 0) {
			System.out.println("--- remove location 실패 ---");
		} else {
			System.out.println("--- remove location 성공 ---");
		}
		return "redirect:/locationList";
	}
}
