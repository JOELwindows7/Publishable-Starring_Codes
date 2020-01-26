package nachos.proj1;

import nachos.threads.Scheduler;
import nachos.threads.ThreadQueue;

public class MyScheduler extends Scheduler {
	//add unimplemented methods
	public MyScheduler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ThreadQueue newThreadQueue(boolean transferPriority) {
		// TODO Auto-generated method stub
		return new Queue();
	}

}
