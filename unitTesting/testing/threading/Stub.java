package testing.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Stub extends core.threading.Thread
{
	protected Lock mutex = null;
	protected Boolean shallWait = false;
	
	public Stub(String name) {
		super(name);
		this.mutex = new ReentrantLock();
		this.mutex.lock();
	}
	
	public Lock getMutex() {
		return this.mutex;
	}
	
	public void shallWait(Boolean shallWait) {
		this.shallWait = shallWait;
	}
	
	@Override
	protected void running() {
		while (true) {
			System.out.println("Locked");
			this.mutex.lock();
			if (this.shallWait) {
				System.out.println("Waiting...");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			this.mutex.unlock();
			System.out.println("Unlocked");
		}
	}
}