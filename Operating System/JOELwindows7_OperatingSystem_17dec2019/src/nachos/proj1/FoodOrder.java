/**
 * 
 */
package nachos.proj1;

/**
 * @author JOELwindows7
 *
 */
public class FoodOrder implements Runnable{ //Implements the Runnable and its methods!!
	//Use Runnable in this area to make available special method whenever KThread forks Thread
	//this class
	private String CustomerName;
	private String FoodName;
	private int quantity;

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public String getFoodName() {
		return FoodName;
	}

	public void setFoodName(String foodName) {
		FoodName = foodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * 
	 */
	public FoodOrder() {
		// TODO Auto-generated constructor stub
		// ALT + SHIFT + S and generate getter setters
		// again and Generate constructor with fields
		// CTRL + SHIFT + F to tidy codings
	}

	public FoodOrder(String customerName, String foodName, int quantity) {
		super();
		CustomerName = customerName;
		FoodName = foodName;
		this.quantity = quantity;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Serving..."); //Use Sysout instead of MyConsole to prevent semaphore crash!!
		try { //always surround with try catch
			Thread.sleep(1000*quantity);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(CustomerName + "'s order is served!");
	}

}
