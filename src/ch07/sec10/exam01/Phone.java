package ch07.sec10.exam01;

public abstract class Phone {

	String owner;

	Phone(String owner) {
		this.owner = owner;
	}

	void turnOn() {
		System.out.println("Turn On");
	}

	void turnOff() {
		System.out.println("Turn Off");
	}

}
