package nachos.proj1;

import java.beans.Customizer;
import java.util.Vector;

import nachos.machine.Machine;
import nachos.threads.KThread;

public class MainSystem {

	MyConsole console = new MyConsole();
	int angka = 0;
	
	public MainSystem() {
		console.print("test");
		
//		Runnable handler = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				System.out.println(angka++);					
//			}
//		};
//		
//		Machine.timer().setInterruptHandler(handler);
//		console.read();
		
		int input = 0;
		String customerName;
		String itemsName;
		Integer quantity;
		Vector<Customer> customerList = new Vector<>();
		
		do {
			console.println("1. Add New");
			console.println("2. Handle Customer");
			console.println("3. Exit");
			
			input = console.readInt();
			if(input == 1) {
				console.print("Input Customer Name : ");
				customerName = console.read();
				
				console.print("Input Items Name : ");
				itemsName = console.read();
				
				console.print("Input Quantity : ");
				quantity = console.readInt();
				
				customerList.add(new Customer(customerName, itemsName, quantity));
			} 
			else if(input == 2) {
				for(int i = 0; i < customerList.size(); i++) {
					new KThread(customerList.get(i)).fork();
				}
			}
			
		} while(input != 3);
		
		
	}
	
}
