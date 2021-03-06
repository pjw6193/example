package dayfour;

public class MoreThreads {

	public static void main(String[] args) {
		// more concise - Java 8 (Runnable: 1 method run)
		// lambda expression:
		// (params, params) -> { method body }
		Thread thread = new Thread(() -> {   // run() method body
			while (true) {
				System.out.println("Lambda");
			}
		});
		//thread.run(); // NOT create a thread (executes in main thread)
		thread.start();

	}

}

// functional interface (Java 8 functional programming)
// 		an interface with only 1 method
// 		Lambda expression: -> notation to call a functional interface method
interface Functional {
	public int work(String param);
}
