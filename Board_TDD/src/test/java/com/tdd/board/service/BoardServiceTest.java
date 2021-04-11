package com.tdd.board.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.context.annotation.Description;
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
	public void not_write_Board_without_content() {
		// given  내용 없는 게시글 하나 준비
		BoardDTO dto = BoardDTO.builder()
						.content("")
						.build();

		// when
		ModelAndView actual = service.write(dto);
		
		// then
		assertThat(actual.getViewName(), is("writeForm"));
	}
	
	@Test // 글 상세보기
	public void detail() {
		// given
		BoardDTO dto = BoardDTO.builder()
						.idx(1)
						.subject("테스트")
						.content("테스트 중입니다.")
						.build();
		
		// when
		//int actual = service.detail(Integer.toString(dto.getIdx()));
		
		
	}
}
