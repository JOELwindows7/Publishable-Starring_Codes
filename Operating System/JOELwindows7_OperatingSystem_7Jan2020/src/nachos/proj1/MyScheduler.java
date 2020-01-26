/**
 * 
 */
package nachos.proj1;

import nachos.threads.*; //Scheduler in that threads package

/**
 * @author JOELwindows7
 *
 */
public class MyScheduler extends Scheduler {

	@Override
	public ThreadQueue newThreadQueue(boolean transferPriority) {
		// TODO Auto-generated method stub
		return new MyQueue(); //that is it?!
	}
	
}
