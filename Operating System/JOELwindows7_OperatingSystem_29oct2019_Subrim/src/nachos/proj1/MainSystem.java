/**
 * 
 */
package nachos.proj1;

/**
 * @author JOELwindows7
 *
 */
public class MainSystem {
	
	Console console = new Console();

	/**
	 * 
	 */
	public MainSystem() {
		// TODO Auto-generated constructor stub
		System.out.println("Hello World");
		//String str = console.read();
		//System.out.println(str); //di nachos haram. gk boleh
		//console.print(str);
		
		int num = console.readInt();
		console.println("" + num); 
	}

}
