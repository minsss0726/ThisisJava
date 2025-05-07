package ch07.sec08.exam02;

public class DriverRunner {

	public static void main(String[] args) {

		Driver driver = new Driver();

		driver.drive(new Vehicle());

		driver.drive(new Taxi());

		driver.drive(new Bus());

	}

}
