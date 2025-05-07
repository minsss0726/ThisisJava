package ch19.sec03.exam01;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerRuuner {
	private static ServerSocket serverSocket = null;

	public static void main(String[] args) throws Exception {

		System.out.println("------------------------------------");
		System.out.println("if close server, press Q and Enter");
		System.out.println("------------------------------------");

		startServer();

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String key = scanner.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();
		stopServer();

	}

	private static void stopServer() throws Exception {
		serverSocket.close();
		System.out.println("Server Closed");

	}

	private static void startServer() throws Exception{
		Thread thread = new Thread() {
		
		@Override
			public void run() {
				
			try {
					serverSocket = new ServerSocket(50001);
					System.out.println("Starting Server");

					while (true) {
						System.out.println("Waiting Server Conneting...");
						Socket socket = serverSocket.accept();

						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("Server Accept Connectin to " + isa.getHostString());

						socket.close();
						System.out.println(isa.getHostString() + " is not Connecting");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				
			}
		};
		thread.start();
	}

}
