package ch06.car;

public class Car {

	static String country = "South_Korea"; // 정적 변수로 객체 생성 없이 사용 가능. 정적 변수는 메모리를 하나만 사용하기에 값이 한번 바뀌면 모든 객체가 바뀐 값을 씀.
	static final String country_code = "82";
	String company = "Kia";
	String model;
	String color;
	int maxSpeed;

	int gas;

	// static 블럭은 코드 최초 실행 시 동시에 실행. 아두이노의 셋업과 같은 개념.
	static {
		country = "South_Korea"; // 정적 변수만 사용 가능
		System.out.println("Set Static");
	}

	// 인자 수가 다른 생성자
	public Car(String model, String color, int maxSpeed) {
		super();
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}

	public Car(String model) {
		super();
		this.model = model;
	}

	public Car(String model, String color) {
		super();
		this.model = model;
		this.color = color;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}

	public boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("no Gas");
			return false;
		}
		System.out.println("Gas On");
		return true;
	}

	public void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("Run. Gas now:" + gas);
				gas -= 1;
			} else {
				System.out.println("Off. gas now:" + gas);
				return; // 반환값이 없는 return은 메소드를 중지시킴.
			}
		}
	}
	@Override
	public String toString() {
		return "Car [country = " + country + ", company = " + company + ", model=" + model + ", color=" + color
				+ ", maxSpeed=" + maxSpeed + "]";
	}

}
