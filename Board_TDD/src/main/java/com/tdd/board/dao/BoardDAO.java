package com.tdd.board.dao;

import java.util.ArrayList;

import org.springframework.web.servlet.ModelAndView;

import com.tdd.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> getList();

	int write(BoardDTO dto);

	ModelAndView detail(String idx);

}
