package ch19.sec03.exam02;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class EchoClientRunner {

	public static void main(String[] args) throws Exception {

		Socket socket = new Socket("192.168.0.23", 50001);

		System.out.println("[Client] Conneting Succes");

		String sendMessage = "My name is mins";
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(sendMessage);
		dos.flush();
		System.out.println("[Client] Send Message " + sendMessage);

		DataInputStream dis = new DataInputStream(socket.getInputStream());
		String receiveMessage = dis.readUTF();
		System.out.println("[Client] Receive Message " + receiveMessage);

		socket.close();
		System.out.println("[Client] Quit Connecting");

	}

}
