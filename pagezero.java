package pack9;
import pack2.notepad;  

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class pagezero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagezero frame = new pagezero();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public pagezero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 100, 0));
		panel.setBounds(0, 0, 636, 79);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PIZZA ORDERING SYSTEM");
		lblNewLabel_1.setBounds(120, 21, 506, 37);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 100, 0));
		panel_1.setBounds(0, 534, 636, 79);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("PIZZA ORDERING SYSTEM");
		lblNewLabel_1_1.setBounds(135, 21, 476, 37);
		panel_1.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnNewButton = new JButton("ADMIN LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pageone po=new pageone();
					po.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(59, 277, 193, 55);
		contentPane.add(btnNewButton);
		
		JButton btnUserLogin = new JButton("USER LOGIN");
		btnUserLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		});
		btnUserLogin.setForeground(Color.WHITE);
		btnUserLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUserLogin.setBackground(Color.BLUE);
		btnUserLogin.setBounds(342, 277, 193, 55);
		contentPane.add(btnUserLogin);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\Rental Page\\hi.gif"));
		lblNewLabel.setBounds(250, 89, 185, 154);
		contentPane.add(lblNewLabel);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnExit.setBackground(Color.RED);
		btnExit.setBounds(216, 415, 193, 55);
		contentPane.add(btnExit);
	}
}
