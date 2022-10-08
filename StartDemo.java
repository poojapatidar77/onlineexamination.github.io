import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class StartDemo extends JPanel
{
	JLabel Lb1,Lb2;
	JButton b1 ,b2;
		ImageIcon img1;
		Image next;
	StartDemo(Fdemo f)
	{
		setLayout(null);
		Font f1=new Font("",Font.BOLD,40);
		// img1=new ImageIcon("next1.png");
	     // next=img1.getImage();
		 
		 
		// Lb1=new JLabel("Online Examination System");
		// Lb1.setBounds(300,300,1000,60);
		// Lb1.setFont(f1);
		// add(Lb1);
		 f1=new Font("",Font.BOLD,20);
		
		b1=new JButton("Help");
		b1.setFont(f1);
		b1.setBounds(100,680,80,40);
		add(b1);
		b1.addActionListener(f);
		
		b2=new JButton("Next");
		b2.setFont(f1);
		b2.setBounds(1000,680,100,40);
		add(b2);
		b2.addActionListener(f);
		
		img1=new ImageIcon("front2.png");
		Lb2=new JLabel(img1);
		Lb2.setBounds(0,0,1200,800);
		add(Lb2);
		 
	}
}
