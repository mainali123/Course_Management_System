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



public class updateCourses extends JDialog {
	private JPanel formPanel;
	private JLabel lblNewLabel_1;
	private JTextField coursesUpdatedCourseId;
	private JTextField coursesUpdatedCourseName;
	private JLabel lblNewLabel_6;
	private JButton coursesUpdatedUpdateButton;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel courseIdAlreadyExistErrorMessage;

	// Getter
	public JTextField getCoursesUpdatedCourseId() {
		return coursesUpdatedCourseId;
	}

	public JTextField getCoursesUpdatedCourseName() {
		return coursesUpdatedCourseName;
	}

	public JButton getCoursesUpdatedUpdateButton() {
		return coursesUpdatedUpdateButton;
	}

	public JLabel getCourseIdAlreadyExistErrorMessage() {
		return courseIdAlreadyExistErrorMessage;
	}


	public updateCourses() {
		setTitle("Update Course");	
		setBounds(100, 100, 549, 426);
		formPanel = new JPanel();
		setContentPane(formPanel);

		JLabel lblNewLabel = new JLabel("Course Name:");

		coursesUpdatedCourseName = new JTextField();
		coursesUpdatedCourseName.setColumns(10);

		coursesUpdatedUpdateButton = new JButton("Update");
		coursesUpdatedUpdateButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		coursesUpdatedUpdateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// Checking if the fields are empty
				if (coursesUpdatedCourseName.getText().isEmpty() || coursesUpdatedCourseId.getText().isEmpty()
						) {
					lblNewLabel_6.setVisible(true);
				} else {
					lblNewLabel_6.setVisible(false);
				}
			}
		});

		lblNewLabel_1 = new JLabel("Course ID:");

		coursesUpdatedCourseId = new JTextField();
		coursesUpdatedCourseId.setColumns(10);
		SpringLayout sl_formPanel = new SpringLayout();
		sl_formPanel.putConstraint(SpringLayout.NORTH, coursesUpdatedUpdateButton, 105, SpringLayout.SOUTH, coursesUpdatedCourseId);
		sl_formPanel.putConstraint(SpringLayout.EAST, coursesUpdatedUpdateButton, -224, SpringLayout.EAST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel, -343, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 60, SpringLayout.SOUTH, lblNewLabel);
		sl_formPanel.putConstraint(SpringLayout.NORTH, coursesUpdatedCourseId, 42, SpringLayout.SOUTH, coursesUpdatedCourseName);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, coursesUpdatedCourseId, 67, SpringLayout.SOUTH, coursesUpdatedCourseName);
		sl_formPanel.putConstraint(SpringLayout.WEST, coursesUpdatedCourseName, 111, SpringLayout.WEST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel, -6, SpringLayout.WEST, coursesUpdatedCourseName);
		sl_formPanel.putConstraint(SpringLayout.EAST, lblNewLabel_1, 0, SpringLayout.EAST, lblNewLabel);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, coursesUpdatedCourseName, -334, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.EAST, coursesUpdatedCourseName, -53, SpringLayout.EAST, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, coursesUpdatedCourseId, 0, SpringLayout.WEST, coursesUpdatedCourseName);
		sl_formPanel.putConstraint(SpringLayout.EAST, coursesUpdatedCourseId, -53, SpringLayout.EAST, formPanel);
		formPanel.setLayout(sl_formPanel);
		formPanel.add(lblNewLabel_1);
		formPanel.add(lblNewLabel);
		formPanel.add(coursesUpdatedCourseId);
		formPanel.add(coursesUpdatedUpdateButton);
		formPanel.add(coursesUpdatedCourseName);

		lblNewLabel_6 = new JLabel("Every Filed should be filled!!!");
		sl_formPanel.putConstraint(SpringLayout.NORTH, coursesUpdatedCourseName, 4, SpringLayout.SOUTH, lblNewLabel_6);
		sl_formPanel.putConstraint(SpringLayout.SOUTH, lblNewLabel_6, -363, SpringLayout.SOUTH, formPanel);
		sl_formPanel.putConstraint(SpringLayout.WEST, lblNewLabel_6, 158, SpringLayout.WEST, formPanel);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setVisible(false);
		formPanel.add(lblNewLabel_6);
		
		courseIdAlreadyExistErrorMessage = new JLabel("Course ID Already Exists!!!");
		courseIdAlreadyExistErrorMessage.setVisible(false);
		courseIdAlreadyExistErrorMessage.setFont(new Font("Tahoma", Font.BOLD, 13));
		courseIdAlreadyExistErrorMessage.setForeground(new Color(255, 0, 0));
		sl_formPanel.putConstraint(SpringLayout.NORTH, courseIdAlreadyExistErrorMessage, 6, SpringLayout.SOUTH, coursesUpdatedCourseId);
		sl_formPanel.putConstraint(SpringLayout.WEST, courseIdAlreadyExistErrorMessage, 10, SpringLayout.WEST, coursesUpdatedCourseId);
		formPanel.add(courseIdAlreadyExistErrorMessage);
	}
}
