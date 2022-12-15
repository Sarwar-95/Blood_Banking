import java.awt.Color;
import java.text.Format;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegisterForm extends JFrame {

	public RegisterForm() { // Constructor

		setSize(650, 600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);

		// ------------->Font Style
		Font font = new Font("Arial", Font.BOLD, 25);
		Font font1 = new Font("Arial", Font.BOLD, 40);

		// ------------->Panel 1
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 650, 80);
		p1.setBackground(new Color(51, 153, 153));
		p1.setLayout(null);

		// ------------->JLabel 1
		JLabel label1 = new JLabel("Registration");
		label1.setBounds(0, 0, 650, 80);
		label1.setHorizontalAlignment(label1.CENTER);
		label1.setFont(font1);
		label1.setLayout(null);
		p1.add(label1);
		add(p1);

		// ------------->JPanel 2
		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 650, 520);
		p2.setBackground(new Color(255, 102, 102));
		p2.setLayout(null);
		add(p2);

		// ------------->User name & Text Filed
		JLabel username = new JLabel("User Name:");
		username.setFont(font);
		username.setBounds(100, 20, 170, 70);

		JTextField txt = new JTextField();
		txt.setFont(font);
		txt.setBounds(250, 30, 310, 50);
		p2.add(username);
		p2.add(txt);

		// ------------->Email & Text Filed
		JLabel Email = new JLabel("Email:");
		Email.setFont(font);
		Email.setBackground(new Color(70, 130, 180));
		Email.setBounds(165, 80, 170, 70);

		JTextField EmailTxt = new JTextField();
		EmailTxt.setFont(font);
		EmailTxt.setBounds(250, 90, 310, 50);
		p2.add(Email);
		p2.add(EmailTxt);

		// ------------->Mobile & Text Filed
		JLabel Mobile = new JLabel("Mobile:");
		Mobile.setFont(font);
		Mobile.setBounds(155, 140, 170, 70);

		JTextField MobileTxt = new JTextField();
		MobileTxt.setBounds(250, 150, 310, 50);
		MobileTxt.setFont(font);
		p2.add(Mobile);
		p2.add(MobileTxt);

		// ------------->Password & Text Filed
		JLabel Password = new JLabel("Password:");
		Password.setFont(font);
		Password.setBounds(115, 200, 170, 70);

		JPasswordField PasswordTxt = new JPasswordField();
		PasswordTxt.setFont(font);
		PasswordTxt.setBounds(250, 210, 310, 50);
		p2.add(Password);
		p2.add(PasswordTxt);

		// ------------->Confirm Password & Text Filed
		JLabel ConfirmPassword = new JLabel("Confirm Password:");
		ConfirmPassword.setFont(font);
		ConfirmPassword.setBounds(15, 260, 300, 70);

		JPasswordField ConfirmPasswordTxt = new JPasswordField();
		ConfirmPasswordTxt.setFont(font);
		ConfirmPasswordTxt.setBounds(250, 270, 310, 50);
		p2.add(ConfirmPassword);
		p2.add(ConfirmPasswordTxt);

		// ------------->Address & Text Filed
		JLabel Address = new JLabel("Address:");
		Address.setFont(font);
		Address.setBounds(135, 320, 170, 70);

		JTextField AddressTxt = new JTextField();
		AddressTxt.setFont(font);
		AddressTxt.setBounds(250, 330, 310, 50);
		p2.add(Address);
		p2.add(AddressTxt);

//		--------------------------***-----------------------------------

		// ------------->Login Button
		JButton loginbtn = new JButton("Login");
		loginbtn.setBounds(100, 410, 115, 40);
		loginbtn.setFont(font);
		p2.add(loginbtn);

		// ------------->Register Button
		JButton Registerbtn = new JButton("Register");
		Registerbtn.setBounds(420, 410, 140, 40);
		Registerbtn.setFont(font);
		p2.add(Registerbtn);

//		--------------------------***-----------------------------------

		// ------------->Login Button ActionListener
		loginbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new LoginForm();
			}
		});

		// ------------->Register Button ActionListener
		Registerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String username = txt.getText();
				String email = EmailTxt.getText();
				String mobile = MobileTxt.getText();
				String password = PasswordTxt.getText();
				String confirmpassword = ConfirmPasswordTxt.getText();
				String Address = AddressTxt.getText();

				// ------------->Query
				String insertQuery = "INSERT INTO `register`(`username`, `email`, `pass`, `mobile`, `Address`)"
						+ " VALUES ('" + username + "','" + email + "','" + password + "','" + mobile + "','" + Address
						+ "')";

				// ------------->Query Passing
				DbConnect db = new DbConnect();
				db.InsertRegister(insertQuery);

			}

		});
		
//		--------------------------***-----------------------------------
		
		setVisible(true);
	}
}
