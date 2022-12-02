package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.ScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.mysql.jdbc.PreparedStatement;

import net.proteanit.sql.DbUtils;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class pagetwopoint extends JFrame {

	private JPanel contentPane;
	private JTextField des;
	private JTextField qua;
	private JTextField nam;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pagetwopoint frame = new pagetwopoint();
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
	PreparedStatement pst;
	ResultSet rst;
	private JTable table;
	private JTextField sea;
	
	public void tableload() {
		try {
			pst=(PreparedStatement) con.prepareStatement("select * from details");
			rst=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rst));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public pagetwopoint() throws SQLException {
		con=UR.dbconnect();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1150, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 1136, 93);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("PIZZA ORDERING SYSTEM");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(328, 25, 594, 37);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUSTOMER DETAILS");
		lblNewLabel_2.setBounds(448, 67, 230, 26);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JButton btnNewButton_1 = new JButton("X");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp=new JOptionPane();
				int i=jp.showConfirmDialog(null,"Are You sure You want to exit");
				if(i==0) {
					dispose();
				}
			}
		});
		
		sea = new JTextField();
		sea.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id=sea.getText();
				try {
					pst=(PreparedStatement) con.prepareStatement("select FirstName,LastName,Emailid from details where id= ?");
					pst.setString(1, id);
					rst=pst.executeQuery();
					if(rst.next()==true) {
						String Category=rst.getString(4);
						nam.setText(rst.getString(1));
						qua.setText(rst.getString(2));
						des.setText(rst.getString(3));
//						cat.setSelectedItem(Category);
					
					}else {
						nam.setText("");
						qua.setText("");
						des.setText("");
//						cat.setSelectedIndex(0);
					}
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setBounds(1087, 0, 49, 60);
		panel.add(btnNewButton_1);
		
		JLabel lblName = new JLabel("FIRST NAME");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(21, 149, 114, 26);
		contentPane.add(lblName);
		
		JLabel lblQuantity = new JLabel("Last Name");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblQuantity.setBounds(21, 222, 114, 26);
		contentPane.add(lblQuantity);
		
		JLabel lblDescription = new JLabel("EMAIL ID");
		lblDescription.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDescription.setBounds(21, 300, 114, 26);
		contentPane.add(lblDescription);
		
		des = new JTextField();
		des.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		des.setBounds(175, 299, 139, 26);
		contentPane.add(des);
		des.setColumns(10);
		
		qua = new JTextField();
		qua.setColumns(10);
		qua.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		qua.setBounds(175, 222, 139, 26);
		contentPane.add(qua);
		
		nam = new JTextField();
		nam.setColumns(10);
		nam.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		nam.setBounds(175, 149, 139, 26);
		contentPane.add(nam);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(453, 103, 658, 505);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index=table.getSelectedRow();
				TableModel model=table.getModel();
				String v2=(model.getValueAt(index,1).toString());
				String v3=(model.getValueAt(index,2).toString());
				String v4=(model.getValueAt(index,3).toString());
				String v5=(model.getValueAt(index,4).toString());
				nam.setText(v2);
				qua.setText(v3);
				des.setText(v4);
//				cat.setSelectedItem(v5);
			}
		});
		scrollPane.setViewportView(table);
		
//		JButton add = new JButton("ADD");
//		add.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(nam.getText().length()<=0 || qua.getText().length()<=0 || des.getText().length()<=0 ) {
//					JOptionPane jp=new JOptionPane();
//					jp.showMessageDialog(null, "Please Fill all the fields");
//				}else {
//				
//				try {
//					pst=(PreparedStatement) con.prepareStatement("insert into product(Name,Quantity,Description,Category) values(?,?,?,?)");
//					pst.setString(1, nam.getText());
//					pst.setString(2,qua.getText());
//					pst.setString(3, des.getText());
////					pst.setString(4,(String) cat.getSelectedItem());
//					pst.executeUpdate();
//					tableload();
//					nam.setText("");
//					qua.setText("");
//					des.setText("");
////					cat.setSelectedIndex(0);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//			}
//		});
//		add.setForeground(Color.WHITE);
//		add.setFont(new Font("Tahoma", Font.BOLD, 15));
//		add.setBackground(Color.BLACK);
//		add.setBounds(89, 442, 103, 34);
//		contentPane.add(add);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String s=sea.getText();
				try {
					pst=(PreparedStatement) con.prepareStatement("delete from details where id=?");
					pst.setString(1, s);
					JOptionPane jp=new JOptionPane();
					int i=jp.showConfirmDialog(null,"Are you sure you want to delete the item");
					if(i==0) {
					pst.executeUpdate();
					tableload();
					nam.setText("");
					qua.setText("");
					des.setText("");
//					cat.setSelectedIndex(0);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		delete.setForeground(Color.WHITE);
		delete.setFont(new Font("Tahoma", Font.BOLD, 15));
		delete.setBackground(Color.BLACK);
		delete.setBounds(70, 595, 212, 34);
		contentPane.add(delete);
		
		JButton home = new JButton("HOME");
		home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp=new JOptionPane();
				int i=jp.showConfirmDialog(null,"You want to go to homepage");
				if(i==0) {
					pageopointo po;
					po = new pageopointo();
					po.setVisible(true);
					dispose();
					
				}
			}
		});
		home.setForeground(Color.WHITE);
		home.setFont(new Font("Tahoma", Font.BOLD, 15));
		home.setBackground(Color.BLACK);
		home.setBounds(144, 379, 104, 34);
		contentPane.add(home);
		
//		JButton edit = new JButton("EDIT");
//		edit.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String s=sea.getText();
//				try {
//					pst=(PreparedStatement) con.prepareStatement("update details set FirstName=?,LastName=?,Emailid=? where id=?");
//					pst.setString(1, nam.getText());
//					pst.setString(2,qua.getText());
//					pst.setString(3, des.getText());
////					pst.setString(4,(String) cat.getSelectedItem());
//					pst.setString(4,s);
//					pst.executeUpdate();
//					tableload();
//					nam.setText("");
//					qua.setText("");
//					des.setText("");
////					cat.setSelectedIndex(0);
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//			}
//		});
//		edit.setForeground(Color.WHITE);
//		edit.setFont(new Font("Tahoma", Font.BOLD, 15));
//		edit.setBackground(Color.BLACK);
//		edit.setBounds(67, 594, 104, 34);
//		contentPane.add(edit);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 676, 1136, 37);
		contentPane.add(panel_1);
		
		
		sea.setColumns(10);
		sea.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		sea.setBounds(175, 535, 139, 26);
		contentPane.add(sea);
		
		JLabel lblNewLabel = new JLabel("Delete By ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 532, 125, 26);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("SHOW TABLE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableload();
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(642, 631, 197, 35);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageopointo po=new pageopointo();
				po.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBackground(Color.RED);
		btnNewButton_2.setBounds(100, 632, 148, 34);
		contentPane.add(btnNewButton_2);
		
		
		
		
	}
}
