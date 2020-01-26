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
public class Console {
	
	SerialConsole console = Machine.console();
	
	char temp;
	
	Semaphore sem = new Semaphore(0);
	//0 => pause (P)
	//1 => resume (V)
	
	public String read(){
		String str = "";
		
		do {
			sem.P(); //pause
			if(temp!='\n'){ //On Enter, did not a time sempat to read '\n'
				str += temp;
			}
		} while (temp != '\n');
		
		return str;
	}
	
	public void print(String str){
		int len = str.length();
		for (int i = 0; i < len; i++) {
			//sem.P(); // do not put pause here. it will cause print only front and back, not in between. you pause before see
			console.writeByte(str.charAt(i));
			sem.P();
		}
	}
	
	public void println(String str){
		print(str + "\n");
	}
	
	public int readInt(){
		int x = -1;
		try {
			x = Integer.parseInt(read());
		} catch (Exception e) {
			// TODO: handle exception
			println("Error! Not an INTEGER");
			x = -1;
		}
		return x;
	}

	/**
	 * 
	 */
	public Console() {
		// TODO Auto-generated constructor stub
		
		Runnable receive = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				temp = (char)console.readByte();
				sem.V(); //resume
			}
		};
		
		Runnable send = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sem.V();
			}
		};
		
		console.setInterruptHandlers(receive, send);
	}

}
