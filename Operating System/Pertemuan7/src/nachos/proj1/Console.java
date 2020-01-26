package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.SerialConsole;
import nachos.threads.Semaphore;

public class Console {

	SerialConsole console = Machine.console();
	char temp;
	Semaphore sem = new Semaphore(0);
	// 0 => pause (P)
	// 1 => resume (V)
	
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

	public String read() {
		String str = "";
		//Hello world\n
		
		do {
			sem.P(); //pause
			if(temp != '\n')
				str += temp;
		}while(temp != '\n');
		
		return str;
	}
	
	public int readInt() {
		int x = -1;
		try {
			x = Integer.parseInt(read());
		} catch (Exception e) {
			// TODO: handle exception
			x = -1;
		}
		return x;
	}
	
	public void print(String str) {
		int len = str.length();
		for(int i = 0 ; i < len; i++){
			console.writeByte(str.charAt(i));
			sem.P();
		}
	}
	
	public void println(String str) {
		print(str + "\n");
	}
	
}
