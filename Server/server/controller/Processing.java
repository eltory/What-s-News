package server.controller;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.json.*;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import server.controller.message.Request;

public class Processing {
	final Gson gson = new Gson();
	
	private final int THREAD_CNT = 1;
	private ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

	
//	public Request unBox(JsonObject request){
	public Request unBox(String request){
		return gson.fromJson(request, Request.class);
	}
	
//	public void getRequest(JsonObject request){
	public void getRequest(String request){
		// DB db = new DB();
		// db.request(unBox(request));
		
		// main���� processing�� getRequest�� �ҷ��ִϱ�, ���⼭ thread �����ϰ� thread�� type casting ���ش�.
		ThreadPoolExecutor pool = (ThreadPoolExecutor)threadPool;
		
		try{
			System.out.println("Get request in Processing.");
			System.out.println(request);
			threadPool.execute(new thread_cast(request));					

			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}

class thread_cast implements Runnable{
	private String request;
	private Gson gson = new Gson();
	private Request req;
	public thread_cast(String req){
		this.request = req;
	}
	
	@Override
	public void run(){
		try{
			req = gson.fromJson(request, Request.class);
			System.out.println("After change : " + req.getIp());
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}