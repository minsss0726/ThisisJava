package ch12.sec05;

import java.text.DecimalFormat;

public class DecimalRunner {

	public static void main(String[] args) {

		double a = 10000000.123231;

		DecimalFormat df = new DecimalFormat("#,###.0");

		System.out.println(df.format(a));

	}

}
