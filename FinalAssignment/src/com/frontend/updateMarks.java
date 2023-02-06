package com.frontend;



import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.ButtonGroup;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;





public class updateMarks extends JDialog {
	private JPanel formPanel;
	private JTextField marksUpdatedMarks;
	private JLabel lblNewLabel_6;
	private JButton marksUpdatedUpdateButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	
	// Getter
	public JTextField getMarksUpdatedMarks() {
		return marksUpdatedMarks;
	}

	public JButton getMarksUpdatedUpdateButton() {
		return marksUpdatedUpdateButton;
	}



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

				// Checking if the marks field is empty
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
