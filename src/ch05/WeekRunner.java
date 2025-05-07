package ch05;

import java.util.Calendar;

public class WeekRunner {

	public static void main(String[] args) {
		
		Week today = null; // enum (열거) 도 선언 가능.
		
		Calendar cla = Calendar.getInstance(); // calendar 객체 생성 후 번지 설정. new로 하지 않음.
		
		int week = cla.get(Calendar.DAY_OF_WEEK);
		
		switch (week) {
		case 1:	today = Week.SUNDAY;	break;
		case 2:	today = Week.MONDAY;	break;
		case 3:	today = Week.TUSEDAY;	break;
		case 4:	today = Week.WEDNESEDAY;	break;
		case 5:	today = Week.THURSDAY;	break;
		case 6:	today = Week.FRIDAY;	break;
		case 7:	today = Week.SATURDAY;	break;
		}
		
		if (today == Week.SUNDAY) {
			System.out.println("Today is SUNDAY");
		} else {
			System.out.println("NOT SUNDAY :(");
		}

	}

}
