package random;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Randomize {
	public static void main(String[] args) {
		String[] stormers = { "Mya", "Elizabeth", "Daniel", "Sean", "Erika", "Steven", "Kathy" };
		LinkedList<String> list = new LinkedList<>(Arrays.asList(stormers));
		Collections.shuffle(list);

		for (int i = 0; i < stormers.length; i++) {
			String string = list.pop();
			System.out.println(string);
		}
	}
}
