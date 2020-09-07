import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class MyTable{

	//jadi disini kita membuat tabel
	//untuk membuat tabel kita akan menggunakan
	//JTable kemudian untuk menyimpan data dan header
	//dari kolomnya kita akan menggunakan vector
	//untuk vector yang isinya data, dia harus berupa Vector of Vector
	//jadi Vectornya menyimpan Vector
	//kita disini juga akan menggunakan JScrollPane dikarenakan
	//JTable harus diisi kedalam JScrollPane karena bisa saja
	//data yang kita masukan melebihi size dari si frame kita.
	JTable table;
	Vector<Vector> data;
	Vector<String> header;
	JScrollPane pane;
	
	public MyTable() {
		// inisialisasi
		data = new Vector<>();
		header = new Vector<>();
		
		//menambahkan nama kolom untuk header tablenya nanti
		header.add("ID");
		header.add("Name");
		header.add("Age");
		
		//data yang kita akan masukkan
		Vector test = new Vector<>();
		test.addElement((int)(Math.random() * 150));
		test.addElement("Test");
		test.addElement(12);
		
		data.add(test);
		
		//inisialisasi JTable yang meng-passing data dan header
		table = new JTable(data, header);
		
		//masukan table kedalam pane
		pane = new JScrollPane(table);
	}

}
