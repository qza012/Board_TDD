package com.tdd.board.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.tdd.board.dao.BoardDAO;
import com.tdd.board.dto.BoardDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardService {
	
	private final BoardDAO dao;
	private ModelAndView mav;
	
	@Autowired
	public BoardService(BoardDAO dao) {
		this.dao = dao;
		this.mav = new ModelAndView();
	}

	public ModelAndView getList() {
		log.info("getList");
		
		ArrayList<BoardDTO> boardList = dao.getList();
		
		if(boardList != null) {			
			mav.addObject("boardList", boardList);
		}

		mav.setViewName("boardList");
		
		return mav;
	}

	public ModelAndView write(BoardDTO dto) {
		log.info("write");
		
		String page = "writeForm";

		if(dto.getContent() == null || dto.getContent().equals("")) {
			mav.setViewName(page);
			return mav;
		} 
		
		int writeResult = dao.write(dto);
		if(writeResult == 1) {
			mav.setViewName("redirect:/");
		}

		return mav;
	}

	public ModelAndView detail(int idx) {
		log.info("detail");
		
		String page = "redirect:/";
		
		BoardDTO board = dao.detail(idx);
		int upHitResult = dao.upHit(idx);
		
		if(upHitResult == 1 && board != null) {			
			mav.addObject("board", dao.detail(idx));
			page = "detail";
		}
		
		mav.setViewName(page);
		
		return mav;
	}

	public ModelAndView updateForm(int idx) {
		log.info("updateForm");
		
		mav.addObject("board", dao.detail(idx));
		mav.setViewName("updateForm");
		
		return mav;
	}

	public ModelAndView update(BoardDTO dto) {
		log.info("update");
		
		int updateResult = dao.update(dto);
		
		if(updateResult == 1) {
			mav.addObject("idx", dto.getIdx());			
		}
		
		mav.setViewName("redirect:/detail");
		
		return mav;
	}
}
