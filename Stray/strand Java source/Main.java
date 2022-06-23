import java.util.*;
class Main{

	public static void main (String[] args){
		/*WHILE
		while(1 + 1 == 2){
			System.out.println("anda benar!");

			} */
		/*DO
		do{
			System.out.println("anda benar lagi");
		}while(1+1 == 2);
		*/

		//misalnya print bintang 10 kali
		/*FOR
			for(int counter = 0; counter < 10; counter++){
			System.out.println("*");
			}*/

		//=== MENU ===
		/*Scanner scan = new Scanner(System.in);
		int choice = 0;

		do{
			System.out.println("Krusty Krab");
			System.out.println("===========");
			System.out.println("1. Call");
			System.out.println("2. Order");
			System.out.println("3. Exit");

			try{
				choice = scan.nextInt();
			}catch(Exception e){

			}finally{
			scan.nextLine();

			}

			if(choice == 1){//call
				String name;
				do{
					System.out.println("Patrick: Iya, Ada Apa?");
					System.out.print("Halo apakah ini dengan: ");
					name = scan.nextLine();
				}while(!name.equals("Patrick"));
				System.out.println("Patrick: iya ini patrick *telephone end*");


			} else if(choice == 2){//order
				System.out.println("ini menu order");

			} else if(choice == 0){
				System.out.println("PILIH YANG BENER DONG !");

			}

		}while(choice !=3 );
		*/

		String nama = "98danny";

			//System.out.println(nama.charAt(2));
			//System.out.println(nama.length());
		System.out.println
		(Character.isDigit(nama.charAt(0)));
		System.out.println
		(Character.isLetter(nama.charAt(0)));

		boolean idUdahBener = true;
		String idKaryawan = "BN123";

		if(idKaryawan.length() !=5){
			idUdahBener = false;
		}

		if(!idKaryawan.startsWith("BN")){
			idUdahBener = false;
		}

		if(!Character.iDigit(idKaryawan.charAt(2))){
			idUdahBener = false;
		}
		if(!Character.iDigit(idKaryawan.charAt(3))){
			idUdahBener = false;
		}
		if(!Character.iDigit(idKaryawan.charAt(4))){
			idUdahBener = false;
		}
		if(idUdahBener == true){
			System.out.println("id anda sudah benar");
		}
	}
}