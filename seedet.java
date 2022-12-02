package pack9;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class seedet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					seedet frame = new seedet();
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
	String nam,fnam,lnam,mbnn,nam1=null;
	public void my_update(String str) {
		nam1=str;
	}
	public void myupdate(String str,String fname,String lname,String mbn) {
		nam=str;
		fnam=fname;
		lnam=lname;
		mbnn=mbn;
	}
	
	Connection con=null;
	public seedet() throws SQLException {
		con=UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("SEE DETAILS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				edetails ed=new edetails();
				ed.myupdate(nam, fnam,lnam, mbnn);
				ed.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(10, 83, 198, 53);
		contentPane.add(btnNewButton);
		
		JButton btnAddBalance = new JButton("ADD BALANCE");
		btnAddBalance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updatebal ub=new updatebal();
					ub.setVisible(true);
					ub.my_update(nam1);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnAddBalance.setForeground(Color.WHITE);
		btnAddBalance.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddBalance.setBackground(Color.RED);
		btnAddBalance.setBounds(233, 83, 193, 53);
		contentPane.add(btnAddBalance);
		
		JButton btnHome = new JButton("HOME");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageopointo po=new pageopointo();
				po.setVisible(true);
				dispose();
			}
		});
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnHome.setBackground(Color.RED);
		btnHome.setBounds(137, 146, 161, 53);
		contentPane.add(btnHome);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 436, 38);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 225, 436, 38);
		contentPane.add(panel_1);
	}

}
