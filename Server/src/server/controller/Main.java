package server.controller;

public class Main {
	private static Connection connection;
	private static Processing processing;
	private static Main main;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		main = new Main();
		processing = new Processing();
		connection = new Connection();
		
		connection.connect();
	}
	
	public static void deliverToProcess(String request) {
		processing.getRequest(request);
	}

}
