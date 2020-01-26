package nachos.proj1;

import nachos.machine.FileSystem;
import nachos.machine.Machine;
import nachos.machine.OpenFile;
import nachos.threads.KThread;

public class MainSystem {
	
	MyConsole console = new MyConsole();
	MyNetworkLink nl = new MyNetworkLink();
	FileSystem fs = Machine.stubFileSystem();
	OpenFile of;
	
	public MainSystem() {
		// TODO Auto-generated constructor stub
		
		//Append read file now
		of = fs.open(nl.getLinkAddress() + ".txt", false);
		if(of != null) //in java cannot just 'of' like C#
		{
			byte[] bytes = new byte[9999];
			of.read(bytes, 0, of.length());
			console.println(new String(bytes));
			//Differentiated. different project per sub topic of file sys, net link, etc.
		}
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
			case 2:
				if(nl.fileList.isEmpty()){
					//System.out.println("There is no available file");
					console.println("There is no available file");
				} else {
//					of = fs.open(nl.getLinkAddress() + ".txt", false); // false create! do not recreate if exist
//					if(of == null){
//						of = fs.open(nl.getLinkAddress() + ".txt", true); //only create if not exist.
//					} else {
//						//OVerwriteo
//						
//					}
					of = fs.open(nl.getLinkAddress() + ".txt", true); //just recreate
					int vectorSize = nl.fileList.size();
					String content = "";
					for (int i = 0; i < vectorSize; i++) {
						content += nl.fileList.get(i).fileName + "#"
								+ nl.fileList.get(i).fileSize + "#"
								+ nl.fileList.get(i).type
								+ "\n";
						new KThread(nl.fileList.get(i)).fork(); //fork means the thread will run concurrently
						//RUn config
						/*
						 * main class
						 * nachos machine
						 * 
						 * working directory
						 * other
						 * set to this project package folder
						 * 
						 * apply and run
						 */
						
					}
					//Overwrite Technique
					of.write(content.getBytes(), 0, content.getBytes().length);
					of.close(); //close file
					//Stub file system must true
				}
				break;
			case 3:
				break;
				
			default:
				break;
			}
			
		}while(input != 3);
		
		console.println(Machine.timer().getTime() + "");
		console.println(Machine.timer().getTime()/10000 + ""); //in soal there should be the formula to convert to second. if not, PROTEST MODE.
		
	}
	
}
