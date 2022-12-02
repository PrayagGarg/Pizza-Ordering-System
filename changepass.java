package pack9;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class changepass extends JFrame {

	private JPanel contentPane;
	public String nam;
	public JLabel l1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changepass frame = new changepass();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */

//	forpass fp=new forpass();
//	String conema=fp.pass();

	
	public void my_update(String str) {
		l1.setText(str);
		 nam=str;
	}
	
	
	Connection con=null;
	forpass fp=new forpass();
	private JTextField pass;
	private JPasswordField cpass;
	public changepass() throws SQLException  {
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
		panel.setBounds(0, 0, 636, 95);
		contentPane.add(panel);
		panel.setLayout(null);
		
		 l1 = new JLabel("");
		 l1.setForeground(Color.WHITE);
		l1.setFont(new Font("Tahoma", Font.BOLD, 25));
		l1.setBounds(287, 28, 237, 39);
		panel.add(l1);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setForeground(Color.WHITE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcome.setBounds(83, 28, 182, 39);
		panel.add(lblWelcome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 518, 636, 95);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("Enter Password");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(101, 170, 190, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(101, 283, 190, 37);
		contentPane.add(lblConfirmPassword);
		
		pass = new JTextField();
		pass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		pass.setBounds(319, 170, 199, 37);
		contentPane.add(pass);
		pass.setColumns(10);
		
		cpass = new JPasswordField();
		cpass.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		cpass.setBounds(319, 283, 199, 37);
		contentPane.add(cpass);
		
		JButton btnNewButton = new JButton("CONFIRM");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pass.getText().equals(cpass.getText())) {
				try {
					System.out.println(nam);
					PreparedStatement pst =(PreparedStatement) con.prepareStatement("update details set Password=? where Emailid=?");
					pst.setString(1,pass.getText());
					pst.setString(2, nam);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Data Update Sucessfully");

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}else {
					JOptionPane jp=new JOptionPane();
					jp.showMessageDialog(null,"Enter Password and Confirm Password mismatch");
				}
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(80, 386, 199, 54);
		contentPane.add(btnNewButton);
		
		JButton btnConfirm = new JButton("BACK TO LOGIN");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					userone uo=new userone();
					uo.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnConfirm.setForeground(Color.WHITE);
		btnConfirm.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnConfirm.setBackground(Color.RED);
		btnConfirm.setBounds(330, 386, 220, 54);
		contentPane.add(btnConfirm);
		
	}
	
}
