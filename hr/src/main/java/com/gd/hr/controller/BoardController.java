package com.gd.hr.controller;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gd.hr.service.IBoardService;
import com.gd.hr.vo.Board;
import com.gd.hr.vo.BoardForm;

@Controller
public class BoardController {
	@Autowired IBoardService boardService;
	
	
	@GetMapping("/boardList")
	public String boardList(Model model) {
		List<Board> boardList = boardService.getBoardList();
		model.addAttribute("boardList", boardList);
		return "boardList";
	}
	
	
	@GetMapping("/addBoard")
	public String addBoard() {
		return "addBoard";
	}
	
	@PostMapping("/addBoard")
	public String addBoard(Model model, BoardForm boardForm, HttpSession session) {
		String path = session.getServletContext().getRealPath("/upload");
		// session.getServletContext().getRealPath(null)
		boardService.addBoard(boardForm, path);
		return "redirect:/boardList";
	}
	
	// Board 수정 form
		@GetMapping("/modifyBoard")
		public String modifyBoard(Model model, @RequestParam (value = "boardNo") int boardNo) {
			// 디버깅
			System.out.println("@GetMapping modifyBoard");
			// Board 1개 상세보기
			Board board = boardService.getBoardOne(boardNo);
			model.addAttribute("board", board);
			
			return "modifyBoard";
		}
		//  Board 수정 action
		@PostMapping("/modifyBoard")
		public String modifyBoard(BoardForm boardForm, HttpSession session) {
			// 디버깅
			System.out.println("@PostMapping modifyBoard");
			// 디버깅
			System.out.println("boardForm : " + boardForm.getBoard() + boardForm.getMultiList());
			String path = session.getServletContext().getRealPath("/upload");
			boardService.modifyBoard(boardForm, path);
			
			return "redirect:/boardList";
		}
		
		@GetMapping("/removeBoard")
		public String removeBoard(int boardNo, HttpSession session) {
			// 디버깅
			System.out.println("@GetMapping removeBoard");
			
			String path = session.getServletContext().getRealPath("/upload");
			int row = boardService.removeBoard(boardNo, path);
			
			// 디버깅
			if(row == 1) { // 성공
				System.out.println("removeBoard 성공");
			} else { // 실패
				System.out.println("removeBoard 실패");
			}
			
			return "redirect:/boardList";
		}
}
