package server.controller;

import lombok.*;
import server.controller.message.Request;
import org.json.*;
import com.google.gson.*;

/**
 * 
 * @author lsh
 *
 */
public class Processing {
	final static Gson gson = new Gson();

	public Request unBox(String request) {
		return gson.fromJson(request, Request.class);
	}

	public void getRequest(String request) {
		// DB db = new DB();
		// db.request(unBox(request));
	}
}
