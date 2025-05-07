package ch19.sec04;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketAddress;
import java.util.Scanner;

public class NewServerRunner {
	private static DatagramSocket datagramSocket = null;

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
		datagramSocket.close();
		System.out.println("Server Closed");

	}

	private static void startServer() {
		Thread thread = new Thread() {
			
			@Override
			public void run() {
				try {
				datagramSocket = new DatagramSocket(50001);
				System.out.println("[Server] Starting Server");
				
				while ( true ) {
					DatagramPacket receivePacket = new DatagramPacket(new byte[1024],1024 );
					datagramSocket.receive(receivePacket);
					String newsKind = new String(receivePacket.getData(), 0 ,receivePacket.getLength() , "UTF-8"); 
					
					SocketAddress socketAddress = receivePacket.getSocketAddress();
					
					for (int i = 0; i <= 10 ;i++) {
						String data = newsKind + " : News " + i;
						byte[] bytes = data.getBytes("UTF-8");
						DatagramPacket sendPacket = new DatagramPacket(bytes, 0, bytes.length , socketAddress);
						datagramSocket.send(sendPacket);
						}
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		};
		thread.start();
	}

}
