package com.gd.hr.service;

import java.util.*;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

public interface ICountryService {
	// RegionList가져오기
	List<Region> addCountryForm();
	//
	List<Country> getCountryIdAndNameList(int regionId);
	// Country 리스트
	List<Map<String,Object>> getCountryList();
	// Country 1개 상세보기
	Country getCountryOne(String countryId);
	// Country 추가
	int addCountry(Country country);
	// Country 수정
	int modifyCountry(Country country);
	// Country 삭제
	int removeCountryByCountryId(String countryId);
}
