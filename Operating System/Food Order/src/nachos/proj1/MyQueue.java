package nachos.proj1;

import java.util.Vector;

import nachos.threads.KThread;
import nachos.threads.ThreadQueue;

public class MyQueue extends ThreadQueue {

	Vector<KThread> queueList = new Vector<>();

	@Override
	public void waitForAccess(KThread thread) {
		queueList.add(thread);
	}

	@Override
	public KThread nextThread() {
		if(queueList.isEmpty()) return null;
		
		return queueList.remove(0);
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
