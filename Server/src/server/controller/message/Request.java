package server.controller.message;

import java.util.List;

import lombok.Data;

@Data

public class Request {
	private String ip; // unboxing 결과 ip
	private String id; // unboxing 결과 유저 id
	private List<String> newsList; // 받아야 할 뉴스 리스트
	private List<String> wantSection; // 원하는 뉴스 섹션들
}
