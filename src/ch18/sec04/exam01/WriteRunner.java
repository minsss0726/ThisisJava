package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteRunner {
	public static void main(String[] args) throws IOException {
		Writer writer = new FileWriter("D:/Temp/test.txt");

		char a = 'a';
		writer.write(a);

		char b = 'b';
		writer.write(b);

		char[] arr = { 'c', 'd', 'e' };
		writer.write(arr);

		writer.write("fgh");

		writer.flush();
		writer.close();
	}
}
