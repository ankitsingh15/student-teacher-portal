import org.hibernate.*;
import org.hibernate.cfg.*;
import javax.swing.*;
import java.util.*;
import java.sql.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.category.*;

class DbHandler {

	public static boolean checkUsernameExists(String username)
	{
    		boolean usernameExists = false;
		try
    		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","abc123");

			String sql = "select * from newsmsuser";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);       			

        			String usernameCounter;
         			while(rs.next()) 
         			{
           				usernameCounter =  rs.getString("uname");
           				if(usernameCounter.equals(username))
           				{
              					usernameExists = true;
           				}
         			}
			
			con.close();


    		 }

     		catch (SQLException e) 
     		{
        			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
     		} 
     		
		return usernameExists;
 	}

	
	public static boolean checkEmailExists(String email)
	{
    		boolean emailExists = false;
		try
    		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","abc123");

			String sql = "select * from newsmsuser";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);       			

        			String emailCounter;
         			while(rs.next()) 
         			{
           				emailCounter =  rs.getString("email");
           				if(emailCounter.equals(email))
           				{
              					emailExists = true;
           				}
         			}
			
			con.close();


    		 }

     		catch (SQLException e) 
     		{
        			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
     		} 
     		
		return emailExists;
 	}

	public static boolean checkMnoExists(String mno)
	{
    		boolean mnoExists = false;
		try
    		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","abc123");

			String sql = "select * from newsmsuser";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);       			

        			String mnoCounter;
         			while(rs.next()) 
         			{
           				mnoCounter =  rs.getString("mno");
           				if(mnoCounter.equals(mno))
           				{
              					mnoExists = true;
           				}
         			}
			
			con.close();
		}

     		catch (SQLException e) 
     		{
        			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
     		} 
     		
		return mnoExists;
 	}

		
	public static boolean checkPassword(String username, String password)
	{
    		boolean correctPassword = false;
		try
    		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","abc123");

			String sql = "select pass from newsmsuser where uname= ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
        			ResultSet rs = stmt.executeQuery();

			
			String pass;
			while(rs.next()) 
         			{
           				pass =  rs.getString("pass");
           				if(pass.equals(password))
           				{
              					correctPassword = true;
           				}
         			}

			con.close();
		}

     		catch (SQLException e) 
     		{
        			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
     		} 
     		
		return correctPassword;
 	}

	public static boolean checkEmail(String username, String email)
	{
    		boolean correctEmail = false;
		try
    		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","abc123");

			String sql = "select email from newsmsuser where uname= ?";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, username);
        			ResultSet rs = stmt.executeQuery();

			
			String givenemail;
			while(rs.next()) 
         			{
           				givenemail =  rs.getString("email");
           				if(givenemail.equals(email))
           				{
              					correctEmail = true;
           				}
         			}

			con.close();
		}

     		catch (SQLException e) 
     		{
        			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
     		} 
     		
		return correctEmail;
 	}

	public static void updatePassword(String username, String newpass) {
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL", "System" , "abc123");

			String sql = "update newsmsuser set pass = ? where uname = ?";
			PreparedStatement stmt = con.prepareStatement(sql);
				
			stmt.setString(1, newpass);
			stmt.setString(2, username);
			
			JOptionPane.showMessageDialog(new JDialog(), "Password Updated. ", "Success",JOptionPane.INFORMATION_MESSAGE);
			con.close();
			
		} catch ( SQLException se ) {
			JOptionPane.showMessageDialog(new JDialog(), " Issue " + se );
		}  
	}
	
	public static void addData(String srno, String sname, String ssub1, String ssub2, String ssub3){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	
		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		Transaction t =  null;
 
		try {
			session = sfact.openSession();
			t = session.beginTransaction();

			Student s = (Student)session.get(Student.class, srno);
		
			Student a = (Student)session.get(Student.class, sname);

			if ( (s == null) && (a == null) ) {
				Student b1 = new Student(srno, sname, ssub1, ssub2, ssub3);
				session.save(b1);
				t.commit();
				JOptionPane.showMessageDialog(new JDialog(), "Record Inserted.", "Sucess",JOptionPane.INFORMATION_MESSAGE);
			}  else {
				JOptionPane.showMessageDialog(new JDialog(),"Marks already entered for the above student. Please proceed to UPDATE section in order to update the marks.","Duplicate Data",JOptionPane.ERROR_MESSAGE);
			}
	
			
				
		} catch( Exception e ) {
			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
			t.rollback();
		} finally {
			if ( session != null ) {
				session.close();
			}
		}
	}

	
	public static void updateData(String srno, String sname, String ssub1, String ssub2, String ssub3){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	
		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		Transaction t =  null;
 
		try {
			session = sfact.openSession();
			t = session.beginTransaction();

			Student s = (Student)session.get(Student.class, srno);

			if ( (s == null)) {
				JOptionPane.showMessageDialog(new JDialog(),"Roll No. does not exist. ","Invalid Data",JOptionPane.ERROR_MESSAGE);
			}  else {  
				s.setSname(sname);
				s.setSsub1(ssub1);
				s.setSsub2(ssub2);
				s.setSsub3(ssub3);
				session.save(s);
				t.commit();
				JOptionPane.showMessageDialog(new JDialog(), "Record Updated.", "Sucess",JOptionPane.INFORMATION_MESSAGE);
			}
	
		} catch( Exception e ) {
			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
			t.rollback();
		} finally {
			if ( session != null ) {
				session.close();
			}
		}
	}


	public static String viewStudent() {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	
		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		
		String msg="";
		int i = 1;
		try {
			session = sfact.openSession();
			

			List<Student> studentList = new ArrayList<>();
			studentList = session.createQuery("from Student").list();
			
			for(Student b : studentList){			
				 msg = msg + i + ") " + "Rno: " + b.getSrno() + " |" +" Name: " + b.getSname()  + " |" + " S1 mks: " + b.getSsub1() + " |"+ " S2 mks: " + b.getSsub2() + " |"+ " S3 mks: " + b.getSsub3() + "\n";
				 i++;
			}
			
		} catch( Exception e ) {
			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
			
		} finally {
			if ( session != null ) {
				session.close();
			}
		}

		return msg;
	}

	
	public static void deleteData(String srno){
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
	
		SessionFactory sfact = cfg.buildSessionFactory();
		Session session = null;
		Transaction t =  null;

		try {
			session = sfact.openSession();
			t = session.beginTransaction();
			Student s = (Student)session.get(Student.class, srno);

			if ( s == null )
				JOptionPane.showMessageDialog(new JDialog(),"Roll No. does not exist. ","Invaild Data",JOptionPane.ERROR_MESSAGE);
			else {
				session.delete(s);
				t.commit();
				JOptionPane.showMessageDialog(new JDialog(), "Record Deleted.", "Sucess",JOptionPane.INFORMATION_MESSAGE);
			}
			
		} catch( Exception e ) {
			JOptionPane.showMessageDialog(new JDialog(), " Issue " + e );
			t.rollback();
		} finally {
			if ( session != null ) {
				session.close();
			}
		} 
	}


	public static void newUser(String fname, String lname, String email, String mno, String uname, String pass, String cpass){
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","System","abc123");
			
			String sql = "insert into newsmsuser values(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, email);
			pstmt.setString(4, mno);
			pstmt.setString(5, uname);
			pstmt.setString(6, pass);
			pstmt.setString(7, cpass);

			pstmt.executeUpdate();
			con.close();
		} catch(SQLException se) {
			JOptionPane.showMessageDialog(new JDialog(), " Issue " + se );
		
		}
	}

	public static boolean validateFirstName(String firstName )
  	{
      		return firstName.matches( "[a-zA-Z][a-zA-Z][a-zA-Z]*" );
   	}

	public static boolean validateLastName(String lastName )
  	{
      		return lastName.matches( "[a-zA-Z][a-zA-Z]*" );
   	}

	public static boolean validateName(String fullName )
   	{
      		return fullName.matches( "[a-zA-Z][a-zA-Z][a-zA-Z]*+([ '-][a-zA-Z]+)*" );
   	}

	public static boolean validateMno(String mno)
   	{
      		return mno.matches( "[789][0-9]{9}" );
   	} 

	public static boolean validateMarks(String mks)
   	{
		int marks = Integer.parseInt(mks);
		boolean value = (( marks >= 0) && ( marks <=100 )) ? true : false;
		return value;
   	}

	public static boolean validateUsername(String uname)
   	{
      		return uname.matches( "[A-Za-z0-9_.]+" );
   	}

	public static boolean validateEmail(String email) 
	{
   		 return email.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	}

	public static boolean validateRno(String rno)
   	{
      		return rno.matches( "[0-9][0-9]*" );
   	}	

	

}