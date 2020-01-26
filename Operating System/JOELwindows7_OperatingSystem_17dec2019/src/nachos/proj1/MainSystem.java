/**
 * 
 */
package nachos.proj1;

import java.util.Vector;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.OpenFile;
import nachos.threads.KThread;

/**
 * @author JOELwindows7
 *
 */
public class MainSystem {
	MyConsole console = new MyConsole();
	Vector<FoodOrder> orders = new Vector<>();
	FileSystem fs = Machine.stubFileSystem(); //use Nachos File System!

	public MainSystem() {
		// console.write("Draw");

		int menu = 0;
		do { // String values No need to be tied exactly. No need to sama persis
			console.writeln("1. Add food");
			console.writeln("2. View food orders");
			console.writeln("3. Serve all orders");
			console.writeln("4. Exit");
			console.writeln("5. Add food");
			console.write("Choice: ");

			menu = console.readInt();

			switch (menu) {
			case 1: // ADD
				String customerName = "";
				do {
					console.write("Customer name[>3 char]: ");
					customerName = console.read();
				} while (customerName.length() <= 3);
				String foodName = "";
				do {
					console.write("Food name [Burger | Pizza]: ");
					foodName = console.read();
				} while (!foodName.equals("Burger") && !foodName.equals("Pizza"));

				int quantity = 0;
				do {
					console.write("Food quantity [>0]");
					quantity = console.readInt();
				} while (quantity <= 0);
				
				FoodOrder temp = new FoodOrder(customerName, foodName, quantity);
				
				orders.add(temp);
				//orders.add(new FoodOrder(customerName, foodName, quantity)); //Unclean way
				break;
			case 2: // VIEW
				console.writeln("++++++++++++++++++++++++++++++++++++++++++++++++");
				int x = 1;
				for (FoodOrder foodOrder : orders) {
					console.writeln("Order " + x);
					console.writeln("Customer name:  " + foodOrder.getCustomerName());
					console.writeln("Food name " + foodOrder.getFoodName());
					console.writeln("Food quantity " + foodOrder.getQuantity());
					console.writeln("================================================");
					x++;
				}
				console.writeln("++++++++++++++++++++++++++++++++++++++++++++++++");
				break;
			case 3: // SERVE
				while (!orders.isEmpty()) {
					new KThread(orders.remove(0)).fork(); //Add new thread of FoodOrder class
					//This removes vectoring
					//Fork triggers run inside the Runnable methods of the Runnable interface
					//This while runs one by one until order vector runs out.
				}
				break;
			case 4: // EXIT
				break;
			default:
				break;
			}
		} while (menu != 4);
		
		writeFile();
	}
	
	private void writeFile(){
		String data = "";
		
		for (FoodOrder foodOrder : orders) {
			data += foodOrder.getCustomerName() + "#"+
					foodOrder.getFoodName() + "#" +
					foodOrder.getQuantity() + "\n";
		}
		
		OpenFile out = fs.open("data.txt", true);
		
		byte[] temp = data.getBytes();
		out.write(temp, 0, temp.length); // file sometimes fell to bin instead of src
	}
	
	//readfile
	//split("\n")
	//split("#")
	
	private void readFile(){
		
		String data; //out.read(buf,offset,false);

		String[] temp = data.split("\n");

		for(int x = 0; x < temp.length; x++){
			String[] temp2 = temp[x].split("#");

			String custName = temp2[0];
			String foodName = temp2[1];
			int qty = Integer.parseInt(temp2[2]);
		}
	}
}
