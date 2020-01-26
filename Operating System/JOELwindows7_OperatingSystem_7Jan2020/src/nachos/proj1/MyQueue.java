/**
 * 
 */
package nachos.proj1;

import java.util.*; //Vector in that util package

//import nachos.threads.KThread;
//import nachos.threads.ThreadQueue;
import nachos.threads.*;

/**
 * @author JOELwindows7
 *
 */
public class MyQueue extends ThreadQueue {
	
	Vector<KThread> threadList = new Vector<>();

	@Override
	public void waitForAccess(KThread thread) {
		// TODO Auto-generated method stub
		threadList.add(thread);
	}

	@Override
	public KThread nextThread() {
		// TODO Auto-generated method stub
		if(threadList.isEmpty()){
			return null; //if threadList vector is empty, no return
		}
		return threadList.remove(0); //do not remove if threadList vector is empty!
	}

	@Override
	public void acquire(KThread thread) { //ignore, leave this
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() { //ignore, leave this
		// TODO Auto-generated method stub
		
	}

}
