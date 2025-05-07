package ch14.sec03.exam01;

import java.awt.Toolkit;
public class BeefPrintRunner {

	// Thread 를 생성하지 않은 상태
	// 소리가 5번 울리고 난 후 print가 됨
	public static void main(String[] args) {

		Toolkit toolKit = Toolkit.getDefaultToolkit();

		for (int i = 0; i < 5; i++) {
			toolKit.beep();
			try { Thread.sleep(500); } catch(Exception e) {}
		}
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Beep");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}

	}

}
