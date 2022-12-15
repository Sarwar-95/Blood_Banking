import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RequestDb {

	private Connection con;
	private Statement st;
	 

	public RequestDb(){

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood bank management", "root", "");
			st = con.createStatement();

		} catch (Exception e) {
			 
		}
	}

//	--------------------------***-----------------------------------
	// ------------->Method
	public void bloodInsertRegister(String insertQuery) {

		try {
			st.executeUpdate(insertQuery);
			JOptionPane.showMessageDialog(null, "as soon as possible. we will contact you.");

		} catch (SQLException e) {
			// System.out.println(e);
			JOptionPane.showMessageDialog(null, "successfully not registered");

		}
	}
}
