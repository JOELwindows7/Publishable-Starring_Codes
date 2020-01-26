/**
 * 
 */
package nachos.proj1;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.MalformedPacketException;
import nachos.machine.NetworkLink;
import nachos.machine.OpenFile;
import nachos.machine.Packet;
import nachos.threads.Semaphore;

/**
 * @author JOELwindows7
 *
 */
public class MainSystem {
	
	NetworkLink nl = Machine.networkLink();
	MyConsole console = new MyConsole();
	Semaphore sem = new Semaphore(0);
	FileSystem fs = Machine.stubFileSystem();
	/**
	 * 
	 */
	public MainSystem() {
		// TODO Auto-generated constructor stub
//		int menu = 0;
//		
//		Runnable receive1 = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				Packet receive = nl.receive();
//				String message1 = new String(receive.contents);
//				
//				//console.writeln("Message: " + message1); //do not use console! it has semaphore blocked!
//				System.out.println("Message: " + message1);
//				sem.V();
//			}
//		};
//		
//		Runnable send1 = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				sem.V();
//			}
//		};
//		
//		nl.setInterruptHandlers(receive1, send1);
//		do {
//			console.writeln("My Address: " + nl.getLinkAddress());
//			console.writeln("1. Send");
//			console.writeln("2. Receive");
//			console.writeln("3. Exit");
//			console.write("Choice: ");
//			menu = console.readInt();
//			
//			switch(menu){
//			case 1: //SEND
//				console.write("Destination adress: ");
//				int destAdress = console.readInt();
//				
//				console.write("Message: ");
//				String message = console.read();
//				
//				byte[] messageByte = message.getBytes();
//				try {
//					Packet send = new Packet(destAdress, nl.getLinkAddress(), messageByte);
//					
//					nl.send(send);
//					sem.P();
//					//P pause
//					//V play
//				} catch (MalformedPacketException e) {
//					// TODO Auto-generated catch block
//					console.writeln("Network Send error");
//					e.printStackTrace();
//				}
//				break;
//			case 2: //RECEIVE
//				try {
//					Packet receive = nl.receive();
//					String message1 = new String(receive.contents);
//					
//					console.writeln("Message: " + message1);
//				} catch (Exception e) {
//					// TODO: handle exception
//					console.writeln("No Packet");
//					//e.printStackTrace();
//				}
//				break;
//			case 3: //EXIT
//				break;
//			default:
//				break;
//			}
//		} while (menu !=3);
		
		//WRITE
		OpenFile out = fs.open("data.txt", true);
		String content = "AAA#100\nBBB#200";
		
		byte[] contentByte = content.getBytes();
		out.write(contentByte, 0, contentByte.length);
		
		//READ
		OpenFile myFile = fs.open("data.txt", false);
		
		byte[] temp = new byte[9999];
		myFile.read(temp, 0, myFile.length());
		
		String data = new String(temp);
		console.writeln(data);
	}

}
