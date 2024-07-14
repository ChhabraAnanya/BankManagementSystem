package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class MiniStatement extends JFrame{

	String pinNo;
	
	MiniStatement(String pinNo){
		this.pinNo = pinNo;
		setTitle("Mini Statement");
		
		setLayout(null);
		
		JLabel miniStatement = new JLabel();
		add(miniStatement);
		
		JLabel bankName = new JLabel("Imperial Elite Bank");
		bankName.setBounds(150,20,150,20);
		add(bankName);
		
		JLabel card = new JLabel();
		card.setBounds(20,60,300,20);
		add(card);
		
		JLabel balance = new JLabel();
		balance.setBounds(20,400,300,20);
		add(balance);
		
		try {
			Conn conn = new Conn();
			ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pinNo+"'");
			while(rs.next()) {
				card.setText("Card Number: " + rs.getString("cardNumber").substring(0,4) + "XXXXXXXX" + rs.getString("cardNumber".substring(12)));
			}
		}catch(Exception e) {
			System.out.println(e);
		}
		
		try {
			Conn conn = new Conn();
			int bal = 0;
			ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pinNo+"'");
			while(rs.next()) {
				miniStatement.setText(miniStatement.getText() + "<html>" + rs.getString("dateText") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("typeText") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><br><br>");
				if(rs.getString("typeText").equals("Deposit")) {
					bal += Integer.parseInt(rs.getString("amount"));
				}else {
				    bal -= Integer.parseInt(rs.getString("amount"));
		    	}
 			}
			balance.setText("Your current account balance is Rs " + bal);
		}catch(Exception e) {
			System.out.println(e);
		}
		miniStatement.setBounds(20,140,400,200);
		
		setSize(400,600);
		setLocation(20,20);
		getContentPane().setBackground(Color.WHITE);
		setVisible(true);
	}
	public static void main(String[] args) {
		new MiniStatement("");
	}

}
