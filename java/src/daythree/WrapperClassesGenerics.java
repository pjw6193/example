package daythree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class WrapperClassesGenerics {

	OuterClass.StaticInnerClass obj = new OuterClass.StaticInnerClass();

	public static void main(String[] args) {
		// ordered collection: maintains the insertion order (list, queue, deque)
		// sorted collections: maintains an order based sorting algorithm (natural
		// order, another order)
		// unordered, not sorted
		Set<Lion> circus = new HashSet<>();
		// sorted collection: natural order (Comparable.compareTo) OR comparator
		// (Comparator.compare)
		Set<Lion> tree = new TreeSet<>(new Lion.LionAgeComparator());
		// add anything to sorted collection: need a natural ordering (Comparable)
		tree.add(new Lion(20, 10));
		tree.add(new Lion(40, 7));
		tree.add(new Lion(10, 9));
		tree.add(new Lion(30, 11));
		System.out.println(tree);

		List<Monkey> bucket = new LinkedList<>();

	}

	public void list() {
		// array-backed (initial capacity - 10)
		Lion[] lion = new Lion[10]; // 10 elements, ran out.. 50% growth
		Lion[] lion2 = new Lion[(int) (lion.length * 1.5)];
		List<Lion> lions = new ArrayList<>();
		List<Object> datas = new ArrayList<>(1_000_000);
		// added 1mil
		datas.add(new Object()); // last one? 499_999 wasted indeces

		// ||||||||||||||||||||||||| //

		// doubly-linked - optimized for memory storage (only as much data as you need)
		List<Monkey> linked = new LinkedList<>(); // series of nodes, nodes connected by pointers/reference vars

	}

	// more flexibility with polymorphism
	public boolean search(Iterable<Lion> list) {
		for (Lion l : list) {

		}
		return false;
	}

	public void generics() {
		// primitive & complex (objects)
		int[] array;
		byte[] bytes;
		Object[] objs;
		Asdf[] asdfs;

		// collections expect Object type not primitives
		// <Asdf> <> - Generics: compile-time safety by specifying a type for
		// constructors, methods, etc.
		List<Integer> arrayList = new ArrayList<>();
		// Integer obj = arrayList.get(0);

		List<Monkey> barrel = new ArrayList<>();
		barrel.add(new Monkey());
		// barrel.add(new Lion()); // will not compile

	}

}

class Asdf {
}

// Comparable used for natural ordering (default order)
class Lion implements Comparable<Lion> {

	private int size;
	private String name;
	int age;

	public Lion() {
		// TODO Auto-generated constructor stub
	}

	public Lion(int size) {
		this.size = size;
	}

	public Lion(int size, int age) {
		this.size = size;
		this.age = age;
	}

	/**
	 * Natural ordering: compare by size
	 */
	public int compareTo(Lion other) {
		// compare this to other Lion
		// - number, before the other
		// 0 - arbitrary
		// + number, after the other
		return this.size - other.size;
	}

	@Override
	public String toString() {
		return "Lion [size=" + size + ", name=" + name + ", age=" + age + "]";
	}

	// Different options for sorting your collections
	// compare lions by age
	static class LionAgeComparator implements Comparator<Lion> {

		@Override
		public int compare(Lion one, Lion another) {
			return one.age - another.age;
		}

	}

}

class Monkey {
}
