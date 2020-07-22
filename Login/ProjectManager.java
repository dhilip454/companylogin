package Login;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
public class ProjectManager implements ActionListener {
		private static final String String = null;
		JFrame frame = new JFrame("Project Manager Window");
		JButton Viewdata,Addjob, Changepass,Logout;
		public void ProjectManager(String usr, String pwd){
		createwindow();
		addtoframe();
		actionEvent(usr,pwd);
	}
		public void createwindow() {
			Viewdata= new JButton("View Employee Data");
			Addjob= new JButton("Add Job");
			Changepass= new JButton("Change Password");
			Logout= new JButton("Log Out");
				    
		}
		public void addtoframe() {
			frame.add(Viewdata);
			frame.add(Addjob);
			frame.add(Changepass);
			frame.add(Logout);
			frame.setLayout(new FlowLayout());
			frame.setSize(300,300);  
			frame.setVisible(true);  

		}
		public void actionEvent(String usr,String pwd)
	    {
			Viewdata.addActionListener(this);
	        Addjob.addActionListener(this);
	        Changepass.addActionListener(this);
	        Logout.addActionListener(this);
	        Viewdata.addActionListener(new ActionListener()
	    	{
	    		public void actionPerformed(ActionEvent e)
	    		{
	    				try {
	    					
	    					PMData frame = new PMData();
	    					frame.PMData(usr,pwd);
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
	 		

		    
			if(e.getSource()==Viewdata)
	        {
	        	
	        }
	        if(e.getSource()==Addjob)
	        {
	        	
	        }
	        if(e.getSource()==Changepass)
	        {
	        	
	        }
	        if(e.getSource()==Logout)
	        {
	        	new log();
	        	frame.dispose();
	        }
		}
	}


