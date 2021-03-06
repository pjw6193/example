package dayfour;

/**
 * Process: Eclipse, Windows, MS Teams.. large, standalone. Thread: lightweight
 * process within a process (subprocess) -- not standalone
 * 
 * Why Threads? / Multithreading? 
 * Concurrency: multiple tasks at the "same time"
 * 	apps can be faster.. asynchronous processing (long-running, don't need to
 * 	wait for a response) 
 * 
 * quad-core processor: 4 cores, each core can handle 1 process/thread at time. time-splicing..
 * 
 * Threads (a single-core): 
 * 1 --------------- 							 ------- 
 * 2 				---------- 							---- 
 * 3 						  ---------- 					-------- 
 * 4 									---------
 *
 * 
 *
 */
public class Multithreading {

	public static void main(String[] args) {
		// extend Thread
		SuperThread superThread = new SuperThread();
		
		// implements Runnable
		WorkerThread workerThread = new WorkerThread();
		Thread thread = new Thread(workerThread);
		
		superThread.start();
		thread.start(); // worker thread
		
		// anonymous inner class 
		Thread anon = new Thread( new Runnable() { // open class body
			// declaring a class right here... no-name class
			public void run() {
				while(true) {
					System.out.println("Anon class");
				}
			}
		} // end of class body 
		);
		anon.start();
		
		
	}

}

/**
 * implement Runnable
 * 	more lightweight than extending Thread
 * 	more likely to use this 
 */
class WorkerThread implements Runnable {

	@Override
	public void run() {
		while(true) {
			System.out.println("WorkerThread");
		}
	}
}

/**
 * extend Thread
 * 	override many of the thread methods
 * 	my own "version" of thread
 * 
 * 	downfall: extend 1 class
 */
class SuperThread extends Thread {
	@Override
	public void run() {
		while(true) {
			System.out.println("SuperThread");
		}
	}
}










