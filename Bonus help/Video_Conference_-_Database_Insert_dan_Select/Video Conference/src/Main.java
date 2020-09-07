import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Main extends JFrame implements ActionListener{
	//container : JFrame
	//subcontainer : JPanel, InternalFrame
	
	JButton add = new JButton("Add");
	JButton delete = new JButton("Delete");
	DefaultTableModel dtm = new DefaultTableModel();
	JTextField txtNama = new JTextField();
	JTextField txtAlamat = new JTextField();
	JTextField txtTelepon = new JTextField();
	DB database = new DB();
	
	public Main() {
		
		// menentukan ukuran dari suatu frame
		this.setSize(600, 500);
		
		// menentukan posisi dimana JFrame akan muncul, apabila diisi dengan null maka akan direferensikan ke layar
		this.setLocationRelativeTo(null);
		
		// menentukan action apa yang akan dilakukan saat frame ditutup
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		
		JPanel gridBag = new JPanel(new GridBagLayout());
		
		JLabel nama = new JLabel("Nama");
		JLabel alamat = new JLabel("Alamat");
		JLabel telepon = new JLabel("Telepon");
		
		// menambahkan event listener ke button, sehingga button dapat melakukan sesuatu ketika di click
		add.addActionListener(this);
		delete.addActionListener(this);
		
		// sebuah contraint / rule yang diterapkan kedalam gridbag saat memasukkan component
		GridBagConstraints gbc = new GridBagConstraints();
		// gridx dan gridy digunakan untuk menentukan koordinat dari component ketika dimasukkan
		gbc.gridx = 0;
		gbc.gridy = 0;
		
		// memberitau gridbag untuk mengisi cellnya secara horizontal, sehingga ukuran dari tiap kolom sama, sesuai dengan 
		// komponen yang paling lebar
		gbc.fill = GridBagConstraints.HORIZONTAL;
		//top right bottom left
		gbc.insets = new Insets(0, 30, 0, 30);
		
		gridBag.add(nama, gbc);
		
		gbc.gridx = 1;
		gridBag.add(alamat, gbc);
		
		gbc.gridx = 2;
		gridBag.add(telepon, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 0;
		gridBag.add(txtNama, gbc);

		gbc.gridy = 1;
		gbc.gridx = 1;
		gridBag.add(txtAlamat, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 2;
		gridBag.add(txtTelepon, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 3;
		gridBag.add(add, gbc);
		
		gbc.gridy = 1;
		gbc.gridx = 4;
		gridBag.add(delete, gbc);
		
		this.add(gridBag, BorderLayout.NORTH);
		
		JTable tblDaftarAlamat = new JTable();
		String[] columnHeaders = new String[] {
				"Nama", "Alamat", "Telepon"				
		};
		
		// memberikan column header kedalam table
		dtm.setColumnIdentifiers(columnHeaders);		
		
		//select dulu dari database nya
		try {
			//1.1. buat dulu statement
			Statement select_data_stmt = database.con.createStatement();
			
			//1.2. executequery() -> ambil resultnya
			
			ResultSet rs = select_data_stmt.executeQuery("SELECT * FROM info");
			
			//1.3. looping semua data
			while(rs.next()) {
				
				//1.4. masukkan data ke dalam dtm (default table model)
				dtm.addRow(new Object[] {
						rs.getString(2),
						rs.getString(3),
						rs.getString(4)
				});
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		// set model kedalam sebuah table
		tblDaftarAlamat.setModel(dtm);
		
		// berfungsi untuk membuat sebuah tabel dapat ditampilkan, dan apabila datanya berjumlah banyak,
		// dapat discroll untuk menampilkan datanya
		JScrollPane scrollPane = new JScrollPane(tblDaftarAlamat);
		
		this.add(scrollPane);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new Main();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// getSource berfungsi untuk memberikan sumber dari suatu action
		if(e.getSource() == add) {
			
			// menambahkan row kedalam table
			dtm.addRow(new Object[] {
					txtNama.getText(), txtAlamat.getText(), txtTelepon.getText()
			});
			
			// statement
			// buat terlebih dahulu interface statement
			try {
				Statement insert_data_stmt = database.con.createStatement();
				// Kalau mau pake cara manual, querynya seperti dibawah (object String x)
//				String x = "INSERT INTO info VALUES(null,\"" + txtNama.getText() + "\",\"" + 
//					txtAlamat.getText() + "\",\"" + txtTelepon.getText() + "\")";
				insert_data_stmt.execute(String.format
						("INSERT INTO info VALUES (null,\"%s\",\"%s\",\"%s\")", 
								txtNama.getText(),txtAlamat.getText(),txtTelepon.getText())
				);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			// memunculkan pop up message, memerlukan 2 parameter, yaitu parentComponent dan message
			// parentComponent berfungsi sebagai referensi dari pop up message untuk muncul di posisi mana
			JOptionPane.showMessageDialog(this, "Successfully Added");
		} else if(e.getSource() == delete) {
			txtNama.setText("");
			txtAlamat.setText("");
			txtTelepon.setText("");
			
			// getRowCount berfungsi untuk memberikan jumlah data (row) yang ada dalam table
			while(dtm.getRowCount() != 0) {
				dtm.removeRow(0);
			}
			
			JOptionPane.showMessageDialog(this, "Text Field Cleared");
		}
	}
	
}
