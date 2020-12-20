import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class DeletePage extends JFrame {
	Container c;
	JLabel lblRno;
	JTextField txtRno; 
	JButton btnSave, btnBack;
	
	DeletePage(){
		c = getContentPane();
		c.setLayout(new FlowLayout());
	
		lblRno = new JLabel("	Enter Roll No. :     ");
		
		txtRno = new JTextField(20);

		btnSave = new JButton("	Delete	");
		btnBack = new JButton("	Back	");

		c.add(lblRno);	c.add(txtRno);	c.add(btnSave);	 c.add(btnBack);

		ActionListener a1 = ( ae ) -> {
			String srno = txtRno.getText();
			DbHandler db = new DbHandler();
			
			if ( !db.validateRno(srno)){
				JOptionPane.showMessageDialog(new JDialog(),"Please Enter a Valid Roll No.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtRno.setText("");
				txtRno.requestFocus();
			} else {
				db.deleteData(srno);
				txtRno.setText("");								
				txtRno.requestFocus();
			}

			

		};
		btnSave.addActionListener(a1);

		ActionListener a2 = ( ae ) -> {
			StudentManSys lp = new StudentManSys();
			dispose();
		}; 
		btnBack.addActionListener(a2);
		
		setTitle("Delete Student Details");
		setSize(300, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}

