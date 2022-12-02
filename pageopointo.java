package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pack8.pagetwo;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class pageopointo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pageopointo frame = new pageopointo();
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
	public pageopointo() {
		setForeground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 650);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 636, 81);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 532, 636, 81);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("TOTAL ORDER PLACED");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					orderplaced pt=new orderplaced();
					pt.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnNewButton.setBounds(70, 128, 487, 50);
		contentPane.add(btnNewButton);
		
		JButton btnManageProduct = new JButton("CUSTOMER DETAILS");
		btnManageProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cutbal cb;
				try {
					cb = new cutbal();
					cb.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		});
		btnManageProduct.setForeground(Color.WHITE);
		btnManageProduct.setFont(new Font("Tahoma", Font.BOLD, 31));
		btnManageProduct.setBackground(Color.GREEN);
		btnManageProduct.setBounds(70, 209, 487, 50);
		contentPane.add(btnManageProduct);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane jp=new JOptionPane();
				int i=jp.showConfirmDialog(null,"Are you sure you want to logout");
				if(i==0) {
					try {
						pageone po=new pageone();
						po.setVisible(true);
						dispose();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			}
		});
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 31));
		btnLogOut.setBackground(Color.RED);
		btnLogOut.setBounds(185, 388, 241, 50);
		contentPane.add(btnLogOut);
		
		JButton customer = new JButton("MANAGE CUSTOMER ACCOUNT");
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pagetwopoint pt;
				
				try {
					pt = new pagetwopoint();
					pt.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		customer.setForeground(Color.WHITE);
		customer.setFont(new Font("Tahoma", Font.BOLD, 27));
		customer.setBackground(Color.GREEN);
		customer.setBounds(70, 297, 487, 50);
		contentPane.add(customer);
	}
}
