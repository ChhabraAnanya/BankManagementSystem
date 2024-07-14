package bank.management.system;

import java.awt.Color;

import javax.swing.*;
import java.awt.*;
import java.util.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpOne extends JFrame implements ActionListener{
	
	long random;
	JButton next;
	JRadioButton male, female, other, married, unmarried, single;
	
	JTextField nameText = new JTextField();
	JTextField fatherNameText = new JTextField();
	JTextField emailText = new JTextField();
	JTextField addressText = new JTextField();
	JTextField cityText = new JTextField();
	JTextField stateText = new JTextField();
	JTextField pinText = new JTextField();
	JTextField dobText = new JTextField();

	SignUpOne(){
		
		setLayout(null);
		
		Random rand = new Random();
        long random = Math.abs((rand.nextLong() % 9000L) + 1000L);
        
		JLabel formNo = new JLabel("Application Form No. " + random);
		formNo.setFont(new Font("Raleway", Font.BOLD, 38));
		formNo.setBounds(140,20,600,40);
		add(formNo);
		
		JLabel personDetails = new JLabel("Page 1: Personal Details");
		personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
		personDetails.setBounds(290,80,400,30);
		add(personDetails);
		
		JLabel name = new JLabel("Name:");
		name.setFont(new Font("Raleway", Font.BOLD, 22));
	    name.setBounds(100,140,100,30);
		add(name);
		nameText.setFont(new Font("Raleway", Font.BOLD,14));
		nameText.setBounds(300,140,400,30);
		add(nameText);
		
		JLabel fathersName = new JLabel("Father's Name:");
		fathersName.setFont(new Font("Raleway", Font.BOLD, 22));
		fathersName.setBounds(100,190,200,30);
		add(fathersName);
		fatherNameText.setFont(new Font("Raleway", Font.BOLD,14));
		fatherNameText.setBounds(300,190,400,30);
		add(fatherNameText);
		
		JLabel dob = new JLabel("Date of Birth:");
		dob.setFont(new Font("Raleway", Font.BOLD, 22));
		dob.setBounds(100,240,200,30);
		add(dob);
		dobText.setFont(new Font("Raleway", Font.BOLD,14));
		dobText.setBounds(300,240,400,30);
		add(dobText);
//		JDateChooser dateChooser = new JDateChooser();
//		dateChooser.setBounds(300,240,400,30);
//		dateChooser.setForeground(Color.BLACK);
//		add(dateChooser);
		
		JLabel gender = new JLabel("Gender:");
		gender.setFont(new Font("Raleway", Font.BOLD, 22));
		gender.setBounds(100,290,200,30);
		add(gender);
		
		male = new JRadioButton("Male");
		male.setBounds(300,290,60,30);
		male.setBackground(Color.WHITE);
		add(male);
		female = new JRadioButton("Female");
		female.setBounds(450,290,120,30);
		female.setBackground(Color.WHITE);
		add(female);
		
		ButtonGroup gendergroup = new ButtonGroup();
		gendergroup.add(male);
		gendergroup.add(female);
		
		JLabel email = new JLabel("Email Address:");
		email.setFont(new Font("Raleway", Font.BOLD, 22));
		email.setBounds(100,340,200,30);
		add(email);
		emailText.setFont(new Font("Raleway", Font.BOLD,14));
		emailText.setBounds(300,340,400,30);
		add(emailText);
	
		JLabel maritalStatus = new JLabel("Marital Status:");
		maritalStatus.setFont(new Font("Raleway", Font.BOLD, 22));
		maritalStatus.setBounds(100,390,200,30);
		add(maritalStatus);
	

		married = new JRadioButton("Married");
		married.setBounds(300,390,100,30);
		married.setBackground(Color.WHITE);
		add(married);
		single = new JRadioButton("Single");
		single.setBounds(450,390,100,30);
		single.setBackground(Color.WHITE);
		add(single);
		other = new JRadioButton("Other");
		other.setBounds(600,390,100,30);
		other.setBackground(Color.WHITE);
		add(other);
		
		ButtonGroup maritalgroup = new ButtonGroup();
		maritalgroup.add(married);
		maritalgroup.add(single);
		maritalgroup.add(other);
		
		JLabel address = new JLabel("Address:");
		address.setFont(new Font("Raleway", Font.BOLD, 22));
		address.setBounds(100,440,200,30);
		add(address);
		addressText.setFont(new Font("Raleway", Font.BOLD,14));
		addressText.setBounds(300,440,400,30);
		add(addressText);
		
		JLabel city = new JLabel("City:");
		city.setFont(new Font("Raleway", Font.BOLD, 22));
		city.setBounds(100,490,200,30);
		add(city);
		cityText.setFont(new Font("Raleway", Font.BOLD,14));
		cityText.setBounds(300,490,400,30);
		add(cityText);
		
		JLabel state = new JLabel("State:");
		state.setFont(new Font("Raleway", Font.BOLD, 22));
		state.setBounds(100,540,200,30);
		add(state);
		stateText.setFont(new Font("Raleway", Font.BOLD,14));
		stateText.setBounds(300,540,400,30);
		add(stateText);
		
		JLabel pinCode = new JLabel("Pin Code:");
		pinCode.setFont(new Font("Raleway", Font.BOLD, 22));
		pinCode.setBounds(100,590,200,30);
		add(pinCode);
		pinText.setFont(new Font("Raleway", Font.BOLD,14));
		pinText.setBounds(300,590,400,30);
		add(pinText);
		
		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620,660,80,30);
		next.addActionListener(this);
		add(next);
		
		getContentPane().setBackground(Color.WHITE);
		setSize(850,800);
		setLocation(350,10);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new SignUpOne();

	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String formno = "" + random;
		String name = nameText.getText();
		String fname = fatherNameText.getText();
		String dob = dobText.getText();
		String gender = null;
		if(male.isSelected()) {
			gender = "Male";
		}
		else if(female.isSelected()) {
			gender = "Female";
		}
		String email = emailText.getText();
		String marital = null;
		if(married.isSelected()) {
			marital = "Married";
		}
		else if(single.isSelected()) {
			marital = "Single";
		}
		else if(other.isSelected()) {
			marital = "Other";
		}
		String address = addressText.getText();
		String city = cityText.getText();
		String state = stateText.getText();
		String pin = pinText.getText();
		
		try {
			if(name.equals("")) {
				JOptionPane.showMessageDialog(null,  "Name is Required");
			}else {
				Conn c = new Conn();
				String query = "insert into signup values('"+formno+"', '"+name+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+marital+"', '"+address+"', '"+city+"', '"+state+"', '"+pin+"')";
				c.s.executeUpdate(query);
				
				setVisible(false);
				new SignUpTwo(formno).setVisible(true);
			}
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
