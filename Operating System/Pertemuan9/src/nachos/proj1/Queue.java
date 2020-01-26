package nachos.proj1;

import java.util.Vector;

import nachos.threads.KThread;
import nachos.threads.ThreadQueue;

public class Queue extends ThreadQueue{

	Vector<KThread> threadList = new Vector<>();
	
	@Override
	public void waitForAccess(KThread thread) {
		// TODO Auto-generated method stub
		threadList.add(thread);
	}

	@Override
	public KThread nextThread() {
		// TODO Auto-generated method stub
		if(threadList.isEmpty()) return null;
		return threadList.remove(0);
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
