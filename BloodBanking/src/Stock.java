import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Stock extends JFrame{
	
	RegisterDbconnection db = new RegisterDbconnection();
	
	public Stock() { // Constructor
		setSize(500, 300);
		setDefaultCloseOperation(3);
		setLocationRelativeTo(null);
		setLayout(null);
		setVisible(true);
		
		// ------------->JLabel
		JLabel top = new JLabel("Stock");
		top.setBounds(0,0,500,80);
		top.setOpaque(true);
		top.setBackground(Color.cyan);
		top.setHorizontalAlignment(JLabel.CENTER);
		top.setFont(new Font("Arial",Font.BOLD,30));
		add(top);
		
//		--------------------------(Button)-----------------------------------
		
		// ------------->Back Button 
		JButton back_btn = new JButton("Back");
        back_btn.setBounds(10,20,60,30);
        back_btn.setBackground(new Color(70,130,180));
        back_btn.setFont(new Font("Arial",Font.BOLD,10)); 
        top.add(back_btn);
        
		// ------------->Back Button ActionListener
        back_btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				new HomePage();
				dispose();
			}
		});
		
//		--------------------------(JTable)-----------------------------------
        
		Object data[][] = {{"",""}};
		String col[] = {"Blood Group", "Available in Stock"};
		
		DefaultTableModel model = new DefaultTableModel(data,col);
		model.removeRow(0);
		
		JTable table = new JTable(model);
		table.setEnabled(false);
		
		// ------------->JScrollPane
		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(0,80,500,400);
		add(sp);
		
		
//		--------------------------***-----------------------------------
		
		// ------------->Query
		String str = "SELECT Bloodgroup, COUNT(Bloodgroup) FROM donorregistration GROUP BY Bloodgroup ORDER BY COUNT(Bloodgroup)";
		
		RegisterDbconnection db = new RegisterDbconnection();
		
		// ------------->Result is a interface 
		ResultSet rs=db.donorList(str);
		
		try {
			while(rs.next()) {
				String blood = rs.getString(1);
				String stockNumber = rs.getString(2);
				
				Object temp[]= {blood,stockNumber};
				model.addRow(temp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

