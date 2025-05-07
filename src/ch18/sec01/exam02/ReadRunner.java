package ch18.sec01.exam02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadRunner {
	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("D:/Temp/test2.db");

		byte[] data = new byte[100];

		while (true) {
			int num = is.read(data);
			if (num == -1) {
				break;
			}

			for (int i = 0; i < num; i++) {
				System.out.println(data[i]);
			}
		}

		is.close();
	}
}
