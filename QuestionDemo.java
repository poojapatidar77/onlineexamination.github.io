import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
class QuestionDemo extends JPanel implements ActionListener ,ItemListener
{
	int current_question=1;
	static int Total_marks=0;
	static int question_marks;
	static int Total_correct_ans=0;
	static int Total_incorrect_ans=0;
	static String course;
	static int ques_attemp=0;
	
	static int total_question;
	static int correct_ans=0;

     ArrayList<Integer> al=new ArrayList<>();

	Font f1;
	
	JButton b2,b3,b4;
	JLabel Lb1,Lb2,Lb3,Lb4,Lb12,Lb13;
     ImageIcon img1,img2;
	JTextArea  ta1;
	ButtonGroup bg1;
	JRadioButton  r1,r2,r3,r4;
	
	boolean cond=false;;
	
	
QuestionDemo(Fdemo f)
{
	  setLayout(null);
	  setBackground(Color.black);
		 f1=new Font("",Font.BOLD,30);
		 Lb1=new JLabel();
	      Lb1.setForeground(Color.white);
		 Lb1.setFont(f1);
		 Lb1.setBounds(400,30,400,50);
		 add(Lb1);
		 
		 f1=new Font("",Font.BOLD,20);
		 
		 Lb2=new JLabel();
	      Lb2.setForeground(Color.white);
		 Lb2.setFont(f1);
		 Lb2.setBounds(130,200,300,50);
		 add(Lb2);
		 
		  
	    
		
		b2=new JButton("Previous");
		b2.setFont(f1);
		b2.setBounds(200,560,130,40);
		add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("Next");
		b3.setFont(f1);
		b3.setBounds(800,560,100,40);
		add(b3);
		b3.addActionListener(this);
		
		
		
		 Lb3=new JLabel();
	      Lb3.setForeground(Color.white);
		 Lb3.setFont(f1);
		 Lb3.setBounds(150,620,300,50);
		 add(Lb3);
		 
		 Lb4=new JLabel();
	      Lb4.setForeground(Color.white);
		 Lb4.setFont(f1);
		 Lb4.setBounds(750,620,300,50);
		 add(Lb4);
		 
		
		b4=new JButton("Submit");
		b4.setFont(f1);
		b4.setBounds(1030,640,100,40);
		add(b4);
		b4.addActionListener(f);
		
		
		 f1=new Font("",Font.BOLD,25);
		ta1=new JTextArea();
		ta1.setFont(f1);
		ta1.setBounds(200,200,700,150);
		add(ta1);
		
		
		
		   
		 bg1=new ButtonGroup();  
         r1=new JRadioButton();
	     r1.setBounds(200,400,200,50);
   		r1.setForeground(Color.white);
		 r1.setFont(f1);
         r1.setOpaque(false);
		 r1.setContentAreaFilled(false);
		 r1.setBorderPainted(false);
		 bg1.add(r1);
	     add(r1);
	r1.addItemListener(this); 
	     r2=new JRadioButton();
	     r2.setBounds(500,400,200,50);
   		r2.setForeground(Color.white);
		 r2.setFont(f1);
         r2.setOpaque(false);
		 r2.setContentAreaFilled(false);
		 r2.setBorderPainted(false);
	r2.addItemListener(this); 
		 
		 bg1.add(r2);
	     add(r2);
	     
	     r3=new JRadioButton();
         r3.setForeground(Color.white);
		 r3.setBounds(200,450,200,50);
		 r3.setFont(f1);
         r3.setOpaque(false);
		 r3.setContentAreaFilled(false);
		 r3.setBorderPainted(false);
		 bg1.add(r3);
	     add(r3);
	r3.addItemListener(this); 
		 
		 
	     r4=new JRadioButton();
	     r4.setBounds(500,450,200,50);
         r4.setForeground(Color.white);
		 r4.setFont(f1);
         r4.setOpaque(false);
		 r4.setContentAreaFilled(false);
		 r4.setBorderPainted(false);
		 bg1.add(r4);
	     add(r4);
	r4.addItemListener(this); 
		 
		img1=new ImageIcon("blackboard.jpg");
		 Lb13=new JLabel(img1);
		 Lb13.setBounds(100,150,900,550);
		 add(Lb13);
		
		img2=new ImageIcon("bk1.png");
		 Lb12=new JLabel(img2);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);
  
  
}

public void paint(Graphics g)
{
super.paint(g);
g.drawRect(100,150,900,550);	


}
void show(String course,int total_question,int question_marks)
{
	Lb1.setText("COURSE NAME : "+course);
	
	this.course=course;
	this.question_marks=question_marks;
	this.total_question=total_question;
		 try
		 {
			 
	    Class.forName("com.mysql.cj.jdbc.Driver");
		
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
		
		Statement st=con.createStatement();
String q="select * from question where course_name='"+course+"' and c_id='"+current_question+"' ;";
		 ResultSet rs=st.executeQuery(q);
System.out.println(course);
System.out.println(current_question);
		 if(rs.next())
	     {
		 Lb3.setText("Question attempted: "+ques_attemp);
		 Lb4.setText("Question remaining: "+(total_question-ques_attemp));
			correct_ans=Integer.parseInt(rs.getString(6)); 
			 
		 f1=new Font("",Font.BOLD,25);
         Lb2.setText("Q. "+current_question);
		 ta1.setText(rs.getString(8));           
	      r1.setText(rs.getString(2));
	      r2.setText(rs.getString(3));
	      r3.setText(rs.getString(4));
	      r4.setText(rs.getString(5));
		  }	 
		 else
		 {
			 
			 System.out.println("no question found");
		 }
		 con.close();
		 
		 
	 }
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
}
public void itemStateChanged(ItemEvent e)
{
	
		int ans=0;
		if(r1.isSelected())ans=1;
		if(r2.isSelected())ans=2;
		if(r3.isSelected())ans=3;
		if(r4.isSelected())ans=4;

	
	   if(ans==correct_ans)
		 {
			 if(current_question-1==al.size())al.add(1);
			else  if(al.size()==0)al.add(1);
		  else al.set(current_question-1,1);
   		 }
		 else if(ans>=1&&ans<=4)
		{
			if(current_question-1==al.size())al.add(0);
		else if(al.size()==0)al.add(0);
		else al.set(current_question-1,0);
		}
		ques_attemp=al.size();
	 Lb3.setText("Question attempted: "+ques_attemp);
		 Lb4.setText("Question remaining: "+(total_question-ques_attemp));
	
	
	}
public void actionPerformed(ActionEvent e)

{
	if(e.getSource()==b3 ||e.getSource()==b2)
	{
	
   if(e.getSource()==b3)current_question++;
		if(e.getSource()==b2)current_question--;
		if(current_question<=total_question)
		{
		ta1.setText("");
		r1.setText("");
		r2.setText("");
		r3.setText("");
		r4.setText("");
		Lb2.setText("");
		//if(e.getSource()==b3)bg1.clearSelection();
		}
		
		show(course,total_question,question_marks);
	}
	
}
}
