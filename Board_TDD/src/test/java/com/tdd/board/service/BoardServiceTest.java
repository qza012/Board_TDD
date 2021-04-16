package com.tdd.board.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.servlet.ModelAndView;

import com.tdd.board.dao.BoardDAO;
import com.tdd.board.dto.BoardDTO;

@RunWith(MockitoJUnitRunner.class)
public class BoardServiceTest {
	
	@Mock	// service 내부의 dao객체 mock으로 생성.
	private BoardDAO boardDao;
	
	@InjectMocks	// mock이 주입될 곳.
	private BoardService boardService;
	
	@Test
	public void Detail_Logic() {
		// given
		BoardDTO dto = createBoard();		
		when(boardDao.upHit(dto.getIdx())).thenReturn(1);
		when(boardDao.detail(dto.getIdx())).thenReturn(dto);
		
		// when
		ModelAndView mav = boardService.detail(dto.getIdx());
		
		// then
		assertThat(mav.getViewName(), is("board/detail"));
		assertThat(mav.getModel().get("board"), is(dto));
	}
	
	@Test
	public void GetList_Logic() {
		// given
		ArrayList<BoardDTO> boardList = new ArrayList<BoardDTO>();	
		when(boardDao.getList()).thenReturn(boardList);
		
		// when
		ModelAndView mav = boardService.getList();
		
		// then
		assertThat(mav.getViewName(), is("board/list"));
		assertThat(mav.getModel().get("boardList"), is(boardList));
	}
	
	@Test
	public void Update_Logic() {
		// given
		BoardDTO dto = createBoard();
		when(boardDao.update(dto)).thenReturn(1);
		
		// when
		ModelAndView mav = boardService.update(dto);
		
		// then
		assertThat(mav.getViewName(), is("redirect:/detail"));
		assertThat(mav.getModel().get("idx"), is(dto.getIdx()));
	}
	
	@Test
	public void Write_Logic() {
		//given
		BoardDTO dto = createBoard();
		when(boardDao.write(dto)).thenReturn(1);
		
		// when
		ModelAndView mav = boardService.write(dto);
		
		// then
		assertThat(mav.getViewName(), is("redirect:/"));
	}
	
	
	@Test	// 내용이 비어있으면 게시글 작성화면으로 보내기.
	public void Not_Write_Board_Without_Content() {
		// given  내용 없는 게시글 하나 준비
		BoardDTO dto = BoardDTO.builder()
						.content("")
						.build();

		// when
		ModelAndView actual = boardService.write(dto);
		
		// then
		assertThat(actual.getViewName(), is("board/writeForm"));
	}
	
	private BoardDTO createBoard() {
		return BoardDTO.builder()
						.idx(1)
						.subject("제목 테스트")
						.content("내용 테스트")
						.build();
	}
}
