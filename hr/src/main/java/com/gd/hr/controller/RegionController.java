package com.gd.hr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.IRegionService;
import com.gd.hr.vo.Region;

@Controller
public class RegionController {
	@Autowired IRegionService regionService; // <- new RegionService()
	
	@GetMapping("/regionList")
	public String regionList(Model model) {
		List<Region> list = regionService.getRegionList();
		model.addAttribute("list", list); // request.setAttribute("list", list);
		System.out.println(list);
		return "regionList"; // ("regionList").forward(request, response);
	}
	
	@GetMapping("/addRegion") // FORM
	public String addRegion() {
		return "addRegion";
	}
	
	@PostMapping("/addRegion") //Action
	public String addRegion(Region region) { // 오버 로딩  // @RequestParam int regionId == request.getParameter("regionId")
		// 디버깅
		System.out.println(region);
		
		int row =  regionService.addRegion(region);
		if(row == 0) {
			System.out.println("--- add region 실패 ---");
		} else {
			System.out.println("--- add region 성공 ---");
		}
		return "redirect:/regionList"; // regionList redirect    리다이렉트 해주세요! : "redirect:/regionList"
	}
	
	
	@GetMapping("/modifyRegion") 
	public String modifyRegion(Model model, @RequestParam(value = "regionId") int regionId) { //@RequestParam(value = "regionId") int regionId @RequestParam value명이랑 변수명 같으면 생략 가능 하지만 안하는걸 추천
		Region region = regionService.getRegionOne(regionId);
		model.addAttribute("region", region);
		return "modifyRegion";
	}
	
	@PostMapping("/modifyRegion") //Action
	public String modifyRegion(Region region) { // 오버 로딩  // @RequestParam int regionId == request.getParameter("regionId")
		// 디버깅
		System.out.println(region);
		
		int row =  regionService.modifyRegion(region);
		if(row == 0) {
			System.out.println("--- modify region 실패 ---");
		} else {
			System.out.println("--- modify region 성공 ---");
		}
		return "redirect:/regionList"; // regionList redirect    리다이렉트 해주세요! : "redirect:/regionList"
	}
	
	@GetMapping("/removeRegion")
	public String removeRegion(@RequestParam(value = "regionId") int regionId) {
		int row =  regionService.removeRegion(regionId);
		if(row == 0) {
			System.out.println("--- remove region 실패 ---");
		} else {
			System.out.println("--- remove region 성공 ---");
		}
		return "redirect:/regionList";
	}
}
