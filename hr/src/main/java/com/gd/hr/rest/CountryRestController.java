package com.gd.hr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gd.hr.service.ICountryService;
import com.gd.hr.vo.Country;

@RestController // RestController안의 메서드 리턴값을 JSON으로 변경 후 응답
public class CountryRestController {
	@Autowired ICountryService countryMapper;
	
	@GetMapping("/rest/getCountryList")
	public List<Country> restGetCountryList(@RequestParam(value = "regionId") int regionId) {
		List<Country> list = countryMapper.getCountryIdAndNameList(regionId);
		return list;
	}
}
