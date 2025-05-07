package ch07.sec02;

public class SmartPhone extends Phone {

	public boolean wifi;

	public SmartPhone(String model, String color) {
		super(model, color); // 부모 객체 호출
		// this.model = model;
		// this.color = color;
	}

	public void setWifi(boolean wifi) {
		this.wifi = wifi;
		System.out.println("Changed wifi");
	}

	public void internet() {
		System.out.println("Conneted internet");
	}

	@Override // annotation 표시
	public void bell() {
		System.out.println("New bell");
	}

}
