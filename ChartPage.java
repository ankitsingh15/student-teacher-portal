import javax.swing.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;
import java.sql.*;

class ChartPage extends JFrame {
	
	
	ChartPage() 
	{

		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","abc123");

			String sql = "select * from student";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			DefaultCategoryDataset d1 = new DefaultCategoryDataset();

			while(rs.next()) {
				String srno = rs.getString(1);
				String sname = rs.getString(2);
				String ssub1 = rs.getString(3);
				String ssub2 = rs.getString(4);
				String ssub3 = rs.getString(5);

				int rno = Integer.parseInt(srno);
				int sub1 = Integer.parseInt(ssub1);
				int sub2 = Integer.parseInt(ssub2);	
				int sub3 = Integer.parseInt(ssub3);

				d1.addValue(sub1, sname, "Physics");
				d1.addValue(sub2, sname, "Chemistry");
				d1.addValue(sub3, sname, "Maths");
			}

			JFreeChart chart = ChartFactory.createBarChart("Student Performance", "Subjects", "Marks", d1, PlotOrientation.VERTICAL, true, false, false );
			ChartPanel panel = new ChartPanel(chart);
			setContentPane(panel);			

			setTitle("Marks Sheet");
			setSize(800, 400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);
			con.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
		}

	}


}