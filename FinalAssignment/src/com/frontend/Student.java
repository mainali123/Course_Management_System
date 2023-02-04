package com.frontend;

import java.sql.*;

import com.database.JDBC;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileOutputStream;


/**
 *
 * @author Diwash
 */
public class Student extends javax.swing.JFrame {


    private static DefaultTableModel reportDefaultTableModel = new javax.swing.table.DefaultTableModel( // Creating a table model for report table
        new Object [][] {

        },
        new String [] {
            "Student ID", "Name", "Email", "Course_ID"
        }
    );


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
            e.printStackTrace();
        }
    }
    public Student() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
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
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 362, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(576, 576, 576))
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

        jTable4.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
                Object[] options = {"Generate", "Don't generate"};
                int n = JOptionPane.showOptionDialog(null, "Do you want to Generate report of the selected student?", "Generate Report", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        	
                if (n == 0) {   // Generate
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
                } else {    // don't generate
                    return;
                }


                
            }
        });
        jTable4.setDefaultEditor(Object.class, null);


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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }                

    private void jTextField38ActionPerformed(java.awt.event.ActionEvent evt) {                                             
    }                                            

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    	DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        model.setRowCount(0);
        showReportDataInTableFromDb();
    }                                         

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {                                               
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
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Student.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Student().setVisible(true);
            }
        });

        // Show Report Data in Table From Database when the application starts
        showReportDataInTableFromDb();
    }

    // Variables declaration                
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField jTextField38;
    private javax.swing.JToggleButton jToggleButton8;
    // End of variables declaration                   
}