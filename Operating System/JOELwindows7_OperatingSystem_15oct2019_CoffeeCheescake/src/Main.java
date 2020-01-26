import java.util.*;

/**
 * 
 */

/**
 * @author JOELwindows7
 *
 */
public class Main {
	public Main(){
		Scanner scan = new Scanner(System.in);
		String menuKey = "";
		ClearScreenTitle();
		
		do {
			System.out.print("Choose menu you want to order [Coffee | Cheese Cake]: ");
			menuKey = scan.nextLine();
		} while (menuKey.equals("Coffee") == false && menuKey.equals("Cheese Cake") == false);
		
		ClearScreenTitle();
		switch(menuKey){
		case "Coffee":
			break;
		case "Cheese Cake":
			break;
		default:
			break;
		}
	}
	public void ClearScreenTitle(){
		for (int i = 0; i < 50; i++) {
			System.out.println(); //please how to clear screen!
		}
		String Title = "Fnbucks Coffee Shop";
		System.out.println(Title);
		for (int i = 0; i < Title.length(); i++) {
			System.out.print("=");
		}
		System.out.println("\n");
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
