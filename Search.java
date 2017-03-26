import java.awt.*;
import javax.swing.*;
import java.io.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
public class Search  extends JFrame implements ActionListener
{
		JLabel li1=new JLabel("Welcome To Hotel Reservation system");
		JLabel li2=new JLabel("Full Name *");
		JLabel li8=new JLabel("Email ID *");
		JLabel li3=new JLabel("Check In Date *");
		JLabel li4=new JLabel("Check Out Date *");
		JLabel li5=new JLabel("No. of Guest *");
		JLabel li6=new JLabel("No. of Rooms *");
		JLabel li7=new JLabel("* Fields are Required");
		JTextField ti1=new JTextField("ABC",40);
		JTextField ti2=new JTextField("xyz@gmail.com",40);
		JTextField ti3=new JTextField("dd/mm/yyyy",40);
		JTextField ti4=new JTextField("dd/mm/yyyy",40);
		JTextField ti5=new JTextField("1",40);
		JTextField ti6=new JTextField("1",40);
		JButton bi1=new JButton("Submit");
		JButton b2=new JButton("Reset");
		ImageIcon i1=new ImageIcon("c.jpg");
		JLabel b3=new JLabel(i1);
		ImageIcon i2=new ImageIcon("1.jpg");
		JButton b4=new JButton(i2);
	Search()
	{
		
		Font fi1=new Font("Constantia",Font.BOLD,20);
		Font f1i=new Font("Constantia",Font.BOLD,16);

		b3.setBounds(00,00,1200,850);
		b4.setBounds(10,110,640,426);

		

		li1.setFont(fi1);
		li7.setFont(f1i);
		li2.setFont(f1i);
		li3.setFont(f1i);
		li4.setFont(f1i);
		li5.setFont(f1i);
		li6.setFont(f1i);
		li8.setFont(f1i);
		add(li1);
		add(li2);
		add(li3);
		add(li4);
		add(li5);
		add(li6);
		add(ti1);
		add(ti2);
		add(ti3);
		add(ti4);
		add(ti5);
		add(ti6);
		
		add(li7);
		add(li8);
		add(bi1);
		add(b2);
		add(b3);
		add(b4);

		bi1.setBackground(Color.BLUE);
		bi1.setForeground(Color.WHITE);
		b2.setBackground(Color.BLUE);
		b2.setForeground(Color.WHITE);
		
		ti1.setForeground(Color.BLUE);
		ti2.setForeground(Color.BLUE);
		ti3.setForeground(Color.BLUE);
		ti4.setForeground(Color.BLUE);
		ti5.setForeground(Color.BLUE);
		ti6.setForeground(Color.BLUE);

		li1.setForeground(Color.BLUE);
		li2.setForeground(Color.RED);
		li3.setForeground(Color.RED);
		li4.setForeground(Color.RED);
		li5.setForeground(Color.RED);
		li6.setForeground(Color.RED);
		li7.setForeground(Color.RED);
		li8.setForeground(Color.RED);

		li1.setBounds(450,00,400,100);
		li2.setBounds(700,150,150,30);
		li8.setBounds(700,200,150,30);
		li3.setBounds(700,250,150,30);
		li4.setBounds(700,300,150,30);
		li5.setBounds(700,350,150,30);
		li6.setBounds(700,400,250,30);
		li7.setBounds(700,550,200,30);


		ti1.setBounds(900,150,250,30);
		ti2.setBounds(900,200,250,30);
		ti3.setBounds(900,250,250,30);
		ti4.setBounds(900,300,250,30);
		ti5.setBounds(900,350,250,30);
		ti6.setBounds(900,400,250,30);
		
		bi1.setBounds(930,450,90,30);
		b2.setBounds(1050,450,90,30);

		bi1.addActionListener(this);
		b2.addActionListener(this);
		FlowLayout f=new FlowLayout();
		setLayout(null);
		setVisible(true);
		setSize(1200,700);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bi1)
			{	
				try
	        {
	        Class.forName("com.mysql.jdbc.Driver");
	        System.out.print("Drivers Loaded Successfully\n");
	        Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root","praveen@01");
	        PreparedStatement s=c.prepareStatement("insert into hotelinfo values(?,?,?,?,?,?)");
	        s.setString(1,ti1.getText());
	        s.setString(2,ti2.getText());
	        s.setString(3,ti3.getText());
	        s.setString(4,ti4.getText());
	        s.setInt(5,Integer.parseInt(ti5.getText()));
	        s.setInt(6,Integer.parseInt(ti6.getText()));
	        s.execute();
 			JLabel l6=new JLabel("Done!!!");
	        System.out.print("Connection Created\n");
	        l6.setForeground(Color.RED);
			l6.setBounds(700,650,200,30);
	        add(l6);
	        Hotel hh=new Hotel();
	        }
    		catch(Exception e)
    		{
    	    System.out.println(e);
 				JLabel l4=new JLabel("Error:- "+e);
 				add(l4);
 				
				l4.setForeground(Color.RED);
				
				l4.setBounds(00,570,1000,20);
   			 }
    		}
    		if(ae.getSource()==b2)
    		{
    		ti1.setText("ABC");
	    	ti2.setText("xyz@gmail.com"); 
	    	ti3.setText("dd/mm/yyyy"); 
	    	ti4.setText("dd/mm/yyyy"); 
	    	ti5.setText("1");
	    	ti6.setText("1");
    		}
}
	public static void main(String[] args) 
	{
		Search h=new Search();
	}
}