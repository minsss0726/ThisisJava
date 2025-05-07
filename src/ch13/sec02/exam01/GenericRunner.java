package ch13.sec02.exam01;

public class GenericRunner {

	public static void main(String[] args) {

		Product<Tv, String> product1 = new Product<>();

		product1.setKind(new Tv());
		product1.setModel("SmartTv");

		Tv tv = product1.getKind(); // 같은 객체
		String tvModel = product1.getModel();

		Product<Car, String> product2 = new Product<>();

		product2.setKind(new Car());
		product2.setModel("SUV");

		Car car = product2.getKind();
		String carModel = product2.getModel();

		System.out.println(tvModel + " " + carModel);

	}

}
