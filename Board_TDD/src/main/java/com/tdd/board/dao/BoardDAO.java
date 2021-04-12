package com.tdd.board.dao;

import java.util.ArrayList;

import com.tdd.board.dto.BoardDTO;

public interface BoardDAO {

	ArrayList<BoardDTO> getList();

	int write(BoardDTO dto);

	BoardDTO detail(String idx);

	int upHit(String idx);

	void update(BoardDTO dto);

}
