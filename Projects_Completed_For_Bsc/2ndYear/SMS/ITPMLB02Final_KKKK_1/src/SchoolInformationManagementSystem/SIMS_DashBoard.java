
package SchoolInformationManagementSystem;

import AMS.ADMIN_AdministrativePanel;
import AMS.ADMIN_AdministrativeTasks;
import SPMS.SPMS_StudentProfileManageStudent;
import TMS.TMS_Timetablemangemnet;
import java.awt.CardLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;



public class SIMS_DashBoard extends javax.swing.JFrame {
    public SIMS_DashBoard() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subSystemHomePanel = new javax.swing.JPanel();
        adminPanel = new javax.swing.JPanel();
        btnEmployeeManagement9 = new javax.swing.JButton();
        libraryManagement = new javax.swing.JPanel();
        btnEmployeeManagement3 = new javax.swing.JButton();
        studentProfileManagement = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        employeeManagement = new javax.swing.JPanel();
        btnEmployeeManagement2 = new javax.swing.JButton();
        timeTableManaement = new javax.swing.JPanel();
        btnEmployeeManagement4 = new javax.swing.JButton();
        cafeteriaManagement = new javax.swing.JPanel();
        btnEmployeeManagement5 = new javax.swing.JButton();
        hostelManagement = new javax.swing.JPanel();
        btnEmployeeManagement6 = new javax.swing.JButton();
        eventManagement = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        btnEmployeeManagement7 = new javax.swing.JButton();
        studentInfoManagement = new javax.swing.JPanel();
        btnEmployeeManagement8 = new javax.swing.JButton();
        Topic = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        sidemenu = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        btnHostelManagement = new javax.swing.JButton();
        btnTimeTableManagement = new javax.swing.JButton();
        btnStudentProfileManagement = new javax.swing.JButton();
        btnCafeteriaManagement = new javax.swing.JButton();
        btnEventManagement = new javax.swing.JButton();
        btnEmployeeManagement = new javax.swing.JButton();
        btnLibraryManagement = new javax.swing.JButton();
        btnStudentInfoManagement = new javax.swing.JButton();
        btnLibraryManagement1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(249, 249, 249));
        setMaximumSize(new java.awt.Dimension(1350, 720));
        setMinimumSize(new java.awt.Dimension(1350, 720));
        setPreferredSize(new java.awt.Dimension(1350, 720));
        setSize(new java.awt.Dimension(1350, 720));

        subSystemHomePanel.setBackground(new java.awt.Color(255, 255, 204));
        subSystemHomePanel.setMaximumSize(new java.awt.Dimension(1120, 580));
        subSystemHomePanel.setMinimumSize(new java.awt.Dimension(1120, 580));
        subSystemHomePanel.setPreferredSize(new java.awt.Dimension(1120, 580));
        subSystemHomePanel.setLayout(new java.awt.CardLayout());

        adminPanel.setBackground(new java.awt.Color(255, 204, 153));

        btnEmployeeManagement9.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement9.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/ad1.png"))); // NOI18N
        btnEmployeeManagement9.setBorderPainted(false);
        btnEmployeeManagement9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout adminPanelLayout = new javax.swing.GroupLayout(adminPanel);
        adminPanel.setLayout(adminPanelLayout);
        adminPanelLayout.setHorizontalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, adminPanelLayout.createSequentialGroup()
                .addComponent(btnEmployeeManagement9, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        adminPanelLayout.setVerticalGroup(
            adminPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(adminPanelLayout.createSequentialGroup()
                .addComponent(btnEmployeeManagement9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(adminPanel, "adminPanel");

        libraryManagement.setBackground(new java.awt.Color(255, 204, 153));

        btnEmployeeManagement3.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement3.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_LMS/libs1t.jpg"))); // NOI18N
        btnEmployeeManagement3.setBorderPainted(false);
        btnEmployeeManagement3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout libraryManagementLayout = new javax.swing.GroupLayout(libraryManagement);
        libraryManagement.setLayout(libraryManagementLayout);
        libraryManagementLayout.setHorizontalGroup(
            libraryManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, libraryManagementLayout.createSequentialGroup()
                .addComponent(btnEmployeeManagement3, javax.swing.GroupLayout.PREFERRED_SIZE, 997, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        libraryManagementLayout.setVerticalGroup(
            libraryManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(libraryManagementLayout.createSequentialGroup()
                .addComponent(btnEmployeeManagement3)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(libraryManagement, "LibraryManagement");

        studentProfileManagement.setBackground(new java.awt.Color(255, 255, 204));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/spmsnewhomeimgk.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentProfileManagementLayout = new javax.swing.GroupLayout(studentProfileManagement);
        studentProfileManagement.setLayout(studentProfileManagementLayout);
        studentProfileManagementLayout.setHorizontalGroup(
            studentProfileManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentProfileManagementLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 1021, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        studentProfileManagementLayout.setVerticalGroup(
            studentProfileManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentProfileManagementLayout.createSequentialGroup()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 694, Short.MAX_VALUE)
                .addContainerGap())
        );

        subSystemHomePanel.add(studentProfileManagement, "studentProfileManagement");

        employeeManagement.setBackground(new java.awt.Color(204, 255, 204));

        btnEmployeeManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/emsm1t.png"))); // NOI18N
        btnEmployeeManagement2.setBorderPainted(false);
        btnEmployeeManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout employeeManagementLayout = new javax.swing.GroupLayout(employeeManagement);
        employeeManagement.setLayout(employeeManagementLayout);
        employeeManagementLayout.setHorizontalGroup(
            employeeManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeManagement2, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
        );
        employeeManagementLayout.setVerticalGroup(
            employeeManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(employeeManagementLayout.createSequentialGroup()
                .addComponent(btnEmployeeManagement2, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(employeeManagement, "employeeManagement");

        timeTableManaement.setBackground(new java.awt.Color(255, 204, 255));

        btnEmployeeManagement4.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement4.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_TMS/tmst1.png"))); // NOI18N
        btnEmployeeManagement4.setBorderPainted(false);
        btnEmployeeManagement4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout timeTableManaementLayout = new javax.swing.GroupLayout(timeTableManaement);
        timeTableManaement.setLayout(timeTableManaementLayout);
        timeTableManaementLayout.setHorizontalGroup(
            timeTableManaementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(timeTableManaementLayout.createSequentialGroup()
                .addComponent(btnEmployeeManagement4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        timeTableManaementLayout.setVerticalGroup(
            timeTableManaementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeManagement4, javax.swing.GroupLayout.PREFERRED_SIZE, 690, Short.MAX_VALUE)
        );

        subSystemHomePanel.add(timeTableManaement, "timeTableManagement");

        cafeteriaManagement.setBackground(new java.awt.Color(153, 153, 255));

        btnEmployeeManagement5.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement5.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_CMS/cmss1t.png"))); // NOI18N
        btnEmployeeManagement5.setBorderPainted(false);
        btnEmployeeManagement5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout cafeteriaManagementLayout = new javax.swing.GroupLayout(cafeteriaManagement);
        cafeteriaManagement.setLayout(cafeteriaManagementLayout);
        cafeteriaManagementLayout.setHorizontalGroup(
            cafeteriaManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeManagement5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        cafeteriaManagementLayout.setVerticalGroup(
            cafeteriaManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeManagement5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        subSystemHomePanel.add(cafeteriaManagement, "cafeteriaManagement");

        hostelManagement.setBackground(new java.awt.Color(204, 102, 255));

        btnEmployeeManagement6.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement6.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_HMS/hmsh1t.jpg"))); // NOI18N
        btnEmployeeManagement6.setBorderPainted(false);
        btnEmployeeManagement6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hostelManagementLayout = new javax.swing.GroupLayout(hostelManagement);
        hostelManagement.setLayout(hostelManagementLayout);
        hostelManagementLayout.setHorizontalGroup(
            hostelManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hostelManagementLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnEmployeeManagement6, javax.swing.GroupLayout.PREFERRED_SIZE, 861, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(95, Short.MAX_VALUE))
        );
        hostelManagementLayout.setVerticalGroup(
            hostelManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hostelManagementLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEmployeeManagement6, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(hostelManagement, "hostelManagement");

        eventManagement.setBackground(new java.awt.Color(0, 204, 204));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel12.setText("This is Event Management Home Screen ");

        btnEmployeeManagement7.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement7.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement7.setText("Event Management ");
        btnEmployeeManagement7.setBorderPainted(false);
        btnEmployeeManagement7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout eventManagementLayout = new javax.swing.GroupLayout(eventManagement);
        eventManagement.setLayout(eventManagementLayout);
        eventManagementLayout.setHorizontalGroup(
            eventManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eventManagementLayout.createSequentialGroup()
                .addGroup(eventManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eventManagementLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addComponent(btnEmployeeManagement7, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(eventManagementLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel12)))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        eventManagementLayout.setVerticalGroup(
            eventManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, eventManagementLayout.createSequentialGroup()
                .addContainerGap(129, Short.MAX_VALUE)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(btnEmployeeManagement7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(293, 293, 293))
        );

        subSystemHomePanel.add(eventManagement, "eventManagement");

        studentInfoManagement.setBackground(new java.awt.Color(255, 51, 102));

        btnEmployeeManagement8.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement8.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/simst1.jpg"))); // NOI18N
        btnEmployeeManagement8.setBorderPainted(false);
        btnEmployeeManagement8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentInfoManagementLayout = new javax.swing.GroupLayout(studentInfoManagement);
        studentInfoManagement.setLayout(studentInfoManagementLayout);
        studentInfoManagementLayout.setHorizontalGroup(
            studentInfoManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeManagement8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 989, Short.MAX_VALUE)
        );
        studentInfoManagementLayout.setVerticalGroup(
            studentInfoManagementLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmployeeManagement8, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );

        subSystemHomePanel.add(studentInfoManagement, "studentInfoManagement");

        Topic.setBackground(new java.awt.Color(26, 56, 103));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("School Information Management System ");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Student Profile Management");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/rsz_logop.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TopicLayout = new javax.swing.GroupLayout(Topic);
        Topic.setLayout(TopicLayout);
        TopicLayout.setHorizontalGroup(
            TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopicLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(TopicLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel53)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        TopicLayout.setVerticalGroup(
            TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TopicLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel53)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidemenu.setBackground(new java.awt.Color(41, 48, 66));

        home.setBackground(new java.awt.Color(41, 48, 66));
        home.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/home.png"))); // NOI18N
        home.setContentAreaFilled(false);
        home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });

        jButton34.setBackground(new java.awt.Color(41, 48, 66));
        jButton34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton34.setForeground(new java.awt.Color(255, 255, 255));
        jButton34.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/lock.png"))); // NOI18N
        jButton34.setContentAreaFilled(false);
        jButton34.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(41, 48, 66));

        btnHostelManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnHostelManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHostelManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnHostelManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/hostell.png"))); // NOI18N
        btnHostelManagement.setText("Hostel  Management ");
        btnHostelManagement.setBorderPainted(false);
        btnHostelManagement.setContentAreaFilled(false);
        btnHostelManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHostelManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHostelManagementActionPerformed(evt);
            }
        });

        btnTimeTableManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnTimeTableManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimeTableManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnTimeTableManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/timetbl.png"))); // NOI18N
        btnTimeTableManagement.setText("Time Table Management ");
        btnTimeTableManagement.setBorderPainted(false);
        btnTimeTableManagement.setContentAreaFilled(false);
        btnTimeTableManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimeTableManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeTableManagementActionPerformed(evt);
            }
        });

        btnStudentProfileManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnStudentProfileManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStudentProfileManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentProfileManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/resultk.png"))); // NOI18N
        btnStudentProfileManagement.setText("Student Profile Management ");
        btnStudentProfileManagement.setBorderPainted(false);
        btnStudentProfileManagement.setContentAreaFilled(false);
        btnStudentProfileManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudentProfileManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentProfileManagementActionPerformed(evt);
            }
        });

        btnCafeteriaManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnCafeteriaManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCafeteriaManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnCafeteriaManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/canteen.png"))); // NOI18N
        btnCafeteriaManagement.setText("Cafeteria Management ");
        btnCafeteriaManagement.setBorderPainted(false);
        btnCafeteriaManagement.setContentAreaFilled(false);
        btnCafeteriaManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCafeteriaManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafeteriaManagementActionPerformed(evt);
            }
        });

        btnEventManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnEventManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEventManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnEventManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/eventnew.png"))); // NOI18N
        btnEventManagement.setText("Event Management ");
        btnEventManagement.setContentAreaFilled(false);
        btnEventManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEventManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventManagementActionPerformed(evt);
            }
        });

        btnEmployeeManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/empm.png"))); // NOI18N
        btnEmployeeManagement.setText("Employee Management ");
        btnEmployeeManagement.setBorderPainted(false);
        btnEmployeeManagement.setContentAreaFilled(false);
        btnEmployeeManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagementActionPerformed(evt);
            }
        });

        btnLibraryManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnLibraryManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLibraryManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnLibraryManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/lib48.png"))); // NOI18N
        btnLibraryManagement.setText("Library Management ");
        btnLibraryManagement.setBorderPainted(false);
        btnLibraryManagement.setContentAreaFilled(false);
        btnLibraryManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibraryManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryManagementActionPerformed(evt);
            }
        });

        btnStudentInfoManagement.setBackground(new java.awt.Color(41, 48, 66));
        btnStudentInfoManagement.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStudentInfoManagement.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentInfoManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/stuinfonew.png"))); // NOI18N
        btnStudentInfoManagement.setText("Student Information Management ");
        btnStudentInfoManagement.setContentAreaFilled(false);
        btnStudentInfoManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudentInfoManagement.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentInfoManagementActionPerformed(evt);
            }
        });

        btnLibraryManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnLibraryManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLibraryManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnLibraryManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/adi.png"))); // NOI18N
        btnLibraryManagement1.setText("Administrative Panel");
        btnLibraryManagement1.setBorderPainted(false);
        btnLibraryManagement1.setContentAreaFilled(false);
        btnLibraryManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibraryManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryManagement1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStudentInfoManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStudentProfileManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCafeteriaManagement)
                            .addComponent(btnHostelManagement)
                            .addComponent(btnEventManagement)
                            .addComponent(btnLibraryManagement)
                            .addComponent(btnEmployeeManagement)
                            .addComponent(btnTimeTableManagement)
                            .addComponent(btnLibraryManagement1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLibraryManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLibraryManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudentProfileManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployeeManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimeTableManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCafeteriaManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHostelManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEventManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudentInfoManagement))
        );

        javax.swing.GroupLayout sidemenuLayout = new javax.swing.GroupLayout(sidemenu);
        sidemenu.setLayout(sidemenuLayout);
        sidemenuLayout.setHorizontalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addGroup(sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidemenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidemenuLayout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(home)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton34)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidemenuLayout.setVerticalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 361, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(subSystemHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 989, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Topic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1007, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Topic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subSystemHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(sidemenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        try {
            new SPMS_StudentProfileManageStudent().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SIMS_DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SIMS_DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHostelManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHostelManagementActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "hostelManagement");
    }//GEN-LAST:event_btnHostelManagementActionPerformed

    

    private void btnTimeTableManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeTableManagementActionPerformed

        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "timeTableManagement");
    }//GEN-LAST:event_btnTimeTableManagementActionPerformed

    private void btnStudentProfileManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentProfileManagementActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "studentProfileManagement");
    }//GEN-LAST:event_btnStudentProfileManagementActionPerformed

    private void btnCafeteriaManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafeteriaManagementActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "cafeteriaManagement");
    }//GEN-LAST:event_btnCafeteriaManagementActionPerformed

    private void btnEventManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventManagementActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "eventManagement");
    }//GEN-LAST:event_btnEventManagementActionPerformed

    private void btnEmployeeManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagementActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "employeeManagement");
    }//GEN-LAST:event_btnEmployeeManagementActionPerformed

    private void btnLibraryManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagementActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "LibraryManagement");
    }//GEN-LAST:event_btnLibraryManagementActionPerformed

    private void btnStudentInfoManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentInfoManagementActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "studentInfoManagement");
    }//GEN-LAST:event_btnStudentInfoManagementActionPerformed

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_homeActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
        new SIMS_DashBoard().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnEmployeeManagement3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement3ActionPerformed
//        dispose();
//        new LMS_LibraryManagementSystem().setVisible(true);
    }//GEN-LAST:event_btnEmployeeManagement3ActionPerformed

    private void btnEmployeeManagement4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement4ActionPerformed
        dispose();
        try {  
            new TMS_Timetablemangemnet().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SIMS_DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SIMS_DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
                                                          

    }//GEN-LAST:event_btnEmployeeManagement4ActionPerformed

    private void btnEmployeeManagement5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement5ActionPerformed
//        dispose();
//        new CMS_CafeteriaManagementSystem().setVisible(true);
    }//GEN-LAST:event_btnEmployeeManagement5ActionPerformed

    private void btnEmployeeManagement6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement6ActionPerformed
//
//        dispose();
//        new HMS_Home().setVisible(true);  
           
    }//GEN-LAST:event_btnEmployeeManagement6ActionPerformed

    private void btnEmployeeManagement7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement7ActionPerformed
        
    }//GEN-LAST:event_btnEmployeeManagement7ActionPerformed

    private void btnEmployeeManagement8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEmployeeManagement8ActionPerformed

    private void btnEmployeeManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement2ActionPerformed

        dispose();
        //new EMS_EmployeeManagementSystem().setVisible(true);
    }//GEN-LAST:event_btnEmployeeManagement2ActionPerformed

    private void btnLibraryManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagement1ActionPerformed

        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "adminPanel");
    }//GEN-LAST:event_btnLibraryManagement1ActionPerformed

    private void btnEmployeeManagement9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement9ActionPerformed
        dispose();
        try {
            new ADMIN_AdministrativePanel().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SIMS_DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SIMS_DashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmployeeManagement9ActionPerformed
    
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
            java.util.logging.Logger.getLogger(SIMS_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SIMS_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SIMS_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SIMS_DashBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SIMS_DashBoard().setVisible(true);
            }
        });
    }

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Topic;
    private javax.swing.JPanel adminPanel;
    private javax.swing.JButton btnCafeteriaManagement;
    private javax.swing.JButton btnEmployeeManagement;
    private javax.swing.JButton btnEmployeeManagement2;
    private javax.swing.JButton btnEmployeeManagement3;
    private javax.swing.JButton btnEmployeeManagement4;
    private javax.swing.JButton btnEmployeeManagement5;
    private javax.swing.JButton btnEmployeeManagement6;
    private javax.swing.JButton btnEmployeeManagement7;
    private javax.swing.JButton btnEmployeeManagement8;
    private javax.swing.JButton btnEmployeeManagement9;
    private javax.swing.JButton btnEventManagement;
    private javax.swing.JButton btnHostelManagement;
    private javax.swing.JButton btnLibraryManagement;
    private javax.swing.JButton btnLibraryManagement1;
    private javax.swing.JButton btnStudentInfoManagement;
    private javax.swing.JButton btnStudentProfileManagement;
    private javax.swing.JButton btnTimeTableManagement;
    private javax.swing.JPanel cafeteriaManagement;
    private javax.swing.JPanel employeeManagement;
    private javax.swing.JPanel eventManagement;
    private javax.swing.JButton home;
    private javax.swing.JPanel hostelManagement;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel libraryManagement;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JPanel studentInfoManagement;
    private javax.swing.JPanel studentProfileManagement;
    public javax.swing.JPanel subSystemHomePanel;
    private javax.swing.JPanel timeTableManaement;
    // End of variables declaration//GEN-END:variables
    
}
