package com.gd.hr.service;


import java.util.List;

import com.gd.hr.vo.Board;
import com.gd.hr.vo.BoardForm;

public interface IBoardService {
	// Board 리스트
	List<Board> getBoardList();
	// Board 1개 상세보기
	Board getBoardOne(int boardOne);
	// Board 입력
	void addBoard(BoardForm boardForm, String path);
	// Board 수정
	void modifyBoard(BoardForm boardForm, String path);
	// Board 삭제
	int removeBoard(int boardNo, String path);
}
