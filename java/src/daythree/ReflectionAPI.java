package daythree;

import java.lang.reflect.Method;

// Reflection API, look at the class itself
public class ReflectionAPI {

	public static void main(String[] args) {
		Method[] methods = Pickle.class.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
	
}

class Pickle {
	String flavor;
	public void eat() {}
	public void brine() {}
}
