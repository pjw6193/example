package dayfour;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Design Pattern: general approach to solving a common problem.
 * 
 * 	-- 1. problem: tight coupling
 *  -- 2. concept of the design pattern: method that returns concrete objects. Use interface as reference type.
 *  -- 3. scenarios: use at ANY coupling point. Tire, wheel, axle.. etc "clicked together"/orchestrated to build a car.
 * 
 */
public class FactoryDesignPattern {

	public static void main(String[] args) {
		Weapon primary = new Sword(); // tightly-coupled.. FactoryDesignPattern is dependent upon Sword class
		Weapon secondary = new Sword(); // every reference to Sword must be changed..
		Weapon backup = new Sword(); // Ctrl+F and update your concrete object types
		Weapon ankle = new Sword(); 
		
		Weapon looselyCoupled = WeaponFactory.newWeapon("modern"); // NO reference to concrete type
		looselyCoupled.attack();
		
		Calendar today = Calendar.getInstance(); // factory method call
		// new GregorianCalendar.. filling today's date
		GregorianCalendar tomorrow = new GregorianCalendar(); // no no no
		
	}

	
}

// Factory: create objects in a loose coupled
// Loose coupling: components are easily interchangeable, not highly-dependent upon each other
// flexibility in your applications
// concrete implementations change ... ONE place in our code is affected
class WeaponFactory {
	
	public static Weapon newWeapon(String type) {
		switch (type) {
		case "melee":
			return new Sword();
		case "modern":
			return new Rifle();
		case "alien":
			return new Needler(); // new concrete type added to options.. change in ONE place.
		default:
			throw new IllegalArgumentException("Invalid weapon option.");
		}
	} 
	
}

// sword, gun
interface Weapon{
	public void attack();
}

class Sword implements Weapon {

	public void attack() {
		System.out.println("Swish");
	}
	
}

class Rifle implements Weapon {

	public void attack() {
		System.out.println("Bang");
	}
	
}

class Needler implements Weapon {

	@Override
	public void attack() {
		System.out.println("Pew");
	}
	
}





