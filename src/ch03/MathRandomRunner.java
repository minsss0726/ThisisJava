package ch03;

public class MathRandomRunner {

	public static void main(String[] args) {
		int coin  = (int)(Math.random() * 2);
		
		if (coin == 0 ) {
			System.out.println("front");
		} else {
			System.out.println("back");
		}

	}

}
