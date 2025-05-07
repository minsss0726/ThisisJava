package ch07.sec02;

public class SmartPhoneRunner {

	public static void main(String[] args) {

		SmartPhone myPhone = new SmartPhone("iphone13", "blue");

		System.out.println("model : " + myPhone.model);
		System.out.println("color : " + myPhone.color);

		System.out.println("wifi : " + myPhone.wifi);

		myPhone.bell();
		myPhone.sendVoice("hello");
		myPhone.receiveVoice("hello. my name is mins");
		myPhone.sendVoice("nice to meet you");
		myPhone.hangUp();

		myPhone.setWifi(true);
		myPhone.internet();

		Phone myPhone2 = new SmartPhone("iphone14", "balck"); // Phone 이 부모 클래스이므로 Phone 에 SmartPhone을 담을 수 있음.
																// SmartPhone으로 자동형변환이 이뤄짐.
																// 타입은 Phone 이지만 메소드와 필드는 SmartPhone 클래스를 참조함.
		System.out.println(myPhone2.toString());
		
		myPhone2.bell();

		// SmartPhone myPhone3 = new Phone("galaxy21","white"); SmartPhone이 자식 클래스이므로
		// 불가능 함.

		// myPhone2.internet(); myPhone2가 Phone 타입이기에 SmartPhone에 있는 메소드를 사용할 수 없음.

		// SmartPhone myPhone3 = (SmartPhone) myPhone2; // Phone 타입인 myPhone2 를
		// SmartPhone 타입으로 강제형변환 하여 넣을 수 있움. 원래 자식타입이
														// 부모타입으로 형변환된 경우에만 가능.

		Phone myPhone4 = new Phone("galaxy20", "gray");
		// SmartPhone myPhone5 = (SmartPhone) myPhone4; 이 경우에는 런타입 에러 발생. myPhone이
		// 자식타입으로 형변화된 경우가 아니기 떄문.

	}

}
