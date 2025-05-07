package ch05;

import java.util.Arrays;

public class TypeAddressRunner {

	public static void main(String[] args) {
		
		int a = 10;
		int b = a;
		
		a = 11;
		
		System.out.println(a);
		
		int[] a1 = { 1, 2, 3 };
		int[] b1 = a1;  // b1은 a1의 값이 아닌 메모리 번지를 저장. 즉 b1의 출력값은 a1이 나옴.
		
		System.out.println(Arrays.toString(b1));
		a1[0] = 4;
		System.out.println(Arrays.toString(b1));

		
		
	}

}
