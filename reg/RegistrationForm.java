package reg;
import javax.swing.*;

import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class RegistrationForm implements ActionListener {
	
	JFrame frame;
    String[] gender={"M","F"};
    String[] role= {"HRA","EMP","PME"};
    JLabel EmailId=new JLabel("Email Id");
    JLabel FirstName=new JLabel("First Name");
    JLabel LastName=new JLabel("Last Name");
    JLabel Gender=new JLabel("Gender");
    JLabel UserId=new JLabel("User Id");
    JLabel Password=new JLabel("Password");   
    JLabel Role=new JLabel("Role");
    JLabel Mobileno=new JLabel("Mobile No");
    JTextField Emailid=new JTextField();
    JTextField firstname=new JTextField();
    JComboBox genderCombo=new JComboBox(gender);
    JTextField lastname=new JTextField();
    JTextField mobileno=new JTextField();
    JTextField userid=new JTextField();
    JPasswordField passwords=new JPasswordField();
    JComboBox roleCombo=new JComboBox(role);
    JButton registerButton=new JButton("REGISTER");
    JButton resetButton=new JButton("RESET");
    
 
    public RegistrationForm()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
        frame.getContentPane().setBackground(Color.white);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
    	EmailId.setBounds(20,20,60,70);
        FirstName.setBounds(20,70,100,70);
        LastName.setBounds(20,120,100,70);
        UserId.setBounds(20,170,100,70);
        Password.setBounds(20,220,140,70);
        Role.setBounds(20,270,100,70);
        Gender.setBounds(20,320,100,70);
        Mobileno.setBounds(20,370,100,70);
        Emailid.setBounds(180,43,165,23);
        firstname.setBounds(180,93,165,23);
        lastname.setBounds(180,143,165,23);
        userid.setBounds(180,193,165,23);
        passwords.setBounds(180,243,165,23);
        roleCombo.setBounds(180,293,165,23);
        genderCombo.setBounds(180,343,165,23);
        mobileno.setBounds(180,393,165,23);
        registerButton.setBounds(70,450,100,35);
        resetButton.setBounds(220,450,100,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(EmailId);
        frame.add(FirstName);
        frame.add(LastName);
        frame.add(UserId);
        frame.add(Password);
        frame.add(Role);
        frame.add(Gender);
        frame.add(Mobileno);
        frame.add(Emailid);
        frame.add(firstname);
        frame.add(lastname);
        frame.add(userid);
        frame.add(passwords);
        frame.add(roleCombo);
        frame.add(genderCombo);
        frame.add(mobileno);
        frame.add(registerButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
 
 
   
	/**
	 *
	 */
	@Override
    public void actionPerformed(ActionEvent e) {  	
 		

    
        if(e.getSource()==registerButton)
        {
        	try {
    		Connection conn=DriverManager.getConnection("jdbc:sqlserver://DESKTOP-R1KFKCE\\DHILIP:1433;databaseName=pcsdb","sa","dhilipan");
        		
        		//Preapared Statement
    	    PreparedStatement Pstatement=conn.prepareStatement("insert into Employees values(?,?,?,?,?,?,?,?,?)");
    	  
                //Specifying the values of it's parameter
                Pstatement.setString(1,Emailid.getText());
                Pstatement.setString(2,firstname.getText());
                Pstatement.setString(3,lastname.getText());
                Pstatement.setString(4,userid.getText());
                Pstatement.setString(5,passwords.getText());
                Pstatement.setString(6,roleCombo.getSelectedItem().toString());
                Pstatement.setString(7,genderCombo.getSelectedItem().toString());
                Pstatement.setString(8,"FALSE");
                Pstatement.setString(9,mobileno.getText());
                Pstatement.executeUpdate();
                Statement stmt = conn.createStatement();
                String sql = "UPDATE Employees SET Active='TRUE' WHERE Role='HRA'";
                stmt.executeUpdate(sql);
                
                JOptionPane.showMessageDialog(null,"Data Registered Successfully");
                   
 
        }
        
             catch (SQLException e1) {
                e1.printStackTrace();
            }
    
         
	}
        if(e.getSource()==resetButton)
        {
            //Clearing Fields
            Emailid.setText("");
            firstname.setText("");
            lastname.setText("");
            userid.setText("");
            passwords.setText("");
            roleCombo.setSelectedItem("");
            genderCombo.setSelectedItem("");
            mobileno.setText("");
        }
 
    }
}

