package com.skillstorm.maven;

public class Calculator {

	public static int add(int x, int y) {
		return x + y;
	} 
	
	public static int subtract(int x, int y) {
		throw new UnsupportedOperationException("I haven't implemented this yet.. ");
	}
	
	// - * /
	
	public static String reverse(String str) {
		return new StringBuilder(str).reverse().toString();
	}
	
}
