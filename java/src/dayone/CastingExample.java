package dayone;

public class CastingExample {

	public static void main(String[] args) {
		double dbl = 12.95;
		int x = (int) dbl; // change type to another type
		String xyz; // data type is String
		
		// overflowing
		int val = 200;
		byte bye = (byte) val;
		System.out.println(bye);
		
		B b = new B();
		// A a = (C) b; // will not compile
		
	}
	
}

class A {}
class B extends A {}
class C extends A {}