import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class AdminPanel extends JPanel
{
	JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7;
	JButton b1,b2,b3,b4,b5,b6,b7;
	
	ImageIcon  img1,img2,img3,img5,img6,img7;
	Image managecourse;
	AdminPanel(Fdemo f)
	{
		
		setLayout(null);
		Font f1=new Font("",Font.BOLD,30);

		
		Lb1=new JLabel("ADMIN PANEL");
		 Lb1.setFont(f1);
		 Lb1.setBounds(500,50,300,50);
    	add(Lb1);
   
        img1=new ImageIcon("result3.png");
	    Lb2=new JLabel(img1);
		Lb2.setBounds(5,100,300,300);
    	add(Lb2);
		
		f1=new Font("",Font.BOLD,20);
		b3=new JButton("Result");
		 b3.setFont(f1);
		
		b3.setBounds(260,230,120,40);
		add(b3);
		b3.addActionListener(f);
		
		
        img2=new ImageIcon("managecourse2.png");
		Lb3=new JLabel(img2);
		Lb3.setBounds(450,150,150,180);
    	add(Lb3);
	    	
		b1=new JButton("Course");
		 b1.setFont(f1);
		b1.setBounds(620,230,110,40);
		add(b1);
		b1.addActionListener(f);
		
		 img3=new ImageIcon("logout.png");
		Lb4=new JLabel(img3);
		Lb4.setBounds(850,150,150,180);
    	add(Lb4);
	    	
		b4=new JButton("Logout");
		 b4.setFont(f1);
		b4.setBounds(1000,230,110,40);
		add(b4);
		b4.addActionListener(f);
		
		
		 img5=new ImageIcon("user1.png");
		Lb5=new JLabel(img5);
		Lb5.setBounds(50,400,200,200);
    	add(Lb5);
	    	
		
		b5=new JButton("Users");
		 b5.setFont(f1);
		b5.setBounds(230,480,110,40);
		add(b5);
		b5.addActionListener(f);
		
		 img6=new ImageIcon("verification.png");
		Lb6=new JLabel(img6);
		Lb6.setBounds(420,400,200,200);
    	add(Lb6);
		
		
		b6=new JButton("Verify");
		 b6.setFont(f1);
		b6.setBounds(620,480,110,40);
		add(b6);
		b6.addActionListener(f);
		
		
		img7=new ImageIcon("password.png");
		Lb7=new JLabel(img7);
		Lb7.setBounds(830,400,200,200);
    	add(Lb7);
		
		
		b7=new JButton("reset");
		 b7.setFont(f1);
		b7.setBounds(1020,480,110,40);
		add(b7);
		b7.addActionListener(f);
		
		
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