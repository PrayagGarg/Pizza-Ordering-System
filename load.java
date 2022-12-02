	package pack9;
	import javax.swing.*;
	import java.awt.Font;
	import java.sql.SQLException;
	import java.awt.Color;    
	public class load extends JFrame{    
	JProgressBar jb;    
	int i=0,num=0;     
	load(){
		getContentPane().setBackground(Color.WHITE);    
	jb=new JProgressBar(0,2000);    
	jb.setForeground(Color.GREEN);
	jb.setBounds(0,527,589,30);         
	jb.setValue(0);    
	jb.setStringPainted(true);    
	getContentPane().add(jb);    
	setSize(603,604);    
	getContentPane().setLayout(null);
	JLabel lblNewLabel_1 = new JLabel("");
	lblNewLabel_1.setIcon(new ImageIcon("D:\\Rental Page\\CompleteShallowFlyingsquirrel-size_restricted.gif"));
	lblNewLabel_1.setBounds(10, 59, 579, 508);
	getContentPane().add(lblNewLabel_1);
	JLabel lblNewLabel = new JLabel("APNA MARKET");
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
	lblNewLabel.setBounds(197, 10, 248, 39);
	getContentPane().add(lblNewLabel);
	}    
	
	public void iterate() throws SQLException{    
	while(i<=1000){    
	  jb.setValue(i);    
	  i=i+2;   
	//  System.out.println(i);
	  try{Thread.sleep(3);}catch(Exception e){}  
	//  System.out.println(i);
	} 
	if(i==1002) {
		dispose();
		pagezero pg=new pagezero();
		pg.setVisible(true);
	}
	}
	
	public static void main(String[] args) throws SQLException {    
	    load m=new load();    
	    m.setVisible(true);    
	    m.iterate();    
	}    
	}    