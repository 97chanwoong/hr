package com.gd.hr.service;

import com.gd.hr.vo.Location;
import java.util.*;
public interface ILocationService {
	// Location 리스트
	List<Map<String,Object>> getLocationList();
	// Location 추가
	int addLocation(Location location);
	// Location을 추가하기 위한 Form
	Map<String,Object> addLocationForm();
	// Location 1개 상세보기
	List<Map<String,Object>> getLocationOne(int locationId);
	// Location 수정
	int modifyLocation(Location location);
	// Location 삭제
	int removeLocationByLocationId(int locationId);
}
