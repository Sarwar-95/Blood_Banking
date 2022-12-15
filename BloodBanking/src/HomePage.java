
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HomePage extends JFrame {

	public HomePage() { // Constructor

		setSize(600, 500);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);

		Font font = ((new Font("Arial", Font.BOLD, 25)));
		 
		// ------------->Panel 1
		JPanel p1 = new JPanel();
		p1.setBounds(0, 0, 600, 80);
		p1.setBackground(new Color(51, 153, 153));
		p1.setLayout(null);

		JLabel label1 = new JLabel("Homepage");
		label1.setBounds(0, 0, 600, 80);
		label1.setHorizontalAlignment(label1.CENTER);
		label1.setFont(new Font("Arial",Font.BOLD,40));
		label1.setLayout(null);
		p1.add(label1);
		add(p1);

		// ------------->Panel 2
		JPanel p2 = new JPanel();
		p2.setBounds(0, 80, 600, 420);
		p2.setBackground(new Color(255, 102, 102));
		p2.setLayout(null);
		add(p2);
		
//		--------------------------(Button)-----------------------------------
		
		// ------------->New Donor Button 
		JButton newDonorbtn = new JButton("Donor Registration");
		newDonorbtn.setBounds(150, 40,300, 40);
		newDonorbtn.setFont(font);
		p2.add(newDonorbtn);

		// ------------->New Donor Button ActionListener
		newDonorbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new NewDoner();
			}
		});

		
		// ------------->Search Donor Button 
		JButton SearchDonor = new JButton("Search Donor ");
		SearchDonor.setBounds(150, 110, 300, 40);
		SearchDonor.setFont(font);
		p2.add(SearchDonor);
		
		// ------------->Search Donor Button ActionListener
		SearchDonor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SearchDonor();
			}
		});

		
		// ------------->Blood Request Button 
		JButton Bloodrequest = new JButton("Blood Request");
		Bloodrequest.setBounds(150, 175, 300, 40);
		Bloodrequest.setFont(font);
		p2.add(Bloodrequest);
		
		// ------------->Blood Request Button ActionListener
		Bloodrequest.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new BloodRequest();
			}
		});
		
		// ------------->Stock Request Button 
		JButton Stockbtn = new JButton("Stock  ");
		Stockbtn .setBounds(150, 245, 300, 40);
		Stockbtn .setFont(font);
		p2.add(Stockbtn );
		
		// ------------->Stock Request Button ActionListener
		Stockbtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Stock();
			}
		});


//		--------------------------***-----------------------------------
		
		setVisible(true);
	}
}

