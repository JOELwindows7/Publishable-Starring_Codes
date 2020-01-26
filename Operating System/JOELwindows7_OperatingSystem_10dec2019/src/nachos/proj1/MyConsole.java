package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

public class MyConsole {

	SerialConsole console = Machine.console();
	Semaphore sem = new Semaphore(0);
	char t;
	String temp;
	
	public MyConsole() {
		// TODO Auto-generated constructor stub
		
		Runnable receive = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				t = (char)console.readByte();
				if(t != '\n') temp += t;
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
	
	public void print(String str) {
		for(int i = 0 ; i < str.length(); i++) {
			console.writeByte(str.charAt(i));
			sem.P();
		}
	}
	
	public String read() {
		temp = "";
		do {
			sem.P();
		} while(t != '\n');
		return temp;
	}
	
	public Integer readInt() {
		try {
			return Integer.parseInt(read());
		} catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}
	
	public void println(String str) 
	{
		print(str + "\n");
	}
	
}
