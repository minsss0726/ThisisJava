package ch12.sec03.exam01;

public class EqualsRunner {

	public static void main(String[] args) {

		Member o1 = new Member("blue");
		Member o2 = new Member("blue");
		Member o3 = new Member("red");

		if (o1.equals(o2)) {
			System.out.println("o1 == o2");
		} else {
			System.out.println("o1 != o2");
		}

		if (o1.equals(o3)) {
			System.out.println("o1 == o3");
		} else {
			System.out.println("o1 != o3");
		}

		System.out.println(o1);
		System.out.println(o2);
		System.out.println(o3);

	}

}
