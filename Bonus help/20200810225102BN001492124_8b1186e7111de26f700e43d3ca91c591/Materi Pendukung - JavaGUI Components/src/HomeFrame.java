import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomeFrame extends JFrame{
	public HomeFrame(String name) {
		this.setSize(200,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		JLabel j = new JLabel("Hello " + name);
		this.add(j);
		this.setVisible(true);
	}
}
