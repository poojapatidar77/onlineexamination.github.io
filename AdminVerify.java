import java.awt.*;
import javax.swing.*;
class AdminVerify extends JPanel
{
	JLabel Lb1,Lb2;
	JButton b2,b1,b3,b4;
	JComboBox Cb1;
AdminVerify(Fdemo f)
{
	   setLayout(null);
		Font f1=new Font("",Font.BOLD,30);
		
		 Lb1=new JLabel("VERIFICATION");
		 Lb1.setFont(f1);
		 Lb1.setBounds(520,70,300,50);
		 add(Lb1);
		 
		 f1=new Font("",Font.BOLD,25);
		 
		 Lb2=new JLabel("User for verification");
		 Lb2.setFont(f1);
		 Lb2.setBounds(170,370,400,50);
		 add(Lb2);
		 
		 Cb1=new JComboBox();
		 Cb1.setFont(f1);
		 Cb1.setBounds(450,370,300,50);
		 add(Cb1);
		 
		 
		 f1=new Font("",Font.BOLD,20);
		 
		 b1=new JButton("Submit");
		b1.setFont(f1);
		b1.setBounds(820,370,120,40);
		add(b1);
		b1.addActionListener(f);
		
		 b3=new JButton("Delete");
		b3.setFont(f1);
		b3.setBounds(500,570,120,40);
		add(b3);
		b3.addActionListener(f);
		
		
		 b4=new JButton("Verify");
		b4.setFont(f1);
		b4.setBounds(650,570,120,40);
		add(b4);
		b4.addActionListener(f);
		
		


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