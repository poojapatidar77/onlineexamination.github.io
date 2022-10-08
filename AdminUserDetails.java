import java.awt.*;
import javax.swing.*;
class AdminUserDetails extends JPanel
{
		JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7,Lb8,Lb9,Lb10,Lb11,Lb12,Lb13,Lb14;
	JButton b2,b1,b3;
	JTextArea ta1;

	JTextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10;
    ButtonGroup bg1;
	JRadioButton r1,r2,r3;
    JComboBox Cb1,Cb2,Cb3;
 Font f1;
	
AdminUserDetails(Fdemo f)
{
	
		setLayout(null);
		 f1=new Font("",Font.BOLD,30);
		
		

		
		 Lb1=new JLabel("USER DETAILS");
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
		 
//		 bg1=new ButtonGroup();
		 
		 // r1=new JRadioButton("MALE");
		 // r1.setFont(f1);
		 // r1.setBounds(390,330,100,40);
         // bg1.add(r1);
		 // add(r1);
		 
		 // r2=new JRadioButton("FEMALE");
		 // r2.setFont(f1);
		 // r2.setBounds(490,330,120,40);
         // bg1.add(r2);
		 // add(r2);
		 
		 // r3=new JRadioButton("OTHER");
		 // r3.setFont(f1);
		 // r3.setBounds(620,330,120,40);
         // bg1.add(r3);
		 // add(r3);
		 
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
		 
		 // Cb1=new JComboBox();
		 // Cb1.setFont(f1);
		 // Cb1.setBounds(390,460,70,40);
          // add(Cb1);
		  
		 // Cb2=new JComboBox();
          // Cb2.setFont(f1);
		 // Cb2.setBounds(480,460,120,40);
          // add(Cb2);
		  
		 // Cb3=new JComboBox();
		 // Cb3.setFont(f1);
		 // Cb3.setBounds(620,460,100,40);
          // add(Cb3);
		  
		  
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
			
			
		b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
		
}
void show2()
{
			ImageIcon img22=new ImageIcon("bk1.png");
		JLabel Lb12=new JLabel(img22);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);

}
}