package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class pageone extends JFrame {

	private JPanel contentPane;
	private JTextField login;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageone frame = new pageone();
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
	public pageone() throws SQLException {
		con=AD.dbconnect();
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Rental Page\\shopping-cart.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.ORANGE);
		panel.setBounds(0, 0, 215, 463);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\Rental Page\\download-shopping-store-market-icon-png-11641399721chs8wj3v67.png"));
		lblNewLabel_4.setBounds(10, 130, 195, 193);
		panel.add(lblNewLabel_4);
		
		login = new JTextField();
		login.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		login.setBounds(387, 185, 157, 34);
		contentPane.add(login);
		login.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("LOGIN ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(262, 185, 115, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(262, 266, 91, 34);
		contentPane.add(lblNewLabel_1);
		
		pass = new JPasswordField();
		pass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pass.setBounds(387, 266, 157, 25);
		contentPane.add(pass);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(309, 39, 167, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\Rental Page\\icons8-online-store-30.png"));
		lblNewLabel_3.setBounds(353, 0, 71, 60);
		contentPane.add(lblNewLabel_3);
		
		JButton log = new JButton("LOGIN");
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String log=login.getText();
				String passw=pass.getText();
				try {
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from bankdata where Emailid=? and Password=?");
					pst.setString(1,log);
					pst.setString(2, passw);
					ResultSet r=pst.executeQuery();
					if(r.next()) {
						JOptionPane.showMessageDialog(null,"Login Sucessfull");
						pageopointo pt=new pageopointo();
						pt.setVisible(true);
						dispose();
					}else {
						JOptionPane.showMessageDialog(null,"Either Email ID or Password is incorrect");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		log.setFont(new Font("Tahoma", Font.BOLD, 15));
		log.setBackground(Color.BLACK);
		log.setForeground(Color.WHITE);
		log.setBounds(292, 363, 103, 34);
		contentPane.add(log);
		
		JButton btnClose = new JButton("CLEAR");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setText("");
				pass.setText("");
			}
		});
		btnClose.setForeground(Color.WHITE);
		btnClose.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose.setBackground(Color.BLACK);
		btnClose.setBounds(440, 363, 104, 34);
		contentPane.add(btnClose);
		
		JButton btnClose_1 = new JButton("CLOSE");
		btnClose_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnClose_1.setForeground(Color.WHITE);
		btnClose_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose_1.setBackground(Color.BLACK);
		btnClose_1.setBounds(292, 419, 104, 34);
		contentPane.add(btnClose_1);
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp=new JOptionPane();
				int i=jp.showConfirmDialog(null,"Are you Sure You want to exit");
				if(i==0) {
				dispose();
				}
			}
		});
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(Color.ORANGE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(537, 0, 49, 60);
		contentPane.add(btnNewButton_1);
		
		JButton btnClose_1_1 = new JButton("BACK");
		btnClose_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagezero pz=new pagezero();
				pz.setVisible(true);
				dispose();
			}
		});
		btnClose_1_1.setForeground(Color.WHITE);
		btnClose_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnClose_1_1.setBackground(Color.RED);
		btnClose_1_1.setBounds(440, 419, 104, 34);
		contentPane.add(btnClose_1_1);
	}
}
