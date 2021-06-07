package dayone;

import java.util.LinkedList;
import java.util.List;

public class Zoo {

	// JVM -> main -> run() -> method()

	public static void main(String[] args) {
		// covariant variable assignment
		Mammal m = new Human();
		m.name = "Human";
		System.out.println(m.name);
		// polymorphism
		// VMI - virtual method invocation (instance methods)
		Mammal[] mam = { new Human(), new Human(), new Dog(), new Human() };
		for (Mammal mammal : mam) {
			// System.out.println(mammal.speak());
			if (mammal instanceof Dog) {
				((Dog) mammal).play();
			}else {
				System.out.println("People don't play");
			}
		}
	}

}

class Mammal {
	// access modifier (to that class only)
	private boolean hasHair;
	protected int weight; // this class, subclass (no matter of package)
	public byte version = 1;
	String name; // package-private/default/no modifier

	// covariant return type
	public Number speak() {
		System.out.println("Blblblb");
		return 10;
	}

}

// Human IS-A Mammal.. 
class Human extends Mammal {
	@Override // annotation (meta-data)
	public Double speak() {
		System.out.println("Words");
		return 11.0;
	}

}

class Dog extends Mammal {

	public Float speak() {
		System.out.println("Bark");
		return 15.0f;
	}

	public void play() {
		System.out.println("Fetch!");
	}
}