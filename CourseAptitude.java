import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
class CourseAptitude extends JPanel implements ActionListener,ItemListener
{
	JLabel Lb1;
	JButton b1,b2;
     Font f1;
	Aptitude apti;
    int que1,que2;

	
	String Correct_Option;
	
	String cou;
	CourseAptitude(Fdemo f)
	{
		
		
	setLayout(null);
	 f1=new Font("",Font.BOLD,30);



		// Lb1=new JLabel("COURSE :APTITUDE");
		 // Lb1.setFont(f1);
		 // Lb1.setBounds(400,30,400,50);
    	// add(Lb1);
	
		apti=new Aptitude(this);
		apti.setBounds(50,100,800,550);
		add(apti);
		
	
	Lb1=new JLabel();
   
   Lb1.setFont(f1);
		 
		Lb1.setBounds(400,30,400,50);
    	
		add(Lb1);

	
	f1=new Font("",Font.BOLD,20);
		b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
		
	 
	}
 	
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
				
					 
			String d_b="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
			String un="root";
			String up="root";
	
      Connection con=DriverManager.getConnection(d_b,un,up);
	  
	  Statement st=con.createStatement();
		if(e.getSource()==apti.New.b1)
		{
			
			String ta1=apti.New.ta1.getText().trim();
			String tx1=apti.New.tx1.getText();
			String tx2=apti.New.tx2.getText();
			String tx5=apti.New.tx5.getText();
			String tx3=apti.New.tx3.getText();
			String tx4=apti.New.tx4.getText();
			String Lb1=apti.New.tx4.getText();
			
 String q="insert into question values('"+cou+"','"+tx1+"','"+tx2+"','"+tx3+"','"+tx4+"','"+Correct_Option+"','"+tx5+"','"+ta1+"');";
st.executeUpdate(q);
	  }
	if(e.getSource()==apti.Update.b1)
	{
			
			String ta1=apti.Update.ta1.getText().trim();
			String tx1=apti.Update.tx1.getText();
			String tx2=apti.Update.tx2.getText();
			String tx3=apti.Update.tx3.getText();
			String tx4=apti.Update.tx4.getText();
			String tx5=apti.Update.tx5.getText();
	
	
String q="Update question set course_name='"+cou+"',option1='"+tx1+"',option2='"+tx2+"',option3='"+tx3+"',option4='"+tx4+"',correct_option='"+tx5+"',c_id='"+que1+" ',ques='"+ta1+"' where course_name='"+cou+"' and c_id ='"+que1+"'";
st.executeUpdate(q);
		
	}
	if(e.getSource()==apti.Remove.b1)
	{
	String q="delete from question where c_id='"+que2+"'";
	 System.out.println("class A");	
	st.executeUpdate(q);
	}
con.close();
	}
		catch(Exception e1)
		{
		System.out.println();
		}
	}
	public void itemStateChanged(ItemEvent e)
	{
		
		if(apti.New.Cb1!=null)Correct_Option=(String)apti.New.Cb1.getSelectedItem();

		 try
		 {
			 
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  

		  Statement st=con.createStatement();
		 
			if(apti.view.Cb1!=null)
			{
		 String que=(String)apti.view.Cb1.getSelectedItem();
          int que1=Integer.parseInt(que);		 
		 
     String q="select * from question where course_name='"+cou+"'and c_id='"+que1+"';" ;
		
		
		   ResultSet rs=st.executeQuery(q);

		 if(rs.next())
		 {
     		 apti.view.tx1.setText(rs.getString(2));
             apti.view.ta1.setText(rs.getString(8));
            apti.view.tx2.setText(rs.getString(3));
     		 apti.view.tx3.setText(rs.getString(4));
     		 apti.view.tx4.setText(rs.getString(5));
     		 apti.view.Lb8.setText(rs.getString(6));
			 }
    	}
		if(apti.Update.Cb1!=null)
			{
		String que=(String)apti.Update.Cb1.getSelectedItem();
          que1=Integer.parseInt(que);		 
		 
		 
		 String q="select * from question where course_name='"+cou+"' and c_id='"+que1+"' " ;
          ResultSet rs=st.executeQuery(q);

		 if(rs.next())
		   {
     		 apti.Update.tx1.setText(rs.getString(2));
		    apti.Update.ta1.setText(rs.getString(8));
            apti.Update.tx2.setText(rs.getString(3));
     		 apti.Update.tx3.setText(rs.getString(4));
     		 apti.Update.tx4.setText(rs.getString(5));
     		 apti.Update.tx5.setText(rs.getString(6));
			 }
    	}		
			if(apti.Remove!=null)
			{
			String que=(String)apti.Remove.Cb1.getSelectedItem();
          que2=Integer.parseInt(que);		 
		 
		 
		 String q="select * from question where course_name='"+cou+"' and c_id='"+que2+"' " ;
          ResultSet rs=st.executeQuery(q);

		 if(rs.next())
		   {
     		 apti.Remove.tx1.setText(rs.getString(2));
		    apti.Remove.ta1.setText(rs.getString(8));
            apti.Remove.tx2.setText(rs.getString(3));
     		 apti.Remove.tx3.setText(rs.getString(4));
     		 apti.Remove.tx4.setText(rs.getString(5));
     		 apti.Remove.tx5.setText(rs.getString(6));
			 }	
			}
			
			
		con.close();
        }
		catch(Exception e1)
		 {
			System.out.println(e1); 
		 }
		 
		 
	}
		public void show1()
	{
		Lb1.setText("COURSE :"+cou);
	 f1=new Font("",Font.BOLD,25);


 	JLabel Lb2=new JLabel("Course Name : "+ cou);
	Lb2.setBounds(880,250,350,50);
	Lb2.setFont(f1);
	Lb2.setForeground(Color.white);
	add(Lb2);
	
	 // f1=new Font("",Font.BOLD,20);
	// JTextField tx1=new JTextField();
	// tx1.setBounds(880,250,130,40);
	// tx1.setFont(f1);
	// add(tx1);
		// tx1.setText(cou);
		
	
	// f1=new Font("",Font.BOLD,20);
	// JTextField tx2=new JTextField();
	// tx2.setBounds(900,350,50,40);
	// tx2.setFont(f1);
	// add(tx2);
	
	// JTextField tx3=new JTextField();
	// tx3.setBounds(950,350,50,40);
	// tx3.setFont(f1);
	// add(tx3);
	
	
	// JTextField tx4=new JTextField();
	// tx4.setBounds(1000,350,50,40);
	// tx4.setFont(f1);
	// add(tx4);
	
	
	 f1=new Font("",Font.BOLD,25);
	
	 
	try{
		
			 
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  

		  Statement st=con.createStatement();
		 
		 if(true)
		 {
		String q1="select count(*) from question where course_name='"+cou+"'";
		 
		 ResultSet rs1=st.executeQuery(q1);
		 if(rs1.next())
		 {
	     
	JLabel Lb5=new JLabel("Total Question : " + rs1.getString(1));
	Lb5.setBounds(880,400,250,50);
	Lb5.setForeground(Color.white);
	Lb5.setFont(f1);
	add(Lb5);
	
			 
		 }
		 }
		 if(true)
		 {
			 
		String q="select * from coursename where course_name='"+cou+"'";	 
	    ResultSet rs=st.executeQuery(q);		 
			 if(rs.next())
			 {
				 
	JLabel Lb3=new JLabel("Time  : 0"+rs.getString(3)+" : 0"+rs.getString(4)+" : 0"+rs.getString(5));
	Lb3.setBounds(880,300,400,50);
	Lb3.setFont(f1);
	Lb3.setForeground(Color.white);
	add(Lb3);
				 
				 
	JLabel Lb4=new JLabel("Each Marks : " +rs.getString(6));
	Lb4.setForeground(Color.white);
	Lb4.setBounds(880,350,350,50);
	Lb4.setFont(f1);
	add(Lb4);
	
				 
				 
			 }
			 
			 
		 }
		 
	}
	catch(Exception e)
	{
		System.out.println(e);
	}
	
	
	ImageIcon img22=new ImageIcon("bk1.png");
		JLabel Lb12=new JLabel(img22);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);

       

	}

	
}
class Aptitude extends JPanel  
{
   JTabbedPane tab;
	NewDemo New;
	ViewDemo view;
	UpdateDemo Update;
	RemoveDemo Remove;
	
	Aptitude(CourseAptitude f)
	{
		
	Font f1=new Font("",Font.BOLD,22);
		setLayout(new BorderLayout());
		
		tab=new JTabbedPane();
		tab.setFont(f1);
		
		New=new NewDemo(f);
		tab.addTab("New",New);
		
		view =new ViewDemo(f);
		tab.addTab("view",view);
		
		Update =new UpdateDemo(f);
		tab.addTab("Update",Update);
		
		Remove=new RemoveDemo(f);
		tab.addTab("Remove",Remove);
		
		add(tab);
       
	   
	}
} 


class NewDemo extends JPanel
{
	
	JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7;
	JComboBox Cb1;
	JTextArea ta1;
	JButton b1;
	
	JTextField tx1,tx2,tx3,tx4,tx5;
	String s1[]={"1","2","3","4"};
	NewDemo(CourseAptitude f)
	{
	 	
		Font f1=new Font("",Font.BOLD,20);
		setLayout(null);
		Lb1=new JLabel("Question ID :");
		Lb1.setBounds(10,30,150,30);
		Lb1.setFont(f1);
		add(Lb1);
        
		tx5=new JTextField(10);
		tx5.setBounds(250,30,150,30);
		tx5.setFont(f1);
		add(tx5);
		
		
 
		Lb2=new JLabel("Question Statement :");
		Lb2.setBounds(10,80,250,30);
		Lb2.setFont(f1);
		add(Lb2);       		
	    
		ta1=new JTextArea(10,50);
		ta1.setBackground(Color.black);
		ta1.setForeground(Color.white);
		ta1.setBounds(250,80,500,150);
		ta1.setFont(f1);
		add(ta1);
	
	    
		Lb3=new JLabel("Option 1 :");
		Lb3.setBounds(10,250,200,30);
		Lb3.setFont(f1);
		add(Lb3);       		
	    
		tx1=new JTextField(10);
		tx1.setBounds(250,250,200,30);
		tx1.setFont(f1);
		add(tx1);       		
	    
		Lb4=new JLabel("Option 2 :");
		Lb4.setBounds(10,300,200,30);
		Lb4.setFont(f1);
		add(Lb4);       		
	    
		tx2=new JTextField(10);
		tx2.setBounds(250,300,200,30);
		tx2.setFont(f1);
		add(tx2);       		
	    
		Lb5=new JLabel("Option 3 :");
		Lb5.setBounds(10,350,200,30);
		Lb5.setFont(f1);
		add(Lb5);       		
	    
		tx3=new JTextField(10);
		tx3.setBounds(250,350,200,30);
		tx3.setFont(f1);
		add(tx3);       		
	    
		Lb6=new JLabel("Option 4 :");
		Lb6.setBounds(10,400,200,30);
		Lb6.setFont(f1);
		add(Lb6);       		
	    
		tx4=new JTextField(10);
		tx4.setBounds(250,400,200,30);
		tx4.setFont(f1);
		add(tx4);       		
	    
		Lb7=new JLabel("Correct Option :");
		Lb7.setBounds(10,450,200,30);
		Lb7.setFont(f1);
		add(Lb7);       		
	    
		
		Cb1=new JComboBox(s1);
		Cb1.setFont(f1);
        Cb1.setBounds(250,450,200,30);
		add(Cb1);
	    Cb1.addItemListener(f);
		
		
		b1=new JButton("Submit");
	    b1.setFont(f1);
        b1.setBounds(600,450,100,30);
		add(b1);
		b1.addActionListener(f);
	}
}

class UpdateDemo extends JPanel
{
	JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7;
	JComboBox Cb1;
	JTextArea ta1;
	JButton b1;
	JTextField tx1,tx2,tx3,tx4,tx5;
	UpdateDemo(CourseAptitude f)
	{

	 	
		Font f1=new Font("",Font.BOLD,20);
		setLayout(null);
		Lb1=new JLabel("Question ID :");
		Lb1.setBounds(10,30,150,30);
		Lb1.setFont(f1);
		add(Lb1);
		
		Cb1=new JComboBox();
		Cb1.setFont(f1);
        Cb1.setBounds(250,30,150,30);
		add(Cb1);
		Cb1.addItemListener(f);
		
 
		Lb2=new JLabel("Question Statement :");
		Lb2.setBounds(10,80,250,30);
		Lb2.setFont(f1);
		add(Lb2);       		
	    
		ta1=new JTextArea(10,50);
		ta1.setBackground(Color.black);
		ta1.setForeground(Color.white);
		ta1.setBounds(250,80,500,150);
		ta1.setFont(f1);
		add(ta1);
	
	    
		Lb3=new JLabel("Option 1 :");
		Lb3.setBounds(10,250,200,30);
		Lb3.setFont(f1);
		add(Lb3);       		
	    
		tx1=new JTextField(10);
		tx1.setBounds(250,250,200,30);
		tx1.setFont(f1);
		add(tx1);       		
	    
		Lb4=new JLabel("Option 2 :");
		Lb4.setBounds(10,300,200,30);
		Lb4.setFont(f1);
		add(Lb4);       		
	    
		tx2=new JTextField(10);
		tx2.setBounds(250,300,200,30);
		tx2.setFont(f1);
		add(tx2);       		
	    
		Lb5=new JLabel("Option 3 :");
		Lb5.setBounds(10,350,200,30);
		Lb5.setFont(f1);
		add(Lb5);       		
	    
		tx3=new JTextField(10);
		tx3.setBounds(250,350,200,30);
		tx3.setFont(f1);
		add(tx3);       		
	    
		Lb6=new JLabel("Option 4 :");
		Lb6.setBounds(10,400,200,30);
		Lb6.setFont(f1);
		add(Lb6);       		
	    
		tx4=new JTextField(10);
		tx4.setBounds(250,400,200,30);
		tx4.setFont(f1);
		add(tx4);       		
	    
		Lb7=new JLabel("Correct Option :");
		Lb7.setBounds(10,450,200,30);
		Lb7.setFont(f1);
		add(Lb7);       		
	    
		tx5=new JTextField();
		tx5.setFont(f1);
        tx5.setBounds(250,450,200,30);
		add(tx5);
		
		
		b1=new JButton("Save");
	    b1.setFont(f1);
        b1.setBounds(600,450,100,30);
		add(b1);
		b1.addActionListener(f);
		
	}
	
}
class RemoveDemo extends JPanel
{
	
    	JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7;
	JComboBox Cb1;
	JTextArea ta1;
	
	JTextField tx1,tx2,tx3,tx4,tx5;

	  JButton b1;

	RemoveDemo(CourseAptitude f)
	{
		
	
		Font f1=new Font("",Font.BOLD,20);
		setLayout(null);
		Lb1=new JLabel("Question ID :");
		Lb1.setBounds(10,30,150,30);
		Lb1.setFont(f1);
		add(Lb1);
		
		Cb1=new JComboBox();
		Cb1.setFont(f1);
        Cb1.setBounds(250,30,150,30);
		add(Cb1);
        
	    Cb1.addItemListener(f);
		
 
		Lb2=new JLabel("Question Statement :");
		Lb2.setBounds(10,80,250,30);
		Lb2.setFont(f1);
		add(Lb2);       		
	    
		ta1=new JTextArea(10,50);
		ta1.setBackground(Color.black);
		ta1.setForeground(Color.white);
		ta1.setBounds(250,80,500,150);
		ta1.setFont(f1);
		add(ta1);
	
	    
		Lb3=new JLabel("Option 1 :");
		Lb3.setBounds(10,250,200,30);
		Lb3.setFont(f1);
		add(Lb3);       		
	    
		tx1=new JTextField(10);
		tx1.setBounds(250,250,200,30);
		tx1.setFont(f1);
		add(tx1);       		
	    
		Lb4=new JLabel("Option 2 :");
		Lb4.setBounds(10,300,200,30);
		Lb4.setFont(f1);
		add(Lb4);       		
	    
		tx2=new JTextField(10);
		tx2.setBounds(250,300,200,30);
		tx2.setFont(f1);
		add(tx2);       		
	    
		Lb5=new JLabel("Option 3 :");
		Lb5.setBounds(10,350,200,30);
		Lb5.setFont(f1);
		add(Lb5);       		
	    
		tx3=new JTextField(10);
		tx3.setBounds(250,350,200,30);
		tx3.setFont(f1);
		add(tx3);       		
	    
		Lb6=new JLabel("Option 4 :");
		Lb6.setBounds(10,400,200,30);
		Lb6.setFont(f1);
		add(Lb6);       		
	    
		tx4=new JTextField(10);
		tx4.setBounds(250,400,200,30);
		tx4.setFont(f1);
		add(tx4);       		
	    
		Lb7=new JLabel("Correct Option :");
		Lb7.setBounds(10,450,200,30);
		Lb7.setFont(f1);
		add(Lb7);       		
		
		
		tx5=new JTextField(10);
		tx5.setBounds(250,450,200,30);
		tx5.setFont(f1);
		add(tx5);       		
	    
		
		b1=new JButton("Remove");
	    b1.setFont(f1);
        b1.setBounds(600,450,130,30);
		add(b1);
		b1.addActionListener(f);
	}
	 
}
class ViewDemo extends JPanel
{
	JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7 ;
	JComboBox Cb1;
	JTextArea ta1;
	Font f1;
	JTextField tx1,tx2,tx3,tx4,Lb8;
     CourseAptitude co;
	ViewDemo(CourseAptitude f)
	{

	 f1=new Font("",Font.BOLD,20);
		setLayout(null);
		Lb1=new JLabel("Question ID :");
		Lb1.setBounds(10,30,150,30);
		Lb1.setFont(f1);
		add(Lb1);
		
		
		 
		 
		Cb1=new JComboBox();
		Cb1.setFont(f1);
        Cb1.setBounds(250,30,150,30);
		add(Cb1);
        
	    Cb1.addItemListener(f);
		
 
		Lb2=new JLabel("Question Statement :");
		Lb2.setBounds(10,80,250,30);
		Lb2.setFont(f1);
		add(Lb2);       		
	    
		ta1=new JTextArea(10,50);
		ta1.setBackground(Color.black);
		ta1.setForeground(Color.white);
		ta1.setBounds(250,80,500,150);
		ta1.setFont(f1);
		add(ta1);
	
	    
		Lb3=new JLabel("Option 1 :");
		Lb3.setBounds(10,250,200,30);
		Lb3.setFont(f1);
		add(Lb3);       		
	    
		tx1=new JTextField(10);
		tx1.setBounds(250,250,200,30);
		tx1.setFont(f1);
		add(tx1);       		
	    
		Lb4=new JLabel("Option 2 :");
		Lb4.setBounds(10,300,200,30);
		Lb4.setFont(f1);
		add(Lb4);       		
	    
		tx2=new JTextField(10);
		tx2.setBounds(250,300,200,30);
		tx2.setFont(f1);
		add(tx2);       		
	    
		Lb5=new JLabel("Option 3 :");
		Lb5.setBounds(10,350,200,30);
		Lb5.setFont(f1);
		add(Lb5);       		
	    
		tx3=new JTextField(10);
		tx3.setBounds(250,350,200,30);
		tx3.setFont(f1);
		add(tx3);       		
	    
		Lb6=new JLabel("Option 4 :");
		Lb6.setBounds(10,400,200,30);
		Lb6.setFont(f1);
		add(Lb6);       		
	    
		tx4=new JTextField(10);
		tx4.setBounds(250,400,200,30);
		tx4.setFont(f1);
		add(tx4);       		
	    
		Lb7=new JLabel("Correct Option :");
		Lb7.setBounds(10,450,200,30);
		Lb7.setFont(f1);
		add(Lb7);       		
		
		Lb8=new JTextField(10);
		Lb8.setBounds(250,450,200,30);
		Lb8.setFont(f1);
		add(Lb8);       		
	    
	
    
	

	}
	
}