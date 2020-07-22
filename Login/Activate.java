package Login;
// Java program to create a blank text  
// field of definite number of columns. 
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*; 
public class Activate extends JFrame implements ActionListener { 
    // JTextField 
    static JTextField t; 
  
    // JFrame 
    static JFrame f; 
  
    // JButton 
    static JButton b; 
  
    // label to display text 
    static JLabel l; 
  
    // default constructor 
    public void Activate() 
    { 
    
  
    // main class 
   
        // create a new frame to store text field and button 
        f = new JFrame("textfield"); 
  
        // create a label to display text 
        l = new JLabel("Enter Employee id"); 
  
        // create a new button 
        b = new JButton("Activate");
  
        // create a object of the text class 
        Activate act = new Activate(); 
 
        
        // addActionListener to button 
        b.addActionListener(act);  
        
        // create a object of JTextField with 16 columns 
        t= new JTextField(4); 
  
        // create a panel to add buttons and textfield 
        JPanel p = new JPanel(); 
  
        // add buttons and textfield to panel 
        p.add(t); 
        p.add(b);
        p.add(l); 
  
        // add panel to frame 
        f.add(p); 
  
        // set the size of frame 
        f.setSize(300, 300); 
  
        f.show(); 
        f.setVisible(true);
   
    }

	@Override
	
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); 
        if (s.equals("Activate")) {
        	  String url="jdbc:sqlserver://DESKTOP-R1KFKCE\\DHILIP:1433;databaseName=pcsdb;user=sa;password=dhilipan";
       		
              try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       		    Connection conn;
				conn = DriverManager.getConnection(url);			 
       		    String userid=t.getText();   
			    PreparedStatement ps;
				ps = conn.prepareStatement("update Employees set active='TRUE' where userid='"+userid+"'");
			   // ps.setString(1, userid);
			    ps.executeUpdate();
              ps.close();
              } 
              catch (SQLException e1) {
  				e1.printStackTrace();
  			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			}
              l.setText("Activated"); 
              t.setText("  "); 
          } 
	}
}