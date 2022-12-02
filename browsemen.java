package pack9;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pack2.notepad;
import pack4.*;

public class browsemen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					browsemen frame = new browsemen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	int balan;
	String email;
	public void my_update(int str,String str1) {
		//	l1.setText(str);
			balan=str;
			email=str1;
		}

	/**
	 * Create the frame.
	 */
	public browsemen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 0));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("USE NOTEPAD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				notepad np=new notepad();
				np.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 102, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(104, 132, 323, 53);
		contentPane.add(btnNewButton);
		
		JButton btnPlayZeroKata = new JButton("USE CALCULATOR");
		btnPlayZeroKata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculator zk=new calculator();
				zk.setVisible(true);
				dispose();
			}
		});
		btnPlayZeroKata.setForeground(new Color(255, 255, 255));
		btnPlayZeroKata.setBackground(new Color(0, 102, 0));
		btnPlayZeroKata.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnPlayZeroKata.setBounds(104, 313, 323, 53);
		contentPane.add(btnPlayZeroKata);
		
		JButton btnOrderPizza = new JButton("ORDER PIZZA");
		btnOrderPizza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				homepage hp;
				try {
					hp = new homepage();
					hp.my_update(balan,email);
					hp.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnOrderPizza.setForeground(new Color(255, 255, 255));
		btnOrderPizza.setBackground(new Color(0, 102, 0));
		btnOrderPizza.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnOrderPizza.setBounds(104, 38, 323, 53);
		contentPane.add(btnOrderPizza);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp=new JOptionPane();
				int i=jp.showConfirmDialog(null,"Are you sure you want to logout");
				if(i==JOptionPane.YES_OPTION) {
					userone uo;
					try {
						uo = new userone();
						uo.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(255, 0, 0));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogOut.setBounds(178, 409, 169, 38);
		contentPane.add(btnLogOut);
		
		JButton btnUseNotepad = new JButton("PLAY ZERO KATA");
		btnUseNotepad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zerokatas zk=new zerokatas();
				zk.frame.setVisible(true);
				dispose();
			}
		});
		btnUseNotepad.setForeground(Color.WHITE);
		btnUseNotepad.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnUseNotepad.setBackground(new Color(0, 102, 0));
		btnUseNotepad.setBounds(104, 219, 323, 53);
		contentPane.add(btnUseNotepad);
	}
}
