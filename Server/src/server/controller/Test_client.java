package server.controller;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import server.controller.message.Request;

public class Test_client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("CLIENT ");
		try {
			Socket c_socket = new Socket("http://WhatsNewsServer.iptime.org", 35002);
			Gson g = new Gson();
			Request r = new Request();
			r.setId("2013");
			r.setIp("217,0,0,1");
			r.setNewsList(null);
			r.setWantSection(null);
			String j = g.toJson(r);
			OutputStream wr = c_socket.getOutputStream();
			System.out.println(j);
			wr.write(j.getBytes());
			InputStream reader = c_socket.getInputStream();
			byte[] receiveBuffer = new byte[100];
			reader.read(receiveBuffer);

			System.out.println(new String(receiveBuffer));

			c_socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}