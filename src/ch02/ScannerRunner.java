package ch02;

import java.util.Scanner;

public class ScannerRunner {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Put x : ");
		String str1 = scanner.nextLine();
		int x = Integer.parseInt(str1);
		
		System.out.println("Put y : ");
		String str2 = scanner.nextLine();
		int y = Integer.parseInt(str1);
		
		int result = x + y;
		System.out.println("result : " + result);
		
		
		while (true) {
			System.out.println("Put String : ");
			String data = scanner.nextLine();
			if (data.equals("q")) {
				break;
			}
			System.out.println("String : " + data);
		}
		
		System.out.println("END");
	}

}
