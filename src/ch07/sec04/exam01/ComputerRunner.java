package ch07.sec04.exam01;

public class ComputerRunner {

	public static void main(String[] args) {

		int r = 10;
		
		Calculator calculator = new Calculator();
		System.out.println("Circle Area : " + calculator.areaCircle(r));
		System.out.println();
		
		Computer computer = new Computer();
		System.out.println("Circle Area : " + computer.areaCircle(r));
		System.out.println();
		computer.game();

		Calculator cal2 = computer; // 자동 형변환
		System.out.println("Circle Area : " + cal2.areaCircle(r)); // Computer 객체로 형변환 되었기 떄문에 Computer안에 메소드 실행.
		// cal2.game(); Computer로 형변환 되었지만 cal2의 타입이 Calculator라 game 메소드는 실행되지 않음.

	}

}
