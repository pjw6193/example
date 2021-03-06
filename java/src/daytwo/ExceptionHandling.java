package daytwo;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandling {
	// division by zero, array index out of bounds, null pointer (unchecked)

	public static void main(String[] args) {
		System.out.println("main(String[])");
		
			try {
				code(null);
			} 
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		System.out.println("main(String[])");
		System.out.println("Continue on..");
	}

	private void tryCatch() {
		// IOException - FileNotFoundException
		try {
			// code that might throw an exception
		} catch (Exception e) {
			// recovery procedures:
			// connect over a network? retry every 5s, timeout 60s
			// log..
		}
	}

										// throws declaration - "duck" an exception
	// throws will shift the responsibility of handling the exception DOWN the call stack
	private static void code(String str) throws FileNotFoundException, IOException { // explicit
		System.out.println("code(String)");
		// null check
		if (str == null) {
			// halt execution and handle this exception
			// throw will create an exception, and try/catch will handle that exception
			// throw new IllegalArgumentException("String cannot be null"); // RuntimeException (unchecked exception)
			throw new IOException(); // Exception (checked exception) 
		}
		if(str != "value") {
			throw new FileNotFoundException();
		}
		System.out.println("code(String) after exception");
	}

	private int divide(int x, int y) {
		if (y == 0) {
			return 0;
		}
		return x / y;
	}

}
