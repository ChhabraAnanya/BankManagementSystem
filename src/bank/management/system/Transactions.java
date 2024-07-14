package bank.management.system;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Transactions extends JFrame implements ActionListener{

	JButton deposit, cashWithdrawal, fastCash, miniStatement, pinChange, balance, exit ;
	String pinNo;
	Transactions(String pinNo){
		this.pinNo = pinNo;
		setLayout(null);
		//System.out.println(ClassLoader.getSystemResource("atm.jpg"));
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("atm.jpg"));
		Image i2 =  i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
	    ImageIcon i3 = new ImageIcon(i2);
	    JLabel image = new JLabel(i3);
	    image.setBounds(0,0,900,900);
	    add(image);
		
		JLabel text = new JLabel("Please select your transactions");
		text.setBounds(210,300,700,35);
		text.setForeground(Color.WHITE);
		text.setFont(new Font("System", Font.BOLD, 16));
		image.add(text);
		
		deposit = new JButton("Deposit");
		deposit.setBounds(170,415,150,30);
		deposit.addActionListener(this);
		image.add(deposit);
		
		cashWithdrawal = new JButton("Cash Withdrawal");
		cashWithdrawal.setBounds(355,415,150,30);
		cashWithdrawal.addActionListener(this);
		image.add(cashWithdrawal);
		
		fastCash = new JButton("Fast Cash");
		fastCash.setBounds(170,450,150,30);
		fastCash.addActionListener(this);
		image.add(fastCash);
		
		miniStatement = new JButton("Mini Statement");
		miniStatement.setBounds(355,450,150,30);
		miniStatement.addActionListener(this);
		image.add(miniStatement);
		
		pinChange = new JButton("Change PIN");
		pinChange.setBounds(170,480,150,30);
		pinChange.addActionListener(this);
		image.add(pinChange);
		
		balance = new JButton("Balance Enquiry");
		balance.setBounds(355,485,150,30);
		balance.addActionListener(this);
		image.add(balance);
		
		exit = new JButton("Exit");
		exit.setBounds(250,520,150,30);
		exit.addActionListener(this);
		image.add(exit);
		
		setSize(900,900);
		setLocation(300,0);
		setUndecorated(true);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Transactions("");
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == exit) {
			System.exit(0);
		}else if(e.getSource() == deposit) {
			setVisible(false);
			new Deposits(pinNo).setVisible(true);
		}else if(e.getSource() == cashWithdrawal) {
			setVisible(false);
			new Withdrawal(pinNo).setVisible(true);
		}else if(e.getSource() == fastCash) {
			setVisible(false);
			new FastCash(pinNo).setVisible(true);
		}else if(e.getSource() == pinChange) {
			setVisible(false);
			new PinChange(pinNo).setVisible(true);
		}else if(e.getSource() == balance) {
			setVisible(false);
			new BalanceEnquiry(pinNo).setVisible(true);
		}else if(e.getSource() == miniStatement) {
			new MiniStatement(pinNo).setVisible(true);
		}
	}

}
