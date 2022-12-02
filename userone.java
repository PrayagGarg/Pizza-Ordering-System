package pack9;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class userone extends JFrame {

	private JPanel contentPane;
	private JTextField logi;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userone frame = new userone();
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
	int bal;
	Connection con=null;
	public userone() throws SQLException {
		con=(Connection) UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 636, 109);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(222, 38, 188, 34);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon("D:\\Rental Page\\hiw.gif"));
		lblNewLabel_2_2.setBounds(500, 10, 126, 89);
		panel.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setIcon(new ImageIcon("D:\\Rental Page\\hiw.gif"));
		lblNewLabel_2_3.setBounds(10, 10, 126, 89);
		panel.add(lblNewLabel_2_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 504, 636, 109);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\Rental Page\\hiw.gif"));
		lblNewLabel_2.setBounds(10, 10, 126, 89);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon("D:\\Rental Page\\hiw.gif"));
		lblNewLabel_2_1.setBounds(485, 10, 126, 89);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("LOGIN ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(119, 148, 115, 31);
		contentPane.add(lblNewLabel_1);
		
		logi = new JTextField();
		logi.setColumns(10);
		logi.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		logi.setBounds(281, 148, 157, 34);
		contentPane.add(logi);
		
		JLabel lblNewLabel_1_1 = new JLabel("PASSWORD");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(118, 229, 129, 34);
		contentPane.add(lblNewLabel_1_1);
		
		pass = new JPasswordField();
		pass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pass.setBounds(281, 229, 157, 34);
		contentPane.add(pass);
		
		JButton log = new JButton("LOGIN");
		log.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from details where Emailid=? and Password=?");
				pst.setString(1,logi.getText());
				pst.setString(2,pass.getText());
				ResultSet rst=pst.executeQuery();
				if(rst.next()) {
					bal=rst.getInt("Balance");
					
					JOptionPane jp=new JOptionPane();
					jp.showMessageDialog(null,"Login Sucessfull");
					browsemen hp=new browsemen();
					hp.my_update(bal,logi.getText());
					hp.setVisible(true);
					dispose();
				}else {
					JOptionPane jp=new JOptionPane();
					jp.showMessageDialog(null,"Wrong Login ID or Password");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		});
		log.setForeground(Color.WHITE);
		log.setFont(new Font("Tahoma", Font.BOLD, 15));
		log.setBackground(Color.BLUE);
		log.setBounds(172, 322, 151, 34);
		contentPane.add(log);
		
		JButton btnNewUser = new JButton("NEW USER");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userreg ur;
				try {
					ur = new userreg();
					ur.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnNewUser.setForeground(Color.WHITE);
		btnNewUser.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewUser.setBackground(Color.BLUE);
		btnNewUser.setBounds(387, 322, 171, 34);
		contentPane.add(btnNewUser);
		
		JButton btnNewButton = new JButton("FORGOT PASSWORD");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				forpass fp;
				try {
					fp = new forpass();
					fp.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(267, 384, 157, 31);
		contentPane.add(btnNewButton);
		
		JButton btnForgotLoginId = new JButton("FORGOT LOGIN ID");
		btnForgotLoginId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				foremai fe;
				try {
					fe = new foremai();
					fe.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnForgotLoginId.setForeground(Color.BLUE);
		btnForgotLoginId.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnForgotLoginId.setBorder(null);
		btnForgotLoginId.setBackground(Color.WHITE);
		btnForgotLoginId.setBounds(267, 425, 157, 31);
		contentPane.add(btnForgotLoginId);
		
		JButton btnBack = new JButton("BACK");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagezero pz=new pagezero();
				pz.setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(Color.RED);
		btnBack.setBounds(273, 466, 151, 34);
		contentPane.add(btnBack);
	}
}
