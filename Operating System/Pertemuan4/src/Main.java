import java.util.Vector;

public class Main {

	static int hp = 100;
	
	public Main() {
		// TODO Auto-generated constructor stub
		
//		Shape shape1 = new Shape(10);
//		Square square1 = new Square(10);

//		Shape shape1 = new Square(10);
//		((Square)shape1).printKeliling(10);
		
		Vector<Shape> shapeList = new Vector<>();
		shapeList.add(new Square(10));
		shapeList.add(new Triangle(10));
		
		for (Shape shape : shapeList) {
			if(shape instanceof Square) {
				System.out.println("Square : ");
				shape.printKeliling();
				((Square) shape).draw();
			} else if(shape instanceof Triangle) {
				System.out.println("Triangle : ");
				shape.printKeliling();
				((Triangle) shape).draw();
			}
		}
		
		Thread thread = new Thread(new Runnable() {
						
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(hp > 0) {
					System.out.println(hp);
					hp -= 10;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		Thread thread2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(hp > 0) {
					System.out.println(hp);
					hp -= 10;
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		
		thread.start();
		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thread2.start();
		try {
			thread2.join();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
