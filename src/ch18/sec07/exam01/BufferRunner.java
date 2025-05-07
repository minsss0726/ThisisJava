package ch18.sec07.exam01;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class BufferRunner {

	public static void main(String[] args) throws Exception {

		String originalFilePath = "D:/Temp/test.jpg";
		String targetFilePath = "D:/Temp/test2.jpg";

		FileInputStream fis = new FileInputStream(originalFilePath);
		FileOutputStream fos = new FileOutputStream(targetFilePath);

		String originalFilePath2 = "D:/Temp/test3.jpg";
		String targetFilePath2 = "D:/Temp/test4.jpg";
		FileInputStream fis2 = new FileInputStream(originalFilePath2);
		FileOutputStream fos2 = new FileOutputStream(targetFilePath2);

		BufferedInputStream bis = new BufferedInputStream(fis2);
		BufferedOutputStream bos = new BufferedOutputStream(fos2);

		long nonBufferTime = copy(fis, fos);
		System.out.println("Non-Using Buffer    " + nonBufferTime);

		long bufferTime = copy(bis, bos);
		System.out.println("Using Buffer    " + bufferTime);
	}

	private static long copy(InputStream is, OutputStream os) throws Exception {
		long start = System.nanoTime();

		while (true) {
			int data = is.read();
			if (data == -1) {
				break;
			}
			os.write(data);

		}
		os.flush();
		long end = System.nanoTime();

		return end - start;
	}
}
