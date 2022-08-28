package com.gd.hr.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class CountryService implements ICountryService {
	@Autowired
	RegionMapper regionMapper;
	@Autowired
	CountryMapper countryMapper;
	@Autowired
	LocationMapper locationMapper;
	
	// RegionList 가져오기
	@Override
	public List<Region> addCountryForm() {
		List<Region> regionList = regionMapper.selectRegionList();
		return regionList;
	}
	
	//
	@Override
	public List<Country> getCountryIdAndNameList(int regionId) {
		List<Country> list = countryMapper.selectCountryIdAndNameList(regionId);
		return list;
	}

	// Country 리스트
	@Override
	public List<Map<String, Object>> getCountryList() {
		List<Map<String, Object>> countryList = countryMapper.selectCountryList();
		return countryList;
	}

	// Country 1개 상세보기
	@Override
	public Country getCountryOne(String countryId) {
		return countryMapper.selectCountryOne(countryId);
	}

	// Country 추가
	@Override
	public int addCountry(Country country) {
		return countryMapper.insertCountry(country);
	}

	// Country 수정
	@Override
	public int modifyCountry(Country country) {
		return countryMapper.updateCountry(country);
	}

	// Country 삭제
	@Override
	public int removeCountryByCountryId(String countryId) {
		locationMapper.deleteLocationByCountryId(countryId); // Location먼저 삭제되는 메서드 실행 
		int row = countryMapper.deleteCountryByCountryId(countryId);
		return row; 
	}

}
