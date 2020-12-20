import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class LoginPage extends JFrame {

	Container c;
	JLabel lblUsername, lblPassword, lblBlank;
	JTextField txtUsername;
	JPasswordField txtPassword;
	JButton btnLogin, btnSignup, btnForgotPassword;

	
	LoginPage() {
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		lblUsername = new JLabel("Enter Username :");
		lblPassword = new JLabel("Enter Password :");
		lblBlank = new JLabel("        ");
		btnForgotPassword = new JButton("Forgot Password ?");	
		btnLogin = new JButton("Login");
		btnSignup = new JButton("Sign up");
		txtUsername = new JTextField(15);
		txtPassword = new JPasswordField(15);


		c.add(lblUsername);
		c.add(txtUsername);
		c.add(lblPassword);
		c.add(txtPassword);
	
		c.add(btnLogin);
		c.add(lblBlank);
		c.add(btnSignup);
	
		c.add(btnForgotPassword);

		ActionListener a1 = ( ae )  -> {
			SignupPage sp = new SignupPage();
			dispose();
		};
		btnSignup.addActionListener( a1 ); 

		ActionListener a2 = ( ae )  -> {
			ForgotPassword fp = new ForgotPassword();
			dispose();
		};
		btnForgotPassword.addActionListener( a2 ); 

		ActionListener a3 = ( ae )  -> {
			String username = txtUsername.getText();
			String password = txtPassword.getText();

			DbHandler db = new DbHandler();


			if ( db.checkUsernameExists(username) ) {
				if ( db.checkPassword(username, password) ) {
					StudentManSys sms = new StudentManSys();
					dispose();
				} else {
					JOptionPane.showMessageDialog(c,"Invalid Password","Error",JOptionPane.ERROR_MESSAGE);
					txtPassword.setText("");
					txtPassword.requestFocus();
				}
			} else {
				JOptionPane.showMessageDialog(c,"Username does not exists.","Oops !",JOptionPane.ERROR_MESSAGE);
				txtUsername.setText("");
				txtUsername.requestFocus();
			}
		};
		btnLogin.addActionListener( a3 ); 

		
		setTitle("User Login");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		
	}
	

	
}

