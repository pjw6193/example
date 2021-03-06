package daytwo;

/**
 * 
 * Javadoc comment
 * 
 * Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
 * tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
 * quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
 * consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
 * cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
 * proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
 * 
 */
public class Loops {

	public static void main(String[] args) {
		int[] array = {};

	}

	public void postProcessBeforeInitialization() {
	} // verbose

	/**
	 * This is an example of Switch-Case
	 */
	public static void switchCase(int x) {
		// char, byte, short, int, String
		String grade = "";
		int characterThatDeterminesYourGrade = 0;
		switch (grade) {
		case "A": {
			System.out.println("Got an A");
			break;
		}
		case "B": {
			System.out.println("Got an B");
			break;
		}
		case "F": {
			System.out.println("Fail");
			break;
		}
		default: {
			throw new IllegalArgumentException("Invalid case");
		}
		}

		System.out.println("Next up...");
	}

	/**
	 * Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod
	 * tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
	 * quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
	 * consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
	 * cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
	 * proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
	 */
	public static void ifElse() {
		boolean isTrue = false;
		boolean somethingElse = true; // Alt+Shift+R - refactor/rename
		if (isTrue) {
			System.out.println("If");
		} else if (somethingElse) {
			// Ctrl+Shift+F - format
			System.out.println("Else If");
		} else {
			System.out.println("Else");
		}
	}

	public static void doWhile() {
		boolean running = false;
		do {
			// always executes at least once
			System.out.println("Execute");
			running = checkValue();
		} while (running);
	}

	public static void nowhile() {
		// while loop - counter
		int counter = 0;
		while (counter < 10) {
			System.out.println("Hello");
		}
		counter++;
	}

	public static void whileloop() {
		// while - sentinel-controlled loops
		// a single value that true/false determines if loop continues
		boolean running = true;
		while (checkValue()) {
			System.out.println("Loop"); // no exit condition
		}
	}

	public static boolean checkValue() {
		// simulation
		if (Math.random() < 0.75)
			return true;
		else
			return false;
	}

	public void forloop() {
		// for - counter-controlled loop
		// fixed number of iterations
		int[] array = { 6, 3, 5, 7, 9, 4, 1 };
		Object[] objs = {};

		for (int i = 0; i < objs.length; i++) {
			//
		}

		// List list = new CopyOnWriteArrayList<>();

		// implements Iterable interface
		for (int temp : array) {
			System.out.print(temp);
		}
	}

}
