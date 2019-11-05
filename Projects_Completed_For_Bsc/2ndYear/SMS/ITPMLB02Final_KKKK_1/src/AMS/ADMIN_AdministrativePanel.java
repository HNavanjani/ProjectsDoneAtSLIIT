
package AMS;

import EMS.EMS_EmployeeManagementSystem;
import SPMS.*;
import SPMS.StudentInformation;
import SPMS.dbConnection;
//import SchoolInformationManagementSystem.CMS_CafeteriaManagementSystem;
//import SchoolInformationManagementSystem.HMS_Home;
import SchoolInformationManagementSystem.SIMS_DashBoard;
import SchoolInformationManagementSystem.SIMS_HomeScreen;
import TMS.TMS_Timetablemangemnet;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;


public class ADMIN_AdministrativePanel extends javax.swing.JFrame {
    Connection conn =null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    String studentGender=null;
    String feedback=null;
    
    /*public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public String url="jdbc:sqlserver://localhost:24809;databaseName=itpoNew";
    public String user="adminK";
    public String pw="admink";*/
    
    
    
    public SPMS_DBAccess obj = new SPMS_DBAccess();
    
    /**
     * Creates new form ManageStudentDetails
     */
    public ADMIN_AdministrativePanel() throws ClassNotFoundException, SQLException {
        
        initComponents();
        /*Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pw);*/
        //conn = dbConnection.connectToDb();
        
        displayCount();
        
        lbl_aeid.setText(String.valueOf(UserClass.userID).toString());
        lbl_anic.setText(String.valueOf(UserClass.NIC).toString());
        lbl_aemail.setText(String.valueOf(UserClass.email).toString());
        lbl_auname.setText(String.valueOf(UserClass.userName).toString());
     
    }
    
    public void displayCount(){
        obj.countAllStu();
        jLabel2.setText(String.valueOf(obj.allStudentCount)+(" Students"));
        
        obj.countAllTeachers();
        jLabel3.setText(String.valueOf(obj.allTeachersCount)+(" Teachers"));
        
        obj.countAllStaff();
        jLabel7.setText(String.valueOf(obj.allStaffCount)+(" Staff Members"));
        
    }
    
    
    
    
    
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        forms = new javax.swing.JPanel();
        dashBoard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbl_aeid = new javax.swing.JLabel();
        lbl_anic = new javax.swing.JLabel();
        lbl_aemail = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_auname = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        btnLibraryManagement4 = new javax.swing.JButton();
        btnLibraryManagement5 = new javax.swing.JButton();
        btnStudentProfileManagement2 = new javax.swing.JButton();
        btnEmployeeManagement2 = new javax.swing.JButton();
        btnTimeTableManagement2 = new javax.swing.JButton();
        btnCafeteriaManagement2 = new javax.swing.JButton();
        btnHostelManagement2 = new javax.swing.JButton();
        btnEventManagement2 = new javax.swing.JButton();
        btnStudentInfoManagement2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Topic = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        sidemenu = new javax.swing.JPanel();
        sidemenu1 = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnHostelManagement1 = new javax.swing.JButton();
        btnTimeTableManagement1 = new javax.swing.JButton();
        btnStudentProfileManagement1 = new javax.swing.JButton();
        btnCafeteriaManagement1 = new javax.swing.JButton();
        btnEventManagement1 = new javax.swing.JButton();
        btnEmployeeManagement1 = new javax.swing.JButton();
        btnLibraryManagement2 = new javax.swing.JButton();
        btnStudentInfoManagement1 = new javax.swing.JButton();
        btnLibraryManagement3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(249, 249, 249));
        setMaximumSize(new java.awt.Dimension(1350, 720));
        setMinimumSize(new java.awt.Dimension(1350, 720));
        setPreferredSize(new java.awt.Dimension(1350, 720));
        setSize(new java.awt.Dimension(1350, 720));

        bg.setBackground(new java.awt.Color(255, 255, 255));
        bg.setMaximumSize(new java.awt.Dimension(1200, 600));
        bg.setMinimumSize(new java.awt.Dimension(1200, 600));
        bg.setPreferredSize(new java.awt.Dimension(1200, 600));

        forms.setBackground(new java.awt.Color(255, 255, 255));
        forms.setMaximumSize(new java.awt.Dimension(1200, 600));
        forms.setMinimumSize(new java.awt.Dimension(1200, 600));
        forms.setPreferredSize(new java.awt.Dimension(1200, 600));
        forms.setLayout(new java.awt.CardLayout());

        dashBoard.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(53, 120, 229));

        jPanel2.setBackground(new java.awt.Color(53, 120, 229));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrator Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 17))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("EmployeeID :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("NIC :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Email :");

        lbl_aeid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_anic.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_aemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Welcome Admin :");

        lbl_auname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_auname, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_anic, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_aeid, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_aemail, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_auname, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_aeid, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(lbl_anic, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lbl_aemail, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setBackground(new java.awt.Color(53, 120, 229));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Administrative Functions", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 17))); // NOI18N

        btnLibraryManagement4.setBackground(new java.awt.Color(41, 48, 66));
        btnLibraryManagement4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLibraryManagement4.setForeground(new java.awt.Color(255, 255, 255));
        btnLibraryManagement4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/adi.png"))); // NOI18N
        btnLibraryManagement4.setText("Administrative Tasks");
        btnLibraryManagement4.setBorderPainted(false);
        btnLibraryManagement4.setContentAreaFilled(false);
        btnLibraryManagement4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibraryManagement4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryManagement4ActionPerformed(evt);
            }
        });

        btnLibraryManagement5.setBackground(new java.awt.Color(41, 48, 66));
        btnLibraryManagement5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLibraryManagement5.setForeground(new java.awt.Color(255, 255, 255));
        btnLibraryManagement5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/lib48.png"))); // NOI18N
        btnLibraryManagement5.setText("Library Management ");
        btnLibraryManagement5.setBorderPainted(false);
        btnLibraryManagement5.setContentAreaFilled(false);
        btnLibraryManagement5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibraryManagement5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryManagement5ActionPerformed(evt);
            }
        });

        btnStudentProfileManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnStudentProfileManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStudentProfileManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentProfileManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/resultk.png"))); // NOI18N
        btnStudentProfileManagement2.setText("Student Profile Management ");
        btnStudentProfileManagement2.setBorderPainted(false);
        btnStudentProfileManagement2.setContentAreaFilled(false);
        btnStudentProfileManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudentProfileManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentProfileManagement2ActionPerformed(evt);
            }
        });

        btnEmployeeManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/empm.png"))); // NOI18N
        btnEmployeeManagement2.setText("Employee Management ");
        btnEmployeeManagement2.setBorderPainted(false);
        btnEmployeeManagement2.setContentAreaFilled(false);
        btnEmployeeManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEmployeeManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement2ActionPerformed(evt);
            }
        });

        btnTimeTableManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnTimeTableManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimeTableManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnTimeTableManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/timetbl.png"))); // NOI18N
        btnTimeTableManagement2.setText("Time Table Management ");
        btnTimeTableManagement2.setBorderPainted(false);
        btnTimeTableManagement2.setContentAreaFilled(false);
        btnTimeTableManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTimeTableManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeTableManagement2ActionPerformed(evt);
            }
        });

        btnCafeteriaManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnCafeteriaManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCafeteriaManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnCafeteriaManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/canteen.png"))); // NOI18N
        btnCafeteriaManagement2.setText("Cafeteria Management ");
        btnCafeteriaManagement2.setBorderPainted(false);
        btnCafeteriaManagement2.setContentAreaFilled(false);
        btnCafeteriaManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCafeteriaManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafeteriaManagement2ActionPerformed(evt);
            }
        });

        btnHostelManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnHostelManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHostelManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnHostelManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/hostell.png"))); // NOI18N
        btnHostelManagement2.setText("Hostel  Management ");
        btnHostelManagement2.setBorderPainted(false);
        btnHostelManagement2.setContentAreaFilled(false);
        btnHostelManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHostelManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHostelManagement2ActionPerformed(evt);
            }
        });

        btnEventManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnEventManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEventManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnEventManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/eventnew.png"))); // NOI18N
        btnEventManagement2.setText("Event Management ");
        btnEventManagement2.setContentAreaFilled(false);
        btnEventManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEventManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventManagement2ActionPerformed(evt);
            }
        });

        btnStudentInfoManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnStudentInfoManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStudentInfoManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentInfoManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/stuinfonew.png"))); // NOI18N
        btnStudentInfoManagement2.setText("Student Information Management ");
        btnStudentInfoManagement2.setContentAreaFilled(false);
        btnStudentInfoManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnStudentInfoManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentInfoManagement2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLibraryManagement4)
                            .addComponent(btnLibraryManagement5))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(btnStudentProfileManagement2, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(btnEmployeeManagement2))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnHostelManagement2)
                                .addGap(46, 46, 46)
                                .addComponent(btnEventManagement2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnStudentInfoManagement2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnTimeTableManagement2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCafeteriaManagement2)))))
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibraryManagement4)
                    .addComponent(btnStudentProfileManagement2))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibraryManagement5)
                    .addComponent(btnEmployeeManagement2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimeTableManagement2)
                    .addComponent(btnCafeteriaManagement2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnHostelManagement2)
                    .addComponent(btnEventManagement2)
                    .addComponent(btnStudentInfoManagement2))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/if_88_171447.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/if_13_2135790.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/if_group2_309041.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(142, 142, 142)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(79, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashBoardLayout = new javax.swing.GroupLayout(dashBoard);
        dashBoard.setLayout(dashBoardLayout);
        dashBoardLayout.setHorizontalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        dashBoardLayout.setVerticalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        forms.add(dashBoard, "dashBoard");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(forms, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(forms, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
        );

        Topic.setBackground(new java.awt.Color(26, 56, 103));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("School Information Management System ");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("Student Profile Management");

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/rsz_logop.png"))); // NOI18N

        javax.swing.GroupLayout TopicLayout = new javax.swing.GroupLayout(Topic);
        Topic.setLayout(TopicLayout);
        TopicLayout.setHorizontalGroup(
            TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopicLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(TopicLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel53)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        TopicLayout.setVerticalGroup(
            TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopicLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TopicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(TopicLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel53)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidemenu.setBackground(new java.awt.Color(41, 48, 66));
        sidemenu.setMaximumSize(new java.awt.Dimension(330, 755));
        sidemenu.setMinimumSize(new java.awt.Dimension(330, 755));

        sidemenu1.setBackground(new java.awt.Color(41, 48, 66));

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

        jPanel6.setBackground(new java.awt.Color(41, 48, 66));

        btnHostelManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnHostelManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnHostelManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnHostelManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/hostell.png"))); // NOI18N
        btnHostelManagement1.setText("Hostel  Management ");
        btnHostelManagement1.setBorderPainted(false);
        btnHostelManagement1.setContentAreaFilled(false);
        btnHostelManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnHostelManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHostelManagement1ActionPerformed(evt);
            }
        });

        btnTimeTableManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnTimeTableManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTimeTableManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnTimeTableManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/timetbl.png"))); // NOI18N
        btnTimeTableManagement1.setText("Time Table Management ");
        btnTimeTableManagement1.setBorderPainted(false);
        btnTimeTableManagement1.setContentAreaFilled(false);
        btnTimeTableManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnTimeTableManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimeTableManagement1ActionPerformed(evt);
            }
        });

        btnStudentProfileManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnStudentProfileManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStudentProfileManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentProfileManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/resultk.png"))); // NOI18N
        btnStudentProfileManagement1.setText("Student Profile Management ");
        btnStudentProfileManagement1.setBorderPainted(false);
        btnStudentProfileManagement1.setContentAreaFilled(false);
        btnStudentProfileManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnStudentProfileManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentProfileManagement1ActionPerformed(evt);
            }
        });

        btnCafeteriaManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnCafeteriaManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCafeteriaManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnCafeteriaManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/canteen.png"))); // NOI18N
        btnCafeteriaManagement1.setText("Cafeteria Management ");
        btnCafeteriaManagement1.setBorderPainted(false);
        btnCafeteriaManagement1.setContentAreaFilled(false);
        btnCafeteriaManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCafeteriaManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCafeteriaManagement1ActionPerformed(evt);
            }
        });

        btnEventManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnEventManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEventManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnEventManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/eventnew.png"))); // NOI18N
        btnEventManagement1.setText("Event Management ");
        btnEventManagement1.setContentAreaFilled(false);
        btnEventManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEventManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEventManagement1ActionPerformed(evt);
            }
        });

        btnEmployeeManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnEmployeeManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEmployeeManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnEmployeeManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/empm.png"))); // NOI18N
        btnEmployeeManagement1.setText("Employee Management ");
        btnEmployeeManagement1.setBorderPainted(false);
        btnEmployeeManagement1.setContentAreaFilled(false);
        btnEmployeeManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEmployeeManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmployeeManagement1ActionPerformed(evt);
            }
        });

        btnLibraryManagement2.setBackground(new java.awt.Color(41, 48, 66));
        btnLibraryManagement2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLibraryManagement2.setForeground(new java.awt.Color(255, 255, 255));
        btnLibraryManagement2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/lib48.png"))); // NOI18N
        btnLibraryManagement2.setText("Library Management ");
        btnLibraryManagement2.setBorderPainted(false);
        btnLibraryManagement2.setContentAreaFilled(false);
        btnLibraryManagement2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLibraryManagement2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryManagement2ActionPerformed(evt);
            }
        });

        btnStudentInfoManagement1.setBackground(new java.awt.Color(41, 48, 66));
        btnStudentInfoManagement1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStudentInfoManagement1.setForeground(new java.awt.Color(255, 255, 255));
        btnStudentInfoManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/stuinfonew.png"))); // NOI18N
        btnStudentInfoManagement1.setText("Student Information Management ");
        btnStudentInfoManagement1.setContentAreaFilled(false);
        btnStudentInfoManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnStudentInfoManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStudentInfoManagement1ActionPerformed(evt);
            }
        });

        btnLibraryManagement3.setBackground(new java.awt.Color(41, 48, 66));
        btnLibraryManagement3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnLibraryManagement3.setForeground(new java.awt.Color(255, 255, 255));
        btnLibraryManagement3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/adi.png"))); // NOI18N
        btnLibraryManagement3.setText("Administrative Panel");
        btnLibraryManagement3.setBorderPainted(false);
        btnLibraryManagement3.setContentAreaFilled(false);
        btnLibraryManagement3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLibraryManagement3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryManagement3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStudentInfoManagement1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnStudentProfileManagement1, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCafeteriaManagement1)
                            .addComponent(btnHostelManagement1)
                            .addComponent(btnEventManagement1)
                            .addComponent(btnLibraryManagement2)
                            .addComponent(btnEmployeeManagement1)
                            .addComponent(btnTimeTableManagement1)
                            .addComponent(btnLibraryManagement3))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLibraryManagement3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLibraryManagement2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudentProfileManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployeeManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimeTableManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCafeteriaManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHostelManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEventManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudentInfoManagement1))
        );

        javax.swing.GroupLayout sidemenu1Layout = new javax.swing.GroupLayout(sidemenu1);
        sidemenu1.setLayout(sidemenu1Layout);
        sidemenu1Layout.setHorizontalGroup(
            sidemenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenu1Layout.createSequentialGroup()
                .addGroup(sidemenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidemenu1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(sidemenu1Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(home)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton34)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidemenu1Layout.setVerticalGroup(
            sidemenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(sidemenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton34, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidemenuLayout = new javax.swing.GroupLayout(sidemenu);
        sidemenu.setLayout(sidemenuLayout);
        sidemenuLayout.setHorizontalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidemenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidemenuLayout.setVerticalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sidemenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Topic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Topic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 712, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sidemenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_homeActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void btnHostelManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHostelManagement1ActionPerformed
        
    }//GEN-LAST:event_btnHostelManagement1ActionPerformed

    private void btnTimeTableManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeTableManagement1ActionPerformed

    }//GEN-LAST:event_btnTimeTableManagement1ActionPerformed

    private void btnStudentProfileManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentProfileManagement1ActionPerformed
        
    }//GEN-LAST:event_btnStudentProfileManagement1ActionPerformed

    private void btnCafeteriaManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafeteriaManagement1ActionPerformed
       
    }//GEN-LAST:event_btnCafeteriaManagement1ActionPerformed

    private void btnEventManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventManagement1ActionPerformed
       
    }//GEN-LAST:event_btnEventManagement1ActionPerformed

    private void btnEmployeeManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement1ActionPerformed
      
    }//GEN-LAST:event_btnEmployeeManagement1ActionPerformed

    private void btnLibraryManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagement2ActionPerformed
       
    }//GEN-LAST:event_btnLibraryManagement2ActionPerformed

    private void btnStudentInfoManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentInfoManagement1ActionPerformed
        
    }//GEN-LAST:event_btnStudentInfoManagement1ActionPerformed

    private void btnLibraryManagement3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagement3ActionPerformed

    }//GEN-LAST:event_btnLibraryManagement3ActionPerformed

    private void btnLibraryManagement4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagement4ActionPerformed
        dispose();
        try {
            new ADMIN_AdministrativeTasks().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLibraryManagement4ActionPerformed

    private void btnLibraryManagement5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagement5ActionPerformed
        //dispose();
// new SIMS_Code.LMS_LibraryManagementSystem().setVisible(true);
    }//GEN-LAST:event_btnLibraryManagement5ActionPerformed

    private void btnStudentProfileManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentProfileManagement2ActionPerformed
       dispose();
        try {
            new SPMS_StudentProfileManageStudent().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnStudentProfileManagement2ActionPerformed

    private void btnEmployeeManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagement2ActionPerformed
        dispose();
        try {
            new EMS_EmployeeManagementSystem().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmployeeManagement2ActionPerformed

    private void btnTimeTableManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeTableManagement2ActionPerformed
       dispose();
        try {
            new TMS_Timetablemangemnet().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimeTableManagement2ActionPerformed

    private void btnCafeteriaManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCafeteriaManagement2ActionPerformed
//        dispose(); 
//        new CMS_CafeteriaManagementSystem().setVisible(true);
    }//GEN-LAST:event_btnCafeteriaManagement2ActionPerformed

    private void btnHostelManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHostelManagement2ActionPerformed
//        dispose(); 
//        new HMS_Home().setVisible(true);
    }//GEN-LAST:event_btnHostelManagement2ActionPerformed

    private void btnEventManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventManagement2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEventManagement2ActionPerformed

    private void btnStudentInfoManagement2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentInfoManagement2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnStudentInfoManagement2ActionPerformed
    private ImageIcon format = null;
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
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
                try {
                    new SPMS_StudentProfileManageStudent().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ADMIN_AdministrativePanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    private ImageIcon format2 = null;
    String filename =null;
    int s = 0;
    byte[] profile_pic=null;
    private String Sgender;
    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Topic;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnCafeteriaManagement1;
    private javax.swing.JButton btnCafeteriaManagement2;
    private javax.swing.JButton btnEmployeeManagement1;
    private javax.swing.JButton btnEmployeeManagement2;
    private javax.swing.JButton btnEventManagement1;
    private javax.swing.JButton btnEventManagement2;
    private javax.swing.JButton btnHostelManagement1;
    private javax.swing.JButton btnHostelManagement2;
    private javax.swing.JButton btnLibraryManagement2;
    private javax.swing.JButton btnLibraryManagement3;
    private javax.swing.JButton btnLibraryManagement4;
    private javax.swing.JButton btnLibraryManagement5;
    private javax.swing.JButton btnStudentInfoManagement1;
    private javax.swing.JButton btnStudentInfoManagement2;
    private javax.swing.JButton btnStudentProfileManagement1;
    private javax.swing.JButton btnStudentProfileManagement2;
    private javax.swing.JButton btnTimeTableManagement1;
    private javax.swing.JButton btnTimeTableManagement2;
    private javax.swing.JPanel dashBoard;
    private javax.swing.JPanel forms;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel lbl_aeid;
    private javax.swing.JLabel lbl_aemail;
    private javax.swing.JLabel lbl_anic;
    private javax.swing.JLabel lbl_auname;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JPanel sidemenu1;
    // End of variables declaration//GEN-END:variables
    
}
