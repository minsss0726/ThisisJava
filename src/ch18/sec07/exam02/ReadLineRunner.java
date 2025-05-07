package ch18.sec07.exam02;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadLineRunner {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
				new FileReader("D:\\java\\mins_workspace\\thisisJAVA\\src\\ch18\\sec07\\exam02\\ReadLineRunner.java"));

		int lineNo = 1;

		while (true) {
			String str = br.readLine();
			if (str == null) {
				break;
			}
			System.out.println(lineNo + "\t" + str);
			lineNo++;
		}

		br.close();
	}

}
