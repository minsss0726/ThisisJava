package ch18.sec06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class CharacterConvertStreamRunner {

	public static void main(String[] args) throws Exception {
		write("Running Convert String");
		String data = read();
		System.out.println(data);

	}

	private static String read() throws Exception {
		InputStream is = new FileInputStream("D:/Temp/test.txt");
		Reader reader = new InputStreamReader(is, "UTF-8");
		char[] data = new char[100];
		int num = reader.read(data);
		reader.close();
		String str = new String(data, 0, num);
		return str;
	}

	private static void write(String str) throws Exception {
		OutputStream os = new FileOutputStream("D:/Temp/test.txt");
		Writer writer = new OutputStreamWriter(os, "UTF-8");

		writer.write(str);
		writer.flush();
		writer.close();

	}

}
