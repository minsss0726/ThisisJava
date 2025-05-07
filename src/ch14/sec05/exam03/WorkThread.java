package ch14.sec05.exam03;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorkThread extends Thread {

	public boolean work = true;

	LocalDateTime now = LocalDateTime.now(); // 현재 날짜 및 시간
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	public WorkThread(String name) {
		super();
		setName(name);

	}

	@Override
	public void run() {
		super.run();
		while (true) {
			if (work) {
				now = LocalDateTime.now();
				System.out.println(getName() + " Working  " + now.format(formatter));
			} else {
				Thread.yield(); // thread 를 실행 대기 상태로 보냄.
			}
		}
	}

}

