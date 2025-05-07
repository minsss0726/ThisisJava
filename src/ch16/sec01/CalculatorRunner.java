package ch16.sec01;

public class CalculatorRunner {

	public static void main(String[] args) {
		
		action( (x,y) -> {
			int result = x + y;
			System.out.println(result);
		});

		action((x, y) -> {
			int result = x - y;
			System.out.println(result);
		});

	}

	private static void action(Calculator calculable) {
		int x = 10;
		int y = 5;
		
		calculable.calculate(x, y);

	}

}
