package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class cutbal extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cutbal frame = new cutbal();
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
	Connection con=null;
	public cutbal() throws SQLException {
		con=UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ENTER EMAIL ID OF CUSTOMER ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(69, 105, 301, 40);
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(243, 16, 0, 0);
		contentPane.add(table);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 436, 72);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 341, 436, 72);
		contentPane.add(panel_1);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.BOLD, 15));
		email.setBounds(69, 183, 284, 40);
		contentPane.add(email);
		email.setColumns(10);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from details where Emailid=?");
					pst.setString(1,email.getText());					
					ResultSet rst=pst.executeQuery();
					
					if(rst.next()) {
					seedet ub=new seedet();
					ub.setVisible(true);
					ub.my_update(email.getText());
					ub.myupdate(email.getText(),rst.getString(2),rst.getString(3),rst.getString(5));
					dispose();
					}else {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"No user exist by this Email ID ");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		submit.setFont(new Font("Tahoma", Font.BOLD, 20));
		submit.setBackground(Color.GREEN);
		submit.setForeground(Color.WHITE);
		submit.setBounds(142, 245, 122, 34);
		contentPane.add(submit);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageopointo po=new pageopointo();
				po.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(142, 282, 122, 34);
		contentPane.add(btnBack);
	}
}
