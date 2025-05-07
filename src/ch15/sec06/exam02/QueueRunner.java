package ch15.sec06.exam02;

import java.util.LinkedList;
import java.util.Queue;

public class QueueRunner {

	public static void main(String[] args) {

		Queue<Message> messageQueue = new LinkedList<>();

		messageQueue.offer(new Message("sendMail", "mins"));
		messageQueue.offer(new Message("sendSMS", "adam"));
		messageQueue.offer(new Message("sendDM", "ranga"));

		while (!messageQueue.isEmpty()) {
			Message message = messageQueue.poll();
			switch (message.command) {
			case "sendMail":
				System.out.println("Send Mail to " + message.to);
				break;
			case "sendSMS":
				System.out.println("Send SMS to " + message.to);
				break;
			case "sendDM":
				System.out.println("Send DM to " + message.to);
				break;

			}
		}

	}

}
