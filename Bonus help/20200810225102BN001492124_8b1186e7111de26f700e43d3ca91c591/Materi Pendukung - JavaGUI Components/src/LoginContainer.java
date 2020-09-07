import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class LoginContainer extends JFrame implements ActionListener{
	
	public void init() {
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new BorderLayout());
	}
	
	JLabel title;
	JButton register;
	FieldPanel f = new FieldPanel();
	
	public LoginContainer() {
		init();
		
		title = new JLabel("Register",SwingConstants.CENTER);
		register = new JButton("Register");
		
		this.add(title,BorderLayout.NORTH);
		
		
		this.add(f, BorderLayout.CENTER);
		
		register.addActionListener(this);
		this.add(register,BorderLayout.SOUTH);
		
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new HomeFrame(f.username.getText());
	}
}
