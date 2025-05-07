package codetest.test06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertNumber {

	/*
	 * 0 - O () // 1 - I // 2 - Z // S 7_ // 3 - E B // 4 - A // 5 - Z S // 6 - B C
	 * // 7 - T Y // 8 - B E3 //9 - q p
	 * 
	 * 복수 문자 2 , 5 - Z , S // 3 , 8 - B
	 */

	ArrayList<ArrayList<String>> list = new ArrayList<>(
			Arrays.asList(new ArrayList<>(Arrays.asList("O", "()")), new ArrayList<>(Arrays.asList("I")),
					new ArrayList<>(Arrays.asList("Z", "S", "7_")), new ArrayList<>(Arrays.asList("E", "B")),
					new ArrayList<>(Arrays.asList("A")), new ArrayList<>(Arrays.asList("Z", "S")),
					new ArrayList<>(Arrays.asList("b", "G")), new ArrayList<>(Arrays.asList("T", "Y")),
					new ArrayList<>(Arrays.asList("B", "E3")), new ArrayList<>(Arrays.asList("q", "p"))));

	ArrayList<String> convert_nums = new ArrayList<>();

	public int[] solution(String[] numstrs, String[] words) {
		int[] answer = new int[words.length];

		// 중복 가능성이 있는 문자를 제외한 문자들을 숫자로 치환
		for (String numstr : numstrs) {
			for (int i = 0; i < numstr.length(); i++) {
				for (int j = 0; j < list.size(); j++) {
					if (list.get(j).contains(String.valueOf(numstr.charAt(i)))) {
						if (numstr.charAt(i) != 'Z' && numstr.charAt(i) != 'S' && numstr.charAt(i) != 'B'
								&& numstr.charAt(i) != 'E') {
							numstr = numstr.replace(String.valueOf(numstr.charAt(i)), String.valueOf(j));
						}
					}
				}
			}
			numstr = numstr.replace("7_", "2");
			numstr = numstr.replace("()", "0");

			System.out.println("우선 치환 : " + numstr);

			// 중복 금지를 체크하기 위해 만든 array 값이 0 이면 사용할 수 있고 1이면 사용할 수 없다.
			// index 위치에 따른 금지
			// 0 - 2가 S 금지
			// 1 - 2가 Z 금지
			// 2 - 5가 S 금지
			// 3 - 5가 Z 금지
			// 4- 3이 B 금지
			// 5 - 8이 B 금지
			ArrayList<Integer> locked = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));

			dfs(numstr, 0, "", new ArrayList<Integer>(locked));
			System.out.println("존재 가능한 숫자들 : " + convert_nums);
			int answer_index = 0;
			for (String word : words) {
				int isContain = (int) convert_nums.stream().filter(e -> e.contains(word)).count();
				if (isContain > 0) {
					System.out.println("포함 값 : " + word);
					answer[answer_index]++;
				}
				answer_index++;
			}
			System.out.println();
		}
		convert_nums.clear(); // 충돌 방지를 위한 리스트 초기화
		return answer;
	}

	// dfs 를 통한 탐색. 중복이 불가능한 문자열 고려해을 치환되는 모든 경우의 수를 찾음.
	// 들어온 문자열을 고려하고 index 를 통해 문자열을 앞에서 부터 하나씩 치환
	// case 를 통해 일괄적으로 dfs를 고려하도록 설계. 전체를 if문으로 사용 시 누락 발생. else if 로 처리를 줄여주면 가능.
	// 최후위 사항은 이미 숫자로 들어오는 경우를 처리
	// E 와 E3 는 다른 문자지로 보지만 시작 ch 가 E 로 동일하기에 같은 케이스에서 처리. E3의 고려사항이 더 많으므로 우선 배치
	public void dfs(String numstr, int index, String convert_numstr, ArrayList<Integer> locked) {
		if (index == numstr.length()) {
			convert_nums.add(convert_numstr);
			return;
		}

		if (numstr.charAt(index) == 'Z') {
			if (locked.get(1) == 0) {
				dfs(numstr, index + 1, convert_numstr + "2", setlocked(locked, 3));
			}
			if (locked.get(3) == 0) {
				dfs(numstr, index + 1, convert_numstr + "5", setlocked(locked, 1));
			}
		} else if (numstr.charAt(index) == 'S') {
			if (locked.get(0) == 0) {
				dfs(numstr, index + 1, convert_numstr + "2", setlocked(locked, 2));
			}
			if (locked.get(2) == 0) {
				dfs(numstr, index + 1, convert_numstr + "5", setlocked(locked, 0));
			}
		} else if (numstr.charAt(index) == 'B') {
			if (locked.get(4) == 0) {
				dfs(numstr, index + 1, convert_numstr + "3", setlocked(locked, 5));
			}
			if (locked.get(5) == 0) {
				dfs(numstr, index + 1, convert_numstr + "8", setlocked(locked, 4));
			}
		} else if (numstr.charAt(index) == 'E') {
			if (index + 1 < numstr.length() && numstr.charAt(index) == 'E' && numstr.charAt(index + 1) == '3') {
				dfs(numstr, index + 2, convert_numstr + "8", new ArrayList<Integer>(locked));
			}
			dfs(numstr, index + 1, convert_numstr + "3", new ArrayList<Integer>(locked));
		} else {
			dfs(numstr, index + 1, convert_numstr + numstr.charAt(index), new ArrayList<Integer>(locked));
		}

	}

	// 어떤 숫자가 문자를 선점하면 다른 문자는 못 쓰도록 locked 을 통해 타 숫자가 같은 문자를 쓰지 못하도록 함
	// 또한 locked 는 dfs 의 경우의 수마다 다 달라야하기에 새로 ArrayList를 갱신해 다음 dfs에 넣어줌
	public ArrayList<Integer> setlocked(ArrayList<Integer> locked, int index) {
		ArrayList<Integer> newlocked = new ArrayList<Integer>(locked);
		newlocked.set(index, 1);
		return newlocked;
	}

}
