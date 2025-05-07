package codetest.test06;

import java.util.Arrays;

public class SolutionRunner {

	public static void main(String[] args) {

		ConvertNumber test = new ConvertNumber();

		String[] str1 = { "ZASSETE", "S4Z537B", "7_ASZEYB" };

		String[] str2 = { "2455373", "425", "373", "378" };

		System.out.println("예제 1 : " + Arrays.toString(test.solution(str1, str2)));
		System.out.println();

		String[] str3 = { "ZAZZ373" };

		String[] str4 = { "2422373", "5455373", "2455373" };

		System.out.println("예제 2 : " + Arrays.toString(test.solution(str3, str4)));
		System.out.println();

		String[] str5 = { "E3EE33E3E3" };

		String[] str6 = { "388" };

		System.out.println("예제 3 : " + Arrays.toString(test.solution(str5, str6)));
		System.out.println();

		String[] str7 = { "()Z3ASEE7_" };

		String[] str8 = { "0" };

		System.out.println("예제 4 : " + Arrays.toString(test.solution(str7, str8)));
		System.out.println();
	}

}