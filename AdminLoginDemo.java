import java.awt.*;
import javax.swing.*;
class AdminLoginDemo extends JPanel
{
	JLabel Lb1,Lb2;
	JTextField tx1;
	JPasswordField p1;
	JButton b1,b2,b3;

    ImageIcon img1;
	AdminLoginDemo(Fdemo f)
	{
		
		setLayout(null);
		Font f1=new Font("",Font.BOLD,30);
		
		 Lb1=new JLabel("ADMIN  LOGIN");
		 Lb1.setFont(f1);
		 Lb1.setForeground(Color.white);
		 Lb1.setBounds(520,100,300,50);
		 add(Lb1);
		 
		 
		 img1=new ImageIcon("admin.png");
		 Lb2=new JLabel(img1);
		 Lb2.setBounds(420,90,400,400);
		 add(Lb2);
		 
		 f1=new Font("",Font.BOLD,20);
		 tx1=new JTextField("Enter Username");
		 tx1.setFont(f1);
		 tx1.setForeground(Color.gray);
		 tx1.setBounds(500,400,270,50);
		 add(tx1);
		 tx1.addKeyListener(f);
		 
		 p1=new JPasswordField("Enter Password");
		 p1.setFont(f1);
		 p1.setForeground(Color.gray);
		 p1.setEchoChar((char)0);
		 p1.setBounds(500,490,270,50);
		 add(p1);
		 p1.addKeyListener(f);
		 
		 b1=new JButton("Login");
		 b1.setFont(f1);
		 b1.setForeground(Color.black);
		 b1.setBounds(550,570,150,50);
		 add(b1);
		 b1.addActionListener(f);


		b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
		
		b3=new JButton("Register");
		b3.setFont(f1);
		b3.setBounds(1000,680,150,40);
		add(b3);
		b3.addActionListener(f);

		ImageIcon img22=new ImageIcon("studentloginbk.png");
		JLabel Lb12=new JLabel(img22);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);

	}
}