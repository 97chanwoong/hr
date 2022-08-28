package com.gd.hr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gd.hr.mapper.CountryMapper;
import com.gd.hr.mapper.LocationMapper;
import com.gd.hr.mapper.RegionMapper;
import com.gd.hr.vo.Region;


@Service
@Transactional
public class RegionService implements IRegionService {
	// DI : 객체를 직접 생성하지않고 스프링 프레임워크를 통해(bean객체) 주입
	// Interface 타입을 사용
	@Autowired RegionMapper regionMapper;
	@Autowired CountryMapper countryMapper; // country삭제를 위해 RegionService에 주입
	@Autowired LocationMapper locationMapper;
	@Override
	public List<Region> getRegionList() {
		return regionMapper.selectRegionList();
	}
	

	@Override
	public Region getRegionOne(int regionId) {
		return regionMapper.selectRegionOne(regionId);
	}


	@Override
	public int addRegion(Region region) {
		return regionMapper.insertRegion(region);
	}

	@Override
	public int modifyRegion(Region region) {
		return regionMapper.updateRegion(region);
	}

	@Override
	public int removeRegion(int regionId) {
		String countryId =  locationMapper.selectCountryId(regionId); // countryId 찾아주기
		int locationId = locationMapper.selectLocationId(countryId); // locationId 찾아주기
		locationMapper.deleteLocationByLocationId(locationId); // location 지워주기
		countryMapper.deleteCountryByRegionId(regionId); // 먼저 실행되어야함
		int row =  regionMapper.deleteRegion(regionId);
		return row; // true false 를 리턴하는게 더 좋은 방법 일 수 있다
	}
	
	
	
	

}
