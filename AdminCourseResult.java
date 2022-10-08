import java.awt.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
class AdminCourseResult extends JPanel
{
	Font f1;
	ImageIcon img1,img2;
	JButton b2;
	JLabel Lb1,Lb2,Lb12,Lb13;
	String s1[]={"S.no","Username"," Total_Q.","Attempt_Q.","Correct_Q.","Wrong_Q.","Total_marks","Marks_obtain","Percentage","Time"};
	JLabel JLb[]=new JLabel[10];
ArrayList<JLabel> al=new ArrayList<>();	
	
	int x=30,y=120;
AdminCourseResult(Fdemo f)
{
	
	      setLayout(null);
	
    	f1=new Font("",Font.BOLD,30);
		
		 Lb1=new JLabel("Result");
	      Lb1.setForeground(Color.white);
		 Lb1.setFont(f1);
		 Lb1.setBounds(500,30,400,50);
		 add(Lb1);

    	f1=new Font("",Font.BOLD,22);

		 Lb2=new JLabel();
	      Lb2.setForeground(Color.white);
		 Lb2.setFont(f1);
		 Lb2.setBounds(800,60,400,50);
		 add(Lb2);



    	f1=new Font("",Font.BOLD,17);

    	b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
		
		for(int i=0;i<9;i++)
		{
		JLb[i]=new JLabel(s1[i]);
        JLb[i].setForeground(Color.white);
		 JLb[i].setFont(f1);
		JLb[i].setBounds(x,y,400,50);
		 add(JLb[i]);
	     
		 if(i<1)x+=60;
		 else if(i<2)x+=80;
		 else if(i<5)x+=125;
		 else if(i==7)x+=140;
		 else x+=137;
	
	}

}
void show(String course_name)
{
	try
		{
			    Class.forName("com.mysql.cj.jdbc.Driver");
		
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
		Statement st=con.createStatement();
		String q="select * from studentresult where course_name='"+course_name+"'";
		ResultSet rs=st.executeQuery(q);
    Lb2.setText("Course name: "+course_name);
	int k=0;   
   int x=35,y=170;	
	while(rs.next())
	  {
		  int c=1;
          JLabel JLb2[]=new JLabel[10]; 
		  for(int i=0;i<10;i++)
		  {
		 JLb2[k]=new JLabel(rs.getString(c++));
         JLb2[k].setForeground(Color.white);
		 JLb2[k].setFont(f1);
		 JLb2[k].setBounds(x,y,400,50);
		 add(JLb2[k]);
		 if(i<1)x+=60;
		 else if(i<2)x+=80;
		 else if(i<5)x+=130;
		 else if(i==7)x+=140;
		 else if(i==8)x+=130;
		 else x+=137;
		if(c==3||c==11)c++;
		}
		  x=35;
		  y+=50;
	    }
		con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
        img1=new ImageIcon("blackboard.jpg");
		 Lb13=new JLabel(img1);
		 Lb13.setBounds(0,100,1200,550);
		 add(Lb13);
			


		  img2=new ImageIcon("bk1.png");
		 Lb12=new JLabel(img2);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);
}
}