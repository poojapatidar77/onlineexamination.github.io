import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class AddCourse extends JPanel
{
	JButton b1,b2;
	JLabel Lb1,Lb2,Lb3;
	ImageIcon img1;
	JTextField tx1,tx2,tx3,tx4;
	JComboBox Cb1;
	 String s1[]={"1","2","3","4","5","6","10"};
	AddCourse(Fdemo f)
	{
	
		setLayout(null);
		Font f1=new Font("",Font.BOLD,30);

		
		Lb1=new JLabel("ADD COURSE");
		 Lb1.setFont(f1);
		 Lb1.setBounds(450,50,300,50);
    	add(Lb1);
		
		img1=new ImageIcon("newcourse.png");
		Lb2=new JLabel(img1);
		 Lb2.setFont(f1);
		 Lb2.setBounds(430,50,270,270);
    	add(Lb2);
	
		 f1=new Font("",Font.BOLD,15);
		tx1=new JTextField("COURSE NAME");
		 tx1.setFont(f1);
          tx1.setForeground(Color.gray); 
		 tx1.setBounds(400,290,370,40);
		add(tx1);
		tx1.addKeyListener(f);



		tx2=new JTextField("HOUR");
		 tx2.setFont(f1);
          tx2.setForeground(Color.gray); 
		 tx2.setBounds(450,360,70,40);
		add(tx2);
		tx2.addKeyListener(f);
        
		tx3=new JTextField("MINUTE");
		 tx3.setFont(f1);
          tx3.setForeground(Color.gray); 
		 tx3.setBounds(550,360,70,40);
		add(tx3);
		tx3.addKeyListener(f);
        
		tx4=new JTextField("SECOND");
		 tx4.setFont(f1);
          tx4.setForeground(Color.gray); 
		 tx4.setBounds(650,360,70,40);
		add(tx4);
		tx4.addKeyListener(f);
        
		 f1=new Font("",Font.BOLD,20);
	     Lb3=new JLabel("EACH MARSK");
      	 Lb3.setFont(f1);
		 Lb3.setBounds(300,430,200,50);
    	 add(Lb3);
		 
		 Cb1=new JComboBox(s1);
		 Cb1.setFont(f1);
         Cb1.setBounds(550,430,70,40);
		add(Cb1);
		
		
		f1=new Font("",Font.BOLD,20);
		b1=new JButton("ADD COURSE");
		b1.setFont(f1);
		b1.setBounds(500,550,170,40);
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