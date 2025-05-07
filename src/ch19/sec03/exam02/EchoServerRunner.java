package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerRunner {
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

	private static void startServer() throws Exception {
		Thread thread = new Thread() {

			@Override
			public void run() {

				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[Server] Starting Server");

					while (true) {
						System.out.println("Waiting Server Conneting...");
						Socket socket = serverSocket.accept();

						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[Server] Server Accept Connectin to " + isa.getHostString());

						DataInputStream dis = new DataInputStream(socket.getInputStream());

						String message = dis.readUTF();

						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						System.out.println("[Server] Sent Data " + message);

						socket.close();
						System.out.println("[Server] " + isa.getHostString() + " is not Connecting");
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			}
		};
		thread.start();
	}

}
