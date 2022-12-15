import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class BloodRequest extends JFrame {

	String blood;

	public BloodRequest() { // Constructor

		setSize(500, 600);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);

		Font font = new Font("Arial", Font.BOLD, 18);

		// ------------->JLabel
		JLabel top = new JLabel("BloodRequest");
		top.setBounds(0, 0, 500, 80);
		top.setOpaque(true);
		top.setBackground(Color.cyan);
		top.setHorizontalAlignment(JLabel.CENTER);
		top.setFont(new Font("Arial", Font.BOLD, 35));
		add(top);

		// ------------->JPanel
		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 500, 520);
		p2.setLayout(null);
		add(p2);

		// --------------JLabel & Text Filed
		JLabel name = new JLabel("Enter You Name ");
		name.setFont(font);
		name.setBounds(10, 0, 200, 50);

		JTextField txt1 = new JTextField();
		txt1.setFont(font);
		txt1.setBounds(10, 35, 470, 30);
		p2.add(name);
		p2.add(txt1);

		// --------------JLabel & Text Filed
		JLabel address = new JLabel("What is the problem of the patient ");
		address.setFont(font);
		address.setBounds(10, 65, 350, 30);

		JTextField txt2 = new JTextField();
		txt2.setFont(font);
		txt2.setBounds(10, 90, 470, 30);
		p2.add(address);
		p2.add(txt2);

		// --------------JLabel & Text Filed
		JLabel amount = new JLabel("Amount ");
		amount.setFont(new Font("Arial", Font.BOLD, 19));
		amount.setBounds(10, 120, 250, 30);

		JTextField txt3 = new JTextField();
		txt3.setBounds(10, 145, 470, 30);
		txt3.setFont(font);
		p2.add(amount);
		p2.add(txt3);

		// --------------JLabel & Text Filed
		JLabel loction = new JLabel("Loction ");
		loction.setFont(new Font("Arial", Font.BOLD, 19));
		loction.setBounds(10, 170, 250, 30);

		JTextField txt4 = new JTextField();
		txt4.setBounds(10, 200, 470, 30);
		txt4.setFont(font);
		p2.add(loction);
		p2.add(txt4);

		// --------------JLabel & Text Filed
		JLabel Mobile = new JLabel("Enter You mobile number :");
		Mobile.setFont(font);
		Mobile.setBounds(10, 230, 250, 30);

		JTextField txt5 = new JTextField();
		txt5.setBounds(10, 260, 470, 30);
		txt5.setFont(font);
		p2.add(Mobile);
		p2.add(txt5);

		// --------------JLabel
		JLabel bloodgroup = new JLabel("Blood Group:");
		bloodgroup.setFont(font);
		bloodgroup.setBounds(10, 310, 250, 50);
		p2.add(bloodgroup);

//		--------------------------***-----------------------------------

		// --------------JComboBox
		String course[] = { "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-" };

		JComboBox cb = new JComboBox(course);
		cb.setBounds(150, 330, 80, 20);
		name.setFont(font);
		p2.add(cb);

//		--------------------------(Button)-----------------------------------

		// ------------->Register Button
		JButton Registerbtn = new JButton("Submit");
		Registerbtn.setBounds(325, 400, 140, 50);
		Registerbtn.setFont(new Font("Arial", Font.BOLD, 25));
		Registerbtn.setBackground(new Color(70, 130, 180));
		p2.add(Registerbtn);

		// ------------->Back Button
		JButton back_btn = new JButton("Back");
		back_btn.setBounds(20, 400, 140, 50);
		back_btn.setBackground(new Color(70, 130, 180));
		back_btn.setFont(font);
		back_btn.setFont(new Font("Arial", Font.BOLD, 25));
		p2.add(back_btn);

		// ------------->Back Button ActionListener
		back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				new HomePage();
				dispose();
			}
		});

		// ------------->Register Button ActionListener
		Registerbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String name = txt1.getText();
				String problem = txt2.getText();
				String amount = txt3.getText();
				String loction = txt4.getText();
				String number = txt5.getText();

				// Object is converted to String for finding gender
				blood = cb.getSelectedItem().toString();

				// ------------->Query
				String insertQuery = "INSERT INTO `request`(`Name`, `problem`, `Amount`, `Location`, `number`, `bloodgroup`)"
						+ "VALUES ('" + name + "','" + problem + "','" + amount + "','" + loction + "', '" + number
						+ "','" + blood + "')";

				RequestDb dbc = new RequestDb();
				dbc.bloodInsertRegister(insertQuery);

			}

		});

//		--------------------------***-----------------------------------
		setVisible(true);

	}
}
