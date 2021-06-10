package dayfour;

public class SingletonConcurrencyIssue {

	public static void main(String[] args) {
		// new Thread(() -> {}).start();
		// thread one
		new Thread(() -> {
			System.out.println(Singleton.getInstance());
		}).start();
		// thread two
		new Thread(() -> {
			System.out.println(Singleton.getInstance());
		}).start();
		
	}
	
}

/**
 * Doubleton? 
 * 
 * 	Race condition.. two threads competing for resource, variable
 * 			deadlock, dirty read, .. unintented consequence
 * 
 */
class Singleton {
	private static Singleton INSTANCE = null;
	private static Object lock = new Object(); // every Object has a monitor.. thread obtains this monitor.. has LOCK on the object

	private Singleton() {

	}

	/**
	 * Joint checking account. Both read a piece of data.. dirty read
	 * Bob: 		$1,000
	 * Sally: 		$1,000
	 * Bob: 		- $500
	 * Sally: 		$1,000
	 */
	// synchronized method: only one thread at a time can access this method
	// public synchronized static Singleton getInstance() 
	public static Singleton getInstance() { 
		// dozen, hundred lines of code... doesn't need to be synchronized. 
		 // once a thread obtains the Object's monitor, NO other thread access until the monitor is released
		// WHYY?? Minimize the amount of time spent going down to 1 thread at a time
		// 4 lanes on a highway.. 2 lanes are blocked for 1 mile stretch.. 
			// everyone changes lanes 2 miles away... 
		synchronized (lock) {
			if (INSTANCE == null) { // t1 snoozes (true) // t2 (true)
				INSTANCE = new Singleton();
				return INSTANCE; 
			} else {
				return INSTANCE;
			}
			
		} // monitor is released and available to another thread
	}
}





