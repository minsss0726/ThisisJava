package ch07.sec08.exam01;

public class CarRunner {

	public static void main(String[] args) {
		
		Car myCar = new Car();
		
		// tire 의 객체에 따라 실행 메세지가 다름.
		myCar.tire = new Tire();
		myCar.run();

		myCar.tire = new HankookTire();
		myCar.run();

		myCar.tire = new KumhoTire();
		myCar.run();

	}

}
