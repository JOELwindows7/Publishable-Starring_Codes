package nachos.proj1;

public class FoodOrder implements Runnable {

	private String customerName;
	private String foodName;
	private int quantity;

	public FoodOrder(String customerName, String foodName, int quantity) {
		super();
		this.customerName = customerName;
		this.foodName = foodName;
		this.quantity = quantity;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public void run() {
		System.out.println("Serving...");
		
		try {
			Thread.sleep(1000 * quantity);
		} catch (InterruptedException e) {

		}
		
		System.out.println(customerName + "'s order is served");
		
		
	}

}
