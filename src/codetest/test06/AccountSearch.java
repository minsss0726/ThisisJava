package codetest.test06;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AccountSearch {

	public int[] solution(String[] nums) {

		ArrayList<String> accounts = new ArrayList<>();
		ArrayList<ArrayList<Integer>> accounts_split = new ArrayList<>();
		


		Run: for (String num : nums) {
			if (num.endsWith("-")) {
				continue Run;
			}
			String[] num_split = num.split("-");
			if (num_split.length < 5) {
				int count = 0;
				for (String str : num_split) {
					if (str.equals("")) {
						continue Run;
					}
					for (int i = 0; i < str.length(); i++) {
						if (str.charAt(i) < 48 || str.charAt(i) > 57) {
							continue Run;
						}
					}
					count += str.length();
				}
				if (count < 11 || count > 14) {
					continue Run;
				}

				ArrayList<Integer> split_length = new ArrayList<>();

				for (String str : num_split) {
					split_length.add(str.length());
				}
				accounts_split.add(split_length);
				accounts.add(num);
				count = 0;
			}
		}

		Map<ArrayList<Integer>, Integer> rank_check = new HashMap<>();

		for (int i = 0; i < accounts_split.size(); i++) {
			if (rank_check.containsKey(accounts_split.get(i))) {
				rank_check.put(accounts_split.get(i), rank_check.get(accounts_split.get(i)) + 1);
			} else {
				rank_check.put(accounts_split.get(i), 1);
			}
		}

		int[] rank = rank_check.values().stream().mapToInt(Integer::intValue).toArray();

		int[] answer = new int[rank.length];
		
		int max = Integer.MIN_VALUE;
		int index = 0;

		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				if (rank[j] > max) {
					max = rank[j];
					index = j;
				}
			}
			answer[i] = max;
			max = Integer.MIN_VALUE;
			rank[index] = Integer.MIN_VALUE;
		}

		return answer;
	}

}
