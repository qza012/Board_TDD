package com.tdd.board.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.tdd.board.service.BoardService;

@RunWith(MockitoJUnitRunner.class)
public class BoardControllerTest {
	
	@Mock
	private BoardService boardService;
	
	@InjectMocks
	private BoardController boardController;

	@Test
	public void GetList_Logic() {
		// given
		ModelAndView mav = new ModelAndView("board/list");	
		when(boardService.getList()).thenReturn(mav);
		
		// when
		ModelAndView actual = boardController.getList();
		
		// then
		assertThat(actual, is(mav));
	}
	
	@Test
	public void Write_Logic() {
		// given
		ModelAndView mav = new ModelAndView("board/write");	
		when(boardService.getList()).thenReturn(mav);
		
		// when
		ModelAndView actual = boardController.getList();
		
		// then
		assertThat(actual, is(mav));
	}
	
	@Test
	public void Detail_Logic() {
		// given
		ModelAndView mav = new ModelAndView("board/detail");	
		when(boardService.detail(1)).thenReturn(mav);
		
		// when
		ModelAndView actual = boardController.detail(1);
		
		// then
		assertThat(actual, is(mav));
	}
	
	@Test
	public void Update_Logic() {
		// given
		ModelAndView mav = new ModelAndView("board/detail");	
		when(boardService.update(Mockito.any())).thenReturn(mav);
		
		// when
		ModelAndView actual = boardController.update(Mockito.any());
		
		// then
		assertThat(actual, is(mav));
	}
}
