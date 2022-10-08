import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.event.*;
class StudentMenu2 extends JPanel
{
	static JButton b2,b1,b3,b4,b5;
	JLabel Lb1,Lb2,Lb3,Lb12,Lb4,Lb5,Lb6,Lb7,Lb8,Lb9,Lb10;
	JComboBox Cb1;
	Font f1;
	static int  total_question;
	static int  question_marks;
	
	boolean condition=false; 
	ImageIcon img1,img2,img3,img4;
	StudentMenu2(Fdemo f)
	{}
StudentMenu2(Fdemo f,String course_selected)
{
	
	  setLayout(null);
		 f1=new Font("",Font.BOLD,35);
		 
		  
		 
		  
		  System.out.println(course_selected);
		 f1=new Font("",Font.BOLD,30);
       Lb6=new JLabel("******INSTRUCTION******");
       Lb6.setFont(f1);
        Lb6.setForeground(Color.white);
		Lb6.setBounds(450,150,500,50);
		add(Lb6);
		f1=new Font("",Font.BOLD,25);
		 
		try
		{
	     Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  
		  Statement st=con.createStatement();
        
String q="select count(*),c.marks,c.hour_c,c.min,c.sec from coursename c inner join question q on c.course_name=q.course_name where c.course_name='"+course_selected+"';" ;
ResultSet rs=st.executeQuery(q);
        if(rs.next())
		{
			total_question=Integer.parseInt(rs.getString(1));
			question_marks=Integer.parseInt(rs.getString(2));
		Lb7=new JLabel("1.  There are total "+rs.getString(1)+" question each with "+rs.getString(2)+" marks in this course");
       Lb7.setFont(f1);
        Lb7.setForeground(Color.white);
		Lb7.setBounds(350,250,800,50);
		add(Lb7);
		
		Lb8=new JLabel("2.  Maximum Time is "+rs.getString(3)+":"+rs.getString(4)+":"+rs.getString(5));
		 Lb8.setFont(f1);
        Lb8.setForeground(Color.white);
		Lb8.setBounds(350,300,800,50);
		add(Lb8);
		
		
		}
		else
		{
			System.out.println("problem");
		}
		con.close();
		}
    	catch(Exception e)
		{
			
			System.out.println(e);
		}
		Lb9=new JLabel("3.  There is no negative marking for any question.");
		 Lb9.setFont(f1);
        Lb9.setForeground(Color.white);
		Lb9.setBounds(350,350,800,50);
		add(Lb9);
		
		
		Lb10=new JLabel("4.  After time up you will be automatic logged out .");
		 Lb10.setFont(f1);
        Lb10.setForeground(Color.white);
		Lb10.setBounds(350,400,800,50);
		add(Lb10);
		
		f1=new Font("",Font.BOLD,20);
		 
		
		b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
		 
    	b5=new JButton("Next");
		b5.setFont(f1);
		b5.setBounds(950,680,100,40);
		add(b5);
		b5.addActionListener(f);
		
		
		
		img2=new ImageIcon("bk1.png");
		 Lb12=new JLabel(img2);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);
		
}

}