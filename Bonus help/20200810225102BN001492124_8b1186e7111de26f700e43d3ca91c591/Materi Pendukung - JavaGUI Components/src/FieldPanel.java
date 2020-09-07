import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FieldPanel extends JPanel{
	
	JTextField username;
	JPasswordField password;
	JPasswordField confirm_password;
	JLabel ulabel;
	JLabel plabel;
	JLabel cplabel;
	GridBagConstraints g;
	JCheckBox check;
	
	public FieldPanel() {
		this.setLayout(new GridBagLayout());
		
		g = new GridBagConstraints();
		ulabel = new JLabel("Username",SwingConstants.LEFT);
		g.gridx = 0;
		g.gridy = 0;
		g.ipady = 15;
		g.ipadx = 175;
		this.add(ulabel,g);

		username = new JTextField();
		g.gridx++;
		this.add(username,g);
		
		plabel = new JLabel("Password",SwingConstants.LEFT);
		g.gridx = 0;
		g.gridy++;
		this.add(plabel,g);
		
		password = new JPasswordField();
		g.gridx++;
		
		this.add(password,g);
		
		cplabel = new JLabel("Confirm Password",SwingConstants.LEFT);
		g.gridx = 0;
		g.gridy++;
		this.add(cplabel,g);
		
		confirm_password = new JPasswordField();
		g.gridx++;
		this.add(confirm_password,g);
		
		check = new JCheckBox("I agree with terms and agreement");
		g.gridx = 0;
		g.gridy++;
		g.gridwidth = 2;
	    g.fill = GridBagConstraints.HORIZONTAL;
		this.add(check,g);
		
	}

}
