package nachos.threads;

import java.util.LinkedList;

/**
 * A <i>communicator</i> allows threads to synchronously exchange 32-bit
 * messages. Multiple threads can be waiting to <i>speak</i>, and multiple
 * threads can be waiting to <i>listen</i>. But there should never be a time
 * when both a speaker and a listener are waiting, because the two threads can
 * be paired off at this point.
 */
public class Communicator {

	private Lock lock;
	private LinkedList<Integer> messageQueue;
	private Condition2 signalToSpeak;
	private Condition2 signalHasSpoken;
	private Condition2 signalToListen;

	/**
	 * Allocate a new communicator.
	 */
	public Communicator() {
		this.lock = new Lock();
		this.signalToSpeak = new Condition2(lock);
		this.signalHasSpoken = new Condition2(lock);
		this.signalToListen = new Condition2(lock);
		this.messageQueue = new LinkedList<Integer>();
	}

	/**
	 * Wait for a thread to listen through this communicator, and then transfer
	 * <i>word</i> to the listener.
	 * 
	 * <p>
	 * Does not return until this thread is paired up with a listening thread.
	 * Exactly one listener should receive <i>word</i>.
	 * 
	 * @param word
	 *            the integer to transfer.
	 */
	public void speak(int word) {
		// 1. Acquire the Lock
		lock.acquire();

		// There is already some message which has to be communicated
		while (!messageQueue.isEmpty()) {
			signalToSpeak.sleep();
		}

		// Some thread has called wake on the waiting thread
		messageQueue.add(word);
		// Wake up a thread to listen to what was spoken and put that on ready
		// queue
		signalToListen.wake();

		// This thread has to wait till message is heard
		while (!messageQueue.isEmpty()) {
			signalHasSpoken.sleep();
		}

		// Wake up a thread which has to speak
		signalToSpeak.wake();

		// Release the acquired lock
		lock.release();

	}

	/**
	 * Wait for a thread to speak through this communicator, and then return the
	 * <i>word</i> that thread passed to <tt>speak()</tt>.
	 * 
	 * @return the integer transferred.
	 */
	public int listen() {
		// 1. Acquire the lock
		lock.acquire();
		// Wait(Sleep) if this thread has to hear the message
		while (messageQueue.isEmpty()) {
			signalToListen.sleep();
		}
		// Get the message
		int word = messageQueue.pollFirst();
		// Wake up the thread which passed the message to this thread
		signalHasSpoken.wake();

		// Release the lock
		lock.release();
		return word;

	}
}
