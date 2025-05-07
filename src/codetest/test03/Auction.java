package codetest.test03;

import java.util.Arrays;

public class Auction {

	public int[] solution(int n, int[] amounts) {
		int[] answer = new int[n];

		Arrays.sort(amounts);
		
		int max = amounts.length - 1;

		for (int i = 0; i < n; i++) {

			if (amounts[max] == amounts[max - 1]) {
				answer[i] = amounts[max];
				amounts[max] = 0;
				Arrays.sort(amounts);
			} else if (amounts[max] != 0) {
				answer[i] = amounts[max - 1] + 10000;
				amounts[max] -= amounts[max - 1] + 10000;
				Arrays.sort(amounts);
			} else {
				answer[i] = 0;
			}
			
		}

		return answer;
	}

}

