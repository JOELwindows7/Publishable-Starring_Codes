import java.util.Vector;

/**
 * 
 */

/**
 * @author prk
 *
 */
public class Main {
	
	static int hp = 100; //carry this static outside constructor
	
	public Main(){
		//Press Workbench on Welcome
		
//		Shape shape1 = new Shape(10);
//		Square square1 = new Square(10);
//		square1.setSide(11);
		//ctrl slash to comment block selected
		
//		Shape shape1 = new Square(10);
//		((Square)shape1).printKeliling(10); //type casing ((s)a).function;
		
		Vector<Shape> shapeList = new Vector<>();
		shapeList.add(new Square(10));
		shapeList.add(new Triangle(10));
		
		for (Shape shape : shapeList) {
			if(shape instanceof Square){
				//instanceof is typeof in Java.
				System.out.println("Square : ");
				shape.printKeliling();
				((Square)shape).draw();
			} else if(shape instanceof Triangle){
				System.out.println("Triangle : ");
				shape.printKeliling();
				((Triangle)shape).draw();
			}
		}
		
		
		
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(hp > 0){
					//thread keep running until HP 0
					System.out.println(hp);
					hp -= 10; //cannot access var from parent thread.
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} //block selected function then alt shift z
				}
			}
		});
		
		
		
		//Copy Paste
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(hp > 0){ //if using same static hp value, this thread2 and thread will attack hp together!
					//thread keep running until HP 0
					System.out.println(hp);
					hp -= 10; //cannot access var from parent thread.
					try {
						Thread.sleep(1000);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					} //block selected function then alt shift z
				}
			}
		});
		
		thread.start(); //start the thread
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start(); //start the thread
		try {
			thread2.join(); //join will make thread sync each other, waiting each other. so no print together
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main(); //this is already a thread
	}
	
	//abstract. for the classification of object
	//cannot directly call constructor. blueprint only. general types.
	//cannot instance object (new Class_name(var). use its child to do so!
	//usually for classification purpose, general imaging of object.
	//e.g Warrior and Mage has ATK and DEF
	//therefore we make abstract of Hero (that Warrior and Mage inherits from), 
	//because definitely has these two variables.

}
