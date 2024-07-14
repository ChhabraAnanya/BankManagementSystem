package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignUpTwo extends JFrame implements ActionListener {

	long random;
	JButton next;
	JRadioButton syes, sno, existingNo, existingYes;
    JComboBox religion, ocuField, eduField, income;
    String formno;

	SignUpTwo(String formno) {

		this.formno = formno;
		setLayout(null);
		setTitle("NEW ACCOUNT APPLICAION FORM - PAGE 2");

		JLabel additional = new JLabel("Page 2: Additional Details");
		additional.setFont(new Font("Raleway", Font.BOLD, 22));
		additional.setBounds(290, 80, 400, 30);
		add(additional);

		JLabel name = new JLabel("Religion:");
		name.setFont(new Font("Raleway", Font.BOLD, 22));
		name.setBounds(100, 170, 100, 30);
		add(name);

		String religionNames[] = { "Christianity", "Hindu", "Islam", "Sikh", "Buddhism", "Other" };
		religion = new JComboBox(religionNames);

		religion.setFont(new Font("Raleway", Font.BOLD, 14));
		religion.setBounds(300, 170, 400, 30);
		religion.setBackground(Color.WHITE);
		add(religion);

		JLabel incomeField = new JLabel("Income:");
		incomeField.setFont(new Font("Raleway", Font.BOLD, 22));
		incomeField.setBounds(100, 240, 200, 30);
		add(incomeField);
		String incomeCategory[] = { "< 1,50,000", "<2,50,1000", "<5,00,000", ">10,00,000", "Null" };
		income = new JComboBox(incomeCategory);
		income.setFont(new Font("Raleway", Font.BOLD, 14));
		income.setBounds(300, 240, 400, 30);
		income.setBackground(Color.WHITE);
		add(income);
//		JDateChooser dateChooser = new JDateChooser();
//		dateChooser.setBounds(300,240,400,30);
//		dateChooser.setForeground(Color.BLACK);
//		add(dateChooser);

		JLabel gender = new JLabel("Educational");
		gender.setFont(new Font("Raleway", Font.BOLD, 22));
		gender.setBounds(100, 290, 200, 30);
		add(gender);

		JLabel email = new JLabel("Qualification:");
		email.setFont(new Font("Raleway", Font.BOLD, 22));
		email.setBounds(100, 315, 200, 30);
		add(email);
		String educationValues[] = { "High School/Diploma", "Bachelor's", "Master's", "Phd" };
		eduField = new JComboBox(educationValues);
		eduField.setFont(new Font("Raleway", Font.BOLD, 14));
		eduField.setBounds(300, 290, 400, 30);
		eduField.setBackground(Color.WHITE);
		add(eduField);

		JLabel maritalStatus = new JLabel("Occupation:");
		maritalStatus.setFont(new Font("Raleway", Font.BOLD, 22));
		maritalStatus.setBounds(100, 355, 200, 30);
		add(maritalStatus);
		String occupationValues[] = { "Salaried", "Self-Employed/Businessman", "Student", "Retired" };
		ocuField = new JComboBox(occupationValues);
		ocuField.setFont(new Font("Raleway", Font.BOLD, 14));
		ocuField.setBounds(300, 355, 400, 30);
		ocuField.setBackground(Color.WHITE);
		add(ocuField);
		
		JLabel city = new JLabel("Senior Citizen:");
		city.setFont(new Font("Raleway", Font.BOLD, 22));
		city.setBounds(100, 405, 200, 30);
		add(city);
		syes = new JRadioButton("Yes");
		syes.setBounds(300,405,100,30);
		sno = new JRadioButton("No");
		sno.setBounds(450,405,100,30);
		syes.setBackground(Color.WHITE);
		sno.setBackground(Color.WHITE);
		add(syes);
		add(sno);
	    
		ButtonGroup values = new ButtonGroup();
		values.add(syes);
		values.add(sno);
				
		JLabel state = new JLabel("Existing Account:");
		state.setFont(new Font("Raleway", Font.BOLD, 22));
		state.setBounds(100, 455, 200, 30);
		add(state);
		existingYes = new JRadioButton("Yes");
		existingYes.setBounds(300,455,100,30);
		existingNo = new JRadioButton("No");
		existingNo.setBounds(450,455,100,30);
		existingYes.setBackground(Color.WHITE);
		existingNo.setBackground(Color.WHITE);
		add(existingYes);
		add(existingNo);
	    
		ButtonGroup seniorValues = new ButtonGroup();
		seniorValues.add(existingYes);
		seniorValues.add(existingNo);

		next = new JButton("Next");
		next.setBackground(Color.BLACK);
		next.setForeground(Color.WHITE);
		next.setFont(new Font("Raleway", Font.BOLD, 14));
		next.setBounds(620, 660, 80, 30);
		next.addActionListener(this);
		add(next);

		getContentPane().setBackground(Color.WHITE);
		setSize(850, 800);
		setLocation(350, 10);
		setVisible(true);
	}

	public static void main(String[] args) {
		new SignUpTwo("");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		String sreligion = (String)religion.getSelectedItem();
		String sincome = (String)income.getSelectedItem();
		String seducation = (String)eduField.getSelectedItem();
		String soccupation = (String)ocuField.getSelectedItem() ;
		String seniorCitizen = null;
		if (syes.isSelected()) {
			seniorCitizen = "Yes";
		} else if (sno.isSelected()) {
			seniorCitizen = "No";
		}
		
		String existingAccount = null;
		if (existingYes.isSelected()) {
			existingAccount = "Yes";
		} else if (existingNo.isSelected()) {
			existingAccount = "No";
		}
		
		try {
		   Conn c = new Conn();
		   String query = "insert into signupTwo values('"+formno+"', '"+sreligion+"', '"+sincome+"', '"+seducation+"', '"+soccupation+"', '"+existingAccount+"', '"+seniorCitizen+"')";
           c.s.executeUpdate(query);
           setVisible(false);
           new SignUpThree(formno).setVisible(true);
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
