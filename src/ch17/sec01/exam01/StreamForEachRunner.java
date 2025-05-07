package ch17.sec01.exam01;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class StreamForEachRunner {

	public static void main(String[] args) {

		Set<String> set = new HashSet<>();

		set.add("mins");
		set.add("adam");
		set.add("ranga");

		Stream<String> stream = set.stream(); // Stream class 자체가 요소 값을 하나씩 흘러가게끔 만듦

		stream.forEach(System.out::println);
		
		set.stream().forEach(name -> System.out.println(name));
		set.stream().forEach(System.out::println);
	}

}
