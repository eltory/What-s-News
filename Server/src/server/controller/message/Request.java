package server.controller.message;

import java.util.List;

import lombok.Data;

@Data
public class Request {
	private String ip; // unboxing result: ip
	private String id; // unboxing result: User id
	private List<String> newsList; // Newslist to receive
	private List<String> wantSection; // Wanted NewsSection 
}
