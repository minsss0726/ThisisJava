package ch12.sec04;

import java.util.Properties;
import java.util.Set;

public class GetPropertiesRunner {

	public static void main(String[] args) {

		String osName = System.getProperty("os.name");
		String userName = System.getProperty("userName");
		String userHome = System.getProperty("userHome");

		System.out.println(osName);
		System.out.println(userName);
		System.out.println(userHome);

		System.out.println("------------------");

		Properties props = System.getProperties();
		Set keys = props.keySet();

		for (Object objkey : keys) {
			String key = (String) objkey;
			String value = System.getProperty(key);
			System.out.printf("%-40s: %s\n", key, value);
		}
	}

}
