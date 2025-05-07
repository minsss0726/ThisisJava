package ch05;

import java.util.Arrays;

public class StringMethodRunner {

	public static void main(String[] args) {
		String str1 = "Hello"; // String 은 immutable. 한번 저장된 값은 바뀔 수 없음.
		
		System.out.println(str1.replace("l","a"));  // String method는 리턴값만 잇음. str1에 값 변화 X
		
		System.out.println(str1.substring(0,2)); // endIndex 는 포함되지 않음.		
		System.out.println(str1.substring(3));		
		System.out.println(str1.substring(1,4));
		
		String str2 = "Number,Title,Main,Name";
		
		String[] str2_split = str2.split(",");
		
		System.out.println(Arrays.toString(str2_split));

	}

}
