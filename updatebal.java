package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class updatebal extends JFrame {

	private JPanel add;
	private JTextField bal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updatebal frame = new updatebal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	JLabel l1;
	String nam=null;
	public void my_update(String str) {
		l1.setText(str);
		nam=str;
	}
	
	/**
	 * Create the frame.
	 */
	PreparedStatement pst,pst1;
	int bali=0;
//	ResultSet rst1;
	Connection con=null;
	public updatebal() throws SQLException {
	
		con=UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		add = new JPanel();
		add.setBackground(Color.WHITE);
		add.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(add);
		add.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UPDATE BALANCE OF");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(48, 0, 217, 66);
		add.add(lblNewLabel);
		
		bal = new JTextField();
		bal.setFont(new Font("Tahoma", Font.BOLD, 20));
		bal.setBounds(93, 134, 228, 37);
		add.add(bal);
		bal.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD BALANCE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pst1=(PreparedStatement) con.prepareStatement("select * from details where Emailid=?");
					 pst1.setString(1, nam);
					  ResultSet rst1=pst1.executeQuery();
					  while(rst1.next()) {
						  bali=rst1.getInt("Balance");
					  }
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					 
					 bali=Integer.parseInt(bal.getText())+bali;
					 pst=(PreparedStatement) con.prepareStatement("update details set Balance=? where Emailid=?");
					pst.setInt(1, bali);
					pst.setString(2, nam);
					int rst=pst.executeUpdate();
					if(rst==1) {
						JOptionPane jp=new JOptionPane();
						int i=jp.showConfirmDialog(null,"Are you sure you want to add balance to customer's account");
						if(i==0) {
							jp.showMessageDialog(null,"Balance updated sucessfully");
							pageopointo po=new pageopointo();
							po.setVisible(true);
							dispose();
						}else if(i==1) {
							cutbal cb=new cutbal();
							cb.setVisible(true);
							dispose();
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(144, 243, 134, 37);
		add.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 436, 66);
		add.add(panel);
		panel.setLayout(null);
		
		 l1 = new JLabel("");
		l1.setForeground(Color.WHITE);
		l1.setBounds(269, 0, 157, 66);
		panel.add(l1);
		l1.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 347, 436, 66);
		add.add(panel_1);
	}

}
