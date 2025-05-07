package ch12.sec05;

public class StringRunner {

	public static void main(String[] args) {

		StringBuilder str1 = new StringBuilder("Hello");
		System.out.println(str1.indexOf("e")); // "e" 의 index 확인

		if (str1.indexOf("e") > -1) { // "e"가 존재하는지 확인
			System.out.println("true");
		}

		System.out.println(str1.substring(str1.indexOf("e"))); // "e" 부터 문자열 출력

		// 파일명이 깨지는 것을 방지하기 위해 파일명을 숫자로 변환
		String fileName = "2025.04.10_시간표.xlsx";
		
		String newFileName = "";
		
		newFileName = String.valueOf(System.currentTimeMillis()) + fileName.substring(fileName.lastIndexOf("."));

		System.out.println(newFileName);
	}

}
