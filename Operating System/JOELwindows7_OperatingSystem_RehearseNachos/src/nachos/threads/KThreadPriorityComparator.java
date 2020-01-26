package nachos.threads;

import java.util.Comparator;

import nachos.machine.Lib;

/**
 * We want a descending tree set, so all the comparisons are negative if value
 * should be greater
 * 
 * @author Puneet Mehta
 * 
 */
public class KThreadPriorityComparator implements Comparator<KThread> {

	@Override
	public int compare(KThread thread1, KThread thread2) {

		Lib.assertTrue(null != thread1);
		Lib.assertTrue(null != thread2);

		// Check for the effective priority, if equal, we check for the
		// waiting time stamps ( a time stamp less than other, makes it larger)
		if (thread1.schedulingState.getEffectivePriority() == thread2.schedulingState
				.getEffectivePriority()) {
			// This we may need to change depending upon the
			if (thread1.getWaitStartTimestamp() < thread2
					.getWaitStartTimestamp()) {
				return -1;
			} else if (thread1.getWaitStartTimestamp() > thread2
					.getWaitStartTimestamp()) {
				return 1;
			}
			return 0;
		}

		return (thread2.schedulingState.getEffectivePriority() - thread1.schedulingState
				.getEffectivePriority());

	}
}
