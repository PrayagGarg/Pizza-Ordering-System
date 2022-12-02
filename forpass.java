package pack9;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class forpass extends JFrame {

	private JPanel contentPane;
	private JTextField fir;
	private JTextField las;
	public JTextField ema;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					forpass frame = new forpass();
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
	public forpass() throws SQLException {
		con=(Connection) UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 636, 78);
		contentPane.add(panel);
		panel.setLayout(null);
		
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
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(58, 125, 128, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(58, 203, 128, 34);
		contentPane.add(lblLastName);
		
		JLabel lblNewLabel_1 = new JLabel("EMAIL ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1.setBounds(58, 281, 128, 34);
		contentPane.add(lblNewLabel_1);
		
		fir = new JTextField();
		fir.setBounds(235, 125, 200, 34);
		contentPane.add(fir);
		fir.setColumns(10);
		
		las = new JTextField();
		las.setColumns(10);
		las.setBounds(235, 203, 200, 34);
		contentPane.add(las);
		
		ema = new JTextField();
		ema.setColumns(10);
		ema.setBounds(235, 281, 200, 34);
		contentPane.add(ema);
		
		JButton btnNewButton = new JButton("VERIFY");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("select * from details where FirstName=? and LastName=? and Emailid=?");
					pst.setString(1,fir.getText());
					pst.setString(2,las.getText());
					pst.setString(3,ema.getText());
					ResultSet rst=pst.executeQuery();
					if(rst.next()) {
						changepass np=new changepass();
						np.my_update(ema.getText());
						np.setVisible(true);
						dispose();
					}else {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"Please enter the correct details");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(117, 383, 162, 34);
		contentPane.add(btnNewButton);
		
		JButton btnBackToLogin = new JButton("BACK TO LOGIN");
		btnBackToLogin.addActionListener(new ActionListener() {
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
		btnBackToLogin.setForeground(Color.WHITE);
		btnBackToLogin.setBackground(Color.BLUE);
		btnBackToLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBackToLogin.setBounds(341, 383, 177, 34);
		contentPane.add(btnBackToLogin);
	}
	public String pass() {
		String email=ema.getText();
//		System.out.println(email);
		return email;
	}

}
