import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


class StudentManSys extends JFrame {

	Container c;
	JButton btnAdd, btnView, btnUpdate, btnDelete, btnCharts, btnLogout;
	

	
	StudentManSys() {
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		btnAdd = new JButton("         ADD        ");
		btnView = new JButton("        VIEW       ");
		btnUpdate = new JButton("     UPDATE     ");
		btnDelete = new JButton("     DELETE     ");
		btnCharts = new JButton("     CHARTS     ");
		btnLogout = new JButton("     LOGOUT    ");


		c.add(btnAdd);
		c.add(btnView);

		c.add(btnUpdate);
		c.add(btnDelete);

		c.add(btnCharts);
		c.add(btnLogout);
		
		

		ActionListener a1 = ( ae ) -> {
			AddPage ap = new AddPage();
			dispose();				
		};
		btnAdd.addActionListener(a1);
	
		ActionListener a2 = ( ae ) -> {
			UpdatePage ap = new UpdatePage();
			dispose();				
		};
		btnUpdate.addActionListener(a2);

		ActionListener a3 = ( ae ) -> {
			DeletePage ap = new DeletePage();
			dispose();				
		};
		btnDelete.addActionListener(a3);

		ActionListener a4 = ( ae ) -> {
			ViewPage ap = new ViewPage();
			dispose();				
		};
		btnView.addActionListener(a4);
		
		ActionListener a5 = ( ae ) -> {
			ChartPage ap = new ChartPage();				
		};
		btnCharts.addActionListener(a5);
		
		ActionListener a6 = ( ae ) -> {
			LoginPage ap = new LoginPage();
			dispose();				
		};
		btnLogout.addActionListener(a6);
	
		
		
		
		setTitle("Student Management System");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	
		
	}
	

}





