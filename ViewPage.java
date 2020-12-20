import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ViewPage extends JFrame {
	Container c;
	JButton  btnBack;
	TextArea taData;
	

	ViewPage(){
		c = getContentPane();
		c.setLayout( new FlowLayout());
	
		taData = new TextArea(10, 30);
		btnBack = new JButton("Back");
		
		c.add(taData);
		c.add(btnBack);

		String data = new DbHandler().viewStudent();   // data from db via DbHandler
		taData.setText(data);

		ActionListener a1 = ( ae )  -> {
			StudentManSys mf = new StudentManSys();
			dispose();
		};
		btnBack.addActionListener(a1);

		setTitle("View Student Details");	
		setSize(300, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}