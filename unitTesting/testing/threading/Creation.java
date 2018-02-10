package testing.threading;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Creation {
	protected Stub stub = null;

	@Test
	void create() {
		
		Thread.State state = Thread.State.NEW;
		
		// Constructor
		final String name = "Stub";
		stub = new Stub(name);
		assertEquals(stub.getName(), name);
		assertEquals(stub.getState(), Thread.State.NEW);
		// Create
		stub.create(null);
		assertEquals(stub.getState(), Thread.State.NEW);
		// Initialize
		stub.initialize(null);
		assertEquals(stub.getState(), Thread.State.NEW);
		// Startup
		stub.startup(null);
		suspend(200);
		assertEquals(stub.getState(), Thread.State.RUNNABLE);
		suspend(100);
		// Lock		
		assertEquals(stub.getState(), Thread.State.WAITING);
		// Unlock
		stub.getMutex().unlock();
		suspend(100);
		assertEquals(stub.getState(), Thread.State.RUNNABLE);
		// Wait
	//	stub.shallWait(true);
	//	try {
	//		Thread.sleep(500);
	//	} catch (InterruptedException e) {
	//		System.out.println(e);
	//	}
	//	state = stub.getState();
	//	assertEquals(stub.getState(), Thread.State.WAITING);
	//	stub.notify();

	//	state = stub.getState();
		
		
	//	assertEquals(stub.getState(), Thread.State.RUNNABLE);
		
		
		
		// Shutdown
	}
	
	static private void suspend(Integer counts) {
		for (Integer counter = 0; (counter < counts); counter++) {
		}
	}
}
