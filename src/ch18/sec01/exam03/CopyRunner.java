package ch18.sec01.exam03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyRunner {

	public static void main(String[] args) throws IOException {
		String originalFileName = "D:/Temp/test.jpg";
		String targetFileName = "D:/Temp/test2.jpg";

		InputStream is = new FileInputStream(originalFileName);
		OutputStream os = new FileOutputStream(targetFileName);

		byte[] data = new byte[1024];

		while (true) {
			int num = is.read(data);
			if (num == -1) {
				break;
			}
			os.write(data, 0, num);
		}

		os.flush();
		os.close();
		is.close();

		System.out.println("Copy Completed");
	}
}
