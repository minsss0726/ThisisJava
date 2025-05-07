package ch08.sec02;

public class RemoteControlRunner {

	public static void main(String[] args) {

		RemoteControl rc;
		rc = new Television();

		rc.turnOn();

		rc = new Audio();
		rc.turnOn();

		/***
		 * 익명 구현 객체 ( 일회성 )
		 */
		RemoteControl rc2 = new RemoteControl() {
			@Override
			public void turnOn() {
				System.out.println("Turn on Radio");

			}
		};
	}

}
