package codetest.test04;

import java.util.ArrayList;
import java.util.Scanner;

public class SolutionRunner {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		ArrayList<Account> accounts = new ArrayList<>();

		System.out.println("----------------------------------");
		System.out.println("1.계좌생성 2.계좌목록 3.예금 4.출금 5.종료");
		System.out.println("----------------------------------");

		int number;


		String account_number;
		String name;
		int money;

		String check_account = "";
		String check_name = "";

		Money: while (true) {
			System.out.println("선택 : ");
			number = scanner.nextInt();
			scanner.nextLine();

			switch (number) {
			case 1: // 계좌 생성
				System.out.println("계좌생성");
				System.out.println("----------------------------------");
				System.out.println("계좌번호 : ");
				account_number = scanner.nextLine();
				System.out.println("성함 : ");
				name = scanner.nextLine();
				System.out.println("초기 잔액 : ");
				money = scanner.nextInt();
				accounts.add(new Account(account_number, name, money));

				break;
			case 2: // 계좌 목록
				System.out.println("계좌목록");
				System.out.println("----------------------------------");
				// System.out.println(Arrays.toString(account));
				System.out.println(accounts);

				break;
			case 3: // 예금
				System.out.println("예금");
				System.out.println("----------------------------------");
				System.out.println("계좌 번호 : ");
				check_account = scanner.nextLine();
				System.out.println("예금주 : ");
				check_name = scanner.nextLine();
				System.out.println("금액 : ");
				int add_money = scanner.nextInt();

				for (int i = 0; i < accounts.size(); i++) {
					if (accounts.get(i).getAccount_number().equals(check_account)
							&& accounts.get(i).getName().equals(check_name)) {
						accounts.get(i).setMoney(accounts.get(i).getMoney() + add_money);
					}
				}

				break;
			case 4: // 출금
				System.out.println("출금");
				System.out.println("----------------------------------");
				System.out.println("계좌 번호 : ");
				check_account = scanner.nextLine();
				System.out.println("예금주 : ");
				check_name = scanner.nextLine();
				System.out.println("금액 : ");
				int deduct_money = scanner.nextInt();
				for (int i = 0; i < accounts.size(); i++) {
					if (accounts.get(i).getAccount_number().equals(check_account)
							&& accounts.get(i).getName().equals(check_name)) {
						accounts.get(i).setMoney(accounts.get(i).getMoney() - deduct_money);
					}
				}
				break;
			case 5: // 종료
				System.out.println("종료");
				System.out.println("----------------------------------");
				break Money;
			}
		}
	}
}
