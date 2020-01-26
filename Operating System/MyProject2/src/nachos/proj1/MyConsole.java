package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

public class MyConsole {
	private SerialConsole sercon = Machine.console();
	private char temp;
	private Semaphore sem = new Semaphore(0);
	
	public MyConsole() {
		Runnable receive = new Runnable() {
			
			@Override
			public void run() {
				temp = (char)sercon.readByte();
				sem.V();
			}
		};
		
		Runnable send = new Runnable() {
			
			@Override
			public void run() {
				sem.V();
			}
		};
		
		sercon.setInterruptHandlers(receive, send);
	}
	
	public String read() {
		String result = "";
		
		do {
			sem.P();
			if(temp != '\n') {
				result += temp;
			}
		}while(temp != '\n');
		
		return result;
	}
	
	public int readInt() {
		int result = -1;
		
		try {
			result = Integer.parseInt(read());
		} catch (Exception e) {
			
		}
		
		return result;
	}
	
	public void write(String str) {
		for(int i = 0; i < str.length(); i++) {
			sercon.writeByte(str.charAt(i));
			sem.P();
		}
	}
	
	public void writeln(String str) {
		write(str + '\n');
	}

}
