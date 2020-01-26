
public abstract class Shape {

	protected int side;

	public Shape(int side) {
		super();
		this.side = side;
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}
	
	public abstract void printKeliling();	
		
}
