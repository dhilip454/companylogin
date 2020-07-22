package Login;
import reg.RegistrationForm;
import config.JDBCConnection;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class login {

	public static void main(String[] args) {
	   log obj=new log();
	}

}
class log extends JFrame implements ActionListener
{
	private static final String String = null;
	JLabel lTitle, lUser,lPassword,lMessage,lrole;
	JTextField userid,passwords;
	JPasswordField tPassword;
	JButton bLogin,bregister;
	JComboBox roleCombo;
		
	static JDialog dialog;
	public log()
	{
		String[] role= {"HRA","EMP","PME"};
		
		lTitle=new JLabel("Login Here");
		lTitle.setBounds(180, 20, 150, 25);
		lUser=new JLabel("User Id");
		lUser.setBounds(50, 80, 150, 25);
		lPassword=new JLabel("Password");
		lPassword.setBounds(50, 160, 150, 25);
		userid=new JTextField();
		userid.setBounds(200, 80, 150, 25);
		passwords=new JPasswordField();
		passwords.setBounds(200, 160, 150, 25);
		((JPasswordField) passwords).setEchoChar('*');
		lrole=new JLabel("Role");
		lrole.setBounds(50, 200, 150, 25);
		roleCombo=new JComboBox(role);
		roleCombo.setBounds(200,200,90,20);
	    		
		bLogin=new JButton("Login");
		bLogin.setBounds(100, 250,150, 25);
		bLogin.addActionListener(this);
		bregister=new JButton("Register");
		bregister.setBounds(250, 250,150, 25);
		lMessage=new JLabel();
		lMessage.setBounds(120, 320, 320, 25);
		dialog=new JDialog(this,"Login",true);
		
		add(lTitle);
		add(lUser);
		add(lPassword);
		add(lrole);
		add(roleCombo);
		add(userid);
		add(passwords);
		add(bLogin);
		add(bregister);
		add(lMessage);
		dialog.add(lMessage);
		dialog.setSize(350, 200);
		setSize(500,500);
		setLayout(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	

		
		bregister.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				new RegistrationForm();
				
			}
		});
		
		
	}
	@Override
  
	public void actionPerformed(ActionEvent e)
		{
	
		if(e.getSource()==bLogin) {                                 
	        
	        try {
	        	//PreparedStatement ps;
		        ResultSet rs;
		        	        String query = "SELECT * FROM Employees WHERE Userid =? AND Pass =? AND Role=? And Active='TRUE'";
		        	      
	        	Connection conn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-R1KFKCE\\DHILIP:1433;databaseName=pcsdb","sa","dhilipan");
	        	

	        	PreparedStatement ps1=conn.prepareStatement(query);
	            
	            ps1.setString(1, userid.getText());
	            ps1.setString(2, passwords.getText());
				ps1.setString(3, roleCombo.getSelectedItem().toString());
			
				rs = ps1.executeQuery();
				String usr=userid.getText();
	            String pwd=passwords.getText();
                
				//String usr=userid.getText();
	            //String pwd=passwords.getText();
	            if(rs.next())
	            {
		            if(roleCombo.getSelectedItem().equals("HRA"))
						
		            {

		                HR hra = new HR();
		                 hra.HR(usr,pwd); 
		                    this.dispose();
		           }
		            if(roleCombo.getSelectedItem().equals("PME"))
						
		            {	

	            	 	ProjectManager pme = new ProjectManager();
		                  pme.ProjectManager(usr,pwd);
		                    this.dispose();
		           }
		            if(roleCombo.getSelectedItem().equals("EMP"))
						
		            {
		            	 	Employee emp = new Employee();
		                    emp.Employee(usr,pwd);
		                   
		    	            
		                    
		                  
		                    this.dispose();
		           }
	            }
	            
	            	else
	                    {
	                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password", "Login Failed", 2);
	                }
	          
	        }
	        catch (SQLException ex) {
	            Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
	        }
			}
		}
	}