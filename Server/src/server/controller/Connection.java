package server.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;


import com.google.gson.Gson;

/**
 * 
 * @author lsh
 *
 */
public class Connection {
	private final int PORT = 35001;
	private final int THREAD_CNT = 1;
	private ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_CNT);

	public void connect() {
		ThreadPoolExecutor pool = (ThreadPoolExecutor) threadPool;

		try {
			ServerSocket serverSocket = new ServerSocket(PORT);
			System.out.println("SERVER START");

			while (true) {
				Socket socket = serverSocket.accept();
				try {
					threadPool.execute(new ConnectionWrap(socket));
					System.out.println(pool.getPoolSize());

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ConnectionWrap implements Runnable {

	private Socket socket = null;
	private static int i = 0;
	Gson gson = new Gson();
	
	public ConnectionWrap(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println(i++ + "'s Client Connected");
			InputStream input = socket.getInputStream();
			byte[] request = new byte[100];
			input.read(request);
			
			if (request != null) {
				System.out.println(request);
				Main.deliverToProcess(new String(request));
			}
			// OutputStream response = socket.getOutputStream();
			// response.write(new Date().toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}