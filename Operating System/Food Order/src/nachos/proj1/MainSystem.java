package nachos.proj1;

import java.util.Vector;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.OpenFile;
import nachos.threads.KThread;

public class MainSystem {

	MyConsole con = new MyConsole();
	Vector<FoodOrder> orders = new Vector<>();
	FileSystem fs = Machine.stubFileSystem();
	
	public MainSystem() {
		int menu = 0;
		
		do{
			con.writeln("1. Add food order");
			con.writeln("2. View food orders");
			con.writeln("3. Serve all orders");
			con.writeln("4. Exit");
			con.write("Choice: ");
			
			menu = con.readInt();
			
			switch(menu){
				case 1: // ADD
					
					String customerName = "";
					do{
						con.write("Customer name[>3 char]: ");
						customerName = con.read();
					}while(customerName.length() <= 3);
					
					String foodName = "";
					do{
						con.write("Food name[Burger | Pizza]: ");
						foodName = con.read();
					}while(!foodName.equals("Burger") && 
							!foodName.equals("Pizza"));
					
					int quantity = 0;
					do{
						con.write("Food quantity[>0]: ");
						quantity = con.readInt();
					}while(quantity <= 0);
					
					FoodOrder temp = new FoodOrder(customerName, 
													foodName, 
													quantity);
					
					orders.add(temp);
					
					// cara kedua
					// order.add(new FoodOrder(customerName, 
					//							foodName, 
					//							quantity))
					
					break;
				case 2: // VIEW
					
					int x = 1;
					for (FoodOrder foodOrder : orders) {
						con.writeln("Order " + x);
						con.writeln("Customer name: " 
									+ foodOrder.getCustomerName());
						con.writeln("Food name: " 
								+ foodOrder.getFoodName());
						con.writeln("Food quantity: " 
								+ foodOrder.getQuantity());
						con.writeln("=======================");
						
						x++;
					}
					
					break;
				case 3: // SERVE
					while(!orders.isEmpty()){
						new KThread(orders.remove(0)).fork();
					}
					
					break;
			}
			
		}while(menu != 4);
		
		writeFile();
	}
	
	private void writeFile(){
		String data = "";
		
		for (FoodOrder foodOrder : orders) {
			data += foodOrder.getCustomerName() + "#" +
					foodOrder.getFoodName() + "#" +
					foodOrder.getQuantity() + "\n";
		}
		
		OpenFile out = fs.open("data.txt", true);
		
		byte[] temp = data.getBytes();
		
		out.write(temp, 0, temp.length);
		
	}

	
	
}
