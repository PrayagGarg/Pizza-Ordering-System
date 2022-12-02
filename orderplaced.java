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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

public class orderplaced extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	PreparedStatement pst;
	ResultSet rst;
	Connection con=null;
	JLabel tot;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					orderplaced frame = new orderplaced();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void tableload() {
		try {
			pst=(PreparedStatement) con.prepareStatement("select * from invoice");
			rst=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public orderplaced() throws SQLException {
		con=(Connection) UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650,650);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tot = new JLabel("");
		tot.setFont(new Font("Tahoma", Font.BOLD, 15));
		tot.setBounds(527, 576, 99, 27);
		contentPane.add(tot);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 55, 577, 473);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "EMAIL ID", "Amount", "Pizza"
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(126);
		table.getColumnModel().getColumn(2).setPreferredWidth(109);
		table.getColumnModel().getColumn(3).setPreferredWidth(130);
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("SHOW ORDERS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableload();
				
				int sum=0;
				for(int a=0;a<table.getRowCount();a++) {
					sum=sum+Integer.parseInt(table.getValueAt(a,2).toString());
				}
				String s=Integer.toString(sum);
				tot.setText(s);
				
			}
		});
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(179, 558, 258, 45);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 0));
		panel.setBounds(0, 0, 636, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ORDERS PLACED BY CUSTOMERS");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(73, 10, 553, 37);
		panel.add(lblNewLabel_1);
		
		
		
		JLabel lblNewLabel = new JLabel("TOTAL EARNING");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(498, 538, 138, 31);
		contentPane.add(lblNewLabel);
	}
}
