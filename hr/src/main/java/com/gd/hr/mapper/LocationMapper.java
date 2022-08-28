package com.gd.hr.mapper;

import org.apache.ibatis.annotations.Mapper;
import java.util.*;
import com.gd.hr.vo.Location;

@Mapper
public interface LocationMapper {
	// Location 리스트
	List<Map<String,Object>> selectLocationList();
	// Location 추가
	int insertLocation(Location location);
	// Location을 추가하기 위한 Form(Region -> Country -> Location)
	Map<String,Object> addLocationForm();
	// Location 1개 상세보기
	List<Map<String,Object>> selectLocationOne(int locationId);
	// Location 수정
	int updateLocation(Location location);
	// countryId를 찾는 기능
	String selectCountryId(int regionId);
	// locationId를 찾는 기능
	int selectLocationId(String countryId);
	// Country에 의해 Location 삭제
	int deleteLocationByCountryId(String countryId);
	// Location 삭제
	int deleteLocationByLocationId(int locationId);
}
