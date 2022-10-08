import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.*;
class StudentRegister extends JPanel implements ActionListener
{
	JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7,Lb8,Lb9,Lb10,Lb11,Lb12;
	JButton b2,b1,b3;
	JTextArea ta1;
	ImageIcon img1,img2;
	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10;
    ButtonGroup bg1;
	JRadioButton r1,r2,r3;
    JComboBox Cb1,Cb2,Cb3;
 int student_count=0;
 String Month[]={"January","February","March","April","May","June","July","August","September","October","November","December"};
void show2()
{

		 try
		 {
			 
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  
		  Statement st=con.createStatement();
		  String q="select * from students" ;
		   
		 
		   ResultSet rs=st.executeQuery(q);
		   while(rs.next())
		   {
			student_count++;
		  }
		 }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
		   
}
StudentRegister(Fdemo f, StudentLoginDemo s)
{
	
		setLayout(null);
		Font f1=new Font("",Font.BOLD,30);
		
		
		 img1=new ImageIcon("register.png");
		 Lb11=new JLabel(img1);
		 Lb11.setBounds(750,250,400,400);
		 add(Lb11);
		 
		 // img2=new ImageIcon("bk1.png");
		 // Lb12=new JLabel(img2);
		 // Lb12.setBounds(0,0,1200,800);
		 // add(Lb12);
		
		 Lb1=new JLabel("STUDENT REGISTERATION");
		 Lb1.setFont(f1);
		 Lb1.setBounds(400,20,500,50);
		 add(Lb1);
		 
		 f1=new Font("",Font.BOLD,22);
		 

		 Lb2=new JLabel("USERNAME");
		 Lb2.setFont(f1);
		 Lb2.setBounds(250,120,200,40);
		 add(Lb2);
		 
         tx1=new JTextField();
		 tx1.setFont(f1);
		 tx1.setBounds(390,120,200,40);
		 add(tx1);

		 Lb3=new JLabel("PASSWORD");
		 Lb3.setFont(f1);
		 Lb3.setBounds(620,120,200,40);
		 add(Lb3);
		 
         tx2=new JTextField();
		 tx2.setFont(f1);
		 tx2.setBounds(760,120,200,40);
		 add(tx2);

         
		 Lb4=new JLabel("NAME");
		 Lb4.setFont(f1);
		 Lb4.setBounds(250,180,200,40);
		 add(Lb4);
		 
		 
         tx3=new JTextField();
		 tx3.setFont(f1);
		 tx3.setBounds(390,180,100,40);
		 add(tx3);
         
		 
         tx4=new JTextField();
		 tx4.setFont(f1);
		 tx4.setBounds(520,180,100,40);
		 add(tx4);
         
         tx5=new JTextField();
		 tx5.setFont(f1);
		 tx5.setBounds(650,180,100,40);
		 add(tx5);
         
		 
		 Lb5=new JLabel("MOBILE NO.");
		 Lb5.setFont(f1);
		 Lb5.setBounds(250,250,200,40);
		 add(Lb5);
		 
         tx6=new JTextField();
		 tx6.setFont(f1);
		 tx6.setBounds(390,250,300,40);
		 add(tx6);

        
		 Lb6=new JLabel("GENDER");
		 Lb6.setFont(f1);
		 Lb6.setBounds(250,330,200,40);
		 add(Lb6);
		 
		 bg1=new ButtonGroup();
		 
		 r1=new JRadioButton("MALE");
		 r1.setFont(f1);
		 r1.setBounds(390,330,100,40);
         bg1.add(r1);
		 add(r1);
		 
		 r2=new JRadioButton("FEMALE");
		 r2.setFont(f1);
		 r2.setBounds(490,330,120,40);
         bg1.add(r2);
		 add(r2);
		 
		 r3=new JRadioButton("OTHER");
		 r3.setFont(f1);
		 r3.setBounds(620,330,120,40);
         bg1.add(r3);
		 add(r3);
		 
		 Lb7=new JLabel("E-MAIL");
		 Lb7.setFont(f1);
		 Lb7.setBounds(250,400,200,40);
		 add(Lb7);
		 
		 
         tx7=new JTextField();
		 tx7.setFont(f1);
		 tx7.setBounds(390,400,300,40);
		 add(tx7);

          
		 Lb8=new JLabel("D.O.B");
		 Lb8.setFont(f1);
		 Lb8.setBounds(250,460,200,40);
		 add(Lb8);
		 
		 Cb1=new JComboBox();
          for(int i=1;i<=31;i++)
		   Cb1.addItem(""+i);	  
		Cb1.setFont(f1);
		 Cb1.setBounds(390,460,70,40);
          add(Cb1);
		  
		 Cb2=new JComboBox(Month);
          Cb2.setFont(f1);
		 Cb2.setBounds(480,460,120,40);
          add(Cb2);
		  
		 Cb3=new JComboBox();
          for(int i=1990;i<=2022;i++)
		   Cb3.addItem(""+i);	  
		Cb3.setFont(f1);
		 Cb3.setBounds(620,460,100,40);
          add(Cb3);
		  
		  
		 Lb9=new JLabel("COLLEGE");
		 Lb9.setFont(f1);
		 Lb9.setBounds(250,520,200,40);
		 add(Lb9);
		 
		 
         tx8=new JTextField();
		 tx8.setFont(f1);
		 tx8.setBounds(390,520,300,40);
		 add(tx8);

          
		 Lb10=new JLabel("ADDRESS");
		 Lb10.setFont(f1);
		 Lb10.setBounds(250,580,200,40);
		 add(Lb10);
		    
			
         tx9=new JTextField();
		 tx9.setFont(f1);
		 tx9.setBounds(390,580,300,70);
		 add(tx9);

 
		 f1=new Font("",Font.BOLD,20);
			
		b1=new JButton("SUBMIT");
		b1.setFont(f1);
		b1.setBounds(450,680,120,40);
		add(b1);
		b1.addActionListener(this);
		
		
 
		b3=new JButton("RESET");
		b3.setFont(f1);
		b3.setBounds(590,680,120,40);
		add(b3);
		b3.addActionListener(this);
		

 
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
public void actionPerformed(ActionEvent e)
{
	if(e.getSource()==b1)
	{
			String user_name=tx1.getText();
			String pass=tx2.getText().trim();
			String name1=tx3.getText().trim();
			String name2=tx4.getText().trim();
			String name3=tx5.getText().trim();
			String mobile_no=tx6.getText().trim();
			String email=tx7.getText().trim();
			String college=tx8.getText().trim();
			String address=tx9.getText().trim();
			String gender="";
			if(r1.isSelected()) gender=r1.getLabel();
			if(r2.isSelected()) gender=r2.getLabel();
			if(r3.isSelected()) gender=r3.getLabel();
			String dob1=(String)Cb1.getSelectedItem();
			String dob2=(String)Cb2.getSelectedItem();
			String dob3=(String)Cb3.getSelectedItem();
			
			
			
		   try
			{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
		
		Statement st=con.createStatement();
		student_count=student_count+1;
String q="insert into students values('"+user_name+"','"+pass+"','"+name1+"','"+name2+"','"+name3+"','"+mobile_no+"','"+gender+"','"+email+"','"+dob1+"','"+dob2+"','"+dob3+"','"+college+"','"+address+"',0,'"+student_count+"')";
       st.executeUpdate(q);	
	   con.close();
JOptionPane.showMessageDialog(this,"You Have Registered Successfully","Message",JOptionPane.INFORMATION_MESSAGE);		

		}
		   catch(Exception e1)
		   {
JOptionPane.showMessageDialog(this,"User name is already exist ","Message",JOptionPane.INFORMATION_MESSAGE);		
			   System.out.println(e1);
		   }
	}
	if(e.getSource()==b3)
	{
		tx1.setText("");
		tx2.setText("");
		tx3.setText("");
		tx4.setText("");
		tx5.setText("");
		tx6.setText("");
		tx7.setText("");
		tx8.setText("");
		tx9.setText("");
	}
}
}