package Login;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*; 
public class Deactivate extends JFrame implements ActionListener { 
    // JTextField 
    static JTextField t; 
  
    // JFrame 
    static JFrame f; 
  
    // JButton 
    static JButton bb; 
  
    // label to display text 
    static JLabel l; 
  
    // default constructor 
    public void Deactivate() 
    { 
    
  
    // main class 
   
        // create a new frame to store text field and button 
        f = new JFrame("textfield"); 
  
        // create a label to display text 
        l = new JLabel("Enter Employee id"); 
  
        // create a new button 
        bb=new JButton("Deactivate");
  
        // create a object of the text class 
        Deactivate dact = new Deactivate(); 
 
        
        // addActionListener to button 
        bb.addActionListener(dact); 
        
        // create a object of JTextField with 16 columns 
        t= new JTextField(4); 
  
        // create a panel to add buttons and textfield 
        JPanel p = new JPanel(); 
  
        // add buttons and textfield to panel 
        p.add(t); 
        p.add(bb);
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
        if (s.equals("Deactivate")){ 
    	  String url="jdbc:sqlserver://DESKTOP-R1KFKCE\\DHILIP:1433;databaseName=pcsdb;user=sa;password=dhilipan";
          try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
   		    Connection conn;
			conn = DriverManager.getConnection(url);			 
   		    String userid=t.getText();   
		    PreparedStatement ps1;
			ps1 = conn.prepareStatement("update Employees set active='FALSE' where userid='"+userid+"'");
		   // ps.setString(1, userid);
		    ps1.executeUpdate();
		    ps1.close();
          } 
          catch (SQLException e1) {
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
          l.setText("Deactivated"); 
          t.setText("  "); 
      } 
	
} 
} 