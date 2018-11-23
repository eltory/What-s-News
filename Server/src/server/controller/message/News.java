package server.controller.message;

import lombok.Data;

@Data
public class News {
	private String id; // 뉴스 아이디
	private String head_line; //뉴스 헤드라인 
	private String times; // 뉴스 작성 및 수정 시간 
	private String data; // 뉴스 내용
}