package server.controller;

/**
 * 
 * @author lsh
 *
 */
public class Main {
	private static Processing processing;
	private static Connection connection;
	
	public static void main(String[] args) {
		processing = new Processing();
		connection = new Connection();
		connection.connect();
		String tmp;
	}

	public static void deliverToProcess(String request) {
		System.out.println(request);
		processing.getRequest(request);
	}
}
