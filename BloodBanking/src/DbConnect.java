import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.JOptionPane;

public class DbConnect {

	private Connection con;
	private Statement st;
	ResultSet rs;
	int flag = 0;

	public DbConnect() { // Constructor

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood bank management", "root", "");
			st = con.createStatement();

		} catch (Exception e) {

		}
	}

	// ------------->InsertRegister is a method
	public void InsertRegister(String insertQuery) {

		try {

			st.executeUpdate(insertQuery);
			JOptionPane.showMessageDialog(null, "successfully registered");

		} catch (SQLException e) {

		}

	}

	// ------------->login is a method
	public void login(String querylogin, String email, String password) {

		try {
			rs = st.executeQuery(querylogin);
			while (rs.next()) {
				String tableemail = rs.getString(2);

				String tablepassword = rs.getString(3);

				if (email.equals(tableemail) && password.equals(tablepassword)) {

					JOptionPane.showMessageDialog(null, "successful login ");

					flag = 1;
					LoginForm f1 = new LoginForm();

					f1.dispose();
					new HomePage();
					break;
				}
			}
			if (flag == 0) {

				JOptionPane.showMessageDialog(null, "You are not a valid user!!");
			}

		}

		catch (Exception e) {
			e.printStackTrace();

		}

	}
}
