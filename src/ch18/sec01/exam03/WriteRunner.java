package ch18.sec01.exam03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WriteRunner {
	public static void main(String[] args) {
		try {
			OutputStream os = new FileOutputStream("D:/Temp/test3.db");
			// 해당되는 디렉토리에 파일 생성하고 도착지로 설정하는 출력 스트림 생성

			byte[] arr = { 10, 20, 30, 40, 50 };

			os.write(arr, 1, 3); // write 는 1 바이트씩 출력.

			os.flush();
			// OutputStream은 내부에 작은 buffer가 있음.
			// flush()는 버퍼에 남아있는 잔류 바이트를 출력하고 비우는 역할
			os.close(); // 출력 스트림이 사용하는 메모리 해제
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
