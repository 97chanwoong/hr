package com.gd.hr.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Country;
import com.gd.hr.vo.Region;

@Mapper
public interface CountryMapper {
	   // RegionList 가져오기
	   List<Region> selectCountryForm();
	   //
	   List<Country> selectCountryIdAndNameList(int regionId); // 오버 로딩 반환타입은 메서드모양 하고 상관없음
	   // Country 리스트
	   List<Map<String, Object>> selectCountryList();
	   // Country 1개 상세보기
	   Country selectCountryOne(String countryId);
	   // Country 추가
	   int insertCountry(Country country);
	   // Country 수정
	   int updateCountry(Country country);
	   // RegionId에 의해 Country삭제
	   int deleteCountryByRegionId(int regionId);
	   // Country 삭제
	   int deleteCountryByCountryId(String countryId);
}
