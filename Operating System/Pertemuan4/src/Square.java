
public class Square extends Shape implements Drawable {

	public Square(int side) {
		super(side);
		// TODO Auto-generated constructor stub
		
	}
	
	@Override
	public void printKeliling() {
		System.out.println("Keliling : " + (4*this.side));
	}
	
	public void printKeliling(int side) {
		System.out.println("Keliling");
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < this.side; i++) {
			for(int j = 0 ; j < this.side; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
