package codetest.test02;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
	
	public int solution (int tickets, int[][] requests) {
		int soldTickets = 0;

		Arrays.sort(requests, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] == o2[0]) {
					return o2[1] - o1[1];
				}
				return o1[0] - o2[0];
			}
		});

		for (int i = 0; i < requests.length; i++) {
			if (tickets - requests[i][1] >= 0) {
				tickets -= requests[i][1];
				soldTickets += requests[i][1];
			}
		}

		return soldTickets;
	}

}

