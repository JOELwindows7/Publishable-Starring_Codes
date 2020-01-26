import java.util.Scanner;

import javax.swing.plaf.synth.SynthSpinnerUI;

/**
 * 
 */

/**
 * @author JOELwindows7
 *
 */
public abstract class Food {
	protected Scanner SubScan = new Scanner(System.in);
	private String subMenuKey = "";
	public Food(String ClassName){
		System.out.println("Order " + ClassName + ": ");
		
		do {
			System.out.print("Input order name [5..20 characters]: ");
			subMenuKey = SubScan.nextLine();
		} while (subMenuKey.length() < 5 || subMenuKey.length() > 20);
	}
	protected String Name;
	protected int Qty;
	protected int Rating;
	
	protected int BasePrice;
	protected void CalculateBase(){
		BasePrice = Rating * 10000;
	}
	protected int TotalPrice;
	protected abstract void CalculateTotal();
	protected void askRestOfBasic(){
		
	}
}
