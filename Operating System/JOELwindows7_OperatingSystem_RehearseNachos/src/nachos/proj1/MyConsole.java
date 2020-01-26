/**
 * 
 */
package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

/**
 * @author JOELwindows7
 *
 */
public class MyConsole {
	
	SerialConsole console = Machine.console();
	Semaphore sem = new Semaphore(0); //uses semaphoring wake pausing
	
	char temp; //place character
	String str; //buffer string

	/**
	 * 
	 */
	public MyConsole() {
		// TODO Auto-generated constructor stub
	}

}
