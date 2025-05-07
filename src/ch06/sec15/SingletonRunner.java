package ch06.sec15;

public class SingletonRunner {

	public static void main(String[] args) {
		Singleton obj1 = Singleton.getInstance(); // 메소드를 통한 간접 객체 선언
		Singleton obj2 = Singleton.getInstance();

		// 한 개만 존재하는 객체이므로 singleton 간접 객체는 번지가 다 동일하다.
		if ( obj1 == obj2 ) {
			System.out.println("same singleton object");
		} else {
			System.out.println("different singleton object");
		}
	}

}
