package pack9;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class edetails extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	JLabel l1,l2,l3,l4;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					edetails frame = new edetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	String nam,fnamee,lnamee,mbne;
	public void myupdate(String str,String fname,String lname,String mbn) {
//		l1.setText(str);
		nam=str;
		fnamee=fname;
		lnamee=lname;
		mbne=mbn;
		l1.setText(fnamee);
		l2.setText(lnamee);
		l3.setText(nam);
		l4.setText(mbne);
	}

	/**
	 * Create the frame.
	 */
	public edetails() {
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);
		panel.setBounds(0, 0, 536, 55);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GREEN);
		panel_1.setBounds(0, 458, 536, 55);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("FIRST NAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(72, 123, 102, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("LAST NAME");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLastName.setBounds(72, 200, 102, 38);
		contentPane.add(lblLastName);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEmailId.setBounds(72, 276, 102, 38);
		contentPane.add(lblEmailId);
		
		JLabel lblMobileNo = new JLabel("MOBILE NO.");
		lblMobileNo.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMobileNo.setBounds(72, 361, 102, 38);
		contentPane.add(lblMobileNo);
		
		 l1 = new JLabel("");
		 l1.setForeground(Color.RED);
		 l1.setFont(new Font("Tahoma", Font.BOLD, 15));
		l1.setBounds(195, 123, 188, 32);
		contentPane.add(l1);
		
		l2 = new JLabel("");
		l2.setForeground(Color.RED);
		l2.setFont(new Font("Tahoma", Font.BOLD, 15));
		l2.setBounds(195, 200, 188, 32);
		contentPane.add(l2);
		
		l3 = new JLabel("");
		l3.setForeground(Color.RED);
		l3.setFont(new Font("Tahoma", Font.BOLD, 15));
		l3.setBounds(195, 276, 188, 32);
		contentPane.add(l3);
		
		l4 = new JLabel("");
		l4.setForeground(Color.RED);
		l4.setFont(new Font("Tahoma", Font.BOLD, 15));
		l4.setBounds(184, 361, 188, 32);
		contentPane.add(l4);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pageopointo po=new pageopointo();
				po.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(205, 403, 111, 45);
		contentPane.add(btnNewButton);
	}

}
