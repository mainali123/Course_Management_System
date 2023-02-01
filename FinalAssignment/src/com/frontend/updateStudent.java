package com.frontend;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.database.JDBC;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JFormattedTextField;
import javax.swing.JRadioButton;
import javax.swing.SpringLayout;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.Enumeration;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.math.BigDecimal;
import java.awt.event.ItemEvent;

public class updateStudent extends JDialog {
	private JPanel formPanel;
	private JLabel lblNewLabel_1;
	private JTextField studentUpdatedAddress;
	private JTextField studentUpdatedName;
	private JLabel lblNewLabel_6;
	private JButton studentUpdatedUpdateButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField studentUpdatedCitizenshipNo;
	private JTextField studentUpdatedDob;
	private JTextField studentUpdatedEmail;
	private JTextField studentUpdatedPassword;
	private JTextField studentUpdatedCollegeEmail;


	







	public JTextField getStudentUpdatedAddress() {
		return studentUpdatedAddress;
	}










	public JTextField getStudentUpdatedName() {
		return studentUpdatedName;
	}










	public JButton getStudentUpdatedUpdateButton() {
		return studentUpdatedUpdateButton;
	}










	public JTextField getStudentUpdatedCitizenshipNo() {
		return studentUpdatedCitizenshipNo;
	}










	public JTextField getStudentUpdatedDob() {
		return studentUpdatedDob;
	}










	public JTextField getStudentUpdatedEmail() {
		return studentUpdatedEmail;
	}










	public JTextField getStudentUpdatedPassword() {
		return studentUpdatedPassword;
	}










	public JTextField getStudentUpdatedCollegeEmail() {
		return studentUpdatedCollegeEmail;
	}










	/**
	 * Create the dialog.
	 */
	public updateStudent() {
		setTitle("Update Student");
		setBounds(100, 100, 549, 426);
		formPanel = new JPanel();
		setContentPane(formPanel);

		JLabel lblNewLabel = new JLabel("Name:");

		studentUpdatedName = new JTextField();
		studentUpdatedName.setColumns(10);

		studentUpdatedUpdateButton = new JButton("Update");
		studentUpdatedUpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		studentUpdatedUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (studentUpdatedName.getText().isEmpty() || studentUpdatedAddress.getText().isEmpty()
						|| studentUpdatedCitizenshipNo.getText().isEmpty()
						|| studentUpdatedDob.getText().isEmpty()
						|| studentUpdatedEmail.getText().isEmpty() || studentUpdatedPassword.getText().isEmpty()) {
					lblNewLabel_6.setVisible(true);
				} else {
					lblNewLabel_6.setVisible(false);
				}
				
				

			}
		});

		lblNewLabel_1 = new JLabel("Address:");

		studentUpdatedAddress = new JTextField();
		studentUpdatedAddress.setColumns(10);
		SpringLayout sl_formPanel = new SpringLayout();
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedUpdateButton, 225, SpringLayout.WEST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -18, SpringLayout.NORTH, lblNewLabel_1);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, studentUpdatedName, -6, SpringLayout.NORTH, studentUpdatedAddress);
		sl_formPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 64, SpringLayout.NORTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.NORTH, studentUpdatedAddress, 61, SpringLayout.NORTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, lblNewLabel_1, 64, SpringLayout.WEST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel, 0, SpringLayout.EAST, lblNewLabel_1);
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedName, 0, SpringLayout.WEST, studentUpdatedAddress);
		sl_formPanel.putConstraint(SpringLayout.EAST, studentUpdatedName, -53, SpringLayout.EAST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedAddress, 6, SpringLayout.EAST, lblNewLabel_1);
		sl_formPanel.putConstraint(SpringLayout.EAST, studentUpdatedAddress, -53, SpringLayout.EAST, formPanel);
		formPanel.setLayout(sl_formPanel);
		formPanel.add(lblNewLabel_1);
		formPanel.add(lblNewLabel);
		formPanel.add(studentUpdatedAddress);
		formPanel.add(studentUpdatedUpdateButton);
		formPanel.add(studentUpdatedName);

		lblNewLabel_6 = new JLabel("Every Filed should be filled!!!");
		sl_formPanel.putConstraint(SpringLayout.NORTH, studentUpdatedName, 4, SpringLayout.SOUTH, lblNewLabel_6);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -363, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 158, SpringLayout.WEST, formPanel);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setVisible(false);
		formPanel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_2 = new JLabel("Citizenship Number:");
		sl_formPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 17, SpringLayout.SOUTH, lblNewLabel_1);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		formPanel.add(lblNewLabel_2);
		
		studentUpdatedCitizenshipNo = new JTextField();
		sl_formPanel.putConstraint(SpringLayout.NORTH, studentUpdatedCitizenshipNo, -3, SpringLayout.NORTH, lblNewLabel_2);
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedCitizenshipNo, 0, SpringLayout.WEST, studentUpdatedAddress);
		sl_formPanel.putConstraint(SpringLayout.EAST, studentUpdatedCitizenshipNo, -53, SpringLayout.EAST, formPanel);
		formPanel.add(studentUpdatedCitizenshipNo);
		studentUpdatedCitizenshipNo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("DOB:");
		sl_formPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_5, 17, SpringLayout.SOUTH, lblNewLabel_2);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel_5, 0, SpringLayout.EAST, lblNewLabel_1);
		formPanel.add(lblNewLabel_5);
		
		studentUpdatedDob = new JTextField();
		sl_formPanel.putConstraint(SpringLayout.NORTH, studentUpdatedDob, -3, SpringLayout.NORTH, lblNewLabel_5);
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedDob, 111, SpringLayout.WEST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.EAST, studentUpdatedDob, 0, SpringLayout.EAST, studentUpdatedAddress);
		studentUpdatedDob.setText("DD/MM/YYYY");
		formPanel.add(studentUpdatedDob);
		studentUpdatedDob.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Email:");
		sl_formPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_7, 16, SpringLayout.SOUTH, lblNewLabel_5);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel_7, 0, SpringLayout.EAST, lblNewLabel_1);
		formPanel.add(lblNewLabel_7);
		
		studentUpdatedEmail = new JTextField();
		sl_formPanel.putConstraint(SpringLayout.NORTH, studentUpdatedEmail, -3, SpringLayout.NORTH, lblNewLabel_7);
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedEmail, 0, SpringLayout.WEST, studentUpdatedAddress);
		sl_formPanel.putConstraint(SpringLayout.EAST, studentUpdatedEmail, 0, SpringLayout.EAST, studentUpdatedAddress);
		formPanel.add(studentUpdatedEmail);
		studentUpdatedEmail.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Password:");
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel_8, 0, SpringLayout.EAST, lblNewLabel_1);
		formPanel.add(lblNewLabel_8);
		
		studentUpdatedPassword = new JTextField();
		sl_formPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 3, SpringLayout.NORTH, studentUpdatedPassword);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, studentUpdatedPassword, -129, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.NORTH, studentUpdatedUpdateButton, 33, SpringLayout.SOUTH, studentUpdatedPassword);
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedPassword, 0, SpringLayout.WEST, studentUpdatedAddress);
		sl_formPanel.putConstraint(SpringLayout.EAST, studentUpdatedPassword, 0, SpringLayout.EAST, studentUpdatedAddress);
		formPanel.add(studentUpdatedPassword);
		studentUpdatedPassword.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("College Email:");
		sl_formPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_3, 15, SpringLayout.SOUTH, lblNewLabel_7);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel_3, 0, SpringLayout.EAST, lblNewLabel_1);
		formPanel.add(lblNewLabel_3);
		
		studentUpdatedCollegeEmail = new JTextField();
		sl_formPanel.putConstraint(SpringLayout.NORTH, studentUpdatedCollegeEmail, 12, SpringLayout.SOUTH, studentUpdatedEmail);
		sl_formPanel.putConstraint(SpringLayout.WEST, studentUpdatedCollegeEmail, 6, SpringLayout.EAST, lblNewLabel_3);
		sl_formPanel.putConstraint(SpringLayout.EAST, studentUpdatedCollegeEmail, 0, SpringLayout.EAST, studentUpdatedAddress);
		formPanel.add(studentUpdatedCollegeEmail);
		studentUpdatedCollegeEmail.setColumns(10);
	}
}
