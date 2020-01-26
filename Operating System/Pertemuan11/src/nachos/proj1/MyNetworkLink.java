package nachos.proj1;

import nachos.machine.Machine;
import nachos.machine.MalformedPacketException;
import nachos.machine.NetworkLink;
import nachos.machine.Packet;
import nachos.threads.Semaphore;

public class MyNetworkLink {

	NetworkLink nl = Machine.networkLink();
	Semaphore sem = new Semaphore(0);
	
	public MyNetworkLink() {
		// TODO Auto-generated constructor stub
		
		Runnable receive = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Packet pkt = nl.receive();
				String content = new String(pkt.contents);
				String data[] = content.split("#");
				System.out.println("New file received : " + data[0]);
			}
		};
		
		Runnable send = new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				sem.V();
			}
		};
		
		nl.setInterruptHandlers(receive, send);
		
	}
	
	public int getLinkAddress() {
		return nl.getLinkAddress();
	}
	
	public void send(int dst, String name, int size, String type) {
		String temp = name + "#" + size + "#" + type;
		try {
			Packet pkt = new Packet(dst, nl.getLinkAddress(), temp.getBytes());
			nl.send(pkt);
			sem.P();
		} catch (MalformedPacketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
