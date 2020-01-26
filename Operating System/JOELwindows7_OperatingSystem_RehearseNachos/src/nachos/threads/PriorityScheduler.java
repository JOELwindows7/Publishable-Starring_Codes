package nachos.threads;

import java.util.SortedSet;
import java.util.TreeSet;

import nachos.machine.Lib;
import nachos.machine.Machine;

/**
 * A scheduler that chooses threads based on their priorities.
 * 
 * <p>
 * A priority scheduler associates a priority with each thread. The next thread
 * to be dequeued is always a thread with priority no less than any other
 * waiting thread's priority. Like a round-robin scheduler, the thread that is
 * dequeued is, among all the threads of the same (highest) priority, the thread
 * that has been waiting longest.
 * 
 * <p>
 * Essentially, a priority scheduler gives access in a round-robin fashion to
 * all the highest-priority threads, and ignores all other threads. This has the
 * potential to starve a thread if there's always a thread waiting with higher
 * priority.
 * 
 * <p>
 * A priority scheduler must partially solve the priority inversion problem; in
 * particular, priority must be donated through locks, and through joins.
 */
public class PriorityScheduler extends Scheduler {
	/**
	 * Allocate a new priority scheduler.
	 */
	public PriorityScheduler() {
	}

	/**
	 * Allocate a new priority thread queue.
	 * 
	 * @param transferPriority
	 *            <tt>true</tt> if this queue should transfer priority from
	 *            waiting threads to the owning thread.
	 * @return a new priority thread queue.
	 */
	public ThreadQueue newThreadQueue(boolean transferPriority) {
		return new PriorityQueue(transferPriority);
	}

	public int getPriority(KThread thread) {
		Lib.assertTrue(Machine.interrupt().disabled());

		return getThreadState(thread).getPriority();
	}

	public int getEffectivePriority(KThread thread) {
		Lib.assertTrue(Machine.interrupt().disabled());

		return getThreadState(thread).getEffectivePriority();
	}

	public void setPriority(KThread thread, int priority) {
		Lib.assertTrue(Machine.interrupt().disabled());

		Lib.assertTrue(priority >= priorityMinimum
				&& priority <= priorityMaximum);

		getThreadState(thread).setPriority(priority);
	}

	public boolean increasePriority() {
		boolean intStatus = Machine.interrupt().disable();

		KThread thread = KThread.currentThread();

		int priority = getPriority(thread);
		if (priority == priorityMaximum)
			return false;

		setPriority(thread, priority + 1);

		Machine.interrupt().restore(intStatus);
		return true;
	}

	public boolean decreasePriority() {
		boolean intStatus = Machine.interrupt().disable();

		KThread thread = KThread.currentThread();

		int priority = getPriority(thread);
		if (priority == priorityMinimum)
			return false;

		setPriority(thread, priority - 1);

		Machine.interrupt().restore(intStatus);
		return true;
	}

	/**
	 * The default priority for a new thread. Do not change this value.
	 */
	public static final int priorityDefault = 1;
	/**
	 * The minimum priority that a thread can have. Do not change this value.
	 */
	public static final int priorityMinimum = 0;
	/**
	 * The maximum priority that a thread can have. Do not change this value.
	 */
	public static final int priorityMaximum = 7;

	/**
	 * Return the scheduling state of the specified thread.
	 * 
	 * @param thread
	 *            the thread whose scheduling state to return.
	 * @return the scheduling state of the specified thread.
	 */
	protected ThreadState getThreadState(KThread thread) {
		if (thread.schedulingState == null)
			thread.schedulingState = new ThreadState(thread);

		return (ThreadState) thread.schedulingState;
	}

	/**
	 * A <tt>ThreadQueue</tt> that sorts threads by priority.
	 */
	protected class PriorityQueue extends ThreadQueue {

		/**
		 * <tt>true</tt> if this queue should transfer priority from waiting
		 * threads to the owning thread.
		 */
		public boolean transferPriority;

		private TreeSet<KThread> priorityQueue;

		// This list has to be dynamically updated
		// private LinkedList<KThread> waitQueueList;

		PriorityQueue(boolean transferPriority) {
			this.transferPriority = transferPriority;
			// Initialize with comparator
			this.priorityQueue = new TreeSet<KThread>(
					new KThreadPriorityComparator());
			// this.waitQueueList = new LinkedList<KThread>();
		}

		public void waitForAccess(KThread thread) {
			Lib.assertTrue(Machine.interrupt().disabled());
			// Set the time
			thread.setWaitStartTimestamp(Machine.timer().getTime());

			// Calls ThreadState.waitForAccess(This PriorityQueue)
			getThreadState(thread).waitForAccess(this);
		}

		public void acquire(KThread thread) {
			Lib.assertTrue(Machine.interrupt().disabled());
			// Calls ThreadState.acquire(This PriorityQueue)
			getThreadState(thread).acquire(this);
			// Reset the wake start time
			thread.resetWaitStartTimestamp();
		}

		public KThread nextThread() {
			Lib.assertTrue(Machine.interrupt().disabled());

			Lib.assertTrue(null != this.priorityQueue);

			// Do housekeeping for this thread
			KThread thread;
			if (null != (thread = this.priorityQueue.pollFirst())) {
				// Reset the wake start time
				thread.resetWaitStartTimestamp();
			}

			return thread;

		}

		/**
		 * Return the next thread that <tt>nextThread()</tt> would return,
		 * without modifying the state of this queue.
		 * 
		 * @return the next thread that <tt>nextThread()</tt> would return.
		 */
		protected ThreadState pickNextThread() {
			Lib.assertTrue(null != this.priorityQueue);
			KThread thread;
			if (null != (thread = this.priorityQueue.first())) {
				return thread.schedulingState;
			}

			return null;

		}

		public void print() {
			Lib.assertTrue(Machine.interrupt().disabled());
			// TODO: implement me (if you want)
		}

		@Override
		public KThread peekNextThread() {

			Lib.assertTrue(null != this.priorityQueue);

			return this.priorityQueue.first();

		}

		public TreeSet<KThread> getPriorityQueue() {
			return priorityQueue;
		}

		// public LinkedList<KThread> getWaitQueueList() {
		// return waitQueueList;
		// }
	}

	/**
	 * The scheduling state of a thread. This should include the thread's
	 * priority, its effective priority, any objects it owns, and the queue it's
	 * waiting for, if any.
	 * 
	 * @see nachos.threads.KThread#schedulingState
	 */
	protected class ThreadState {

		/** The thread with which this object is associated. */
		protected KThread thread;
		/** The priority of the associated thread. */
		protected int priority;
		/**
		 * Effective Priority Cached
		 */
		protected int effectivePrioirity;

		/**
		 * Allocate a new <tt>ThreadState</tt> object and associate it with the
		 * specified thread.
		 * 
		 * @param thread
		 *            the thread this state belongs to.
		 */
		public ThreadState(KThread thread) {
			this.thread = thread;

			setPriority(priorityDefault);
			this.effectivePrioirity = priorityDefault;
		}

		/**
		 * Return the priority of the associated thread.
		 * 
		 * @return the priority of the associated thread.
		 */
		public int getPriority() {
			return priority;
		}

		/**
		 * Return the effective priority of the associated thread.
		 * 
		 * @return the effective priority of the associated thread.
		 */
		public int getEffectivePriority() {
			// TODO: implement me

			return this.effectivePrioirity;

		}

		/**
		 * Set the priority of the associated thread to the specified value.
		 * 
		 * @param priority
		 *            the new priority.
		 */
		public void setPriority(int priority) {
			if (this.priority == priority)
				return;
			this.priority = priority;

			// TODO: Set Effective Property
			if (this.effectivePrioirity < priority) {
				// We need to go into the priority queue and if transfers are
				// available, we may need to raise priorities of threads

			}
		}

		/**
		 * Called when <tt>waitForAccess(thread)</tt> (where <tt>thread</tt> is
		 * the associated thread) is invoked on the specified priority queue.
		 * The associated thread is therefore waiting for access to the resource
		 * guarded by <tt>waitQueue</tt>. This method is only called if the
		 * associated thread cannot immediately obtain access.
		 * 
		 * @param waitQueue
		 *            the queue that the associated thread is now waiting on.
		 * 
		 * @see nachos.threads.ThreadQueue#waitForAccess
		 */
		public void waitForAccess(PriorityQueue waitQueue) {
			// TODO: implement me
			// Add the thread to the priority queue
			// Two ways to add , once when retaining priority and once with
			// donating priority
			Lib.assertTrue(null != waitQueue);

			// Donate Priority
			if (waitQueue.transferPriority) {

				SortedSet<KThread> lowerPriorityThreads = waitQueue
						.getPriorityQueue().headSet(this.thread);

				for (KThread thread : lowerPriorityThreads) {

					thread.schedulingState.effectivePrioirity = this.thread.schedulingState.effectivePrioirity;
				}
			}
			// Just add the thread now
			waitQueue.priorityQueue.add(this.thread);

		}

		/**
		 * Called when the associated thread has acquired access to whatever is
		 * guarded by <tt>waitQueue</tt>. This can occur either as a result of
		 * <tt>acquire(thread)</tt> being invoked on <tt>waitQueue</tt> (where
		 * <tt>thread</tt> is the associated thread), or as a result of
		 * <tt>nextThread()</tt> being invoked on <tt>waitQueue</tt>.
		 * 
		 * @see nachos.threads.ThreadQueue#acquire
		 * @see nachos.threads.ThreadQueue#nextThread
		 */
		public void acquire(PriorityQueue waitQueue) {
			// TODO: Check here if the waitQueue is empty or if not empty, the
			// thread in question has the highest priority than the max element
			// in waitQueue?
			Lib.assertTrue(null != waitQueue);

			if (!waitQueue.priorityQueue.isEmpty()) {

				// Transfer of priority should happen here?

			}

		}

	}
}
