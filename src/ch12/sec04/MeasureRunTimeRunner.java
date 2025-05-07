package ch12.sec04;

public class MeasureRunTimeRunner {

	public static void main(String[] args) {

		long time1 = System.currentTimeMillis();

		int sum1 = 0;

		for (int i = 1; i <= 100000000; i++) {
			sum1 += i;
		}

		long time2 = System.currentTimeMillis();

		System.out.println("sum1");
		System.out.println(time2 - time1);

	}

}
