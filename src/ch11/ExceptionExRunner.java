package ch11;

public class ExceptionExRunner {

	public static void main(String[] args) throws Exception {

		System.out.println("Start");
		
		int a = 3;
		int b = 0;
		int[] arr = { 1, 2, 3 };

		try {
			// int c = a / b; // ArithmeticException
			// System.out.println(arr[3]);
		} catch (ArithmeticException e) {
			System.out.println(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			e.printStackTrace();
		} finally {
			System.out.println("End");
		}

		test();

	}

	public static void test() throws Exception {
		try {
			Class.forName("java.util.String");
		} catch (Exception e) {
		}
	}
}
