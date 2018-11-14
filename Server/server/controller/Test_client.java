
package server.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import server.controller.message.Request;
import sun.net.www.http.HttpClient;

public class Test_client {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("CLIENT ");
		try {
			URL url = new URL("http://localhost:8080/Server/index.jsp");
			//URL url = new URL("http://WhatsNewsServer.iptime.org:35001/Server/index.jsp");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setConnectTimeout(3000);
			OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream());
			String str, receiveMsg;

			osw.write("exec=run&msg=실행하기&client=접속자1");
			//osw.write("exec=no&msg=없음&client=접속자2");
			//osw.write("msg=send msg");
			osw.flush();
			if (conn.getResponseCode() == conn.HTTP_OK) {
				InputStreamReader tmp = new InputStreamReader(conn.getInputStream(), "UTF-8");
				BufferedReader reader = new BufferedReader(tmp);
				StringBuffer buffer = new StringBuffer();
				/*while ((str = reader.readLine()) != null) {
					buffer.append(str);
				}*/
				buffer.append(reader.readLine());
				receiveMsg = buffer.toString();
				System.out.println(receiveMsg);
			} else {
				System.out.print("통신 결과" + conn.getResponseCode() + "에러");
			}

			// HttpClient client = HttpClient.New(url);

			// Socket c_socket = new Socket("WhatsNewsServer.iptime.org", 35001);
			/*
			 * HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			 * conn.setRequestMethod("GET"); conn.setConnectTimeout(3000);
			 * conn.setReadTimeout(3000); conn.setRequestProperty("Content-Type",
			 * "text/html"); conn.setDoOutput(true);
			 * 
			 * Gson g = new Gson(); Request r = new Request(); r.setId("2013");
			 * r.setIp("217,0,0,1"); r.setNewsList(null); r.setWantSection(null); String j =
			 * g.toJson(r); DataOutputStream wr = new
			 * DataOutputStream(conn.getOutputStream()); wr.writeBytes(j); wr.close(); //
			 * OutputStream wr = c_socket.getOutputStream(); // System.out.println(j); //
			 * wr.write(j.getBytes()); // HttpRequet h // InputStream reader =
			 * c_socket.getInputStream(); byte[] receiveBuffer = new byte[1000]; //
			 * reader.read(receiveBuffer);
			 * 
			 * System.out.println(new String(receiveBuffer)); conn.disconnect();
			 */
			// c_socket.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
