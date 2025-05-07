package ch17.sec03;

import java.util.Arrays;
import java.util.List;

public class StudentRunner {

	public static void main(String[] args) {
		
		List<Student> list = Arrays.asList(
				new Student("mins", 20), new Student("adam", 30),
				new Student("ranga",40) );
			
		double avg = list.stream().mapToInt(student -> student.getScore()) // student.getScore()로 점수를 가져와 int 화 시킴
				.average() // mapping 된 값들로 평균을 구함
				.getAsDouble(); // average 는 return 값을 얻을 수 있는 최종 연산이므로 그 값을 double 형태로 get함
		
		System.out.println("avg : " + avg);
	}
}
