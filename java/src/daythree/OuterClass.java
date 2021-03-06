package daythree;

public class OuterClass {
	
	public static void main(String[] args) {
		// inner (nested) class: reference is Outer.Inner
		OuterClass.InnerClass obj = new OuterClass(). new InnerClass();
		obj.run();
		
		// static (nested) inner class: reference is Outer.Inner
		OuterClass.StaticInnerClass obj2 = new OuterClass.StaticInnerClass();
		obj2.run();
	}
	
	
	// class within a class
	class InnerClass { // Alt+Shift+R
		public void run() {
			System.out.println("Inner class running");
		}
	}
	
	// no need to instantiate the OuterClass object
	static class StaticInnerClass {
		public void run() {
			System.out.println("Static inner class running");
		}
	}
	
}
