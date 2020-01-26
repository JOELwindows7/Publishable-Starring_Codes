/**
 * 
 */
package nachos.proj1;

import nachos.threads.Scheduler;
import nachos.threads.ThreadQueue;

/**
 * @author JOELwindows7
 *
 */
public class MyScheduler extends Scheduler {

	/**
	 * 
	 */
	public MyScheduler() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public ThreadQueue newThreadQueue(boolean transferPriority) {
		// TODO Auto-generated method stub
		return new MyQueue(); //IMPORTANT!!! construct new class of that Queue!!!
	}

}
