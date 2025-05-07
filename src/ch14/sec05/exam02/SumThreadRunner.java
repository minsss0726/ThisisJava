package ch14.sec05.exam02;

public class SumThreadRunner {

	public static void main(String[] args) {
		SumThread sumThread = new SumThread();
		sumThread.start();

		try {
			sumThread.join(); // SumThread run()이 종료될때까지 mainThread가 일시정지됨
		} catch (InterruptedException e) {
		}

		System.out.println("sum : " + sumThread.getSum());
	}
}
