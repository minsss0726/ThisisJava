package ch07.sec10.exam01;

public class PhoneRunner {

	public static void main(String[] args) {

		SmartPhone myPhone = new SmartPhone("mins");

		myPhone.turnOn(); // Phone 클래스의 메소드 사용
		myPhone.internetSearch();
		myPhone.turnOff();
	}

}
