package TMS;

import DBConnection.DBConnect;
import SPMS.dbConnection;

import SPMS.dbConnection;
import EMS.EMS_EmployeeManagementSystem;
import SPMS_IREPORTS.IREPORT_PARAMETERIZED;
import SchoolInformationManagementSystem.SIMS_DashBoard;
import SchoolInformationManagementSystem.SIMS_HomeScreen;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
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

/**
 *
 * @author I.L.Basnayake
 */
public class TMS_Timetablemangemnet extends javax.swing.JFrame {

    public Connection conn = null;
    public PreparedStatement pst = null;
    public ResultSet rs = null;
//    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    public String url = "jdbc:sqlserver://localhost:24809;databaseName=sms_";
//    public String user = "adminK";
//    public String pw = "admink";

    public TMS_Timetablemangemnet() throws ClassNotFoundException, SQLException {
        initComponents();
        //conn = dbConnection.connectToDb();
//        Class.forName(driver);
//        conn = DriverManager.getConnection(url, user, pw);

        conn = DBConnect.connect();
        updatetable();

        //load to table
        tableload();

    }

    private void updatetable() {
        /* try{
            String sql = "select className,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_classwise";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery(sql);
           classtable.setModel(DbUtils.resultSetToTableModel(rs)); 
            
        }
        
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
        
    }*/

    }

    public void tableload() {
        try {
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);
            String sql = "select timeTableID,className,classTeacherName,day,period1,period2,period3,period4,period5,period6,period7,period8 FROM tms_classwise";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable5.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {

        }

    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        SIDEMENUE = new javax.swing.JPanel();
        STAFFTTT = new javax.swing.JButton();
        stafftimetable = new javax.swing.JButton();
        searchstafftt = new javax.swing.JButton();
        STAFFID = new javax.swing.JButton();
        mngprofile1 = new javax.swing.JButton();
        mngprofile3 = new javax.swing.JButton();
        DASHBOARD1 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        MAINPANELT = new javax.swing.JPanel();
        classwisetimetablee = new javax.swing.JPanel();
        classwise = new javax.swing.JPanel();
        CREATETIMTABLE = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jComboBox4 = new javax.swing.JComboBox<>();
        jComboBox5 = new javax.swing.JComboBox<>();
        jComboBox6 = new javax.swing.JComboBox<>();
        jComboBox8 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jComboBox7 = new javax.swing.JComboBox<>();
        jComboBox11 = new javax.swing.JComboBox<>();
        jComboBox12 = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton16 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable();
        addclass1 = new javax.swing.JButton();
        addclass2 = new javax.swing.JButton();
        cleasclass1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        addc = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        backclass = new javax.swing.JButton();
        addclass = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        classtable = new javax.swing.JTable();
        updateclass = new javax.swing.JButton();
        deleateclass = new javax.swing.JButton();
        cleasclass = new javax.swing.JButton();
        jTextField5 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        updatec = new javax.swing.JPanel();
        SEARCHSTAFFTT = new javax.swing.JPanel();
        searchstafftt1 = new javax.swing.JPanel();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel33 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        searchclasstt2 = new javax.swing.JPanel();
        SEARCHSTAFF = new javax.swing.JPanel();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();
        jLabel31 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton15 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        dashboard = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        stafftimetable2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jComboBox13 = new javax.swing.JComboBox<>();
        jTextField4 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jComboBox14 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox9 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jComboBox10 = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jComboBox15 = new javax.swing.JComboBox<>();
        jLabel23 = new javax.swing.JLabel();
        jComboBox16 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        jComboBox17 = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        jComboBox18 = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        jComboBox19 = new javax.swing.JComboBox<>();
        jLabel27 = new javax.swing.JLabel();
        jComboBox20 = new javax.swing.JComboBox<>();
        jButton17 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton9 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        staffadd = new javax.swing.JButton();
        staffupdate = new javax.swing.JButton();
        staffdeleate = new javax.swing.JButton();
        staffclear = new javax.swing.JButton();
        backstaff = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        UPMENUE = new javax.swing.JPanel();
        System = new javax.swing.JLabel();
        Client = new javax.swing.JLabel();
        ClientLogo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1350, 720));
        setSize(new java.awt.Dimension(1350, 720));

        SIDEMENUE.setBackground(new java.awt.Color(41, 48, 66));

        STAFFTTT.setBackground(new java.awt.Color(41, 48, 66));
        STAFFTTT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        STAFFTTT.setForeground(new java.awt.Color(255, 255, 255));
        STAFFTTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_LMS/empm.png"))); // NOI18N
        STAFFTTT.setText("STAFF TIMETABLE");
        STAFFTTT.setContentAreaFilled(false);
        STAFFTTT.setPreferredSize(new java.awt.Dimension(111, 23));
        STAFFTTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STAFFTTTActionPerformed(evt);
            }
        });

        stafftimetable.setBackground(new java.awt.Color(41, 48, 66));
        stafftimetable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        stafftimetable.setForeground(new java.awt.Color(255, 255, 255));
        stafftimetable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/emply.png"))); // NOI18N
        stafftimetable.setText("SEARCH CLASSTIMETABLE");
        stafftimetable.setToolTipText("");
        stafftimetable.setContentAreaFilled(false);
        stafftimetable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stafftimetableActionPerformed(evt);
            }
        });

        searchstafftt.setBackground(new java.awt.Color(41, 48, 66));
        searchstafftt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        searchstafftt.setForeground(new java.awt.Color(255, 255, 255));
        searchstafftt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_LMS/resultk.png"))); // NOI18N
        searchstafftt.setText("SEARCH STAFF TIMETABLE");
        searchstafftt.setContentAreaFilled(false);
        searchstafftt.setPreferredSize(new java.awt.Dimension(111, 23));
        searchstafftt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchstaffttActionPerformed(evt);
            }
        });

        STAFFID.setBackground(new java.awt.Color(41, 48, 66));
        STAFFID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        STAFFID.setForeground(new java.awt.Color(255, 255, 255));
        STAFFID.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_TMS/tminfo.png"))); // NOI18N
        STAFFID.setText("CLASS WISE TIMETABLE");
        STAFFID.setContentAreaFilled(false);
        STAFFID.setPreferredSize(new java.awt.Dimension(111, 23));
        STAFFID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                STAFFIDActionPerformed(evt);
            }
        });

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

        DASHBOARD1.setBackground(new java.awt.Color(41, 48, 66));
        DASHBOARD1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DASHBOARD1.setForeground(new java.awt.Color(255, 255, 255));
        DASHBOARD1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_LMS/dashboard.png"))); // NOI18N
        DASHBOARD1.setText("Dashboard");
        DASHBOARD1.setContentAreaFilled(false);
        DASHBOARD1.setPreferredSize(new java.awt.Dimension(111, 23));
        DASHBOARD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DASHBOARD1ActionPerformed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_TMS/TT1.jpg"))); // NOI18N

        javax.swing.GroupLayout SIDEMENUELayout = new javax.swing.GroupLayout(SIDEMENUE);
        SIDEMENUE.setLayout(SIDEMENUELayout);
        SIDEMENUELayout.setHorizontalGroup(
            SIDEMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, SIDEMENUELayout.createSequentialGroup()
                .addGap(0, 20, Short.MAX_VALUE)
                .addGroup(SIDEMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(DASHBOARD1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(SIDEMENUELayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(mngprofile1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mngprofile3))
                    .addComponent(STAFFTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52))
            .addGroup(SIDEMENUELayout.createSequentialGroup()
                .addGroup(SIDEMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SIDEMENUELayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(SIDEMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(stafftimetable, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(SIDEMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(STAFFID, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                                .addComponent(searchstafftt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(SIDEMENUELayout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SIDEMENUELayout.setVerticalGroup(
            SIDEMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SIDEMENUELayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(SIDEMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(mngprofile1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mngprofile3, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(26, 26, 26)
                .addComponent(DASHBOARD1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(STAFFID, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(STAFFTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(searchstafftt, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(stafftimetable, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        MAINPANELT.setLayout(new java.awt.CardLayout());

        classwisetimetablee.setBackground(new java.awt.Color(204, 204, 204));

        classwise.setLayout(new java.awt.CardLayout());

        CREATETIMTABLE.setBackground(new java.awt.Color(204, 204, 255));

        jButton3.setBackground(new java.awt.Color(204, 204, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 51));
        jButton3.setText("GENERATE TIME TABLE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(0, 0, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 51));
        jLabel1.setText("TIME TABLE ID");

        jLabel2.setBackground(new java.awt.Color(0, 0, 102));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 51, 51));
        jLabel2.setText("CLASSNAME");

        jLabel3.setBackground(new java.awt.Color(0, 0, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 51, 51));
        jLabel3.setText("DAYS");

        jLabel4.setBackground(new java.awt.Color(0, 0, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 51, 51));
        jLabel4.setText("PERIOD 1");

        jLabel5.setBackground(new java.awt.Color(0, 0, 102));
        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 51, 51));
        jLabel5.setText("PERIOD2");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel6.setBackground(new java.awt.Color(0, 0, 102));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 51, 51));
        jLabel6.setText("PERIOD 3");

        jLabel7.setBackground(new java.awt.Color(0, 0, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 51, 51));
        jLabel7.setText("PERIOD 4");

        jLabel8.setBackground(new java.awt.Color(0, 0, 102));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 51, 51));
        jLabel8.setText("PERIOD 5");

        jLabel9.setBackground(new java.awt.Color(0, 0, 102));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 51, 51));
        jLabel9.setText("PERIOD 6");

        jLabel10.setBackground(new java.awt.Color(0, 0, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 51, 51));
        jLabel10.setText("PERIOD 7");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jComboBox4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jComboBox5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jComboBox6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jComboBox8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel19.setBackground(new java.awt.Color(0, 0, 102));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 51, 51));
        jLabel19.setText("PERIOD8");

        jComboBox7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jComboBox11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", " " }));

        jComboBox12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GRADE", "GRADE  6-A", "GRADE  6-B", "GRADE 7-A", "GRADE  8-A", "GRADE 8-B", "GRADE  9", "GRADE  10-A", "GRADE  10-B", "GRADE  11-A", "GRADE  11-B", " ", " " }));
        jComboBox12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox12ActionPerformed(evt);
            }
        });

        jLabel20.setBackground(new java.awt.Color(0, 0, 102));
        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 51, 51));
        jLabel20.setText("CLASS TEACHER NAME");

        jButton16.setBackground(new java.awt.Color(102, 153, 255));
        jButton16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton16.setForeground(new java.awt.Color(0, 51, 102));
        jButton16.setText("SAVE");
        jButton16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton16MouseClicked(evt);
            }
        });
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jLabel17.setBackground(new java.awt.Color(0, 0, 102));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setText("CLASS TIMETABLE 2018");

        jTable5.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "timetableid", "classname", "classt name", "days", "period1", "period2", "period3", "period4", "period5", "period6", "period7", "period8"
            }
        ));
        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable5MouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(jTable5);

        addclass1.setBackground(new java.awt.Color(153, 0, 255));
        addclass1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addclass1.setForeground(new java.awt.Color(255, 255, 255));
        addclass1.setText("ADD");
        addclass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclass1ActionPerformed(evt);
            }
        });

        addclass2.setBackground(new java.awt.Color(0, 179, 60));
        addclass2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        addclass2.setForeground(new java.awt.Color(255, 255, 255));
        addclass2.setText("UPDATE");
        addclass2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclass2ActionPerformed(evt);
            }
        });

        cleasclass1.setBackground(new java.awt.Color(102, 51, 255));
        cleasclass1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cleasclass1.setForeground(new java.awt.Color(0, 0, 102));
        cleasclass1.setText("CLEAR");
        cleasclass1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleasclass1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 51));
        jButton4.setText("GENERATE Report");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CREATETIMTABLELayout = new javax.swing.GroupLayout(CREATETIMTABLE);
        CREATETIMTABLE.setLayout(CREATETIMTABLELayout);
        CREATETIMTABLELayout.setHorizontalGroup(
            CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATETIMTABLELayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATETIMTABLELayout.createSequentialGroup()
                                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                                                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel19)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(76, 76, 76))
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jComboBox5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jComboBox12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jComboBox7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBox8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATETIMTABLELayout.createSequentialGroup()
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(addclass2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                            .addComponent(jButton16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addclass1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cleasclass1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                        .addGap(304, 304, 304))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATETIMTABLELayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 844, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                .addGap(356, 356, 356)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        CREATETIMTABLELayout.setVerticalGroup(
            CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jButton4))
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 53, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, CREATETIMTABLELayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton16))
                .addGap(24, 24, 24)
                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBox4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(32, 32, 32)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jComboBox6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(32, 32, 32)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jComboBox7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jComboBox8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(CREATETIMTABLELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(30, Short.MAX_VALUE))
                    .addGroup(CREATETIMTABLELayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(addclass1)
                        .addGap(41, 41, 41)
                        .addComponent(addclass2)
                        .addGap(32, 32, 32)
                        .addComponent(cleasclass1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        classwise.add(CREATETIMTABLE, "card2");

        addc.setBackground(new java.awt.Color(153, 153, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 230));

        backclass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backclass.setText("Back");
        backclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backclassActionPerformed(evt);
            }
        });

        addclass.setBackground(new java.awt.Color(0, 179, 60));
        addclass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addclass.setForeground(new java.awt.Color(255, 255, 255));
        addclass.setText("ADD");
        addclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclassActionPerformed(evt);
            }
        });

        classtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Timetable ID", "Class Name", "Days", "PERIOD1", "PERIOD2", "PERIOD3", "PERIOD4", "PERIOD5", "PERIOD6", "PERIOD7", "PERIOD8"
            }
        ));
        classtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                classtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(classtable);

        updateclass.setText("UPDATE");
        updateclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateclassActionPerformed(evt);
            }
        });

        deleateclass.setText("DELEATE");
        deleateclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleateclassActionPerformed(evt);
            }
        });

        cleasclass.setBackground(new java.awt.Color(102, 51, 255));
        cleasclass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cleasclass.setForeground(new java.awt.Color(0, 0, 102));
        cleasclass.setText("CLEAR");
        cleasclass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleasclassActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(0, 0, 102));
        jLabel29.setText("GRADE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(updateclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(deleateclass, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(cleasclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(backclass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(534, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 808, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(addclass)
                        .addGap(30, 30, 30))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29))
                        .addGap(33, 33, 33)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(updateclass)
                        .addGap(39, 39, 39)
                        .addComponent(deleateclass)
                        .addGap(33, 33, 33)
                        .addComponent(cleasclass)
                        .addGap(34, 34, 34)
                        .addComponent(backclass)
                        .addGap(51, 51, 51)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(77, 126, Short.MAX_VALUE))
        );

        jLabel32.setBackground(new java.awt.Color(0, 0, 102));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(0, 0, 102));
        jLabel32.setText("CLASS TIMETABLE 2018");

        javax.swing.GroupLayout addcLayout = new javax.swing.GroupLayout(addc);
        addc.setLayout(addcLayout);
        addcLayout.setHorizontalGroup(
            addcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addcLayout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
            .addGroup(addcLayout.createSequentialGroup()
                .addGap(533, 533, 533)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addcLayout.setVerticalGroup(
            addcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addcLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel32)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );

        classwise.add(addc, "card3");

        updatec.setBackground(new java.awt.Color(204, 204, 255));

        javax.swing.GroupLayout updatecLayout = new javax.swing.GroupLayout(updatec);
        updatec.setLayout(updatecLayout);
        updatecLayout.setHorizontalGroup(
            updatecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1339, Short.MAX_VALUE)
        );
        updatecLayout.setVerticalGroup(
            updatecLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );

        classwise.add(updatec, "card4");

        javax.swing.GroupLayout classwisetimetableeLayout = new javax.swing.GroupLayout(classwisetimetablee);
        classwisetimetablee.setLayout(classwisetimetableeLayout);
        classwisetimetableeLayout.setHorizontalGroup(
            classwisetimetableeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(classwise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        classwisetimetableeLayout.setVerticalGroup(
            classwisetimetableeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(classwise, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        MAINPANELT.add(classwisetimetablee, "card3");

        SEARCHSTAFFTT.setBackground(new java.awt.Color(255, 204, 204));
        SEARCHSTAFFTT.setLayout(new java.awt.CardLayout());

        searchstafftt1.setBackground(new java.awt.Color(153, 153, 255));

        jButton19.setBackground(new java.awt.Color(0, 179, 60));
        jButton19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton19.setForeground(new java.awt.Color(255, 255, 255));
        jButton19.setText("Add");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setBackground(new java.awt.Color(0, 77, 153));
        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setForeground(new java.awt.Color(255, 255, 255));
        jButton20.setText("UPDATE");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setBackground(new java.awt.Color(255, 26, 26));
        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setForeground(new java.awt.Color(255, 255, 255));
        jButton21.setText("DELEATE");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CLASSname", "DAY", "PERIOD1", "PERIOD2", "PERIOD3", "PERIOD4", "PERIOD5", "PERIOD6", "PERIOD7", "PERIOD8"
            }
        ));
        jScrollPane3.setViewportView(jTable3);

        jLabel33.setBackground(new java.awt.Color(0, 102, 102));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel33.setText("TEACHERS NAME");

        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });

        jButton22.setBackground(new java.awt.Color(255, 26, 26));
        jButton22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton22.setForeground(new java.awt.Color(255, 255, 255));
        jButton22.setText("SEARCH");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setBackground(new java.awt.Color(0, 77, 153));
        jButton23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton23.setForeground(new java.awt.Color(255, 255, 255));
        jButton23.setText("CLEAR");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton25.setBackground(new java.awt.Color(0, 77, 153));
        jButton25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton25.setForeground(new java.awt.Color(255, 255, 255));
        jButton25.setText("Generate Report");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout searchstafftt1Layout = new javax.swing.GroupLayout(searchstafftt1);
        searchstafftt1.setLayout(searchstafftt1Layout);
        searchstafftt1Layout.setHorizontalGroup(
            searchstafftt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchstafftt1Layout.createSequentialGroup()
                .addGroup(searchstafftt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(searchstafftt1Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchstafftt1Layout.createSequentialGroup()
                        .addGap(223, 223, 223)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(searchstafftt1Layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(253, Short.MAX_VALUE))
        );
        searchstafftt1Layout.setVerticalGroup(
            searchstafftt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchstafftt1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(searchstafftt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22)
                    .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(searchstafftt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(270, Short.MAX_VALUE))
        );

        SEARCHSTAFFTT.add(searchstafftt1, "card2");

        MAINPANELT.add(SEARCHSTAFFTT, "card4");

        SEARCHSTAFF.setBackground(new java.awt.Color(153, 153, 255));

        jButton12.setBackground(new java.awt.Color(0, 179, 60));
        jButton12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("DELEATE");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setBackground(new java.awt.Color(0, 77, 153));
        jButton13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("Update");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setBackground(new java.awt.Color(255, 26, 26));
        jButton14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("CLEAR");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "timetableid", "classname", "classTeacherName", "days", "PERIOD1", "PERIOD2", "PERIOD3", "PERIOD4", "PERIOD5", "PERIOD6", "PERIOD7", "PERIOD8"
            }
        ));
        jScrollPane5.setViewportView(jTable4);

        jLabel31.setBackground(new java.awt.Color(0, 153, 153));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 153));
        jLabel31.setText("SEARCH CLASS GRADE");

        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });

        jButton15.setBackground(new java.awt.Color(255, 26, 26));
        jButton15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("SEARCH");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton18.setBackground(new java.awt.Color(0, 179, 60));
        jButton18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton18.setForeground(new java.awt.Color(255, 255, 255));
        jButton18.setText("ADD");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton24.setBackground(new java.awt.Color(0, 179, 60));
        jButton24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton24.setForeground(new java.awt.Color(255, 255, 255));
        jButton24.setText("BACK");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout SEARCHSTAFFLayout = new javax.swing.GroupLayout(SEARCHSTAFF);
        SEARCHSTAFF.setLayout(SEARCHSTAFFLayout);
        SEARCHSTAFFLayout.setHorizontalGroup(
            SEARCHSTAFFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SEARCHSTAFFLayout.createSequentialGroup()
                .addGroup(SEARCHSTAFFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SEARCHSTAFFLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SEARCHSTAFFLayout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SEARCHSTAFFLayout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        SEARCHSTAFFLayout.setVerticalGroup(
            SEARCHSTAFFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SEARCHSTAFFLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(SEARCHSTAFFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15))
                .addGap(68, 68, 68)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83)
                .addGroup(SEARCHSTAFFLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton13)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(191, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout searchclasstt2Layout = new javax.swing.GroupLayout(searchclasstt2);
        searchclasstt2.setLayout(searchclasstt2Layout);
        searchclasstt2Layout.setHorizontalGroup(
            searchclasstt2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchclasstt2Layout.createSequentialGroup()
                .addComponent(SEARCHSTAFF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );
        searchclasstt2Layout.setVerticalGroup(
            searchclasstt2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchclasstt2Layout.createSequentialGroup()
                .addComponent(SEARCHSTAFF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        MAINPANELT.add(searchclasstt2, "card2");

        dashboard.setBackground(new java.awt.Color(0, 102, 102));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_TMS/ttnew2.jpg"))); // NOI18N

        javax.swing.GroupLayout dashboardLayout = new javax.swing.GroupLayout(dashboard);
        dashboard.setLayout(dashboardLayout);
        dashboardLayout.setHorizontalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(234, 234, 234)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(490, Short.MAX_VALUE))
        );
        dashboardLayout.setVerticalGroup(
            dashboardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardLayout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );

        MAINPANELT.add(dashboard, "dashboard");

        stafftimetable2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel12.setBackground(new java.awt.Color(0, 0, 102));
        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 51, 51));
        jLabel12.setText("TEACHER ID");

        jLabel13.setBackground(new java.awt.Color(0, 0, 102));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 51, 51));
        jLabel13.setText("CLASSNAME");

        jComboBox13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GRADE", "GRADE  6-A", "GRADE  6-B", "GRADE 7-A", "GRADE  8-A", "GRADE 8-B", "GRADE  9", "GRADE  10-A", "GRADE  10-B", "GRADE  11-A", "GRADE  11-B", " ", " " }));

        jLabel21.setBackground(new java.awt.Color(0, 0, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 51, 51));
        jLabel21.setText("CLASS TEACHER NAME");

        jLabel14.setBackground(new java.awt.Color(0, 0, 102));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 51, 51));
        jLabel14.setText("DAYS");

        jComboBox14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY", "FRIDAY", " " }));

        jLabel15.setBackground(new java.awt.Color(0, 0, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 51, 51));
        jLabel15.setText("PERIOD 1");

        jComboBox9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel18.setBackground(new java.awt.Color(0, 0, 102));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 51, 51));
        jLabel18.setText("PERIOD2");

        jComboBox10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel22.setBackground(new java.awt.Color(0, 0, 102));
        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 51, 51));
        jLabel22.setText("PERIOD 3");

        jComboBox15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel23.setBackground(new java.awt.Color(0, 0, 102));
        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(0, 51, 51));
        jLabel23.setText("PERIOD 4");

        jComboBox16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel24.setBackground(new java.awt.Color(0, 0, 102));
        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 51, 51));
        jLabel24.setText("PERIOD 5");

        jComboBox17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel25.setBackground(new java.awt.Color(0, 0, 102));
        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(0, 51, 51));
        jLabel25.setText("PERIOD 6");

        jComboBox18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel26.setBackground(new java.awt.Color(0, 0, 102));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 51, 51));
        jLabel26.setText("PERIOD 7");

        jComboBox19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jLabel27.setBackground(new java.awt.Color(0, 0, 102));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 51, 51));
        jLabel27.setText("PERIOD8");

        jComboBox20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUBJECTS", "     -", "MATHEMATICS", "ISLAM", "ENVIRONMENTAL STUDIS", "SINHALA", "BUDDHISM", "SCIENCE", "HISTORY", "SINHALA" }));

        jButton17.setBackground(new java.awt.Color(0, 0, 51));
        jButton17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton17.setForeground(new java.awt.Color(0, 0, 51));
        jButton17.setText("SAVE");
        jButton17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton17MouseClicked(evt);
            }
        });
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton8.setBackground(new java.awt.Color(0, 0, 51));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 51));
        jButton8.setText("INSERT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "teacherID", "Classteachername", "DAYS", "PERIOD1", "PERIOD2", "PERIOD3", "PERIOD4", "PERIOD5", "PERIOD6", "PERIOD7", "PERIOD8"
            }
        ));
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTable2);

        jButton9.setBackground(new java.awt.Color(0, 0, 51));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton9.setForeground(new java.awt.Color(0, 0, 51));
        jButton9.setText("DELEATE");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel12))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15)
                            .addComponent(jLabel22)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26))))
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox18, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox13, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3)
                    .addComponent(jTextField4)
                    .addComponent(jComboBox14, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox10, 0, 198, Short.MAX_VALUE)
                    .addComponent(jComboBox9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox15, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox17, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox19, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox20, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBox16, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(108, 108, 108)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jButton8)
                        .addGap(51, 51, 51)
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 817, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton8)
                            .addComponent(jButton9)
                            .addComponent(jButton17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel25)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel26)
                        .addGap(26, 26, 26))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel21)
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel14))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30)
                                        .addComponent(jComboBox14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel15)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel18)
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel22)
                                    .addComponent(jComboBox15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addComponent(jLabel23)
                                .addGap(36, 36, 36)
                                .addComponent(jLabel24))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jComboBox9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addComponent(jComboBox10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(84, 84, 84)
                                .addComponent(jComboBox16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jComboBox17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(jComboBox18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jComboBox19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTabbedPane1.addTab("STAFF TIME TABLE", jPanel2);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "DAYS", "PERIOD1", "PERIOD2", "PERIOD3", "PERIOD4", "PERIOD5", "PERIOD6", "PERIOD7", "PERIOD8"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        staffadd.setBackground(new java.awt.Color(0, 179, 60));
        staffadd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        staffadd.setForeground(new java.awt.Color(255, 255, 255));
        staffadd.setText("ADD");
        staffadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffaddActionPerformed(evt);
            }
        });

        staffupdate.setText("UPDATE");
        staffupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffupdateActionPerformed(evt);
            }
        });

        staffdeleate.setText("DELEATE");
        staffdeleate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffdeleateActionPerformed(evt);
            }
        });

        staffclear.setBackground(new java.awt.Color(102, 51, 255));
        staffclear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        staffclear.setForeground(new java.awt.Color(0, 0, 102));
        staffclear.setText("CLEAR");
        staffclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                staffclearActionPerformed(evt);
            }
        });

        backstaff.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        backstaff.setText("Back");
        backstaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backstaffActionPerformed(evt);
            }
        });

        jLabel30.setBackground(new java.awt.Color(0, 102, 102));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 0, 102));
        jLabel30.setText("STAFF TIME TABLE 2018");

        jTextField8.setText("jTextField8");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffadd, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffdeleate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffclear, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(backstaff, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(staffupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(97, 97, 97)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(405, 405, 405))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(57, 57, 57)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(staffadd)
                        .addGap(44, 44, 44)
                        .addComponent(staffupdate)
                        .addGap(32, 32, 32)
                        .addComponent(staffdeleate)
                        .addGap(40, 40, 40)))
                .addComponent(staffclear)
                .addGap(36, 36, 36)
                .addComponent(backstaff)
                .addGap(119, 119, 119))
        );

        jTabbedPane1.addTab("GENERATE TIMETABLE", jPanel5);

        jLabel28.setBackground(new java.awt.Color(0, 102, 102));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(51, 0, 102));
        jLabel28.setText("STAFF TIME TABLE 2018");

        javax.swing.GroupLayout stafftimetable2Layout = new javax.swing.GroupLayout(stafftimetable2);
        stafftimetable2.setLayout(stafftimetable2Layout);
        stafftimetable2Layout.setHorizontalGroup(
            stafftimetable2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stafftimetable2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1)
                .addContainerGap())
            .addGroup(stafftimetable2Layout.createSequentialGroup()
                .addGap(469, 469, 469)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        stafftimetable2Layout.setVerticalGroup(
            stafftimetable2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, stafftimetable2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MAINPANELT.add(stafftimetable2, "card6");

        UPMENUE.setBackground(new java.awt.Color(26, 56, 103));
        UPMENUE.setMaximumSize(new java.awt.Dimension(944, 119));
        UPMENUE.setMinimumSize(new java.awt.Dimension(944, 119));

        System.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        System.setForeground(new java.awt.Color(255, 255, 255));
        System.setText("School Information Management System ");

        Client.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Client.setForeground(new java.awt.Color(255, 255, 255));
        Client.setText("TimeTable Management System");

        ClientLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/rsz_logop.png"))); // NOI18N
        ClientLogo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ClientLogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClientLogoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout UPMENUELayout = new javax.swing.GroupLayout(UPMENUE);
        UPMENUE.setLayout(UPMENUELayout);
        UPMENUELayout.setHorizontalGroup(
            UPMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPMENUELayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(ClientLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(UPMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UPMENUELayout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(System))
                    .addGroup(UPMENUELayout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(Client)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        UPMENUELayout.setVerticalGroup(
            UPMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UPMENUELayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UPMENUELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ClientLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(UPMENUELayout.createSequentialGroup()
                        .addComponent(System, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Client)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(SIDEMENUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MAINPANELT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(UPMENUE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(UPMENUE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MAINPANELT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(SIDEMENUE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void STAFFIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STAFFIDActionPerformed
        MAINPANELT.removeAll();
        MAINPANELT.add(classwisetimetablee);
        MAINPANELT.repaint();
        MAINPANELT.revalidate();
    }//GEN-LAST:event_STAFFIDActionPerformed

    private void searchstaffttActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchstaffttActionPerformed
        MAINPANELT.removeAll();
        MAINPANELT.add(SEARCHSTAFFTT);
        MAINPANELT.repaint();
        MAINPANELT.revalidate();
    }//GEN-LAST:event_searchstaffttActionPerformed

    private void STAFFTTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_STAFFTTTActionPerformed
        MAINPANELT.removeAll();
        MAINPANELT.add(stafftimetable2);
        MAINPANELT.repaint();
        MAINPANELT.revalidate();
    }//GEN-LAST:event_STAFFTTTActionPerformed

    private void stafftimetableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stafftimetableActionPerformed
        MAINPANELT.removeAll();
        MAINPANELT.add(searchclasstt2);
        MAINPANELT.repaint();
        MAINPANELT.revalidate();
    }//GEN-LAST:event_stafftimetableActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        classwise.removeAll();
        classwise.add(addc);
        classwise.repaint();
        classwise.revalidate();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void backclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backclassActionPerformed
        classwise.removeAll();
        classwise.add(CREATETIMTABLE);
        classwise.repaint();
        classwise.revalidate();
    }//GEN-LAST:event_backclassActionPerformed

    private void mngprofile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofile1ActionPerformed

        dispose();
        new SIMS_DashBoard().setVisible(true);
    }//GEN-LAST:event_mngprofile1ActionPerformed

    private void mngprofile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofile3ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_mngprofile3ActionPerformed

    private void ClientLogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClientLogoActionPerformed
        dispose();
        try {
            new EMS_EmployeeManagementSystem().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TMS_Timetablemangemnet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(TMS_Timetablemangemnet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ClientLogoActionPerformed

    private void DASHBOARD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DASHBOARD1ActionPerformed
        MAINPANELT.removeAll();
        MAINPANELT.add(dashboard);
        MAINPANELT.repaint();
        MAINPANELT.revalidate();
    }//GEN-LAST:event_DASHBOARD1ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        /*searchclasstt2.removeAll();
      
        searchclasstt2.repaint();
        searchclasstt2.revalidate();*/

        int x = JOptionPane.showConfirmDialog(null, "do you want to update?");
        if (x == 0) {
            String timeTableID = jTextField1.getText();
            String className = jComboBox12.getSelectedItem().toString();
            String classTeacherName = jTextField2.getText();
            String day = jComboBox11.getSelectedItem().toString();
            String period1 = jComboBox1.getSelectedItem().toString();
            String period2 = jComboBox2.getSelectedItem().toString();
            String period3 = jComboBox3.getSelectedItem().toString();
            String period4 = jComboBox4.getSelectedItem().toString();
            String period5 = jComboBox6.getSelectedItem().toString();
            String period6 = jComboBox7.getSelectedItem().toString();
            String period7 = jComboBox8.getSelectedItem().toString();
            String period8 = jComboBox5.getSelectedItem().toString();

            try {
//                conn = DriverManager.getConnection(url, user, pw);
//                Class.forName(driver);

                String sql = "UPDATE tms_classwise SET className = '" + className + "',classTeacherName = '" + classTeacherName + "',day = '" + day + "',period1 = '" + period1 + "',period2 = '" + period2 + "',period3 = '" + period3 + "',period4 = '" + period4 + "',period5 = '" + period5 + "',period6 = '" + period6 + "',period7 = '" + period7 + "',period8 = '" + period8 + "' where timeTableID = '" + timeTableID + "' ";

                pst = conn.prepareStatement(sql);
                pst.execute();

                tableload();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTable4.getModel();
        if (jTable4.getSelectedRow() == -1) {
            if (jTable4.getRowCount() == 0) {
                jTextField6.setText("table is empty");
            } else {
                jTextField6.setText("select a period");
            }
        } else {
            model.removeRow(jTable4.getSelectedRow());
        }

        /*   searchclasstt2.removeAll();
     
        searchclasstt2.repaint();
        searchclasstt2.revalidate();*/
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton16MouseClicked

    }//GEN-LAST:event_jButton16MouseClicked

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        //conn = dbConnection.connectToDb();//calling the connection module

        try {

//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);
            String sql = "Insert into   tms_classwise (timeTableID,className,classTeacherName,day,period1,period2,period3,period4,period5,period6,period7,period8) values (?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField1.getText());
            pst.setString(2, jComboBox12.getSelectedItem().toString());
            pst.setString(3, jTextField2.getText());
            pst.setString(4, jComboBox11.getSelectedItem().toString());
            pst.setString(5, jComboBox1.getSelectedItem().toString());
            pst.setString(6, jComboBox2.getSelectedItem().toString());
            pst.setString(7, jComboBox3.getSelectedItem().toString());
            pst.setString(8, jComboBox4.getSelectedItem().toString());
            pst.setString(9, jComboBox5.getSelectedItem().toString());
            pst.setString(10, jComboBox6.getSelectedItem().toString());
            pst.setString(11, jComboBox7.getSelectedItem().toString());
            pst.setString(12, jComboBox8.getSelectedItem().toString());
            pst.execute();

            JOptionPane.showMessageDialog(null, "data saved succesfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        /*try
    	{
    	String sql = "INSERT INTO  tms_claastt"
            	+ "(timeTableID,className,classTeacherName,day, period1,period2,period3,period4,period5,period6,period7,period8)"
            	+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    	pst = conn.prepareStatement(sql);
    	pst.setString(1, jTextField1.getText());
    	pst.setString(2, jComboBox12.getSelectedItem().toString());
    	pst.setString(3, jTextField2.getText());
    	pst.setString(4, jComboBox11.getSelectedItem().toString());
    	pst.setString(5, jComboBox1.getSelectedItem().toString());
    	pst.setString(6, jComboBox2.getSelectedItem().toString());
    	pst.setString(7, jComboBox3.getSelectedItem().toString());
    	pst.setString(8, jComboBox4.getSelectedItem().toString());
    	pst.setString(9, jComboBox5.getSelectedItem().toString());
    	pst.setString(10, jComboBox6.getSelectedItem().toString());
    	pst.setString(11, jComboBox7.getSelectedItem().toString());
    	pst.setString(12, jComboBox8.getSelectedItem().toString());
    	pst.executeUpdate();
    
	}
	catch(SQLException ex)
	{
    	
	}
         */

    }//GEN-LAST:event_jButton16ActionPerformed

    private void addclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclassActionPerformed
        try {
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);
            String sql = "select day,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_classwise";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            classtable.setModel(DbUtils.resultSetToTableModel(rs));

            tableload();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }


    }//GEN-LAST:event_addclassActionPerformed

    private void jButton17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton17MouseClicked

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        //conn = dbConnection.connectToDb();//calling the connection module

        try {
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);

            String sql = "Insert into    tms_stafftt (teacherID,Classteachername,day,period1,period2,period3,period4,period5,period6,period7,period8) values (?,?,?,?,?,?,?,?,?,?,?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, jTextField3.getText());
            pst.setString(2, jTextField3.getText());
            pst.setString(3, jComboBox14.getSelectedItem().toString());
            pst.setString(4, jComboBox9.getSelectedItem().toString());
            pst.setString(5, jComboBox10.getSelectedItem().toString());
            pst.setString(6, jComboBox15.getSelectedItem().toString());
            pst.setString(7, jComboBox16.getSelectedItem().toString());
            pst.setString(8, jComboBox17.getSelectedItem().toString());
            pst.setString(9, jComboBox18.getSelectedItem().toString());
            pst.setString(10, jComboBox19.getSelectedItem().toString());
            pst.setString(11, jComboBox20.getSelectedItem().toString());
            pst.execute();

            JOptionPane.showMessageDialog(null, "data saved succesfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);
            String sql = "select teacherID,Classteachername,day,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_stafftt";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void cleasclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleasclassActionPerformed
        classtable.setModel(new DefaultTableModel(null, new String[]{"day", "period1", "period2", "period3", "period4", "period5", "period6", "period7", "period8"}));
    }//GEN-LAST:event_cleasclassActionPerformed

    private void jComboBox12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox12ActionPerformed
        jTextField5.setText(jComboBox12.getSelectedItem().toString());
    }//GEN-LAST:event_jComboBox12ActionPerformed

    private void updateclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateclassActionPerformed
        jTextField6.setText("");
        DefaultTableModel model = (DefaultTableModel) classtable.getModel();
        if (classtable.getSelectedRow() == -1) {
            if (classtable.getRowCount() == 0) {
                jTextField6.setText("table is empty");
            } else {
                jTextField6.setText("select a period");
            }
        } else {
            model.setValueAt(jComboBox11.getSelectedItem(), classtable.getSelectedRow(), 0);
            model.setValueAt(jComboBox1.getSelectedItem(), classtable.getSelectedRow(), 1);
            model.setValueAt(jComboBox2.getSelectedItem(), classtable.getSelectedRow(), 2);
            model.setValueAt(jComboBox3.getSelectedItem(), classtable.getSelectedRow(), 3);
            model.setValueAt(jComboBox4.getSelectedItem(), classtable.getSelectedRow(), 4);
            model.setValueAt(jComboBox5.getSelectedItem(), classtable.getSelectedRow(), 5);
            model.setValueAt(jComboBox6.getSelectedItem(), classtable.getSelectedRow(), 6);
            model.setValueAt(jComboBox7.getSelectedItem(), classtable.getSelectedRow(), 7);
            model.setValueAt(jComboBox8.getSelectedItem(), classtable.getSelectedRow(), 8);
        }


    }//GEN-LAST:event_updateclassActionPerformed

    private void classtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classtableMouseClicked
        int r = classtable.getSelectedRow();
        String timeTableID = classtable.getValueAt(r, 0).toString();
        /*String className=classtable.getValueAt(r, 1).toString();*/
 /* String classTeacherName=classtable.getValueAt(r, 2).toString();*/
        String day = classtable.getValueAt(r, 1).toString();
        String period1 = classtable.getValueAt(r, 2).toString();
        String period2 = classtable.getValueAt(r, 3).toString();
        String period3 = classtable.getValueAt(r, 4).toString();
        String period4 = classtable.getValueAt(r, 5).toString();
        String period5 = classtable.getValueAt(r, 6).toString();
        String period6 = classtable.getValueAt(r, 7).toString();
        String period7 = classtable.getValueAt(r, 8).toString();
        String period8 = classtable.getValueAt(r, 9).toString();

        jTextField1.setText(timeTableID);
        /*jComboBox12.setSelectedItem(className);
        jTextField2.setText(classTeacherName);*/
        jComboBox11.setSelectedItem(day);
        jComboBox1.setSelectedItem(period1);
        jComboBox2.setSelectedItem(period2);
        jComboBox3.setSelectedItem(period3);
        jComboBox4.setSelectedItem(period4);
        jComboBox6.setSelectedItem(period5);
        jComboBox7.setSelectedItem(period6);
        jComboBox8.setSelectedItem(period7);
        jComboBox5.setSelectedItem(period8);

        /*DefaultTableModel model = (DefaultTableModel) classtable.getModel();
        jComboBox11.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 0).toString());
        jComboBox1.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 1).toString());
        jComboBox2.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 2).toString());
        jComboBox3.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 3).toString());
        jComboBox4.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 4).toString());
        jComboBox5.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 5).toString()); 
        jComboBox6.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 6).toString());
        jComboBox7.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 7).toString());
        jComboBox8.setSelectedItem(model.getValueAt(classtable.getSelectedRow(), 8).toString());    */
    }//GEN-LAST:event_classtableMouseClicked

    private void deleateclassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleateclassActionPerformed
        DefaultTableModel model = (DefaultTableModel) classtable.getModel();
        if (classtable.getSelectedRow() == -1) {
            if (classtable.getRowCount() == 0) {
                jTextField6.setText("table is empty");
            } else {
                jTextField6.setText("select a period");
            }
        } else {
            model.removeRow(classtable.getSelectedRow());
        }
    }//GEN-LAST:event_deleateclassActionPerformed

    private void staffaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffaddActionPerformed
        try {
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);
            String sql = "select day,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_stafftt";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            jTable1.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_staffaddActionPerformed

    private void staffupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffupdateActionPerformed
        jTextField6.setText("");
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRow() == -1) {
            if (jTable1.getRowCount() == 0) {
                jTextField6.setText("table is empty");
            } else {
                jTextField6.setText("select a period");
            }
        } else {
            model.setValueAt(jComboBox11.getSelectedItem(), jTable1.getSelectedRow(), 0);
            model.setValueAt(jComboBox1.getSelectedItem(), jTable1.getSelectedRow(), 1);
            model.setValueAt(jComboBox2.getSelectedItem(), jTable1.getSelectedRow(), 2);
            model.setValueAt(jComboBox3.getSelectedItem(), jTable1.getSelectedRow(), 3);
            model.setValueAt(jComboBox4.getSelectedItem(), jTable1.getSelectedRow(), 4);
            model.setValueAt(jComboBox5.getSelectedItem(), jTable1.getSelectedRow(), 5);
            model.setValueAt(jComboBox6.getSelectedItem(), jTable1.getSelectedRow(), 6);
            model.setValueAt(jComboBox7.getSelectedItem(), jTable1.getSelectedRow(), 7);
            model.setValueAt(jComboBox8.getSelectedItem(), jTable1.getSelectedRow(), 8);
        }
    }//GEN-LAST:event_staffupdateActionPerformed

    private void staffdeleateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffdeleateActionPerformed
        /* String sql = "deleate from tms_stafftt where DAY=?";
        try{
            
             pst=conn.prepareStatement(sql);
             pst.setString(1,jTextField3.getText());
             
             
             pst.execute();
             
             JOptionPane.showMessageDialog(null,"deleated");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        updatetable();*/

        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        if (jTable1.getSelectedRow() == -1) {
            if (jTable1.getRowCount() == 0) {
                jTextField6.setText("table is empty");
            } else {
                jTextField6.setText("select a period");
            }
        } else {
            model.removeRow(jTable1.getSelectedRow());
        }
    }//GEN-LAST:event_staffdeleateActionPerformed

    private void staffclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_staffclearActionPerformed
        jTable1.setModel(new DefaultTableModel(null, new String[]{"day", "period1", "period2", "period3", "period4", "period5", "period6", "period7", "period8"}));
    }//GEN-LAST:event_staffclearActionPerformed

    private void backstaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backstaffActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backstaffActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        /*int selectedRow = jTable1.getSelectedRow();    
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        jTextField3.setText(model.getValueAt(jTable1.getSelectedRow(), 0).toString());
        jComboBox13.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 1).toString());
        jTextField4.setText(model.getValueAt(jTable1.getSelectedRow(), 2).toString());
        jComboBox14.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 3).toString());
        jComboBox9.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 4).toString());
        jComboBox10.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 5).toString());
        jComboBox15.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 6).toString());
        jComboBox16.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 7).toString());
        jComboBox17.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 8).toString()); 
        jComboBox18.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 9).toString());
        jComboBox19.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 10).toString());
        jComboBox20.setSelectedItem(model.getValueAt(jTable1.getSelectedRow(), 11).toString());    */
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseClicked

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void addclass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclass1ActionPerformed
        try {
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);

            String sql = "select className,classTeacherName,day,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_classwise";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable5.setModel(DbUtils.resultSetToTableModel(rs));

            tableload();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_addclass1ActionPerformed

    private void addclass2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclass2ActionPerformed
        int x = JOptionPane.showConfirmDialog(null, "do you want to update?");
        if (x == 0) {
            String timeTableID = jTextField1.getText();
            String className = jComboBox12.getSelectedItem().toString();
            String classTeacherName = jTextField2.getText();
            String day = jComboBox11.getSelectedItem().toString();
            String period1 = jComboBox1.getSelectedItem().toString();
            String period2 = jComboBox2.getSelectedItem().toString();
            String period3 = jComboBox3.getSelectedItem().toString();
            String period4 = jComboBox4.getSelectedItem().toString();
            String period5 = jComboBox6.getSelectedItem().toString();
            String period6 = jComboBox7.getSelectedItem().toString();
            String period7 = jComboBox8.getSelectedItem().toString();
            String period8 = jComboBox5.getSelectedItem().toString();

            try {

//                conn = DriverManager.getConnection(url, user, pw);
//                Class.forName(driver);
                String sql = "UPDATE tms_classwise SET className = '" + className + "',classTeacherName = '" + classTeacherName + "',day = '" + day + "',period1 = '" + period1 + "',period2 = '" + period2 + "',period3 = '" + period3 + "',period4 = '" + period4 + "',period5 = '" + period5 + "',period6 = '" + period6 + "',period7 = '" + period7 + "',period8 = '" + period8 + "' where timeTableID = '" + timeTableID + "' ";

                pst = conn.prepareStatement(sql);
                pst.execute();

                tableload();
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_addclass2ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        int r = jTable5.getSelectedRow();
        String timeTableID = jTable5.getValueAt(r, 0).toString();
        String className = jTable5.getValueAt(r, 1).toString();
        String classTeacherName = jTable5.getValueAt(r, 2).toString();
        String day = jTable5.getValueAt(r, 3).toString();
        String period1 = jTable5.getValueAt(r, 4).toString();
        String period2 = jTable5.getValueAt(r, 5).toString();
        String period3 = jTable5.getValueAt(r, 6).toString();
        String period4 = jTable5.getValueAt(r, 7).toString();
        String period5 = jTable5.getValueAt(r, 8).toString();
        String period6 = jTable5.getValueAt(r, 9).toString();
        String period7 = jTable5.getValueAt(r, 10).toString();
        String period8 = jTable5.getValueAt(r, 11).toString();

        jTextField1.setText(timeTableID);
        jComboBox12.setSelectedItem(className);
        jTextField2.setText(classTeacherName);
        jComboBox11.setSelectedItem(day);
        jComboBox1.setSelectedItem(period1);
        jComboBox2.setSelectedItem(period2);
        jComboBox3.setSelectedItem(period3);
        jComboBox4.setSelectedItem(period4);
        jComboBox6.setSelectedItem(period5);
        jComboBox7.setSelectedItem(period6);
        jComboBox8.setSelectedItem(period7);
        jComboBox5.setSelectedItem(period8);

    }//GEN-LAST:event_jTable5MouseClicked

    private void cleasclass1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleasclass1ActionPerformed
        jTable5.setModel(new DefaultTableModel(null, new String[]{"timeTableID", "className", "classTeacherName", "day", "period1", "period2", "period3", "period4", "period5", "period6", "period7", "period8"}));
    }//GEN-LAST:event_cleasclass1ActionPerformed

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        /*try{
           String sql = "select * from tms_classwise where className = ? " ;
           
           pst=conn.prepareStatement(sql);
           pst.setString(1, jTextField7.getText());
           
           rs = pst.executeQuery();
           
           if(rs.next()){
               String add1=rs.getString("timeTableID");
               jTextField1.setText(add1);
               
                String add2=rs.getString("className");
                jComboBox12.setSelectedItem(add2);
                
                 String add3=rs.getString("classTeacherName");
                 jTextField2.setText(add3);
                 
                  String add4=rs.getString("day");
                  jComboBox11.setSelectedItem(add4);
                  
                   String add5=rs.getString("period1");
                   jComboBox1.setSelectedItem(add5);
                   
                    String add6=rs.getString("period2");
                    jComboBox2.setSelectedItem(add6);
                    
                     String add7=rs.getString("period3");
                     jComboBox3.setSelectedItem(add7);
                     
                      String add8=rs.getString("period4");
                      jComboBox4.setSelectedItem(add8);
                      
                       String add9=rs.getString("period5");
                       jComboBox6.setSelectedItem(add9);
                       
                        String add10=rs.getString("period6");
                        jComboBox7.setSelectedItem(add10);
                        
                         String add11=rs.getString("period7");
                         jComboBox8.setSelectedItem(add11);
                         
                          String add12=rs.getString("period8");
                          jComboBox5.setSelectedItem(add12);
                          
               
           }
           
       }catch(Exception e){
           JOptionPane.showMessageDialog(null,e);
       }*/
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        try {
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);

            String sql = "select className,classTeacherName,day,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_classwise";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            jTable4.setModel(DbUtils.resultSetToTableModel(rs));

            tableload();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed

        try {
            String classname = jTextField7.getText();
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);
            String sql = "Select timeTableID,className,classTeacherName,day,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_classwise where className LIKE '%" + classname + "%' ";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable4.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        jTable3.setModel(new DefaultTableModel(null,new String[]{"classTeacherName","className","day","period1","period2","period3","period4","period5","period6","period7","period8"}));
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
         int x=   JOptionPane.showConfirmDialog(null, "do you want to update?");
    if(x==0){
        String classTeacherName = jTextField3.getText();
     
       String day = jComboBox14.getSelectedItem().toString();
       String period1 =  jComboBox9.getSelectedItem().toString();
       String period2 = jComboBox10.getSelectedItem().toString(); 
       String period3 =  jComboBox15.getSelectedItem().toString();
        String period4 = jComboBox16.getSelectedItem().toString();
       String period5 = jComboBox17.getSelectedItem().toString(); 
       String period6 = jComboBox18.getSelectedItem().toString(); 
       String period7 = jComboBox19.getSelectedItem().toString(); 
       String period8 = jComboBox20.getSelectedItem().toString();
       
       String sql = "UPDATE tms_classwise SET className = classTeacherName = '"+classTeacherName+"',day = '"+day+"',period1 = '"+period1+"',period2 = '"+period2+"',period3 = '"+period3+"',period4 = '"+period4+"',period5 = '"+period5+"',period6 = '"+period6+"',period7 = '"+period7+"',period8 = '"+period8+"' where classTeacherName = '"+classTeacherName+"' ";
      try{
       pst = conn.prepareStatement(sql); 
       pst.execute();
       
          tableload();
      }catch(Exception e){
          
      }
    }        
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed

        try {
            String teachername = jTextField9.getText();
//            conn = DriverManager.getConnection(url, user, pw);
//            Class.forName(driver);
            String sql = "Select Classteachername,day,period1,period2,period3,period4,period5,period6,period7,period8 from  tms_stafft where Classteachername LIKE '%" + teachername + "%' ";

            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            jTable3.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        jTable4.setModel(new DefaultTableModel(null, new String[]{"timeTableID", "className", "classTeacherName", "day", "period1", "period2", "period3", "period4", "period5", "period6", "period7", "period8"}));
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        searchclasstt2.removeAll();
        searchclasstt2.add(CREATETIMTABLE);
        searchclasstt2.repaint();
        searchclasstt2.revalidate();
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
         try {
            String studentList = "C:\\xampp\\htdocs\\ITP\\Project\\VIVA\\IREPORTS\\TMS_TimeTableN.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(studentList);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        HashMap fp_p1 = new HashMap();
        fp_p1.put("ptname", jTextField9.getText());
        
        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("C:\\xampp\\htdocs\\ITP\\Project\\VIVA\\IREPORTS\\TMS_TimeTableP.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
       try{
            String sql = "select classTeacherName,day,period1,period2,period3,period4,period5,period6,period7,period8 from tms_stafft";
            pst=conn.prepareStatement(sql);
            rs=pst.executeQuery();
           jTable3.setModel(DbUtils.resultSetToTableModel(rs)); 
           
           tableload();
            
        }
        
    catch(Exception e){
        JOptionPane.showMessageDialog(null, e);
    }
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
       DefaultTableModel model = (DefaultTableModel) jTable3.getModel();
           if(jTable3.getSelectedRow()==-1){
            if(jTable3.getRowCount()==0){
                jTextField8.setText("table is empty");
            }else{
                jTextField8.setText("select a period");
            }
        }else{
               model.removeRow(jTable3.getSelectedRow());
           }
         
    }//GEN-LAST:event_jButton21ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException {
        /*  timetableDB connect = new timetableDB();
        connect.getData();*/
        new TMS_Timetablemangemnet().setVisible(true);

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
            java.util.logging.Logger.getLogger(TMS_Timetablemangemnet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new TMS_Timetablemangemnet().setVisible(true);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(TMS_Timetablemangemnet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(TMS_Timetablemangemnet.class.getName()).log(Level.SEVERE, null, ex);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CREATETIMTABLE;
    private javax.swing.JLabel Client;
    private javax.swing.JButton ClientLogo;
    private javax.swing.JButton DASHBOARD1;
    private javax.swing.JPanel MAINPANELT;
    private javax.swing.JPanel SEARCHSTAFF;
    private javax.swing.JPanel SEARCHSTAFFTT;
    private javax.swing.JPanel SIDEMENUE;
    private javax.swing.JButton STAFFID;
    private javax.swing.JButton STAFFTTT;
    private javax.swing.JLabel System;
    private javax.swing.JPanel UPMENUE;
    private javax.swing.JPanel addc;
    private javax.swing.JButton addclass;
    private javax.swing.JButton addclass1;
    private javax.swing.JButton addclass2;
    private javax.swing.JButton backclass;
    private javax.swing.JButton backstaff;
    private javax.swing.JTable classtable;
    private javax.swing.JPanel classwise;
    private javax.swing.JPanel classwisetimetablee;
    private javax.swing.JButton cleasclass;
    private javax.swing.JButton cleasclass1;
    private javax.swing.JPanel dashboard;
    private javax.swing.JButton deleateclass;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox10;
    private javax.swing.JComboBox<String> jComboBox11;
    private javax.swing.JComboBox<String> jComboBox12;
    private javax.swing.JComboBox<String> jComboBox13;
    private javax.swing.JComboBox<String> jComboBox14;
    private javax.swing.JComboBox<String> jComboBox15;
    private javax.swing.JComboBox<String> jComboBox16;
    private javax.swing.JComboBox<String> jComboBox17;
    private javax.swing.JComboBox<String> jComboBox18;
    private javax.swing.JComboBox<String> jComboBox19;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox20;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JComboBox<String> jComboBox4;
    private javax.swing.JComboBox<String> jComboBox5;
    private javax.swing.JComboBox<String> jComboBox6;
    private javax.swing.JComboBox<String> jComboBox7;
    private javax.swing.JComboBox<String> jComboBox8;
    private javax.swing.JComboBox<String> jComboBox9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
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
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JButton mngprofile1;
    private javax.swing.JButton mngprofile3;
    private javax.swing.JPanel searchclasstt2;
    private javax.swing.JButton searchstafftt;
    private javax.swing.JPanel searchstafftt1;
    private javax.swing.JButton staffadd;
    private javax.swing.JButton staffclear;
    private javax.swing.JButton staffdeleate;
    private javax.swing.JButton stafftimetable;
    private javax.swing.JPanel stafftimetable2;
    private javax.swing.JButton staffupdate;
    private javax.swing.JPanel updatec;
    private javax.swing.JButton updateclass;
    // End of variables declaration//GEN-END:variables
}
