package com.gd.hr.vo;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardForm{
	// private int boardNo; // <input name="boardNo"..>
	private Board board; // <input name="board.boardNo"...>
	private List<MultipartFile> multiList;
}
