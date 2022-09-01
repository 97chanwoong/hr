package com.gd.hr.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.*;
import com.gd.hr.vo.Boardfile;

@Mapper
public interface BoardfileMapper {
	// Boardfile 추가
	int insertBoardfile(Boardfile boardfile);
	// Board 삭제시 Boardfile도 삭제
	int deleteBoardfileByBoard(int boardNo);
	// Boardfile 삭제를 위한 Boardno 찾기
	List<Boardfile> selectBoardfileByBoardNo(int boardNo);
	
}
