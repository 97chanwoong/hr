package com.gd.hr.service;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.gd.hr.mapper.BoardMapper;
import com.gd.hr.mapper.BoardfileMapper;
import com.gd.hr.vo.BoardForm;
import com.gd.hr.vo.Boardfile;

@Service
@Transactional
public class BoardService implements IBoardService {
	@Autowired BoardMapper boardMapper;
	@Autowired BoardfileMapper boardfileMapper;
	
	@Override
	public void addBoard(BoardForm boardForm, String path) {
		System.out.println(boardForm.getBoard()); // board.getBoardNo() --> 0
		int row = boardMapper.insertBoard(boardForm.getBoard());
		System.out.println(boardForm.getBoard()); // board.getBoardNo() --> selectKey
		
		// boardfile insert
		// board입력이 성공하고 파일이 있을때
		if(row == 1 && boardForm.getMultiList() != null) {
			for(MultipartFile mf : boardForm.getMultiList()) {
				Boardfile boardfile = new Boardfile();
				boardfile.setBoardNo(boardForm.getBoard().getBoardNo());
				
				// 중복되지 않는 랜덤이름 생성 UUID API
				String filename = UUID.randomUUID().toString().replace("-", "");
				
				boardfile.setFileName(filename);
				boardfile.setOriginName(mf.getOriginalFilename());
				boardfile.setFileType(mf.getContentType());
				boardfile.setFileSize(mf.getSize());
				
				// 파일입력 메서드
				boardfileMapper.insertBoardfile(boardfile);
				// 파일생성
				// 확장자
				String ext = mf.getOriginalFilename().substring(mf.getOriginalFilename().lastIndexOf("."));
				try {
					mf.transferTo(new File(path + filename + ext)); // 새로운 빈 파일안에 MultipartFile안에 파일을 하나씩 복사
				} catch (Exception e) {
					e.printStackTrace();
					// try-catch를 하지 않아도 되는 예외를 발생시키기
					throw new RuntimeException(); // @트랜젝션 처리가 되도록 강제로 Runtime예외(try절을 강요하지 않는 예외)발생
				} 
			}
		}
	}
}

