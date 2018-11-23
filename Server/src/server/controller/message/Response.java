package server.controller.message;

import java.util.List;

import lombok.Data;

@Data
public class Response {
	 private List<News> result; // Received Request and return News
	 private List<String> newsList; // Full list
}
