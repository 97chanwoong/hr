package com.gd.hr.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Boardfile;

@Mapper
public interface BoardfileMapper {
	// Boardfile 추가
	int insertBoardfile(Boardfile boardfile);
	// Boardfile 수정

}
