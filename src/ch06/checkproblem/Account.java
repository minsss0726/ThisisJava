package ch06.checkproblem;

public class Account {

	private String[][] account = new String[100][3];
	private String account_number = "";
	private String name = "";
	private String money = "0";

	private int count = 0;

	public Account(String account_number, String name, String money) {
		super();
		this.account_number = account_number;
		this.name = name;
		this.money = money;
	}

}
