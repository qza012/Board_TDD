package com.tdd.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(value = "/")
	public ModelAndView getList() {
		log.info("boardList");
		
		return service.getList();
	}
	
	@PostMapping(value = "/write")
	public ModelAndView write(@ModelAttribute BoardDTO dto) {
		log.info("write");

		return service.write(dto);
	}
	
	@GetMapping(value = "/writeForm")
	public String writeForm() {
		log.info("writeForm");
		
		return "board/writeForm";
	}
	
	@GetMapping(value = "/detail")
	public ModelAndView detail(@RequestParam int idx) {
		log.info("detail");
		
		return service.detail(idx);
	}
	
	@GetMapping(value = "/updateForm")
	public ModelAndView updateForm(@RequestParam int idx) {
		log.info("updateForm");
		
		return service.updateForm(idx);
	}
	
	@PostMapping(value = "/update")
	public ModelAndView update(@ModelAttribute BoardDTO dto){
		log.info("update");
		
		return service.update(dto);
	}
}
