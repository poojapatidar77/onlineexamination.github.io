import java.awt.*;
import javax.swing.*;
class HomeDemo extends JPanel
{
	JButton b1,b2,b3;
	JLabel Lb1,Lb2;
	
	ImageIcon img1,img2;
	HomeDemo(Fdemo f)
	{
		setLayout(null);
		
		Font f1=new Font("",Font.BOLD,35);
		
		
		Lb1=new JLabel("ONLINE EXAMINATION SYSTEM");
		Lb1.setBounds(350,10,700,400);
		Lb1.setForeground(Color.red);
		Lb1.setFont(f1);
		add(Lb1);
		
		 f1=new Font("",Font.BOLD,27);
		
		b1=new JButton("ADMIN");
		b1.setFont(f1);
		b1.setBounds(500,300,250,50);
		add(b1);
		b1.addActionListener(f);
		
		b2=new JButton("USER");
		b2.setFont(f1);
		b2.setBounds(500,390,250,50);
		add(b2);
		b2.addActionListener(f);
		
		f1=new Font("",Font.BOLD,20);
		
		b3=new JButton("Back");
		b3.setFont(f1);
		b3.setBounds(100,680,100,40);
		add(b3);
		b3.addActionListener(f);
		
		img2=new ImageIcon("menu1.jpg");
		Lb2=new JLabel(img2);
		Lb2.setBounds(0,0,1200,800);
		add(Lb2);
		
	}
}