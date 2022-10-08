import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class Fdemo extends JFrame implements ActionListener ,KeyListener ,ItemListener
{
	String name1;
	String course_selected1;
	static String student_user_name;
	static String student_user_pass;
	String 	deleted_item;	
	static int student_id;
	StartDemo start;
	HomeDemo home;
	AdminLoginDemo admin_login;
	AdminRegisterDemo admin_register;
	CardLayout card;
	AdminPanel admin_panel;
	AdminManageCourse admin_manage_cource;
	CourseAptitude course_aptitude;
	AddCourse add_course;
	StudentLoginDemo student_login;
	StudentRegister student_register;
	StudentMenu student_menu;
	StudentMenu2 student_menu2;
	StudentMenu2 student_menu21;
	QuestionDemo question_demo2;
	SubmitResult submit_result;
	StudentResult student_result;
	AdminUser admin_user;
	AdminUserResult admin_user_result;
	AdminCourse admin_course;
	AdminCourseResult admin_course_result;
	AdminVerify admin_verify;
	AdminUserDetails admin_user_details;
	AdminUserDetails2 admin_user_details2;
	UserDetails user_details;
	QuestionDemo question_demo;
	
	Container cn=getContentPane();
	Fdemo()
	{
		card=new CardLayout();
		setLayout(card);
		
		setResizable(false);
		setTitle("Online Examination System");
		
		start=new StartDemo(this);
		add("start",start);
	
	    home=new HomeDemo(this);
		add("home",home);
		
		admin_login=new AdminLoginDemo(this);
		add("admin_login",admin_login);
		
		admin_register=new AdminRegisterDemo(this);
		add("admin_register",admin_register);
		
		admin_panel=new AdminPanel(this);
		add("admin_panel",admin_panel);
		
		admin_manage_cource=new AdminManageCourse(this);
		add("admin_manage_cource",admin_manage_cource);
		
		course_aptitude=new CourseAptitude(this);
		add("course_aptitude",course_aptitude);
	
	  add_course=new AddCourse(this);
	  add("add_course",add_course);
	
	  student_login =new StudentLoginDemo(this,student_login);
	  add("student_login",student_login);
	
		   student_register=new StudentRegister(this,student_login);
	   add("student_register",student_register);

	student_menu=new StudentMenu(this);
	add("student_menu",student_menu);
	
	admin_verify=new AdminVerify(this);
	add("admin_verify",admin_verify);
	
	admin_user_details=new AdminUserDetails(this);
	add("admin_user_details",admin_user_details);
	
	admin_user_details2=new AdminUserDetails2(this);
	add("admin_user_details2",admin_user_details2);
	
	user_details=new UserDetails(this);
	add("user_details",user_details);
	
	student_menu21=new StudentMenu2(this);
	add("student_menu21",student_menu21);
	
	question_demo=new QuestionDemo(this);
	add("question_demo",question_demo);
	
	submit_result=new SubmitResult(this);
	add("submit_result",submit_result);
	
	student_result=new StudentResult(this);
	add("student_result",student_result);
	
	admin_user=new AdminUser(this);
	add("admin_user",admin_user);
	
	admin_user_result=new AdminUserResult(this);
	add("admin_user_result",admin_user_result);
	
	admin_course=new AdminCourse(this);
	add("admin_course",admin_course);
	
	admin_course_result=new AdminCourseResult(this);
	add("admin_course_result",admin_course_result);
	}
	
	
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==start.b2)card.show(cn,"home");
		else if(e.getSource()==home.b3)card.show(cn,"start");
		else if(e.getSource()==home.b2)card.show(cn,"student_login");
		else if(e.getSource()==home.b1)card.show(cn,"admin_login");
		else if(e.getSource()==admin_login.b2)card.show(cn,"home");
		else if(e.getSource()==student_login.b2)card.show(cn,"home");
		else if(e.getSource()==student_login.b3)
		{
	      student_register.show2();
		card.show(cn,"student_register");
		}	
	else if(e.getSource()==student_register.b2)card.show(cn,"student_login");
		else if(e.getSource()==admin_login.b3)card.show(cn,"admin_register");
		else if(e.getSource()==admin_register.b2)card.show(cn,"admin_login");
		else if(e.getSource()==admin_verify.b2)card.show(cn,"admin_panel");
		else if(e.getSource()==admin_user_details.b2)card.show(cn,"admin_verify");
		else if(e.getSource()==student_menu.b2)card.show(cn,"student_login");
		else if(e.getSource()==submit_result.b2)card.show(cn,"student_menu");
		else if(e.getSource()==admin_user.b2)card.show(cn,"admin_panel");
		else if(e.getSource()==admin_panel.b3)card.show(cn,"admin_course");
		else if(e.getSource()==admin_user_result.b2)card.show(cn,"admin_user_details2");
		else if(e.getSource()==admin_user_details2.b2)card.show(cn,"admin_user");
		else if(e.getSource()==admin_course.b2)card.show(cn,"admin_panel");
		else if(e.getSource()==admin_course_result.b2)card.show(cn,"admin_course");
		else if(e.getSource()==admin_course.b1)
		{
		admin_course_result.show((String)admin_course.Cb1.getSelectedItem());
        card.show(cn,"admin_course_result");
		}
		else if(e.getSource()==admin_user_details2.b3)
		{
		admin_user_result.show(admin_user_details2.user);
		card.show(cn,"admin_user_result");
			
		}	
		else if(e.getSource()==student_menu.b3)
		{
		student_result.show(student_id,student_user_name);	
		card.show(cn,"student_result");
		}	
		else if(e.getSource()==student_result.b2)card.show(cn,"student_menu");
		else if(e.getSource()==question_demo.b4)
		{
		int total_question=student_menu2.total_question;
        int	correct_question=0;
		int marks=student_menu2.question_marks;
        int	wrong_ans=0;
        for(int i:question_demo.al)
		{
		if(i==1)correct_question++;
        else if(i==0)wrong_ans++;		
		}			
        int attempt_question=question_demo.al.size();
		int total_marks=marks*total_question;
		int marks_obtain=marks*correct_question;
		float percentage=(float)((marks_obtain*100.0)/total_marks);
		
String q="2022-04-02";
int  st_id=student_id;

String time1="00:00:09";
submit_result.show(student_id,student_user_name,question_demo.course,time1,total_question,attempt_question,correct_question,wrong_ans,marks_obtain,total_marks,percentage);	
		try
		{
			    Class.forName("com.mysql.cj.jdbc.Driver");
		
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
		Statement st=con.createStatement();
		
		

String q1="insert into studentresult values('"+st_id+"','"+student_user_name+"','"+question_demo.course+"','"+total_question+"','"+attempt_question+"','"+correct_question+"','"+wrong_ans+"','"+total_marks+"','"+marks_obtain+"','"+percentage+"','"+q+"','"+time1+"');";
	
	st.executeUpdate(q1);
	
		con.close();
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
	  card.show(cn,"submit_result");
		
		}	
		else if(e.getSource()==student_menu2.b5)
		{
		
		question_demo.show(course_selected1,student_menu2.total_question,student_menu2.question_marks);
		card.show(cn,"question_demo");
		}
		else if(e.getSource()==user_details.b2)card.show(cn,"student_menu");
		else if(e.getSource()==admin_user.b1)
		{
			
			admin_user_details2.show((String)admin_user.Cb1.getSelectedItem());
			card.show(cn,"admin_user_details2");
		}
	 	else if(e.getSource()==user_details.b1||e.getSource()==admin_panel.b6||e.getSource()==student_menu.b1||e.getSource()==admin_verify.b1 || e.getSource()==admin_verify.b4)
		{
		try
		{
		
	    Class.forName("com.mysql.cj.jdbc.Driver");
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
		Statement st=con.createStatement();
		if(e.getSource()==admin_verify.b4)
		
		
		{
		String choice=(String)admin_verify.Cb1.getSelectedItem();
		String q="update students set verify=1 where user_name='"+choice+"'";
		st.executeUpdate(q);
JOptionPane.showMessageDialog(this,"Details is successfully Varified","Warning",JOptionPane.WARNING_MESSAGE);
		
		}			
		if(e.getSource()==user_details.b1)
		{
			String u_name=user_details.tx1.getText().trim();
			String pass=user_details.tx2.getText().trim();
			String name1=user_details.tx3.getText().trim();
			String name2=user_details.tx4.getText().trim();
			String name3=user_details.tx5.getText().trim();
			String mobile_no=user_details.tx6.getText().trim();
			String email=user_details.tx7.getText().trim();
			String college1=user_details.tx8.getText().trim();
			String address1=user_details.tx9.getText().trim();
			String gender="";
			if(user_details.r1.isSelected()) gender=user_details.r1.getLabel();
			if(user_details.r2.isSelected()) gender=user_details.r2.getLabel();
			if(user_details.r3.isSelected()) gender=user_details.r3.getLabel();
			String dob1=(String)user_details.Cb1.getSelectedItem();
			String dob2=(String)user_details.Cb2.getSelectedItem();
			String dob3=(String)user_details.Cb3.getSelectedItem();
			
String q="update students set user_name='"+u_name+"',pass_word='"+pass+"',first_name='"+name1+"' ,middle_name='"+name2+"',last_name='"+name3+"',mobile_no='"+mobile_no+"',gender='"+gender+"'  where user_name='"+student_user_name+"'and pass_word='"+student_user_pass+"' ; ";			
String q1="update students set email='"+email+"',DOB_date='"+dob1+"' ,DOB_month='"+dob2+"',DOB_year='"+dob3+"',college='"+college1+"',Address='"+address1+"' where user_name='"+student_user_name+"'and pass_word='"+student_user_pass+"' ; ";			
          
		  st.executeUpdate(q);	
           st.executeUpdate(q1);	
JOptionPane.showMessageDialog(this,"Your information is Successfully update","Warning",JOptionPane.WARNING_MESSAGE);
		   
		}
        if(e.getSource()==admin_panel.b6)
		{
		String q="select * from students where verify=0";	
		ResultSet rs=st.executeQuery(q);
		if(rs.next())
		{
		card.show(cn,"admin_verify");
		admin_verify.Cb1.addItem(rs.getString(1));	
		while(rs.next())
		admin_verify.Cb1.addItem(rs.getString(1));	
		}	
			
		else JOptionPane.showMessageDialog(this,"No user found","Warning",JOptionPane.WARNING_MESSAGE);
			con.close();
		}
		else if(e.getSource()==student_menu.b1)
		{
			
				System.out.println(student_user_name);
				System.out.println(student_user_pass);
				
			String q="select * from students where user_name='"+student_user_name+"'and pass_word='"+student_user_pass+"'";
         
			ResultSet rs=st.executeQuery(q);
            if(rs.next())
			{
			student_menu.student_id=Integer.parseInt(rs.getString(15));
			user_details.tx1.setText(rs.getString(1));
			user_details.tx2.setText(rs.getString(2));
		    user_details.tx3.setText(rs.getString(3));
			user_details.tx4.setText(rs.getString(4));
			user_details.tx5.setText(rs.getString(5));
			user_details.tx6.setText(rs.getString(6));
			user_details.tx7.setText(rs.getString(8));
			user_details.tx8.setText(rs.getString(12));
			user_details.tx9.setText(rs.getString(13));
			}
			else
			{
				System.out.println("problem");
			} 
			
			user_details.show2();
          card.show(cn,"user_details");	
	}
	
	
		else if(e.getSource()==admin_verify.b1)
		{
			String q="";
		 
			String choice=(String)admin_verify.Cb1.getSelectedItem();
			 q="select * from students where user_name='"+choice+"'";
			
			ResultSet rs=st.executeQuery(q);
			if(rs.next())
			{
			admin_user_details.tx1.setText(rs.getString(1));
			admin_user_details.tx2.setText(rs.getString(2));
			admin_user_details.tx3.setText(rs.getString(3));
			admin_user_details.tx4.setText(rs.getString(4));
			admin_user_details.tx5.setText(rs.getString(5));
			admin_user_details.tx6.setText(rs.getString(6));
			admin_user_details.tx7.setText(rs.getString(8));
			admin_user_details.tx8.setText(rs.getString(12));
			admin_user_details.tx9.setText(rs.getString(13));
			
			admin_user_details.Lb13=new JLabel(""+rs.getString(7).toLowerCase());
			admin_user_details.f1=new Font("",Font.BOLD,25);

			admin_user_details.Lb13.setFont(admin_user_details.f1);
		    admin_user_details.Lb13.setBounds(390,330,150,40);
			admin_user_details.add(admin_user_details.Lb13);
		 
	        admin_user_details.Lb14=new JLabel(""+rs.getString(9)+"/"+rs.getString(10)+"/"+rs.getString(11));
			admin_user_details.f1=new Font("",Font.BOLD,25);
			admin_user_details.Lb14.setFont(admin_user_details.f1);
		    admin_user_details.Lb14.setBounds(390,460,250,40);
			admin_user_details.add(admin_user_details.Lb14);
		 
	         admin_user_details.show2();   	 
			card.show(cn,"admin_user_details");
			}
			
		}
		}
		catch(Exception e1)
		{
		System.out.println(e1);	
		}
		}
		else if(e.getSource()==student_login.b1)
		{

	// card.show(cn,"student_menu");
	
	student_user_name=student_login.tx1.getText();
	student_user_pass=student_login.p1.getText();
try
{
	Class.forName("com.mysql.cj.jdbc.Driver");
		
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
	
	
		Statement st=con.createStatement();
		String s1=student_login.tx1.getText();
		String s2=student_login.p1.getText();
		
String q="select * from students where user_name='"+s1+"' and pass_word='"+s2+"'";
ResultSet rs=st.executeQuery(q);
		if(rs.next())
		{
			student_register.student_count=Integer.parseInt(rs.getString(15));
		student_id=Integer.parseInt(rs.getString(15));	
 if(rs.getString(14).equals("0"))JOptionPane.showMessageDialog(this,"Please verify your details by ADMIN","Message",JOptionPane.INFORMATION_MESSAGE);		
else 
{
	card.show(cn,"student_menu");
}	
		}
		else
		{
	JOptionPane.showMessageDialog(this,"Try Again","Warning",JOptionPane.WARNING_MESSAGE);
			
		}
		
		
con.close();
}
catch(Exception e1)
{
	JOptionPane.showMessageDialog(this,"Try Again","Warning",JOptionPane.WARNING_MESSAGE);

}

		}
		else if(e.getSource()==course_aptitude.b2)
		{


		card.show(cn,"admin_manage_cource");
    	}
		else if(e.getSource()==admin_login.b1||e.getSource()==admin_panel.b7)
		{
			
		// card.show(cn,"admin_panel");	
			try
			{
				String s1=admin_login.tx1.getText();
				String s2=admin_login.p1.getText();
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
		
		Statement st=con.createStatement();
		
		if(e.getSource()==admin_login.b1)
		{
				name1=s1;
		String q="select * from login where name='"+s1+"' AND pass='"+s2+"'";
		
		ResultSet rs=st.executeQuery(q);
		
		if(rs.next())
		{
		card.show(cn,"admin_panel");	
		}
		else 
		{
	JOptionPane.showMessageDialog(this,"Wrong user Id and Password","Warning",JOptionPane.WARNING_MESSAGE);
		}
		admin_login.tx1.setText("");
		admin_login.p1.setText("");
		}
		else if(e.getSource()==admin_panel.b7)
		{
	     		JPanel panel = new JPanel();
       JLabel label = new JLabel("Enter a password:");
       JPasswordField pass1 = new JPasswordField(10);
       panel.add(label);
       panel.add(pass1);
        String[] options = new String[]{"OK", "Cancel"};
       int option = JOptionPane.showOptionDialog(null, panel, "Change Password",
                         JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                         null, options, options[1]);
        if(option == 0) // pressing OK button
        {
        char[] password = pass1.getPassword();
		
         String q="update login set pass='"+new String(password)+"'where name='"+name1+"' ";
         st.executeUpdate(q);		 
        System.out.println("Your password is: " + new String(password));
	JOptionPane.showMessageDialog(this,"successfully password changed","",JOptionPane.INFORMATION_MESSAGE);
        System.out.println("Your password is: " + name1);
  		}
		}
		con.close();
		}
		catch(Exception e1)
		{
	JOptionPane.showMessageDialog(this,"Try Again","Warning",JOptionPane.WARNING_MESSAGE);

		}
			
		}
		else if(e.getSource()==student_menu.b5)
		{
			student_menu2=new StudentMenu2(this,student_menu.course_selected);
            add("student_menu2",student_menu2);
		     card.show(cn,"student_menu2");
		
		}
		else if(e.getSource()==student_menu21.b2)card.show(cn,"student_menu");
		else if(e.getSource()==student_menu.b4)
		{
		
	card.show(cn,"student_login");
	JOptionPane.showMessageDialog(this,"You successfully Logout","Warning",JOptionPane.INFORMATION_MESSAGE);
			
		}	
	
       	else if(e.getSource()==admin_panel.b2)card.show(cn,"admin_login");
       	else if(e.getSource()==admin_panel.b5)card.show(cn,"admin_user");
		
			
		
	    else if(e.getSource()==admin_panel.b1)card.show(cn,"admin_manage_cource");
	    else if(e.getSource()==admin_manage_cource.b2)card.show(cn,"admin_panel");
	    else if(e.getSource()==admin_panel.b4)card.show(cn,"admin_login");
	    else if(e.getSource()==admin_manage_cource.b3)
		{
		  course_aptitude.Lb1.setText("");	
         course_aptitude.show1();
    	card.show(cn,"course_aptitude");
		
		 try
		 {
			 
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  
		  Statement st=con.createStatement();
		  String q="select * from question where course_name='"+course_aptitude.cou+"'" ;
		 
		 
		   ResultSet rs=st.executeQuery(q);
		   
				
		while(rs.next())
		   {
		course_aptitude.apti.view.Cb1.addItem(rs.getString(7));
		course_aptitude.apti.Update.Cb1.addItem(rs.getString(7));
		course_aptitude.apti.Remove.Cb1.addItem(rs.getString(7));
		 
		 }
		 }
		 catch(Exception e1)
		 {
			System.out.println(e1); 
		 }
	
		}
	    else if(e.getSource()==admin_manage_cource.b1)card.show(cn,"add_course");
	    else if(e.getSource()==add_course.b2)card.show(cn,"admin_manage_cource");
	    
		
		
	    if(e.getSource()==admin_manage_cource.b4)
		{
		 try
		 {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  
		  Statement st=con.createStatement();
		  String q="delete from coursename where course_name='"+deleted_item+"'" ;
		   
		
		st.executeUpdate(q);
		
		
	con.close();
        admin_manage_cource.Cb1.removeItem(deleted_item);		
		}
		 catch(Exception e11)
		 {
			System.out.println(e11); 
		 }
		 
		}
		else if(e.getSource()==add_course.b1)
		{
			String s11=add_course.tx1.getText();
			String s2=add_course.tx2.getText();
			String s3=add_course.tx3.getText();
			String s4=add_course.tx3.getText();
			
			
			// admin_manage_cource.Cb1.addItem(s11.toUpperCase());
      
	  try
	  { 
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		  String un="root";
		  String up="root";
		  
		  Connection con=DriverManager.getConnection(db,un,up);
		  
		  int n=admin_manage_cource.count_course+1;
		  Statement st=con.createStatement();
   		  
String q="insert into coursename values('"+n+"','"+s11+"','"+s2+"','"+s3+"','"+s4+"','"+2+"')";	  
		  st.executeUpdate(q);
		  admin_manage_cource.Cb1.addItem(s11.toUpperCase());
			con.close();
      	  }
       catch(Exception e1)
	   {
		   System.out.println(e1);
	   }	
	   
		}
		
	}
	public void keyReleased(KeyEvent e)
	{
	}
	public void keyPressed(KeyEvent e)
	{
      if(student_login.tx1.isFocusOwner())
	  {
		  String s1=student_login.tx1.getText();
		if(s1.equals("Enter Username"))
        {
			student_login.tx1.setText("");
		    student_login.tx1.setForeground(Color.black);
		}    
	}
      if(student_login.p1.isFocusOwner())
	  {
		  String s1=student_login.p1.getText();
		if(s1.equals("Enter Password"))
        {
			student_login.p1.setText("");
		    student_login.p1.setForeground(Color.black);
           student_login.p1.setEchoChar('*');	
			
		} 
		
	}
	  if(admin_login.tx1.isFocusOwner())
		{
		String s1=admin_login.tx1.getText();
		if(s1.equals("Enter Username"))
        {
			admin_login.tx1.setText("");
			admin_login.tx1.setForeground(Color.black);
		}
		}
		if(admin_login.p1.isFocusOwner())
		{
			String s1=admin_login.p1.getText();
			if(s1.equals("Enter Password"))
			{
            admin_login.p1.setText("");
			admin_login.p1.setForeground(Color.black);
			admin_login.p1.setEchoChar('*');	
			}
		}
		if(add_course.tx1.isFocusOwner())
		{
			String s1=add_course.tx1.getText();
			if(s1.equals("COURSE NAME"))
			{
				add_course.tx1.setText("");
			}
		}
		if(add_course.tx2.isFocusOwner())
		{
			String s1=add_course.tx2.getText();
			if(s1.equals("HOUR"))
			{
				add_course.tx2.setText("");
			}
		}
		if(add_course.tx3.isFocusOwner())
		{
			String s1=add_course.tx3.getText();
			if(s1.equals("MINUTE"))
			{
				add_course.tx3.setText("");
			}
		}
		if(add_course.tx4.isFocusOwner())
		{
			String s1=add_course.tx4.getText();
			if(s1.equals("SECOND"))
			{
				add_course.tx4.setText("");
			}
		}
	}
	public void keyTyped(KeyEvent e)
	{
	}
	public void itemStateChanged(ItemEvent e)
	{
		// if(admin_manage_cource.Cb1.getSelectedItem()==admin_manage_cource.s1[1])card.show(cn,"course_aptitude");
	
	
		deleted_item=(String)admin_manage_cource.Cb1.getSelectedItem();
	    course_aptitude.cou=deleted_item;
              	 	
		if(student_menu.Cb1!=null)
		{

			student_menu.course_selected=(String)student_menu.Cb1.getSelectedItem();
			question_demo.course=(String)student_menu.Cb1.getSelectedItem();
               course_selected1=(String)student_menu.Cb1.getSelectedItem();
             System.out.println(course_selected1);

		}
  
	}
}
class main
{
public static void main(String ar[])
{
Fdemo f=new Fdemo();
f.setVisible(true);
f.setBounds(300,100,1200,800);
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
}
}