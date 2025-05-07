package codetest.test01;

public class MemberShip {

	int[] periods;
	int[][] payments;
	int[] estimates;


	public int[] solution(int[] periods, int[][] payments, int[] estimates) {

		int[] answer = new int[2];

		int[] payments_sum = new int[payments.length];

		boolean[] now_vip = new boolean[periods.length];
		boolean[] next_vip = new boolean[periods.length];

		//현재 달
		for (int i = 0; i < periods.length; i++) {
			for (int j = 0; j < payments[i].length; j++) {
				payments_sum[i] += payments[i][j];
			}
		}
		
		
		for (int i = 0; i < periods.length; i++) {
			now_vip[i] = checkVip(periods[i], payments_sum[i]);
		}


		
		//다음 달
		for ( int i = 0; i < periods.length ; i++) {
			periods[i] += 1;
		}

		for (int i = 0; i < payments_sum.length ; i++) {
			payments_sum[i] = payments_sum[i] - payments[i][0] + estimates[i];
		}
		
		for (int i = 0; i < periods.length; i++) {
			next_vip[i] = checkVip(periods[i], payments_sum[i]);
		}

		for (int i = 0; i < periods.length; i++) {
			if ((now_vip[i] == false) && (next_vip[i] == true)) {
				answer[0]++;
			}
			if ((now_vip[i] == true) && (next_vip[i] == false)) {
				answer[1]++;
			}
		}
		
		return answer;
		
	}

	public boolean checkVip(int month, int payment) {
		if (month >= 60) {
			if (payment >= 600000) {
				return true;
			}
		} else if ((month >= 24) && (month < 60)) {
			if (payment >= 900000) {
				return true;
			}
		}
		return false;
	}

}

