package dayone;

/**
 * Classes, objects, constructors/chaining,
 * OOP (abstraction, inheritance, polymorphism, encapsulation)
 * Primitive data types, if/else**, casting, instanceof 
 *
 */
public class Office {
	public static void main(String[] args) {
		Developer d = new Developer();
	}
}

class Person extends java.lang.Object{
	String name = "Dan Pickles";
	
	// DRY = don't repeat yourself
	// WET = write everything twice
	public Person() {
		super(); // call no-arg constructor in the SUPER class
		System.out.println("Person constructor");
		// default behavior to instantiate an object..
	}
	
	public Person(String name) {
		// reuse that default behavior in the no-arg constructor
		this(); // call no-arg constructor in THIS class
		System.out.println("String-arg Person constructor");
		this.name = name;
	}
}

/**
 * Encapsulation
 * 
 * Javadoc
 * @author PWalsh
 *
 */
class Developer extends Person{
	public static final long serialVersionUID = 1L;
	private String[] languages = {"Java", "Python", "JavaScript"};
	private double salary;
	private String title; 
	private boolean onCoffeeBreak;
	
	// best practice - no-arg constructor (JavaBean specification)
	public Developer() {
		super("Dan Pickles"); // constructor chaining
		System.out.println("Developer constructor for " + name);
	}
	
	// overloading - constructors, methods) same name/different parameters 
	// initialize an object (initial state of an object) -- instantiate (new)
	public Developer(String[] languages, double salary, String title, boolean onCoffeeBreak) {
		super();
		this.languages = languages;
		this.salary = salary;
		this.title = title;
		this.onCoffeeBreak = onCoffeeBreak;
	}


	public String[] getLanguages() {
		return languages;
	}
	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	public double getSalary() {
		return salary;
	}
	// data validation
	public void setSalary(double salary) {
		if (salary < 0) {
			throw new IllegalArgumentException("Salary must be greater than zero.");
		}
		this.salary = salary;
	}
	public String getTitle() {
		return title;
	}
	// data santization
	public void setTitle(String title) {
		title = title.trim().toUpperCase();
		this.title = title;
	}
	public boolean isOnCoffeeBreak() {
		return onCoffeeBreak;
	}
	public void setOnCoffeeBreak(boolean onCoffeeBreak) {
		this.onCoffeeBreak = onCoffeeBreak;
	}
	
}
