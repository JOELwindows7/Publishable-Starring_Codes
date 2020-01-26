
public class Triangle extends Shape implements Drawable{

	public Triangle(int side) {
		super(side);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void printKeliling() {
		// TODO Auto-generated method stub
		System.out.println("Keliling : " + (3*this.side));
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i < this.side; i++) {
			for(int j = 0 ; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
