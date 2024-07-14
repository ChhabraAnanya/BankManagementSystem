package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BalanceEnquiry extends JFrame implements ActionListener{

	JButton back;
	String pinNo;
	
	BalanceEnquiry(String pinNo){
		this.pinNo = pinNo;
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 = i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0,0,900,900);
		add(image);
		
		back = new JButton("BACK");
		back.setBounds(355,520,150,30);
		back.addActionListener(this);
		image.add(back);
		
		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pinNo+"' ");
			while(rs.next()) {
			   if(rs.getString("typeText").equals("Deposit")) {
			   balance += Integer.parseInt(rs.getString("amount"));
			}else {
				balance -= Integer.parseInt(rs.getString("amount"));
			}
			}
		}catch(Exception e) {
				System.out.println(e);
			}
		
		JLabel message = new JLabel("Your Current Amount Balance is Rs " + balance);
		message.setForeground(Color.WHITE);
		message.setBounds(170,300,400,30);
		image.add(message);
			
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		new BalanceEnquiry("");
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
	    setVisible(false);
	    new Transactions(pinNo).setVisible(true);
	}

}
