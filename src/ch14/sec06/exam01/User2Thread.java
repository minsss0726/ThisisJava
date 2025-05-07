package ch14.sec06.exam01;

public class User2Thread extends Thread {
	private Calculator calculator;

	public User2Thread() {
		super();
		setName("User2Thtread");
	}

	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}

	@Override
	public void run() {
		super.run();
		calculator.setMemory2(50);
	}

}
