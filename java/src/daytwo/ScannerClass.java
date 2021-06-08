package daytwo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScannerClass {
							// method scope
	public static void main(String[] args) {
		// method scope
		int num = 0;
		List elements = new ArrayList();	
		
		// InputStream - stream of binary data that can be read FROM a source  
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter some input: ");
		String input = scanner.next();
		
		System.out.print("Enter some number input: ");
	
		while(scanner.hasNextInt()) {
			int block = 0; // variable in BLOCK scope
			num = scanner.nextInt(); 
			scanner.next(); // clear out the inputstream
		}
		//block = 10; // will not compile
		// OutputStream - streaming data TO a source (file, network, console, etc.)
		System.out.println(input + " " + num); 
		scanner.close();
	}
	
}
