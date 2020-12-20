import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class AddPage extends JFrame {

	Container c;
	JLabel lblRno, lblName, lblSub1, lblSub2, lblSub3, lblBlank;
	JTextField txtRno, txtName, txtSub1, txtSub2, txtSub3; 
	JButton btnSave, btnBack;
	
	AddPage(){
		c = getContentPane();
		c.setLayout(new FlowLayout());
	
		lblRno = new JLabel("	Enter Roll No. :     ");
		lblName = new JLabel("	Enter Name :           ");
		lblSub1 = new JLabel("   Enter Subject-1 Marks:     ");
		lblSub2 = new JLabel("   Enter Subject-2 Marks:     ");
		lblSub3 = new JLabel("   Enter Subject-3 Marks:     ");
		lblBlank = new JLabel("    ");

		txtRno = new JTextField(20);
		txtName = new JTextField(20);
		txtSub1 = new JTextField(20);
		txtSub2 = new JTextField(20);
		txtSub3 = new JTextField(20);

		btnSave = new JButton("	Save	");
		btnBack = new JButton("	Back	");

		c.add(lblRno);	c.add(txtRno);	c.add(lblName);	c.add(txtName);	c.add(lblSub1);
		c.add(txtSub1);	c.add(lblSub2);	c.add(txtSub2);	c.add(lblSub3);
		c.add(txtSub3);	c.add(btnSave);	 c.add(btnBack);

		ActionListener a1 = ( ae ) -> {
			String srno = txtRno.getText();
			String sname = txtName.getText();
			String ssub1 = txtSub1.getText();
			String ssub2 = txtSub2.getText();
			String ssub3 = txtSub3.getText();
			DbHandler db = new DbHandler();
			
			if ( !db.validateRno(srno)){
				JOptionPane.showMessageDialog(new JDialog(),"Please Enter a Valid Roll No.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtRno.setText("");
				txtRno.requestFocus();
			}

			if ( !db.validateName(sname)){
				JOptionPane.showMessageDialog(c,"Please Enter a Valid Name.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtName.setText("");
				txtName.requestFocus();
			}

			if (  !db.validateRno(ssub1) ){
				JOptionPane.showMessageDialog(c,"Please Enter Valid Marks.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtSub1.setText("");
				txtSub1.requestFocus();
			}

			if ( !db.validateMarks(ssub1)){
				JOptionPane.showMessageDialog(c,"Please Enter Marks Between the Range of 1 - 100","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtSub1.setText("");
				txtSub1.requestFocus();
			}

			if (  !db.validateRno(ssub2) ){
				JOptionPane.showMessageDialog(c,"Please Enter Valid Marks.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtSub2.setText("");
				txtSub2.requestFocus();
			}

			if ( !db.validateMarks(ssub2)){
				JOptionPane.showMessageDialog(c,"Please Enter Marks Between the Range of 1 - 100","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtSub2.setText("");
				txtSub2.requestFocus();
			}

			if (  !db.validateRno(ssub3) ){
				JOptionPane.showMessageDialog(c,"Please Enter Valid Marks.","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtSub3.setText("");
				txtSub3.requestFocus();
			}

			if ( !db.validateMarks(ssub3) ){
				JOptionPane.showMessageDialog(c,"Please Enter Marks Between the Range of 1 - 100","Invalid Data",JOptionPane.ERROR_MESSAGE);
				txtSub3.setText("");
				txtSub3.requestFocus();
			}

			if ( db.validateRno(srno) && db.validateName(sname) && ( db.validateRno(ssub1)  && db.validateMarks(ssub1) )  && ( db.validateRno(ssub2)  && db.validateMarks(ssub2) ) && ( db.validateRno(ssub3)  && db.validateMarks(ssub3) ) ) {
				db.addData(srno, sname, ssub1, ssub2, ssub3);
				txtRno.setText("");
				txtName.setText("");
				txtSub1.setText("");
				txtSub2.setText("");
				txtSub3.setText("");
				txtRno.requestFocus();
			}
		};
		btnSave.addActionListener(a1);

		ActionListener a2 = ( ae ) -> {
			StudentManSys lp = new StudentManSys();
			dispose();
		}; 
		btnBack.addActionListener(a2);
		
		

		setTitle("Add Student Details");
		setSize(300, 320);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}