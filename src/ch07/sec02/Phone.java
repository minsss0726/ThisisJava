package ch07.sec02;

public class Phone {

	public String model;
	public String color;

	public Phone(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	public void bell() {
		System.out.println("Ring the bell");

	}

	public void sendVoice(String message) {
		System.out.println("me : " + message);
	}

	public void receiveVoice(String message) {
		System.out.println("you : " + message);
	}

	public void hangUp() {
		System.out.println("Cut calls");
	}

	@Override
	public String toString() {
		return "Phone [model=" + model + ", color=" + color + "]";
	}
}
