package com.frontend;

import java.io.FileOutputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


import com.database.JDBC;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



// import email from LoginPanel.java file of the same package

/**
 *
 * @author Diwash
 */
public class Instructor extends javax.swing.JFrame {

    public static String globalInstructorID;
    public static String globalCourseID;
    public static String globalModuleID;

    public static void initializeIDs() {
        Statement statement = JDBC.getStatement();

        String query1 = "SELECT Instructor_ID FROM instructor WHERE Email_address = '" + LoginPanel.email + "'";
        


        // execute the query, and set the global variables
        try {
            ResultSet rs1 = statement.executeQuery(query1);
            while (rs1.next()) {
                globalInstructorID = rs1.getString("Instructor_ID");
            }

            String query2 = "SELECT Course_ID FROM instructor_course WHERE Instructor_ID = '" + globalInstructorID + "'";
            ResultSet rs2 = statement.executeQuery(query2);
            while (rs2.next()) {
                globalCourseID = rs2.getString("Course_ID");
            }

            String query3 = "SELECT Module_code FROM instructor_module WHERE Instructor_ID = '" + globalInstructorID + "'";
            ResultSet rs3 = statement.executeQuery(query3);
            while (rs3.next()) {
                globalModuleID = rs3.getString("Module_code");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    private static DefaultTableModel assignmentDefaultTableModel = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Course ID", "Module ID", "Assignment Number", "Student ID", "Instructor ID", "Submission Status"
        }
    );

    private static DefaultTableModel reportDefaultTableModel = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Student ID", "Student Name", "Email", "Module Code", "Course ID"
        }
    );
    

    private static DefaultTableModel marksDefaultTableModel = new javax.swing.table.DefaultTableModel(
        new Object [][] {

        },
        new String [] {
            "Student ID", "Module ID", "Course_ID", "Marks"
        }
    );

    public static void showAssignmentDataInTableFromDb() {
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT * FROM assignment ORDER BY Assignment_Number ASC";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String assignmentNumber = rs.getString("Assignment_Number");
                String instructorId = rs.getString("Instructor_ID");
                String courseId = rs.getString("Course_ID");
                String moduleId = rs.getString("Module_code");
                String studentID = rs.getString("Student_ID");
                String submittedStatus = rs.getString("Submitted");

                assignmentDefaultTableModel.addRow(new Object[] {courseId, moduleId, assignmentNumber, studentID, instructorId, submittedStatus});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void showReportDataInTableFromDb() {
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT student.Student_ID, student.Name, student.College_email_address, student_course.Course_ID, student_module.Module_code FROM student INNER JOIN student_course ON student.Student_ID = student_course.Student_ID INNER JOIN student_module ON student.Student_ID = student_module.Student_ID WHERE student_course.Course_ID = '" + LoginPanel.courseID + "'" + " AND student_module.Module_code = '" + LoginPanel.moduleID + "'";
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String studentId = rs.getString("Student_ID");
                String studentName = rs.getString("Name");
                String studentEmail = rs.getString("College_email_address");
                String courseId = rs.getString("Course_ID");
                String moduleCode = rs.getString("Module_code");

                reportDefaultTableModel.addRow(new Object[] {studentId, studentName, studentEmail, moduleCode, courseId});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void showMarksDataInTableFromDb() {
        Statement statement = JDBC.getStatement();

        try {
            String query = "SELECT * FROM marks WHERE Course_ID = '" + LoginPanel.courseID + "'" + " AND Module_code = '" + LoginPanel.moduleID + "'";

            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                String studentId = rs.getString("Student_ID");
                String moduleCode = rs.getString("Module_code");
                String courseId = rs.getString("Course_ID");
                String marks = rs.getString("Marks");

                marksDefaultTableModel.addRow(new Object[] {studentId, moduleCode, courseId, marks});
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public Instructor() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        instructorAddAssignment = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        instructorAssignmentNumber = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        instructorInstructorId = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        instructorCourseId = new javax.swing.JComboBox<>();
        assignmentNumberErrorMessage = new javax.swing.JLabel();
        assignmentNumberErrorMessage.setVisible(false);
        courseIdErrorMessage = new javax.swing.JLabel();
        courseIdErrorMessage.setVisible(false);
        moduleIdErrorMessage = new javax.swing.JLabel();
        moduleIdErrorMessage.setVisible(false);
        jLabel7 = new javax.swing.JLabel();
        instructorModuleId = new javax.swing.JComboBox<>();
        instructorIdErrorMessage = new javax.swing.JLabel();
        instructorIdErrorMessage.setVisible(false);
        jPanel8 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        refreshAssignment = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        instructorLogoutButton1 = new javax.swing.JToggleButton();
        jPanel23 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel26 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        jTextField38 = new javax.swing.JTextField();
        refreshReport = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jPanel27 = new javax.swing.JPanel();
        instructorLogoutButton2 = new javax.swing.JToggleButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        jTextField39 = new javax.swing.JTextField();
        refreshMarks = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        jPanel30 = new javax.swing.JPanel();
        instructorLogoutButton3 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));

        jPanel2.setBackground(new java.awt.Color(255, 36, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome Instructor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(589, 589, 589))
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

        jPanel6.setBackground(new java.awt.Color(29, 29, 29));

        jPanel7.setBackground(new java.awt.Color(23, 23, 23));
        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        instructorAddAssignment.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        instructorAddAssignment.setText("Add Assignment");
        instructorAddAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorAddAssignmentActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Assignment Number:");

        instructorAssignmentNumber.setText("Enter Assignment Number");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Course ID:");


        Statement statement = JDBC.getStatement();

        String query3 = "SELECT Instructor_ID FROM instructor WHERE Email_address = '" + LoginPanel.email + "'";
        ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(query3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        List<String> instructorIds = new ArrayList<>();
        instructorIds.add("Select Instructor ID");
        try {
            while (resultSet.next()) {
                try {
                    instructorIds.add(resultSet.getString("Instructor_ID"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String[] instructorIdsArray = instructorIds.toArray(new String[0]);

        instructorInstructorId.setModel(new javax.swing.DefaultComboBoxModel<>(instructorIdsArray));
        instructorInstructorId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorInstructorIdActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Instructor ID:");

        
        String query = "SELECT Course_ID FROM instructor_course WHERE Instructor_ID = '" + LoginPanel.id + "'";
		try {
			resultSet = statement.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
        List<String> courseIds = new ArrayList<>();
        courseIds.add("Select Courses");
        try {
            while(resultSet.next()) {
                try{
                courseIds.add(resultSet.getString("Course_ID"));
                }catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
			e.printStackTrace();
		}
        String[] courseIdsArray = courseIds.toArray(new String[0]);
        instructorCourseId.setModel(new javax.swing.DefaultComboBoxModel<>(courseIdsArray));
        instructorCourseId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorCourseIdActionPerformed(evt);
            }
        });

        assignmentNumberErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        assignmentNumberErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        assignmentNumberErrorMessage.setText("Assignment Number cannot be empty!!!");

        courseIdErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        courseIdErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        courseIdErrorMessage.setText("Course ID cannot be empty!!!");

        moduleIdErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        moduleIdErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        moduleIdErrorMessage.setText("Module ID cannot be empty!!!");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Module ID:");


        String query2 = "SELECT Module_code FROM instructor_module WHERE Instructor_ID = '" + LoginPanel.id + "'";
        try {
            resultSet = statement.executeQuery(query2);
        } catch (SQLException e) {
            e.printStackTrace();
		}
        List<String> moduleIds = new ArrayList<>();
        moduleIds.add("Select Modules");

        try {
            while (resultSet.next()) {
                try {
                    moduleIds.add(resultSet.getString("Module_code"));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String[] moduleIdsArray = moduleIds.toArray(new String[0]);

        instructorModuleId.setModel(new javax.swing.DefaultComboBoxModel<>(moduleIdsArray));
        instructorModuleId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorModuleIdActionPerformed(evt);
            }
        });

        instructorIdErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        instructorIdErrorMessage.setForeground(new java.awt.Color(255, 0, 51));
        instructorIdErrorMessage.setText("Instructor ID cannot be empty!!!");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(202, 202, 202)
                        .addComponent(instructorAddAssignment)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel12)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(instructorInstructorId, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(instructorAssignmentNumber, javax.swing.GroupLayout.DEFAULT_SIZE, 363, Short.MAX_VALUE)
                            .addComponent(instructorCourseId, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(instructorModuleId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(instructorIdErrorMessage)
                            .addComponent(moduleIdErrorMessage)
                            .addComponent(courseIdErrorMessage)
                            .addComponent(assignmentNumberErrorMessage))))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(instructorAssignmentNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel12))
                .addGap(1, 1, 1)
                .addComponent(assignmentNumberErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(instructorCourseId, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(courseIdErrorMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(instructorModuleId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(moduleIdErrorMessage)
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructorInstructorId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(5, 5, 5)
                .addComponent(instructorIdErrorMessage)
                .addGap(18, 18, 18)
                .addComponent(instructorAddAssignment)
                .addGap(277, 277, 277))
        );

        jPanel8.setBackground(new java.awt.Color(23, 23, 23));
        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jPanel11.setBackground(new java.awt.Color(23, 23, 23));
        jPanel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Search Assignments:");

        jTextField10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField10ActionPerformed(evt);
            }
        });

        refreshAssignment.setBackground(new java.awt.Color(23, 23, 23));
        refreshAssignment.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        refreshAssignment.setForeground(new java.awt.Color(255, 255, 255));
        refreshAssignment.setText("Refresh");
        refreshAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshAssignmentActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(23, 23, 23));
        jButton4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 384, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton4)
                .addGap(43, 43, 43)
                .addComponent(refreshAssignment)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4)
                    .addComponent(refreshAssignment))
                .addGap(27, 27, 27))
        );

        jTable1.setModel(assignmentDefaultTableModel);
        jScrollPane1.setViewportView(jTable1);

        jPanel12.setBackground(new java.awt.Color(23, 23, 23));
        jPanel12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        instructorLogoutButton1.setBackground(new java.awt.Color(23, 23, 23));
        instructorLogoutButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        instructorLogoutButton1.setForeground(new java.awt.Color(255, 255, 255));
        instructorLogoutButton1.setText("Log Out");
        instructorLogoutButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorLogoutButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(381, 381, 381)
                .addComponent(instructorLogoutButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(instructorLogoutButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 659, Short.MAX_VALUE))
                .addGap(0, 316, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Assignmets", jPanel6);

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

        refreshReport.setBackground(new java.awt.Color(23, 23, 23));
        refreshReport.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        refreshReport.setForeground(new java.awt.Color(255, 255, 255));
        refreshReport.setText("Refresh");
        refreshReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshReportActionPerformed(evt);
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
                .addComponent(refreshReport)
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
                    .addComponent(refreshReport))
                .addGap(27, 27, 27))
        );

        jTable4.setModel(reportDefaultTableModel);
        jScrollPane4.setViewportView(jTable4);

        jPanel27.setBackground(new java.awt.Color(23, 23, 23));
        jPanel27.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        instructorLogoutButton2.setBackground(new java.awt.Color(23, 23, 23));
        instructorLogoutButton2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        instructorLogoutButton2.setForeground(new java.awt.Color(255, 255, 255));
        instructorLogoutButton2.setText("Log Out");
        instructorLogoutButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorLogoutButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(instructorLogoutButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(646, 646, 646))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(instructorLogoutButton2)
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

        jTabbedPane1.addTab("Student", jPanel23);

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

        refreshMarks.setBackground(new java.awt.Color(23, 23, 23));
        refreshMarks.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        refreshMarks.setForeground(new java.awt.Color(255, 255, 255));
        refreshMarks.setText("Refresh");
        refreshMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshMarksActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(23, 23, 23));
        jButton18.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("Search");

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
                .addComponent(jButton18)
                .addGap(43, 43, 43)
                .addComponent(refreshMarks)
                .addContainerGap(671, Short.MAX_VALUE))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel52)
                    .addComponent(jTextField39, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18)
                    .addComponent(refreshMarks))
                .addGap(27, 27, 27))
        );

        jTable5.setModel(marksDefaultTableModel);
        jScrollPane5.setViewportView(jTable5);

        jTable5.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                Object[] options = {"Update", "no"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to update the selected marks?", "Update marks", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        	
                if (n == 0) {   // Update
                    var updateMarks = new updateMarks();
                    updateMarks.setVisible(true);
                    JButton updateButton = updateMarks.getMarksUpdatedUpdateButton();

                    String courseID1 = "";
                    String sid = "";
                    String moduleID = "";

                    String previousMarks = "";
                    Statement statement = JDBC.getStatement();

                    

                    for (int columnIndex=0; columnIndex < jTable5.getColumnCount(); columnIndex++) {
                        if (sid.isEmpty()){
                            sid = jTable5.getValueAt(jTable5.getSelectedRow(), columnIndex).toString();
                        } else if (moduleID.isEmpty()){
                            moduleID = jTable5.getValueAt(jTable5.getSelectedRow(), columnIndex).toString();
                        } else if (courseID1.isEmpty()){
                            courseID1 = jTable5.getValueAt(jTable5.getSelectedRow(), columnIndex).toString();
                        } else if (previousMarks.isEmpty()){
                            previousMarks = jTable5.getValueAt(jTable5.getSelectedRow(), columnIndex).toString();
                        }

                    }
                    final String previousID = courseID1;
                    final String previousSid = sid;
                    final String previousModuleID = moduleID;

                    updateMarks.getMarksUpdatedMarks().setText(previousMarks);

                    updateButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                            String updatedMarks = updateMarks.getMarksUpdatedMarks().getText();


                            try {
                                String updateQuery = "UPDATE marks SET Marks = '" + updatedMarks + "' WHERE Student_ID = '" + previousSid + "' AND Module_Code = '" + previousModuleID + "' AND Course_ID = '" + previousID + "'";
                                statement.executeUpdate(updateQuery);
                                JOptionPane.showMessageDialog(null, "Data is updated");
                            } catch (Exception ex) {
                                System.out.println(ex);
                            }
                        }
                    });

                    
                } else {
                    return;
                }
                
            }});



        jPanel30.setBackground(new java.awt.Color(23, 23, 23));
        jPanel30.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(35, 35, 35), 4, true));

        instructorLogoutButton3.setBackground(new java.awt.Color(23, 23, 23));
        instructorLogoutButton3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        instructorLogoutButton3.setForeground(new java.awt.Color(255, 255, 255));
        instructorLogoutButton3.setText("Log Out");
        instructorLogoutButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                instructorLogoutButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(instructorLogoutButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(646, 646, 646))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel30Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(instructorLogoutButton3)
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

        jTabbedPane1.addTab("Marks", jPanel24);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1012, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                      

    private void instructorLogoutButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                                        
    	this.dispose();
        new LoginPanel().setVisible(true);
    }                                                       

    private void refreshReportActionPerformed(java.awt.event.ActionEvent evt) {                                              
    	DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
    	showReportDataInTableFromDb();
    }                                             

    private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void instructorLogoutButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                                        
    	this.dispose();
        new LoginPanel().setVisible(true);
    }                                                       

    private void refreshAssignmentActionPerformed(java.awt.event.ActionEvent evt) {                                                  
    	DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
    	showAssignmentDataInTableFromDb();
    }                                                 

    private void jTextField10ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void instructorAddAssignmentActionPerformed(java.awt.event.ActionEvent evt) {                                                        
        String assignmentId = instructorAssignmentNumber.getText();
        String courseId = instructorCourseId.getSelectedItem().toString();
        String moduleId = instructorModuleId.getSelectedItem().toString();
        String instructorId = instructorInstructorId.getSelectedItem().toString();

        if (assignmentId.equals("Enter Assignment Number") || courseId.equals("Select Courses") || moduleId.equals("Select Modules") || instructorId.equals("Select Instructor ID")) {
            if(assignmentId.equals("Enter Assignment Number")){
                assignmentNumberErrorMessage.setVisible(true);
            } else {
                assignmentNumberErrorMessage.setVisible(false);
            } 
            if(courseId.equals("Select Courses")){
                courseIdErrorMessage.setVisible(true);
            } else {
                courseIdErrorMessage.setVisible(false);
            }
            if(moduleId.equals("Select Modules")){
                moduleIdErrorMessage.setVisible(true);
            } else {
                moduleIdErrorMessage.setVisible(false);
            }
            if(instructorId.equals("Select Instructor ID")){
                instructorIdErrorMessage.setVisible(true);
            } else {
                instructorIdErrorMessage.setVisible(false);
            }
        } else {
            try {
                Statement statement = JDBC.getStatement();

                String query = "SELECT Student_ID FROM student";
                ResultSet rs = statement.executeQuery(query);
                ArrayList<String> studentIdList = new ArrayList<String>();
                while (rs.next()) {
                    String studentId = rs.getString("Student_ID");

                    studentIdList.add(studentId);
            }

            for (String studentId : studentIdList) {
                String query_ = "INSERT INTO assignment (Course_ID, Module_code, Assignment_Number, Student_ID, Instructor_ID, Submitted) VALUES ('" + courseId + "', '" + moduleId + "', '" + assignmentId + "', '" + studentId + "', '" + instructorId + "', NULL)";
                statement.executeUpdate(query_);
            }
            
            JOptionPane.showMessageDialog(null, "Assignment added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error in adding assignment");

        }
    }
    }                                                       

    private void instructorInstructorIdActionPerformed(java.awt.event.ActionEvent evt) {                                                       
    }                                                      

    private void instructorCourseIdActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    }                                                  

    private void instructorModuleIdActionPerformed(java.awt.event.ActionEvent evt) {                                                   
    }                                                  

    private void jTextField39ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void refreshMarksActionPerformed(java.awt.event.ActionEvent evt) {                                             
    	DefaultTableModel model = (DefaultTableModel) jTable5.getModel();
        model.setRowCount(0);
    	showMarksDataInTableFromDb();
    }                                            

    private void instructorLogoutButton3ActionPerformed(java.awt.event.ActionEvent evt) {                                                        
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
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instructor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instructor().setVisible(true);
            }
        });

        // Showing data in table from database when the application starts
        showAssignmentDataInTableFromDb();
        showReportDataInTableFromDb();
        showMarksDataInTableFromDb();

        // initializeIDs();
        System.out.println(globalCourseID);
        System.out.println(globalModuleID);
        System.out.println(globalInstructorID);

    }

    // Variables declaration                   
    private javax.swing.JLabel assignmentNumberErrorMessage;
    private javax.swing.JLabel courseIdErrorMessage;
    private javax.swing.JButton instructorAddAssignment;
    private javax.swing.JTextField instructorAssignmentNumber;
    private javax.swing.JComboBox<String> instructorCourseId;
    private javax.swing.JLabel instructorIdErrorMessage;
    private javax.swing.JComboBox<String> instructorInstructorId;
    private javax.swing.JToggleButton instructorLogoutButton1;
    private javax.swing.JToggleButton instructorLogoutButton2;
    private javax.swing.JToggleButton instructorLogoutButton3;
    private javax.swing.JComboBox<String> instructorModuleId;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTable jTable5;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JTextField jTextField39;
    private javax.swing.JLabel moduleIdErrorMessage;
    private javax.swing.JButton refreshAssignment;
    private javax.swing.JButton refreshMarks;
    private javax.swing.JButton refreshReport;
    // End of variables declaration                   
}