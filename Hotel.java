import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
public class Hotel  extends JFrame implements ActionListener
{
		JLabel l1=new JLabel("Welcome To Hotel Reservation system");
		JLabel l2=new JLabel("E-Mail *");
		JLabel l3=new JLabel("Password *");
		JLabel l5=new JLabel("* fields are mandatory!!!");
		JTextField t1=new JTextField("xyz@gmail.com",40);
		JPasswordField t2=new JPasswordField("123456",40);
		JButton b1=new JButton("Sign IN");
		JButton b2=new JButton("Sign UP");
		Font fi=new Font("Monotype Corosiva",Font.BOLD,20);
		Font f1=new Font("Constantia",Font.BOLD,16);
		ImageIcon i1=new ImageIcon("desk.jpg");
		JButton b3=new JButton(i1);
		ImageIcon i2=new ImageIcon("c.jpg");
		JLabel bs=new JLabel(i2);
	Hotel()
	{
		
		b3.setBounds(10,110,640,442);
		bs.setBounds(00,00,1200,850);
		add(b1);
b1.addActionListener((ActionListener)this);
		//b1.addActionListener(this);
		b2.addActionListener(this);
		add(b3);
		l1.setFont(fi);
		l2.setFont(f1);
		l3.setFont(f1);
		add(l1);
		l1.setBounds(300,00,400,100);
		add(l2);
		add(l3);
		add(t1);
		add(t2);
		add(b1);
		add(b2);
		add(l5);

		add(bs);
		b1.setBackground(Color.BLUE);
		b1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		t1.setBackground(Color.BLUE);
		t1.setForeground(Color.WHITE);
		t2.setBackground(Color.BLUE);
		l1.setForeground(Color.BLUE);
		t2.setForeground(Color.WHITE);
		l2.setForeground(Color.RED);
		l3.setForeground(Color.RED);
		l5.setForeground(Color.RED);
		l2.setBounds(700,140,150,40);
		t1.setBounds(800,140,140,40);
		l3.setBounds(700,220,150,40);
		t2.setBounds(800,220,140,40);
		b1.setBounds(730,320,90,40);
		b2.setBounds(880,320,90,40);
		l5.setBounds(700,380,500,20);
		GridLayout f=new GridLayout();
		setLayout(null);
		setVisible(true);
		setSize(1024,650);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try
	        {
	        	Statement st;
				PreparedStatement ps;
				ResultSet rs;
	        	Class.forName("com.mysql.jdbc.Driver");
	        	System.out.print("Drivers Loaded Successfully\n");
	        	Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","praveen@01");
	        	st=c.createStatement();
				rs=st.executeQuery("SELECT * FROM hotel WHERE email ='"+t1.getText()+"' and password='"+t2.getText()+"'");
	        	int foundrs = 0;
	        	String s,a;
	        	while (rs.next())
                { 
                	s= rs.getString(1);
                	a= rs.getString(2);
                	System.out.println(""+a+"\n"+s);
                	foundrs=1;
                }
	        	if (foundrs==0)
                {
                	System.out.println("Error");
                	JLabel l16=new JLabel("INVALID ID OR PASSWORD!!!");
                	l16.setForeground(Color.RED);
                	add(l16);
                	l16.setBounds(750,280,500,20);
              		
                }
                else
                {
                	foundrs=0;
                	Search s1=new Search();
                	
                }
	        	}
	        catch(Exception e)
    		{
    	    System.out.println(e);
 				
 				JLabel l4=new JLabel("Error:- "+e);
				l4.setForeground(Color.RED);
				add(l4);
				l4.setBounds(00,570,1000,20);
				
 				
			}
		}
			if(ae.getSource()==b2)
			{
				Sinup ss=new Sinup();
			}
		}	
    	
	public static void main(String[] args)
	{
		Hotel h=new Hotel();
	}
}