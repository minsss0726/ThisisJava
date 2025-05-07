package ch06.car;

public class CarRuuner {

	public static void main(String[] args) {

		Car car1 = new Car("Avante", "Blakc", 283); // 생성자의 파라미터와 동일해야 함
		Car car2 = new Car("Ray", "Blue");
		Car car3 = new Car("Ray");

		System.out.println(car1.toString());
		// System.out.println(car2.toString());
		// System.out.println(car3.toString());

		car1.setGas(10);
		if (car1.isLeftGas()) {
			System.out.println("Start");

			car1.run();

		}
		System.out.println("Charge Gas");
	}

}