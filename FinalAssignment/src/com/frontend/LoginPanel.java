/**
 * @author Diwash Mainali
 */
// Default email: diwash@mainali.com
// Default password: diwash
package com.frontend;


import java.util.*;
import java.sql.*;


public class LoginPanel extends javax.swing.JFrame {

    /**
     * Creates new form LoginPanel
     */
    public LoginPanel() {
        initComponents();
    }                     
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        loginEmail = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        loginRole = new javax.swing.JComboBox<>();
        loginButton = new javax.swing.JButton();
        emailAddressErrorMessage = new javax.swing.JLabel();
        emailAddressErrorMessage.setVisible(false);
        passwordErrorMessage = new javax.swing.JLabel();
        passwordErrorMessage.setVisible(false);
        roleErrorMessage = new javax.swing.JLabel();
        roleErrorMessage.setVisible(false);
        loginErrorMessage = new javax.swing.JLabel();
        loginErrorMessage.setVisible(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(26, 26, 26));
        jPanel1.setPreferredSize(new java.awt.Dimension(1200, 750));

        jPanel2.setBackground(new java.awt.Color(255, 36, 0));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Course Management System");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap(943, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(401, 401, 401))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 30));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email: ");

        loginEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginEmailActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 30));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password:");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 30));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Role:");

        loginRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Select Role", "Course_Administrator", "Instructor", "Student"}));

        loginButton.setFont(new java.awt.Font("Times New Roman", 0, 30));
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    loginButtonActionPerformed(evt);

                    // email address validation
                    if (loginEmail.getText().equals("")) {  // Checking weather user has entered an email address or not
                        emailAddressErrorMessage.setVisible(true);
                    } else {
                        emailAddressErrorMessage.setVisible(false);
                    }

                    // password validation
                    char[] password = loginPassword.getPassword();  // Gets the password as an array of characters. It is impossible to apply .getText() method on JPasswordField because it is a deprecated method.
                    if (password.length == 0) {   // Checking weather user has entered a password or not
                        passwordErrorMessage.setVisible(true);
                    } else {
                        passwordErrorMessage.setVisible(false);
                    }

                    // role validation
                    if (loginRole.getSelectedItem().equals("Select Role")) {    // Checking weather user has selected a role or not
                        roleErrorMessage.setVisible(true);
                    } else {
                        roleErrorMessage.setVisible(false);
                    }

                    // if all fields are valid
                    if (!loginEmail.getText().equals("") && password.length != 0 && !loginRole.getSelectedItem().equals("Select Role")) {

                        if (loginRole.getSelectedItem().equals("Course_Administrator")) {
                            if (loginEmail.getText().equals("diwash@mainali.com") && Arrays.equals(password, "diwash".toCharArray())) {
                                CourseAdministrator courseAdministrator = new CourseAdministrator();    // Creating object of Course Administrator class
                                courseAdministrator.setVisible(true);   // Redirect to Course Administrator page if email and password are correct
                            } else{
                                loginErrorMessage.setVisible(true);
                            }
                        }
                            else if (loginRole.getSelectedItem().equals("Student")) {
                            if (loginEmail.getText().equals("diwash@mainali.com") && Arrays.equals(password, "diwash".toCharArray())) {
                                    Student student = new Student();    // Creating object of Student class
                                    student.setVisible(true);   // Redirect to Student page if email and password are correct
                                }

                             else {
                                loginErrorMessage.setVisible(true);
                            }
                        }
                            else if (loginRole.getSelectedItem().equals("Instructor")) {
                                if (loginEmail.getText().equals("diwash@mainali.com") && Arrays.equals(password, "diwash".toCharArray())) {
                                    Instructor instructor = new Instructor();   // Creating object of Instructor class
                                    instructor.setVisible(true);    // Redirect to Instructor page if email and password are correct
                                }
                             else {
                                loginErrorMessage.setVisible(true);   // Show error message if email and password are incorrect
                            }
                        }
                    }
                }
                 catch(SQLException e){
                                e.printStackTrace();
                            }
                        }
                    });

                    emailAddressErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 14));
                    emailAddressErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
                    emailAddressErrorMessage.setText("Invalid Email Address");

                    passwordErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 14));
                    passwordErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
                    passwordErrorMessage.setText("Invalid Password Entered");

                    roleErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 14)); 
                    roleErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
                    roleErrorMessage.setText("Invalid Role");

                    loginErrorMessage.setFont(new java.awt.Font("Times New Roman", 1, 18)); 
                    loginErrorMessage.setForeground(new java.awt.Color(255, 0, 0));
                    loginErrorMessage.setText("Invalid Login Detail entered!!!");

                    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                    jPanel1.setLayout(jPanel1Layout);
                    jPanel1Layout.setHorizontalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(702, 702, 702)
                                                            .addComponent(loginButton))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(319, 319, 319)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addComponent(jLabel4)
                                                                    .addComponent(jLabel3)
                                                                    .addComponent(jLabel2))
                                                            .addGap(28, 28, 28)
                                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addComponent(loginEmail)
                                                                    .addComponent(loginPassword)
                                                                    .addComponent(loginRole, 0, 684, Short.MAX_VALUE)
                                                                    .addComponent(emailAddressErrorMessage)
                                                                    .addComponent(passwordErrorMessage)
                                                                    .addComponent(roleErrorMessage)))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                            .addGap(643, 643, 643)
                                                            .addComponent(loginErrorMessage)))
                                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    );
                    jPanel1Layout.setVerticalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(96, 96, 96)
                                            .addComponent(loginErrorMessage)
                                            .addGap(37, 37, 37)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(loginEmail))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(emailAddressErrorMessage)
                                            .addGap(48, 48, 48)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(loginPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(passwordErrorMessage)
                                            .addGap(42, 42, 42)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(loginRole))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(roleErrorMessage)
                                            .addGap(97, 97, 97)
                                            .addComponent(loginButton)
                                            .addGap(0, 445, Short.MAX_VALUE))
                    );

                    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                    getContentPane().setLayout(layout);
                    layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1920, Short.MAX_VALUE)
                    );
                    layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
                    );

                    pack();
                }

                private void loginEmailActionPerformed (java.awt.event.ActionEvent evt){
                }

                private void loginButtonActionPerformed (java.awt.event.ActionEvent evt) throws SQLException {
                }

                /**
                 * @param args the command line arguments
                 */
                public static void main (String args[]){
                    try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                            if ("Nimbus".equals(info.getName())) {
                                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                break;
                            }
                        }
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(LoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
                    }

                    /* Create and display the form */
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new LoginPanel().setVisible(true);
                        }
                    });
                }

                // Variables declaration - do not modify
                private javax.swing.JLabel emailAddressErrorMessage;
                private javax.swing.JLabel jLabel1;
                private javax.swing.JLabel jLabel2;
                private javax.swing.JLabel jLabel3;
                private javax.swing.JLabel jLabel4;
                private javax.swing.JPanel jPanel1;
                private javax.swing.JPanel jPanel2;
                private javax.swing.JButton loginButton;
                private static javax.swing.JTextField loginEmail;
                private javax.swing.JLabel loginErrorMessage;
                private static javax.swing.JPasswordField loginPassword;
                private javax.swing.JComboBox<String> loginRole;
                private javax.swing.JLabel passwordErrorMessage;
                private javax.swing.JLabel roleErrorMessage;
                // End of variables declaration
            }
