package com.gd.hr.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Board;

@Mapper
public interface BoardMapper {
	// Board 리스트
	List<Map<String,Object>> selectBoardList();
	// Board 추가
	int insertBoard(Board board);
}
