package com.gd.hr.mapper;

import java.util.*;

import org.apache.ibatis.annotations.Mapper;

import com.gd.hr.vo.Board;

@Mapper
public interface BoardMapper {
	// Board 리스트
	List<Board> selectBoardList();
	// Board 1개 상세보기
	Board selectBoardOne(int boardNo);
	// Board 추가
	int insertBoard(Board board);
	// Board 수정
	int updateBoard(Board board);
	// Board 삭제
	int deleteBoard(int boardNo);
}
