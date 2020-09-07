import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class MyFrame extends JFrame implements ActionListener{

	public void init() {
		this.setSize(800,600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	}
	
	//Kita dapat membuat toolbar yang horizontal atau vertical.
	JToolBar toolbar;
	JButton send;
	JButton clear;
	MyTable table;
	
	JLabel lbl_name;
	JTextField name;
	JLabel lbl_age;
	JTextField age;
	
	GridBagConstraints g;
	
	public MyFrame() {
		init();
		toolbar = new JToolBar();
		toolbar.setPreferredSize(new Dimension(280,400));
		
		g = new GridBagConstraints();
		
		//toolbar itu dapat kita temukan seperti pada photoshop
		//yang memiliki tools" yang dapat kita gunakan
		//nah pada JToolBar kita dapat mengset layoutnya
		//kemudian menambahkan component ke dalamnya.
		toolbar.setLayout(new GridBagLayout());
		
		lbl_name = new JLabel("Name");
		lbl_name.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_age = new JLabel("Age");
		lbl_age.setHorizontalAlignment(SwingConstants.CENTER);
		name = new JTextField();
		age = new JTextField();
		
		g.gridy++;
		g.ipady = 15;
		g.ipadx = 250;
		toolbar.add(lbl_name,g);
		g.gridy++;
		toolbar.add(name,g);
		g.gridy++;
		toolbar.add(lbl_age,g);
		g.gridy++;
		toolbar.add(age,g);
		g.gridy++;
		
		send = new JButton("Send");
		send.addActionListener(this);
		clear = new JButton("Clear");
		clear.addActionListener(this);
		
		g.ipadx = 40;
		g.gridy++;
		toolbar.add(send,g);
		g.ipadx = 39;
		g.gridy++;
		toolbar.add(clear,g);
		
		table = new MyTable();
		
		this.add(toolbar,BorderLayout.WEST);
		this.add(table.pane,BorderLayout.CENTER);
		
		this.setVisible(true);
	}


	//berikut adalah action listener, dimana kita bisa menambahkan 
	//action yang dilakukan jika kita melakukan sesuatu seperti 
	//mengclick sebuah button atau yang lainnya
	@Override
	public void actionPerformed(ActionEvent e) {
		//jadi kita bisa mendapatkan nama actionnya berdasarkan button nya
		//menggunakan getActionCommand()
		//untuk component lain bisa saja berbeda jadi bisa di cek cek sendiri
		if(e.getActionCommand().equals("Send")) {
			
			//kita ambil data yang ada dari text field dan kita
			//masukan ke dalam vector
			Vector a = new Vector();
			
			a.addElement((int)(Math.random() * 150));
			a.addElement(name.getText().toString());
			a.addElement(age.getText().toString());
			
			//kita tambahkan datanya kedalam vector
			table.data.add(a);
			
			//lalu kita beritahu kepada si table yang ada di object table
			//kalau datanya ada kita tambahin
			//supaya tampilan nya bertambah
			((DefaultTableModel)table.table.getModel()).fireTableDataChanged();
			
			//jika ditekan tombol send maka yang kita lakukan adalah menampilkan messageDialog
			//nah temen - temen disini bisa membuat langsung object JOptionPane atau dibedakan
			//satu per satu
			new JOptionPane().showMessageDialog(this, "Send successful");
			
		}else if(e.getActionCommand().equals("Clear")) {
			name.setText("");
			age.setText("");
			new JOptionPane().showMessageDialog(this, "Cleared!");
		}
	}

}
