package ch18.sec01.exam01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadRunner {

	public static void main(String[] args) throws IOException {

		InputStream is = new FileInputStream("D:/Temp/test1.db");

		while (true) {
			int data = is.read();

			if (data == -1) {
				break;
			}
			System.out.println(data);
		}
		
		is.close();

	}

}
