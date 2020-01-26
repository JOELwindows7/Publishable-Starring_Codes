package nachos.proj1;

public class Customer implements Runnable{
	//add unimplemented methods
	String customerName;
	String itemsName;
	Integer quantity;
	
	//alt + shift + s, then o
	public Customer(String customerName, String itemsName, Integer quantity) {
		super();
		this.customerName = customerName;
		this.itemsName = itemsName;
		this.quantity = quantity;
	}


	public Customer() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(customerName + " bought " + quantity + " pcs of " + itemsName);
	}

}
