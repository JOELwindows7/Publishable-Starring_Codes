package nachos.proj1;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.MalformedPacketException;
import nachos.machine.NetworkLink;
import nachos.machine.OpenFile;
import nachos.machine.Packet;
import nachos.threads.Semaphore;

public class MainSystem {

	NetworkLink nl = Machine.networkLink();
	MyConsole console = new MyConsole();
	Semaphore sem = new Semaphore(0);
	FileSystem fs = Machine.stubFileSystem();
	
	public MainSystem() {
//		int menu = 0;
//		
//		Runnable receive2 = new Runnable() {
//			
//			@Override
//			public void run() {
//				Packet receive = nl.receive();
//				String message2 = new String(receive.contents);
//				
//				System.out.println("Message: " + message2);
//				sem.V();
//			}
//		};
//		
//		Runnable send2 = new Runnable() {
//			
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				sem.V();
//			}
//		};
//		
//		nl.setInterruptHandlers(receive2, send2);
//		
//		do{
//			console.writeln("My Address: " + nl.getLinkAddress());
//			console.writeln("1. Send");
//			console.writeln("2. Receive");
//			console.writeln("3. Exit");
//			console.write("Choice: ");
//			menu = console.readInt();
//			
//			if(menu == 1){ // SEND
//				console.write("Destination address: ");
//				int destAddress = console.readInt();
//				
//				console.write("Message: ");
//				String message = console.read();
//				
//				byte[] messageByte = message.getBytes();
//				try {
//					Packet send = new Packet(
//							destAddress, nl.getLinkAddress(), messageByte);
//					nl.send(send);
//					sem.P();
//					// P(pause) V(play)
//				} catch (MalformedPacketException e) {
//					e.printStackTrace();
//				}
//				
//			}else if(menu == 2){ // RECEIVE
//				try {
//					Packet receive = nl.receive();
//					String message2 = new String(receive.contents);
//					
//					console.writeln("Message: " + message2);
//				} catch (Exception e) {
//					console.writeln("Tidak ada paket");
//				}
//				
//			}
//		}while(menu != 3);
		
		
		
		// WRITE
		OpenFile out = fs.open("data.txt", true);
		String content = "AAA#100\nBBB#200";
		
		byte[] contentByte = content.getBytes();
		out.write(contentByte, 0, contentByte.length);
			
		
		// READ
		OpenFile myFile = fs.open("data.txt", false);
		byte[] temp = new byte[9999];
		myFile.read(temp, 0, myFile.length());
		
		String data = new String(temp);
		console.writeln(data);
			
			
		
	}

}
