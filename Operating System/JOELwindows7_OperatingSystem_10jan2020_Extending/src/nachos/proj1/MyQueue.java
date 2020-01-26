package nachos.proj1;

import java.util.Vector;

import nachos.threads.KThread;
import nachos.threads.ThreadQueue;

public class MyQueue extends ThreadQueue{

	Vector<KThread> threadList = new Vector<>();
	
	//FIFO! add from front, remove behind
	
	@Override
	public void waitForAccess(KThread thread) { //YESS
		// TODO Auto-generated method stub
		threadList.add(thread);
	}

	@Override
	public KThread nextThread() { //YESS
		// TODO Auto-generated method stub
		if(threadList.isEmpty()) return null;
		return threadList.remove(0);
	}

	@Override
	public void acquire(KThread thread) { //ignore
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() { //ignore
		// TODO Auto-generated method stub
		
	}

	
	
}
