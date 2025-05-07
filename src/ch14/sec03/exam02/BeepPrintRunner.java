package ch14.sec03.exam02;

import java.awt.Toolkit;

public class BeepPrintRunner {
	// Thread를 통한 동시 수행
	// 익명 자식 객체를 통한 생성

	public static void main(String[] args) {
		
		Thread thread = new Thread() {
			@Override
			public void run() {
				Toolkit toolKit = Toolkit.getDefaultToolkit();
				for (int i = 0; i < 5; i++) {
					toolKit.beep();
					try { Thread.sleep(500); } catch(Exception e) {}
				}
			}
		};
		
		thread.start();
		
		for (int i = 0; i < 5; i++) {
			System.out.println("Beep");
			try {
				Thread.sleep(500);
			} catch (Exception e) {
			}
		}
	}
}
