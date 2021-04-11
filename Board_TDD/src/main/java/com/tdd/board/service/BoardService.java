package com.tdd.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.tdd.board.dao.BoardDAO;
import com.tdd.board.dto.BoardDTO;

import lombok.extern.log4j.Log4j;

@Log4j
@Service
public class BoardService {
		
	private final BoardDAO dao;
	
	@Autowired
	public BoardService(BoardDAO dao) {
		this.dao = dao;
	}

	public ModelAndView getList() {
		log.info("getList");

		ModelAndView mav = new ModelAndView();

		mav.setViewName("boardList");
		mav.addObject("boardList", dao.getList());
		
		return mav;
	}

	public ModelAndView write(BoardDTO dto) {
		log.info("write");

		ModelAndView mav = new ModelAndView();
		
		if(dto.getContent() == null || dto.getContent().equals("")) {
			mav.setViewName("writeForm");
		} else {
			dao.write(dto);
			mav.setViewName("redirect:/list");
		}

		return mav;
	}

//	public ModelAndView detail(String idx) {
//		log.info("detail");
//		
//		return dao.detail(idx);
//	}
}
