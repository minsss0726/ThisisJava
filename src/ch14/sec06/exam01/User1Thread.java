package ch14.sec06.exam01;

public class User1Thread extends Thread {
	private Calculator calculator;

	public User1Thread() {
		super();
		setName("User1Thtread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		super.run();
		calculator.setMemory1(100);
	}

}
