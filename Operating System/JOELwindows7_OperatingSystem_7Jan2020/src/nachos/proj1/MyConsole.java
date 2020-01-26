/**
 * 
 */
package nachos.proj1;

import nachos.machine.*;
import nachos.threads.*;

/**
 * @author JOELwindows7
 *
 */
public class MyConsole {
	SerialConsole console = Machine.console();
	Semaphore sem = new Semaphore(0); // control flow of multithread and avoid
										// crash
	char temp;
	String str;

	public MyConsole() {
		// TODO Auto-generated constructor stub

		Runnable receive = new Runnable() { // data in

			@Override
			public void run() {
				// TODO Auto-generated method stub
				temp = (char) console.readByte(); // need cast because readByte
													// reads integer.
				// Byte is integer
				if (temp != '\n') {
					str += temp; // fill str char by char
				}
				sem.V(); // increment semaphore, wake up thread in P();
			}
		};

		Runnable send = new Runnable() { // data out

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sem.V(); // increment semaphore, wake up thread in P();
			}
		};
		console.setInterruptHandlers(receive, send); // parameter receive then
														// send. do not flip!
	}

	public String readLine() {
		str = "";
		do {
			sem.P(); // wait for semaphore >0 and decrement
		} while (temp != '\n'); // read until enter button
		return str;

	}

	public int readInt() {
		try {
			return Integer.parseInt(readLine());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

	public void print(String string) {
		for (int i = 0; i < string.length(); i++) {
			console.writeByte(string.charAt(i)); // Just write byte to console
													// char by char
			sem.P(); // wait for semaphore >0 and decrement
		}
	}
	public void println(String string){ // optional, Recommended
		print(string + '\n');
	}
}
