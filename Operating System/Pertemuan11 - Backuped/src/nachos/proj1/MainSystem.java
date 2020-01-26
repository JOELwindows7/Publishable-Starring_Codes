package nachos.proj1;

import nachos.machine.Machine;

public class MainSystem {
	
	MyConsole console = new MyConsole();
	MyNetworkLink nl = new MyNetworkLink();
	
	public MainSystem() {
		// TODO Auto-generated constructor stub
		
		int input = 0;
		do {
			console.println("Computer address : " 
					+ nl.getLinkAddress());
			
			console.println("1. Send");
			console.println("2. Receive");
			console.println("3. Exit");

			input = console.readInt();
			
			switch(input) {
			case 1:
				console.print("Input dst : ");
				int dst = console.readInt();
				
				console.print("Input file name : ");
				String name = console.readLine();
				
				console.print("Input file size : ");
				int size = console.readInt();
				
				console.print("Input file type : ");
				String type = console.readLine();
				nl.send(dst, name, size, type);
				
				break;
			}
			
		}while(input != 3);
		
		console.println(Machine.timer().getTime() + "");
		
	}
	
}
