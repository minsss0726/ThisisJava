package ch04;

import java.util.Scanner;

public class CheckProblemRunner {

	public static void main(String[] args) {
		
		//3
		for (int i = 1; i <= 100 ; i++ ) {
			if ( i % 3 == 0 ) {
				System.out.print(i+" ");
			}
		}
		
		//4
		int number1 = 0;
		int number2 = 0;
		
		while (number1 + number2 != 5) {
			number1 = (int)(Math.random() * 5) + 1;
			number2 = (int)(Math.random() * 5) + 1;
			System.out.println(number1 +"," +number2);
		}
		
		
		//5
		for (int x = 0 ; x < 60 ; x++) {
			for (int y = 0 ; y < 60 ; y++ ) {
				if ( (4 * x) + (5 * y) == 60 ) {
					System.out.println(x+","+y);
				}
			}
		}
		
		//6
		for (int i = 1 ; i <= 5 ; i++) {
			for (int j = 1 ; j <= i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//7
		int money1 = 0;
			
		Scanner scanner = new Scanner(System.in);
		
		String select1;
		
		while (true) {
		
			System.out.println("----------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("----------------------------");
			
			select1 = scanner.nextLine();
			
			if ("1".equals(select1)) {
				System.out.println("선택 : 예금");
				System.out.println("예금액: ");
				int money_save = scanner.nextInt();
				money1 += money_save;
			} else if ("2".equals(select1)) {
				System.out.println("선택 : 출금");
				System.out.println("예금액: ");
				int money_take = scanner.nextInt();
				if (money1 > money_take) {
					money1 -= money_take;
				} else {
					System.out.println("출금 불가");
				}
			} else if ("3".equals(select1)) {
				System.out.println("선택 : 잔고");
				System.out.println("잔고 : "+money1);
				
			} else if ("4".equals(select1)) {
				System.out.println("종료");
				break;
			}					
		}		
	}
}
