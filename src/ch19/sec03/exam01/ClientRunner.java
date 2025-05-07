package ch19.sec03.exam01;

import java.net.Socket;

public class ClientRunner {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("localhost", 50001);

		System.out.println("Conneting Succes");

		socket.close();
		System.out.println("Cut Connecting");

	}

}
