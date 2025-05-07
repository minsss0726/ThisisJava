package ch12.sec05;

import java.util.Arrays;
import java.util.Random;

public class RandomRunner {

	public static void main(String[] args) {

		int[] selectNumber = new int[6];

		Random random = new Random(3);

		for (int i = 0; i < 6; i++) {
			selectNumber[i] = random.nextInt(45) + 1;
		}

		int[] winningNumber = new int[6];

		random = new Random(5);

		for (int i = 0; i < 6; i++) {
			winningNumber[i] = random.nextInt(45) + 1;
		}

		Arrays.sort(selectNumber);
		Arrays.sort(winningNumber);

		System.out.println(Arrays.toString(selectNumber));
		System.out.println(Arrays.toString(winningNumber));

		System.err.println(Arrays.equals(selectNumber, winningNumber));

	}
}
