package com.tdd.board.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

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
	private BoardDAO dao;
	
	@InjectMocks	// mock이 주입될 곳.
	private BoardService service;
	
	@Test // 내용이 비어있으면 게시글 작성화면으로 보내기.
	public void Not_Write_Board_Without_Content() {
		// given  내용 없는 게시글 하나 준비
		BoardDTO dto = BoardDTO.builder()
						.content("")
						.build();

		// when
		ModelAndView actual = service.write(dto);
		
		// then
		assertThat(actual.getViewName(), is("writeForm"));
	}

}
