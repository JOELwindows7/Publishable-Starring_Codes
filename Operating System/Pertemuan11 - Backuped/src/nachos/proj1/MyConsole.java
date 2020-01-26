package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

public class MyConsole {
	
	SerialConsole console = Machine.console();
	Semaphore sem = new Semaphore(0);
	
	char temp;
	String str;
	
	public MyConsole() {
		// TODO Auto-generated constructor stub
		
		Runnable receive = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				temp = (char)console.readByte();
				if(temp != '\n') {
					str += temp;
				}
				sem.V();
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
	
	public String readLine() {
		str = "";
		do {
			sem.P();
		} while(temp != '\n');
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
		for(int i = 0; i < string.length(); i++) {
			console.writeByte(string.charAt(i));
			sem.P();
		}
	}
	
	public void println(String string) {
		print(string + '\n');
	}
	
}	
