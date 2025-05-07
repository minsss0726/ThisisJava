package ch05;

import java.util.Arrays;
import java.util.Scanner;

public class CheckProblemRunner {

	public static void main(String[] args) {
		//8
		/*int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int sum = 0;
		double avg = 0d;
		int count = 0;
		
		for  ( int i = 0 ; i< array.length ; i++) {
			for ( int j = 0 ; j < array[i].length ; j ++) {
				sum += array[i][j];
				count++;
			}
		}

		avg = (double)sum / (double)count;
		
		System.out.println("sum : "+sum+" avg : "+ avg);*/
		
		//9
		Scanner scanner = new Scanner(System.in);
		
		String select = "";
		
		int students = 0;
		
		int[] scores = {};
		
		while (true) {
			
			System.out.println("------------------------------------");
			System.out.println("1.학생수 2.점수입력 3.점수리스트 4.분석 5.종료");
			System.out.println("------------------------------------");
			
			select = scanner.nextLine();
			
			
			if ("1".equals(select)) {
				System.out.println("학생 수 :");
				students = scanner.nextInt();
				scores = new int[students];
			} else if ("2".equals(select)) {
				for (int i = 0; i < students ; i++) {
					System.out.println("점수 입력:");
					scores[i] = scanner.nextInt();
				}
			} else if ("3".equals(select)) {
				System.out.println("점수리스트 : "+ Arrays.toString(scores));
			} else if ("4".equals(select)) {
				System.out.println("최고 점수 : " + Arrays.stream(scores).max().getAsInt());
				System.out.println("평균 점수 : " + Arrays.stream(scores).average().orElse(0));
			} else if ("5".equals(select)) {
				System.out.println("종료");
				break;
			}
			
		}
		
		
		
		
	}

}
