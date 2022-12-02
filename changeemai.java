package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changeemai extends JFrame {

	private JPanel contentPane;
	public JLabel l1,l2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeemai frame = new changeemai();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void my_update(String str,String str1) {
		l1.setText(str);
		l2.setText(str1);
	}

	/**
	 * Create the frame.
	 */
	Connection con=null;
	public changeemai() throws SQLException {
		con=UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 636, 94);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel.setBounds(112, 32, 144, 52);
		panel.add(lblNewLabel);
		
		 l2 = new JLabel("");
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Tahoma", Font.BOLD, 25));
		l2.setBounds(278, 32, 231, 52);
		panel.add(l2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 519, 636, 94);
		contentPane.add(panel_1);
		
		 l1 = new JLabel("");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		l1.setBounds(255, 284, 240, 35);
		contentPane.add(l1);
		
		JLabel lblYourEmailId = new JLabel("Your Email ID is ");
		lblYourEmailId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblYourEmailId.setBounds(238, 191, 176, 35);
		contentPane.add(lblYourEmailId);
		
		JButton btnNewButton = new JButton("CHANGE EMAIL ID");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				PrepareStatement pst=con.prepareStatement("update details set Emailid=? where Emailid=?");
				chanems ce;
				try {
					ce = new chanems();
					ce.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(218, 408, 232, 35);
		contentPane.add(btnNewButton);
	}

}
