package com.gd.hr.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Location;
import com.gd.hr.vo.Region;

@Service
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

	@Override
	public Location gettLocationOne(String locationId) {
		return null;
	}

	@Override
	public int modifyLocation(Location location) {
		return 0;
	}

	@Override
	public int removeLocationByRegionId(int regionId) {
		return 0;
	}

	@Override
	public int removeLocationByCountryId(String countryId) {
		return 0;
	}

	// Location 삭제
	@Override
	public int removeLocationByLocationId(int locationId) {
		return locationMapper.deleteLocationByLocationId(locationId);
	}
	
	
	

}
