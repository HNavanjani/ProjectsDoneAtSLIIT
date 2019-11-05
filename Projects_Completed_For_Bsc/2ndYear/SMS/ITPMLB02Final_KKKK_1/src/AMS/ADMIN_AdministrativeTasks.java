
package AMS;
import DBConnection.DBConnect;
import SPMS.dbConnection;

import SPMS.SPMS_StudentProfileManageStudent;
import SPMS.dbConnection;
import EMS.EMS_EmployeeManagementSystem;
import SchoolInformationManagementSystem.SIMS_DashBoard;
import SchoolInformationManagementSystem.SIMS_HomeScreen;
import TMS.TMS_Timetablemangemnet;
import java.awt.CardLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;


public class ADMIN_AdministrativeTasks extends javax.swing.JFrame {
    Connection conn =null;
    PreparedStatement pst = null;
    ResultSet rs=null;
    String studentGender=null;
    String feedback=null;
    String selectedNoticeID ,selectedNotice;
    
    /*public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public String url="jdbc:sqlserver://localhost:24809;databaseName=itpoNew";
    public String user="adminK";
    public String pw="admink";*/
    /**
     * Creates new form ManageStudentDetails
     */
    public ADMIN_AdministrativeTasks() throws ClassNotFoundException, SQLException {
        
        initComponents();
        
        /*Class.forName(driver);
            conn=DriverManager.getConnection(url, user, pw);*/
        //conn = dbConnection.connectToDb();
        
        conn = DBConnect.connect();
        
        groupButton();
        
        txt_addid.setEditable(false);
        txt_addfname.setEditable(false);
        txt_addlname.setEditable(false);
        txt_addemail.setEditable(false);
        txt_addphone.setEditable(false);
        txtNotice.setEditable(false);
        txt_NoticeID.setEditable(false);
     
    }
    
    
    public void ViewUserList(){
        String user_type = null;
        user_type = combousertype.getItemAt(combousertype.getSelectedIndex());
    
        if(user_type.equals("Student")){
        try{        
        String sql = "SELECT RegNo,firstName,lastName,email,phoneNo FROM spms_studentinfo";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        tblViewUserList.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        }
        else if(user_type.equals("Staff")){
        try{        
        String sql = "SELECT employeeID,firstName,lastName,email,contact FROM ems_employeedetails";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        tblViewUserList.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        }
        else if(user_type.equals("Admin")||user_type.equals("Librarian")||user_type.equals("Matron")||user_type.equals("Cafeteria Manager"))
        {
        try{        
        String sql = "SELECT userID,firstName,lastName,email,phone,AccessType FROM [user]";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        tblViewUserList.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        }
        else if(user_type.equals("<<Select User Type >>")){
            JOptionPane.showMessageDialog(null, "Choose an Access Type !");
        }
    }
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        forms = new javax.swing.JPanel();
        dashBoard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btn_adduser = new javax.swing.JButton();
        btn_viwuserlist = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        txt_addid = new javax.swing.JTextField();
        req4 = new javax.swing.JLabel();
        req3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_addemail = new javax.swing.JTextField();
        lbl_addid = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_addlname = new javax.swing.JTextField();
        txt_addphone = new javax.swing.JTextField();
        req2 = new javax.swing.JLabel();
        req1 = new javax.swing.JLabel();
        req5 = new javax.swing.JLabel();
        txt_addfname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        combousertype = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        remove = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        add = new javax.swing.JRadioButton();
        radioclear = new javax.swing.JRadioButton();
        update = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblViewUserList = new javax.swing.JTable();
        notices = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        btn_adduser1 = new javax.swing.JButton();
        btn_viwuserlist1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        txt_NoticeID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lbl_addid1 = new javax.swing.JLabel();
        req8 = new javax.swing.JLabel();
        req10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNotice = new javax.swing.JTextArea();
        jPanel12 = new javax.swing.JPanel();
        remove1 = new javax.swing.JRadioButton();
        jLabel13 = new javax.swing.JLabel();
        add1 = new javax.swing.JRadioButton();
        radioclear1 = new javax.swing.JRadioButton();
        update1 = new javax.swing.JRadioButton();
        jPanel13 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblViewNotices = new javax.swing.JTable();
        Topic = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        sidemenu = new javax.swing.JPanel();
        home = new javax.swing.JButton();
        jButton34 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        btnTimeTableManagement = new javax.swing.JButton();
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
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User Mnagement", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 17), new java.awt.Color(51, 0, 255))); // NOI18N

        jPanel4.setBackground(new java.awt.Color(53, 120, 229));

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/clearn.png"))); // NOI18N
        jButton3.setText("Clear");
        jButton3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(204, 204, 204));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/updateuser.png"))); // NOI18N
        jButton6.setText("Update user");
        jButton6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/deleteuser.png"))); // NOI18N
        jButton4.setText("Remove user");
        jButton4.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btn_adduser.setBackground(new java.awt.Color(204, 204, 204));
        btn_adduser.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_adduser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/adduser.png"))); // NOI18N
        btn_adduser.setText("Add user");
        btn_adduser.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_adduser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adduserActionPerformed(evt);
            }
        });

        btn_viwuserlist.setBackground(new java.awt.Color(204, 204, 204));
        btn_viwuserlist.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_viwuserlist.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/preview.png"))); // NOI18N
        btn_viwuserlist.setText("View User List");
        btn_viwuserlist.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_viwuserlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viwuserlistActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_viwuserlist, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(btn_adduser, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_adduser)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton6)
                    .addComponent(btn_viwuserlist))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(53, 120, 229));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Basic User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txt_addid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_addid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addidActionPerformed(evt);
            }
        });

        req4.setForeground(new java.awt.Color(255, 0, 0));
        req4.setText("*");

        req3.setForeground(new java.awt.Color(255, 0, 0));
        req3.setText("*");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("email address :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Phone No :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("First Name :");

        txt_addemail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_addemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addemailActionPerformed(evt);
            }
        });

        lbl_addid.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_addid.setText("ID :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Last Name :");

        txt_addlname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_addlname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addlnameActionPerformed(evt);
            }
        });

        txt_addphone.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_addphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addphoneActionPerformed(evt);
            }
        });

        req2.setForeground(new java.awt.Color(255, 0, 0));
        req2.setText("*");

        req1.setForeground(new java.awt.Color(255, 0, 0));
        req1.setText("*");

        req5.setForeground(new java.awt.Color(255, 0, 0));
        req5.setText("*");

        txt_addfname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_addfname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_addfnameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(lbl_addid))
                .addGap(61, 61, 61)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txt_addphone, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_addemail, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_addlname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_addfname, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(req5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req1, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req3, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txt_addid, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_addlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_addemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(req1)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_addphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(req4)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_addid)
                            .addComponent(txt_addid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req5))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_addfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Choose Access Level");

        combousertype.setBackground(new java.awt.Color(255, 255, 153));
        combousertype.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        combousertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select User Type >>", "Admin", "Staff", "Student", "Matron", "Librarian", "Cafeteria Manager" }));

        jPanel7.setBackground(new java.awt.Color(53, 120, 229));

        remove.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        remove.setText("Remove User");
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Select Action :");

        add.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add.setText("Add User");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update.setText("Update User");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(remove)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(update)
                        .addGap(83, 83, 83)
                        .addComponent(radioclear))
                    .addComponent(add))
                .addGap(27, 27, 27))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(add))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioclear)
                    .addComponent(update))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(53, 120, 229));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "User List", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblViewUserList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblViewUserList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewUserListMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblViewUserList);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(combousertype, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(32, 32, 32))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(combousertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(77, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(179, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dashBoardLayout = new javax.swing.GroupLayout(dashBoard);
        dashBoard.setLayout(dashBoardLayout);
        dashBoardLayout.setHorizontalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dashBoardLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dashBoardLayout.setVerticalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        forms.add(dashBoard, "dashBoard");

        jPanel8.setBackground(new java.awt.Color(53, 120, 229));

        jPanel9.setBackground(new java.awt.Color(53, 120, 229));
        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Manage School News and Alerts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 17))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(53, 120, 229));

        jButton8.setBackground(new java.awt.Color(204, 204, 204));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/clearn.png"))); // NOI18N
        jButton8.setText("Clear");
        jButton8.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setBackground(new java.awt.Color(204, 204, 204));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/updateuser.png"))); // NOI18N
        jButton9.setText("Update ");
        jButton9.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton11.setBackground(new java.awt.Color(204, 204, 204));
        jButton11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/deleteuser.png"))); // NOI18N
        jButton11.setText("Remove ");
        jButton11.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        btn_adduser1.setBackground(new java.awt.Color(204, 204, 204));
        btn_adduser1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_adduser1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/adduser.png"))); // NOI18N
        btn_adduser1.setText("Add ");
        btn_adduser1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_adduser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_adduser1ActionPerformed(evt);
            }
        });

        btn_viwuserlist1.setBackground(new java.awt.Color(204, 204, 204));
        btn_viwuserlist1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_viwuserlist1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/preview.png"))); // NOI18N
        btn_viwuserlist1.setText("View ");
        btn_viwuserlist1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btn_viwuserlist1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viwuserlist1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_viwuserlist1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_adduser1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_adduser1)
                    .addComponent(jButton11)
                    .addComponent(jButton8)
                    .addComponent(jButton9)
                    .addComponent(btn_viwuserlist1))
                .addContainerGap())
        );

        jPanel11.setBackground(new java.awt.Color(53, 120, 229));
        jPanel11.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Basic User Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        txt_NoticeID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txt_NoticeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NoticeIDActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Notice : ");

        lbl_addid1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbl_addid1.setText("Notice ID :");

        req8.setForeground(new java.awt.Color(255, 0, 0));
        req8.setText("*");

        req10.setForeground(new java.awt.Color(255, 0, 0));
        req10.setText("*");

        txtNotice.setColumns(20);
        txtNotice.setRows(5);
        jScrollPane3.setViewportView(txtNotice);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(lbl_addid1))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(txt_NoticeID, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(req10, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(req8, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_addid1)
                    .addComponent(txt_NoticeID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(req10))
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(req8))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3)
                        .addContainerGap())))
        );

        jPanel12.setBackground(new java.awt.Color(53, 120, 229));

        remove1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        remove1.setText("Remove");
        remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                remove1ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Select Action :");

        add1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add1.setText("Add ");
        add1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add1ActionPerformed(evt);
            }
        });

        update1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update1.setText("Update ");
        update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(add1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(remove1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(update1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioclear1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(add1)
                        .addComponent(remove1)
                        .addComponent(update1))
                    .addComponent(radioclear1))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(53, 120, 229));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notices", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        tblViewNotices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblViewNotices.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblViewNoticesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblViewNotices);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 907, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(99, 99, 99))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(113, 113, 113))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(113, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout noticesLayout = new javax.swing.GroupLayout(notices);
        notices.setLayout(noticesLayout);
        noticesLayout.setHorizontalGroup(
            noticesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noticesLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        noticesLayout.setVerticalGroup(
            noticesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noticesLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        forms.add(notices, "notices");

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
            .addComponent(forms, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        jPanel5.setBackground(new java.awt.Color(41, 48, 66));

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
        btnLibraryManagement.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/shedule.png"))); // NOI18N
        btnLibraryManagement.setText("School News Alerts");
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
        btnLibraryManagement1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/empm.png"))); // NOI18N
        btnLibraryManagement1.setText("User Management");
        btnLibraryManagement1.setBorderPainted(false);
        btnLibraryManagement1.setContentAreaFilled(false);
        btnLibraryManagement1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLibraryManagement1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLibraryManagement1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnStudentInfoManagement, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEventManagement)
                            .addComponent(btnLibraryManagement)
                            .addComponent(btnEmployeeManagement)
                            .addComponent(btnTimeTableManagement)
                            .addComponent(btnLibraryManagement1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnLibraryManagement1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLibraryManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEmployeeManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimeTableManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEventManagement)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnStudentInfoManagement)
                .addGap(189, 189, 189))
        );

        javax.swing.GroupLayout sidemenuLayout = new javax.swing.GroupLayout(sidemenu);
        sidemenu.setLayout(sidemenuLayout);
        sidemenuLayout.setHorizontalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addGroup(sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sidemenuLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Topic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Topic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(sidemenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed

        dispose();
        new SIMS_DashBoard().setVisible(true);
    }//GEN-LAST:event_homeActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void btnTimeTableManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimeTableManagementActionPerformed
        dispose();
        try {
            new TMS_Timetablemangemnet().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ADMIN_AdministrativeTasks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_AdministrativeTasks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnTimeTableManagementActionPerformed

    private void btnEventManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEventManagementActionPerformed
        
    }//GEN-LAST:event_btnEventManagementActionPerformed

    private void btnEmployeeManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmployeeManagementActionPerformed
         dispose();
        try {
            new EMS_EmployeeManagementSystem().setVisible(true);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ADMIN_AdministrativeTasks.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ADMIN_AdministrativeTasks.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEmployeeManagementActionPerformed

    private void btnLibraryManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagementActionPerformed
    CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "notices");
    }//GEN-LAST:event_btnLibraryManagementActionPerformed

    private void btnStudentInfoManagementActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStudentInfoManagementActionPerformed
       
    }//GEN-LAST:event_btnStudentInfoManagementActionPerformed

    private void btnLibraryManagement1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLibraryManagement1ActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "dashBoard");
        
    }//GEN-LAST:event_btnLibraryManagement1ActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        txt_addid.setEditable(true);
        txt_addfname.setEditable(true);
        txt_addlname.setEditable(true);
        txt_addemail.setEditable(true);
        txt_addphone.setEditable(true);
    }//GEN-LAST:event_updateActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
        txt_addid.setEditable(true);
        txt_addfname.setEditable(true);
        txt_addlname.setEditable(true);
        txt_addemail.setEditable(true);
        txt_addphone.setEditable(true);
    }//GEN-LAST:event_addActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
        txt_addid.setEditable(true);
        txt_addfname.setEditable(true);
        txt_addlname.setEditable(true);
        txt_addemail.setEditable(true);
        txt_addphone.setEditable(true);
    }//GEN-LAST:event_removeActionPerformed

    private void txt_addfnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addfnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addfnameActionPerformed

    private void txt_addphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addphoneActionPerformed

    private void txt_addlnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addlnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addlnameActionPerformed

    private void txt_addemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addemailActionPerformed

    private void txt_addidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_addidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_addidActionPerformed

    private void btn_viwuserlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viwuserlistActionPerformed
        ViewUserList();
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_viwuserlistActionPerformed

    private void btn_adduserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adduserActionPerformed

        int confirminsert = JOptionPane.showConfirmDialog(null, "Do you really want to add this user to the system?","Insert",JOptionPane.YES_NO_OPTION);
        String user_type = null;
        user_type = combousertype.getItemAt(combousertype.getSelectedIndex());

        if(confirminsert==0)
        {

            if(user_type.equals("Student"))
            {
                try
                {
                    String sql = "INSERT INTO spms_studentinfo"
                    + "(firstName,lastName,email,phoneNo)"
                    + "VALUES (?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    
                    pst.setString(1,txt_addfname.getText());
                    pst.setString(2,txt_addlname.getText());
                    pst.setString(3,txt_addemail.getText());
                    pst.setString(4,txt_addphone.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Inserted Successfully !");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            else if(user_type.equals("Staff"))
            {
                try
                {
                    String sql = "INSERT INTO ems_employeedetails"
                    + "(firstName,lastName,email,contact)"
                    + "VALUES (?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,txt_addfname.getText());
                    pst.setString(2,txt_addlname.getText());
                    pst.setString(3,txt_addemail.getText());
                    pst.setString(4,txt_addphone.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Inserted Successfully !");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

            else if(user_type.equals("Admin")||user_type.equals("Matron")||user_type.equals("Librarian")||user_type.equals("Cafeteria Manager"))
            {
                try
                {
                    String sql = "INSERT INTO [user]"
                    + "(userID,firstName,lastName,email,phone)"
                    + "VALUES (?,?,?,?,?)";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,txt_addid.getText());
                    pst.setString(2,txt_addfname.getText());
                    pst.setString(3,txt_addlname.getText());
                    pst.setString(4,txt_addemail.getText());
                    pst.setString(5,txt_addphone.getText());
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Inserted Successfully !");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }

    }//GEN-LAST:event_btn_adduserActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int confirmdelete = JOptionPane.showConfirmDialog(null, "Do you really want to delete this record ?","Delete",JOptionPane.YES_NO_OPTION);
        String user_type = null;
        user_type = combousertype.getItemAt(combousertype.getSelectedIndex());
        if(confirmdelete==0){
            if(user_type.equals("Student"))
            {
                try{
                    String sql = "DELETE FROM spms_studentinfo WHERE RegNo=?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,txt_addid.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            if(user_type.equals("Staff"))
            {
                try{
                    String sql = "DELETE FROM ems_employeedetails WHERE employeeID=?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,txt_addid.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
            if(user_type.equals("Admin")||user_type.equals("Matron")||user_type.equals("Librarian")||user_type.equals("Cafeteria Manager"))
            {
                try{
                    String sql = "DELETE FROM [user] WHERE userID=?";
                    pst = conn.prepareStatement(sql);
                    pst.setString(1,txt_addid.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        int confirminsert = JOptionPane.showConfirmDialog(null, "Do you really want to add this user to the system?","Insert",JOptionPane.YES_NO_OPTION);
        String user_type = null;
        user_type = combousertype.getItemAt(combousertype.getSelectedIndex());

        if(confirminsert==0)
        {

            if(user_type.equals("Student"))
            {
                try
                {
                    String sql = "UPDATE spms_studentinfo SET firstName=?,lastName=?,email=?,phoneNo=? where RegNo=?";

                    pst = conn.prepareStatement(sql);

                    pst.setString(5,txt_addid.getText());

                    pst.setString(1,txt_addfname.getText());
                    pst.setString(2,txt_addlname.getText());
                    pst.setString(3,txt_addemail.getText());
                    pst.setString(4,txt_addphone.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
                }

                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
            if(user_type.equals("Staff"))
            {
                try
                {
                    String sql = "UPDATE ems_employeedetails SET firstName=?,lastName=?,email=?,contact=? where employeeID=?";

                    pst = conn.prepareStatement(sql);

                    pst.setString(5,txt_addid.getText());

                    pst.setString(1,txt_addfname.getText());
                    pst.setString(2,txt_addlname.getText());
                    pst.setString(3,txt_addemail.getText());
                    pst.setString(4,txt_addphone.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
                }

                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
            if(user_type.equals("Admin")||user_type.equals("Matron")||user_type.equals("Librarian")||user_type.equals("Cafeteria Manager"))
            {
                try
                {
                    String sql = "UPDATE [user] SET firstName=?,lastName=?,email=?,phone=? where userID=?";

                    pst = conn.prepareStatement(sql);

                    pst.setString(5,txt_addid.getText());

                    pst.setString(1,txt_addfname.getText());
                    pst.setString(2,txt_addlname.getText());
                    pst.setString(3,txt_addemail.getText());
                    pst.setString(4,txt_addphone.getText());

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
                }

                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }

            }
        }

    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        txt_addfname.setText(" ");
        txt_addlname.setText(" ");
        txt_addemail.setText(" ");
        txt_addphone.setText(" ");
        txt_addid.setText(" ");
        combousertype.setSelectedIndex(0);
        radioclear.setSelected(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        txt_NoticeID.setText(null);
        txtNotice.setText(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try
                {
                    String sql = "UPDATE spms_notices SET notice=? where noticeID=?";

                    pst = conn.prepareStatement(sql);

                    int selectedID=Integer.parseInt(selectedNoticeID);
                    pst.setInt(2,selectedID);

                    pst.setString(1,txtNotice.getText());
                    

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
                }

                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
                 try{
                    String sql = "DELETE FROM spms_notices WHERE noticeID=?";
                    pst = conn.prepareStatement(sql);
                    int selectedID=Integer.parseInt(selectedNoticeID);
                    pst.setInt(1,selectedID);

                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(null, ex);
                }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void btn_adduser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_adduser1ActionPerformed
            try
                {
                    String sql = "INSERT INTO spms_notices"
                    + "(notice)"
                    + "VALUES (?)";
                    pst = conn.prepareStatement(sql);
                    
                    pst.setString(1,txtNotice.getText());
                    
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Record Inserted Successfully !");
                }
                catch(Exception ex)
                {
                    JOptionPane.showMessageDialog(null, ex);
                }
    }//GEN-LAST:event_btn_adduser1ActionPerformed

    private void btn_viwuserlist1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viwuserlist1ActionPerformed
       try{        
        String sql = "SELECT * FROM spms_notices";
        pst = conn.prepareStatement(sql);
        rs = pst.executeQuery();
        tblViewNotices.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e ){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_btn_viwuserlist1ActionPerformed

    private void txt_NoticeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NoticeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NoticeIDActionPerformed

    private void update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update1ActionPerformed
         txt_NoticeID.setEditable(true);
        txtNotice.setEditable(true);
    }//GEN-LAST:event_update1ActionPerformed

    private void add1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add1ActionPerformed
        txt_NoticeID.setEditable(false);
        txtNotice.setEditable(true);
        
    }//GEN-LAST:event_add1ActionPerformed

    private void remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_remove1ActionPerformed
         txt_NoticeID.setEditable(true);
        txtNotice.setEditable(true);
    }//GEN-LAST:event_remove1ActionPerformed

    private void tblViewNoticesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewNoticesMouseClicked
        try {
            int row = tblViewNotices.getSelectedRow();
            String tblClick = (tblViewNotices.getModel().getValueAt(row, 0).toString());

          

            String sql = "SELECT * FROM spms_notices WHERE noticeID='"+tblClick+"'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                selectedNoticeID = rs.getString("noticeID");
                selectedNotice = rs.getString("notice");
            }

            txt_NoticeID.setText(selectedNoticeID);
            txtNotice.setText(selectedNotice);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblViewNoticesMouseClicked

    private void tblViewUserListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblViewUserListMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblViewUserListMouseClicked
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
                    Logger.getLogger(ADMIN_AdministrativeTasks.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ADMIN_AdministrativeTasks.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    
    private ImageIcon format2 = null;
    String filename =null;
    int s = 0;
    byte[] profile_pic=null;
    private String Sgender;
    
    private void groupButton( ) {

        ButtonGroup bg1 = new ButtonGroup( );

        bg1.add(add);
        bg1.add(remove);
        bg1.add(update);
        bg1.add(radioclear);
        radioclear.setVisible(false);
        
        bg1.add(add1);
        bg1.add(remove1);
        bg1.add(update1);
        bg1.add(radioclear1);
        radioclear1.setVisible(false);
        

        }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Topic;
    private javax.swing.JRadioButton add;
    private javax.swing.JRadioButton add1;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnEmployeeManagement;
    private javax.swing.JButton btnEventManagement;
    private javax.swing.JButton btnLibraryManagement;
    private javax.swing.JButton btnLibraryManagement1;
    private javax.swing.JButton btnStudentInfoManagement;
    private javax.swing.JButton btnTimeTableManagement;
    private javax.swing.JButton btn_adduser;
    private javax.swing.JButton btn_adduser1;
    private javax.swing.JButton btn_viwuserlist;
    private javax.swing.JButton btn_viwuserlist1;
    private javax.swing.JComboBox<String> combousertype;
    private javax.swing.JPanel dashBoard;
    private javax.swing.JPanel forms;
    private javax.swing.JButton home;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl_addid;
    private javax.swing.JLabel lbl_addid1;
    private javax.swing.JPanel notices;
    private javax.swing.JRadioButton radioclear;
    private javax.swing.JRadioButton radioclear1;
    private javax.swing.JRadioButton remove;
    private javax.swing.JRadioButton remove1;
    private javax.swing.JLabel req1;
    private javax.swing.JLabel req10;
    private javax.swing.JLabel req2;
    private javax.swing.JLabel req3;
    private javax.swing.JLabel req4;
    private javax.swing.JLabel req5;
    private javax.swing.JLabel req8;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JTable tblViewNotices;
    private javax.swing.JTable tblViewUserList;
    private javax.swing.JTextArea txtNotice;
    private javax.swing.JTextField txt_NoticeID;
    private javax.swing.JTextField txt_addemail;
    private javax.swing.JTextField txt_addfname;
    private javax.swing.JTextField txt_addid;
    private javax.swing.JTextField txt_addlname;
    private javax.swing.JTextField txt_addphone;
    private javax.swing.JRadioButton update;
    private javax.swing.JRadioButton update1;
    // End of variables declaration//GEN-END:variables
    
}
