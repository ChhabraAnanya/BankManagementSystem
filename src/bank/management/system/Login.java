package bank.management.system;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
	JButton signin = new JButton("SIGN IN");
	JButton clear = new JButton("CLEAR");
	JButton signup = new JButton("SIGN UP");
	
	JTextField cardTextField = new JTextField();
	JPasswordField pinTextField = new JPasswordField();

	Login(){
		setTitle("AUTOMATED TELLER MACHINE");
		
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel label = new JLabel(i3);
		label.setBounds(70,10,100,100);
		add(label);
		
		
		JLabel text = new JLabel("Welcome to ATM");
		text.setBounds(200, 40, 400, 40);
		text.setFont(new Font("Osward", Font.BOLD, 38));
		add(text);
		
		JLabel cardNo = new JLabel("Card No:");
		cardNo.setBounds(120, 150, 150, 30);
		cardNo.setForeground(Color.BLACK);
		cardNo.setFont(new Font("Raleway", Font.BOLD, 28));
		add(cardNo);
		
		cardTextField.setBounds(300, 150, 230, 30);
		add(cardTextField);
		
		JLabel pin = new JLabel("PIN:");
		pin.setBounds(120, 220, 250, 30);
		pin.setFont(new Font("Raleway", Font.BOLD, 28));
		add(pin);
		
		pinTextField.setBounds(300, 220, 230, 30);
		add(pinTextField);
		
		signin.setBounds(300,300,100,30);
		signin.setBackground(Color.black);
		signin.setForeground(Color.WHITE);
		signin.addActionListener(this);
		add(signin);
		
		clear.setBounds(430,300,100,30);
		clear.setBackground(Color.black);
		clear.setForeground(Color.WHITE);
		clear.addActionListener(this);
		add(clear);
		
		signup.setBounds(300,350,230,30);
		signup.setBackground(Color.black);
		signup.setForeground(Color.WHITE);
		signup.addActionListener(this);
		add(signup);
		
		getContentPane().setBackground(Color.WHITE);
		
		setSize(800,480);
		setVisible(true);
		setLocation(350,200);
	}
	public static void main(String[] args) {
		new Login();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==clear) {
			cardTextField.setText("");
			pinTextField.setText("");
		}
		else if(e.getSource()==signin) {
			Conn conn = new Conn();
			String cardNo = cardTextField.getText();
			String pinNo = pinTextField.getText();
			
			  System.out.println("Card Number:" + cardNo);
	            System.out.println("PIN: " + pinNo);
			String logInquery = "select * from login where cardNumber = '"+cardNo+"' and pin = '"+pinNo+"'";
	        System.out.print(logInquery);
			try {
				ResultSet rs = conn.s.executeQuery(logInquery);
	
				if(rs.next()) {
					setVisible(false);
					new Transactions(pinNo).setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
				}
			}catch(Exception ex){
				System.out.println(ex);
			}
		}
		else if(e.getSource()==signup) {
			setVisible(false);
			new SignUpOne().setVisible(true);
		}
	}

}
 