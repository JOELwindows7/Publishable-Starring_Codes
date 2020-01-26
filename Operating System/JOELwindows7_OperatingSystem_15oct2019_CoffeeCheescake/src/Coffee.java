/**
 * 
 */

/**
 * @author prk
 *
 */
public class Coffee extends Food {
	public Coffee(){
		super("Coffee");
		AskCoffeeQuestion();
	}
	private int NumSize;
	private String size;
	private int sizePrice;
	private void CalculateSize(){
		sizePrice = NumSize * 5000;
	}
	private String TypeTemperature;
	
	protected void CalculateTotal(){
		this.TotalPrice = (this.BasePrice + sizePrice) * this.Qty;
	}
	private void AskCoffeeQuestion(){
		do {
			System.out.print("Input order size [Small | Medium | Large]: ");
			size = this.SubScan.nextLine();
		} while (!size.equals("Small") && !size.equals("Medium") && !size.equals("Large"));
		
		System.out.println("Input order type [Cold | Hot]: ");
		TypeTemperature = this.SubScan.nextLine();
	}
}
