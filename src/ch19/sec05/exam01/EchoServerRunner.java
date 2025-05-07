package ch19.sec05.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServerRunner {
	private static ServerSocket serverSocket = null;
	private static ExecutorService executorService = Executors.newFixedThreadPool(10);

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

	private static void stopServer() {
		try {
			serverSocket.close();
			executorService.shutdownNow();
			System.out.println("[Server] Server Closed");
		} catch (Exception e) {

		}
	}

	private static void startServer() {
		Thread thread = new Thread() {

			@Override
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[Server] Starting Server");
					
					while (true) {
						Socket socket = serverSocket.accept();
						
						executorService.execute(() -> {
							try {
								InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println("[Server] " +isa.getHostName() + " Accept Connecting");
								
								DataInputStream dis = new DataInputStream(socket.getInputStream());
								String message = dis.readUTF();
								
								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
								dos.writeUTF(message);
								dos.flush();
								System.out.println("[Server] send data : " + message);
								
								socket.close();
								System.out.println("[Server] Close Connecting : " + isa.getHostName());
								
						
								} catch (Exception e) {
								}
							});
						}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		};
		thread.start();
	}

}
