package dayone;

import java.io.Serializable;

public class Jungle {
	public static void main(String[] args) {
		Animal lion = new Lion();
		lion.move();
		Cloneable c = (Cloneable) lion;
		Hunter hunter = new Lion(); // new Shark(); new Human();
		hunter.hunt();
	}
}

// 100% purely-abstract (Java 8)
// define behaviors (something a class can DO) 
interface Hunter {
	public static final int number = 0; // final - cannot change the value
	public abstract void hunt();
	//public abstract void stalk();
	//public abstract void pounce();
	
	// multiple inheritance 
	public default void talk() {
		System.out.println("Talk");
	} 
}

// abstract class - partially complete class ** Generalization
// something that a class IS
abstract class Animal {
	// instance variables
	boolean isAlive; 
	
	// abstract methods
	public abstract void move(); // no body {   }
	
	// concrete methods
	public void birth() {
		this.isAlive = true;
	}
	
	public void die() {
		this.isAlive = false;
	}
}

// concrete class - 100% complete  ** Specialization
// final classes cannot be extended (last leaf in the tree of inheritance)
// marker interface (interface with no methods)
final class Lion extends Animal implements Hunter, Cloneable, Serializable {

	@Override
	public void move() {
		System.out.println("Running");
	}

	@Override
	public void hunt() {
		System.out.println("Animal Planet stuff");
	}  

		
}

// class A extends String {} // doesn't compile