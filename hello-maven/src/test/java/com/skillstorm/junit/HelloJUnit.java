package com.skillstorm.junit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

// annotation: @Something, provides metadata on class, method, variable, parameters.. 
// JUnit: is reading your code to find these annotates, which tells JUnit what to do.
public class HelloJUnit {
	
	static java.util.Map<String, Object> testData; // fully-qualified classname, import statement not needed

	@BeforeClass // execute ONCE before ALL tests in this class
	public static void initialSetup() { // QA/SDET 'automation' testers // CSV files, databases
		System.out.println("@BeforeClass");
	}
	
	@Before // executes FOR EACH test
	public void before() {
		System.out.println("@Before"); // Transient (data)/tests: data is reset for each test
	}
	
	@Test // execute as a test
	public void test() {
		System.out.println("@Test 1");
	}
	@Test // execute as a test
	public void test2() {
		System.out.println("@Test 2");
	}
	
	@After // executes FOR EACH test
	public void after() {
		System.out.println("@After");
	}
	
	@AfterClass // execute ONCE after ALL tests in this class
	public static void teardown() { // must be static
		System.out.println("@AfterClass");
	}
	
}
