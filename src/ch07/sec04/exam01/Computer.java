package ch07.sec04.exam01;

public class Computer extends Calculator {

	@Override
	public double areaCircle(double r) {
		System.out.println("Class Computer, areaCircle() ");
		return Math.PI * r * r;
	}

	public void game() {
		System.out.println("Play Game");
	}

}
