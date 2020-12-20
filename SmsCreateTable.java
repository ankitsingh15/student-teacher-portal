// wajp to establish connection with ojdbc11g and create a table student 

import java.sql.*;
import javax.swing.*;
	
class SmsCreateTable extends JFrame {
	public static void main(String args[]){
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "System" , "abc123");

			String sql = "create table newsmsuser (fname varchar(20), lname varchar(20), email varchar(50), mno varchar(20), uname varchar(20), pass varchar(20), cpass varchar(20))";
			Statement stmt = con.createStatement();
			stmt.executeUpdate(sql);    					// Java  to Oracle --> Parsing and Execution  
			con.close();
			JOptionPane.showMessageDialog(new JDialog(),"Table Created","Success",JOptionPane.INFORMATION_MESSAGE);
		} catch ( SQLException se ) {
			JOptionPane.showMessageDialog(new JDialog(),"Issue: " + se,"Error",JOptionPane.ERROR_MESSAGE);
		}  

	}
}