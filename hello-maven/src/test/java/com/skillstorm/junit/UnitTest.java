package com.skillstorm.junit;

import static org.junit.Assert.*; // static methods without referencing the class name
import org.junit.Test;

import com.skillstorm.maven.Calculator;

// Maven runs any test (src/test/java) that matches the pattern *Test.java
// Unit test is developer's job. Unit test is small scope: method inputs return the right output
// code coverage: if, loops, "branch" you test with inputs that hit all the branches
public class UnitTest { // end all test class with "Test"

	@Test
	public void testMethod() {
		System.out.println("Test method");
	}
	
	@Test
	public void addTest() {
		// boundary   0-120  -1 0 1    ->  119 120 121
		// postivite -> input that makes sense
		// negative -> invalid input
		// equivalence class partitioning -> 
			// purchase restricted items: 18+, 21+, any age (3 classes)
			// any difference between 15 16 tobacco? 17 18 19
		
		// Assert class: assert that some expected value returned (T/F)
		// 0+0
		assertEquals(0, Calculator.add(0, 0)); // expected == actual
		assertEquals(10, Calculator.add(7, 3)); 
	}
	
	@Test // returns void, no parameters, public
	public void reverseTest() {
		String expected = "dlroW olleH";
		StringBuilder sb = new StringBuilder("Hello"); 
		assertEquals(true, sb.equals(new StringBuilder("Hello")));
		assertEquals(expected, Calculator.reverse("Hello World"));
		assertEquals(12.595, 12.594, 0.002); // methods without delta param are deprecated
	}
	
	
	
	
	
}
