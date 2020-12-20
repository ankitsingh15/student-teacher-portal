import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ForgotPassword extends JFrame {
	Container c;
	JLabel lblEmail, lblNewPassword, lblCNewPassword, lblUsername, lblBlank;
	JTextField txtEmail, txtUsername;
	JPasswordField txtNewPassword, txtCNewPassword;
	JButton btnUpdate, btnCancel; 
	
	ForgotPassword(){
		c = getContentPane();
		c.setLayout(new FlowLayout());

		lblUsername = new JLabel("Enter Username: ");
		lblEmail = new JLabel("Enter Email ID:     ");
		lblNewPassword = new JLabel("Enter New Password: ");
		lblCNewPassword = new JLabel("Confirm New Password: ");
		lblBlank = new JLabel("    ");

		txtUsername = new JTextField(15);
		txtEmail = new JTextField(15);
		txtNewPassword = new JPasswordField(20);
		txtCNewPassword = new JPasswordField(20);
	
		btnUpdate = new JButton("Update");
		btnCancel = new JButton("Cancel");

		c.add(lblUsername);	c.add(txtUsername);	c.add(lblEmail);	c.add(txtEmail);	c.add(lblNewPassword);	c.add(txtNewPassword);
		c.add(lblCNewPassword);	c.add(txtCNewPassword);	c.add(btnUpdate);	c.add(lblBlank);	c.add(btnCancel);
		
		ActionListener a1 = ( ae ) -> {
			LoginPage lp = new LoginPage();
			dispose();
		};
		btnCancel.addActionListener(a1);

		ActionListener a2 = ( ae ) -> {
			String uname = txtUsername.getText();
			String email = txtEmail.getText();
			String newpass = txtNewPassword.getText();
			String cnewpass = txtCNewPassword.getText();

			DbHandler db = new DbHandler();

			if ( !db.validateUsername(uname)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid Username.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtUsername.setText("");
				txtUsername.requestFocus();
			}
					
			if ( !db.validateEmail(email)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid Email Address.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtEmail.setText("");
				txtEmail.requestFocus();
			}

			if ( !newpass.equals(cnewpass)) {
				JOptionPane.showMessageDialog(c,"Both the passwords dont match.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtNewPassword.setText("");
				txtCNewPassword.setText("");
				txtNewPassword.requestFocus();
			}
		
			if ( db.validateEmail(email) && db.validateUsername(uname) && newpass.equals(cnewpass) )  {
				if( db.checkUsernameExists(uname) ) {
					if ( db.checkEmail(uname, email) ) {
						db.updatePassword(uname, newpass);
						dispose();
						LoginPage lp = new LoginPage();
							
					} else {
						JOptionPane.showMessageDialog(new JDialog(),"Inavlid Email address. Please enter valid email address for the given user.","Invalid Data",JOptionPane.ERROR_MESSAGE);
						txtEmail.setText("");
						txtEmail.requestFocus();
					}
				} 
				else {
					JOptionPane.showMessageDialog(new JDialog(),"Username does not exists.","Invalid Data",JOptionPane.ERROR_MESSAGE);
					txtUsername.setText("");
					txtUsername.requestFocus();
				}
		
			}
			
			
		};
		btnUpdate.addActionListener(a2);
		

		setTitle("New Password");
		setSize(300, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		

	}


}