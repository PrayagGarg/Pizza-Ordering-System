package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class zerokatas {

	JFrame frame;
	private JTextField xcount;
	private JTextField ocount;
	private int xcount1=0;
	private int ocount1=0;
	private String startgame="X";
	private int b1=10;
	private int b2=10;
	private int b3=10;
	private int b4=10;
	private int b5=10;
	private int b6=10;
	private int b7=10;
	private int b8=10;
	private int b9=10;
	private int i=0;
	protected Object setvisible;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					zerokatas window = new zerokatas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public zerokatas() {
		initialize();
	}
	public void winning() {
		//for player x
		if(b1==1 && b2==1 && b3==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		else if(b4==1 && b5==1 && b6==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		else if(b7==1 && b8==1 && b9==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		else if(b1==1 && b4==1 && b7==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		else if(b2==1 && b5==1 && b8==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		else if(b3==1 && b6==1 && b9==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		else if(b7==1 && b5==1 && b3==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		else if(b9==1 && b5==1 && b1==1) {
			JOptionPane.showMessageDialog(null,"+1 for Player X.Press Reset To play again");
			xcount1++;
			xcount.setText(String.valueOf(xcount1));
		}
		//for player O
		else if(b1==0 && b2==0 && b3==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To play again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(b4==0 && b5==0 && b6==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To play again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(b7==0 && b8==0 && b9==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To play again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(b1==0 && b4==0 && b7==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To play again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(b2==0 && b5==0 && b8==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To play again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(b3==0 && b6==0 && b9==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To play again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(b7==0 && b5==0 && b3==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To play again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(b9==0 && b5==0 && b1==0) {
			JOptionPane.showMessageDialog(null,"+1 for Player O.Press Reset To plays again");
			ocount1++;
			ocount.setText(String.valueOf(ocount1));
		}
		else if(i==9) {
			JOptionPane.showMessageDialog(null,"No One Win.Press Reset To play again");
		}
	}
	private void chooseplay() {
		if(startgame=="X") {
			startgame="O";
			
		}else {
			startgame="X";
		}
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 602, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 5, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JButton btn1 = new JButton("");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText(startgame);
				if(startgame=="X") {
					btn1.setForeground(Color.red);
					b1=1;
					i++;
				}else {
					btn1.setForeground(Color.blue);
					b1=0;
					i++;
				}
				chooseplay();
				winning();
			}
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_1.add(btn1, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JButton btn2 = new JButton("");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn2.setText(startgame);
				if(startgame=="X") {
					btn2.setForeground(Color.red);
					b2=1;
					i++;
				}else {
					btn2.setForeground(Color.blue);
					b2=0;
					i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_2.add(btn2, BorderLayout.CENTER);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btn3 = new JButton("");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn3.setText(startgame);
				if(startgame=="X") {
					btn3.setForeground(Color.red);
					b3=1;
					i++;
				}else {
					btn3.setForeground(Color.blue);
					b3=0;
					i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_3.add(btn3, BorderLayout.CENTER);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_3 = new JButton("PLAYER X");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_4.add(btnNewButton_3, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		xcount = new JTextField();
		xcount.setHorizontalAlignment(SwingConstants.CENTER);
		xcount.setText("0");
		xcount.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_5.add(xcount, BorderLayout.CENTER);
		xcount.setColumns(10);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JButton btn4 = new JButton("");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn4.setText(startgame);
				if(startgame=="X") {
					btn4.setForeground(Color.red);
					b4=1;
					i++;
				}else {
					btn4.setForeground(Color.blue);
					b4=0;
					i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_9.add(btn4, BorderLayout.CENTER);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JButton btn5 = new JButton("");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn5.setText(startgame);
				if(startgame=="X") {
					btn5.setForeground(Color.red);
					b5=1;
					i++;
				}else {
					btn5.setForeground(Color.blue);
					b5=0;
					i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_8.add(btn5, BorderLayout.CENTER);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JButton btn6 = new JButton("");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn6.setText(startgame);
				if(startgame=="X") {
					btn6.setForeground(Color.red);
					b6=1;
					i++;
				}else {
					btn6.setForeground(Color.blue);
				b6=0;
				i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_10.add(btn6, BorderLayout.CENTER);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		JButton btnNewButton_6 = new JButton("PLAYER O");
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel_11.add(btnNewButton_6, BorderLayout.CENTER);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		ocount = new JTextField();
		ocount.setHorizontalAlignment(SwingConstants.CENTER);
		ocount.setText("0");
		ocount.setFont(new Font("Tahoma", Font.BOLD, 40));
		panel_7.add(ocount, BorderLayout.CENTER);
		ocount.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JButton btn7 = new JButton("");
		btn7.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn7.setText(startgame);
				if(startgame=="X") {
					btn7.setForeground(Color.red);
					b7=1;
					i++;
				}else {
					btn7.setForeground(Color.blue);
					b7=0;
					i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_6.add(btn7, BorderLayout.CENTER);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_12);
		panel_12.setLayout(new BorderLayout(0, 0));
		
		JButton btn8 = new JButton("");
		btn8.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn8.setText(startgame);
				if(startgame=="X") {
					btn8.setForeground(Color.red);
					b8=1;
					i++;
				}else {
					btn8.setForeground(Color.blue);
				b8=0;
				i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_12.add(btn8, BorderLayout.CENTER);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_13);
		panel_13.setLayout(new BorderLayout(0, 0));
		
		JButton btn9 = new JButton("");
		btn9.setFont(new Font("Tahoma", Font.BOLD, 40));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn9.setText(startgame);
				if(startgame=="X") {
					btn9.setForeground(Color.red);
					b9=1;
					i++;
				}else {
					btn9.setForeground(Color.blue);
				b9=0;
				i++;
				}
				chooseplay();
				winning();
			}
		});
		panel_13.add(btn9, BorderLayout.CENTER);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_14);
		panel_14.setLayout(new BorderLayout(0, 0));
		
		JButton reset = new JButton("RESET");
		reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn1.setText(null);
				btn2.setText(null);
				btn3.setText(null);
				btn4.setText(null);
				btn5.setText(null);
				btn6.setText(null);
				btn7.setText(null);
				btn8.setText(null);
				btn9.setText(null);
				b1=10;
				b2=10;
				b3=10;
				b4=10;
				b5=10;
				b6=10;
				b7=10;
				b8=10;
				b9=10;
				i=0;
			}
		});
		reset.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_14.add(reset, BorderLayout.CENTER);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.add(panel_15);
		panel_15.setLayout(new BorderLayout(0, 0));
		
		JButton exit = new JButton("EXIT");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame =new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm you want to exit","Zero Kata",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION)
				{
				
				System.exit(0);	
				
				}
			}
		});
		exit.setFont(new Font("Tahoma", Font.BOLD, 23));
		panel_15.add(exit, BorderLayout.CENTER);
	}

}
