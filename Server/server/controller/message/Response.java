package server.controller.message;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	 private List<News> result; // Request �ް� News����
	 private List<String> newsList; // ��ü List
}
