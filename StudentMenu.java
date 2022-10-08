import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
class StudentMenu extends JPanel
{
	JButton b2,b1,b3,b4,b5;
	JLabel Lb1,Lb2,Lb3,Lb12,Lb4,Lb5,Lb6,Lb7,Lb8;
	JComboBox Cb1;
	Font f1;
	static int student_id;
	
	String course_selected;
	ImageIcon img1,img2,img3,img4;
StudentMenu(Fdemo f)
{
	
	  setLayout(null);
		 f1=new Font("",Font.BOLD,30);
		 Lb1=new JLabel("Welcome");
		 Lb1.setFont(f1);
		 Lb1.setBounds(520,30,300,50);
		 add(Lb1);
		 
		 f1=new Font("",Font.BOLD,20);
		
		 
		 img1=new ImageIcon("edit2.png");
		 Lb2=new JLabel(img1);
		 Lb2.setBounds(100,130,177,177);
		 add(Lb2);
		 
  

		b1=new JButton("Edit Detail");
		b1.setFont(f1);
		b1.setBounds(300,200,150,40);
		add(b1);
		b1.addActionListener(f);
	
	 
		 img3=new ImageIcon("result3.png");
		 Lb3=new JLabel(img3);
		 Lb3.setBounds(500,130,177,177);
		 add(Lb3);
		 
        
		b3=new JButton("Result");
		b3.setFont(f1);
		b3.setBounds(700,200,100,40);
		add(b3);
		b3.addActionListener(f);
	
	 
	 
		 img4=new ImageIcon("logout.png");
		 Lb4=new JLabel(img4);
		 Lb4.setBounds(820,130,177,177);
		 add(Lb4);
		 

		b4=new JButton("Logout");
		b4.setFont(f1);
		b4.setBounds(1000,200,110,40);
		add(b4);
		b4.addActionListener(f);
	
       Lb5=new JLabel("SELECT COURSE ");
       Lb5.setFont(f1);
        Lb5.setBounds(300,400,200,50);
		add(Lb5);
		
		Cb1=new JComboBox();
		try
		{
	     Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  
		  Statement st=con.createStatement();
		  String q="select * from coursename " ;
		  ResultSet rs=st.executeQuery(q);
		  while(rs.next())
		  {
			  Cb1.addItem(rs.getString(2));
		  }
	     con.close();
		}
		catch(Exception e1)
		{
			
		}
		Cb1.setFont(f1);
		Cb1.setBounds(500,400,250,50);
		add(Cb1);
		Cb1.addItemListener(f);	   
	    
	 
	  
    	b5=new JButton("Start");
		b5.setFont(f1);
		b5.setBounds(800,400,100,40);
		add(b5);
		b5.addActionListener(f);
		
    	b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
		
		


		  img2=new ImageIcon("bk1.png");
		 Lb12=new JLabel(img2);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);
		 
}

}