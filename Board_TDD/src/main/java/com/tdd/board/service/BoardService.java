package com.tdd.board.service;

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

		mav.setViewName("boardList");
		mav.addObject("boardList", dao.getList());
		
		return mav;
	}

	public ModelAndView write(BoardDTO dto) {
		log.info("write");

		if(dto.getContent() == null || dto.getContent().equals("")) {
			mav.setViewName("writeForm");
		} else {
			dao.write(dto);
			mav.setViewName("redirect:/");
		}

		return mav;
	}

	public ModelAndView detail(String idx) {
		log.info("detail");
		
		dao.upHit(idx);
		mav.addObject("board", dao.detail(idx));
		mav.setViewName("detail");
		
		return mav;
	}

	public ModelAndView updateForm(String idx) {
		log.info("updateForm");
		
		mav.addObject("board", dao.detail(idx));
		mav.setViewName("updateForm");
		
		return mav;
	}

	public ModelAndView update(BoardDTO dto) {
		log.info("update");
		
		dao.update(dto);
		mav.addObject("idx", dto.getIdx());
		mav.setViewName("redirect:/detail");
		
		return mav;
	}
}
