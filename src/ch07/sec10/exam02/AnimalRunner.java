package ch07.sec10.exam02;

public class AnimalRunner {

	public static void main(String[] args) {

		Dog dog = new Dog();
		dog.sound();

		Cat cat = new Cat();
		cat.sound();

		animalSound(new Dog());
		animalSound(new Cat());
		
		// 익명 자식 개체
		Animal animal = new Animal(){
			@Override
			public void sound() {
				System.out.println("jackjack");
			}
		};
		
		// 익명 객체에 다형성 적용. 위와 다른 형태지만 처리 및 결과는 같음
		animalSound(new Animal() {
			@Override
			public void sound() {
				System.out.println("yee");
			}
		});
	}

	private static void animalSound(Animal animal) {
		animal.sound();

	}

}
