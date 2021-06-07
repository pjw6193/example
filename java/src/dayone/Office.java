package dayone;

public class Office {
	public static void main(String[] args) {
		Developer d = new Developer();
		d.setTitle("    Java Developer  ");
		System.out.println(d.getTitle());
	}
}

class Developer {
	public static final long serialVersionUID = 1L;
	private String[] languages = {"Java", "Python", "JavaScript"};
	private double salary;
	private String title; 
	private boolean onCoffeeBreak;
	
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
	
	
	// getters/setters 
	
	
}