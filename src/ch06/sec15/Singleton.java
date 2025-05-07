package ch06.sec15;

public class Singleton {
	private static Singleton singleton = new Singleton(); // private 정적 필드 전선와 초기화. singleton의 번지 값을 저장하는 것. 메모리에서 최초
															// 실행시에만 로드 됨.

	// private 접근자 권한 생성자 선언
	private Singleton() {

	}

	// public 권한을 갖는 정적 메소드 선언. 이 메소드를 통해서만 singleton 객체를 선언할 수 있음. singleton 의 번지
	// 값을 리턴
	public static Singleton getInstance() {
		return singleton;
	}
}
