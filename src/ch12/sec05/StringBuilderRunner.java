package ch12.sec05;

public class StringBuilderRunner {

	public static void main(String[] args) {

		String str = "";
		StringBuilder sb = new StringBuilder();

		// String 의 처리 시간
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			str += i;
		}

		long endTime = System.currentTimeMillis();

		System.out.println("String : " + (endTime - startTime));

		// StringBuilder 의 처리 시간
		startTime = System.currentTimeMillis();

		for (int i = 0; i < 100000; i++) {
			sb.append(i);
		}

		endTime = System.currentTimeMillis();

		System.out.println("StringBuiler : " + (endTime - startTime));
	}

}
