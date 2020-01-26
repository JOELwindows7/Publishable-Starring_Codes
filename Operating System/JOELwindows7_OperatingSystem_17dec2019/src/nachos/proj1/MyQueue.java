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
public class MyQueue extends ThreadQueue { //Ctrl + Space

	Vector<KThread> queueList = new Vector<>();
	/**
	 * 
	 */
	public MyQueue() {
		// TODO Auto-generated constructor stub
		//Unused
	}

	@Override
	public void waitForAccess(KThread thread) { //Used
		// TODO Auto-generated method stub
		queueList.add(thread); //Add Queue
	}

	@Override
	public KThread nextThread() { //Used
		// TODO Auto-generated method stub
		if(queueList.isEmpty()) return null; //IMPORTANT!!! return null if queue is empty!
		return queueList.remove(0); //Finished Thread! Go to Next thread by removing queue at the 
		//first line (index 0) according to FIFO
		//And run it
	}

	@Override
	public void acquire(KThread thread) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}

}
