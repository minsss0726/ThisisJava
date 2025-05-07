package ch05;

import java.util.Arrays;

public class BasicArrayRunner {

	public static void main(String[] args) {
		String[] str1 = new String[]{"a","b"};
		System.out.println(Arrays.toString(str1));
		
		String[] str2 = new String[3]; // 배열의 길이를 선언하거나 초기 상태를 설정해야한다. 참조 : line14
		System.out.println(Arrays.toString(str2)); // String 배열의 초기값은 null
		
		Integer[] int1 = new Integer[]{1 ,1 , 1};
		System.out.println(Arrays.toString(int1));
		
		Integer[] int2 = new Integer[3];   // Integer 배열의 초기값은 null
		System.out.println(Arrays.toString(int2));
		
		int[] int3 = new int[3];   // int 의 초기값은 0
		System.out.println(Arrays.toString(int3));
		
		arrayTest(new int[]{0,0,0});
		
		int[][] int4 = new int[][]{ {0,0} , {0,0} };
		
		int[][] int5 = new int[][]{ {0,0} , {0,0} , {0,0,0,0} }; // 다차원이 배열 안의 배열의 길이는 다를 수 있다.
		System.out.println(int5.length);
		System.out.println(int5[1].length);
		System.out.println(int5[2].length);
		
		String[] str3 = new String[5];
		
		System.arraycopy(str1, 0, str3, 0, str1.length); // 배열 복사
		for (String str:str3) {
			System.out.print(str+" ");
		}
		System.out.println();
		
		int[] int6 = Arrays.copyOf(int3, 5); // 배열 복사 2
		System.out.println(Arrays.toString(int6));
		
	}
	
	
	public static void arrayTest(int[] i) {
		System.out.println("done");
	}
}


