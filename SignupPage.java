import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class SignupPage extends JFrame {
	Container c;
	JLabel lblFName, lblLName, lblEmail,lblMno, lblUsername, lblPassword, lblPreNo, lblConfirmPassword,lblBlank;
	JTextField txtFName, txtLName, txtEmail, txtMno, txtUsername; 
	JButton btnSubmit, btnBack;
	JPasswordField txtPassword, txtConfirmPassword;
	
	SignupPage(){
		c = getContentPane();
		c.setLayout(new FlowLayout());
	
		lblFName = new JLabel("Enter First Name: ");
		lblLName = new JLabel("Enter Last Name: ");
		lblEmail = new JLabel("Enter Email ID:     ");
		lblPreNo = new JLabel("+91");
		lblMno = new JLabel("Enter Mobile No: ");
		lblUsername = new JLabel("Enter Username: ");
		lblPassword = new JLabel("Enter Password: ");
		lblConfirmPassword = new JLabel("Confirm Password:");
		lblBlank = new JLabel("    ");

		txtFName = new JTextField(15);
		txtLName = new JTextField(15);
		txtEmail = new JTextField(15);
		txtMno = new JTextField(13);
		txtUsername = new JTextField(15);
		txtPassword = new JPasswordField(15);
		txtConfirmPassword = new JPasswordField(14);

		btnSubmit = new JButton("Submit");
		btnBack = new JButton("Back");

		c.add(lblFName);	c.add(txtFName);	c.add(lblLName);	c.add(txtLName);	c.add(lblEmail);
		c.add(txtEmail);	c.add(lblMno);	c.add(lblPreNo);	c.add(txtMno);	c.add(lblUsername);
		c.add(txtUsername);	c.add(lblPassword);		c.add(txtPassword);	c.add(lblConfirmPassword);	c.add(txtConfirmPassword);
		c.add(lblBlank);	c.add(btnSubmit);	 c.add(lblBlank);	c.add(btnBack);

		ActionListener a1 = ( ae ) -> {
			String fname = txtFName.getText();
			String lname = txtLName.getText();
			String email = txtEmail.getText();
			String mno = txtMno.getText();
			String uname = txtUsername.getText();
			String pass = txtPassword.getText();
			String cpass = txtConfirmPassword.getText();
			DbHandler db = new DbHandler();

			if ( !db.validateFirstName(fname)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid First Name.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtFName.setText("");
				txtFName.requestFocus();
			}

			if ( !db.validateLastName(lname)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid Last Name.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtLName.setText("");
				txtLName.requestFocus();
			}

			if ( !db.validateEmail(email)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid Email Address.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtEmail.setText("");
				txtEmail.requestFocus();
			}
			
			if ( !db.validateMno(mno)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid Mobile Number.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtMno.setText("");
				txtMno.requestFocus();
			}
	
			if ( !db.validateUsername(uname)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid Username.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtUsername.setText("");
				txtUsername.requestFocus();
			}

			if ( !pass.equals(cpass)) {
				JOptionPane.showMessageDialog(c,"Both the passwords dont match.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtPassword.setText("");
				txtConfirmPassword.setText("");
				txtPassword.requestFocus();
			}

			
			if ( db.validateFirstName(fname) && db.validateLastName(lname) && db.validateEmail(email) && db.validateMno(mno) && db.validateUsername(uname) && pass.equals(cpass) )  {
				if ( !db.checkUsernameExists(uname) ) {
					if ( !db.checkEmailExists(email) ) {
						if ( !db.checkMnoExists(mno) ) {
							db.newUser(fname, lname, email, mno, uname, pass, cpass);
							JOptionPane.showMessageDialog(c, "Sign-up completed.", "Sucess",JOptionPane.INFORMATION_MESSAGE);
							dispose();
							LoginPage lp = new LoginPage();
						} else {
							JOptionPane.showMessageDialog(c,"Mobile Number is already registered.","Oops...",JOptionPane.ERROR_MESSAGE);
							txtMno.setText("");
							txtMno.requestFocus();
						}
					} else {
						JOptionPane.showMessageDialog(c,"Email address is already registered.","Oops...",JOptionPane.ERROR_MESSAGE);
						txtEmail.setText("");
						txtEmail.requestFocus();
					}
				} else {
					JOptionPane.showMessageDialog(c,"Username already exists.","Oops...",JOptionPane.ERROR_MESSAGE);
					txtUsername.setText("");
					txtUsername.requestFocus();
				}
			}
			
				
			
		};
		btnSubmit.addActionListener(a1);

		ActionListener a2 = ( ae ) -> {
			LoginPage lp = new LoginPage();
			dispose();
		}; 
		btnBack.addActionListener(a2);
		
		setTitle("Sign-Up");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}

