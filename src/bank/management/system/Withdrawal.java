package bank.management.system;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener{

	JButton withdraw,back;
	JTextField amount;
	String pinNo;
	
	Withdrawal(String pinNo){
		this.pinNo = pinNo;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		JLabel text = new JLabel("Enter the amount you want to Withdraw");
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD,16));
		text.setBounds(170,300,400,25);
		image.add(text);
		
		amount = new JTextField();
		amount.setFont(new Font("Raleway", Font.BOLD,22));
		amount.setBounds(170,350,320,25);
		image.add(amount);
		
		withdraw = new JButton("Withdraw");
		withdraw.setBounds(355,485,150,30);
		withdraw.addActionListener(this);
		image.add(withdraw);
		
		back = new JButton("Back");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		setSize(900,900);
		setLocation(300,0);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Withdrawal("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == withdraw) {
			String depositAmount = amount.getText();
			Date date = new Date();
			if(depositAmount.equals("")) {
				JOptionPane.showMessageDialog(null, "Please Enter the Amount");
			}else {
				try {
				Conn conn = new Conn();
				String query ="insert into bank values ('"+pinNo+"','"+date+"', 'Withdrawal', '"+depositAmount+"')";
				conn.s.executeUpdate(query);
				
				JOptionPane.showMessageDialog(null, "Rs" +depositAmount+" Withdrawed Successfully");
				
				setVisible(false);
				new Transactions(pinNo).setVisible(true);
				}catch(Exception exception){
					System.out.println(exception);
				}
			}
		}else if(e.getSource() == back) {
			setVisible(false);
			new Transactions(pinNo).setVisible(true);
		}
	}

}
