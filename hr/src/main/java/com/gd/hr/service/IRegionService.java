package com.gd.hr.service;

import java.util.List;

import com.gd.hr.vo.Region;

public interface IRegionService {
	// 대륙 리스트
	List<Region> getRegionList();
	// 대륙 1개 상세보기
	Region getRegionOne(int regionId);
	// 대륙 추가
	int addRegion(Region region);
	// 대륙 수정
	int modifyRegion(Region region);
	// 대륙 삭제
	int removeRegion(int regionId);
}

