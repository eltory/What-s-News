package server.controller.message;

import lombok.Data;

@Data
public class News {
	private String id; // News id
	private String head_line; // News headline
	private String times; // New set and modification time 
	private String data; // News contents
}