package ch06.sec04;

public class StudentRunner {

	public static void main(String[] args) {

		Student stu1 = new Student("Adam"); // 생성자

		Student stu2 = new Student("Pin");
		
		// System.out.println(stu1 == stu2);
		
		// Student stu3 = stu2; // stu2 의 번지를 저장
		
		// System.out.println(stu2 == stu3);
		

		System.out.println(stu1.name);
		System.out.println(stu2.name);

		stu1.method1(); // 메소드 호출
		System.out.println(stu2.method2()); // return 값이 있는 메소드 호출
	}
}