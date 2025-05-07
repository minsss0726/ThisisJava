package ch05;

import java.util.Arrays;
import java.util.Collections;

public class ArraySortRunner {

	public static void main(String[] args) {
		int[] arr = {3,2,1,4,23};
		
		Arrays.sort(arr); //오름차순 정렬
		
		System.out.println(Arrays.toString(arr)); 
		String[] arr1 = {"a","b","c" };
		
		Arrays.sort(arr1, Collections.reverseOrder()); //내림차순 정렬
		System.out.println(Arrays.toString(arr1)); 
	}

}
