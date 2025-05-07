package ch12.sec05;

public class WrapperRunner {

	public static void main(String[] args) {

		Integer obj = 100; // boxing

		int value = obj; // unboxing

		int result = obj + 100; // 연산 시 unboxing

		System.out.println(get("str", 23)); // 23 이 Object에 맞게 자동 형변환 됨

	}

	public static String get(String str, Object obj) {
		return str + obj;
	}
}
