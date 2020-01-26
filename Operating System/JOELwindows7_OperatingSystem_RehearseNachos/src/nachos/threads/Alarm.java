package nachos.threads;

import nachos.machine.Machine;

/**
 * Uses the hardware timer to provide preemption, and to allow threads to sleep
 * until a certain time.
 */
public class Alarm {

	// Create a waitQueue
	private ThreadQueue waitQueue;

	/**
	 * Allocate a new Alarm. Set the machine's timer interrupt handler to this
	 * alarm's callback.
	 * 
	 * <p>
	 * <b>Note</b>: Nachos will not function correctly with more than one alarm.
	 */
	public Alarm() {
		this.waitQueue = ThreadedKernel.scheduler.newThreadQueue(false);
		Machine.timer().setInterruptHandler(new Runnable() {
			public void run() {
				timerInterrupt();
				boolean intStatus = Machine.interrupt().disable();
				KThread thread;
				// Wake all the threads if their wake up time has been passed
				while ((thread = waitQueue.peekNextThread()) != null
						&& thread.getWakeTime() < Machine.timer().getTime()) {
					waitQueue.nextThread().ready();
				}

				Machine.interrupt().restore(intStatus);

			}
		});
	}

	/**
	 * The timer interrupt handler. This is called by the machine's timer
	 * periodically (approximately every 500 clock ticks). Causes the current
	 * thread to yield, forcing a context switch if there is another thread that
	 * should be run.
	 */
	public void timerInterrupt() {
		KThread.currentThread().yield();
	}

	/**
	 * Put the current thread to sleep for at least <i>x</i> ticks, waking it up
	 * in the timer interrupt handler. The thread must be woken up (placed in
	 * the scheduler ready set) during the first timer interrupt where
	 * 
	 * <p>
	 * <blockquote> (current time) >= (WaitUntil called time)+(x) </blockquote>
	 * 
	 * @param x
	 *            the minimum number of clock ticks to wait.
	 * 
	 * @see nachos.machine.Timer#getTime()
	 */
	public void waitUntil(long x) {

		long wakeTime = Machine.timer().getTime() + x;
		KThread.currentThread().setWakeTime(wakeTime);
		boolean intStatus = Machine.interrupt().disable();
		waitQueue.waitForAccess(KThread.currentThread());
		KThread.sleep();
		Machine.interrupt().restore(intStatus);

	}
}
