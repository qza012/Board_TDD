package com.tdd.board.dto;

import java.sql.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int idx;
	private String user_name;
	private String subject;
	private String content;
	private Date reg_date;
	private int bhit;

	// mybatis 매핑을 하려면 기본생성자가 필수.
	public BoardDTO() {
		
	}
	
	@Builder
	private BoardDTO(int idx, String user_name, String subject, String content
			,Date reg_date, int bhit) {
		this.idx = idx;
		this.user_name = user_name;
		this.subject = subject;
		this.content = content;
		this.reg_date = reg_date;
		this.bhit = bhit;
	}
}
