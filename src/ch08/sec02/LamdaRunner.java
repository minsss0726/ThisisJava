package ch08.sec02;

public class LamdaRunner {

	public static void main(String[] args) {

		Runable r = (a, b) -> a + b;


		System.out.println(r.run(1, 3));
	}
}
