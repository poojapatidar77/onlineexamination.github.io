import java.awt.*;
import java.sql.*;
import javax.swing.*;
class SubmitResult extends JPanel
{
	JLabel Lb1,Lb2,Lb3,Lb4,Lb5,Lb6,Lb7,Lb8,Lb9 ,Lb10,Lb12,Lb13,Lb14;
	Font f1;
	JButton b2;
	ImageIcon img1,img2,img3;
SubmitResult(Fdemo f)
{
      setLayout(null);
	
    	f1=new Font("",Font.BOLD,30);
		
		 Lb1=new JLabel("Result");
	      Lb1.setForeground(Color.white);
		 Lb1.setFont(f1);
		 Lb1.setBounds(500,30,400,50);
		 add(Lb1);
		 
		 
		 
    	f1=new Font("",Font.BOLD,20);
		 b2=new JButton("Next");
		b2.setFont(f1);
		b2.setBounds(1030,650,100,40);
		add(b2);
		b2.addActionListener(f);
		
    	f1=new Font("",Font.BOLD,25);
	
         Lb2=new JLabel();
	      Lb2.setForeground(Color.white);
		 Lb2.setFont(f1);
		 Lb2.setBounds(200,150,500,40);
		 add(Lb2);
			    	
    
         Lb3=new JLabel("Time taken : ");
	      Lb3.setForeground(Color.white);
		 Lb3.setFont(f1);
		 Lb3.setBounds(200,210,500,40);
		 add(Lb3);
			    	
    
         Lb4=new JLabel("Total question : ");
	      Lb4.setForeground(Color.white);
		 Lb4.setFont(f1);
		 Lb4.setBounds(200,270,500,40);
		 add(Lb4);
			    	
         Lb5=new JLabel("Attempted question : ");
	      Lb5.setForeground(Color.white);
		 Lb5.setFont(f1);
		 Lb5.setBounds(200,330,500,40);
		 add(Lb5);
			    	
    
         Lb6=new JLabel("Correct question : ");
	      Lb6.setForeground(Color.white);
		 Lb6.setFont(f1);
		 Lb6.setBounds(200,390,500,40);
		 add(Lb6);
			    	
    
    
         Lb7=new JLabel("Wrong question : ");
	      Lb7.setForeground(Color.white);
		 Lb7.setFont(f1);
		 Lb7.setBounds(200,450,500,40);
		 add(Lb7);
			    	
    
         Lb8=new JLabel("Marks obtained : ");
	      Lb8.setForeground(Color.white);
		 Lb8.setFont(f1);
		 Lb8.setBounds(200,510,500,40);
		 add(Lb8);
			    	
         Lb9=new JLabel("Total Marks : ");
	      Lb9.setForeground(Color.white);
		 Lb9.setFont(f1);
		 Lb9.setBounds(200,570,500,40);
		 add(Lb9);
			    	
    
			    	
         Lb10=new JLabel("Percentage : ");
	      Lb10.setForeground(Color.white);
		 Lb10.setFont(f1);
		 Lb10.setBounds(200,630,500,40);
		 add(Lb10);
			    	
    
		
}

void show(int student_id,String student_user_name,String course,String time1,int total_question,int attempt_question,
int correct_question,int wrong_ans,int marks_obtain,int total_marks,float percentage)
{
         Lb2.setText("Course name :              " +course);	
         Lb3.setText("Time taken :                 " +time1);	
         Lb4.setText("Total question :                 " +total_question);	
         Lb5.setText("Attempted question :         " +attempt_question);	
         Lb6.setText("Corrected question :         " +correct_question);	
         Lb7.setText("Wrong question :               " +wrong_ans);	
         Lb8.setText("Marks obtained :               " +marks_obtain);	
         Lb9.setText("Total Marks :                     " +total_marks);	
         Lb10.setText("Percentage :                  " +percentage);	




        img3=new ImageIcon("newresult2.png");
		 Lb14=new JLabel(img3);
		 Lb14.setBounds(630,380,279,279);
		 add(Lb14);
			

        img1=new ImageIcon("blackboard.jpg");
		 Lb13=new JLabel(img1);
		 Lb13.setBounds(100,100,900,600);
		 add(Lb13);
			

	  img2=new ImageIcon("bk1.png");
		 Lb12=new JLabel(img2);
		 Lb12.setBounds(0,0,1200,800);
		 add(Lb12);
}
}