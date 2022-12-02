	package pack9;
	
	import java.awt.EventQueue;
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.border.EmptyBorder;
	import java.awt.Color;
	import javax.swing.JRadioButton;
	import java.awt.Font;
	import javax.swing.JTable;
	import javax.swing.JScrollPane;
	import javax.swing.ButtonGroup;
	import javax.swing.JButton;
	import javax.swing.JLabel;
	import javax.swing.JOptionPane;
	import javax.swing.JSpinner;
	import javax.swing.JTextField;
	import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JCheckBox;
	import java.awt.event.MouseAdapter;
	import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.ImageIcon;
	
	public class homepage extends JFrame {
	
		private JPanel contentPane;
		private JTable table;
		JSpinner qty;
		JLabel balance;
		JLabel tot;
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						homepage frame = new homepage();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	int price,a,b;
	public int total;
	DefaultTableModel model;
	public String item;
	String cheese="No";
	int index=-1;
	int balan;
	String email;
		/*,name*
		 * Create the frame.
		 */
	
	public void my_update(int str,String str1) {
	//	l1.setText(str);
		balan=str;
		email=str1;
	}
	
	
	ButtonGroup G = new ButtonGroup();
	ButtonGroup G1 = new ButtonGroup();
	Connection con=null;
		public homepage() throws SQLException {
			con=UR.dbconnect();
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 900, 800);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(153, 255, 0));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			
			JRadioButton onion = new JRadioButton("ONION");
			G1.add(onion);
			onion.setFont(new Font("Tahoma", Font.BOLD, 14));
			onion.setBackground(new Color(102, 255, 51));
			onion.setBounds(14, 74, 88, 21);
			contentPane.add(onion);
			
			JRadioButton tomato = new JRadioButton("TOMATO");
			G1.add(tomato);
			tomato.setFont(new Font("Tahoma", Font.BOLD, 14));
			tomato.setBackground(new Color(102, 255, 51));
			tomato.setBounds(14, 145, 88, 21);
			contentPane.add(tomato);
			
			JRadioButton capsicum = new JRadioButton("CAPSISUM");
			G1.add(capsicum);
			capsicum.setFont(new Font("Tahoma", Font.BOLD, 13));
			capsicum.setBackground(new Color(102, 255, 51));
			capsicum.setBounds(14, 211, 103, 21);
			contentPane.add(capsicum);
			
			JRadioButton corn = new JRadioButton("CORN");
			G1.add(corn);
			corn.setFont(new Font("Tahoma", Font.BOLD, 14));
			corn.setBackground(new Color(102, 255, 51));
			corn.setBounds(14, 292, 88, 21);
			contentPane.add(corn);
			
			JRadioButton paneer = new JRadioButton("PANEER");
			G1.add(paneer);
			paneer.setFont(new Font("Tahoma", Font.BOLD, 14));
			paneer.setBackground(new Color(102, 255, 51));
			paneer.setBounds(14, 365, 88, 21);
			contentPane.add(paneer);
			
			JRadioButton farm = new JRadioButton("FARMHOUSE");
			G1.add(farm);
			farm.setFont(new Font("Tahoma", Font.BOLD, 11));
			farm.setBackground(new Color(102, 255, 51));
			farm.setBounds(14, 440, 103, 21);
			contentPane.add(farm);
			
			JLabel lblNewLabel_6 = new JLabel("SELECT SIZE");
			lblNewLabel_6.setBackground(new Color(255, 51, 0));
			lblNewLabel_6.setForeground(new Color(255, 255, 255));
			lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel_6.setBounds(29, 514, 160, 35);
			contentPane.add(lblNewLabel_6);
			
			JRadioButton small = new JRadioButton("Small");
			G.add(small);
//			small.setIcon(pizza);
			small.setBackground(new Color(102, 255, 51));
			small.setFont(new Font("Tahoma", Font.BOLD, 15));
			small.setBounds(29, 557, 103, 21);
			contentPane.add(small);
			
			JRadioButton medium = new JRadioButton("Medium");
			G.add(medium);
	
			medium.setBackground(new Color(102, 255, 51));
			medium.setFont(new Font("Tahoma", Font.BOLD, 15));
			medium.setBounds(29, 601, 103, 21);
			contentPane.add(medium);
			
			JRadioButton large = new JRadioButton("Large");
			G.add(large);
			large.setFont(new Font("Tahoma", Font.BOLD, 15));
			large.setBackground(new Color(102, 255, 51));
			large.setBounds(29, 644, 103, 21);
			contentPane.add(large);
			
			JRadioButton elarge = new JRadioButton("Extra Large");
			G.add(elarge);
			elarge.setBackground(new Color(102, 255, 51));
			elarge.setFont(new Font("Tahoma", Font.BOLD, 15));
			elarge.setBounds(29, 686, 113, 21);
			contentPane.add(elarge);
			
			JCheckBox chee = new JCheckBox("EXTRA CHEESE");
			chee.setBackground(new Color(102, 255, 51));
			chee.setFont(new Font("Tahoma", Font.BOLD, 15));
			chee.setBounds(29, 729, 147, 21);
			contentPane.add(chee);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(194, 60, 498, 438);
			contentPane.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					index=table.getSelectedRow();
				}
			});
			table.setFont(new Font("Tahoma", Font.BOLD, 10));
			table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ITEM", "QUANTITY", "PRICE", "EXTRA CHEESE", "TOTAL"
				}
			));
			table.getColumnModel().getColumn(3).setPreferredWidth(95);
			scrollPane.setViewportView(table);
			
			tot = new JLabel("");
			tot.setForeground(new Color(255, 255, 255));
			tot.setFont(new Font("Tahoma", Font.BOLD, 20));
			tot.setBounds(762, 60, 88, 28);
			contentPane.add(tot);
			
			JButton add = new JButton("ADD");
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					if(onion.isSelected()==false && tomato.isSelected()==false && capsicum.isSelected()==false && corn.isSelected()==false && paneer.isSelected()==false && farm.isSelected()==false &&small.isSelected()==false && medium.isSelected()==false && large.isSelected()==false && elarge.isSelected()==false) {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"Please select your pizza and size of pizza");
					}
					else if(small.isSelected()==false && medium.isSelected()==false && large.isSelected()==false && elarge.isSelected()==false) {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"Please select size of your pizza");
					}else if(onion.isSelected()==false && tomato.isSelected()==false && capsicum.isSelected()==false && corn.isSelected()==false && paneer.isSelected()==false && farm.isSelected()==false) {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"Please select your pizza");
					}
							
					else{
					if(tomato.isSelected() && small.isSelected()) {
						item="tomato small";
						price=100;
					}else if(tomato.isSelected() && medium.isSelected()){
						item="tomato medium";
						price=140;
					}else if(tomato.isSelected() && large.isSelected()) {
						item="tomato large";
						price=200;
					}else if(tomato.isSelected() && elarge.isSelected()){
						item="tomato ExtraLarge";
						price=300;
					}
					if(capsicum.isSelected() && small.isSelected()) {
						item="capsicum small";
						price=100;
					}else if(capsicum.isSelected() && medium.isSelected()){
						item="capsicum medium";
						price=140;
					}else if(capsicum.isSelected() && large.isSelected()) {
						item="capsicum large";
						price=200;
					}else if(capsicum.isSelected() && elarge.isSelected()){
						item="capsicum ExtraLarge";
						price=300;
					}
					if(corn.isSelected() && small.isSelected()) {
						item="corn small";
						price=100;
					}else if(corn.isSelected() && medium.isSelected()){
						item="corn medium";
						price=140;
					}else if(corn.isSelected() && large.isSelected()) {
						item="corn large";
						price=200;
					}else if(corn.isSelected() && elarge.isSelected()){
						item="corn ExtraLarge";
						price=300;
					}
					if(paneer.isSelected() && small.isSelected()) {
						item="paneer small";
						price=110;
					}else if(paneer.isSelected() && medium.isSelected()){
						item="paneer medium";
						price=150;
					}else if(paneer.isSelected() && large.isSelected()) {
						item="paneer large";
						price=220;
					}else if(paneer.isSelected() && elarge.isSelected()){
						item="paneer ExtraLarge";
						price=330;
					}
					if(farm.isSelected() && small.isSelected()) {
						item="farm small";
						price=120;
					}else if(farm.isSelected() && medium.isSelected()){
						item="farm medium";
						price=160;
					}else if(farm.isSelected() && large.isSelected()) {
						item="farm large";
						price=230;
					}else if(farm.isSelected() && elarge.isSelected()){
						item="farm ExtraLarge";
						price=350;
					}
					if(onion.isSelected() && small.isSelected()) {
						item="Onion small";
						price=100;
					}else if(onion.isSelected() && medium.isSelected()){
						item="Onion medium";
						price=140;
					}else if(onion.isSelected() && large.isSelected()) {
						item="Onion large";
						price=200;
					}else if(onion.isSelected() && elarge.isSelected()){
						item="Onion ExtraLarge";
						price=300;
					}
					
					
					
					if(chee.isSelected()) {
						cheese="Yes";
						price =price+25;
					}
					int quty=Integer.parseInt(qty.getValue().toString());
					if(quty>=1) {
					int tot=price*quty;
	//				System.out.println(price);
					model=(DefaultTableModel) table.getModel();
					model.addRow(new Object[]
							{
									item,
									quty,price,cheese,tot
									
							}
							
							);
				}
					else {
						JOptionPane jp=new JOptionPane();
						jp.showMessageDialog(null,"Please select quantity");
					}
				}
					int sum=0;
					for(int a=0;a<table.getRowCount();a++) {
						sum=sum+Integer.parseInt(table.getValueAt(a,4).toString());
					}
					String s=Integer.toString(sum);
					tot.setText(s);
				}
			});
			add.setForeground(Color.WHITE);
			add.setFont(new Font("Tahoma", Font.BOLD, 15));
			add.setBackground(Color.RED);
			add.setBounds(712, 139, 151, 48);
			contentPane.add(add);
			
			
			
			JLabel quantity = new JLabel("QUANTITY");
			quantity.setFont(new Font("Tahoma", Font.BOLD, 15));
			quantity.setBounds(700, 87, 88, 42);
			contentPane.add(quantity);
			
			 qty = new JSpinner();
			qty.setFont(new Font("Tahoma", Font.BOLD, 18));
			qty.setBounds(798, 90, 82, 35);
			contentPane.add(qty);
			
			JLabel lblQuantity = new JLabel("TOTAL");
			lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblQuantity.setBounds(702, 60, 50, 35);
			contentPane.add(lblQuantity);
			
			balance = new JLabel("");
			balance.setForeground(new Color(255, 255, 255));
			balance.setFont(new Font("Tahoma", Font.BOLD, 15));
			balance.setBounds(746, 2, 88, 42);
			contentPane.add(balance);
			
			
			
			JButton removel = new JButton("REMOVE PIZZA ");
			removel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(index!=-1) {
					model.removeRow(index);
					int sum=0;
					for(int a=0;a<table.getRowCount();a++) {
						sum=sum+Integer.parseInt(table.getValueAt(a,4).toString());
					}
					String s=Integer.toString(sum);
					tot.setText(s);
				}else {
					JOptionPane jp=new JOptionPane();
					jp.showMessageDialog(null,"Please Select a pizza you want to remove");
				}
				}
			});
			removel.setForeground(Color.WHITE);
			removel.setFont(new Font("Tahoma", Font.BOLD, 13));
			removel.setBackground(Color.RED);
			removel.setBounds(710, 197, 151, 48);
			contentPane.add(removel);
			
			JLabel wallet = new JLabel("New label");
			wallet.setIcon(new ImageIcon("D:\\Rental Page\\pngtree-orange-wallet-icon-image_1168655.jpg"));
			wallet.setBounds(685, 0, 50, 50);
			contentPane.add(wallet);
			
			JButton btnNewButton = new JButton("SHOW BALANCE");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					balanceupdate();
				}
			});
			btnNewButton.setBackground(Color.RED);
			btnNewButton.setForeground(Color.WHITE);
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
			btnNewButton.setBounds(512, 2, 173, 35);
			contentPane.add(btnNewButton);
			
			JButton btnNewButton_1 = new JButton("PAY");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					b=Integer.parseInt(tot.getText());
//					System.out.println(b+" "+balan);
					if(b>=0 && balan>0 && balan>=b) {
						a=balan-b;
						String c=String.valueOf(a);
						if(a>=0) {
						try {
							PreparedStatement pst=(PreparedStatement) con.prepareStatement("update details set Balance=? where Emailid=?");
							pst.setInt(1,a);
							pst.setString(2,email);
							int i=pst.executeUpdate();
							balance.setText(c);
							if(i==1 || i==0 || i==2) {
								JOptionPane jp=new JOptionPane();
								jp.showMessageDialog(null,"Order Placed Sucessfully");
								model.setRowCount(0);
								PreparedStatement pst1=(PreparedStatement) con.prepareStatement("insert into invoice(Emailid,Amount,Pizza) values(?,?,?)");
								pst1.setString(1,email);
								pst1.setInt(2,b);
								pst1.setString(3, item);
								pst1.executeUpdate();
								
								int j=jp.showConfirmDialog(null,"You want to see your order history ?");
								if(j==0) {
									invo io=new invo();
									io.setVisible(true);
									io.my_updates(email,tot.getText(),item,balance.getText());
									dispose();
								}
								else {
									jp.showMessageDialog(null,"Your Order will be delievered to you soon");
									dispose();
								}
								
							}else {
								JOptionPane jp=new JOptionPane();
								jp.showMessageDialog(null,"Order Not Placed If any ammount debited from your wallet it will be returned to you within 3 days");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}else {
						
					}
				}else {
					JOptionPane jp=new JOptionPane();
					jp.showMessageDialog(null,"Insuffiecient Funds Please add more funds to your account");
				}
				}
				
				
			});
			btnNewButton_1.setForeground(Color.WHITE);
			btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 30));
			btnNewButton_1.setBackground(Color.RED);
			btnNewButton_1.setBounds(712, 258, 147, 48);
			contentPane.add(btnNewButton_1);
			
			JLabel lblNewLabel = new JLabel("New label");
			lblNewLabel.setIcon(new ImageIcon("D:\\Rental Page\\onionpizza.jpg"));
			lblNewLabel.setBounds(123, 60, 50, 50);
			contentPane.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("New label");
			lblNewLabel_1.setIcon(new ImageIcon("D:\\Rental Page\\tomato.jpg"));
			lblNewLabel_1.setBounds(123, 132, 50, 50);
			contentPane.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("New label");
			lblNewLabel_2.setIcon(new ImageIcon("D:\\Rental Page\\capsicum.jpg"));
			lblNewLabel_2.setBounds(123, 199, 50, 50);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("New label");
			lblNewLabel_3.setIcon(new ImageIcon("D:\\Rental Page\\corn.png"));
			lblNewLabel_3.setBounds(123, 279, 50, 50);
			contentPane.add(lblNewLabel_3);
			
			JLabel lblNewLabel_4 = new JLabel("New label");
			lblNewLabel_4.setIcon(new ImageIcon("D:\\Rental Page\\Paneer_Special.jpg"));
			lblNewLabel_4.setBounds(123, 352, 50, 50);
			contentPane.add(lblNewLabel_4);
			
			JLabel lblNewLabel_5 = new JLabel("New label");
			lblNewLabel_5.setIcon(new ImageIcon("D:\\Rental Page\\Farmhouse.jpg"));
			lblNewLabel_5.setBounds(123, 426, 50, 50);
			contentPane.add(lblNewLabel_5);
			
			JButton print = new JButton("ORDER HISTORY");
			print.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
				}
			});
			print.setForeground(Color.WHITE);
			print.setFont(new Font("Tahoma", Font.BOLD, 13));
			print.setBackground(Color.RED);
			print.setBounds(710, 315, 151, 48);
			contentPane.add(print);
			
			JButton btnBack = new JButton("BACK");
			btnBack.addActionListener(new ActionListener() {
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
			btnBack.setForeground(Color.WHITE);
			btnBack.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnBack.setBackground(Color.RED);
			btnBack.setBounds(712, 388, 151, 48);
			contentPane.add(btnBack);
			
			
			
			
		}
		public void balanceupdate() {
			
			balance.setText(String.valueOf(balan));
		}
	}
