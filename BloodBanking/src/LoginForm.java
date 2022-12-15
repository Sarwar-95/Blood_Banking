import java.text.Format;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {

	public LoginForm() {

		setSize(500, 400);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);

		Font font = new Font("Arial", Font.BOLD, 15);
		Font font1 = new Font("Arial", Font.BOLD, 20);
		
		// ------------->Panel 1
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 500, 80);
		p1.setBackground(new Color(51, 153, 153));
		p1.setLayout(null);


		// ------------->JLabel 1
		JLabel label1 = new JLabel("Login");
		label1.setBounds(0, 0, 500, 80);
		label1.setHorizontalAlignment(label1.CENTER);
		label1.setFont(new Font("Arial",Font.BOLD,40));
		label1.setBackground(Color.cyan);
		label1.setLayout(null);
		p1.add(label1);
		add(p1);

		// ------------->Panel 2
		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 500, 320);
		p2.setBackground(new Color(255, 255, 204));
		p2.setLayout(null);
		add(p2);
		
		// ------------->JLabel email & Text Filed
		JLabel email = new JLabel("Email: ");
		email.setFont(font1);
		email.setBounds(80,20,100, 70);

		JTextField t1 = new JTextField();
		t1.setFont(font1);
		t1.setBounds(150, 30, 250, 50);
		p2.add(email);
		p2.add(t1);


		// ------------->Password & Text Filed
		JLabel password = new JLabel("Password: ");
		password.setFont(font1);
		password.setBounds(40, 80, 200, 70);

		JPasswordField pass = new JPasswordField();
		pass.setFont(font1);
		pass.setBounds(150,90, 250, 50);
		p2.add(password);
		p2.add(pass);

		JLabel not = new JLabel("Don't Have Account? ");
		not.setFont(font);
		not.setBounds(20,200, 200, 70);
		p2.add(not);
		
//		--------------------------***-----------------------------------
		
		// ------------->Register Button
		JButton Registerbtn = new JButton("Click Here");
		Registerbtn.setBounds(180,220, 110,30);
		Registerbtn.setFont(font);
		p2.add(Registerbtn);


		// ------------->Login Button
		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(290, 160, 110, 40);
		loginbtn.setFont(new Font("Arial",Font.BOLD,25));
		p2.add(loginbtn);
		

//		--------------------------***-----------------------------------
		
		// ------------->Register Button ActionListener
		Registerbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new RegisterForm();
			}
		});
		
		
		// ------------->Login Button ActionListener
		loginbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String email = t1.getText(); 
				String password = pass.getText();
				
				// ------------->Query 
				String querylogin = "SELECT * FROM `register`";
				
				// ------------->Query Passing
				DbConnect db = new DbConnect ();
				db.login(querylogin, email, password);
				dispose();
			}
			
		});
//		--------------------------***-----------------------------------
		
		setVisible(true);
	}
}

