package codetest.test04;

public class Account {
	private String name;
	private String account_number;
	private int money;

	public Account(String account_number, String name, int money) {
		super();
		this.name = name;
		this.account_number = account_number;
		this.money = money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [name= " + name + ", account_number= " + account_number + ", money= " + money + "]" + "\n";
	}

}