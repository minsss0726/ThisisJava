package codetest.test03;

import java.util.Arrays;

public class SolutionRunner {

	public static void main(String[] args) {

		Auction auction = new Auction();

		int n1 = 4;
		int[] arr1 = { 1000000, 490000, 700000, 290000 };

		System.out.println(Arrays.toString(auction.solution(n1, arr1)));

		int n2 = 6;
		int[] arr2 = { 30000, 70000, 10000 };
		System.out.println(Arrays.toString(auction.solution(n2, arr2)));

		int n3 = 10;
		int[] arr3 = { 840000, 800000, 790000, 840000 };
		System.out.println(Arrays.toString(auction.solution(n3, arr3)));
	}

}
