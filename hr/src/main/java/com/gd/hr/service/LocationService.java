package com.gd.hr.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Location;
import com.gd.hr.vo.Region;

@Service
@Transactional
public class LocationService implements ILocationService {
	@Autowired RegionMapper regionMapper;
	@Autowired LocationMapper locationMapper;
	
	// Location 리스트
	@Override
	public List<Map<String, Object>> getLocationList() {
		List<Map<String,Object>> locationList = locationMapper.selectLocationList();
		return locationList;
	}
	
	// Location 추가
	@Override
	public int addLocation(Location location) {
		int row = locationMapper.insertLocation(location);
		return row;
	}
	// Location을 추가하기 위한 Form
	@Override
	public Map<String, Object> addLocationForm() {
		Map<String,Object> resultMap = new HashMap<>();
		List<Region> regionList = regionMapper.selectRegionList();
		resultMap.put("regionList",regionList);
		return resultMap;
	}
	
	// Location 1개 상세보기 
	@Override
	public Map<String, Object> getLocationOne(int locationId) {
		return locationMapper.selectLocationOne(locationId);
	}
	
	// Location 수정
	@Override
	public int modifyLocation(Location location) {
		return locationMapper.updateLocation(location);
	}

	// Location 삭제
	@Override
	public int removeLocationByLocationId(int locationId) {
		return locationMapper.deleteLocationByLocationId(locationId);
	}
	
	
	

}
