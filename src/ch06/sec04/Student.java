package ch06.sec04;

public class Student {
	
	String name; // 필드. 객체가 가지고 있는 값.
	
	// 생성자. return 타입이 존재하지 않으며 class와 이름이 같음.
	public Student(String name) {
		super();
		this.name = name;
	}

	// return 값이 존재하지 않는 메소드
	void method1() {
		String name = null; // 지역변수. {} 다락 안에서만 존재 및 사용 가능.
		System.out.println(name);
		System.out.println(this.name); // 필드 출력 this.
	}
	
	// return 값이 존재하는 메소드
	String method2() {
		return this.name; // 필드 출력. 지역변수가 없으면 필드로 인식
	}
	
}
