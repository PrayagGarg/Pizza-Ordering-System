package pack9;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;
import java.awt.Font;
import javax.swing.ImageIcon;

public class invo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					invo frame = new invo();
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
	String email1;
	String amount1;
	String item1;
	String rbal1;
	DefaultTableModel model;
	public JTable table;
	PreparedStatement pst;
	ResultSet rst;
	public void my_updates(String email, String amount,String item,String rbal) {
		email1=email;
		amount1=amount;
		item1=item;
		rbal1=rbal;
	}
	
	public void tableload() {
		try {
			pst=(PreparedStatement) con.prepareStatement("select * from invoice where Emailid=?");
			pst.setString(1,email1);
			rst=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Connection con=null;
	public invo() throws SQLException {
		con=(Connection) UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 616, 438);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				 "Email ID", "Order Amount", "ITEM","Remaining Bal",
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("SEE ORDER HISTORY");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				model=(DefaultTableModel) table.getModel();
//				model.addRow(new Object[]
//						{
//								email1,amount1,item1,rbal1
//								
//						}
//						
//						);
				tableload();
			}
		});
		btnNewButton.setBounds(190, 511, 205, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("ORDER HISTORY");
		lblNewLabel.setBackground(new Color(51, 255, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(216, 0, 132, 27);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp=new JOptionPane();
				int i=jp.showConfirmDialog(null,"Are you sure you want to logout");
				if(i == JOptionPane.YES_OPTION) {
				jp.showMessageDialog(null,"Logged Out Sucessfully");
				try {
					userone uo=new userone();
					uo.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\Rental Page\\logout.jpg"));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBounds(576, 0, 60, 60);
		contentPane.add(btnNewButton_1);
		
	
		
		
		
		
	}
}
