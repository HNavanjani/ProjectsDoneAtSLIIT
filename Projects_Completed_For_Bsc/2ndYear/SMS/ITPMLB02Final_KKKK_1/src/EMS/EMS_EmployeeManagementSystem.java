
package EMS;
import DBConnection.DBConnect;
import SPMS.dbConnection;

import SPMS.dbConnection;
import SPMS_IREPORTS.IREPORT_PARAMETERIZED;
import SchoolInformationManagementSystem.SIMS_DashBoard;
import SchoolInformationManagementSystem.SIMS_HomeScreen;
import SchoolInformationManagementSystem.SPMS_StudentProfileManageTeacher;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;


public class EMS_EmployeeManagementSystem extends javax.swing.JFrame {
    
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
//    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    public String url="jdbc:sqlserver://localhost:24809;databaseName=sms_";
//    public String user="adminK";
//    public String pw="admink";
//    
    
    public EMS_EmployeeManagementSystem() throws ClassNotFoundException, SQLException{
        initComponents();
        
        //con = dbConnection.connectToDb();
        
         con = DBConnect.connect();
//         Class.forName(driver);
//         con=DriverManager.getConnection(url, user, pw);
        
        tableload();
        tableload1();
        tableload3();
        
        CurrentDate();
        
        
        }
    
    public boolean validemai(){
        String emailPattern = "^[A-Z0-9]+@[A-Z0-9]+\\.[A-Z]{2,3}$";
        
        Pattern patternemail = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
        
        Matcher regeMatcheremail = patternemail.matcher(txt_email.getText());
        if(!regeMatcheremail.matches()){
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid email address!");
            return false;
        }
        else
            return true;
        }
        
        public boolean validphone(){
        String phonecount = "^[0-9]{10}$";
        
        Pattern patternphone = Pattern.compile(phonecount, Pattern.CASE_INSENSITIVE);
        
        Matcher regeMatcherphone = patternphone.matcher(txt_contact.getText());
        if(!regeMatcherphone.matches()){
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid phone number for Student!");
            return false;
        }
        else
            return true;
        }
    
    
    public void CurrentDate(){
        
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        date_txt1.setText(year+"/"+(month+1)+"/"+day);
        
        
        int second = cal.get(Calendar.SECOND);
        int minute = cal.get(Calendar.MINUTE);
        int hour = cal.get(Calendar.HOUR);
        time_txt.setText(hour+":"+(minute+1)+":"+second);
        
         
    }
   
    public void tableload() 
    {
        try {
//            Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
           
        String sql = "SELECT EmployeeID,firstName,lastName,gender,email,contact,position FROM ems_employeedetails";
        
        pst = con.prepareStatement(sql);
        rs =  pst.executeQuery();
        
        jTable_add.setModel(DbUtils.resultSetToTableModel(rs));
        
        
        }
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
     public void tableload1() 
    {
        try {
//           Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
        String sq = "SELECT firstName,leavestartdate,leaveenddate,leavenoofdays FROM ems_employeeleave";
        
        pst = con.prepareStatement(sq);
        rs =  pst.executeQuery();
        
        jTable_leave.setModel(DbUtils.resultSetToTableModel(rs));
        
        
        }
        catch (SQLException e) {
        }
    }
     public void tableload3() 
    {
        try {
//            Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
           
        String sq = "SELECT EmployeeID,firstName,position,salary FROM ems_employeesalary";
        
        pst = con.prepareStatement(sq);
        rs =  pst.executeQuery();
        
        tbl_slry.setModel(DbUtils.resultSetToTableModel(rs));
        
        
        }
        catch (SQLException e) {
        }
    }
     
     public double calcsalary(String post)
     {
         
         int basic = 0;
         double bonus = 0 ;
         double salary;
         
         
         
         if(post.equals("Principle"))
         {
             basic = 30000;
             bonus=0.45;
          }
         else if(post.equals("Teacher"))
         {
             basic = 25000;
             bonus=0.25;
         }
         else if(post.equals("Clerk"))
         {
             basic = 15000;
             bonus=0.15;
         }
         else if(post.equals("Cleaner"))
         {
             basic = 8000;
             bonus=0.1;
         }
         
         
        
         else 
              
       JOptionPane.showMessageDialog(null, "'Error");
         
         salary=basic+(basic*bonus);
                 
         return salary;  
         }
     
     
     
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        topBar = new javax.swing.JPanel();
        System = new javax.swing.JLabel();
        Client = new javax.swing.JLabel();
        ClientLogo = new javax.swing.JButton();
        sidemenu = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnemployeeprofile = new javax.swing.JButton();
        btnsalary = new javax.swing.JButton();
        btnregistration = new javax.swing.JButton();
        btnattendence = new javax.swing.JButton();
        btnattendence1 = new javax.swing.JButton();
        btnsalary1 = new javax.swing.JButton();
        btnattendence2 = new javax.swing.JButton();
        mngprofile1 = new javax.swing.JButton();
        mngprofile3 = new javax.swing.JButton();
        subSystemHomePanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        attendence = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btn_atten_in = new javax.swing.JButton();
        time_txt = new javax.swing.JLabel();
        txt_atten_id1 = new javax.swing.JTextField();
        lbl_atten_id2 = new javax.swing.JLabel();
        date_txt1 = new javax.swing.JLabel();
        lbl_atten_id1 = new javax.swing.JLabel();
        lbl_atten_id3 = new javax.swing.JLabel();
        txt_atten_id2 = new javax.swing.JTextField();
        btn_atten_in1 = new javax.swing.JButton();
        lbl_atten_id4 = new javax.swing.JLabel();
        btn_atten_out1 = new javax.swing.JButton();
        registration = new javax.swing.JPanel();
        lbl_reg = new javax.swing.JLabel();
        btn_reg_m = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txt_contact = new javax.swing.JTextField();
        lbl_reg_position = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        txt_ln = new javax.swing.JTextField();
        lbl_reg_email = new javax.swing.JLabel();
        lbl_reg_fn = new javax.swing.JLabel();
        lbl_reg_id = new javax.swing.JLabel();
        txt_fn = new javax.swing.JTextField();
        lbl_reg_ln = new javax.swing.JLabel();
        lbl_reg_gender = new javax.swing.JLabel();
        lbl_reg_contact = new javax.swing.JLabel();
        combox_posi = new javax.swing.JComboBox<>();
        combox_gender = new javax.swing.JComboBox<>();
        lbl_reg_dob = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_add = new javax.swing.JTable();
        txt_fn1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        Txt1_srch1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        btn_reg_m1 = new javax.swing.JButton();
        Salary = new javax.swing.JPanel();
        lbl_slry_m = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btn_slry_cal = new javax.swing.JButton();
        lbl_slry_ts = new javax.swing.JLabel();
        lbl_slry_eid = new javax.swing.JLabel();
        lbl_slry_possition = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_slry = new javax.swing.JTable();
        txt_slry_ts = new javax.swing.JTextField();
        txt_slry_eid = new javax.swing.JTextField();
        lbl_slry_fn = new javax.swing.JLabel();
        txt_slry_fn = new javax.swing.JTextField();
        lbl_slry_eid1 = new javax.swing.JLabel();
        lbl_slry_eid2 = new javax.swing.JLabel();
        txt_slry_ts1 = new javax.swing.JTextField();
        btn_slry_cal1 = new javax.swing.JButton();
        leave = new javax.swing.JPanel();
        lbl_leave_sd = new javax.swing.JLabel();
        lbl_leave_nod = new javax.swing.JLabel();
        txt_leave_nod = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_leave = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btn_leave_add = new javax.swing.JButton();
        lbl_leave_ed = new javax.swing.JLabel();
        lbl_leave_fn = new javax.swing.JLabel();
        txt_leave_fn = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(249, 249, 249));
        setMaximumSize(new java.awt.Dimension(1350, 720));
        setMinimumSize(new java.awt.Dimension(1350, 720));
        setPreferredSize(new java.awt.Dimension(1350, 720));
        setSize(new java.awt.Dimension(1350, 720));

        topBar.setBackground(new java.awt.Color(26, 56, 103));
        topBar.setMaximumSize(new java.awt.Dimension(944, 119));
        topBar.setMinimumSize(new java.awt.Dimension(944, 119));

        System.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        System.setForeground(new java.awt.Color(255, 255, 255));
        System.setText("School Information Management System ");

        Client.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Client.setForeground(new java.awt.Color(255, 255, 255));
        Client.setText("Employee Management System");

        ClientLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/rsz_logop.png"))); // NOI18N
        ClientLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClientLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout topBarLayout = new javax.swing.GroupLayout(topBar);
        topBar.setLayout(topBarLayout);
        topBarLayout.setHorizontalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(ClientLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(System))
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(Client)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        topBarLayout.setVerticalGroup(
            topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClientLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(topBarLayout.createSequentialGroup()
                        .addComponent(System, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Client)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        sidemenu.setBackground(new java.awt.Color(41, 48, 66));
        sidemenu.setMaximumSize(new java.awt.Dimension(375, 777));
        sidemenu.setMinimumSize(new java.awt.Dimension(375, 777));

        menuPanel.setBackground(new java.awt.Color(41, 48, 66));
        menuPanel.setMaximumSize(new java.awt.Dimension(355, 755));
        menuPanel.setMinimumSize(new java.awt.Dimension(355, 755));

        jPanel3.setBackground(new java.awt.Color(41, 48, 66));
        jPanel3.setMaximumSize(new java.awt.Dimension(347, 577));
        jPanel3.setMinimumSize(new java.awt.Dimension(347, 577));

        btnemployeeprofile.setBackground(new java.awt.Color(41, 48, 66));
        btnemployeeprofile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnemployeeprofile.setForeground(new java.awt.Color(255, 255, 255));
        btnemployeeprofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/profile.png"))); // NOI18N
        btnemployeeprofile.setText("Employee Profile");
        btnemployeeprofile.setBorderPainted(false);
        btnemployeeprofile.setContentAreaFilled(false);
        btnemployeeprofile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnemployeeprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnemployeeprofileActionPerformed(evt);
            }
        });

        btnsalary.setBackground(new java.awt.Color(41, 48, 66));
        btnsalary.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalary.setForeground(new java.awt.Color(255, 255, 255));
        btnsalary.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/sal2.png"))); // NOI18N
        btnsalary.setText("Salary Management");
        btnsalary.setBorderPainted(false);
        btnsalary.setContentAreaFilled(false);
        btnsalary.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalaryActionPerformed(evt);
            }
        });

        btnregistration.setBackground(new java.awt.Color(41, 48, 66));
        btnregistration.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnregistration.setForeground(new java.awt.Color(255, 255, 255));
        btnregistration.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/register.png"))); // NOI18N
        btnregistration.setText("Employee Registration");
        btnregistration.setBorderPainted(false);
        btnregistration.setContentAreaFilled(false);
        btnregistration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnregistration.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregistrationActionPerformed(evt);
            }
        });

        btnattendence.setBackground(new java.awt.Color(41, 48, 66));
        btnattendence.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnattendence.setForeground(new java.awt.Color(255, 255, 255));
        btnattendence.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/callender.png"))); // NOI18N
        btnattendence.setText("Attendence Tracking");
        btnattendence.setBorderPainted(false);
        btnattendence.setContentAreaFilled(false);
        btnattendence.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnattendence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnattendenceActionPerformed(evt);
            }
        });

        btnattendence1.setBackground(new java.awt.Color(41, 48, 66));
        btnattendence1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnattendence1.setForeground(new java.awt.Color(255, 255, 255));
        btnattendence1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/dashboard.png"))); // NOI18N
        btnattendence1.setText("Dashboard");
        btnattendence1.setBorderPainted(false);
        btnattendence1.setContentAreaFilled(false);
        btnattendence1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnattendence1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnattendence1ActionPerformed(evt);
            }
        });

        btnsalary1.setBackground(new java.awt.Color(41, 48, 66));
        btnsalary1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalary1.setForeground(new java.awt.Color(255, 255, 255));
        btnsalary1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/teachermng.png"))); // NOI18N
        btnsalary1.setText("Student Profile Management");
        btnsalary1.setBorderPainted(false);
        btnsalary1.setContentAreaFilled(false);
        btnsalary1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnsalary1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalary1ActionPerformed(evt);
            }
        });

        btnattendence2.setBackground(new java.awt.Color(41, 48, 66));
        btnattendence2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnattendence2.setForeground(new java.awt.Color(255, 255, 255));
        btnattendence2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/callender.png"))); // NOI18N
        btnattendence2.setText("Leave Management");
        btnattendence2.setBorderPainted(false);
        btnattendence2.setContentAreaFilled(false);
        btnattendence2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnattendence2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnattendence2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnattendence)
                    .addComponent(btnregistration)
                    .addComponent(btnemployeeprofile)
                    .addComponent(btnsalary)
                    .addComponent(btnattendence1)
                    .addComponent(btnsalary1)
                    .addComponent(btnattendence2))
                .addGap(56, 56, 56))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnattendence1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnattendence)
                .addGap(7, 7, 7)
                .addComponent(btnattendence2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnregistration)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnemployeeprofile)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsalary1)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        mngprofile1.setBackground(new java.awt.Color(41, 48, 66));
        mngprofile1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mngprofile1.setForeground(new java.awt.Color(255, 255, 255));
        mngprofile1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/home.png"))); // NOI18N
        mngprofile1.setToolTipText("HOME");
        mngprofile1.setBorderPainted(false);
        mngprofile1.setContentAreaFilled(false);
        mngprofile1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mngprofile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngprofile1ActionPerformed(evt);
            }
        });

        mngprofile3.setBackground(new java.awt.Color(41, 48, 66));
        mngprofile3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mngprofile3.setForeground(new java.awt.Color(255, 255, 255));
        mngprofile3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/lock.png"))); // NOI18N
        mngprofile3.setToolTipText("LOG OUT");
        mngprofile3.setBorderPainted(false);
        mngprofile3.setContentAreaFilled(false);
        mngprofile3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mngprofile3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngprofile3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(mngprofile1)
                        .addGap(93, 93, 93)
                        .addComponent(mngprofile3)))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(mngprofile1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mngprofile3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout sidemenuLayout = new javax.swing.GroupLayout(sidemenu);
        sidemenu.setLayout(sidemenuLayout);
        sidemenuLayout.setHorizontalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sidemenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        sidemenuLayout.setVerticalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        subSystemHomePanel.setBackground(new java.awt.Color(255, 255, 204));
        subSystemHomePanel.setMaximumSize(new java.awt.Dimension(1048, 993));
        subSystemHomePanel.setLayout(new java.awt.CardLayout());

        dashboard.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setBackground(new java.awt.Color(102, 102, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_EMS/imageemploeemanage.png"))); // NOI18N

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(287, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(563, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(dashboard, "dashboard");

        attendence.setBackground(new java.awt.Color(102, 102, 255));
        attendence.setMaximumSize(new java.awt.Dimension(1048, 993));
        attendence.setMinimumSize(new java.awt.Dimension(1048, 993));

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn_atten_in.setBackground(new java.awt.Color(34, 139, 34));
        btn_atten_in.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_atten_in.setText("Time  OUT");
        btn_atten_in.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_atten_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atten_inActionPerformed(evt);
            }
        });

        time_txt.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        time_txt.setText("TIME");

        lbl_atten_id2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_atten_id2.setText("ID");

        date_txt1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date_txt1.setText("DATE");

        lbl_atten_id1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_atten_id1.setText("Password");

        lbl_atten_id3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_atten_id3.setText("Employee ID");

        btn_atten_in1.setBackground(new java.awt.Color(34, 139, 34));
        btn_atten_in1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_atten_in1.setText("Time IN ");
        btn_atten_in1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_atten_in1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atten_in1ActionPerformed(evt);
            }
        });

        lbl_atten_id4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_atten_id4.setText("ID");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_atten_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lbl_atten_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_atten_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_atten_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_atten_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_atten_in1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(time_txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_atten_in, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(264, Short.MAX_VALUE)
                    .addComponent(txt_atten_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(131, 131, 131)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(time_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(date_txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_atten_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_atten_id4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(lbl_atten_id3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_atten_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_atten_id1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_atten_in, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_atten_in1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(114, 114, 114)
                    .addComponent(txt_atten_id2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(190, Short.MAX_VALUE)))
        );

        btn_atten_out1.setBackground(new java.awt.Color(220, 19, 60));
        btn_atten_out1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_atten_out1.setText("View Profile");
        btn_atten_out1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_atten_out1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_atten_out1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout attendenceLayout = new javax.swing.GroupLayout(attendence);
        attendence.setLayout(attendenceLayout);
        attendenceLayout.setHorizontalGroup(
            attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, attendenceLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                .addComponent(btn_atten_out1)
                .addGap(195, 195, 195))
        );
        attendenceLayout.setVerticalGroup(
            attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(attendenceLayout.createSequentialGroup()
                .addGroup(attendenceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addGap(394, 394, 394)
                        .addComponent(btn_atten_out1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(attendenceLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(652, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(attendence, "attendence");

        registration.setBackground(new java.awt.Color(102, 102, 255));
        registration.setMaximumSize(new java.awt.Dimension(1048, 993));
        registration.setMinimumSize(new java.awt.Dimension(1048, 993));

        lbl_reg.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_reg.setText("Registration");

        btn_reg_m.setBackground(new java.awt.Color(34, 139, 34));
        btn_reg_m.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_reg_m.setText("Add");
        btn_reg_m.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reg_mActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        txt_contact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_reg_position.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_position.setText("Position");

        txt_email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_ln.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_reg_email.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_email.setText("Email ");

        lbl_reg_fn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_fn.setText("First Name ");

        lbl_reg_id.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_id.setText("EID");

        txt_fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_reg_ln.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_ln.setText("Last Name");

        lbl_reg_gender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_gender.setText("Gender");

        lbl_reg_contact.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_contact.setText("Contact ");

        combox_posi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select position", "Principle", "Teacher", "Clerk", "Cleaner" }));
        combox_posi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combox_posiActionPerformed(evt);
            }
        });

        combox_gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Gender", "Male", "Female" }));

        lbl_reg_dob.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_reg_dob.setText("Date of Birth");

        jTable_add.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "EID", "First Name", "Last Name", "Gender", "Email", "Contact", "Position"
            }
        ));
        jTable_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_addMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_add);

        txt_fn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_reg_fn)
                    .addComponent(lbl_reg_id, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_reg_ln)
                    .addComponent(lbl_reg_position)
                    .addComponent(lbl_reg_contact)
                    .addComponent(lbl_reg_email)
                    .addComponent(lbl_reg_gender)
                    .addComponent(lbl_reg_dob))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txt_contact, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_email, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combox_gender, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_ln, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_fn, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combox_posi, 0, 136, Short.MAX_VALUE)
                    .addComponent(txt_fn1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_reg_id, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fn1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txt_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbl_reg_fn)))
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_ln, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_reg_ln))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_reg_gender)
                            .addComponent(combox_gender, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lbl_reg_dob)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_reg_email)
                            .addComponent(txt_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_reg_contact, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_contact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_reg_position, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combox_posi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Name");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Search");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        btn_reg_m1.setBackground(new java.awt.Color(34, 139, 34));
        btn_reg_m1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_reg_m1.setText("View Employee List");
        btn_reg_m1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reg_m1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout registrationLayout = new javax.swing.GroupLayout(registration);
        registration.setLayout(registrationLayout);
        registrationLayout.setHorizontalGroup(
            registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrationLayout.createSequentialGroup()
                .addGroup(registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrationLayout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(btn_reg_m1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btn_reg_m, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(jButton1)
                        .addGap(171, 171, 171)
                        .addComponent(jButton2))
                    .addGroup(registrationLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(lbl_reg)
                        .addGap(230, 230, 230)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Txt1_srch1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        registrationLayout.setVerticalGroup(
            registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(registrationLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(lbl_reg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Txt1_srch1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(registrationLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_reg_m, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_reg_m1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(registrationLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(registrationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2))))
                .addContainerGap(638, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(registration, "registration");

        Salary.setBackground(new java.awt.Color(102, 102, 255));
        Salary.setMaximumSize(new java.awt.Dimension(1048, 993));
        Salary.setMinimumSize(new java.awt.Dimension(1048, 993));

        lbl_slry_m.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbl_slry_m.setText("Salary Information");

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Principle", "Teacher", "Clerk", "Cleaner" }));

        btn_slry_cal.setBackground(new java.awt.Color(220, 19, 60));
        btn_slry_cal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_slry_cal.setForeground(new java.awt.Color(255, 255, 255));
        btn_slry_cal.setText("Calculate");
        btn_slry_cal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_slry_calActionPerformed(evt);
            }
        });

        lbl_slry_ts.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_slry_ts.setText("Monthly Salary");

        lbl_slry_eid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_slry_eid.setText("ID");

        lbl_slry_possition.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_slry_possition.setText("Position");

        jScrollPane2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbl_slry.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tbl_slry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Emloyee ID", "First Name", "Position", "Monthly Salary"
            }
        ));
        jScrollPane2.setViewportView(tbl_slry);

        txt_slry_ts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_slry_ts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_slry_tsActionPerformed(evt);
            }
        });

        txt_slry_eid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_slry_fn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_slry_fn.setText("First Name");

        txt_slry_fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbl_slry_eid1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_slry_eid1.setText("Employee ID");

        lbl_slry_eid2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_slry_eid2.setText("ID");

        txt_slry_ts1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_slry_ts1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_slry_ts1ActionPerformed(evt);
            }
        });

        btn_slry_cal1.setBackground(new java.awt.Color(220, 19, 60));
        btn_slry_cal1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_slry_cal1.setForeground(new java.awt.Color(255, 255, 255));
        btn_slry_cal1.setText("Generate Report");
        btn_slry_cal1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_slry_cal1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_slry_ts, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(txt_slry_ts, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbl_slry_possition, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_slry_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbl_slry_eid1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(72, 72, 72)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txt_slry_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_slry_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(lbl_slry_eid2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_slry_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(93, 93, 93)
                        .addComponent(btn_slry_cal, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addComponent(txt_slry_ts1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(btn_slry_cal1, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addComponent(lbl_slry_eid, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_slry_eid2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)))
                        .addComponent(txt_slry_eid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(75, 75, 75)
                                .addComponent(lbl_slry_eid1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbl_slry_fn)
                                    .addComponent(txt_slry_fn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(lbl_slry_possition)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)))
                                .addComponent(btn_slry_cal)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_slry_ts, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_slry_ts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_slry_ts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_slry_cal1))))
                .addContainerGap())
        );

        javax.swing.GroupLayout SalaryLayout = new javax.swing.GroupLayout(Salary);
        Salary.setLayout(SalaryLayout);
        SalaryLayout.setHorizontalGroup(
            SalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaryLayout.createSequentialGroup()
                .addGroup(SalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SalaryLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SalaryLayout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(lbl_slry_m, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        SalaryLayout.setVerticalGroup(
            SalaryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SalaryLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_slry_m, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(616, Short.MAX_VALUE))
        );

        subSystemHomePanel.add(Salary, "Salary");

        leave.setBackground(new java.awt.Color(102, 102, 255));

        lbl_leave_sd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_leave_sd.setText("Leave Start Date");

        lbl_leave_nod.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_leave_nod.setText("Leave NO of Days");

        txt_leave_nod.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jTable_leave.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "First Name", "Start Date", "End Date", "No of Days"
            }
        ));
        jScrollPane3.setViewportView(jTable_leave);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Leave");

        btn_leave_add.setBackground(new java.awt.Color(34, 139, 34));
        btn_leave_add.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_leave_add.setText("ADD");
        btn_leave_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_leave_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_leave_addActionPerformed(evt);
            }
        });

        lbl_leave_ed.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_leave_ed.setText("Leave End Date");

        lbl_leave_fn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_leave_fn.setText("First Name");

        txt_leave_fn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("ID");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("ID");

        javax.swing.GroupLayout leaveLayout = new javax.swing.GroupLayout(leave);
        leave.setLayout(leaveLayout);
        leaveLayout.setHorizontalGroup(
            leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leaveLayout.createSequentialGroup()
                        .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(leaveLayout.createSequentialGroup()
                                .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_leave_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_leave_sd, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_leave_fn, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
                                    .addComponent(jTextField2)))
                            .addGroup(leaveLayout.createSequentialGroup()
                                .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_leave_ed, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbl_leave_nod, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(33, 33, 33)
                                .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jTextField1)
                                    .addComponent(txt_leave_nod, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))))
                        .addGap(30, 30, 30))
                    .addGroup(leaveLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(142, 142, 142)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(217, 217, 217))
            .addGroup(leaveLayout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
            .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(leaveLayout.createSequentialGroup()
                    .addGap(244, 244, 244)
                    .addComponent(btn_leave_add, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(733, Short.MAX_VALUE)))
        );
        leaveLayout.setVerticalGroup(
            leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leaveLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel2)
                .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leaveLayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(lbl_leave_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_leave_sd, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(leaveLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leaveLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txt_leave_fn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))
                            .addGroup(leaveLayout.createSequentialGroup()
                                .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(leaveLayout.createSequentialGroup()
                                        .addGap(154, 154, 154)
                                        .addComponent(lbl_leave_ed, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(leaveLayout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)))
                        .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_leave_nod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_leave_nod, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(723, Short.MAX_VALUE))
            .addGroup(leaveLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(leaveLayout.createSequentialGroup()
                    .addGap(414, 414, 414)
                    .addComponent(btn_leave_add, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(632, Short.MAX_VALUE)))
        );

        subSystemHomePanel.add(leave, "leave");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        subSystemHomePanel.add(jPanel6, "card8");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(topBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(subSystemHomePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sidemenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(topBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(subSystemHomePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnattendenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnattendenceActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "attendence");
    }//GEN-LAST:event_btnattendenceActionPerformed

    private void btnemployeeprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnemployeeprofileActionPerformed
        
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "employeeprofile");
    }//GEN-LAST:event_btnemployeeprofileActionPerformed

    private void btnregistrationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregistrationActionPerformed
       CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "registration");
    }//GEN-LAST:event_btnregistrationActionPerformed

    private void btnsalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalaryActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "Salary");
    }//GEN-LAST:event_btnsalaryActionPerformed

    private void ClientLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientLogoActionPerformed
        dispose();
        try {
            new EMS_EmployeeManagementSystem().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EMS_EmployeeManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EMS_EmployeeManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClientLogoActionPerformed

    private void mngprofile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofile1ActionPerformed

        dispose();
        new SIMS_DashBoard().setVisible(true);
    }//GEN-LAST:event_mngprofile1ActionPerformed

    private void mngprofile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofile3ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_mngprofile3ActionPerformed

    private void btnattendence1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnattendence1ActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "dashboard");
    }//GEN-LAST:event_btnattendence1ActionPerformed

    private void btnsalary1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalary1ActionPerformed
        dispose();
        try {
            new SPMS_StudentProfileManageTeacher().setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(EMS_EmployeeManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EMS_EmployeeManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnsalary1ActionPerformed

    private void btn_atten_out1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atten_out1ActionPerformed
        
    }//GEN-LAST:event_btn_atten_out1ActionPerformed

    private void btnattendence2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnattendence2ActionPerformed
        CardLayout card = (CardLayout)subSystemHomePanel.getLayout();
        card.show(subSystemHomePanel, "leave");
    }//GEN-LAST:event_btnattendence2ActionPerformed

    private void txt_slry_tsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_slry_tsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_slry_tsActionPerformed

    private void combox_posiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combox_posiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combox_posiActionPerformed

    private void btn_reg_mActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reg_mActionPerformed

        tableload();
        try{       
        if(validemai()&&validphone()){
       
        String fname = txt_fn.getText();
        String eid = txt_fn1.getText();
        String lname = txt_ln.getText();
        String gender = combox_gender.getSelectedItem().toString();
        //String dob;
       // dob = txt_dob.getDateFormatString();
        
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        String position = combox_posi.getSelectedItem().toString();
        
        //try{
//            Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
        String q = "INSERT INTO ems_employeedetails(EmployeeID,firstName,lastName,gender,email,contact,position)values('"+ eid+"','"+ fname+"','"+ lname+"','"+ gender+"','"+ email+"','"+ contact+"','"+position+"')";
        pst = con.prepareStatement(q);
        pst.executeUpdate();
        
        
        tableload();
       
        }
         
}
      catch(SQLException e){
          
         JOptionPane.showMessageDialog(null,e);
     
       }
        
        
    }//GEN-LAST:event_btn_reg_mActionPerformed

    private void jTable_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_addMouseClicked
     
       int r = jTable_add.getSelectedRow();
       String id = jTable_add.getValueAt(r,0).toString();
       String fname = jTable_add.getValueAt(r,1).toString();
       String lname = jTable_add.getValueAt(r,2).toString();
       String gender = jTable_add.getValueAt(r,3).toString();
       //String dob = jTable_add.getValueAt(r,4).toString();
       String email = jTable_add.getValueAt(r,4).toString();
       String contact = jTable_add.getValueAt(r,5).toString();
       String position = jTable_add.getValueAt(r,6).toString();  
        
        txt_fn.setText(fname);
        txt_ln.setText(lname);
        combox_gender.setSelectedItem(gender);
        //txt_dob.setDateFormatString(dob); 
        txt_email.setText(email);
        txt_contact.setText(contact);
        combox_posi.setSelectedItem(position);
        
        txt_fn1.setText(id);
       
       
       
    }//GEN-LAST:event_jTable_addMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        
        
        if(validemai()&&validphone()){
    int x = JOptionPane.showConfirmDialog(null,"Do you really want to update");
    
    if(x==0)
    {
        String id = txt_fn1.getText();
        String fname = txt_fn.getText();
        String lname = txt_ln.getText();
        String gender = combox_gender.getSelectedItem().toString();
       // String dob = txt_dob.getDateFormatString();
        String email = txt_email.getText();
        String contact = txt_contact.getText();
        String position = combox_posi.getSelectedItem().toString();
        
        
         
        try{
//            Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
        String sql = "UPDATE ems_employeedetails SET firstName='"+ fname+"',lastName='"+ lname+"',gender='"+ gender+"',email='"+ email+"',contact='"+ contact+"',position='"+position+"' where EmployeeID ='"+id+"' ";
        
        pst = con.prepareStatement(sql);
       pst.executeUpdate();
         tableload();
    }
        
     catch (SQLException e){   
         JOptionPane.showMessageDialog(null, e);
     }
    }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
      
      int x = JOptionPane.showConfirmDialog(null,"Do you really want to Delete"); 
      
      if(x==0)
      {
         String id = txt_fn1.getText(); 
           
      
    
        try{
//             Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
        String sql = "DELETE from ems_employeedetails where EmployeeID ='"+id+"' ";
        pst = con.prepareCall(sql);
        pst.executeUpdate();
        
         tableload();
        }
        catch (SQLException e){   
         JOptionPane.showMessageDialog(null, e);
     }
      }
        
        
    }//GEN-LAST:event_jButton2ActionPerformed
  
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
      
      String fname = Txt1_srch1.getText();
     
      try{
//           Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
      String sql = "Select EmployeeID,firstName,lastName,gender,email,contact,position  from ems_employeedetails where firstName LIKE '%"+fname+"%' ";
       
       pst = con.prepareStatement(sql);
       rs = pst.executeQuery();
       
       jTable_add.setModel(DbUtils.resultSetToTableModel(rs));
      }
      catch(SQLException e){
        
      } 
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_leave_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_leave_addActionPerformed
      tableload1();
        
        String fname = txt_leave_fn.getText();
     String sdate = jTextField2.getText();
     String edate = jTextField1.getText();
    String num = txt_leave_nod.getText();

 try{
//          Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
        String q = "INSERT INTO ems_employeeleave (firstName,leavestartdate,leaveenddate,leavenoofdays) values('"+ fname+"','"+ sdate+"','"+ edate+"','"+ num+"')";
        pst = con.prepareStatement(q);
        pst.executeUpdate();
        tableload1();
        
       
           
           
       }
      catch(SQLException e){
      }          
       
    }//GEN-LAST:event_btn_leave_addActionPerformed

    private void btn_slry_calActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_slry_calActionPerformed
     
        
     String id = txt_slry_eid.getText();
     String fname = txt_slry_fn.getText();
     String position = jComboBox1.getSelectedItem().toString();
     
    // double sal = calcsalary(txt_slry_ts.getText());
     double sal = calcsalary(jComboBox1.getSelectedItem().toString());
        int salary;
        salary = (int) sal;
        txt_slry_ts.setText(Integer.toString(salary));


 try{
//          Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
        String p = "INSERT INTO ems_employeesalary (EmployeeID,firstName,position,salary) values('"+ id+"','"+ fname+"','"+ position+"','"+sal+"')";
        pst = con.prepareStatement(p);
pst.executeUpdate();        
        tableload3();
       
           
           
       }
      catch(SQLException e){
      }        
      
        
    }//GEN-LAST:event_btn_slry_calActionPerformed

    private void btn_atten_in1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atten_in1ActionPerformed
        
       
             
 String eid = txt_atten_id2.getText();

    String pwd = txt_atten_id1.getText();

 try{
//      Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
       
          
        String qt = "INSERT INTO ems_att (employeeID,password ) values( '"+eid+"','"+ pwd+"')";
       
        pst = con.prepareStatement(qt);
       pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Successfully Marked attendance...");
              
 }
       catch(SQLException e){
      }      
                JOptionPane.showMessageDialog(null, "Successfully Marked attendance...");

    }//GEN-LAST:event_btn_atten_in1ActionPerformed

    private void btn_atten_inActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_atten_inActionPerformed
       
String eid = txt_atten_id2.getText();

String pwd = txt_atten_id1.getText();

 try{
//      Class.forName(driver);
//            con=DriverManager.getConnection(url, user, pw);
          
        String q = "INSERT INTO ems_att (employeeID ,password ) values('"+ eid+"','"+ pwd+"')";
        pst = con.prepareStatement(q);
        pst.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Successfully Marked departure...");
 }
      
      
      catch(SQLException e){
      }   
        JOptionPane.showMessageDialog(null, "Successfully Marked departure...");
    }//GEN-LAST:event_btn_atten_inActionPerformed

    private void btn_reg_m1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reg_m1ActionPerformed
        try {
            String studentList = "C:\\xampp\\htdocs\\ITP\\Project\\VIVA\\IREPORTS\\EMS_EmployeeN.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(studentList);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_reg_m1ActionPerformed

    private void txt_slry_ts1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_slry_ts1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_slry_ts1ActionPerformed

    private void btn_slry_cal1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_slry_cal1ActionPerformed
         HashMap fp_p1 = new HashMap();
        fp_p1.put("psal", txt_slry_ts1.getText());
        
        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("C:\\xampp\\htdocs\\ITP\\Project\\VIVA\\IREPORTS\\EMS_SalaryP.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_btn_slry_cal1ActionPerformed
     
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EMS_EmployeeManagementSystem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new EMS_EmployeeManagementSystem().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EMS_EmployeeManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(EMS_EmployeeManagementSystem.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Client;
    private javax.swing.JButton ClientLogo;
    private javax.swing.JPanel Salary;
    private javax.swing.JLabel System;
    private javax.swing.JTextField Txt1_srch1;
    private javax.swing.JPanel attendence;
    private javax.swing.JButton btn_atten_in;
    private javax.swing.JButton btn_atten_in1;
    private javax.swing.JButton btn_atten_out1;
    private javax.swing.JButton btn_leave_add;
    private javax.swing.JButton btn_reg_m;
    private javax.swing.JButton btn_reg_m1;
    private javax.swing.JButton btn_slry_cal;
    private javax.swing.JButton btn_slry_cal1;
    private javax.swing.JButton btnattendence;
    private javax.swing.JButton btnattendence1;
    private javax.swing.JButton btnattendence2;
    private javax.swing.JButton btnemployeeprofile;
    private javax.swing.JButton btnregistration;
    private javax.swing.JButton btnsalary;
    private javax.swing.JButton btnsalary1;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> combox_gender;
    private javax.swing.JComboBox<String> combox_posi;
    private javax.swing.JPanel dashboard;
    private javax.swing.JLabel date_txt1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable_add;
    private javax.swing.JTable jTable_leave;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lbl_atten_id1;
    private javax.swing.JLabel lbl_atten_id2;
    private javax.swing.JLabel lbl_atten_id3;
    private javax.swing.JLabel lbl_atten_id4;
    private javax.swing.JLabel lbl_leave_ed;
    private javax.swing.JLabel lbl_leave_fn;
    private javax.swing.JLabel lbl_leave_nod;
    private javax.swing.JLabel lbl_leave_sd;
    private javax.swing.JLabel lbl_reg;
    private javax.swing.JLabel lbl_reg_contact;
    private javax.swing.JLabel lbl_reg_dob;
    private javax.swing.JLabel lbl_reg_email;
    private javax.swing.JLabel lbl_reg_fn;
    private javax.swing.JLabel lbl_reg_gender;
    private javax.swing.JLabel lbl_reg_id;
    private javax.swing.JLabel lbl_reg_ln;
    private javax.swing.JLabel lbl_reg_position;
    private javax.swing.JLabel lbl_slry_eid;
    private javax.swing.JLabel lbl_slry_eid1;
    private javax.swing.JLabel lbl_slry_eid2;
    private javax.swing.JLabel lbl_slry_fn;
    private javax.swing.JLabel lbl_slry_m;
    private javax.swing.JLabel lbl_slry_possition;
    private javax.swing.JLabel lbl_slry_ts;
    private javax.swing.JPanel leave;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JButton mngprofile1;
    private javax.swing.JButton mngprofile3;
    private javax.swing.JPanel registration;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JPanel subSystemHomePanel;
    private javax.swing.JTable tbl_slry;
    private javax.swing.JLabel time_txt;
    private javax.swing.JPanel topBar;
    private javax.swing.JTextField txt_atten_id1;
    private javax.swing.JTextField txt_atten_id2;
    private javax.swing.JTextField txt_contact;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_fn;
    private javax.swing.JTextField txt_fn1;
    private javax.swing.JTextField txt_leave_fn;
    private javax.swing.JTextField txt_leave_nod;
    private javax.swing.JTextField txt_ln;
    private javax.swing.JTextField txt_slry_eid;
    private javax.swing.JTextField txt_slry_fn;
    private javax.swing.JTextField txt_slry_ts;
    private javax.swing.JTextField txt_slry_ts1;
    // End of variables declaration//GEN-END:variables

  
    
}
