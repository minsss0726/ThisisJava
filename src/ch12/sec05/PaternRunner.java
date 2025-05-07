package ch12.sec05;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PaternRunner {

	public static void main(String[] args) {

		String regExp = "(02|010)-\\d{3,4}-\\d{4}"; // | 는 또는, \d 는 한개의 숫자, {n} 는 n개 , {n,m} 은 n~m개
		String data = "010-123-4567";
		boolean result = Pattern.matches(regExp, data);

		System.out.println(result);

		regExp = "\\w+@\\w+\\.\\w+(\\.\\w+)?"; // \w 힌 개희 숫자 혹은 한 개의 알파벳, \. 은 . , + 는 한 개 이상
		data = "angle@mycompany.com";
		result = Pattern.matches(regExp, data);

		System.out.println(result);

		// 컴파일 가능
		Pattern p = Pattern.compile("b[a-z]*"); // b로 시작, 영문 소문자, 0개 이상;
		Matcher m = p.matcher("ball");
		System.out.println(m.matches());
		System.out.println(p.matcher("batman").matches());

		// 추출
		String source = "Hello. My name is mins. My phone Number is 010-1234-5678. And Home Number is 010-123-4567.";
		p = Pattern.compile("(0\\d{1,2})-(\\d{3,4})-(\\d{4})"); // () 그룹화
		m = p.matcher(source);
		while (m.find()) {
			System.out.println(m.group());
		}

	}

}
