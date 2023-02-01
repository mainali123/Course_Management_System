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

public class updateMarks extends JDialog {
	private JPanel formPanel;
	private JTextField marksUpdatedMarks;
	private JLabel lblNewLabel_6;
	private JButton marksUpdatedUpdateButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	
	public JTextField getMarksUpdatedMarks() {
		return marksUpdatedMarks;
	}



	public JButton getMarksUpdatedUpdateButton() {
		return marksUpdatedUpdateButton;
	}



	/**
	 * Create the dialog.
	 */
	public updateMarks() {
		setTitle("Update Marks");
		setBounds(100, 100, 549, 426);
		formPanel = new JPanel();
		setContentPane(formPanel);

		JLabel lblNewLabel = new JLabel("Marks:");

		marksUpdatedMarks = new JTextField();
		marksUpdatedMarks.setColumns(10);

		marksUpdatedUpdateButton = new JButton("Update");
		marksUpdatedUpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		marksUpdatedUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (marksUpdatedMarks.getText().isEmpty()) {
					lblNewLabel_6.setVisible(true);
				} else {
					lblNewLabel_6.setVisible(false);
				}
				
				

			}
		});
		SpringLayout sl_formPanel = new SpringLayout();
		sl_formPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -343, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, marksUpdatedUpdateButton, -115, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, marksUpdatedMarks, -334, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, marksUpdatedMarks, 133, SpringLayout.WEST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, marksUpdatedMarks);
		sl_formPanel.putConstraint(SpringLayout.EAST, marksUpdatedMarks, -53, SpringLayout.EAST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, marksUpdatedUpdateButton, 228, SpringLayout.WEST, formPanel);
		formPanel.setLayout(sl_formPanel);
		formPanel.add(lblNewLabel);
		formPanel.add(marksUpdatedUpdateButton);
		formPanel.add(marksUpdatedMarks);

		lblNewLabel_6 = new JLabel("Every Filed should be filled!!!");
		sl_formPanel.putConstraint(SpringLayout.NORTH, marksUpdatedMarks, 4, SpringLayout.SOUTH, lblNewLabel_6);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -363, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 158, SpringLayout.WEST, formPanel);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setVisible(false);
		formPanel.add(lblNewLabel_6);
	}
}
