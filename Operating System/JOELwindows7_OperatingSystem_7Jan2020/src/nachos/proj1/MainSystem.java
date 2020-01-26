/**
 * 
 */
package nachos.proj1;

import nachos.machine.Machine;

/**
 * @author JOELwindows7
 *
 */
public class MainSystem {
	MyConsole console = new MyConsole();
	MyNetworkLink nl = new MyNetworkLink();

	public MainSystem() {
		// TODO Auto-generated constructor stub
		// console.println(console.readLine()); //test your own console!
		
		int input=0;
		do {
			console.println("Computer address: " + nl.getLinkAddress());
			
			console.println("1. Send");
			console.println("2. Receive");
			console.println("3. Exit");
			console.print("Choose : ");
			input = console.readInt();
			
			switch(input){
			case 1:
				console.print("Input dst : ");
				int dst = console.readInt();
				
				console.println("Input file name : ");
				String name = console.readLine();
				
				console.print("Input file size : ");
				int size = console.readInt();
				
				console.println("Input file type : ");
				String type = console.readLine();
				
				nl.send(dst, name, size, type);
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
			}
		} while (input !=3);
		
		console.println(Machine.timer().getTime() + ""); // machine timer get
															// time prints total
															// tick of the
															// machine right now
		
	}

	// Setup
	/*
	 * Run config - Main class nachos.machine - Argument, working directory
	 * other, go to this proj1 - apply and run in that window to apply config
	 * 
	 * Console - Consoled
	 * 
	 * Scheduler - make Scheduler and Queue class
	 * 
	 * nachos.conf - console true - own MyScheduler - network link true
	 */
}
