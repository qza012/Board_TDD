package com.tdd.board.dao;

import java.util.ArrayList;

import com.tdd.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> getList();

	int insert(BoardDTO dto);

}
