/**
 * 
 */
package nachos.proj1;

import java.util.Vector;

import nachos.machine.Machine;
import nachos.threads.KThread;

/**
 * @author JOELwindows7
 *
 */
public class MainSystem {
	
	MyConsole console = new MyConsole();
	int angka = 0;
	/**
	 * 
	 */
	public MainSystem() {
		// TODO Auto-generated constructor stub
		//console.print("Darr");
		
//		Runnable handler = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				//avoid using MyConsole console. it can crash semaphore!
//				//use sysout
//				System.out.println(angka++);
//			}
//		};
//		
//		//Timer
//		Machine.timer().setInterruptHandler(handler);
//		console.read(); //prevent the main thread finish too early even before this thread of main system runs.
		
		int input = 0;
		String customerName;
		String itemsName;
		Integer quantity;
		Vector<Customer> customerList = new Vector<>();
		
		do{
			
			console.println("1. Add New");
			console.println("2. Handle Customer");
			console.println("3. Exit");
			
			input = console.readInt();
			switch(input){
			case 1:
				console.print("Input Customer Name: ");
				customerName = console.read();
				
				console.print("Input Items Name: ");
				itemsName = console.read();
				
				console.print("Input Quantity Name: ");
				quantity = console.readInt();
				
				customerList.add(new Customer(customerName, itemsName, quantity));
				break;
			case 2:
				for(int i = 0; i < customerList.size(); i++){
					new KThread(customerList.get(i)).fork();
				}
				break;
			case 3:
				break;
			default:
				break;
			}
		} while (input != 3);
	}

}
