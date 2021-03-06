package dayfour;

public class StringClass {

	public static void main(String[] args) {
		// String pool: heap memory that stores Strings
		String word = "primitive";
		String word2 = "primitive"; // 1 object in String pool
		// both point to the same String in the String Pool
		// word = "xyz"; // new String, pointing word ref var to that String
		//System.out.println(word2); // String class: FINAL byte[] value (immutable) cannot mutated/changed
		
		String sentence = new String("Hello World");
		String sentence2 = new String("Hello World"); // 2 strings in the pool, bypasses the String pool
		
		// equality: == compares reference variables (memory location)
		System.out.println(word == word2);
		System.out.println(sentence == sentence2);
		System.out.println(sentence.equals(sentence2)); // equality: char by char 
	
		System.out.println(5 == 5);
		System.out.println(true != false);
		System.out.println(word == null); // good, does it point to a String in the pool?
		String str = null;
		//str.equals(null);
		
		StringBuilder strb = new StringBuilder("String value"); // mutable.. 
		System.out.println(reverse("Hello"));
	}
	
	public static String reverse(String str) {
		String reversed = ""; // StringBuilder 1 object in memory
		for(int i = str.length()-1; i>=0; i--) {
			reversed += str.charAt(i);
			// String pool: o, ol, oll, olle, olleH , Hello // 6 strings  
		}
		return reversed;
	}
	
	
}

/**
 * Ternary operator: ternary expression
 */
class Dan {
	String email;
	
	public int hashCode() {
		// boolean expression ? true : false // short-hand for if-else
		int result = email == null? 1 : email.hashCode(); 
		// calculation
		return result;
	}
}



















