package dayfour;

/**
 * 
 * -- large, complex, long-start-up-time, memory-intensive components
 * 		-- &&&& don't need more than one 
 * -- stateless component: doesn't store state
 * -- stateful component: store some data about an object (multiple instances) 
 * Singleton - initialize/store only 1 instance of this component
 * 
 * -- private constructor
 * -- a way to access the instance
 *
 * -- ThreadPool (pool of threads awaiting work to do)
 * -- Database Connection Pools (pool DB connections waiting for stuff to do)
 * -- Controllers, Services, Data Access Objects, stateless software components
 *
 */
public class SingletonDesignPattern {

	public static void main(String[] args) {
		//ServiceClass obj = new ServiceClass(); // will not compile
		
		LazilyLoadedSingleton one = LazilyLoadedSingleton.getInstance(); 
		LazilyLoadedSingleton two = LazilyLoadedSingleton.getInstance();
		System.out.println(one); System.out.println(two); System.out.println(one == two);
		
		EagerLoadedSingleton eOne = EagerLoadedSingleton.INSTANCE;
		EagerLoadedSingleton eTwo = EagerLoadedSingleton.INSTANCE;
		System.out.println(eOne == eTwo);
	}
	
	
}

/**
 * Lazy-loaded: Initialized precisely when it is first requested..
 * *** Race-Condition/Concurrency issues here
 * 
 */
class LazilyLoadedSingleton {
	// constant (static final) - ALL_CAPS_NAMING
	private static LazilyLoadedSingleton INSTANCE = null;
	
	// no one can create an object
	private LazilyLoadedSingleton() {
		
	}
		
	public static LazilyLoadedSingleton getInstance() {
		if(INSTANCE == null) {
			INSTANCE = new LazilyLoadedSingleton();
			return INSTANCE;
		}else {
			return INSTANCE;
		}
	}
	
}

/**
 * Eagerly-loaded: Initialize the singleton when the app starts
 * Load critical components on start-up.. everything else is lazy
 * 
 * 15-min planned maintenance window.. deploy/started within 15mins
 * You cannot eagerly load everything.. 
 */
class EagerLoadedSingleton {
	
	public static final EagerLoadedSingleton INSTANCE;
	
	// static block: executes when the class is loaded (class load into the JVM)
	// called before the constructor even.. 
	// NO CHANCE of a race condition. This is called by the JVM itself
	static {
		INSTANCE = new EagerLoadedSingleton();
		// multiple lines of code
	}
	
	private EagerLoadedSingleton() {
		
	}
	
}










