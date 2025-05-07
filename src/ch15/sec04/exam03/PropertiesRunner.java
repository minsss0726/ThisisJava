package ch15.sec04.exam03;

import java.util.Properties;

public class PropertiesRunner {

	public static void main(String[] args) throws Exception {
		Properties properties = new Properties();

		properties.load(PropertiesRunner.class.getResourceAsStream("database.properties"));

		String driver = properties.getProperty("driver");
		String url = properties.getProperty("url");
		String username = properties.getProperty("username");
		String password = properties.getProperty("password");

		System.out.println(driver);
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);

	}

}
