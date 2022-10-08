import java.awt.*;
import java.sql.*;
import javax.swing.*;
class AdminUser extends JPanel
{
	Font f1;
	JButton b2,b1;
	JLabel Lb1,Lb2;
	JComboBox Cb1;
AdminUser(Fdemo f)
{
	
	    
	      setLayout(null);
	
    	f1=new Font("",Font.BOLD,30);
		
		 Lb1=new JLabel("USER");
	      // Lb1.setForeground(Color.white);
		 Lb1.setFont(f1);
		 Lb1.setBounds(520,30,400,50);
		 add(Lb1);
		 
		 Lb2=new JLabel("Available User");
	      Lb2.setForeground(Color.red);
		 Lb2.setFont(f1);
		 Lb2.setBounds(200,300,300,50);
		 add(Lb2);
		 
    	f1=new Font("",Font.BOLD,20);
         Cb1=new JComboBox();
		 try
		 {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String db="jdbc:mysql://localhost:3306/onlineexam?use SSL=false";
		String un="root";
		String up="root";
		Connection con=DriverManager.getConnection(db,un,up);
		Statement st=con.createStatement();
		
		String q="select * from students";
		ResultSet rs=st.executeQuery(q);
		while(rs.next())
		{
			Cb1.addItem(rs.getString(1));
		}
		
		 }
		 catch(Exception e) 
		 {
			 System.out.println(e);
		 }
		  
		 Cb1.setFont(f1);
		 Cb1.setBounds(450,300,270,50);
		 add(Cb1);
          
	
    	b1=new JButton("Search");
		b1.setFont(f1);
		b1.setBounds(800,300,100,40);
		add(b1);
		b1.addActionListener(f);
		
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