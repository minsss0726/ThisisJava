package ch19.url;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class UrlRunner {

	public static void main(String[] args) {
		/***
		 * 웹상의 주소(URL)로 요청 후 응답받은 데이터(html,json,text...)를 응답받아 콘솔에 출력
		 */

		URL url = null;
		BufferedReader br = null;

		try {
			url = new URL("https://work24.go.kr/cm/main.do");

			br = new BufferedReader(new InputStreamReader(url.openStream()));
			String readLine = "";


			while ((readLine = br.readLine()) != null) {
				System.out.println(readLine);
			}

			String text = "김민중";
			String text2 = URLEncoder.encode(text);
			System.out.println(text2);
			String text3 = URLDecoder.decode(text2);
			System.out.println(text3);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}

	}

}
