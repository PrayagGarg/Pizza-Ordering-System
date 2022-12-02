package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class chanems extends JFrame {

	private JPanel newe;
	private JTextField old;
	private JTextField emailnew;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					chanems frame = new chanems();
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
	public chanems() throws SQLException {
		con=UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		newe = new JPanel();
		newe.setBackground(Color.WHITE);
		newe.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(newe);
		newe.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 0, 636, 96);
		newe.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLUE);
		panel_1.setBounds(0, 517, 636, 96);
		newe.add(panel_1);
		
		old = new JTextField();
		old.setBounds(237, 167, 277, 43);
		newe.add(old);
		old.setColumns(10);
		
		emailnew = new JTextField();
		emailnew.setColumns(10);
		emailnew.setBounds(237, 294, 277, 43);
		newe.add(emailnew);
		
		JLabel lblNewLabel = new JLabel("OLD EMAIL ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(48, 167, 160, 50);
		newe.add(lblNewLabel);
		
		JLabel lblNewEmailId = new JLabel("NEW EMAIL ID");
		lblNewEmailId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewEmailId.setBounds(48, 294, 160, 50);
		newe.add(lblNewEmailId);
		
		JButton submit = new JButton("SUBMIT");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(emailnew.getText().length()<=0 || old.getText().length()<=0) {
					JOptionPane jp=new JOptionPane();
					jp.showMessageDialog(null,"Please fill all the Fields carefully");
				}else {
				try {
					PreparedStatement pst=(PreparedStatement) con.prepareStatement("update details set Emailid=? where Emailid=?");
					pst.setString(1,emailnew.getText());
					pst.setString(2,old.getText());
					int i=pst.executeUpdate();
					System.out.println(i);
					if(i==0) {
						JOptionPane jp=new JOptionPane();
						int j=jp.showConfirmDialog(null,"Are you sure you want to update your Emai ID");
						if(j==0) {
							jp.showMessageDialog(null,"Email Updated Sucessfully");
							userone uo=new userone();
							uo.setVisible(true);
							dispose();
						}else if(j==1) {
							changeemai ce=new changeemai();
							ce.setVisible(true);
							dispose();
						}
					}else {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"Failed to update Email ID");
						changeemai ce=new changeemai();
						ce.setVisible(true);
						dispose();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		submit.setBackground(Color.RED);
		submit.setForeground(Color.WHITE);
		submit.setFont(new Font("Tahoma", Font.BOLD, 20));
		submit.setBounds(237, 395, 160, 43);
		newe.add(submit);
	}
}
