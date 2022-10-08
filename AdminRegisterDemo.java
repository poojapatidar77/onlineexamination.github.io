import java.awt.*;
import javax.swing.*;
class AdminRegisterDemo extends JPanel
{
	JButton b2;
	AdminRegisterDemo(Fdemo f)
	{
		setLayout(null);
		Font f1=new Font("",Font.BOLD,20);
	
      
	
		b2=new JButton("Back");
		b2.setFont(f1);
		b2.setBounds(100,680,100,40);
		add(b2);
		b2.addActionListener(f);
		
	}
}