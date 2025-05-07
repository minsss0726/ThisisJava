package ch19.sec02;

import java.net.InetAddress;

public class InetAddressRunner {

	public static void main(String[] args) throws Exception {

		InetAddress local = InetAddress.getLocalHost();
		System.out.println("My Computer's IP Address : " + local.getHostAddress());

		InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
		for (InetAddress remote : iaArr) {
			System.out.println("www.naver.com IP Address : " + remote.getHostAddress());
		}
	}

}
