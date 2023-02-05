/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.frontend;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.database.JDBC;
import com.mysql.cj.api.jdbc.Statement;
import com.mysql.cj.jdbc.PreparedStatement;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Diwash
 */
public class Student extends javax.swing.JFrame {

    public static DefaultTableModel assignmentDefaultTableModel = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Assignment Number", "Module Number", "Instructor Id", "Is Submitted"
        }
    );

    public static DefaultTableModel instructorDefaultTableModel = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Instructor Id", "Name", "Email", "Module ID", "Course ID"
        }
    );

    public static DefaultTableModel reportDefaultTableModel = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Course ID", "Module ID", "Marks"
        }
    );

    public static void showReportDataInTableFromDb(){
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT isGenerated FROM report WHERE Student_ID = '" + LoginPanel.id + "'";
            ResultSet resultSet = statement.executeQuery(query);
            // Check if report is generated or not with the first row of the result set
            resultSet.next();
            if (resultSet.getString("isGenerated").equals("0")) {
                JOptionPane.showMessageDialog(null, "Report is not generated yet");
            } else {
                query = "SELECT report.Course_ID, report.Module_code, report.Marks FROM report WHERE Student_ID = '" + LoginPanel.id + "'";
                resultSet = statement.executeQuery(query);

                while (resultSet.next()) {
                    String courseID = resultSet.getString("Course_ID");
                    String moduleCode = resultSet.getString("Module_code");
                    String marks = resultSet.getString("Marks");

                    reportDefaultTableModel.addRow(new Object[] {courseID, moduleCode, marks});
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showInstructorDataInTableFromDb(){
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT instructor.Instructor_ID, instructor.Name, instructor.Email_address, instructor_course.Course_ID, instructor_module.Module_code FROM instructor JOIN instructor_course ON instructor.Instructor_ID = instructor_course.Instructor_ID JOIN instructor_module ON instructor.Instructor_ID = instructor_module.Instructor_ID WHERE instructor_course.Course_ID = '" + LoginPanel.courseID + "'";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String instructorId = resultSet.getString("Instructor_ID");
                String instructorName = resultSet.getString("Name");
                String instructorEmail = resultSet.getString("Email_address");
                String instructorModule = resultSet.getString("Module_code");
                String instructorCourse = resultSet.getString("Course_ID");

                instructorDefaultTableModel.addRow(new Object[] {instructorId, instructorName, instructorEmail, instructorModule, instructorCourse});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void showAssignmentDataInTableFromDb() {
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT Assignment_Number, Module_code, Instructor_ID, Submitted FROM assignment WHERE Student_ID = '" + LoginPanel.id + "'";
            ResultSet resultSet = statement.executeQuery(query);

            System.out.println(LoginPanel.id);
            while (resultSet.next()) {
                String assignmentNumber = resultSet.getString("Assignment_Number");
                String moduleCode = resultSet.getString("Module_code");
                String instructorId = resultSet.getString("Instructor_ID");
                String isSubmitted = resultSet.getString("Submitted");

                assignmentDefaultTableModel.addRow(new Object[] {assignmentNumber, moduleCode, instructorId, isSubmitted});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Creates new form Student
     */
    public Student() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        studentNameTextField = new javax.swing.JTextField();
        studentAddressTextField = new javax.swing.JTextField();
        studentEmailTextField = new javax.swing.JTextField();
        studentCitizenshipTextField = new javax.swing.JTextField();
        studentCourseIdComboBox = new javax.swing.JComboBox<>();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        studentPhoneTextField = new javax.swing.JTextField();
        studentCollegeEmailTextField = new javax.swing.JTextField();
        addStudentButton = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        studentPasswordTextField = new javax.swing.JTextField();
        studentDobTextField = new javax.swing.JTextField();
        studentNameErrorMessage = new javax.swing.JLabel();
        studentNameErrorMessage.setVisible(false);
        studentAddressErrorMessage = new javax.swing.JLabel();
        studentAddressErrorMessage.setVisible(false);
        studentEmailErrorMessage = new javax.swing.JLabel();
        studentEmailErrorMessage.setVisible(false);
        studentCitizenshipErrorMessage = new javax.swing.JLabel();
        studentCitizenshipErrorMessage.setVisible(false);
        studentDobErrorMessage = new javax.swing.JLabel();
        studentDobErrorMessage.setVisible(false);
        studentPhoneNoErrorMessage = new javax.swing.JLabel();
        studentPhoneNoErrorMessage.setVisible(false);
        studentCollegeEmailErrorMessage = new javax.swing.JLabel();
        studentCollegeEmailErrorMessage.setVisible(false);
        studentPasswordErrorMessage = new javax.swing.JLabel();
        studentPasswordErrorMessage.setVisible(false);
        studentCourseErrorMessage = new javax.swing.JLabel();
        studentCourseErrorMessage.setVisible(false);
        jLabel12 = new javax.swing.JLabel();
        studentStudentIdTextField = new javax.swing.JTextField();
        studentStudentIdErrorMessage = new javax.swing.JLabel();
        studentStudentIdErrorMessage.setVisible(false);
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        instructorSearchTextField = new javax.swing.JTextField();
        refreshInstructorButton = new javax.swing.JButton();
        searchInstructorButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                // Ask user weather he have submitted assignment on canvas or not
                int dialogResult = JOptionPane.showConfirmDialog(null, "Have you submitted assignment on canvas?", "Warning", JOptionPane.YES_NO_OPTION);
                if (dialogResult == JOptionPane.YES_OPTION) {
                    Statement statement = JDBC.getStatement();
                    // If yes then update the database
                    int row = jTable1.getSelectedRow();
                    String assignmentNumber = jTable1.getModel().getValueAt(row, 0).toString();
                    try {
                        String query = "UPDATE assignment SET Submitted = 'yes' WHERE Student_ID = '" + LoginPanel.id + "' AND Assignment_number = '" + assignmentNumber + "'";
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Assignment submitted successfully");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    int row = jTable1.getSelectedRow();
                    String assignmentNumber = jTable1.getModel().getValueAt(row, 0).toString();
                    try {
                        Statement statement = JDBC.getStatement();
                        String query = "UPDATE assignment SET Submitted = 'no' WHERE Student_ID = '" + LoginPanel.id + "' AND Assignment_number = '" + assignmentNumber + "'";
                        statement.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "Assignment submitted successfully");
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                }
        	}
        });
        jPanel12 = new javax.swing.JPanel();
        instructorLogoutButton = new javax.swing.JToggleButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jPanel22 = new javax.swing.JPanel();
        jToggleButton6 = new javax.swing.JToggleButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        jToggleButton8 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));

        jPanel2.setBackground(new java.awt.Color(255, 36, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Student");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(379, 379, 379))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.setBackground(new java.awt.Color(54, 54, 54));
        jTabbedPane1.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jTabbedPane1.setName(""); // NOI18N

        jPanel6.setBackground(new java.awt.Color(29, 29, 29));

        jPanel7.setBackground(new java.awt.Color(23, 23, 23));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("Name:");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("Address:");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("Email:");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("Citizenship Number:");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("DOB:");

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Course ID:");

        studentNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentNameTextFieldActionPerformed(evt);
            }
        });

        Statement statement = JDBC.getStatement();
        String query1 = "SELECT Course_ID FROM courses";
        ResultSet resultSet1 = null;
        try {
        resultSet1 = statement.executeQuery(query1);
        } catch (SQLException e) {
        e.printStackTrace();
        }
        List<String> courseIds = new ArrayList<>();
        courseIds.add("Select Course");
        try {
        while (resultSet1.next()) {
        try {
        courseIds.add(resultSet1.getString("Course_ID"));
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        String[] courseIdArray = courseIds.toArray(new String[0]);
        
        studentCourseIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(courseIdArray));
        studentCourseIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentCourseIdComboBoxActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("Phone Number:");

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("College Email:");

        addStudentButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        addStudentButton.setText("Register");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Password:");

        studentDobTextField.setText("DD/MM/YYYY");
        studentDobTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentDobTextFieldActionPerformed(evt);
            }
        });

        studentNameErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentNameErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentNameErrorMessage.setText("Name cannot be empty!!");

        studentAddressErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentAddressErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentAddressErrorMessage.setText("Address cannot be empty!!");

        studentEmailErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentEmailErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentEmailErrorMessage.setText("Email cannot be empty!!");

        studentCitizenshipErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentCitizenshipErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentCitizenshipErrorMessage.setText("Citizenship number cannot be empty!!");

        studentDobErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentDobErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentDobErrorMessage.setText("Date of Birth cannot be empty!!");

        studentPhoneNoErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentPhoneNoErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentPhoneNoErrorMessage.setText("Phone number cannot be empty!!");

        studentCollegeEmailErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentCollegeEmailErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentCollegeEmailErrorMessage.setText("College Email cannot be empty!!");

        studentPasswordErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentPasswordErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentPasswordErrorMessage.setText("Password cannot be empty!!");

        studentCourseErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentCourseErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentCourseErrorMessage.setText("Course ID cannot be empty!!");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Student ID:");

        studentStudentIdErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        studentStudentIdErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        studentStudentIdErrorMessage.setText("Student ID cannot be empty!!");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel43)
                            .addComponent(jLabel42)
                            .addComponent(jLabel41)
                            .addComponent(jLabel40))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(studentNameTextField)
                            .addComponent(studentAddressTextField)
                            .addComponent(studentEmailTextField)
                            .addComponent(studentCitizenshipTextField)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentCitizenshipErrorMessage)
                                    .addComponent(studentNameErrorMessage)
                                    .addComponent(studentAddressErrorMessage)
                                    .addComponent(studentEmailErrorMessage))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabel45)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(studentDobErrorMessage)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(studentDobTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel49)
                            .addComponent(jLabel50)
                            .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(studentCollegeEmailErrorMessage)
                                    .addComponent(studentPasswordErrorMessage)
                                    .addComponent(studentCourseErrorMessage)
                                    .addComponent(studentStudentIdErrorMessage))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(studentCollegeEmailTextField)
                            .addComponent(studentPasswordTextField)
                            .addComponent(studentCourseIdComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentStudentIdTextField)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(studentPhoneNoErrorMessage)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(studentPhoneTextField))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 741, Short.MAX_VALUE)
                .addComponent(addStudentButton)
                .addGap(687, 687, 687))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(studentNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentNameErrorMessage)
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(studentAddressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(studentAddressErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel42)
                    .addComponent(studentEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(studentEmailErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(studentCitizenshipTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(studentCitizenshipErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(studentDobTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentDobErrorMessage)
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(studentPhoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentPhoneNoErrorMessage)
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel49)
                    .addComponent(studentCollegeEmailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(studentCollegeEmailErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel50)
                    .addComponent(studentPasswordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentPasswordErrorMessage)
                .addGap(7, 7, 7)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentCourseIdComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentCourseErrorMessage)
                .addGap(9, 9, 9)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentStudentIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(studentStudentIdErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addStudentButton)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Register", jPanel6);

        jPanel3.setBackground(new java.awt.Color(29, 29, 29));

        jPanel5.setBackground(new java.awt.Color(23, 23, 23));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel11.setBackground(new java.awt.Color(23, 23, 23));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Search Assignment:");

        instructorSearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorSearchTextFieldActionPerformed(evt);
            }
        });

        refreshInstructorButton.setBackground(new java.awt.Color(23, 23, 23));
        refreshInstructorButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        refreshInstructorButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshInstructorButton.setText("Refresh");
        refreshInstructorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshInstructorButtonActionPerformed(evt);
            }
        });

        searchInstructorButton.setBackground(new java.awt.Color(23, 23, 23));
        searchInstructorButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchInstructorButton.setForeground(new java.awt.Color(255, 255, 255));
        searchInstructorButton.setText("Search");
        searchInstructorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchInstructorButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorSearchTextField)
                .addGap(18, 18, 18)
                .addComponent(searchInstructorButton)
                .addGap(44, 44, 44)
                .addComponent(refreshInstructorButton)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(instructorSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchInstructorButton)
                    .addComponent(refreshInstructorButton))
                .addGap(27, 27, 27))
        );

        jTable1.setModel(assignmentDefaultTableModel);
        jScrollPane1.setViewportView(jTable1);

        jPanel12.setBackground(new java.awt.Color(23, 23, 23));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        instructorLogoutButton.setBackground(new java.awt.Color(23, 23, 23));
        instructorLogoutButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        instructorLogoutButton.setForeground(new java.awt.Color(255, 255, 255));
        instructorLogoutButton.setText("Log Out");
        instructorLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorLogoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(707, Short.MAX_VALUE)
                .addComponent(instructorLogoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(685, 685, 685))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addComponent(instructorLogoutButton)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assignment", jPanel3);

        jPanel18.setBackground(new java.awt.Color(29, 29, 29));

        jPanel20.setBackground(new java.awt.Color(23, 23, 23));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel21.setBackground(new java.awt.Color(23, 23, 23));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Search Instructor:");

        jTextField29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField29ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(23, 23, 23));
        jButton11.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("Refresh");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setBackground(new java.awt.Color(23, 23, 23));
        jButton12.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Search");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField29)
                .addGap(18, 18, 18)
                .addComponent(jButton12)
                .addGap(42, 42, 42)
                .addComponent(jButton11)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jTextField29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12)
                    .addComponent(jButton11))
                .addGap(27, 27, 27))
        );

        jTable3.setModel(instructorDefaultTableModel);
        jScrollPane3.setViewportView(jTable3);

        jPanel22.setBackground(new java.awt.Color(23, 23, 23));
        jPanel22.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jToggleButton6.setBackground(new java.awt.Color(23, 23, 23));
        jToggleButton6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jToggleButton6.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton6.setText("Log Out");
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(708, Short.MAX_VALUE)
                .addComponent(jToggleButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(684, 684, 684))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addComponent(jToggleButton6)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3)
                    .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Instructor", jPanel18);

        jPanel23.setBackground(new java.awt.Color(29, 29, 29));

        jPanel25.setBackground(new java.awt.Color(23, 23, 23));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel26.setBackground(new java.awt.Color(23, 23, 23));
        jPanel26.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel51.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("Search Student:");

        jTextField38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField38ActionPerformed(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(23, 23, 23));
        jButton15.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("Refresh");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setBackground(new java.awt.Color(23, 23, 23));
        jButton16.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("Search");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField38)
                .addGap(18, 18, 18)
                .addComponent(jButton16)
                .addGap(33, 33, 33)
                .addComponent(jButton15)
                .addContainerGap())
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16)
                    .addComponent(jButton15))
                .addGap(27, 27, 27))
        );

        jTable4.setModel(reportDefaultTableModel);
        jScrollPane4.setViewportView(jTable4);

        jPanel27.setBackground(new java.awt.Color(23, 23, 23));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jToggleButton8.setBackground(new java.awt.Color(23, 23, 23));
        jToggleButton8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jToggleButton8.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton8.setText("Log Out");
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(746, Short.MAX_VALUE)
                .addComponent(jToggleButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(646, 646, 646))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jToggleButton8)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addComponent(jPanel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel27, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Report", jPanel23);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1535, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 702, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void instructorSearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                          
        // TODO add your handling code here:
    }                                                         

    private void refreshInstructorButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    	// clear the table first
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);
            showAssignmentDataInTableFromDb();
    }                                                       

    private void instructorLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    private void studentNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
    }                                                    

    private void studentCourseIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        // TODO add your handling code here:
    }                                                       

    private void addStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        if (studentNameTextField.getText().isEmpty() || studentAddressTextField.getText().isEmpty() || studentDobTextField.getText().contentEquals("DD/MM/YYYY") || studentEmailTextField.getText().isEmpty() || studentPasswordTextField.getText().isEmpty() || (String) studentCourseIdComboBox.getSelectedItem() == "Select Course" || studentCitizenshipTextField.getText().isEmpty() || studentCollegeEmailTextField.getText().isEmpty() || studentStudentIdTextField.getText().isEmpty()) {
            if(studentNameTextField.getText().isEmpty()) {
                studentNameErrorMessage.setVisible(true);
            } else {
                studentNameErrorMessage.setVisible(false);
            }
            if (studentAddressTextField.getText().isEmpty()) {
                studentAddressErrorMessage.setVisible(true);
            } else {
                studentAddressErrorMessage.setVisible(false);
            }
            if (studentDobTextField.getText().contentEquals("DD/MM/YYYY")) {
                studentDobErrorMessage.setVisible(true);
            } else {
                studentDobErrorMessage.setVisible(false);
            }
            if (studentEmailTextField.getText().isEmpty()) {
                studentEmailErrorMessage.setVisible(true);
            } else {
                studentEmailErrorMessage.setVisible(false);
            }
            if (studentPasswordTextField.getText().isEmpty()) {
                studentPasswordErrorMessage.setVisible(true);
            } else {
                studentPasswordErrorMessage.setVisible(false);
            }
            if ((String) studentCourseIdComboBox.getSelectedItem() == "Select Course") {
                studentCourseErrorMessage.setVisible(true);
            } else {
                studentCourseErrorMessage.setVisible(false);
            }
            if (studentCitizenshipTextField.getText().isEmpty()) {
                studentCitizenshipErrorMessage.setVisible(true);
            } else {
                studentCitizenshipErrorMessage.setVisible(false);
            }
            if (studentCollegeEmailTextField.getText().isEmpty()) {
                studentCollegeEmailErrorMessage.setVisible(true);
            } else {
                studentCollegeEmailErrorMessage.setVisible(false);
            }
            if (studentStudentIdTextField.getText().isEmpty()) {
                studentStudentIdErrorMessage.setVisible(true);
            } else {
                studentStudentIdErrorMessage.setVisible(false);
            }



        } else {
    	
            studentName = studentNameTextField.getText().trim();
            studentAddress = studentAddressTextField.getText().trim();
            studentDob = studentDobTextField.getText().trim();
            studentEmail = studentEmailTextField.getText().trim();
            studentPassword = studentPasswordTextField.getText().trim();
            studentCourseId = (String) studentCourseIdComboBox.getSelectedItem();
            studentCitizenshipNo = studentCitizenshipTextField.getText().trim();
            studentCollegeEmail = studentCollegeEmailTextField.getText().trim();
            studentId = studentStudentIdTextField.getText().trim();
            studentCourseId = (String) studentCourseIdComboBox.getSelectedItem();

            String checkQuery = "SELECT * FROM student WHERE Student_ID = '" + studentId +"'";

            // Checking if student already exists in the database then display error message else display student added message
            Statement statement = JDBC.getStatement();
            try {
                ResultSet checkResult = statement.executeQuery(checkQuery);
                if (checkResult.next()) {
                    JOptionPane.showMessageDialog(null, "Student already exists in the database", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String insertQuery1 = "INSERT INTO student (Student_ID, Name, Address, DOB, Citizenship_Number, Email_address, College_email_address, College_email_address_password, Course_ID) VALUES ('" + studentId +"', '" + studentName +"', '" + studentAddress +"', '" + studentDob +"', '" + studentCitizenshipNo +"', '" + studentEmail +"', '" + studentCollegeEmail +"', '" + studentPassword +"', '" + studentCourseId +"')";
                    String insertQuery2 = "INSERT INTO student_course (Student_ID, Course_ID) VALUES ('" + studentId +"', '" + studentCourseId +"')";
                        
                    try {
                        int insertSuccess1 = statement.executeUpdate(insertQuery1);
                        int insertSuccess2 = statement.executeUpdate(insertQuery2);

                        String getModuleCodeQuery = "SELECT module_code FROM module WHERE course_id = '" + studentCourseId +"'";
                    ResultSet resultSet = null;
                    try {
                        resultSet = statement.executeQuery(getModuleCodeQuery);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    ArrayList<String> moduleCodeList = new ArrayList<>();
                    try {
                        while (resultSet.next()) {
                            moduleCodeList.add(resultSet.getString("module_code"));
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    for (String moduleCode : moduleCodeList) {
                        String insertQuery4 = "INSERT INTO student_module (Student_ID, Module_Code, Course_ID) VALUES ('" + studentId +"', '" + moduleCode +"', '" + studentCourseId +"')";
                        try {
                            statement.executeUpdate(insertQuery4);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    for (String moduleCode : moduleCodeList){
                        String insertQuery5 = "INSERT INTO marks (Student_ID, Module_Code, Course_ID, Marks) VALUES ('" + studentId +"', '" + moduleCode +"', '" + studentCourseId +"', NULL)";
                        try {
                            statement.executeUpdate(insertQuery5);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }

                    for (String moduleCode : moduleCodeList) {
                        String insertQuery3 = "INSERT INTO report (Student_ID, Module_Code, Course_ID, Marks) VALUES ('" + studentId +"', '" + moduleCode +"', '" + studentCourseId +"', NULL)";
                        try {
                            statement.executeUpdate(insertQuery3);
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    }   


                        if (insertSuccess1 == 1 && insertSuccess2 == 1) {
                            JOptionPane.showMessageDialog(jPanel1, "Student added successfully");
                        } else {
                            JOptionPane.showMessageDialog(jPanel1, "Student not added");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }        
    }
    }                                                

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        showInstructorDataInTableFromDb();
    }                                         

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
    }                                            

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    }                                         

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    }                                              

    private void studentDobTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
    }                                                   

    private void searchInstructorButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        // TODO add your handling code here:
    }                                                      

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton addStudentButton;
    private javax.swing.JToggleButton instructorLogoutButton;
    private javax.swing.JTextField instructorSearchTextField;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JButton refreshInstructorButton;
    private javax.swing.JButton searchInstructorButton;
    private javax.swing.JLabel studentAddressErrorMessage;
    private javax.swing.JTextField studentAddressTextField;
    private javax.swing.JLabel studentCitizenshipErrorMessage;
    private javax.swing.JTextField studentCitizenshipTextField;
    private javax.swing.JLabel studentCollegeEmailErrorMessage;
    private javax.swing.JTextField studentCollegeEmailTextField;
    private javax.swing.JLabel studentCourseErrorMessage;
    private javax.swing.JComboBox<String> studentCourseIdComboBox;
    private javax.swing.JLabel studentDobErrorMessage;
    private javax.swing.JTextField studentDobTextField;
    private javax.swing.JLabel studentEmailErrorMessage;
    private javax.swing.JTextField studentEmailTextField;
    private javax.swing.JLabel studentNameErrorMessage;
    private javax.swing.JTextField studentNameTextField;
    private javax.swing.JLabel studentPasswordErrorMessage;
    private javax.swing.JTextField studentPasswordTextField;
    private javax.swing.JLabel studentPhoneNoErrorMessage;
    private javax.swing.JTextField studentPhoneTextField;
    private javax.swing.JLabel studentStudentIdErrorMessage;
    private javax.swing.JTextField studentStudentIdTextField;
    // End of variables declaration    
    
        // Students
        private String studentName = "";
        private String studentAddress = "";
        private String studentEmail = "";
        private String studentCitizenshipNo = "";
        private String studentDob = "";
        private String studentCollegeEmail = "";
        private String studentPassword = "";
        private String studentCourseId = "";
        private String studentId = "";
}
