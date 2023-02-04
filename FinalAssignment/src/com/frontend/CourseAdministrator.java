package com.frontend;
/*
 * login email = diwash@mainali.com
 * login password = diwash
 */
// Importing all the required packages
import java.sql.*;
import java.util.*;
import java.util.List;

import com.database.JDBC;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;


/**
 *
 * @author Diwash
 */




public class CourseAdministrator extends javax.swing.JFrame {   // Course Administrator class 

    private static DefaultTableModel instructorDefaultTableModel = new javax.swing.table.DefaultTableModel( // Creating a table model for instructor table 
        new Object [][] {

        },
        new String [] {
            "S.N", "Name", "Address", "Years of Experience", "Citizenship Number", "PAN Number", "DOB", "Email", "Password", "Module ID", "Course ID"
        }
    );

    private static DefaultTableModel studentDefaultTableModel = new DefaultTableModel(  // Creating a table model for student table
        new Object[][] {
        },
        new String[] {
            "Student ID", "Name", "Address", "Email", "Citizenship Number", "DOB", "College Email", "Password", "Course ID"
        }
    );

    private static DefaultTableModel courseDefaultTableModel = new javax.swing.table.DefaultTableModel( // Creating a table model for course table
        new Object [][] {

        },
        new String [] {
            "Course ID", "Course Name"
        }
    );

    private static DefaultTableModel moduleDefaultTableModel = new javax.swing.table.DefaultTableModel( // Creating a table model for module table
        new Object [][] {

        },
        new String [] {
            "Module Code", "Module Name", "Course_ID"
        }
    );

    private static DefaultTableModel reportDefaultTableModel = new javax.swing.table.DefaultTableModel( // Creating a table model for report table
        new Object [][] {

        },
        new String [] {
            "Student ID", "Name", "Email", "Course_ID"
        }
    );

    private static DefaultTableModel studentDetailsDefaultTableModel = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Student ID", "Name", "Email", "Address", "Citizenship Number", "DOB", "Course_ID"
        }
    );


    public static void showDataInTableFromDb(){ // Method to show data in table from database 
        Statement statement = JDBC.getStatement();  // Creating a statement object to execute the query

    try {
        String joinQuery = "SELECT instructor.*, instructor_module.* " + 
                           "FROM instructor " + 
                           "INNER JOIN instructor_module " + 
                           "ON instructor.Instructor_ID = instructor_module.Instructor_ID";
    
        ResultSet result = statement.executeQuery(joinQuery);   // Executing the query
        
        while (result.next()) {
            String instructorIdFromDb = result.getString("Instructor.Instructor_ID");   // Getting the data from the database
            String instructorNameFromDb = result.getString("Instructor.Name");
            String instructorAddressFromDb = result.getString("Instructor.Address");
            String instructorExperienceFromDb = result.getString("Instructor.Year_of_experience");
            String instructorCitizenshipFromDb = result.getString("Instructor.Citizenship_Number");
            String instructorPanFromDb = result.getString("Instructor.Pan_number");
            String instructorDobFromDb = result.getString("Instructor.DOB");
            String instructorEmailFromDb = result.getString("Instructor.Email_address");
            String instructorPasswordFromDb = result.getString("Instructor.Password");
    
            String instructorModuleCodeFromDb = result.getString("instructor_module.Module_code");
            String instructorCourseIdFromDb = result.getString("instructor_module.Course_ID");
    
            instructorDefaultTableModel.addRow(new Object[]{instructorIdFromDb, instructorNameFromDb, instructorAddressFromDb, instructorExperienceFromDb, instructorCitizenshipFromDb, instructorPanFromDb, instructorDobFromDb, instructorEmailFromDb, instructorPasswordFromDb, instructorModuleCodeFromDb, instructorCourseIdFromDb});  // Adding the data to the table
        }
        result.close(); // Closing the result set
    } catch (SQLException e) {
        e.printStackTrace();    // Printing the error
    }
    }    

    public static void showStudentDataInTableFromDb(){
        Statement statement = JDBC.getStatement();

        
        try {
            String query = "SELECT * FROM student";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String studentIdFromDb = result.getString("Student_ID");
                String studentNameFromDb = result.getString("Name");
                String studentAddressFromDb = result.getString("Address");
                String studentDobFromDb = result.getString("DOB");
                String studentCitizenshipFromDb = result.getString("Citizenship_Number");
                String studentEmailFromDb = result.getString("Email_address");
                String studentCollegeEmailFromDb = result.getString("College_email_address");
                String studentPasswordFromDb = result.getString("College_email_address_password");
                String studentCourseIdFromDb = result.getString("Course_ID");

                studentDefaultTableModel.addRow(new Object[]{studentIdFromDb, studentNameFromDb, studentAddressFromDb, studentEmailFromDb, studentCitizenshipFromDb, studentDobFromDb, studentCollegeEmailFromDb, studentPasswordFromDb, studentCourseIdFromDb});

            }
    } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void showCoursesDataInTableFromDb(){
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT * FROM courses";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String courseIdFromDb = result.getString("Course_ID");
                String courseNameFromDb = result.getString("Course_name");

                courseDefaultTableModel.addRow(new Object[]{courseIdFromDb, courseNameFromDb});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showModulesDataInTableFromDb(){
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT * FROM module";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String moduleIdFromDb = result.getString("Module_code");
                String moduleNameFromDb = result.getString("Module_name");
                String moduleCourseFromDb = result.getString("Course_ID");

                moduleDefaultTableModel.addRow(new Object[]{moduleIdFromDb, moduleNameFromDb, moduleCourseFromDb});
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void showReportDataInTableFromDb(){
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT Student_ID, Name, Email_address, Course_ID FROM student";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
                String studentIdFromDb = result.getString("Student_ID");
                String studentNameFromDb = result.getString("Name");
                String studentEmailFromDb = result.getString("Email_address");
                String studentCourseIdFromDb = result.getString("Course_ID");

                reportDefaultTableModel.addRow(new Object[]{studentIdFromDb, studentNameFromDb, studentEmailFromDb, studentCourseIdFromDb});
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void showStudentDetailsDataInTableFromDb(){
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT * FROM student";
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {
            String studentIdFromDb = result.getString("Student_ID");
            String studentNameFromDb = result.getString("Name");
            String studentAddressFromDb = result.getString("Address");
            String studentDobFromDb = result.getString("DOB");
            String studentCitizenshipFromDb = result.getString("Citizenship_Number");
            String studentEmailFromDb = result.getString("Email_address");
            String studentCourseIdFromDb = result.getString("Course_ID");

            studentDetailsDefaultTableModel.addRow(new Object[]{studentIdFromDb, studentNameFromDb, studentEmailFromDb, studentAddressFromDb,  studentCitizenshipFromDb, studentDobFromDb, studentCourseIdFromDb});
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    /**
     * Creates new form CourseAdministrator
     */
    public CourseAdministrator() {
        initComponents(); 
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        instructorNameTextField = new javax.swing.JTextField();
        instructorAddressTextField = new javax.swing.JTextField();
        instructorExperienceTextField = new javax.swing.JTextField();
        instructorCitizenshipTextField = new javax.swing.JTextField();
        instructorPanTextField = new javax.swing.JTextField();
        instructorModule_1ComboBox = new javax.swing.JComboBox<>();
        instructorCourseIdComboBox = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        instructorPhoneTextField = new javax.swing.JTextField();
        instructorEmailTextField = new javax.swing.JTextField();
        addInstructorButton = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        instructorPasswordTextField = new javax.swing.JTextField();
        instructorDobTextField = new javax.swing.JTextField();
        instructorNameErrorMessage = new javax.swing.JLabel();
        instructorNameErrorMessage.setVisible(false);
        instructorAddressErrorMessage = new javax.swing.JLabel();
        instructorAddressErrorMessage.setVisible(false);
        instructorExperienceErrorMessage = new javax.swing.JLabel();
        instructorExperienceErrorMessage.setVisible(false);
        instructorCitizenshipErrorMessage = new javax.swing.JLabel();
        instructorCitizenshipErrorMessage.setVisible(false);
        instructorPanErrorMessage = new javax.swing.JLabel();
        instructorPanErrorMessage.setVisible(false);
        instructorDobErrorMessage = new javax.swing.JLabel();
        instructorDobErrorMessage.setVisible(false);
        instructorPhoneNoErrorMessage = new javax.swing.JLabel();
        instructorPhoneNoErrorMessage.setVisible(false);
        instructorEmailErrorMessage = new javax.swing.JLabel();
        instructorEmailErrorMessage.setVisible(false);
        instructorPasswordErrorMessage = new javax.swing.JLabel();
        instructorPasswordErrorMessage.setVisible(false);
        instructorModuleErrorMessage = new javax.swing.JLabel();
        instructorModuleErrorMessage.setVisible(false);
        jPanel5 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        instructorSearchTextField = new javax.swing.JTextField();
        refreshInstructorButton = new javax.swing.JButton();
        searchInstructorButton = new javax.swing.JButton();
        searchInstructorButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                
                String instructorSearchValue = instructorSearchTextField.getText(); // Get the search value from the text field 
                
                instructorDefaultTableModel.setRowCount(0); // Clear the table before adding new data

                try {
                    String joinQuery = "SELECT instructor.* " + 
                                       "FROM instructor " + 
                                       "WHERE instructor.name LIKE '%" + instructorSearchValue + "%'";  // Search query 
                    Statement statement = JDBC.getStatement();
                    ResultSet rs = statement.executeQuery(joinQuery);
    
                    while (rs.next()) {
                        String id = rs.getString("Instructor_ID");
                        String name = rs.getString("Name");
                        String address = rs.getString("Address");
                        String experience = rs.getString("Year_of_experience");
                        String citNo = rs.getString("Citizenship_Number");
                        String panNo = rs.getString("Pan_number");
                        String dob = rs.getString("DOB");
                        String email = rs.getString("Email_address");
                        String pass = rs.getString("Password");
    
                        Object[] row = {id, name, address, experience, citNo, panNo, dob, email, pass}; 
                        instructorDefaultTableModel.addRow(row);    // Add the row to the table
                    }
                } catch (Exception ex) {
                    System.out.println(ex);
                }

        	}
        });
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTable1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {    // When a row is clicked
                Object[] options = {"Update", "Delete"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to update or delete the selected instructor?", "Update or Delete Instructor", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        	
                if (n == 0) {   // Update
                    var updateInstructor = new updateInstructor();
                    updateInstructor.setVisible(true);
                    JButton updateButton = updateInstructor.getInstructorUpdatedUpdateButton();

                    String previousID1 = "";
                    
                    String previousName = "";
                    String previousAddress = "";
                    String previousExperience = "";
                    String previousCitizenship = "";
                    String previousPan = "";
                    String previousDob = "";
                    String previousEmail = "";
                    String previousPassword = "";


                    for (int columnIndex=0; columnIndex < jTable1.getColumnCount(); columnIndex++) {
                        if (previousID1.isEmpty()){
                            previousID1 = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousName.isEmpty()){
                            previousName = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousAddress.isEmpty()){
                            previousAddress = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousExperience.isEmpty()){
                            previousExperience = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousCitizenship.isEmpty()){
                            previousCitizenship = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousPan.isEmpty()){
                            previousPan = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousDob.isEmpty()){
                            previousDob = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousEmail.isEmpty()){
                            previousEmail = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        } else if(previousPassword.isEmpty()){
                            previousPassword = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        }

                    }
                    final String previousID = previousID1;

                    updateInstructor.getInstructorUpdatedName().setText(previousName);
                    updateInstructor.getInstructorUpdatedAddress().setText(previousAddress);
                    updateInstructor.getInstructorUpdatedExperience().setText(previousExperience);
                    updateInstructor.getInstructorUpdatedCitizenshipNo().setText(previousCitizenship);
                    updateInstructor.getInstructorUpdatedPanNo().setText(previousPan);
                    updateInstructor.getInstructorUpdatedDob().setText(previousDob);
                    updateInstructor.getInstructorUpdatedEmail().setText(previousEmail);
                    updateInstructor.getInstructorUpdatedPassword().setText(previousPassword);
                    


                    updateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String updatedName = updateInstructor.getInstructorUpdatedName().getText();
                            String updatedAddress = updateInstructor.getInstructorUpdatedAddress().getText();
                            String updatedExperience = updateInstructor.getInstructorUpdatedExperience().getText();
                            String updatedCitizenship = updateInstructor.getInstructorUpdatedCitizenshipNo().getText();
                            String updatedPan = updateInstructor.getInstructorUpdatedPanNo().getText();
                            String updatedDob = updateInstructor.getInstructorUpdatedDob().getText();
                            String updatedEmail = updateInstructor.getInstructorUpdatedEmail().getText();
                            String updatedPassword = updateInstructor.getInstructorUpdatedPassword().getText();

                            try {
                                String updateQuery = "UPDATE instructor SET Name = '" + updatedName + "', Address = '" + updatedAddress + "', Year_of_experience = '" + updatedExperience + "', Citizenship_Number = '" + updatedCitizenship + "', Pan_number = '" + updatedPan + "', DOB = '" + updatedDob + "', Email_address = '" + updatedEmail + "', Password = '" + updatedPassword + "' WHERE Instructor_ID = '" + previousID + "'";
                                Statement statement = JDBC.getStatement();
                                statement.executeUpdate(updateQuery);
                                JOptionPane.showMessageDialog(null, "Data is updated");
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    
                } else {    // Delete

                    String Id = "";
                    for (int columnIndex=0; columnIndex < jTable1.getColumnCount(); columnIndex++) {
                        if (Id.isEmpty()){
                            Id = jTable1.getValueAt(jTable1.getSelectedRow(), columnIndex).toString();
                        }
                    }

                    Statement statement = JDBC.getStatement();
                    String deleteQuery1 = "DELETE FROM instructor_module WHERE Instructor_ID = '" + Id + "'";
                    String deleteQuery2 = "DELETE FROM instructor_course WHERE Instructor_ID = '" + Id + "'";
                    String deleteQuery3 = "DELETE FROM instructor WHERE Instructor_ID = '" + Id + "'";

                    try {
                        statement.executeUpdate(deleteQuery1);
                        statement.executeUpdate(deleteQuery2);
                        statement.executeUpdate(deleteQuery3);
                        JOptionPane.showMessageDialog(null, "Data is deleted");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        jTable1.setDefaultEditor(Object.class, null);
        jPanel12 = new javax.swing.JPanel();
        instructorLogoutButton = new javax.swing.JToggleButton();
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
        jLabel49 = new javax.swing.JLabel();
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
        jPanel8 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        studentSearchTextField = new javax.swing.JTextField();
        refreshStudentButton = new javax.swing.JButton();
        searchStudentButton = new javax.swing.JButton();
        searchStudentButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                
        	}
        });
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable6 = new javax.swing.JTable();

        jTable6.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                Object[] options = {"Update", "Delete"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to update or delete the selected student?", "Update or Delete Instructor", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        	
                if (n == 0) {   // Update
                    var updateStudent = new updateStudent();
                    updateStudent.setVisible(true);
                    JButton updateButton = updateStudent.getStudentUpdatedUpdateButton();

                    String previousID1 = "";
                    
                    String previousName = "";
                    String previousAddress = "";
                    String previousCitizenship = "";
                    String previousDob = "";
                    String previousEmail = "";
                    String previousCollegeEmail = "";
                    String previousPassword = "";
                    Statement statement = JDBC.getStatement();

                    for (int columnIndex=0; columnIndex < jTable6.getColumnCount(); columnIndex++) {
                        if (previousID1.isEmpty()){
                            previousID1 = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        } else if(previousName.isEmpty()){
                            previousName = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        } else if(previousAddress.isEmpty()){
                            previousAddress = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        } else if(previousCitizenship.isEmpty()){
                            previousCitizenship = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        } else if(previousDob.isEmpty()){
                            previousDob = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        } else if(previousEmail.isEmpty()){
                            previousEmail = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        } else if(previousCollegeEmail.isEmpty()){
                            previousCollegeEmail = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        } else if(previousPassword.isEmpty()){
                            previousPassword = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        }

                    }
                    final String previousID = previousID1;

                    updateStudent.getStudentUpdatedName().setText(previousName);
                    updateStudent.getStudentUpdatedAddress().setText(previousAddress);
                    updateStudent.getStudentUpdatedCitizenshipNo().setText(previousCitizenship);
                    updateStudent.getStudentUpdatedDob().setText(previousDob);
                    updateStudent.getStudentUpdatedEmail().setText(previousEmail);
                    updateStudent.getStudentUpdatedCollegeEmail().setText(previousCollegeEmail);
                    updateStudent.getStudentUpdatedPassword().setText(previousPassword);
                    


                    updateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String updatedName = updateStudent.getStudentUpdatedName().getText();
                            String updatedAddress = updateStudent.getStudentUpdatedAddress().getText();
                            String updatedCitizenship = updateStudent.getStudentUpdatedCitizenshipNo().getText();
                            String updatedDob = updateStudent.getStudentUpdatedDob().getText();
                            String updatedEmail = updateStudent.getStudentUpdatedEmail().getText();
                            String updatedCollegeEmail = updateStudent.getStudentUpdatedCollegeEmail().getText();
                            String updatedPassword = updateStudent.getStudentUpdatedPassword().getText();


                            try {
                                String updateQuery = "UPDATE student SET Name = '" + updatedName + "', Address = '" + updatedAddress + "', Citizenship_Number = '" + updatedCitizenship + "', DOB = '" + updatedDob + "', Email_address = '" + updatedEmail + "', College_email_address = '" + updatedCollegeEmail + "', College_email_address_password = '" + updatedPassword + "' WHERE Student_ID = '" + previousID + "'";
                                statement.executeUpdate(updateQuery);
                                JOptionPane.showMessageDialog(null, "Data is updated");
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    
                } else {    // Delete

                    String Id = "";
                    for (int columnIndex=0; columnIndex < jTable6.getColumnCount(); columnIndex++) {
                        if (Id.isEmpty()){
                            Id = jTable6.getValueAt(jTable6.getSelectedRow(), columnIndex).toString();
                        }
                    }

                    Statement statement = JDBC.getStatement();
                    String deleteQuery1 = "DELETE FROM marks WHERE Student_ID = '" + Id + "'";
                    String deleteQuery2 = "DELETE FROM report WHERE Student_ID = '" + Id + "'";
                    String deleteQuery3 = "DELETE FROM student_module WHERE Student_ID = '" + Id + "'";
                    String deleteQuery4 = "DELETE FROM student_course WHERE Student_ID = '" + Id + "'";
                    String deleteQuery5 = "DELETE FROM student WHERE Student_ID = '" + Id + "'";


                    try {
                        statement.executeUpdate(deleteQuery1);
                        statement.executeUpdate(deleteQuery2);
                        statement.executeUpdate(deleteQuery3);
                        statement.executeUpdate(deleteQuery4);
                        statement.executeUpdate(deleteQuery5);
                        JOptionPane.showMessageDialog(null, "Data is deleted");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        jTable6.setDefaultEditor(Object.class, null);

        jPanel32 = new javax.swing.JPanel();
        logoutStudentButton = new javax.swing.JToggleButton();
        jPanel13 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        courseCourseNameTextField = new javax.swing.JTextField();
        courseCourseIdTextField = new javax.swing.JTextField();
        addCourseButton = new javax.swing.JButton();
        jLabel64 = new javax.swing.JLabel();
        courseCourseNameErrorMessage = new javax.swing.JLabel();
        courseCourseNameErrorMessage.setVisible(false);
        courseCourseIdErrorMessage = new javax.swing.JLabel();
        courseCourseIdErrorMessage.setVisible(false);
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        courseSearchTextField = new javax.swing.JTextField();
        refreshCourseButton = new javax.swing.JButton();
        searchCourseButton = new javax.swing.JButton();
        searchCourseButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        jTable2.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                Object[] options = {"Update", "Delete"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to update or delete the selected student?", "Update or Delete Instructor", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        	
                if (n == 0) {   // Update
                    var updateCourses = new updateCourses();
                    updateCourses.setVisible(true);
                    JButton updateButton = updateCourses.getCoursesUpdatedUpdateButton();

                    String courseID1 = "";
                    String previousName = "";
                    Statement statement = JDBC.getStatement();

                    

                    for (int columnIndex=0; columnIndex < jTable2.getColumnCount(); columnIndex++) {
                        if (courseID1.isEmpty()){
                            courseID1 = jTable2.getValueAt(jTable2.getSelectedRow(), columnIndex).toString();
                        } else if(previousName.isEmpty()){
                            previousName = jTable2.getValueAt(jTable2.getSelectedRow(), columnIndex).toString();
                        }

                    }
                    final String previousID = courseID1;

                    updateCourses.getCoursesUpdatedCourseName().setText(previousName);
                    updateCourses.getCoursesUpdatedCourseId().setText(previousID);
                    


                    updateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String updatedName = updateCourses.getCoursesUpdatedCourseName().getText();
                            String updatedId = updateCourses.getCoursesUpdatedCourseId().getText();


                            try {
                                String updateQuery = "UPDATE courses SET Course_ID = '" + updatedId + "', Course_name = '" + updatedName + "' WHERE Course_ID = '" + previousID + "'";
                                statement.executeUpdate(updateQuery);
                                JOptionPane.showMessageDialog(null, "Data is updated");
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    
                } else {    // Delete

                    String Id = "";
                    for (int columnIndex=0; columnIndex < jTable2.getColumnCount(); columnIndex++) {
                        if (Id.isEmpty()){
                            Id = jTable2.getValueAt(jTable2.getSelectedRow(), columnIndex).toString();
                        }
                    }

                    Statement statement = JDBC.getStatement();
                    String deleteQuery1 = "DELETE FROM marks WHERE Student_ID = '" + Id + "'";
                    String deleteQuery2 = "DELETE FROM report WHERE Student_ID = '" + Id + "'";
                    String deleteQuery3 = "DELETE FROM student_module WHERE Student_ID = '" + Id + "'";
                    String deleteQuery4 = "DELETE FROM student_course WHERE Student_ID = '" + Id + "'";
                    String deleteQuery5 = "DELETE FROM student WHERE Student_ID = '" + Id + "'";
                    String deleteQuery6 = "DELETE FROM module WHERE Course_ID = '" + Id + "'";
                    String deleteQuery7 = "DELETE FROM courses WHERE Course_ID = '" + Id + "'";

                    try {
                        statement.executeUpdate(deleteQuery1);
                        statement.executeUpdate(deleteQuery2);
                        statement.executeUpdate(deleteQuery3);
                        statement.executeUpdate(deleteQuery4);
                        statement.executeUpdate(deleteQuery5);
                        statement.executeUpdate(deleteQuery6);
                        statement.executeUpdate(deleteQuery7);
                        JOptionPane.showMessageDialog(null, "Data is deleted");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        jTable2.setDefaultEditor(Object.class, null);

        jPanel17 = new javax.swing.JPanel();
        logoutCourseButton = new javax.swing.JToggleButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        moduleModuleNameTextField = new javax.swing.JTextField();
        moduleModuleCodeTextField = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        moduleCourseComboBox = new javax.swing.JComboBox<>();
        moduleModuleNameErrorMessage = new javax.swing.JLabel();
        moduleModuleNameErrorMessage.setVisible(false);
        moduleModuleCodeErrorMessage = new javax.swing.JLabel();
        moduleModuleCodeErrorMessage.setVisible(false);
        moduleCourseErrorMessage = new javax.swing.JLabel();
        moduleCourseErrorMessage.setVisible(false);
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jTextField29 = new javax.swing.JTextField();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton12.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        jTable3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                Object[] options = {"Update", "Delete"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to update or delete the selected student?", "Update or Delete Instructor", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        	
                if (n == 0) {   // Update
                    var updateModules = new updateModules();
                    updateModules.setVisible(true);
                    JButton updateButton = updateModules.getModulesUpdatedUpdateButton();

                    String courseID1 = "";
                    String previousName = "";
                    Statement statement = JDBC.getStatement();

                    

                    for (int columnIndex=0; columnIndex < jTable3.getColumnCount(); columnIndex++) {
                        if (courseID1.isEmpty()){
                            courseID1 = jTable3.getValueAt(jTable3.getSelectedRow(), columnIndex).toString();
                        } else if(previousName.isEmpty()){
                            previousName = jTable3.getValueAt(jTable3.getSelectedRow(), columnIndex).toString();
                        }

                    }
                    final String previousID = courseID1;

                    updateModules.getModulesUpdatedModuleName().setText(previousName);
                    

                    


                    updateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String updatedName = updateModules.getModulesUpdatedModuleName().getText();


                            try {
                                String updateQuery = "UPDATE module SET Module_name = '" + updatedName + "' WHERE Module_code = '" + previousID + "'";
                                statement.executeUpdate(updateQuery);
                                JOptionPane.showMessageDialog(null, "Data is updated");
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    
                } else {    // Delete

                    String Id = "";
                    for (int columnIndex=0; columnIndex < jTable3.getColumnCount(); columnIndex++) {
                        if (Id.isEmpty()){
                            Id = jTable3.getValueAt(jTable3.getSelectedRow(), columnIndex).toString();
                        }
                    }

                    Statement statement = JDBC.getStatement();
                    String deleteQuery1 = "DELETE FROM marks WHERE Module_Code = '" + Id + "'";
                    String deleteQuery2 = "DELETE FROM report WHERE Module_Code = '" + Id + "'";
                    String deleteQuery3 = "DELETE FROM student_module WHERE Module_Code = '" + Id + "'";
                    String deleteQuery4 = "DELETE FROM module WHERE Module_Code = '" + Id + "'";
                    String deleteQuery5 = "DELETE FROM module_course WHERE Module_Code = '" + Id + "'";
                    String deleteQuery6 = "DELETE FROM course_module WHERE Module_Code = '" + Id + "'";
                    String deleteQuery7 = "DELETE FROM modules WHERE Module_Code = '" + Id + "'";

                    try {
                        statement.executeUpdate(deleteQuery1);
                        statement.executeUpdate(deleteQuery2);
                        statement.executeUpdate(deleteQuery3);
                        statement.executeUpdate(deleteQuery4);
                        statement.executeUpdate(deleteQuery5);
                        statement.executeUpdate(deleteQuery6);
                        statement.executeUpdate(deleteQuery7);
                        JOptionPane.showMessageDialog(null, "Data is deleted");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        jTable3.setDefaultEditor(Object.class, null);

        jPanel22 = new javax.swing.JPanel();
        jToggleButton6 = new javax.swing.JToggleButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton16.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

jTable4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                Object[] options = {"Generate", "Don't generate"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to Generate report of the selected student?", "Generate Report", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        	
                if (n == 0) {
                    String studentID = "";
                    for (int columnIndex=0; columnIndex < jTable4.getColumnCount(); columnIndex++) {
                        if (studentID.isEmpty()){
                            studentID = jTable4.getValueAt(jTable4.getSelectedRow(), columnIndex).toString();
                        }
                    }

                    Statement statement = JDBC.getStatement();
                    String query = "SELECT * FROM report WHERE Student_ID = '" + studentID + "'";
                    ResultSet rs = null;
                    try {
                        rs = statement.executeQuery(query);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    try {
                        Document document = new Document();
                        PdfWriter.getInstance(document, new FileOutputStream("D:\\Report.pdf"));
                        document.open();
                        document.add(new Paragraph("Report of Student ID: " + studentID));

                        PdfPTable table = new PdfPTable(4);
                        table.addCell("Student ID");
                        table.addCell("Module Code");
                        table.addCell("Course ID");
                        table.addCell("Marks");

                        while (rs.next()) {
                            table.addCell(rs.getString("Student_ID"));
                            table.addCell(rs.getString("Module_Code"));
                            table.addCell(rs.getString("Course_ID"));
                            table.addCell(rs.getString("Marks"));
                        }

                        document.add(table);
                        document.close();
                        JOptionPane.showMessageDialog(null, "Report is generated");
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                } else {
                    return;
                }


                
            }
        });
        jTable4.setDefaultEditor(Object.class, null);

        jPanel27 = new javax.swing.JPanel();
        jToggleButton8 = new javax.swing.JToggleButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton19.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

        	}
        });
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jTable5.setDefaultEditor(Object.class, null);
        jPanel30 = new javax.swing.JPanel();
        jToggleButton10 = new javax.swing.JToggleButton();

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 51));
        jLabel23.setText("Phone number cannot be empty!!");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));

        jPanel2.setBackground(new java.awt.Color(255, 36, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Course Administrator");

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

        jPanel3.setBackground(new java.awt.Color(29, 29, 29));

        jPanel4.setBackground(new java.awt.Color(23, 23, 23));
        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Address:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Years Of Experience:");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Citizenship Number:");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Pan Number:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("DOB:");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Module Code 1:");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Course ID:");

        instructorNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorNameTextFieldActionPerformed(evt);
            }
        });

        Statement statement = JDBC.getStatement();
        String query = "SELECT Module_code FROM module";
        ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        List<String> moduleCodes = new ArrayList<>();
        moduleCodes.add("Select Modules");
        try {
			while (resultSet.next()) {
			try {
				moduleCodes.add(resultSet.getString("Module_code"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
        String[] moduleCodeArray = moduleCodes.toArray(new String[0]);
        instructorModule_1ComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(moduleCodeArray));
        
        instructorModule_1ComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorModule_1ComboBoxActionPerformed(evt);
            }
        });
        

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
        instructorCourseIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(courseIdArray));
        instructorCourseIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorModule_2ComboBoxActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Phone Number:");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Email:");

        addInstructorButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        addInstructorButton.setText("Add");
        addInstructorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInstructorButtonActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Password:");

        instructorDobTextField.setText("DD/MM/YYYY");

        instructorNameErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorNameErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorNameErrorMessage.setText("Name cannot be empty!!");

        instructorAddressErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorAddressErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorAddressErrorMessage.setText("Address cannot be empty!!");

        instructorExperienceErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorExperienceErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorExperienceErrorMessage.setText("Experience cannot be empty!!");

        instructorCitizenshipErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorCitizenshipErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorCitizenshipErrorMessage.setText("Citizenship number cannot be empty!!");

        instructorPanErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorPanErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorPanErrorMessage.setText("Pan number cannot be empty!!");

        instructorDobErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorDobErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorDobErrorMessage.setText("Date of Birth cannot be empty!!");

        instructorPhoneNoErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorPhoneNoErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorPhoneNoErrorMessage.setText("Phone number cannot be empty!!");

        instructorEmailErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorEmailErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorEmailErrorMessage.setText("Email cannot be empty!!");

        instructorPasswordErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorPasswordErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorPasswordErrorMessage.setText("Password cannot be empty!!");

        instructorModuleErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        instructorModuleErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorModuleErrorMessage.setText("Module cannot be empty!!");
        
        JLabel lblInstructorId = new JLabel();
        lblInstructorId.setText("Instructor ID:");
        lblInstructorId.setForeground(Color.WHITE);
        lblInstructorId.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        
        instructorInstructorIdTextField = new JTextField();
        instructorInstructorIdTextField.setColumns(10);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4Layout.setHorizontalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addGap(9)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel5)
        				.addComponent(jLabel4)
        				.addComponent(jLabel2)
        				.addComponent(jLabel3)
        				.addComponent(jLabel6)
        				.addComponent(jLabel7)
        				.addComponent(jLabel10)
        				.addComponent(jLabel11)
        				.addComponent(jLabel15)
        				.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        					.addComponent(jLabel9)
        					.addComponent(jLabel8))
        				.addComponent(lblInstructorId))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(instructorNameTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorAddressTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorExperienceTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorCitizenshipTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorPanTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorPhoneTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorEmailTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorPasswordTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addComponent(instructorDobTextField, Alignment.LEADING, 319, 319, Short.MAX_VALUE)
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(instructorModuleErrorMessage)
        						.addComponent(instructorPasswordErrorMessage)
        						.addComponent(instructorEmailErrorMessage)
        						.addComponent(instructorPhoneNoErrorMessage)
        						.addComponent(instructorDobErrorMessage)
        						.addComponent(instructorPanErrorMessage)
        						.addComponent(instructorCitizenshipErrorMessage)
        						.addComponent(instructorNameErrorMessage)
        						.addComponent(instructorAddressErrorMessage)
        						.addComponent(instructorExperienceErrorMessage))
        					.addGap(0, 196, Short.MAX_VALUE))
        				.addComponent(instructorCourseIdComboBox, 0, 410, Short.MAX_VALUE)
        				.addGroup(jPanel4Layout.createSequentialGroup()
        					.addComponent(instructorInstructorIdTextField, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
        					.addComponent(addInstructorButton))
        				.addComponent(instructorModule_1ComboBox, Alignment.LEADING, 0, 319, Short.MAX_VALUE))
        			.addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
        	jPanel4Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel4Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel3)
        				.addComponent(instructorNameTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(instructorNameErrorMessage)
        			.addGap(3)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel2)
        				.addComponent(instructorAddressTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(instructorAddressErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel4)
        				.addComponent(instructorExperienceTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(instructorExperienceErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel5)
        				.addComponent(instructorCitizenshipTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(instructorCitizenshipErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(instructorPanTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(instructorPanErrorMessage)
        			.addGap(3)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(instructorDobTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(instructorDobErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel10)
        				.addComponent(instructorPhoneTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(instructorPhoneNoErrorMessage)
        			.addGap(3)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel11)
        				.addComponent(instructorEmailTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(instructorEmailErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jLabel15)
        				.addComponent(instructorPasswordTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(instructorPasswordErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(instructorModule_1ComboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel8))
        			.addGap(3)
        			.addComponent(instructorModuleErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel9)
        				.addComponent(instructorCourseIdComboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGroup(jPanel4Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel4Layout.createParallelGroup(Alignment.BASELINE)
        					.addComponent(instructorInstructorIdTextField, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblInstructorId, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        				.addComponent(addInstructorButton))
        			.addContainerGap())
        );
        jPanel4.setLayout(jPanel4Layout);

        jPanel5.setBackground(new java.awt.Color(23, 23, 23));
        jPanel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel11.setBackground(new java.awt.Color(23, 23, 23));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Search Instructor:");

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

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(instructorSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(searchInstructorButton)
                .addGap(43, 43, 43)
                .addComponent(refreshInstructorButton)
                .addContainerGap(107, Short.MAX_VALUE))
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

        jTable1.setModel(instructorDefaultTableModel);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(2).setHeaderValue("Address");
            jTable1.getColumnModel().getColumn(3).setHeaderValue("Years of Experience");
            jTable1.getColumnModel().getColumn(4).setHeaderValue("Citizenship Number");
            jTable1.getColumnModel().getColumn(5).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setHeaderValue("PAN Number");
            jTable1.getColumnModel().getColumn(6).setHeaderValue("DOB");
            jTable1.getColumnModel().getColumn(8).setHeaderValue("Password");
            jTable1.getColumnModel().getColumn(9).setHeaderValue("Module ID");
            jTable1.getColumnModel().getColumn(10).setHeaderValue("Course ID");
        }

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
        jPanel12Layout.setHorizontalGroup(
        	jPanel12Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel12Layout.createSequentialGroup()
        			.addGap(385)
        			.addComponent(instructorLogoutButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(477, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
        	jPanel12Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel12Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(instructorLogoutButton)
        			.addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel12.setLayout(jPanel12Layout);

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
        jPanel3Layout.setHorizontalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 613, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 1009, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
        	jPanel3Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel3Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jPanel4, GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE)
        				.addComponent(jPanel5, GroupLayout.PREFERRED_SIZE, 659, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        jPanel3.setLayout(jPanel3Layout);

        jTabbedPane1.addTab("Instructors", jPanel3);

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

        String query1_ = "SELECT Course_ID FROM courses";
        ResultSet resultSet1_ = null;
        try {
        resultSet1_ = statement.executeQuery(query1_);
        } catch (SQLException e) {
        e.printStackTrace();
        }
        List<String> courseIds_ = new ArrayList<>();
        courseIds_.add("Select Course");
        try {
        while (resultSet1_.next()) {
        try {
        courseIds_.add(resultSet1_.getString("Course_ID"));
        } catch (SQLException e) {
        e.printStackTrace();
        }
        }
        } catch (SQLException e) {
        e.printStackTrace();
        }
        String[] courseIdArray_ = courseIds.toArray(new String[0]);
        studentCourseIdComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(courseIdArray_));
        studentCourseIdComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentCourseIdComboBoxActionPerformed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("College Email:");

        addStudentButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        addStudentButton.setText("Add");
        addStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentButtonActionPerformed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Password:");

        studentDobTextField.setText("DD/MM/YYYY");

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
        jPanel7Layout.setHorizontalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addContainerGap(10, Short.MAX_VALUE)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel7Layout.createSequentialGroup()
        					.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        							.addGroup(jPanel7Layout.createSequentialGroup()
        								.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        									.addComponent(jLabel43)
        									.addComponent(jLabel42)
        									.addComponent(jLabel41)
        									.addComponent(jLabel40))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(studentNameTextField, 255, 255, 255)
        									.addComponent(studentAddressTextField, 255, 255, 255)
        									.addComponent(studentEmailTextField, 255, 255, 255)
        									.addComponent(studentCitizenshipTextField, 255, 255, 255)
        									.addComponent(studentCitizenshipErrorMessage)
        									.addComponent(studentNameErrorMessage)
        									.addComponent(studentAddressErrorMessage)
        									.addComponent(studentEmailErrorMessage)))
        							.addGroup(jPanel7Layout.createSequentialGroup()
        								.addComponent(jLabel45)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(studentDobErrorMessage)
        									.addComponent(studentDobTextField, 255, 255, 255))))
        						.addGroup(Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
        							.addComponent(jLabel49)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(studentCollegeEmailTextField, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
        						.addGroup(Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
        							.addComponent(jLabel50)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(studentCollegeEmailErrorMessage)
        								.addComponent(studentPasswordTextField, GroupLayout.PREFERRED_SIZE, 251, GroupLayout.PREFERRED_SIZE)
        								.addComponent(studentPasswordErrorMessage)))
        						.addGroup(Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
        							.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        								.addComponent(jLabel12)
        								.addComponent(jLabel46, GroupLayout.PREFERRED_SIZE, 107, GroupLayout.PREFERRED_SIZE))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING)
        								.addComponent(studentStudentIdErrorMessage)
        								.addGroup(jPanel7Layout.createParallelGroup(Alignment.LEADING, false)
        									.addComponent(studentCourseErrorMessage)
        									.addComponent(studentCourseIdComboBox, 0, 250, Short.MAX_VALUE)
        									.addComponent(studentStudentIdTextField)))))
        					.addContainerGap())
        				.addGroup(Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
        					.addComponent(addStudentButton)
        					.addGap(158))))
        );
        jPanel7Layout.setVerticalGroup(
        	jPanel7Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel7Layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel40)
        				.addComponent(studentNameTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(studentNameErrorMessage)
        			.addGap(3)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel41)
        				.addComponent(studentAddressTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(studentAddressErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel42)
        				.addComponent(studentEmailTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(studentEmailErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel43)
        				.addComponent(studentCitizenshipTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(studentCitizenshipErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel45)
        				.addComponent(studentDobTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(studentDobErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel49)
        				.addComponent(studentCollegeEmailTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(3)
        			.addComponent(studentCollegeEmailErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(studentPasswordTextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel50))
        			.addGap(4)
        			.addComponent(studentPasswordErrorMessage)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(studentCourseIdComboBox, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jLabel46))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(studentCourseErrorMessage)
        			.addGap(12)
        			.addGroup(jPanel7Layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(jLabel12)
        				.addGroup(jPanel7Layout.createSequentialGroup()
        					.addComponent(studentStudentIdTextField, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
        					.addGap(1)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(studentStudentIdErrorMessage)
        			.addGap(27)
        			.addComponent(addStudentButton)
        			.addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel7.setLayout(jPanel7Layout);

        jPanel8.setBackground(new java.awt.Color(23, 23, 23));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel31.setBackground(new java.awt.Color(23, 23, 23));
        jPanel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("Search Student:");

        studentSearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentSearchTextFieldActionPerformed(evt);
            }
        });

        refreshStudentButton.setBackground(new java.awt.Color(23, 23, 23));
        refreshStudentButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        refreshStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshStudentButton.setText("Refresh");
        refreshStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshStudentButtonActionPerformed(evt);
            }
        });

        searchStudentButton.setBackground(new java.awt.Color(23, 23, 23));
        searchStudentButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        searchStudentButton.setText("Search");

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31Layout.setHorizontalGroup(
        	jPanel31Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel31Layout.createSequentialGroup()
        			.addGap(31)
        			.addComponent(jLabel63)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(studentSearchTextField, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(searchStudentButton)
        			.addGap(43)
        			.addComponent(refreshStudentButton)
        			.addContainerGap(149, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
        	jPanel31Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel31Layout.createSequentialGroup()
        			.addContainerGap(25, Short.MAX_VALUE)
        			.addGroup(jPanel31Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(studentSearchTextField, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        				.addComponent(searchStudentButton)
        				.addComponent(refreshStudentButton)
        				.addComponent(jLabel63))
        			.addGap(27))
        );
        jPanel31.setLayout(jPanel31Layout);

        jTable6.setModel(studentDefaultTableModel);
        jScrollPane6.setViewportView(jTable6);

        jPanel32.setBackground(new java.awt.Color(23, 23, 23));
        jPanel32.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        logoutStudentButton.setBackground(new java.awt.Color(23, 23, 23));
        logoutStudentButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        logoutStudentButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutStudentButton.setText("Log Out");
        logoutStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32Layout.setHorizontalGroup(
        	jPanel32Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel32Layout.createSequentialGroup()
        			.addGap(367)
        			.addComponent(logoutStudentButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(512, Short.MAX_VALUE))
        );
        jPanel32Layout.setVerticalGroup(
        	jPanel32Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel32Layout.createSequentialGroup()
        			.addContainerGap(23, Short.MAX_VALUE)
        			.addComponent(logoutStudentButton)
        			.addContainerGap())
        );
        jPanel32.setLayout(jPanel32Layout);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel31, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane6)
                    .addComponent(jPanel32, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Students", jPanel6);

        jPanel13.setBackground(new java.awt.Color(29, 29, 29));

        jPanel14.setBackground(new java.awt.Color(23, 23, 23));
        jPanel14.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));
        jPanel14.setPreferredSize(new java.awt.Dimension(552, 259));

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Course Name:");

        courseCourseNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseCourseNameTextFieldActionPerformed(evt);
            }
        });

        addCourseButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        addCourseButton.setText("Add");
        addCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseButtonActionPerformed(evt);
            }
        });

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("Course ID:");

        courseCourseNameErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        courseCourseNameErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        courseCourseNameErrorMessage.setText("Course Name cannot be empty!!");

        courseCourseIdErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        courseCourseIdErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        courseCourseIdErrorMessage.setText("Course ID cannot be empty!!");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(addCourseButton)
                .addGap(191, 191, 191))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel64))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(courseCourseNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
                    .addComponent(courseCourseIdTextField)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(courseCourseIdErrorMessage)
                            .addComponent(courseCourseNameErrorMessage))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(courseCourseNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(courseCourseNameErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseCourseIdTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel64))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseCourseIdErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addCourseButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel15.setBackground(new java.awt.Color(23, 23, 23));
        jPanel15.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel16.setBackground(new java.awt.Color(23, 23, 23));
        jPanel16.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Search Course:");

        courseSearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseSearchTextFieldActionPerformed(evt);
            }
        });

        refreshCourseButton.setBackground(new java.awt.Color(23, 23, 23));
        refreshCourseButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        refreshCourseButton.setForeground(new java.awt.Color(255, 255, 255));
        refreshCourseButton.setText("Refresh");
        refreshCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshCourseButtonActionPerformed(evt);
            }
        });

        searchCourseButton.setBackground(new java.awt.Color(23, 23, 23));
        searchCourseButton.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        searchCourseButton.setForeground(new java.awt.Color(255, 255, 255));
        searchCourseButton.setText("Search");

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(searchCourseButton)
                .addGap(43, 43, 43)
                .addComponent(refreshCourseButton)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(courseSearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchCourseButton)
                    .addComponent(refreshCourseButton))
                .addGap(27, 27, 27))
        );

        jTable2.setModel(courseDefaultTableModel);
        jScrollPane2.setViewportView(jTable2);

        jPanel17.setBackground(new java.awt.Color(23, 23, 23));
        jPanel17.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        logoutCourseButton.setBackground(new java.awt.Color(23, 23, 23));
        logoutCourseButton.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        logoutCourseButton.setForeground(new java.awt.Color(255, 255, 255));
        logoutCourseButton.setText("Log Out");
        logoutCourseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutCourseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17Layout.setHorizontalGroup(
        	jPanel17Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel17Layout.createSequentialGroup()
        			.addGap(367)
        			.addComponent(logoutCourseButton, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(465, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
        	jPanel17Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
        			.addContainerGap(23, Short.MAX_VALUE)
        			.addComponent(logoutCourseButton)
        			.addContainerGap())
        );
        jPanel17.setLayout(jPanel17Layout);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Courses", jPanel13);

        jPanel18.setBackground(new java.awt.Color(29, 29, 29));

        jPanel19.setBackground(new java.awt.Color(23, 23, 23));
        jPanel19.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Module Name:");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Module Code:");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Select Course:");

        moduleModuleNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField21ActionPerformed(evt);
            }
        });

        jButton10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        moduleCourseComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(courseIdArray_));
        moduleCourseComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox4ActionPerformed(evt);
            }
        });

        moduleModuleNameErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moduleModuleNameErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        moduleModuleNameErrorMessage.setText("Module Name cannot be empty!!");

        moduleModuleCodeErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moduleModuleCodeErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        moduleModuleCodeErrorMessage.setText("Module Code cannot be empty!!");

        moduleCourseErrorMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        moduleCourseErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        moduleCourseErrorMessage.setText("Course cannot be empty!!");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel30)
                    .addComponent(jLabel29)
                    .addComponent(jLabel28))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(moduleModuleNameTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 372, Short.MAX_VALUE)
                    .addComponent(moduleModuleCodeTextField)
                    .addComponent(moduleCourseComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(moduleCourseErrorMessage)
                            .addComponent(moduleModuleCodeErrorMessage)
                            .addComponent(moduleModuleNameErrorMessage))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(moduleModuleNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(moduleModuleNameErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(moduleModuleCodeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(moduleModuleCodeErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(moduleCourseComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moduleCourseErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel20.setBackground(new java.awt.Color(23, 23, 23));
        jPanel20.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel21.setBackground(new java.awt.Color(23, 23, 23));
        jPanel21.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel39.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Search Module:");

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
        jPanel21Layout.setHorizontalGroup(
        	jPanel21Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel21Layout.createSequentialGroup()
        			.addGap(24)
        			.addComponent(jLabel39, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(jTextField29, GroupLayout.PREFERRED_SIZE, 410, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(jButton12)
        			.addGap(43)
        			.addComponent(jButton11)
        			.addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
        	jPanel21Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel21Layout.createSequentialGroup()
        			.addContainerGap(25, Short.MAX_VALUE)
        			.addGroup(jPanel21Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jTextField29, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
        				.addComponent(jButton12)
        				.addComponent(jButton11)
        				.addComponent(jLabel39))
        			.addGap(27))
        );
        jPanel21.setLayout(jPanel21Layout);

        jTable3.setModel(moduleDefaultTableModel);
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
        jPanel22Layout.setHorizontalGroup(
        	jPanel22Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel22Layout.createSequentialGroup()
        			.addGap(379)
        			.addComponent(jToggleButton6, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(457, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
        	jPanel22Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, jPanel22Layout.createSequentialGroup()
        			.addContainerGap(23, Short.MAX_VALUE)
        			.addComponent(jToggleButton6)
        			.addContainerGap())
        );
        jPanel22.setLayout(jPanel22Layout);

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
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Modules", jPanel18);

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
                .addComponent(jTextField38, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton16)
                .addGap(43, 43, 43)
                .addComponent(jButton15)
                .addContainerGap(671, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel24.setBackground(new java.awt.Color(29, 29, 29));

        jPanel28.setBackground(new java.awt.Color(23, 23, 23));
        jPanel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel29.setBackground(new java.awt.Color(23, 23, 23));
        jPanel29.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel52.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("Search Student:");

        jTextField39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField39ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(23, 23, 23));
        jButton18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Refresh");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setBackground(new java.awt.Color(23, 23, 23));
        jButton19.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Search");

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton19)
                .addGap(43, 43, 43)
                .addComponent(jButton18)
                .addContainerGap(671, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19)
                    .addComponent(jButton18))
                .addGap(27, 27, 27))
        );

        jTable5.setModel(studentDetailsDefaultTableModel);
        jScrollPane5.setViewportView(jTable5);

        jPanel30.setBackground(new java.awt.Color(23, 23, 23));
        jPanel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jToggleButton10.setBackground(new java.awt.Color(23, 23, 23));
        jToggleButton10.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jToggleButton10.setForeground(new java.awt.Color(255, 255, 255));
        jToggleButton10.setText("Log Out");
        jToggleButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jToggleButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(642, 642, 642))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jToggleButton10)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addComponent(jPanel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel30, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Student Details", jPanel24);

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
                .addComponent(jTabbedPane1))
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
    }                    

    private void jToggleButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                                
    	this.dispose();
        new LoginPanel().setVisible(true);
    }                                               

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);
        showStudentDetailsDataInTableFromDb();
    }                                         

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                               
        this.dispose();
        new LoginPanel().setVisible(true);
    }                                              

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        showReportDataInTableFromDb();
    }                                         

    private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void jToggleButton6ActionPerformed(java.awt.event.ActionEvent evt) {                                               
    	this.dispose();
        new LoginPanel().setVisible(true);
    }                                              

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
        model.setRowCount(0);
        showModulesDataInTableFromDb();
    }                                         

    private void jTextField29ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void jComboBox4ActionPerformed(java.awt.event.ActionEvent evt) {                                           
    }                                          

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {                                          

        if(moduleModuleNameTextField.getText().isEmpty() || moduleModuleCodeTextField.getText().isEmpty() || moduleCourseComboBox.getSelectedItem().toString().equals("Select Course")){
            if (moduleModuleNameTextField.getText().isEmpty()) {
                moduleModuleNameErrorMessage.setVisible(true);
            } else {
                moduleModuleNameErrorMessage.setVisible(false);
            }
            if (moduleModuleCodeTextField.getText().isEmpty()) {
                moduleModuleCodeErrorMessage.setVisible(true);
            } else {
                moduleModuleCodeErrorMessage.setVisible(false);
            }
            if (moduleCourseComboBox.getSelectedItem().toString().equals("Select Course")) {
                moduleCourseErrorMessage.setVisible(true);
            } else {
                moduleCourseErrorMessage.setVisible(false);
            }
        } else {
            moduleName = moduleModuleNameTextField.getText();
            moduleCode = moduleModuleCodeTextField.getText();
            moduleCourseId = moduleCourseComboBox.getSelectedItem().toString();

            Statement statement = JDBC.getStatement();
            String insertQuery = "INSERT INTO module (Course_ID, Module_name, Module_code) VALUES ('"+moduleCourseId+"', '"+moduleName+"', '"+moduleCode+"')";

            try{
                int success = statement.executeUpdate(insertQuery);
                if (success == 1){
                    JOptionPane.showMessageDialog(null, "Module Added Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Module not added");
                }
            } catch (SQLException e){
                e.printStackTrace();
            }
        }

    }                                 

    private void jTextField21ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void logoutCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    	this.dispose();
        new LoginPanel().setVisible(true);
    }                                                  

    private void refreshCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    	DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        showCoursesDataInTableFromDb();
    }                                                   

    private void courseSearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                      
    }                                                     

    private void addCourseButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        if (courseCourseNameTextField.getText().isEmpty() || courseCourseIdTextField.getText().isEmpty()){
            if(courseCourseNameTextField.getText().isEmpty()){
                courseCourseNameErrorMessage.setVisible(true);
            } else {
                courseCourseNameErrorMessage.setVisible(false);
            }
            if(courseCourseIdTextField.getText().isEmpty()){
                courseCourseIdErrorMessage.setVisible(true);
            } else {
                courseCourseIdErrorMessage.setVisible(false);
            }
        } else {
            courseName = courseCourseNameTextField.getText().trim();
            courseID = courseCourseIdTextField.getText().trim();

            Statement statement = JDBC.getStatement();
            String insertQuery = "INSERT INTO courses (Course_ID, Course_name) VALUES ('"+courseID+"', '"+courseName+"')";

            try{
                int success = statement.executeUpdate(insertQuery);
                if (success == 1){
                    JOptionPane.showMessageDialog(null, "Course Added Successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Course not added");
                }
            } catch (SQLException e){
                e.printStackTrace();
            }

        }
    }                                               

    private void courseCourseNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                          
    }                                                         

    private void instructorLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                       
        this.dispose();
        new LoginPanel().setVisible(true);
    }                                                      

    private void refreshInstructorButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        showDataInTableFromDb();
    }                                                       

    private void instructorSearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                          
    }                                                         

    private void addInstructorButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
    	
    	// Displaying error message
    	
        if (instructorNameTextField.getText().isEmpty() || instructorAddressTextField.getText().isEmpty() || instructorExperienceTextField.getText().isEmpty() || instructorCitizenshipTextField.getText().isEmpty() || instructorPanTextField.getText().isEmpty() || instructorDobTextField.getText().contentEquals("DD/MM/YYYY") || instructorPhoneTextField.getText().isEmpty() || instructorEmailTextField.getText().isEmpty() || instructorPasswordTextField.getText().isEmpty() || (String) instructorModule_1ComboBox.getSelectedItem() == "Select Modules" || (String) instructorCourseIdComboBox.getSelectedItem() == "Select Course") {
            if (instructorNameTextField.getText().isEmpty()) {
                instructorNameErrorMessage.setVisible(true);
            } else {
                instructorNameErrorMessage.setVisible(false);
            }
            
            if (instructorAddressTextField.getText().isEmpty()) {
                instructorAddressErrorMessage.setVisible(true);
            } else {
                instructorAddressErrorMessage.setVisible(false);
            }
            
            if (instructorExperienceTextField.getText().isEmpty()) {
                instructorExperienceErrorMessage.setVisible(true);
            } else {
                instructorExperienceErrorMessage.setVisible(false);
            }
            
            if (instructorCitizenshipTextField.getText().isEmpty()) {
                instructorCitizenshipErrorMessage.setVisible(true);
            } else {
                instructorCitizenshipErrorMessage.setVisible(false);
            }
            
            if (instructorPanTextField.getText().isEmpty()) {
                instructorPanErrorMessage.setVisible(true);
            } else {
                instructorPanErrorMessage.setVisible(false);
            }
            
            if (instructorDobTextField.getText().contentEquals("DD/MM/YYYY")) {
                instructorDobErrorMessage.setVisible(true);
            } else {
                instructorDobErrorMessage.setVisible(false);
            }
            
            if( instructorPhoneTextField.getText().isEmpty()) {
                instructorPhoneNoErrorMessage.setVisible(true);
            } else {
                instructorPhoneNoErrorMessage.setVisible(false);
            }
            
            if (instructorEmailTextField.getText().isEmpty()) {
                instructorEmailErrorMessage.setVisible(true);
            } else {
                instructorEmailErrorMessage.setVisible(false);
            }
            
            if (instructorPasswordTextField.getText().isEmpty()) {
                instructorPasswordErrorMessage.setVisible(true);
            } else {
                instructorPasswordErrorMessage.setVisible(false);
            }
            
            if ((String) instructorModule_1ComboBox.getSelectedItem() == "Select Modules") {
                instructorModuleErrorMessage.setVisible(true);
            } else {
                instructorModuleErrorMessage.setVisible(false);
            }
        } else {
    	
            instructorName = instructorNameTextField.getText().trim();
            instructorAddress = instructorAddressTextField.getText().trim();
            instructorYearsOfExperience = instructorExperienceTextField.getText().trim();
            instructorCitizenshipNo = instructorCitizenshipTextField.getText().trim();
            instructorPanNo = instructorPanTextField.getText().trim();
            instructorDob = instructorDobTextField.getText().trim();
            instructorEmail = instructorEmailTextField.getText().trim();
            instructorPassword = instructorPasswordTextField.getText().trim();
            instructorModule1 = (String) instructorModule_1ComboBox.getSelectedItem();
            instructorCourseId = (String) instructorCourseIdComboBox.getSelectedItem();
            instructorId = instructorInstructorIdTextField.getText().trim();

            Statement statement = JDBC.getStatement();
            String insertQuery1 = "INSERT INTO Instructor (Instructor_ID, Name, Address, Year_of_experience, Citizenship_Number, Pan_number, DOB, Email_address, Password) VALUES ('" + instructorId +"' ,'"+ instructorName +"', '"+ instructorAddress +"', '"+ instructorYearsOfExperience +"', '"+ instructorCitizenshipNo +"', '"+ instructorPanNo +"', '"+ instructorDob +"', '"+ instructorEmail +"', '" + instructorPassword + "')";
            String insertQuery2 = "INSERT INTO Instructor_Module (Instructor_ID, Module_code, Course_ID) VALUES ('" + instructorId +"', '" + instructorModule1 +"', '" + instructorCourseId +"')";
            String insertQuery3 = "INSERT INTO Instructor_Course (Instructor_ID, Course_ID) VALUES ('" + instructorId +"', '" + instructorCourseId +"')";
            try {
                int insertSuccess1 = statement.executeUpdate(insertQuery1);
                int insertSuccess2 = statement.executeUpdate(insertQuery2);
                int insertSuccess3 = statement.executeUpdate(insertQuery3);

                if (insertSuccess1 == 1 && insertSuccess2 == 1 && insertSuccess3 == 1) {
                    JOptionPane.showMessageDialog(jPanel1, "Instructor added successfully");
                } else {
                    JOptionPane.showMessageDialog(jPanel1, "Instructor not added");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    }                                                   

    private void instructorModule_2ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                           
    }                                                          

    private void instructorModule_1ComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                           
    }                                                          

    private void instructorNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                        
    }                                                       

    private void studentNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    }                                                    

    private void studentCourseIdComboBoxActionPerformed(java.awt.event.ActionEvent evt) {                                                        
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

            
            Statement statement = JDBC.getStatement();
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
    }                                                

    private void studentSearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {                                                       
    }                                                      

    private void refreshStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                     
    	DefaultTableModel model = (DefaultTableModel) jTable6.getModel();
        model.setRowCount(0);
        showStudentDataInTableFromDb();
    }                                                    

    private void logoutStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        this.dispose();
        new LoginPanel().setVisible(true);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CourseAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseAdministrator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseAdministrator().setVisible(true);
            }
        });

        // show data in table from database when the program starts
        showDataInTableFromDb();
        showStudentDataInTableFromDb();
        showCoursesDataInTableFromDb();
        showModulesDataInTableFromDb();
        showReportDataInTableFromDb();
        showStudentDetailsDataInTableFromDb();

    }

    // Variables declaration
    private javax.swing.JButton addCourseButton;
    private javax.swing.JButton addInstructorButton;
    private javax.swing.JButton addStudentButton;
    private javax.swing.JLabel courseCourseIdErrorMessage;
    private javax.swing.JTextField courseCourseIdTextField;
    private javax.swing.JLabel courseCourseNameErrorMessage;
    private javax.swing.JTextField courseCourseNameTextField;
    private javax.swing.JTextField courseSearchTextField;
    private javax.swing.JLabel instructorAddressErrorMessage;
    private javax.swing.JTextField instructorAddressTextField;
    private javax.swing.JLabel instructorCitizenshipErrorMessage;
    private javax.swing.JTextField instructorCitizenshipTextField;
    private javax.swing.JLabel instructorDobErrorMessage;
    private javax.swing.JTextField instructorDobTextField;
    private javax.swing.JLabel instructorEmailErrorMessage;
    private javax.swing.JTextField instructorEmailTextField;
    private javax.swing.JLabel instructorExperienceErrorMessage;
    private javax.swing.JTextField instructorExperienceTextField;
    private javax.swing.JToggleButton instructorLogoutButton;
    private javax.swing.JLabel instructorModuleErrorMessage;
    private javax.swing.JComboBox<String> instructorModule_1ComboBox;
    private javax.swing.JComboBox<String> instructorCourseIdComboBox;
    private javax.swing.JLabel instructorNameErrorMessage;
    private javax.swing.JTextField instructorNameTextField;
    private javax.swing.JLabel instructorPanErrorMessage;
    private javax.swing.JTextField instructorPanTextField;
    private javax.swing.JLabel instructorPasswordErrorMessage;
    private javax.swing.JTextField instructorPasswordTextField;
    private javax.swing.JLabel instructorPhoneNoErrorMessage;
    private javax.swing.JTextField instructorPhoneTextField;
    private javax.swing.JTextField instructorSearchTextField;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JComboBox<String> moduleCourseComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTextField moduleModuleNameTextField;
    private javax.swing.JTextField moduleModuleCodeTextField;
    private javax.swing.JTextField jTextField29;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JToggleButton jToggleButton10;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton logoutCourseButton;
    private javax.swing.JToggleButton logoutStudentButton;
    private javax.swing.JLabel moduleCourseErrorMessage;
    private javax.swing.JLabel moduleModuleCodeErrorMessage;
    private javax.swing.JLabel moduleModuleNameErrorMessage;
    private javax.swing.JButton refreshCourseButton;
    private javax.swing.JButton refreshInstructorButton;
    private javax.swing.JButton refreshStudentButton;
    private javax.swing.JButton searchCourseButton;
    private javax.swing.JButton searchInstructorButton;
    private javax.swing.JButton searchStudentButton;
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
    private javax.swing.JTextField studentSearchTextField;
    private javax.swing.JLabel studentStudentIdErrorMessage;
    private javax.swing.JTextField studentStudentIdTextField;
    private JTextField instructorInstructorIdTextField;
    // End of variables declaration                   

    // Instructors
    private String instructorName = "";
    private String instructorAddress = "";
    private String instructorYearsOfExperience = "";
    private String instructorCitizenshipNo = "";
    private String instructorPanNo = "";
    private String instructorDob = "";
    private String instructorEmail = "";
    private String instructorPassword = "";
    private String instructorModule1 = "";
    private String instructorCourseId = "";
    private String instructorId = "";

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

    // Courses
    private String courseName = "";
    private String courseID = "";

    // Modules
    private String moduleName = "";
    private String moduleCode = "";
    private String moduleCourseId = "";
}