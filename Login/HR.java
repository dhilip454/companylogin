package Login;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class HR implements ActionListener {
	private static final int EXIT_ON_CLOSE = 0;
	JFrame frame = new JFrame("HR Window");
	JButton Activate,Deactivate, Changepass,Viewdata,Logout;
	
	public void HR(String usr, String pwd){
	createwindow();
	addtoframe();
	actionEvent(usr,pwd);
}
	public void createwindow() {
		Viewdata= new JButton("View Data");
		Activate= new JButton("Activate Employee");
		Deactivate= new JButton("Deactivate Employee");
		Changepass= new JButton("Change Password");
		Logout= new JButton("Log Out");
			    
	}
	public void addtoframe() {


	    
		frame.add(Viewdata);
		frame.add(Activate);
		frame.add(Deactivate);
		frame.add(Changepass);
		frame.add(Logout);

		frame.setLayout(new FlowLayout());
		frame.setSize(300,300);  
		frame.setVisible(true);  
		
	}
	public void actionEvent(String usr, String pwd)
    {
		Activate.addActionListener(this);
        Deactivate.addActionListener(this);
        Changepass.addActionListener(this);
       Logout.addActionListener(this);
      
       
	
	Viewdata.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
				try {
					HRData frame = new HRData();
					frame.HRData(usr,pwd);
			        frame.pack();
			        frame.setVisible(true);

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			
			}
	});
	Activate.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			 Activate act = new Activate(); 
			 act.Activate();
			  act.pack();
		}
		 	});

	Deactivate.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
			 Deactivate dact = new Deactivate(); 
			 dact.Deactivate();
			  dact.pack();
		}
		 	});
	Changepass.addActionListener(new ActionListener()
	{
		public void actionPerformed(ActionEvent e)
		{
		}
		 	});
    }
	public void actionPerformed(ActionEvent e) {  	
		
		
		if(e.getSource()==Logout)
        {
        	new log();
        	frame.dispose();
        	
        }
	}
		 	//}



}