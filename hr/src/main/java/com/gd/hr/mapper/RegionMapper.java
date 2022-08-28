package com.gd.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Region;

@Mapper // --> @Repository public class XXX implements RegionMapper {...}  @Mapper는 인터페이스 위에 붙는다
public interface RegionMapper {
	// 대륙 리스트
	List<Region> selectRegionList();
	// 대륙 1개 상세보기
	Region selectRegionOne(int regionId);
	// 대륙 추가
	int insertRegion(Region region);
	// 대륙 수정
	int updateRegion(Region region);
	// 대륙 삭제
	int deleteRegion(int regionId);
}
