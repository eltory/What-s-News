package server.controller.message;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	 private List<News> result; // Request 받고 News리턴
	 private List<String> newsList; // 전체 List
}
