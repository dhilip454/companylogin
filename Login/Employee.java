package Login;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import reg.RegistrationForm;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Employee implements ActionListener{
	JFrame frame = new JFrame("Employee Window");
	JButton Viewdata,Viewjob, Changepass,Logout;
	public void Employee(String usr, String pwd){
	createwindow();
	addtoframe();
	actionEvent(usr,pwd);
	    

}
	public void createwindow() {
		Viewdata= new JButton("View Data");
		Viewjob= new JButton("View Job");
		Changepass= new JButton("Change Password");
		Logout= new JButton("Log Out");
			    
	}
	public void addtoframe() {
		frame.add(Viewdata);
		frame.add(Viewjob);
		frame.add(Changepass);
		frame.add(Logout);
		Viewdata.addActionListener(this);
	    Viewjob.addActionListener(this);
	    Changepass.addActionListener(this);
	    Logout.addActionListener(this);

		frame.setLayout(new FlowLayout());
		frame.setSize(300,300);  
		frame.setVisible(true);  

	}
	public void actionEvent(String usr, String pwd)
    {
		Viewdata.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    				try {
    					
    					Empdata frame = new Empdata();
    					frame.Empdata(usr,pwd);
    					frame.pack();
    			        frame.setVisible(true);

    				} catch (ClassNotFoundException e1) {
    					// TODO Auto-generated catch block
    					e1.printStackTrace();
    				}
    				
    			
    			
    			}
    	});
		
}


	public void actionPerformed(ActionEvent e) {  	
 		

    
     //   if(e.getSource()==Viewjob)
       // {
        	
        //}
        //if(e.getSource()==Changepass)
       // {
        	
       // }
        if(e.getSource()==Logout)
        {
        	new log();
        	frame.dispose();
        }
	}
	}
	

	

