package pack9;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class foremai extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					foremai frame = new foremai();
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
	private JTextField mob;
	private JTextField las;
	private JTextField fir;
	public foremai() throws SQLException {
		con=UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		mob = new JTextField();
		mob.setColumns(10);
		mob.setBounds(295, 338, 200, 34);
		contentPane.add(mob);
		
		JLabel lblNewLabel_1 = new JLabel("MOBILE No.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(118, 338, 128, 34);
		contentPane.add(lblNewLabel_1);
		
		las = new JTextField();
		las.setColumns(10);
		las.setBounds(295, 260, 200, 34);
		contentPane.add(las);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(118, 260, 128, 34);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(118, 182, 128, 34);
		contentPane.add(lblNewLabel);
		
		fir = new JTextField();
		fir.setColumns(10);
		fir.setBounds(295, 182, 200, 34);
		contentPane.add(fir);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 636, 78);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("ENTER YOUR DETAILS");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2.setBounds(102, 10, 427, 58);
		panel.add(lblNewLabel_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 535, 636, 78);
		contentPane.add(panel_1);
		
		JButton verify = new JButton("VERIFY");
		verify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from details where FirstName=? and LastName=? and Mobile=?");
					pst.setString(1, fir.getText());
					pst.setString(2, las.getText());
					pst.setString(3,mob.getText());
					
					ResultSet rst=pst.executeQuery();
//					String nam=rst.getString("Emailid");
					if(rst.next()) {
						changeemai ce=new changeemai();
						ce.my_update(rst.getString("Emailid"),(rst.getString("FirstName")+" "+rst.getString("LastName")));
						ce.setVisible(true);
						dispose();
					}else {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"Details Mismatch");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		verify.setForeground(Color.WHITE);
		verify.setFont(new Font("Tahoma", Font.BOLD, 15));
		verify.setBackground(Color.BLUE);
		verify.setBounds(118, 424, 162, 34);
		contentPane.add(verify);
		
		JButton login = new JButton("BACK TO LOGIN");
		login.addActionListener(new ActionListener() {
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
		login.setForeground(Color.WHITE);
		login.setFont(new Font("Tahoma", Font.BOLD, 15));
		login.setBackground(Color.BLUE);
		login.setBounds(342, 424, 177, 34);
		contentPane.add(login);
	}
}
