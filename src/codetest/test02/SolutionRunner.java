package codetest.test02;

public class SolutionRunner {

	public static void main(String[] args) {
		Solution case1 = new Solution();
		
		System.out.println(case1.solution(10, new int[][] { { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } }));

		System.out.println(case1.solution(8, new int[][] { { 1, 9 }, { 3, 6 }, { 2, 5 } }));

		System.out.println(case1.solution(20000, new int[][] { { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } }));
	}

}
