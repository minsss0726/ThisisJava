package codetest.test06;

import java.util.Arrays;

public class AccountSearchRunner {

	public static void main(String[] args) {
		AccountSearch as = new AccountSearch();
		
		String[] arr1 = {"4514--234495-1","305-44-291501","1-2-34-495-8623","492134545151","623-421523-67341",
				"-5439-59639921", "6235-7X3+47-7456", "98-76-543-210", "512-73-634901", "000-999999-22555",
				"064-82-792561" };
		
		System.out.println(Arrays.toString(as.solution(arr1)));
		
		String[] arr2 = { "1-2-3-456789012", "582845-385823", "48572-39485-89012", "4-5-2-593328484", "4958-392945123-",
				"49582039415423", "7-3-7-000000000", "485723-693812", "39482746582734", "1-1-1-111111111",
				"A4944-5095-4951", "4851293412223" };

		System.out.println(Arrays.toString(as.solution(arr2)));

		String[] arr3 = { "592356=5345", "49-694-4495-64", "5923565345%" };

		System.out.println(Arrays.toString(as.solution(arr3)));

	}

}
