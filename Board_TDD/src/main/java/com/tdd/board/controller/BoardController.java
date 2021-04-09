package com.tdd.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tdd.board.dto.BoardDTO;
import com.tdd.board.service.BoardService;

import lombok.extern.log4j.Log4j;

@Log4j
@Controller
@RequestMapping("/")
public class BoardController {

	private final BoardService service;
	
	@Autowired
	public BoardController(BoardService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/")
	public ModelAndView List() {
		log.info("boardList");
		
		return service.getList();
	}
	
	@RequestMapping(value = "/insert")
	public String insert(@ModelAttribute BoardDTO dto) {
		log.info("insert");
		String page = "redirect:/list";
		
		int result = service.insert(dto);
		if(result == 0) {
			page = "insert";
		}
		
		return page;
	}
}
