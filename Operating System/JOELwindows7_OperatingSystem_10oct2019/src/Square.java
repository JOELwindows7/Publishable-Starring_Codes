import org.w3c.dom.events.MouseEvent;

/**
 * 
 */

/**
 * @author JOELwindows7
 *
 */
public class Square extends Shape implements Drawable{ //implement. can implement many interfaces
	//int side;
	public Square(int side) {
		super(side);
		// TODO Auto-generated constructor stub
	} //to avoid diamond inherit, you can only extend 1 class.
	
	@Override //tag it override
	public void printKeliling(){
		//Square overrides the superclass
		System.out.println("Keliling : " + (4*this.side));
	}
	
	public void printKeliling(int side){
		System.out.println("Keliling");
	}
	
	public void printKeliling(int side, String test){
		//overload. same method but this time it has different parameter
		//System.out.println("Keliling");
		printKeliling(side);
	}
	
	public void printKeliling(String test, int side){
		printKeliling(side, test);
	}

	@Override
	public void draw() { //draw() is from interface, if in case super() has draw, use super().draw()
		// TODO Auto-generated method stub
		for(int i = 0; i<this.side;i++){
			for(int j = 0; j < this.side; j++){
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
