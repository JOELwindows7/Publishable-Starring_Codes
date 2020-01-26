
public abstract class Shape {
	protected int side;

	public Shape(int side) {
		super();
		this.side = side; //this = variable outside this function, in this class
		
		//alt shift s
	}
	
	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

//	private void test(){
//		super().draw();
//	}
	
//	public void printKeliling(){
//		//override example
//		System.out.println("side : " + this.side);
//	}
	
	public abstract void printKeliling();
}
