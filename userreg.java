package pack9;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class userreg extends JFrame {

	private JPanel contentPane;
	private JTextField first;
	private JTextField last;
	private JTextField mobile;
	private JTextField email;
	private JPasswordField pass;
	private JPasswordField cpass;
	private String gen=null;
	private int c=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userreg frame = new userreg();
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
	public userreg() throws SQLException {
		ButtonGroup bg=new ButtonGroup();
		con=UR.dbconnect();
		setTitle("Registration Form");
		setBackground(SystemColor.window);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 755);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(43, 36, 115, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastName.setBounds(43, 125, 115, 37);
		contentPane.add(lblLastName);
		
		JLabel lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMobileNumber.setBounds(43, 281, 160, 37);
		contentPane.add(lblMobileNumber);
		
		JLabel lblEmailId = new JLabel("Email ID");
		lblEmailId.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblEmailId.setBounds(43, 378, 115, 37);
		contentPane.add(lblEmailId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(43, 475, 115, 37);
		contentPane.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(43, 560, 183, 37);
		contentPane.add(lblConfirmPassword);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBounds(43, 200, 115, 37);
		contentPane.add(lblGender);
		
		first = new JTextField();
		first.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		first.setBounds(280, 36, 160, 29);
		contentPane.add(first);
		first.setColumns(10);
		
		last = new JTextField();
		last.setColumns(10);
		last.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		last.setBounds(280, 125, 160, 29);
		contentPane.add(last);
		
		mobile = new JTextField();
		mobile.setColumns(10);
		mobile.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		mobile.setBounds(280, 281, 160, 29);
		contentPane.add(mobile);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		email.setBounds(280, 373, 160, 29);
		contentPane.add(email);
		
		pass = new JPasswordField();
		pass.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pass.setBounds(280, 475, 160, 29);
		contentPane.add(pass);
		
		cpass = new JPasswordField();
		cpass.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		cpass.setBounds(280, 560, 160, 29);
		contentPane.add(cpass);
		
		JRadioButton male = new JRadioButton("Male");
		male.setFont(new Font("Tahoma", Font.BOLD, 15));
		bg.add(male);
		male.setBackground(Color.WHITE);
		male.setBounds(235, 200, 116, 37);
		contentPane.add(male);
		
		JRadioButton female = new JRadioButton("Female");
		female.setFont(new Font("Tahoma", Font.BOLD, 15));
		bg.add(female);
		female.setBackground(Color.WHITE);
		female.setBounds(353, 200, 103, 37);
		contentPane.add(female);
		
		JLabel lblNewLabel_2 = new JLabel("Please Upload Image (Size less than 300px * 300px)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(613, 109, 300, 37);
		contentPane.add(lblNewLabel_2);
		JLabel labe = new JLabel("New label");
		labe.setBorder(new LineBorder(Color.GREEN, 2));
		labe.setBounds(613, 173, 300, 300);
		contentPane.add(labe);
		JFileChooser jfc=new JFileChooser();
		JButton btnNewButton = new JButton("BROWSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jfc.showOpenDialog(null);
				File file=jfc.getSelectedFile();
				labe.setIcon(new ImageIcon(file.toString()));
				labe.setHorizontalAlignment(JLabel.CENTER);
				
//				try {
//					PreparedStatement pst =con.prepareStatement("insert into details(Image) values(?)");
//					
//					try {
//						
//						
//					} catch (FileNotFoundException e1) {
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
			}
		});
		
		JButton submit = new JButton("SUBMIT");
		submit.setBorder(new LineBorder(Color.GREEN, 2));
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(first.getText().length()<=0 || last.getText().length()<=0 || email.getText().length()<=0 || mobile.getText().length()<=0 || pass.getText().length()<=0 || cpass.getText().length()<=0) {
					JOptionPane.showMessageDialog(null,"Please fill all the fields");
					
				}
				else {
					if(pass.getText().equals(cpass.getText())) {
						
						if(male.isSelected()) {
							gen="Male";
							c=1;
						}else if(female.isSelected()) {
							gen="Female";
							c=1;
						}
						if(c==1) {
							
							
							String firs=first.getText();
							String las=last.getText();
							String em=email.getText();
							String passw=pass.getText();
							String mobi=mobile.getText();
							String geni=gen;
							
							File file1=jfc.getSelectedFile();
//							labe.setIcon(new ImageIcon(file.toString()));
//							labe.setHorizontalAlignment(JLabel.CENTER);
							
							try {
								PreparedStatement pst=con.prepareStatement("insert into details(FirstName,LastName,Emailid,Mobile,Gender,Password,Image) values(?,?,?,?,?,?,?)");
								FileInputStream fls;
								try {
									fls = new FileInputStream(file1);
									pst.setString(1, firs);
									pst.setString(2, las);
									pst.setString(3, em);
									pst.setString(4, mobi);
									pst.setString(5, geni);
									pst.setString(6, passw);
									pst.setBlob(7,fls);
								} catch (FileNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							
								pst.executeUpdate();
								JOptionPane.showMessageDialog(null,"User Registered Sucessfully");
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
							
							first.setText("");
							last.setText("");
							mobile.setText("");
							email.setText("");
							pass.setText("");
							cpass.setText("");
							bg.clearSelection();
							userone lf;
							try {
								lf = new userone();
								lf.setVisible(true);
								dispose();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						
							
						}
					}else {
						JOptionPane.showMessageDialog(null,"Password Mismatch");
					}
				}
				
				
			}
		});
		submit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		submit.setForeground(Color.WHITE);
		submit.setBackground(Color.BLACK);
		submit.setBounds(269, 658, 115, 37);
		contentPane.add(submit);
		
		JButton close = new JButton("CLOSE");
		close.setBorder(new LineBorder(Color.GREEN, 2));
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userone uo;
				try {
					uo = new userone();
					uo.setVisible(true);
					dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		

		
		close.setForeground(Color.WHITE);
		close.setFont(new Font("Tahoma", Font.PLAIN, 15));
		close.setBackground(Color.BLACK);
		close.setBounds(456, 658, 104, 37);
		contentPane.add(close);

		btnNewButton.setBorder(new LineBorder(Color.GREEN, 2));
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(708, 522, 139, 37);
		contentPane.add(btnNewButton);
		
	
	}
}
