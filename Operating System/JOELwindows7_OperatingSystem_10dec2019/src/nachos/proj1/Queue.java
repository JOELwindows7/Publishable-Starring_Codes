/**
 * 
 */
package nachos.proj1;

import java.util.Vector;

import nachos.threads.KThread;
import nachos.threads.ThreadQueue;

/**
 * @author JOELwindows7
 *
 */
public class Queue extends ThreadQueue{
	//add unimplemented methods
	/**
	 * 
	 */
	public Queue() {
		// TODO Auto-generated constructor stub
	}
	
	Vector<KThread> threadList = new Vector<>();

	@Override
	public void waitForAccess(KThread thread) { //using, to wait for thread access
		// TODO Auto-generated method stub
		threadList.add(thread);
	}

	@Override
	public KThread nextThread() { //using, to execute thread
		// TODO Auto-generated method stub
		if(threadList.isEmpty()) return null;
		return threadList.remove(0); //do not neglect other index of threadList!!!
		//replace get to remove. still error
		//because even thread is empty, attempted to remove that empty array. Out of range!
		//validate it! if it is empty, it return null, if not, remove that executed thread.
		//you can also use removeFirst() according to ROund Robin included!
		//basically, this should be a copy paste of that included RoundRobinScheduler.java
	}

	@Override
	public void acquire(KThread thread) { //rare
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() { //rare
		// TODO Auto-generated method stub
		
	}

}
