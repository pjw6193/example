package daythree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * java.util - likely to not be thread-safe
 * java.util.concurrent - https://docs.oracle.com/javase/7/docs/api/java/util/concurrent/package-summary.html
 * 
 * 
 * List - ordered
 * 		ArrayList
 * 		LinkedList
 * 		Vector (thread-safe)
 * 		Stack 
 * 		
 * Set - no duplicates (dupes)
 * 		HashSet (unordered, unsorted)
 * 		TreeSet (sorted)
 * 		LinkedHashSet (ordered)
 * 
 * Queue - FIFO (first-in first-out) 
 * 		LinkedList (ordered)
 * 		PriorityQueue (sorted)		
 * 
 * Deque - LIFO (last-in first-out) like a Stack
 * 		LinkedList (ordered)
 * 		ArrayDeque (ordered)
 * 
 * Map
 * 		HashMap (unordered, unsorted)
 * 		TreeMap (sorted by key)
 * 		LinkedHashMap (ordered by key)
 * 		Hashtable (unordered, unsorted, thread-safe)
 *
 */
public class CollectionsClasses {

	public static void main(String[] args) {
		//Collection coll = new Collection(); // abstract
		
		// unique elements, no duplicates (by way equals method)
		new TreeSet();// sorted
		new LinkedHashSet(); // ordered
		
		Set<Person> peeps = new HashSet(); // unordered, unsorted
		Person one = new Person("Dan", 10);
		Person two = new Person("Howie", 20);
		peeps.add(one); peeps.add(two);
		System.out.println(peeps);
	
		// key, value
		Map<String, String> dictionary = new HashMap<>();
		dictionary.put("pickle", "vegetable brined in vinegar");
		System.out.println(dictionary.get("pickle"));
		for(String key : dictionary.values()) {}
	}
	
}

class Person {
	
	private String name;
	private int height;
	
	public Person(String name, int height) {
		super();
		this.name = name;
		this.height = height;
	}

	// implement hashCode/equals
	@Override
	public boolean equals(Object obj) {
		Person p = (Person) obj;
		if(this.name.equals(p.name)) {
			// check the other fields
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		// reduce the search time
		// utilize the fields to generate the most unique code possible
		return height * name.hashCode();
	}
	
}

class Flask {
	
	private int id;
	private String label;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((label == null) ? 0 : label.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flask other = (Flask) obj;
		if (id != other.id)
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	
	
	
}




