import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class NewDoner extends JFrame {

	String gender, blood;

	public NewDoner() { // Constructor

		setSize(600, 600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);

		Font font = new Font("Arial", Font.BOLD, 15);
		Font font1 = new Font("Arial", Font.BOLD, 18);

		// ------------->Panel 1
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 80);
		p1.setBackground(new Color(51, 153, 153));
		p1.setLayout(null);
		add(p1);

		// ------------->JLabel
		JLabel label1 = new JLabel("Doner Registration");
		label1.setBounds(0, 0, 600, 80);
		label1.setHorizontalAlignment(label1.CENTER);
		label1.setFont(new Font("Arial", Font.BOLD, 40));
		label1.setLayout(null);
		p1.add(label1);
		add(p1);

		// ------------->Panel 2
		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 600, 520);
		p2.setBackground(new Color(255, 102, 102));
		p2.setLayout(null);
		add(p2);

		// ------------->JLabel & JTextField
		JLabel name = new JLabel("Enter You Name:");
		name.setFont(font);
		name.setBounds(10, 0, 150, 50);

		JTextField txt1 = new JTextField();
		txt1.setFont(font);
		txt1.setBounds(10, 40, 470, 30);
		p2.add(name);
		p2.add(txt1);

		// ------------->JLabel & JTextField
		JLabel address = new JLabel("Enter You Address:");
		address.setFont(font);
		address.setBounds(10, 65, 150, 30);

		JTextField txt2 = new JTextField();
		txt2.setFont(font);
		txt2.setBounds(10, 92, 470, 30);
		p2.add(address);
		p2.add(txt2);

		// ------------->JLabel & JTextField
		JLabel Mobile = new JLabel("Enter You mobile number :");
		Mobile.setFont(font);
		Mobile.setBounds(10, 118, 250, 30);

		JTextField txt3 = new JTextField();
		txt3.setBounds(10, 145, 470, 30);
		txt3.setFont(font);
		p2.add(Mobile);
		p2.add(txt3);

		// ------------->JLabel & JTextField
		JLabel age = new JLabel("Enter You Age:");
		age.setFont(font);
		age.setBounds(10, 170, 250, 30);

		JTextField txt4 = new JTextField();
		txt4.setBounds(10, 200, 470, 30);
		txt4.setFont(font);
		p2.add(age);
		p2.add(txt4);

		// ------------->JLabel & JTextField
		JLabel sex = new JLabel("Sex:");
		sex.setFont(font1);
		sex.setBounds(10, 250, 100, 30);
		p2.add(sex);

//		--------------------------(JRadioButton)-----------------------------------

		// ------------->Male
		JRadioButton male = new JRadioButton("male");
		male.setBounds(60, 255, 100, 20);
		p2.add(male);

		// ------------->Female
		JRadioButton Female = new JRadioButton("Fmale");
		Female.setBounds(60, 280, 100, 20);
		p2.add(Female);

		// ------------->ButtonGroup
		ButtonGroup bg = new ButtonGroup();
		bg.add(male);
		bg.add(Female);

//		--------------------------***-----------------------------------

		// ------------->JLabel
		JLabel bloodgroup = new JLabel("Blood Group:");
		bloodgroup.setFont(font1);
		bloodgroup.setBounds(10, 310, 250, 50);
		p2.add(bloodgroup);

//		--------------------------(JComboBox)--------------------------------

		String course[] = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };

		JComboBox cb = new JComboBox(course);
		cb.setBounds(140, 325, 80, 20);
		name.setFont(font);
		p2.add(cb);

//		--------------------------(JButton)-----------------------------------

		// ------------->Register Button
		JButton Registerbtn = new JButton("Submit");
		Registerbtn.setBounds(400, 400, 150, 50);
		Registerbtn.setFont(new Font("Arial", Font.BOLD, 30));
		Registerbtn.setBackground(new Color(70, 130, 180));
		p2.add(Registerbtn);

		// ------------->Back Button
		JButton back_btn = new JButton("Back");
		back_btn.setBounds(50, 400, 150, 50);
		back_btn.setBackground(new Color(70, 130, 180));
		back_btn.setFont(new Font("Arial", Font.BOLD, 30));
		p2.add(back_btn);

//		--------------------------(ActionListener)-----------------------------------
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new HomePage();
			}
		});

		Registerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = txt1.getText();
				String address = txt2.getText();
				String mobile = txt3.getText();
				String age = txt4.getText();

				if (male.isSelected()) {
					gender = "Male";
				} else if (Female.isSelected()) {
					gender = "Female";
				}

				// Object is converted to String for finding gender
				Object bloodObj = cb.getSelectedItem();
				blood = bloodObj.toString();

				// ------------->Query
				String insertQuery = "INSERT INTO `donorregistration`(`Name`, `Address`, `Molile`, `Age`, `sex`, `Bloodgroup`)"
						+ "VALUES ('" + name + "','" + address + "','" + mobile + "','" + age + "', '" + gender + "','"
						+ blood + "')";

				// ------------->Query Passing
				RegisterDbconnection dbx = new RegisterDbconnection();
				dbx.InsertRegister(insertQuery);

				JOptionPane.showMessageDialog(null, "Successfully registered !!");

			}
		});

//		--------------------------***-----------------------------------

		setVisible(true);
	}

}
