import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
class AdminManageCourse extends JPanel 
{
	JLabel Lb1,Lb2;
	JButton b1,b2,b3,b4; 
	 ImageIcon img1;

	int count_course;
	
	JComboBox Cb1;
	AdminManageCourse(Fdemo f)
    {
		
		setLayout(null);
		Font f1=new Font("",Font.BOLD,30);

		
		Lb1=new JLabel("MANAGE COURSE");
		 Lb1.setFont(f1);
		 Lb1.setBounds(450,50,300,50);
    	add(Lb1);
		
		img1=new ImageIcon("course.png");
		Lb2=new JLabel(img1);
	   Lb2.setBounds(450,100,250,250);
    	add(Lb2);
		
		
		 f1=new Font("",Font.BOLD,20);

    

		
         b4=new JButton("DELETE");
		b4.setFont(f1);
		b4.setBounds(800,440,180,40);
		add(b4);
		b4.addActionListener(f);
		 
		 Cb1=new JComboBox();
		 Cb1.setFont(f1);
	   Cb1.setBounds(450,350,250,50);
		 try
		 {
			 int x=0;
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  
		  Statement st=con.createStatement();
		  String q="select * from coursename" ;
		   
		   ResultSet rs=st.executeQuery(q);
		   
		   
		 while(rs.next())
		 {
			 Cb1.addItem(rs.getString(2));
		 x=Integer.parseInt(rs.getString(1));
		 }
		 count_course=x;
        
		   
			con.close();
		 }
		 catch(Exception e1)
		 {
			System.out.println(e1); 
		 }
	
		add(Cb1);
		Cb1.addItemListener(f);
         b1=new JButton("ADD COURSE");
		b1.setFont(f1);
		b1.setBounds(800,350,180,40);
		add(b1);
		b1.addActionListener(f);
		 
		
         b3=new JButton("EDIT COURSE");
		b3.setFont(f1);
		b3.setBounds(500,440,180,40);
		add(b3);
		b3.addActionListener(f);
		 
		
	 	
		f1=new Font("",Font.BOLD,20);
		b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
	
   
		ImageIcon img22=new ImageIcon("bk1.png");
		JLabel Lb12=new JLabel(img22);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);

	}
	
}