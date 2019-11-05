package SPMS;


import DBConnection.DBConnect;
import SPMS_IREPORTS.IREPORT_PARAMETERIZED;
import SchoolInformationManagementSystem.SIMS_HomeScreen;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import SPMS.dbConnection;


public class SPMS_StudentProfileManageStudent extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
//    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    public String url="jdbc:sqlserver://localhost:24809;databaseName=smsDB";
//    public String user="adminK";
//    public String pw="admink";

    String studentGender = null;
    String feedback = null;
    String total = null;
    String average = null;
    String count = null;
    String rank = null;
    float AVG;
    String overallGrade = null;
    float TOTAL;
    public String documentType = null;
    public String currentDate = null;
    public String requestedDoc = null;
    public boolean docAvailability = false;
    String stotal = null;
    String saverage = null;
    String soverallGrade = null;
    String stotalT2 = null;
    String saverageT2 = null;
    String soverallGradeT2 = null;
    public String subj1, subj2, subj3, subj4, subj5, subj6, subj7, subj8, subj9, mark1, mark2, mark3, mark4, mark5, mark6, mark7, mark8, mark9 = null;
    public String sg1, sg2, sg3, sg4, sg5, sg6, sg7, sg8, sg9 = null;
    public String acs, acName, acMarks, subj1T2, subj2T2, subj3T2, subj4T2, subj5T2, subj6T2, subj7T2, subj8T2, subj9T2, mark1T2, mark2T2, mark3T2, mark4T2, mark5T2, mark6T2, mark7T2, mark8T2, mark9T2 = null;
    private ImageIcon format2 = null;
    String filename = null;
    int s = 0;
    byte[] profile_pic = null;
    byte[] Stuphotograph = null;
    private String Sgender;
    public List<Calendar> events = new ArrayList<Calendar>();

    SPMS_DBAccess_Stu obj1 = new SPMS_DBAccess_Stu();

    public SPMS_StudentProfileManageStudent() throws ClassNotFoundException, SQLException  {

        initComponents();
         
//         Class.forName(driver);
//         conn=DriverManager.getConnection(url, user, pw);
        //conn = dbConnection.connectToDb();
         conn = DBConnect.connect();
        groupButton();
        FillComboClass();
        FillComboSubject();
        ViewNotices();
        ViewExtraActivityTable();

       tblnotices.getTableHeader().setUI(null);
       tblnotices.setRowHeight(30);
      
        
        
        txtcurrentpw.setEditable(false);
        lblnewpw.setVisible(false);
        txtnewpw.setVisible(false);
        btndone.setVisible(false);
        btnDownloadDoc.setVisible(false);
        lbldocError.setVisible(false);
        lblSPMSLogedin.setText(String.valueOf(StudentInformation.stid).toString());
        txtSPMSSID.setText(String.valueOf(StudentInformation.stid).toString());
        lblSPMSProfilePic.setIcon(new ImageIcon(StudentInformation.sprofilepic.getImage().getScaledInstance(lblSPMSProfilePic.getWidth(), lblSPMSProfilePic.getHeight(), Image.SCALE_DEFAULT)));
        txtSPMSFname.setText(String.valueOf(StudentInformation.sfname).toString());
        txtSPMSLname.setText(String.valueOf(StudentInformation.slname).toString());
        txtSPMSGender.setText(String.valueOf(StudentInformation.sgender).toString());
        txtSPMSEmail.setText(String.valueOf(StudentInformation.semail).toString());
        txtSPMSCurrentClass.setText(String.valueOf(StudentInformation.scurrentClass).toString());

    }

    
    public void groupButton() {
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(female);
        bg1.add(male);
        bg1.add(radioclear);
        radioclear.setVisible(false);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(e);
        bg2.add(g);
        bg2.add(a);
        bg2.add(p);
        bg2.add(radioclear2);
        radioclear2.setVisible(false);

        ButtonGroup bg4 = new ButtonGroup();
        bg4.add(resultssheet);
        bg4.add(leavingc);
        bg4.add(characterc);
        bg4.add(radioclear3);
        radioclear3.setVisible(false);
    }

    public boolean validnicParent() {

        String nic = "^[0-9]{9}V$";

        Pattern patternnic = Pattern.compile(nic, Pattern.CASE_INSENSITIVE);

        Matcher regeMatchernic = patternnic.matcher(txtPnic.getText());
        if (!regeMatchernic.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid NIC !");
            return false;
        } else {
            return true;
        }
    }

    public boolean validemailStudentInfoManage() {
        String emailPattern = "^[A-Z0-9]+@[A-Z0-9]+\\.[A-Z]{2,3}$";

        Pattern patternemail = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);

        Matcher regeMatcheremail = patternemail.matcher(txtSemail.getText());
        if (!regeMatcheremail.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid email address for Student!");
            return false;
        } else {
            return true;
        }
    }

    public boolean validemailInquiry() {
        String emailPattern = "^[A-Z0-9]+@[A-Z0-9]+\\.[A-Z]{2,3}$";

        Pattern patternemail = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);

        Matcher regeMatcheremail = patternemail.matcher(txtIstuemail.getText());
        if (!regeMatcheremail.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid email address!");
            return false;
        } else {
            return true;
        }
    }

    public boolean validphoneStudentInfoManage() {
        String phonecount = "^[0-9]{10}$";

        Pattern patternphone = Pattern.compile(phonecount, Pattern.CASE_INSENSITIVE);

        Matcher regeMatcherphone = patternphone.matcher(txtSphone.getText());
        if (!regeMatcherphone.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid phone number for Student!");
            return false;
        } else {
            return true;
        }
    }

    public boolean validemailParent() {
        String emailPattern = "^[A-Z0-9]+@[A-Z0-9]+\\.[A-Z]{2,3}$";

        Pattern patternemail = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);

        Matcher regeMatcheremail = patternemail.matcher(txtPemail.getText());
        if (!regeMatcheremail.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid email address for Parent!");
            return false;
        } else {
            return true;
        }
    }

    public boolean validphoneParent() {
        String phonecount = "^[0-9]{10}$";

        Pattern patternphone = Pattern.compile(phonecount, Pattern.CASE_INSENSITIVE);

        Matcher regeMatcherphone = patternphone.matcher(txtPphone.getText());
        if (!regeMatcherphone.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid phone number for Parent!");
            return false;
        } else {
            return true;
        }
    }

    public boolean validphoneInquiry() {
        String phonecount = "^[0-9]{10}$";

        Pattern patternphone = Pattern.compile(phonecount, Pattern.CASE_INSENSITIVE);

        Matcher regeMatcherphone = patternphone.matcher(txtIstuphone.getText());
        if (!regeMatcherphone.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid phone number !");
            return false;
        } else {
            return true;
        }
    }

    public boolean validphonePhy() {
        String phonecount = "^[0-9]{10}$";

        Pattern patternphone = Pattern.compile(phonecount, Pattern.CASE_INSENSITIVE);

        Matcher regeMatcherphone = patternphone.matcher(txtSPhyPhone.getText());
        if (!regeMatcherphone.matches()) {
            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid phone number for Physician!");
            return false;
        } else {
            return true;
        }
    }
    
    
    

   

    
    

    public void viewStudentInfo() {

        try {
            txtSfname.setText(String.valueOf(StudentInformation.sfname).toString());

            lblSPMSPersonalPic.setIcon(new ImageIcon(StudentInformation.sprofilepic.getImage().getScaledInstance(lblSPMSProfilePic.getWidth(), lblSPMSProfilePic.getHeight(), Image.SCALE_DEFAULT)));

            txtSmname.setText(String.valueOf(StudentInformation.smname).toString());
            txtSlname.setText(String.valueOf(StudentInformation.slname).toString());

            if (String.valueOf(StudentInformation.sgender).toString().equals("Female")) {
                female.setSelected(true);
            } else if (String.valueOf(StudentInformation.sgender).toString().equals("Male")) {
                male.setSelected(true);
            }

            Sdob.setDate((StudentInformation.sdob));
            txt_Snationality.setText(String.valueOf(StudentInformation.snationality).toString());
            txtSreligion.setText(String.valueOf(StudentInformation.sreligion).toString());
            txtcurrentpw.setText(String.valueOf(StudentInformation.stdpwd).toString());

            txtSemail.setText(String.valueOf(StudentInformation.semail).toString());
            txtSphone.setText(String.valueOf(StudentInformation.sphone).toString());
            txtSstreetNo.setText(String.valueOf(StudentInformation.streetNo).toString());
            txtSstreet.setText(String.valueOf(StudentInformation.street).toString());
            txtScity.setText(String.valueOf(StudentInformation.city).toString());
            txtScountry.setText(String.valueOf(StudentInformation.country).toString());

            txtPnic.setText(String.valueOf(StudentInformation.pnic).toString());
            txtPfname.setText(String.valueOf(StudentInformation.pfname).toString());
            txtPlname.setText(String.valueOf(StudentInformation.plname).toString());
            txtPemail.setText(String.valueOf(StudentInformation.pemail).toString());
            txtPphone.setText(String.valueOf(StudentInformation.pphone).toString());
            txtPoccupation.setText(String.valueOf(StudentInformation.poccupation).toString());

            Sbio.setText(String.valueOf(StudentInformation.sskills).toString());

            txtSPhyname.setText(String.valueOf(StudentInformation.phyname).toString());
            txtSPhyPhone.setText(String.valueOf(StudentInformation.phyphone).toString());
            txtSbloodgroup.setText(String.valueOf(StudentInformation.sbloodgroup).toString());
            txtSmedical.setText(String.valueOf(StudentInformation.medicalalert).toString());
            txtSrestr.setText(String.valueOf(StudentInformation.phyrestr).toString());
            txtSmediother.setText(String.valueOf(StudentInformation.mediother).toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ViewScheduleInfo() {
        obj1.ViewScheduleInfo();
        tblSheduleinfo.setModel(DbUtils.resultSetToTableModel(obj1.rs));

    }

    public void ViewTeacherInfo() {
        obj1.ViewTeacherInfo();
        tblTeacherInfo.setModel(DbUtils.resultSetToTableModel(obj1.rs));

    }

    public void ViewNotices() {
        obj1.ViewNotices();
        tblnotices.setModel(DbUtils.resultSetToTableModel(obj1.rs));
      
    }

    public void ViewTermlyReport() {
        try {

            int pstuRegNo = Integer.parseInt(lblSPMSLogedin.getText());
            String pclass = comboClass2.getSelectedItem().toString();
            String pyear = txtyr.getText();
            String pterm = comboterm.getSelectedItem().toString();

            obj1.ViewTermlyReport(pstuRegNo, pclass, pyear, pterm);

            txts1.setText(obj1.esub1);
            txts2.setText(obj1.esub2);
            txts3.setText(obj1.esub3);
            txts4.setText(obj1.esub4);
            txts5.setText(obj1.esub5);
            txts6.setText(obj1.esub6);
            txts7.setText(obj1.esub7);
            txts8.setText(obj1.esub8);
            txts9.setText(obj1.esub9);

            txtm1.setText(String.valueOf(obj1.emark1));
            txtm2.setText(String.valueOf(obj1.emark2));
            txtm3.setText(String.valueOf(obj1.emark3));
            txtm4.setText(String.valueOf(obj1.emark4));
            txtm5.setText(String.valueOf(obj1.emark5));
            txtm6.setText(String.valueOf(obj1.emark6));
            txtm7.setText(String.valueOf(obj1.emark7));
            txtm8.setText(String.valueOf(obj1.emark8));
            txtm9.setText(String.valueOf(obj1.emark9));

            g1.setText(obj1.egrade1);
            g2.setText(obj1.egrade2);
            g3.setText(obj1.egrade3);
            g4.setText(obj1.egrade4);
            g5.setText(obj1.egrade5);
            g6.setText(obj1.egrade6);
            g7.setText(obj1.egrade7);
            g8.setText(obj1.egrade8);
            g9.setText(obj1.egrade9);

            txttotalmarks.setText(String.valueOf(obj1.etotal));
            txtavg.setText(String.valueOf(obj1.eavg));
            txtOverallGrade.setText(obj1.eograde);

            txtshowStuNo1.setText(lblSPMSLogedin.getText());
            txtshowClass1.setText(comboClass2.getSelectedItem().toString());
            txtshowYear1.setText(txtyr.getText());
            txtshowTerm1.setText(comboterm.getSelectedItem().toString());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void FillComboClass() {
        try {
            obj1.getAllClasses();
            int len2 = obj1.AllClasses.size();
            for (int j = 0; j < len2; j++) {
                comboClassreport.addItem(obj1.AllClasses.get(j));
                comboClass2.addItem(obj1.AllClasses.get(j));
                comboClassreport1.addItem(obj1.AllClasses.get(j));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void FillComboSubject() {

        try {
            obj1.getAllSubjects();
            int len2 = obj1.AllSubjects.size();
            for (int j = 0; j < len2; j++) {
                comboSub1.addItem(obj1.AllSubjects.get(j));
                comboSub2.addItem(obj1.AllSubjects.get(j));
                comboSub3.addItem(obj1.AllSubjects.get(j));
                comboSub4.addItem(obj1.AllSubjects.get(j));
                comboSub5.addItem(obj1.AllSubjects.get(j));
                comboSub6.addItem(obj1.AllSubjects.get(j));
                comboSub7.addItem(obj1.AllSubjects.get(j));
                comboSub8.addItem(obj1.AllSubjects.get(j));
                comboSub9.addItem(obj1.AllSubjects.get(j));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void ViewExtraActivityTable() {
        try {
            int pstuRegNo = StudentInformation.stid;
            obj1.ViewExtraActivityTable(pstuRegNo);
            tblExtraActivity.setModel(DbUtils.resultSetToTableModel(obj1.rs));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void GenerateOfficialDocuments() {
        try {

            if (resultssheet.isSelected()) {
                documentType = "Results Sheet";
            }
            if (leavingc.isSelected()) {
                documentType = "Leaving Certificate";
            }
            if (characterc.isSelected()) {
                documentType = "Character Certificate";
            }

            LocalDate localDate = LocalDate.now();
            currentDate = (String.valueOf(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate)));

            String pdocumentType = documentType;
            String pdate = currentDate;
            int pstuRegNo = StudentInformation.stid;
            String pStudentFullName = txtOFullname.getText();
            byte[] pphotograph = Stuphotograph;
            String pskillsAndInterests = txtOSkills.getText();
            String pbio = txtOBio.getText();
            String pExtraActivities = txtOExtra.getText();
            String pclass = txtOClass.getText();
            String pteacherFirstName = txtOTeacherFname.getText();
            String pteacherLastName = txtOTeacherLname.getText();
            int pOLIndex = Integer.parseInt(txtOIndexOL.getText());
            String pOLYear = txtOyrOL.getText();
            String pOLSubject1 = comboSub1.getSelectedItem().toString();
            String pOLGrade1 = comboGrade1.getSelectedItem().toString();
            String pOLSubject2 = comboSub2.getSelectedItem().toString();
            String pOLGrade2 = comboGrade2.getSelectedItem().toString();
            String pOLSubject3 = comboSub3.getSelectedItem().toString();
            String pOLGrade3 = comboGrade3.getSelectedItem().toString();
            String pOLSubject4 = comboSub4.getSelectedItem().toString();
            String pOLGrade4 = comboGrade4.getSelectedItem().toString();
            String pOLSubject5 = comboSub5.getSelectedItem().toString();
            String pOLGrade5 = comboGrade5.getSelectedItem().toString();
            String pOLSubject6 = comboSub6.getSelectedItem().toString();
            String pOLGrade6 = comboGrade6.getSelectedItem().toString();
            String pOLSubject7 = comboSub7.getSelectedItem().toString();
            String pOLGrade7 = comboGrade7.getSelectedItem().toString();
            String pOLSubject8 = comboSub8.getSelectedItem().toString();
            String pOLGrade8 = comboGrade8.getSelectedItem().toString();
            String pOLSubject9 = comboSub9.getSelectedItem().toString();
            String pOLGrade9 = comboGrade9.getSelectedItem().toString();

            obj1.GenerateOfficialDocuments(pdocumentType, pdate, pstuRegNo, pStudentFullName, pphotograph, pskillsAndInterests, pbio, pExtraActivities, pclass, pteacherFirstName, pteacherLastName, pOLIndex, pOLYear, pOLSubject1, pOLGrade1, pOLSubject2, pOLGrade2, pOLSubject3, pOLGrade3, pOLSubject4, pOLGrade4, pOLSubject5, pOLGrade5, pOLSubject6, pOLGrade6, pOLSubject7, pOLGrade7, pOLSubject8, pOLGrade8, pOLSubject9, pOLGrade9);
            JOptionPane.showMessageDialog(null, "Your Request has been Sent Successfully!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public boolean CheckDocumentAvailability() {
        try {
            int pstuRegNo = StudentInformation.stid;
            String pdocumentType = txtODocTypeDownload.getText();
            String pdocStatus = "Is Ready";

            obj1.CheckDocumentAvailability(pstuRegNo, pdocumentType, pdocStatus);

            requestedDoc = obj1.requestedDocumentType;

            try {
                if (requestedDoc.equals(txtODocTypeDownload.getText())) {
                    JOptionPane.showMessageDialog(null, "Your Document is Available");
                    btnDownloadDoc.setVisible(true);
                    lbldocError.setVisible(false);
                    docAvailability = true;
                }
            } catch (Exception e) {

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return docAvailability;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        forms = new javax.swing.JPanel();
        dashBoard = new javax.swing.JPanel();
        panelSPMSQuickView = new javax.swing.JPanel();
        lblSPMSEmail = new javax.swing.JLabel();
        lblSPMSGender = new javax.swing.JLabel();
        txtSPMSFname = new javax.swing.JTextField();
        lblSPMSLname = new javax.swing.JLabel();
        lblSPMSWelcome = new javax.swing.JLabel();
        txtSPMSGender = new javax.swing.JTextField();
        lblSPMSLogedin = new javax.swing.JLabel();
        txtSPMSSID = new javax.swing.JTextField();
        lblSPMSFname = new javax.swing.JLabel();
        txtSPMSEmail = new javax.swing.JTextField();
        txtSPMSLname = new javax.swing.JTextField();
        lblSPMSSID = new javax.swing.JLabel();
        DesktopPaneSPMSProfilePic = new javax.swing.JDesktopPane();
        lblSPMSProfilePic = new javax.swing.JLabel();
        btnSPMSPrintProfile = new javax.swing.JButton();
        lblSPMSSID1 = new javax.swing.JLabel();
        txtSPMSCurrentClass = new javax.swing.JTextField();
        panelSPMSNotices = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblnotices = new javax.swing.JTable ()

        {
            @Override

            public Component prepareRenderer (TableCellRenderer renderer, int rowIndex, int columnIndex){
                Component componenet = super.prepareRenderer(renderer, rowIndex, columnIndex);

                Object value = getModel().getValueAt(rowIndex,columnIndex);

                if(columnIndex == 0){

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.RED);

                }

                else {

                    componenet.setBackground(Color.WHITE);
                    componenet.setForeground(Color.BLACK);
                }

                return componenet;
            }

        }

        ;
        jButton5 = new javax.swing.JButton();
        panelSPMSCalendar1 = new javax.swing.JPanel();
        jCalendarSPMSCalendar1 = new com.toedter.calendar.JCalendar();
        manageStudentDetails = new javax.swing.JPanel();
        panelSPMSManageProfileCover = new javax.swing.JPanel();
        jTabbedPaneSPMSManageProfile = new javax.swing.JTabbedPane();
        panelSPSPersonal = new javax.swing.JPanel();
        panelSPMSPersonalDetails = new javax.swing.JPanel();
        reqfname = new javax.swing.JLabel();
        male = new javax.swing.JRadioButton();
        txt_Snationality = new javax.swing.JTextField();
        txtSmname = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        reqnationality = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        reqmname = new javax.swing.JLabel();
        reqreligion = new javax.swing.JLabel();
        female = new javax.swing.JRadioButton();
        jLabel19 = new javax.swing.JLabel();
        Sdob = new com.toedter.calendar.JDateChooser();
        txtSreligion = new javax.swing.JTextField();
        reqlname = new javax.swing.JLabel();
        txtSlname = new javax.swing.JTextField();
        txtSfname = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        radioclear = new javax.swing.JRadioButton();
        lblnewpw = new javax.swing.JLabel();
        btnchangepw = new javax.swing.JButton();
        txtnewpw = new javax.swing.JPasswordField();
        lblnewpw1 = new javax.swing.JLabel();
        txtcurrentpw = new javax.swing.JPasswordField();
        btndone = new javax.swing.JButton();
        lblSPMSPersonalProfilePic = new javax.swing.JLabel();
        txtSPMSPersonalImgPath = new javax.swing.JTextField();
        btnSPMSPersonalAttachImg = new javax.swing.JButton();
        DesktopPaneSPMSProfilePic1 = new javax.swing.JDesktopPane();
        lblSPMSPersonalPic = new javax.swing.JLabel();
        panelSPMSContact = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtScountry = new javax.swing.JTextField();
        reqcity = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtScity = new javax.swing.JTextField();
        txtSphone = new javax.swing.JTextField();
        reqstreetNo = new javax.swing.JLabel();
        reqStreet = new javax.swing.JLabel();
        txtSstreetNo = new javax.swing.JTextField();
        txtSemail = new javax.swing.JTextField();
        reqphoneno = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        reqemail = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        reqcountry = new javax.swing.JLabel();
        txtSstreet = new javax.swing.JTextField();
        panelSPMSParent = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtPoccupation = new javax.swing.JTextField();
        reqpphone = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtPphone = new javax.swing.JTextField();
        txtPfname = new javax.swing.JTextField();
        reqplname = new javax.swing.JLabel();
        reqpemail = new javax.swing.JLabel();
        txtPlname = new javax.swing.JTextField();
        txtPnic = new javax.swing.JTextField();
        reqpfname = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        reqpnic = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        reqpoccu = new javax.swing.JLabel();
        txtPemail = new javax.swing.JTextField();
        panelSPMSBio = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Sbio = new javax.swing.JEditorPane();
        panelSPMSMedical = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        txtSPhyPhone = new javax.swing.JTextField();
        txtSbloodgroup = new javax.swing.JTextField();
        txtSPhyname = new javax.swing.JTextField();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        txtSmedical = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtSrestr = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtSmediother = new javax.swing.JTextArea();
        iuds = new javax.swing.JPanel();
        btnclearstuDetails = new javax.swing.JButton();
        btnViewStuInfo = new javax.swing.JButton();
        btnUpdateStuInfo = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        analyzePerformance = new javax.swing.JPanel();
        panelSPMSAnalyzeCover = new javax.swing.JPanel();
        jTabbedPaneSPMSAnalyze = new javax.swing.JTabbedPane();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        comboClass2 = new javax.swing.JComboBox<>();
        txtyr = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        txtm1 = new javax.swing.JTextField();
        txts1 = new javax.swing.JTextField();
        g8 = new javax.swing.JTextField();
        txtm2 = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        g1 = new javax.swing.JTextField();
        g7 = new javax.swing.JTextField();
        txtm6 = new javax.swing.JTextField();
        txtm5 = new javax.swing.JTextField();
        txtm3 = new javax.swing.JTextField();
        txtOverallGrade = new javax.swing.JTextField();
        g2 = new javax.swing.JTextField();
        txts2 = new javax.swing.JTextField();
        txts6 = new javax.swing.JTextField();
        g4 = new javax.swing.JTextField();
        g9 = new javax.swing.JTextField();
        txts7 = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        g3 = new javax.swing.JTextField();
        txts9 = new javax.swing.JTextField();
        txts4 = new javax.swing.JTextField();
        txtm9 = new javax.swing.JTextField();
        txts8 = new javax.swing.JTextField();
        txtavg = new javax.swing.JTextField();
        g6 = new javax.swing.JTextField();
        txtm4 = new javax.swing.JTextField();
        txtm7 = new javax.swing.JTextField();
        txts3 = new javax.swing.JTextField();
        g5 = new javax.swing.JTextField();
        txttotalmarks = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        txts5 = new javax.swing.JTextField();
        txtm8 = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        txtshowStuNo1 = new javax.swing.JTextField();
        jLabel192 = new javax.swing.JLabel();
        txtshowClass1 = new javax.swing.JTextField();
        jLabel193 = new javax.swing.JLabel();
        txtshowYear1 = new javax.swing.JTextField();
        jLabel194 = new javax.swing.JLabel();
        txtshowTerm1 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        comboterm = new javax.swing.JComboBox<>();
        btnViewStuInfo1 = new javax.swing.JButton();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblExtraActivity = new javax.swing.JTable();
        btnViewStuInfo2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        generateReportsStat = new javax.swing.JPanel();
        panelSPMSGenerateReports = new javax.swing.JPanel();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jTabbedPane11 = new javax.swing.JTabbedPane();
        jPanel33 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        btnRankReport = new javax.swing.JButton();
        txtyearreport = new javax.swing.JTextField();
        btnBarChart = new javax.swing.JButton();
        jLabel118 = new javax.swing.JLabel();
        jLabel119 = new javax.swing.JLabel();
        btnPieChart = new javax.swing.JButton();
        jLabel120 = new javax.swing.JLabel();
        combotermreport = new javax.swing.JComboBox<>();
        btnStuTermlyReport = new javax.swing.JButton();
        jLabel124 = new javax.swing.JLabel();
        comboClassreport = new javax.swing.JComboBox<>();
        comboReportterm2 = new javax.swing.JComboBox<>();
        btnClearReports1 = new javax.swing.JButton();
        jLabel121 = new javax.swing.JLabel();
        comboClassreport1 = new javax.swing.JComboBox<>();
        jLabel206 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        generateOfficialDoc = new javax.swing.JPanel();
        panelSPMSGenerateOfficialDoc = new javax.swing.JPanel();
        jTabbedPane13 = new javax.swing.JTabbedPane();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel12 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtOFullname = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtOClass = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtOStuID = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        txtOTeacherFname = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtOTeacherLname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtOPathImg = new javax.swing.JTextField();
        btnOUploadPhoto = new javax.swing.JButton();
        DesktopPaneSPMSProfilePic3 = new javax.swing.JDesktopPane();
        lblSPMSPhotograph = new javax.swing.JLabel();
        jPanel22 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtOBio = new javax.swing.JTextArea();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtOSkills = new javax.swing.JTextArea();
        ac = new javax.swing.JTabbedPane();
        jPanel24 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        txtOyrOL = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        txtOIndexOL = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel135 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        comboSub1 = new javax.swing.JComboBox<>();
        comboGrade1 = new javax.swing.JComboBox<>();
        comboSub2 = new javax.swing.JComboBox<>();
        comboGrade2 = new javax.swing.JComboBox<>();
        comboSub3 = new javax.swing.JComboBox<>();
        comboGrade3 = new javax.swing.JComboBox<>();
        comboSub4 = new javax.swing.JComboBox<>();
        comboGrade4 = new javax.swing.JComboBox<>();
        comboSub5 = new javax.swing.JComboBox<>();
        comboGrade5 = new javax.swing.JComboBox<>();
        comboSub6 = new javax.swing.JComboBox<>();
        comboGrade6 = new javax.swing.JComboBox<>();
        comboSub7 = new javax.swing.JComboBox<>();
        comboGrade7 = new javax.swing.JComboBox<>();
        comboSub8 = new javax.swing.JComboBox<>();
        comboGrade8 = new javax.swing.JComboBox<>();
        comboSub9 = new javax.swing.JComboBox<>();
        comboGrade9 = new javax.swing.JComboBox<>();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtOExtra = new javax.swing.JTextArea();
        GenerateDoc = new javax.swing.JPanel();
        resultssheet = new javax.swing.JRadioButton();
        leavingc = new javax.swing.JRadioButton();
        characterc = new javax.swing.JRadioButton();
        jLabel36 = new javax.swing.JLabel();
        btnRequestDoc = new javax.swing.JButton();
        radioclear3 = new javax.swing.JRadioButton();
        DownloadDocument = new javax.swing.JPanel();
        jLabel37 = new javax.swing.JLabel();
        btnChkAvailability = new javax.swing.JButton();
        txtODocTypeDownload = new javax.swing.JTextField();
        lbldocError = new javax.swing.JLabel();
        btnDownloadDoc = new javax.swing.JButton();
        btnClearOfficial = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        searchShedule = new javax.swing.JPanel();
        jPanel44 = new javax.swing.JPanel();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel27 = new javax.swing.JPanel();
        jPanel38 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSearchshedule = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblSheduleinfo = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jPanel13 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        searchTeachersInfo = new javax.swing.JPanel();
        jPanel45 = new javax.swing.JPanel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jPanel29 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtSearchTeachers = new javax.swing.JTextField();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblTeacherInfo = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        feedbacks = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        feedDate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        e = new javax.swing.JRadioButton();
        txtTfname = new javax.swing.JTextField();
        p = new javax.swing.JRadioButton();
        a = new javax.swing.JRadioButton();
        radioclear2 = new javax.swing.JRadioButton();
        txtTlname = new javax.swing.JTextField();
        jLabel110 = new javax.swing.JLabel();
        g = new javax.swing.JRadioButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        txtDes = new javax.swing.JTextArea();
        jLabel111 = new javax.swing.JLabel();
        btnAddFeedback = new javax.swing.JButton();
        jButton77 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        inquiry = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        txtIstuClass = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        txtInstudentID = new javax.swing.JTextField();
        jLabel114 = new javax.swing.JLabel();
        jLabel115 = new javax.swing.JLabel();
        txtIstuemail = new javax.swing.JTextField();
        jLabel116 = new javax.swing.JLabel();
        txtIstuphone = new javax.swing.JTextField();
        jLabel117 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtIstuInquiry = new javax.swing.JTextArea();
        inqDate = new com.toedter.calendar.JDateChooser();
        sendInquiry = new javax.swing.JButton();
        clearInquiryForm = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        Topic = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        sidemenu = new javax.swing.JPanel();
        panelSPMSSideMenuCover = new javax.swing.JPanel();
        btnSPMSGenerateOfficialDocs = new javax.swing.JButton();
        btnSPMSSearchScedule = new javax.swing.JButton();
        btnSPMSGenerateReports = new javax.swing.JButton();
        btnSPMSAnalyzePerformance = new javax.swing.JButton();
        btnSPMSSearchTeacherInfo = new javax.swing.JButton();
        btnSPMSMakeInquiry = new javax.swing.JButton();
        btnSPMSManageProfile = new javax.swing.JButton();
        btnSPMSProvideFeedbacks = new javax.swing.JButton();
        panelSPMSTopLeftCover = new javax.swing.JPanel();
        btnSPSMhome = new javax.swing.JButton();
        btnSPMSLogout = new javax.swing.JButton();
        btnSPMSAccount = new javax.swing.JButton();

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

        panelSPMSQuickView.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSQuickView.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ProfileQuickView", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        lblSPMSEmail.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSPMSEmail.setText("Email :");

        lblSPMSGender.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSPMSGender.setText("Gender :");

        txtSPMSFname.setEditable(false);
        txtSPMSFname.setBackground(new java.awt.Color(255, 255, 255));
        txtSPMSFname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblSPMSLname.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSLname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSPMSLname.setText("Last Name :");

        lblSPMSWelcome.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSWelcome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSPMSWelcome.setText("Welcome user :");

        txtSPMSGender.setEditable(false);
        txtSPMSGender.setBackground(new java.awt.Color(255, 255, 255));
        txtSPMSGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblSPMSLogedin.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSLogedin.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSPMSSID.setEditable(false);
        txtSPMSSID.setBackground(new java.awt.Color(255, 255, 255));
        txtSPMSSID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblSPMSFname.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSFname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSPMSFname.setText("First Name :");

        txtSPMSEmail.setEditable(false);
        txtSPMSEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtSPMSEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtSPMSLname.setEditable(false);
        txtSPMSLname.setBackground(new java.awt.Color(255, 255, 255));
        txtSPMSLname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lblSPMSSID.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSSID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSPMSSID.setText("Student ID :");

        DesktopPaneSPMSProfilePic.setLayer(lblSPMSProfilePic, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneSPMSProfilePicLayout = new javax.swing.GroupLayout(DesktopPaneSPMSProfilePic);
        DesktopPaneSPMSProfilePic.setLayout(DesktopPaneSPMSProfilePicLayout);
        DesktopPaneSPMSProfilePicLayout.setHorizontalGroup(
            DesktopPaneSPMSProfilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSProfilePic, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        DesktopPaneSPMSProfilePicLayout.setVerticalGroup(
            DesktopPaneSPMSProfilePicLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePicLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSProfilePic, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnSPMSPrintProfile.setBackground(new java.awt.Color(67, 130, 180));
        btnSPMSPrintProfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSPrintProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSPrintProfile.setText("Print Complete Profile");
        btnSPMSPrintProfile.setBorderPainted(false);
        btnSPMSPrintProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSPrintProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSPrintProfileActionPerformed(evt);
            }
        });

        lblSPMSSID1.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSSID1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblSPMSSID1.setText("Current Class :");

        txtSPMSCurrentClass.setEditable(false);
        txtSPMSCurrentClass.setBackground(new java.awt.Color(255, 255, 255));
        txtSPMSCurrentClass.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout panelSPMSQuickViewLayout = new javax.swing.GroupLayout(panelSPMSQuickView);
        panelSPMSQuickView.setLayout(panelSPMSQuickViewLayout);
        panelSPMSQuickViewLayout.setHorizontalGroup(
            panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSPMSQuickViewLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSPMSPrintProfile)
                .addGap(35, 35, 35))
            .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSPMSQuickViewLayout.createSequentialGroup()
                        .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSPMSFname)
                            .addComponent(lblSPMSLname)
                            .addComponent(lblSPMSGender, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34)
                        .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSPMSLname, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSPMSFname)
                            .addComponent(txtSPMSGender)))
                    .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                        .addComponent(lblSPMSSID1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSPMSCurrentClass, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                        .addComponent(lblSPMSSID)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSPMSSID, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                        .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                                .addComponent(lblSPMSEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(txtSPMSEmail))
                            .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                                .addComponent(lblSPMSWelcome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblSPMSLogedin, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(DesktopPaneSPMSProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
        );
        panelSPMSQuickViewLayout.setVerticalGroup(
            panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSQuickViewLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSPMSLogedin, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSPMSWelcome))
                .addGap(27, 27, 27)
                .addComponent(DesktopPaneSPMSProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSPMSSID)
                    .addComponent(txtSPMSSID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSPMSSID1)
                    .addComponent(txtSPMSCurrentClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSPMSFname)
                    .addComponent(txtSPMSFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSPMSLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSPMSLname))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSPMSGender)
                    .addComponent(txtSPMSGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSPMSQuickViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSPMSEmail)
                    .addComponent(txtSPMSEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSPMSPrintProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        panelSPMSNotices.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSNotices.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notice Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane12.setBorder(null);
        jScrollPane12.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane12.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        tblnotices.setForeground(new java.awt.Color(255, 255, 255));
        tblnotices.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblnotices.setFillsViewportHeight(true);
        tblnotices.setGridColor(new java.awt.Color(255, 255, 255));
        tblnotices.setShowHorizontalLines(false);
        tblnotices.setShowVerticalLines(false);
        jScrollPane12.setViewportView(tblnotices);
        if (tblnotices.getColumnModel().getColumnCount() > 0) {
            tblnotices.getColumnModel().getColumn(0).setResizable(false);
            tblnotices.getColumnModel().getColumn(0).setPreferredWidth(15);
            tblnotices.getColumnModel().getColumn(1).setResizable(false);
            tblnotices.getColumnModel().getColumn(1).setPreferredWidth(25);
        }

        jButton5.setBackground(new java.awt.Color(45, 203, 112));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/if_sync_126579.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSPMSNoticesLayout = new javax.swing.GroupLayout(panelSPMSNotices);
        panelSPMSNotices.setLayout(panelSPMSNoticesLayout);
        panelSPMSNoticesLayout.setHorizontalGroup(
            panelSPMSNoticesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSNoticesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSPMSNoticesLayout.setVerticalGroup(
            panelSPMSNoticesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSNoticesLayout.createSequentialGroup()
                .addComponent(jButton5)
                .addContainerGap(177, Short.MAX_VALUE))
            .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        panelSPMSCalendar1.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSCalendar1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Calendar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jCalendarSPMSCalendar1.setBackground(new java.awt.Color(0, 204, 255));
        jCalendarSPMSCalendar1.setDecorationBackgroundColor(new java.awt.Color(255, 255, 255));
        jCalendarSPMSCalendar1.setDecorationBordersVisible(true);
        jCalendarSPMSCalendar1.setTodayButtonText("");
        jCalendarSPMSCalendar1.setTodayButtonVisible(true);
        jCalendarSPMSCalendar1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jCalendarSPMSCalendar1ComponentShown(evt);
            }
        });

        javax.swing.GroupLayout panelSPMSCalendar1Layout = new javax.swing.GroupLayout(panelSPMSCalendar1);
        panelSPMSCalendar1.setLayout(panelSPMSCalendar1Layout);
        panelSPMSCalendar1Layout.setHorizontalGroup(
            panelSPMSCalendar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSCalendar1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jCalendarSPMSCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSPMSCalendar1Layout.setVerticalGroup(
            panelSPMSCalendar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCalendarSPMSCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dashBoardLayout = new javax.swing.GroupLayout(dashBoard);
        dashBoard.setLayout(dashBoardLayout);
        dashBoardLayout.setHorizontalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSPMSQuickView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSPMSNotices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSPMSCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        dashBoardLayout.setVerticalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dashBoardLayout.createSequentialGroup()
                        .addComponent(panelSPMSNotices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSPMSCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelSPMSQuickView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(98, Short.MAX_VALUE))
        );

        forms.add(dashBoard, "dashBoard");

        manageStudentDetails.setBackground(new java.awt.Color(255, 255, 255));
        manageStudentDetails.setMaximumSize(new java.awt.Dimension(1200, 600));
        manageStudentDetails.setMinimumSize(new java.awt.Dimension(1200, 600));
        manageStudentDetails.setPreferredSize(new java.awt.Dimension(1200, 600));

        panelSPMSManageProfileCover.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSManageProfileCover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 201, 208)));

        jTabbedPaneSPMSManageProfile.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPaneSPMSManageProfile.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        panelSPSPersonal.setBackground(new java.awt.Color(255, 255, 255));

        panelSPMSPersonalDetails.setBackground(new java.awt.Color(255, 255, 255));

        reqfname.setBackground(new java.awt.Color(255, 255, 255));
        reqfname.setForeground(new java.awt.Color(255, 0, 0));
        reqfname.setText("*");

        male.setBackground(new java.awt.Color(255, 255, 255));
        male.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        male.setText("Male");
        male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maleActionPerformed(evt);
            }
        });

        txt_Snationality.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txt_Snationality.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_SnationalityKeyTyped(evt);
            }
        });

        txtSmname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSmname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSmnameKeyTyped(evt);
            }
        });

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("First Name :");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Middle Name :");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Last Name :");

        reqnationality.setBackground(new java.awt.Color(255, 255, 255));
        reqnationality.setForeground(new java.awt.Color(255, 0, 0));
        reqnationality.setText("*");

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Nationality :");

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Date Of Birth :");

        reqmname.setBackground(new java.awt.Color(255, 255, 255));
        reqmname.setForeground(new java.awt.Color(255, 0, 0));
        reqmname.setText("*");

        reqreligion.setBackground(new java.awt.Color(255, 255, 255));
        reqreligion.setForeground(new java.awt.Color(255, 0, 0));
        reqreligion.setText("*");

        female.setBackground(new java.awt.Color(255, 255, 255));
        female.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        female.setText("Female");
        female.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                femaleActionPerformed(evt);
            }
        });

        jLabel19.setBackground(new java.awt.Color(255, 255, 255));
        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Religion :");

        Sdob.setBackground(new java.awt.Color(255, 255, 255));
        Sdob.setDateFormatString("yyyy-MM-dd");

        txtSreligion.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSreligion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSreligionKeyTyped(evt);
            }
        });

        reqlname.setBackground(new java.awt.Color(255, 255, 255));
        reqlname.setForeground(new java.awt.Color(255, 0, 0));
        reqlname.setText("*");

        txtSlname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSlname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSlnameKeyTyped(evt);
            }
        });

        txtSfname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSfnameKeyTyped(evt);
            }
        });

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Gender :");

        radioclear.setBackground(new java.awt.Color(255, 255, 255));
        radioclear.setForeground(new java.awt.Color(255, 204, 102));

        lblnewpw.setBackground(new java.awt.Color(255, 255, 255));
        lblnewpw.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnewpw.setText("New Password :");

        btnchangepw.setBackground(new java.awt.Color(67, 130, 180));
        btnchangepw.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnchangepw.setForeground(new java.awt.Color(255, 255, 255));
        btnchangepw.setText("Change Password");
        btnchangepw.setIconTextGap(2);
        btnchangepw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnchangepwActionPerformed(evt);
            }
        });

        lblnewpw1.setBackground(new java.awt.Color(255, 255, 255));
        lblnewpw1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblnewpw1.setText("Current Password :");

        btndone.setBackground(new java.awt.Color(67, 130, 180));
        btndone.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btndone.setForeground(new java.awt.Color(255, 255, 255));
        btndone.setText("DONE");
        btndone.setIconTextGap(2);
        btndone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSPMSPersonalDetailsLayout = new javax.swing.GroupLayout(panelSPMSPersonalDetails);
        panelSPMSPersonalDetails.setLayout(panelSPMSPersonalDetailsLayout);
        panelSPMSPersonalDetailsLayout.setHorizontalGroup(
            panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(lblnewpw1)
                    .addComponent(btnchangepw)
                    .addComponent(lblnewpw))
                .addGap(45, 45, 45)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                        .addComponent(txtSreligion, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reqreligion, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcurrentpw, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSfname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSmname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sdob, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                        .addComponent(female)
                        .addGap(17, 17, 17)
                        .addComponent(male)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(radioclear))
                    .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                        .addComponent(txt_Snationality, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reqnationality, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(reqmname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(reqfname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                            .addComponent(txtSlname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(reqlname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                        .addComponent(txtnewpw, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndone, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSPMSPersonalDetailsLayout.setVerticalGroup(
            panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSPMSPersonalDetailsLayout.createSequentialGroup()
                        .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtSfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtSmname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSPMSPersonalDetailsLayout.createSequentialGroup()
                        .addComponent(reqfname)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(reqmname, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtSlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqlname, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(radioclear, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(male)
                            .addComponent(female))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(Sdob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_Snationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reqnationality, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSreligion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(reqreligion)))
                .addGap(18, 18, 18)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcurrentpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnewpw1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnchangepw)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSPMSPersonalDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnewpw)
                    .addComponent(txtnewpw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndone))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblSPMSPersonalProfilePic.setBackground(new java.awt.Color(255, 255, 255));
        lblSPMSPersonalProfilePic.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lblSPMSPersonalProfilePic.setText("Profile Picture :");

        txtSPMSPersonalImgPath.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnSPMSPersonalAttachImg.setBackground(new java.awt.Color(67, 130, 180));
        btnSPMSPersonalAttachImg.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnSPMSPersonalAttachImg.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSPersonalAttachImg.setText("Attach Photo");
        btnSPMSPersonalAttachImg.setIconTextGap(2);
        btnSPMSPersonalAttachImg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSPersonalAttachImgActionPerformed(evt);
            }
        });

        DesktopPaneSPMSProfilePic1.setLayer(lblSPMSPersonalPic, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneSPMSProfilePic1Layout = new javax.swing.GroupLayout(DesktopPaneSPMSProfilePic1);
        DesktopPaneSPMSProfilePic1.setLayout(DesktopPaneSPMSProfilePic1Layout);
        DesktopPaneSPMSProfilePic1Layout.setHorizontalGroup(
            DesktopPaneSPMSProfilePic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePic1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSPersonalPic, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        DesktopPaneSPMSProfilePic1Layout.setVerticalGroup(
            DesktopPaneSPMSProfilePic1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePic1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSPersonalPic, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSPSPersonalLayout = new javax.swing.GroupLayout(panelSPSPersonal);
        panelSPSPersonal.setLayout(panelSPSPersonalLayout);
        panelSPSPersonalLayout.setHorizontalGroup(
            panelSPSPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPSPersonalLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(panelSPMSPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panelSPSPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSPSPersonalLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(panelSPSPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(DesktopPaneSPMSProfilePic1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panelSPSPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelSPSPersonalLayout.createSequentialGroup()
                                    .addGap(47, 47, 47)
                                    .addComponent(lblSPMSPersonalProfilePic, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(txtSPMSPersonalImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelSPSPersonalLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(btnSPMSPersonalAttachImg)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        panelSPSPersonalLayout.setVerticalGroup(
            panelSPSPersonalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPSPersonalLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(lblSPMSPersonalProfilePic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DesktopPaneSPMSProfilePic1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtSPMSPersonalImgPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSPMSPersonalAttachImg)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelSPSPersonalLayout.createSequentialGroup()
                .addComponent(panelSPMSPersonalDetails, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 32, Short.MAX_VALUE))
        );

        jTabbedPaneSPMSManageProfile.addTab("Personal Details", panelSPSPersonal);

        panelSPMSContact.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        txtScountry.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtScountry.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtScountryKeyTyped(evt);
            }
        });

        reqcity.setForeground(new java.awt.Color(255, 0, 0));
        reqcity.setText("*");

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Email :");

        txtScity.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtScity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtScityKeyTyped(evt);
            }
        });

        txtSphone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSphoneKeyTyped(evt);
            }
        });

        reqstreetNo.setForeground(new java.awt.Color(255, 0, 0));
        reqstreetNo.setText("*");

        reqStreet.setForeground(new java.awt.Color(255, 0, 0));
        reqStreet.setText("*");

        txtSstreetNo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSstreetNo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSstreetNoKeyTyped(evt);
            }
        });

        txtSemail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSemailKeyTyped(evt);
            }
        });

        reqphoneno.setForeground(new java.awt.Color(255, 0, 0));
        reqphoneno.setText("*");

        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel46.setText("Street No :");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel48.setText("Country :");

        reqemail.setForeground(new java.awt.Color(255, 0, 0));
        reqemail.setText("*");

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setText("Street :");

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setText("City :");

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setText("Phone No :");

        reqcountry.setForeground(new java.awt.Color(255, 0, 0));
        reqcountry.setText("*");

        txtSstreet.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSstreet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSstreetKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46)
                    .addComponent(jLabel25)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel50)
                            .addComponent(jLabel51)
                            .addComponent(jLabel48))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtScountry, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtSemail, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqemail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtScity, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqcity, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtSphone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtSstreetNo, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqstreetNo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(txtSstreet, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25)
                    .addComponent(reqemail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel51)
                    .addComponent(txtSphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqphoneno, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSstreetNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqstreetNo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel46))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSstreet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqStreet, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel49))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel50)
                    .addComponent(txtScity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqcity, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel48)
                    .addComponent(txtScountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqcountry, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout panelSPMSContactLayout = new javax.swing.GroupLayout(panelSPMSContact);
        panelSPMSContact.setLayout(panelSPMSContactLayout);
        panelSPMSContactLayout.setHorizontalGroup(
            panelSPMSContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSContactLayout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(744, 744, 744))
        );
        panelSPMSContactLayout.setVerticalGroup(
            panelSPMSContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSContactLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        jTabbedPaneSPMSManageProfile.addTab("Contact Details", panelSPMSContact);

        panelSPMSParent.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        txtPoccupation.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPoccupation.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPoccupationKeyTyped(evt);
            }
        });

        reqpphone.setForeground(new java.awt.Color(255, 0, 0));
        reqpphone.setText("*");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Guardian NIC :");

        txtPphone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPphone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPphoneKeyTyped(evt);
            }
        });

        txtPfname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPfnameKeyTyped(evt);
            }
        });

        reqplname.setForeground(new java.awt.Color(255, 0, 0));
        reqplname.setText("*");

        reqpemail.setForeground(new java.awt.Color(255, 0, 0));
        reqpemail.setText("*");

        txtPlname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPlname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPlnameKeyTyped(evt);
            }
        });

        txtPnic.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPnic.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPnicKeyTyped(evt);
            }
        });

        reqpfname.setForeground(new java.awt.Color(255, 0, 0));
        reqpfname.setText("*");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Guardian Last Name :");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Guardian Occupation :");

        reqpnic.setForeground(new java.awt.Color(255, 0, 0));
        reqpnic.setText("*");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Guardian Email :");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Guardian Phone No :");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Guardian First Name :");

        reqpoccu.setForeground(new java.awt.Color(255, 0, 0));
        reqpoccu.setText("*");

        txtPemail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPemailKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(jLabel12)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(jLabel20)
                            .addComponent(jLabel24))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtPoccupation, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqpoccu, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtPnic, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqpnic, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtPphone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqpphone, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtPfname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqpfname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtPlname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqplname, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtPemail, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(reqpemail, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPnic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(reqpnic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(txtPfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqpfname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqplname, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqpemail, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtPphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqpphone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reqpoccu, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPoccupation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSPMSParentLayout = new javax.swing.GroupLayout(panelSPMSParent);
        panelSPMSParent.setLayout(panelSPMSParentLayout);
        panelSPMSParentLayout.setHorizontalGroup(
            panelSPMSParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSParentLayout.createSequentialGroup()
                .addGap(150, 150, 150)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(710, 710, 710))
        );
        panelSPMSParentLayout.setVerticalGroup(
            panelSPMSParentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSParentLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        jTabbedPaneSPMSManageProfile.addTab("Parent/Guardian Information", panelSPMSParent);

        panelSPMSBio.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 17)); // NOI18N
        jLabel3.setText("A little bit about me :");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(Sbio);

        javax.swing.GroupLayout panelSPMSBioLayout = new javax.swing.GroupLayout(panelSPMSBio);
        panelSPMSBio.setLayout(panelSPMSBioLayout);
        panelSPMSBioLayout.setHorizontalGroup(
            panelSPMSBioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSBioLayout.createSequentialGroup()
                .addGroup(panelSPMSBioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSPMSBioLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3))
                    .addGroup(panelSPMSBioLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 89, Short.MAX_VALUE))
        );
        panelSPMSBioLayout.setVerticalGroup(
            panelSPMSBioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSBioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(298, 298, 298))
        );

        jTabbedPaneSPMSManageProfile.addTab("Bio", panelSPMSBio);

        panelSPMSMedical.setBackground(new java.awt.Color(255, 255, 255));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setText("Physician’s Name :");

        txtSPhyPhone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSPhyPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSPhyPhoneKeyTyped(evt);
            }
        });

        txtSbloodgroup.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSbloodgroup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSbloodgroupKeyTyped(evt);
            }
        });

        txtSPhyname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSPhyname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSPhynameKeyTyped(evt);
            }
        });

        jLabel54.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel54.setText("Blood Group :");

        jLabel55.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel55.setText("Other Conditions :");

        jLabel56.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel56.setText("Medical Alet :");

        jLabel57.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel57.setText("Physical Restrictions : ");

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setText("Physician’s Number :");

        txtSmedical.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSmedical.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSmedicalKeyTyped(evt);
            }
        });

        txtSrestr.setColumns(20);
        txtSrestr.setRows(5);
        jScrollPane3.setViewportView(txtSrestr);

        txtSmediother.setColumns(20);
        txtSmediother.setRows(5);
        jScrollPane4.setViewportView(txtSmediother);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54)
                    .addComponent(jLabel52)
                    .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabel55))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSPhyname, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSPhyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSbloodgroup, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSmedical, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSPhyname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel52))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(txtSPhyPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSbloodgroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel54))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSmedical, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel57)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jLabel55))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout panelSPMSMedicalLayout = new javax.swing.GroupLayout(panelSPMSMedical);
        panelSPMSMedical.setLayout(panelSPMSMedicalLayout);
        panelSPMSMedicalLayout.setHorizontalGroup(
            panelSPMSMedicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSMedicalLayout.createSequentialGroup()
                .addGap(154, 154, 154)
                .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(699, 699, 699))
        );
        panelSPMSMedicalLayout.setVerticalGroup(
            panelSPMSMedicalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSMedicalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPaneSPMSManageProfile.addTab("Medical Details", panelSPMSMedical);

        iuds.setBackground(new java.awt.Color(255, 255, 255));

        btnclearstuDetails.setBackground(new java.awt.Color(251, 163, 4));
        btnclearstuDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnclearstuDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnclearstuDetails.setText("CLEAR");
        btnclearstuDetails.setBorderPainted(false);
        btnclearstuDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnclearstuDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearstuDetailsActionPerformed(evt);
            }
        });

        btnViewStuInfo.setBackground(new java.awt.Color(67, 130, 180));
        btnViewStuInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewStuInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnViewStuInfo.setText("VIEW Student Details");
        btnViewStuInfo.setBorderPainted(false);
        btnViewStuInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewStuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStuInfoActionPerformed(evt);
            }
        });

        btnUpdateStuInfo.setBackground(new java.awt.Color(191, 17, 226));
        btnUpdateStuInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateStuInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStuInfo.setText("UPDATE");
        btnUpdateStuInfo.setBorderPainted(false);
        btnUpdateStuInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateStuInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStuInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout iudsLayout = new javax.swing.GroupLayout(iuds);
        iuds.setLayout(iudsLayout);
        iudsLayout.setHorizontalGroup(
            iudsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iudsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewStuInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateStuInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnclearstuDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(152, 152, 152))
        );
        iudsLayout.setVerticalGroup(
            iudsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iudsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(iudsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUpdateStuInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(iudsLayout.createSequentialGroup()
                        .addGroup(iudsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnclearstuDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewStuInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 201, 208));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Manage Student Profile Details");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSPMSManageProfileCoverLayout = new javax.swing.GroupLayout(panelSPMSManageProfileCover);
        panelSPMSManageProfileCover.setLayout(panelSPMSManageProfileCoverLayout);
        panelSPMSManageProfileCoverLayout.setHorizontalGroup(
            panelSPMSManageProfileCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSManageProfileCoverLayout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(panelSPMSManageProfileCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneSPMSManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSPMSManageProfileCoverLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(iuds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(209, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSPMSManageProfileCoverLayout.setVerticalGroup(
            panelSPMSManageProfileCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSManageProfileCoverLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPaneSPMSManageProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iuds, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout manageStudentDetailsLayout = new javax.swing.GroupLayout(manageStudentDetails);
        manageStudentDetails.setLayout(manageStudentDetailsLayout);
        manageStudentDetailsLayout.setHorizontalGroup(
            manageStudentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageStudentDetailsLayout.createSequentialGroup()
                .addComponent(panelSPMSManageProfileCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 208, Short.MAX_VALUE))
        );
        manageStudentDetailsLayout.setVerticalGroup(
            manageStudentDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageStudentDetailsLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelSPMSManageProfileCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        forms.add(manageStudentDetails, "manageStudentDetails");

        analyzePerformance.setBackground(new java.awt.Color(255, 255, 255));
        analyzePerformance.setMaximumSize(new java.awt.Dimension(1200, 600));
        analyzePerformance.setMinimumSize(new java.awt.Dimension(1200, 600));
        analyzePerformance.setPreferredSize(new java.awt.Dimension(1200, 600));

        panelSPMSAnalyzeCover.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSAnalyzeCover.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPaneSPMSAnalyze.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPaneSPMSAnalyze.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Year :");

        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel128.setText("Class :");

        comboClass2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Class>>" }));

        txtyr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtyr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtyrKeyTyped(evt);
            }
        });

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));
        jPanel14.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Termly Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel43.setBackground(new java.awt.Color(255, 255, 255));

        txtm1.setEditable(false);

        txts1.setEditable(false);

        g8.setEditable(false);
        g8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g8KeyTyped(evt);
            }
        });

        txtm2.setEditable(false);

        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel130.setText("Average Marks :");

        g1.setEditable(false);
        g1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g1KeyTyped(evt);
            }
        });

        g7.setEditable(false);
        g7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g7KeyTyped(evt);
            }
        });

        txtm6.setEditable(false);

        txtm5.setEditable(false);

        txtm3.setEditable(false);

        txtOverallGrade.setEditable(false);
        txtOverallGrade.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOverallGrade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOverallGradeKeyTyped(evt);
            }
        });

        g2.setEditable(false);
        g2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g2KeyTyped(evt);
            }
        });

        txts2.setEditable(false);

        txts6.setEditable(false);

        g4.setEditable(false);
        g4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g4KeyTyped(evt);
            }
        });

        g9.setEditable(false);
        g9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g9KeyTyped(evt);
            }
        });

        txts7.setEditable(false);

        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel131.setText("Overall Grade :");

        g3.setEditable(false);
        g3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g3KeyTyped(evt);
            }
        });

        txts9.setEditable(false);

        txts4.setEditable(false);

        txtm9.setEditable(false);
        txtm9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtm9ActionPerformed(evt);
            }
        });

        txts8.setEditable(false);

        txtavg.setEditable(false);
        txtavg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtavg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtavgKeyTyped(evt);
            }
        });

        g6.setEditable(false);
        g6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g6KeyTyped(evt);
            }
        });

        txtm4.setEditable(false);

        txtm7.setEditable(false);

        txts3.setEditable(false);

        g5.setEditable(false);
        g5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g5KeyTyped(evt);
            }
        });

        txttotalmarks.setEditable(false);
        txttotalmarks.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txttotalmarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttotalmarksKeyTyped(evt);
            }
        });

        jLabel108.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel108.setText("Total Marks :");

        txts5.setEditable(false);

        txtm8.setEditable(false);

        jLabel191.setBackground(java.awt.Color.white);
        jLabel191.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel191.setText("Student No :");

        txtshowStuNo1.setEditable(false);

        jLabel192.setBackground(java.awt.Color.white);
        jLabel192.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel192.setText("Class :");

        txtshowClass1.setEditable(false);

        jLabel193.setBackground(java.awt.Color.white);
        jLabel193.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel193.setText("Year :");

        txtshowYear1.setEditable(false);

        jLabel194.setBackground(java.awt.Color.white);
        jLabel194.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel194.setText("Term :");

        txtshowTerm1.setEditable(false);

        javax.swing.GroupLayout jPanel43Layout = new javax.swing.GroupLayout(jPanel43);
        jPanel43.setLayout(jPanel43Layout);
        jPanel43Layout.setHorizontalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txts4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txts3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txts5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txts6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txts7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txts8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txts9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txts2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txts1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtm6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtm8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtm9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtm3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtm4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtm5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtm7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtm1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtm2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(g1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(g9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel191)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtshowStuNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel43Layout.createSequentialGroup()
                                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel193)
                                        .addComponent(jLabel192))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtshowClass1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtshowYear1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel43Layout.createSequentialGroup()
                                    .addGap(4, 4, 4)
                                    .addComponent(jLabel194)
                                    .addGap(0, 0, Short.MAX_VALUE))))
                        .addComponent(txtshowTerm1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel130)
                                    .addComponent(jLabel108))
                                .addGap(22, 22, 22)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txttotalmarks)
                                    .addComponent(txtavg, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(jLabel131)
                                .addGap(32, 32, 32)
                                .addComponent(txtOverallGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtshowStuNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel191))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel192)
                            .addComponent(txtshowClass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtshowYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel193))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtshowTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel194))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel108)
                            .addComponent(txttotalmarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel130)
                            .addComponent(txtavg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel131)
                            .addComponent(txtOverallGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(txtm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtm5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtm6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtm7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtm8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtm9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(txts1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txts2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txts3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txts4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txts5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txts6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txts7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txts8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txts9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 737, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 302, Short.MAX_VALUE)
            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel14Layout.createSequentialGroup()
                    .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 30, Short.MAX_VALUE)))
        );

        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel129.setText("Term");

        comboterm.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Term>>", "First Term", "Second Term", "Third Term" }));

        btnViewStuInfo1.setBackground(new java.awt.Color(67, 130, 180));
        btnViewStuInfo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewStuInfo1.setForeground(new java.awt.Color(255, 255, 255));
        btnViewStuInfo1.setText("VIEW Term Report");
        btnViewStuInfo1.setBorderPainted(false);
        btnViewStuInfo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewStuInfo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStuInfo1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtyr, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel128)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboClass2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel129)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboterm, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnViewStuInfo1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtyr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128)
                    .addComponent(comboClass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel129)
                    .addComponent(comboterm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewStuInfo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane3.addTab(" Termly Student Report", jPanel7);

        jTabbedPaneSPMSAnalyze.addTab("View Academic Records", jTabbedPane3);

        jTabbedPane4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));

        tblExtraActivity.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Date", "Activity Name", "Description", "Marks"
            }
        ));
        jScrollPane11.setViewportView(tblExtraActivity);

        btnViewStuInfo2.setBackground(new java.awt.Color(67, 130, 180));
        btnViewStuInfo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewStuInfo2.setForeground(new java.awt.Color(255, 255, 255));
        btnViewStuInfo2.setText("VIEW Achievements");
        btnViewStuInfo2.setBorderPainted(false);
        btnViewStuInfo2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewStuInfo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStuInfo2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnViewStuInfo2)
                .addContainerGap(72, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(btnViewStuInfo2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Achievements", jPanel15);

        jTabbedPaneSPMSAnalyze.addTab("View  Extacurricular Records", jTabbedPane4);

        jPanel3.setBackground(new java.awt.Color(0, 201, 208));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("Analyze Performance");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSPMSAnalyzeCoverLayout = new javax.swing.GroupLayout(panelSPMSAnalyzeCover);
        panelSPMSAnalyzeCover.setLayout(panelSPMSAnalyzeCoverLayout);
        panelSPMSAnalyzeCoverLayout.setHorizontalGroup(
            panelSPMSAnalyzeCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSPMSAnalyzeCoverLayout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jTabbedPaneSPMSAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, 763, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
        );
        panelSPMSAnalyzeCoverLayout.setVerticalGroup(
            panelSPMSAnalyzeCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSPMSAnalyzeCoverLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPaneSPMSAnalyze, javax.swing.GroupLayout.PREFERRED_SIZE, 457, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout analyzePerformanceLayout = new javax.swing.GroupLayout(analyzePerformance);
        analyzePerformance.setLayout(analyzePerformanceLayout);
        analyzePerformanceLayout.setHorizontalGroup(
            analyzePerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analyzePerformanceLayout.createSequentialGroup()
                .addComponent(panelSPMSAnalyzeCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 206, Short.MAX_VALUE))
        );
        analyzePerformanceLayout.setVerticalGroup(
            analyzePerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(analyzePerformanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSPMSAnalyzeCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(83, Short.MAX_VALUE))
        );

        forms.add(analyzePerformance, "analyzePerformance");

        generateReportsStat.setBackground(new java.awt.Color(255, 255, 255));
        generateReportsStat.setMaximumSize(new java.awt.Dimension(1200, 600));
        generateReportsStat.setMinimumSize(new java.awt.Dimension(1200, 600));
        generateReportsStat.setPreferredSize(new java.awt.Dimension(1200, 600));

        panelSPMSGenerateReports.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSGenerateReports.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPane10.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane10.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        jTabbedPane11.setBackground(new java.awt.Color(255, 255, 255));

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        btnRankReport.setBackground(new java.awt.Color(67, 130, 180));
        btnRankReport.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnRankReport.setForeground(new java.awt.Color(255, 255, 255));
        btnRankReport.setText("Generate Student Rank Report");
        btnRankReport.setIconTextGap(14);
        btnRankReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRankReportActionPerformed(evt);
            }
        });

        txtyearreport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtyearreport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtyearreportKeyTyped(evt);
            }
        });

        btnBarChart.setBackground(new java.awt.Color(67, 130, 180));
        btnBarChart.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnBarChart.setForeground(new java.awt.Color(255, 255, 255));
        btnBarChart.setText("Generate Column Chart - Compare Current Resilts with :");
        btnBarChart.setIconTextGap(14);
        btnBarChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBarChartActionPerformed(evt);
            }
        });

        jLabel118.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel118.setText("Year :");

        jLabel119.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel119.setText("Term");

        btnPieChart.setBackground(new java.awt.Color(67, 130, 180));
        btnPieChart.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPieChart.setForeground(new java.awt.Color(255, 255, 255));
        btnPieChart.setText("Generate Pie Chart - Subjects Vs Marks");
        btnPieChart.setIconTextGap(14);
        btnPieChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPieChartActionPerformed(evt);
            }
        });

        jLabel120.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel120.setText("Class :");

        combotermreport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Term>>", "First Term", "Second Term", "Third Term" }));

        btnStuTermlyReport.setBackground(new java.awt.Color(67, 130, 180));
        btnStuTermlyReport.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnStuTermlyReport.setForeground(new java.awt.Color(255, 255, 255));
        btnStuTermlyReport.setText("Generate My Termly Report");
        btnStuTermlyReport.setIconTextGap(14);
        btnStuTermlyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStuTermlyReportActionPerformed(evt);
            }
        });

        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel124.setText("Term :");

        comboClassreport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Class>>" }));

        comboReportterm2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Term>>", "First Term", "Second Term", "Third Term" }));

        btnClearReports1.setBackground(new java.awt.Color(251, 163, 4));
        btnClearReports1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearReports1.setForeground(new java.awt.Color(255, 255, 255));
        btnClearReports1.setText("CLEAR");
        btnClearReports1.setBorderPainted(false);
        btnClearReports1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearReports1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearReports1ActionPerformed(evt);
            }
        });

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel121.setText("Class :");

        comboClassreport1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Class>>" }));

        jLabel206.setBackground(java.awt.Color.white);
        jLabel206.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel206.setText("Generate Reports");

        jLabel205.setBackground(java.awt.Color.white);
        jLabel205.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel205.setText("Generate Charts");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addComponent(jLabel118)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtyearreport, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel119)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(combotermreport, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel120)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboClassreport, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnStuTermlyReport, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPieChart)
                    .addComponent(btnRankReport)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(btnBarChart, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                                .addComponent(btnClearReports1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(177, 177, 177)))
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboClassreport1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addComponent(jLabel124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboReportterm2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel206)
                    .addComponent(jLabel205))
                .addContainerGap(225, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel206)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel119)
                    .addComponent(jLabel120)
                    .addComponent(jLabel118)
                    .addComponent(txtyearreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combotermreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboClassreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnStuTermlyReport)
                .addGap(18, 18, 18)
                .addComponent(btnRankReport)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel205)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(btnPieChart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnBarChart)
                            .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel124)
                                .addComponent(comboReportterm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel121)
                            .addComponent(comboClassreport1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(64, 64, 64))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearReports1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34))))
        );

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane11.addTab("Exam Results Statistics", jPanel33);

        jTabbedPane10.addTab("Academic ", jTabbedPane11);

        jPanel5.setBackground(new java.awt.Color(0, 201, 208));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Generate Reports");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSPMSGenerateReportsLayout = new javax.swing.GroupLayout(panelSPMSGenerateReports);
        panelSPMSGenerateReports.setLayout(panelSPMSGenerateReportsLayout);
        panelSPMSGenerateReportsLayout.setHorizontalGroup(
            panelSPMSGenerateReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSGenerateReportsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane10)
                .addContainerGap())
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelSPMSGenerateReportsLayout.setVerticalGroup(
            panelSPMSGenerateReportsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSGenerateReportsLayout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout generateReportsStatLayout = new javax.swing.GroupLayout(generateReportsStat);
        generateReportsStat.setLayout(generateReportsStatLayout);
        generateReportsStatLayout.setHorizontalGroup(
            generateReportsStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generateReportsStatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSPMSGenerateReports, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );
        generateReportsStatLayout.setVerticalGroup(
            generateReportsStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generateReportsStatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSPMSGenerateReports, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(113, 113, 113))
        );

        forms.add(generateReportsStat, "generateReportsStat");

        generateOfficialDoc.setBackground(new java.awt.Color(255, 255, 255));
        generateOfficialDoc.setMaximumSize(new java.awt.Dimension(1200, 600));
        generateOfficialDoc.setMinimumSize(new java.awt.Dimension(1200, 600));
        generateOfficialDoc.setPreferredSize(new java.awt.Dimension(1200, 600));

        panelSPMSGenerateOfficialDoc.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSGenerateOfficialDoc.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPane13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        jTabbedPane7.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        jTabbedPane5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Student's Full Name :");

        txtOFullname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOFullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOFullnameKeyTyped(evt);
            }
        });

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Class :");

        txtOClass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOClass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOClassKeyTyped(evt);
            }
        });

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Student ID :");

        txtOStuID.setEditable(false);
        txtOStuID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOStuID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOStuIDKeyTyped(evt);
            }
        });

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Class Teacher's First Name :");

        txtOTeacherFname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOTeacherFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOTeacherFnameKeyTyped(evt);
            }
        });

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Class Teacher's Last Name :");

        txtOTeacherLname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOTeacherLname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOTeacherLnameKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(116, 116, 116)
                        .addComponent(txtOStuID))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(27, 27, 27)
                        .addComponent(txtOTeacherLname))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOTeacherFname)
                            .addComponent(txtOClass)))
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(txtOFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(57, 57, 57))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtOStuID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(txtOClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(txtOTeacherFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOTeacherLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(12, 12, 12)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtOFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
        );

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Student's Recent Photograph");

        txtOPathImg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnOUploadPhoto.setBackground(new java.awt.Color(67, 130, 180));
        btnOUploadPhoto.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnOUploadPhoto.setForeground(new java.awt.Color(255, 255, 255));
        btnOUploadPhoto.setText("Attach Photo");
        btnOUploadPhoto.setIconTextGap(2);
        btnOUploadPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOUploadPhotoActionPerformed(evt);
            }
        });

        DesktopPaneSPMSProfilePic3.setLayer(lblSPMSPhotograph, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneSPMSProfilePic3Layout = new javax.swing.GroupLayout(DesktopPaneSPMSProfilePic3);
        DesktopPaneSPMSProfilePic3.setLayout(DesktopPaneSPMSProfilePic3Layout);
        DesktopPaneSPMSProfilePic3Layout.setHorizontalGroup(
            DesktopPaneSPMSProfilePic3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePic3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSPhotograph, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        DesktopPaneSPMSProfilePic3Layout.setVerticalGroup(
            DesktopPaneSPMSProfilePic3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePic3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSPhotograph, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(btnOUploadPhoto))
                    .addComponent(jLabel6)
                    .addComponent(txtOPathImg, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(DesktopPaneSPMSProfilePic3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(15, 15, 15)
                        .addComponent(DesktopPaneSPMSProfilePic3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOPathImg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnOUploadPhoto))
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Student Details", jPanel12);

        jPanel22.setBackground(java.awt.Color.white);

        jScrollPane2.setBackground(java.awt.Color.white);

        txtOBio.setColumns(20);
        txtOBio.setRows(5);
        jScrollPane2.setViewportView(txtOBio);

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Bio", jPanel22);

        jPanel23.setBackground(java.awt.Color.white);

        jScrollPane5.setBackground(java.awt.Color.white);

        txtOSkills.setColumns(20);
        txtOSkills.setRows(5);
        jScrollPane5.setViewportView(txtOSkills);

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Skills and Interests", jPanel23);

        jTabbedPane7.addTab("Student Information", jTabbedPane5);

        ac.setBackground(java.awt.Color.white);

        jPanel24.setBackground(java.awt.Color.white);

        jPanel16.setBackground(java.awt.Color.white);

        jLabel59.setBackground(java.awt.Color.white);
        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("Year :");

        txtOyrOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOyrOLActionPerformed(evt);
            }
        });
        txtOyrOL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOyrOLKeyTyped(evt);
            }
        });

        jLabel84.setBackground(java.awt.Color.white);
        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setText("Subject :");

        txtOIndexOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOIndexOLActionPerformed(evt);
            }
        });
        txtOIndexOL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOIndexOLKeyTyped(evt);
            }
        });

        jLabel61.setBackground(java.awt.Color.white);
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("Exam Index No :");

        jLabel87.setBackground(java.awt.Color.white);
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel87.setText("Grade :");

        jLabel88.setBackground(java.awt.Color.white);
        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel88.setText("Grade :");

        jLabel89.setBackground(java.awt.Color.white);
        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel89.setText("Grade :");

        jLabel91.setBackground(java.awt.Color.white);
        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel91.setText("Subject :");

        jLabel92.setBackground(java.awt.Color.white);
        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel92.setText("Subject :");

        jLabel127.setBackground(java.awt.Color.white);
        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel127.setText("Subject :");

        jLabel135.setBackground(java.awt.Color.white);
        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel135.setText("Grade :");

        jLabel138.setBackground(java.awt.Color.white);
        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel138.setText("Subject :");

        jLabel139.setBackground(java.awt.Color.white);
        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel139.setText("Grade :");

        jLabel140.setBackground(java.awt.Color.white);
        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel140.setText("Subject :");

        jLabel141.setBackground(java.awt.Color.white);
        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel141.setText("Grade :");

        jLabel142.setBackground(java.awt.Color.white);
        jLabel142.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel142.setText("Subject :");

        jLabel143.setBackground(java.awt.Color.white);
        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel143.setText("Grade :");

        jLabel144.setBackground(java.awt.Color.white);
        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel144.setText("Subject :");

        jLabel145.setBackground(java.awt.Color.white);
        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel145.setText("Grade :");

        jLabel146.setBackground(java.awt.Color.white);
        jLabel146.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel146.setText("Subject :");

        jLabel147.setBackground(java.awt.Color.white);
        jLabel147.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel147.setText("Grade :");

        comboSub1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub1ActionPerformed(evt);
            }
        });

        comboGrade1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub2ActionPerformed(evt);
            }
        });

        comboGrade2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub3ActionPerformed(evt);
            }
        });

        comboGrade3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub4ActionPerformed(evt);
            }
        });

        comboGrade4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub5ActionPerformed(evt);
            }
        });

        comboGrade5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub6ActionPerformed(evt);
            }
        });

        comboGrade6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub7ActionPerformed(evt);
            }
        });

        comboGrade7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub8ActionPerformed(evt);
            }
        });

        comboGrade8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        comboSub9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub9ActionPerformed(evt);
            }
        });

        comboGrade9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Grade>>", "A", "B", "C", "S", "W" }));

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel92)
                                    .addComponent(jLabel88))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboGrade4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel91)
                                    .addComponent(jLabel89)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel87))
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboSub1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboGrade1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(comboSub7, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(comboGrade7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel138, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel139, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub5, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboGrade5, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel127))
                                    .addComponent(jLabel135, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel141)
                                    .addComponent(jLabel140))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub8, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboGrade8, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel144)
                                        .addComponent(jLabel145, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboSub6, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboGrade6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(jPanel16Layout.createSequentialGroup()
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel146)
                                        .addComponent(jLabel147, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(comboSub9, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(comboGrade9, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel143)
                                        .addGap(18, 18, 18))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addComponent(jLabel142)
                                        .addGap(14, 14, 14)))
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(comboGrade3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addComponent(jLabel61)
                        .addGap(4, 4, 4)
                        .addComponent(txtOIndexOL, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel59)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOyrOL, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(96, 96, 96))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel61)
                            .addComponent(jLabel59)
                            .addComponent(txtOIndexOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtOyrOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel89))
                            .addComponent(comboSub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboSub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel127)
                                            .addComponent(jLabel142)
                                            .addComponent(comboSub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(1, 1, 1)
                                        .addComponent(jLabel143))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel135)))))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(comboSub4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel92))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboGrade4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel88))))
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboSub7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel84))
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(comboGrade7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel87)
                                                    .addComponent(jLabel141)))))
                                    .addGroup(jPanel16Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(comboSub8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel140))
                                            .addGroup(jPanel16Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(comboGrade8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(jPanel16Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(comboGrade3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboSub6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addComponent(jLabel144)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel145)
                                    .addComponent(comboGrade6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(comboSub5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel138))
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboGrade5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel139))))
                        .addGap(16, 16, 16)
                        .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel146)
                            .addComponent(comboSub9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel16Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboGrade9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel147))))))
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ac.addTab("Ordinary Level Exam", jPanel24);

        jTabbedPane7.addTab("Academic Information", ac);

        jPanel20.setBackground(java.awt.Color.white);

        jScrollPane6.setBackground(java.awt.Color.white);

        txtOExtra.setColumns(20);
        txtOExtra.setRows(5);
        jScrollPane6.setViewportView(txtOExtra);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Extracurricular Activities", jPanel20);

        resultssheet.setText("Results Sheet");

        leavingc.setText("Leaving Certificate");

        characterc.setText("Character Certificate");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Document Type :");

        btnRequestDoc.setBackground(new java.awt.Color(34, 139, 34));
        btnRequestDoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRequestDoc.setForeground(new java.awt.Color(255, 255, 255));
        btnRequestDoc.setText("Request Document");
        btnRequestDoc.setBorderPainted(false);
        btnRequestDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRequestDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestDocActionPerformed(evt);
            }
        });

        radioclear3.setBackground(new java.awt.Color(255, 255, 255));
        radioclear3.setForeground(new java.awt.Color(255, 204, 102));

        javax.swing.GroupLayout GenerateDocLayout = new javax.swing.GroupLayout(GenerateDoc);
        GenerateDoc.setLayout(GenerateDocLayout);
        GenerateDocLayout.setHorizontalGroup(
            GenerateDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GenerateDocLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                .addGroup(GenerateDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioclear3)
                    .addComponent(characterc)
                    .addComponent(leavingc)
                    .addComponent(btnRequestDoc)
                    .addComponent(resultssheet))
                .addGap(306, 306, 306))
        );
        GenerateDocLayout.setVerticalGroup(
            GenerateDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GenerateDocLayout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(GenerateDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(resultssheet)
                    .addComponent(jLabel36))
                .addGap(14, 14, 14)
                .addComponent(leavingc)
                .addGap(18, 18, 18)
                .addComponent(characterc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(radioclear3)
                .addGap(50, 50, 50)
                .addComponent(btnRequestDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jTabbedPane7.addTab("Request Document", GenerateDoc);

        jTabbedPane13.addTab("Request Document", jTabbedPane7);

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("Document Type :");

        btnChkAvailability.setBackground(new java.awt.Color(67, 130, 180));
        btnChkAvailability.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnChkAvailability.setForeground(new java.awt.Color(255, 255, 255));
        btnChkAvailability.setText("Check Document Availability");
        btnChkAvailability.setBorderPainted(false);
        btnChkAvailability.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChkAvailability.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChkAvailabilityActionPerformed(evt);
            }
        });

        txtODocTypeDownload.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtODocTypeDownloadKeyTyped(evt);
            }
        });

        lbldocError.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbldocError.setForeground(new java.awt.Color(255, 0, 0));
        lbldocError.setText("Sorry Your Document is NOT Available Yet. Please Try Again Later...");

        btnDownloadDoc.setBackground(new java.awt.Color(67, 130, 180));
        btnDownloadDoc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDownloadDoc.setForeground(new java.awt.Color(255, 255, 255));
        btnDownloadDoc.setText("Download Document");
        btnDownloadDoc.setBorderPainted(false);
        btnDownloadDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDownloadDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDownloadDocActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DownloadDocumentLayout = new javax.swing.GroupLayout(DownloadDocument);
        DownloadDocument.setLayout(DownloadDocumentLayout);
        DownloadDocumentLayout.setHorizontalGroup(
            DownloadDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownloadDocumentLayout.createSequentialGroup()
                .addGap(0, 161, Short.MAX_VALUE)
                .addComponent(lbldocError, javax.swing.GroupLayout.PREFERRED_SIZE, 477, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(122, 122, 122))
            .addGroup(DownloadDocumentLayout.createSequentialGroup()
                .addGroup(DownloadDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DownloadDocumentLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(txtODocTypeDownload, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DownloadDocumentLayout.createSequentialGroup()
                        .addGap(278, 278, 278)
                        .addComponent(btnDownloadDoc)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DownloadDocumentLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChkAvailability)
                .addGap(281, 281, 281))
            .addGroup(DownloadDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DownloadDocumentLayout.createSequentialGroup()
                    .addGap(199, 199, 199)
                    .addComponent(jLabel37)
                    .addContainerGap(457, Short.MAX_VALUE)))
        );
        DownloadDocumentLayout.setVerticalGroup(
            DownloadDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DownloadDocumentLayout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(txtODocTypeDownload, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnChkAvailability, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbldocError, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDownloadDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(DownloadDocumentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DownloadDocumentLayout.createSequentialGroup()
                    .addGap(140, 140, 140)
                    .addComponent(jLabel37)
                    .addContainerGap(250, Short.MAX_VALUE)))
        );

        jTabbedPane13.addTab("Download Document", DownloadDocument);

        btnClearOfficial.setBackground(new java.awt.Color(251, 163, 4));
        btnClearOfficial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearOfficial.setForeground(new java.awt.Color(255, 255, 255));
        btnClearOfficial.setText("CLEAR");
        btnClearOfficial.setBorderPainted(false);
        btnClearOfficial.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearOfficial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearOfficialActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(0, 201, 208));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Generate Official Documents");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel31)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel31)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelSPMSGenerateOfficialDocLayout = new javax.swing.GroupLayout(panelSPMSGenerateOfficialDoc);
        panelSPMSGenerateOfficialDoc.setLayout(panelSPMSGenerateOfficialDocLayout);
        panelSPMSGenerateOfficialDocLayout.setHorizontalGroup(
            panelSPMSGenerateOfficialDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelSPMSGenerateOfficialDocLayout.createSequentialGroup()
                .addGroup(panelSPMSGenerateOfficialDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelSPMSGenerateOfficialDocLayout.createSequentialGroup()
                        .addGap(315, 315, 315)
                        .addComponent(btnClearOfficial, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelSPMSGenerateOfficialDocLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jTabbedPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(126, Short.MAX_VALUE))
        );
        panelSPMSGenerateOfficialDocLayout.setVerticalGroup(
            panelSPMSGenerateOfficialDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSGenerateOfficialDocLayout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnClearOfficial, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout generateOfficialDocLayout = new javax.swing.GroupLayout(generateOfficialDoc);
        generateOfficialDoc.setLayout(generateOfficialDocLayout);
        generateOfficialDocLayout.setHorizontalGroup(
            generateOfficialDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generateOfficialDocLayout.createSequentialGroup()
                .addComponent(panelSPMSGenerateOfficialDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 209, Short.MAX_VALUE))
        );
        generateOfficialDocLayout.setVerticalGroup(
            generateOfficialDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(generateOfficialDocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSPMSGenerateOfficialDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        forms.add(generateOfficialDoc, "generateOfficialDoc");

        searchShedule.setBackground(new java.awt.Color(255, 255, 255));
        searchShedule.setMaximumSize(new java.awt.Dimension(1200, 600));
        searchShedule.setMinimumSize(new java.awt.Dimension(1200, 600));
        searchShedule.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel44.setBackground(new java.awt.Color(255, 255, 255));
        jPanel44.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPane8.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jPanel38.setBackground(java.awt.Color.white);

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        jLabel8.setBackground(java.awt.Color.white);
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Enter Class Name  search Schedule Info");

        txtSearchshedule.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchshedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchsheduleActionPerformed(evt);
            }
        });
        txtSearchshedule.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchsheduleKeyReleased(evt);
            }
        });

        jScrollPane7.setBackground(java.awt.Color.white);

        tblSheduleinfo.setBackground(new java.awt.Color(204, 204, 204));
        tblSheduleinfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane7.setViewportView(tblSheduleinfo);

        jButton2.setBackground(new java.awt.Color(45, 203, 112));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("RefreshTable");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(238, Short.MAX_VALUE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchshedule, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(41, 41, 41))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane7)
                .addContainerGap())
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtSearchshedule, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147)
                .addComponent(jPanel38, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Search Record", jPanel27);

        jPanel13.setBackground(new java.awt.Color(0, 201, 208));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setText("Search Schedule");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel32)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel32)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(176, Short.MAX_VALUE))
            .addComponent(jPanel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout searchSheduleLayout = new javax.swing.GroupLayout(searchShedule);
        searchShedule.setLayout(searchSheduleLayout);
        searchSheduleLayout.setHorizontalGroup(
            searchSheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchSheduleLayout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 209, Short.MAX_VALUE))
        );
        searchSheduleLayout.setVerticalGroup(
            searchSheduleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchSheduleLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(139, 139, 139))
        );

        forms.add(searchShedule, "searchShedule");

        searchTeachersInfo.setBackground(new java.awt.Color(255, 255, 255));

        jPanel45.setBackground(new java.awt.Color(255, 255, 255));
        jPanel45.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPane9.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        jPanel29.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Enter Teacher  Name  search teachers' Info");

        txtSearchTeachers.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchTeachers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchTeachersKeyReleased(evt);
            }
        });

        jScrollPane8.setBackground(new java.awt.Color(255, 255, 255));

        tblTeacherInfo.setBackground(new java.awt.Color(204, 204, 204));
        tblTeacherInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane8.setViewportView(tblTeacherInfo);

        jButton3.setBackground(new java.awt.Color(45, 203, 112));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("RefreshTable");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearchTeachers, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane8)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel29Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(30, 30, 30))
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSearchTeachers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton3)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jTabbedPane9.addTab("Search Record", jPanel29);

        jPanel17.setBackground(new java.awt.Color(0, 201, 208));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel34.setText("Search Teachers' Information");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel34)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel34)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addGap(180, 180, 180)
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout searchTeachersInfoLayout = new javax.swing.GroupLayout(searchTeachersInfo);
        searchTeachersInfo.setLayout(searchTeachersInfoLayout);
        searchTeachersInfoLayout.setHorizontalGroup(
            searchTeachersInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTeachersInfoLayout.createSequentialGroup()
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        searchTeachersInfoLayout.setVerticalGroup(
            searchTeachersInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(searchTeachersInfoLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        forms.add(searchTeachersInfo, "searchTeacherInfo");

        feedbacks.setBackground(new java.awt.Color(255, 255, 255));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));
        jPanel18.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        feedDate.setDateFormatString("yyyy-MM-dd");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Teacher Last Name :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Teacher First Name :");

        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel109.setText("Feedback");

        e.setBackground(new java.awt.Color(255, 255, 255));
        e.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        e.setText("Excellent");
        e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eActionPerformed(evt);
            }
        });

        txtTfname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTfnameKeyTyped(evt);
            }
        });

        p.setBackground(new java.awt.Color(255, 255, 255));
        p.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        p.setText("Poor");
        p.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pActionPerformed(evt);
            }
        });

        a.setBackground(new java.awt.Color(255, 255, 255));
        a.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        a.setText("Average");
        a.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aActionPerformed(evt);
            }
        });

        radioclear2.setBackground(new java.awt.Color(255, 255, 255));
        radioclear2.setForeground(new java.awt.Color(255, 204, 102));

        txtTlname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTlnameKeyTyped(evt);
            }
        });

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel110.setText("Description");

        g.setBackground(new java.awt.Color(255, 255, 255));
        g.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g.setText("Good");
        g.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gActionPerformed(evt);
            }
        });

        txtDes.setColumns(20);
        txtDes.setRows(5);
        jScrollPane9.setViewportView(txtDes);

        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel111.setText("Date");

        btnAddFeedback.setBackground(new java.awt.Color(34, 139, 34));
        btnAddFeedback.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddFeedback.setForeground(new java.awt.Color(255, 255, 255));
        btnAddFeedback.setText("Provide Feedback");
        btnAddFeedback.setBorderPainted(false);
        btnAddFeedback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddFeedback.setMaximumSize(new java.awt.Dimension(119, 25));
        btnAddFeedback.setMinimumSize(new java.awt.Dimension(119, 25));
        btnAddFeedback.setPreferredSize(new java.awt.Dimension(119, 25));
        btnAddFeedback.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFeedbackActionPerformed(evt);
            }
        });

        jButton77.setBackground(new java.awt.Color(251, 163, 4));
        jButton77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton77.setForeground(new java.awt.Color(255, 255, 255));
        jButton77.setText("CLEAR");
        jButton77.setBorderPainted(false);
        jButton77.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton77.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton77ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel111, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(feedDate, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTfname, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnAddFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(118, 118, 118)
                        .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTlname, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(e)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(g)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(a)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(p)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(radioclear2))
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addComponent(jLabel110, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(142, Short.MAX_VALUE))
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel111)
                    .addComponent(feedDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTfname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtTlname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel109)
                        .addComponent(g)
                        .addComponent(e)
                        .addComponent(a)
                        .addComponent(p))
                    .addComponent(radioclear2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel31Layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jLabel110)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddFeedback, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton77, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel19.setBackground(new java.awt.Color(0, 201, 208));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText("Provide Feedback");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel35)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap(253, Short.MAX_VALUE)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(147, 147, 147))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout feedbacksLayout = new javax.swing.GroupLayout(feedbacks);
        feedbacks.setLayout(feedbacksLayout);
        feedbacksLayout.setHorizontalGroup(
            feedbacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbacksLayout.createSequentialGroup()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 20, Short.MAX_VALUE))
        );
        feedbacksLayout.setVerticalGroup(
            feedbacksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(feedbacksLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
        );

        forms.add(feedbacks, "feedbacks");

        inquiry.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));
        jPanel25.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));
        jPanel32.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtIstuClass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIstuClass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIstuClassActionPerformed(evt);
            }
        });

        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel112.setText("Class :");

        jLabel113.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel113.setText("Date :");

        txtInstudentID.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtInstudentID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInstudentIDKeyTyped(evt);
            }
        });

        jLabel114.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel114.setText("Student ID :");

        jLabel115.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel115.setText("Email :");

        txtIstuemail.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIstuemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIstuemailActionPerformed(evt);
            }
        });

        jLabel116.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel116.setText("Phone No :");

        txtIstuphone.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtIstuphone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIstuphoneActionPerformed(evt);
            }
        });

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel117.setText("Student Inquiry :");

        txtIstuInquiry.setColumns(20);
        txtIstuInquiry.setRows(5);
        jScrollPane10.setViewportView(txtIstuInquiry);

        inqDate.setBackground(new java.awt.Color(255, 255, 255));
        inqDate.setDateFormatString("yyyy-MM-dd");

        sendInquiry.setBackground(new java.awt.Color(34, 139, 34));
        sendInquiry.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        sendInquiry.setForeground(new java.awt.Color(255, 255, 255));
        sendInquiry.setText("SEND");
        sendInquiry.setBorderPainted(false);
        sendInquiry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        sendInquiry.setMaximumSize(new java.awt.Dimension(119, 25));
        sendInquiry.setMinimumSize(new java.awt.Dimension(119, 25));
        sendInquiry.setPreferredSize(new java.awt.Dimension(119, 25));
        sendInquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendInquiryActionPerformed(evt);
            }
        });

        clearInquiryForm.setBackground(new java.awt.Color(251, 163, 4));
        clearInquiryForm.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        clearInquiryForm.setForeground(new java.awt.Color(255, 255, 255));
        clearInquiryForm.setText("CLEAR");
        clearInquiryForm.setBorderPainted(false);
        clearInquiryForm.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        clearInquiryForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearInquiryFormActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel114, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel113, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGap(65, 65, 65))
                                .addGroup(jPanel32Layout.createSequentialGroup()
                                    .addComponent(jLabel115, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addGap(114, 114, 114)))
                            .addGroup(jPanel32Layout.createSequentialGroup()
                                .addComponent(jLabel112, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)))
                        .addGroup(jPanel32Layout.createSequentialGroup()
                            .addComponent(jLabel116, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(84, 84, 84)))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addComponent(jLabel117, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(84, 84, 84)))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtIstuemail, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                        .addComponent(txtInstudentID)
                        .addComponent(txtIstuphone, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIstuClass)
                            .addComponent(inqDate, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))))
                .addContainerGap(37, Short.MAX_VALUE))
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(sendInquiry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(clearInquiryForm, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62))
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel32Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtInstudentID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel114))
                .addGap(30, 30, 30)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIstuClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel112))
                .addGap(24, 24, 24)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel113)
                    .addComponent(inqDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtIstuemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel115))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel116))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtIstuphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel117))
                    .addGroup(jPanel32Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearInquiryForm, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendInquiry, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel26.setBackground(new java.awt.Color(0, 201, 208));

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel38.setText("Make Inquiry");

        javax.swing.GroupLayout jPanel26Layout = new javax.swing.GroupLayout(jPanel26);
        jPanel26.setLayout(jPanel26Layout);
        jPanel26Layout.setHorizontalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel26Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel38)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel26Layout.setVerticalGroup(
            jPanel26Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel26Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel38)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(277, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addComponent(jPanel26, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout inquiryLayout = new javax.swing.GroupLayout(inquiry);
        inquiry.setLayout(inquiryLayout);
        inquiryLayout.setHorizontalGroup(
            inquiryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inquiryLayout.createSequentialGroup()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );
        inquiryLayout.setVerticalGroup(
            inquiryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inquiryLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
        );

        forms.add(inquiry, "inquiry");

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
        sidemenu.setMaximumSize(new java.awt.Dimension(330, 755));
        sidemenu.setMinimumSize(new java.awt.Dimension(330, 755));

        panelSPMSSideMenuCover.setBackground(new java.awt.Color(41, 48, 66));

        btnSPMSGenerateOfficialDocs.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSGenerateOfficialDocs.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSGenerateOfficialDocs.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSGenerateOfficialDocs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/doc.png"))); // NOI18N
        btnSPMSGenerateOfficialDocs.setText(" Generate Official Documents");
        btnSPMSGenerateOfficialDocs.setBorderPainted(false);
        btnSPMSGenerateOfficialDocs.setContentAreaFilled(false);
        btnSPMSGenerateOfficialDocs.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSGenerateOfficialDocs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSGenerateOfficialDocsActionPerformed(evt);
            }
        });

        btnSPMSSearchScedule.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSSearchScedule.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSSearchScedule.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSSearchScedule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/rsz_1time.png"))); // NOI18N
        btnSPMSSearchScedule.setText(" Search Shedule Information");
        btnSPMSSearchScedule.setBorderPainted(false);
        btnSPMSSearchScedule.setContentAreaFilled(false);
        btnSPMSSearchScedule.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSSearchScedule.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSSearchSceduleActionPerformed(evt);
            }
        });

        btnSPMSGenerateReports.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSGenerateReports.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSGenerateReports.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSGenerateReports.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/stat32.png"))); // NOI18N
        btnSPMSGenerateReports.setText(" Generate Reports & Statistics");
        btnSPMSGenerateReports.setBorderPainted(false);
        btnSPMSGenerateReports.setContentAreaFilled(false);
        btnSPMSGenerateReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSGenerateReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSGenerateReportsActionPerformed(evt);
            }
        });

        btnSPMSAnalyzePerformance.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSAnalyzePerformance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSAnalyzePerformance.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSAnalyzePerformance.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/analyse24.png"))); // NOI18N
        btnSPMSAnalyzePerformance.setText(" Analyze Student Performance");
        btnSPMSAnalyzePerformance.setBorderPainted(false);
        btnSPMSAnalyzePerformance.setContentAreaFilled(false);
        btnSPMSAnalyzePerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSAnalyzePerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSAnalyzePerformanceActionPerformed(evt);
            }
        });

        btnSPMSSearchTeacherInfo.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSSearchTeacherInfo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSSearchTeacherInfo.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSSearchTeacherInfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/teacher32.png"))); // NOI18N
        btnSPMSSearchTeacherInfo.setText("Search Teachers' Information");
        btnSPMSSearchTeacherInfo.setBorderPainted(false);
        btnSPMSSearchTeacherInfo.setContentAreaFilled(false);
        btnSPMSSearchTeacherInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSSearchTeacherInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSSearchTeacherInfoActionPerformed(evt);
            }
        });

        btnSPMSMakeInquiry.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSMakeInquiry.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSMakeInquiry.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSMakeInquiry.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/inquiry.png"))); // NOI18N
        btnSPMSMakeInquiry.setText("Make An Student Inquiry");
        btnSPMSMakeInquiry.setContentAreaFilled(false);
        btnSPMSMakeInquiry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSMakeInquiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSMakeInquiryActionPerformed(evt);
            }
        });

        btnSPMSManageProfile.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSManageProfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSManageProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSManageProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/profile.png"))); // NOI18N
        btnSPMSManageProfile.setText("Manage Student Profile Details");
        btnSPMSManageProfile.setBorderPainted(false);
        btnSPMSManageProfile.setContentAreaFilled(false);
        btnSPMSManageProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSManageProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSManageProfileActionPerformed(evt);
            }
        });

        btnSPMSProvideFeedbacks.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSProvideFeedbacks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSProvideFeedbacks.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSProvideFeedbacks.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/feedback.png"))); // NOI18N
        btnSPMSProvideFeedbacks.setText("Provide Student Feedbacks");
        btnSPMSProvideFeedbacks.setBorderPainted(false);
        btnSPMSProvideFeedbacks.setContentAreaFilled(false);
        btnSPMSProvideFeedbacks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSProvideFeedbacks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSProvideFeedbacksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSPMSSideMenuCoverLayout = new javax.swing.GroupLayout(panelSPMSSideMenuCover);
        panelSPMSSideMenuCover.setLayout(panelSPMSSideMenuCoverLayout);
        panelSPMSSideMenuCoverLayout.setHorizontalGroup(
            panelSPMSSideMenuCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSSideMenuCoverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSPMSSideMenuCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSPMSManageProfile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPMSSearchTeacherInfo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPMSProvideFeedbacks, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPMSMakeInquiry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPMSAnalyzePerformance, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPMSGenerateReports, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                    .addComponent(btnSPMSGenerateOfficialDocs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPMSSearchScedule, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelSPMSSideMenuCoverLayout.setVerticalGroup(
            panelSPMSSideMenuCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSSideMenuCoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSPMSManageProfile)
                .addGap(18, 18, 18)
                .addComponent(btnSPMSAnalyzePerformance)
                .addGap(18, 18, 18)
                .addComponent(btnSPMSGenerateReports)
                .addGap(18, 18, 18)
                .addComponent(btnSPMSGenerateOfficialDocs)
                .addGap(18, 18, 18)
                .addComponent(btnSPMSSearchScedule)
                .addGap(18, 18, 18)
                .addComponent(btnSPMSSearchTeacherInfo)
                .addGap(18, 18, 18)
                .addComponent(btnSPMSProvideFeedbacks)
                .addGap(18, 18, 18)
                .addComponent(btnSPMSMakeInquiry)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelSPMSTopLeftCover.setBackground(new java.awt.Color(41, 48, 66));

        btnSPSMhome.setBackground(new java.awt.Color(41, 48, 66));
        btnSPSMhome.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPSMhome.setForeground(new java.awt.Color(255, 255, 255));
        btnSPSMhome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/home.png"))); // NOI18N
        btnSPSMhome.setToolTipText("HOME");
        btnSPSMhome.setBorderPainted(false);
        btnSPSMhome.setContentAreaFilled(false);
        btnSPSMhome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPSMhome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPSMhomeActionPerformed(evt);
            }
        });

        btnSPMSLogout.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSLogout.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSLogout.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/lock.png"))); // NOI18N
        btnSPMSLogout.setToolTipText("LOG OUT");
        btnSPMSLogout.setBorderPainted(false);
        btnSPMSLogout.setContentAreaFilled(false);
        btnSPMSLogout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSLogoutActionPerformed(evt);
            }
        });

        btnSPMSAccount.setBackground(new java.awt.Color(41, 48, 66));
        btnSPMSAccount.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSPMSAccount.setForeground(new java.awt.Color(255, 255, 255));
        btnSPMSAccount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/behaviour.png"))); // NOI18N
        btnSPMSAccount.setToolTipText("MY ACCOUNT");
        btnSPMSAccount.setBorderPainted(false);
        btnSPMSAccount.setContentAreaFilled(false);
        btnSPMSAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSPMSAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSPMSAccountActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSPMSTopLeftCoverLayout = new javax.swing.GroupLayout(panelSPMSTopLeftCover);
        panelSPMSTopLeftCover.setLayout(panelSPMSTopLeftCoverLayout);
        panelSPMSTopLeftCoverLayout.setHorizontalGroup(
            panelSPMSTopLeftCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSTopLeftCoverLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSPSMhome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSPMSAccount)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSPMSLogout)
                .addContainerGap())
        );
        panelSPMSTopLeftCoverLayout.setVerticalGroup(
            panelSPMSTopLeftCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSTopLeftCoverLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSPMSTopLeftCoverLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnSPMSAccount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPSMhome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSPMSLogout))
                .addContainerGap())
        );

        javax.swing.GroupLayout sidemenuLayout = new javax.swing.GroupLayout(sidemenu);
        sidemenu.setLayout(sidemenuLayout);
        sidemenuLayout.setHorizontalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSPMSSideMenuCover, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelSPMSTopLeftCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        sidemenuLayout.setVerticalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addComponent(panelSPMSTopLeftCover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSPMSSideMenuCover, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(184, 184, 184))
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
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(sidemenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSPMSManageProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSManageProfileActionPerformed

        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "manageStudentDetails");


    }//GEN-LAST:event_btnSPMSManageProfileActionPerformed


    private void btnSPMSGenerateReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSGenerateReportsActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "generateReportsStat");
    }//GEN-LAST:event_btnSPMSGenerateReportsActionPerformed

    private void btnSPMSSearchSceduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSSearchSceduleActionPerformed
        ViewScheduleInfo();
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "searchShedule");
    }//GEN-LAST:event_btnSPMSSearchSceduleActionPerformed

    private void btnSPMSSearchTeacherInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSSearchTeacherInfoActionPerformed
        ViewTeacherInfo();
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "searchTeacherInfo");
    }//GEN-LAST:event_btnSPMSSearchTeacherInfoActionPerformed

    private void btnSPMSMakeInquiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSMakeInquiryActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "inquiry");
    }//GEN-LAST:event_btnSPMSMakeInquiryActionPerformed

    private void btnSPMSProvideFeedbacksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSProvideFeedbacksActionPerformed

        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "feedbacks");
    }//GEN-LAST:event_btnSPMSProvideFeedbacksActionPerformed

    private void btnSPMSGenerateOfficialDocsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSGenerateOfficialDocsActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "generateOfficialDoc");
    }//GEN-LAST:event_btnSPMSGenerateOfficialDocsActionPerformed

    private void btnSPMSAnalyzePerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSAnalyzePerformanceActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "analyzePerformance");

    }//GEN-LAST:event_btnSPMSAnalyzePerformanceActionPerformed

    private void txtIstuphoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIstuphoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIstuphoneActionPerformed

    private void txtIstuemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIstuemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIstuemailActionPerformed

    private void txtIstuClassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIstuClassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIstuClassActionPerformed

    private void gActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gActionPerformed

    }//GEN-LAST:event_gActionPerformed

    private void aActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aActionPerformed

    private void pActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pActionPerformed

    private void eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eActionPerformed

    }//GEN-LAST:event_eActionPerformed

    private void txtSearchTeachersKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchTeachersKeyReleased

        DefaultTableModel table = (DefaultTableModel) tblTeacherInfo.getModel();
        String search = txtSearchTeachers.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tblTeacherInfo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

        try {

            String pfirstName = txtSearchshedule.getText();
            obj1.getTeacherInfo(pfirstName);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_txtSearchTeachersKeyReleased

    private void txtSearchsheduleKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchsheduleKeyReleased
        DefaultTableModel table = (DefaultTableModel) tblSheduleinfo.getModel();
        String search = txtSearchshedule.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tblSheduleinfo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));

        try {
            String pclassName = txtSearchshedule.getText();
            obj1.getScheduleInfo(pclassName);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_txtSearchsheduleKeyReleased

    private void txtSmedicalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSmedicalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSmedicalKeyTyped

    private void txtSPhynameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSPhynameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSPhynameKeyTyped

    private void txtSbloodgroupKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSbloodgroupKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSbloodgroupKeyTyped

    private void txtSPhyPhoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSPhyPhoneKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSPhyPhoneKeyTyped

    private void txtPemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPemailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPemailKeyTyped

    private void txtPnicKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPnicKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPnicKeyTyped

    private void txtPlnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPlnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtPlnameKeyTyped

    private void txtPfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPfnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtPfnameKeyTyped

    private void txtPphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPphoneKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPphoneKeyTyped

    private void txtPoccupationKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPoccupationKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPoccupationKeyTyped

    private void txtSstreetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSstreetKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSstreetKeyTyped

    private void txtSemailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSemailKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSemailKeyTyped

    private void txtSstreetNoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSstreetNoKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Digits Only !");

        }
    }//GEN-LAST:event_txtSstreetNoKeyTyped

    private void txtSphoneKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSphoneKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSphoneKeyTyped

    private void txtScityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtScityKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtScityKeyTyped

    private void txtScountryKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtScountryKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtScountryKeyTyped

    private void btnSPMSPersonalAttachImgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSPersonalAttachImgActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txtSPMSPersonalImgPath.setText(filename);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblSPMSPersonalPic.getWidth(), lblSPMSPersonalPic.getHeight(), Image.SCALE_DEFAULT));
        lblSPMSPersonalPic.setIcon(imageIcon);

        try {

            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];

            for (int readNum; (readNum = fis.read(buff)) != -1;) {
                bos.write(buff, 0, readNum);

            }
            profile_pic = bos.toByteArray();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }


    }//GEN-LAST:event_btnSPMSPersonalAttachImgActionPerformed

    private void txtSfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSfnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtSfnameKeyTyped

    private void txtSlnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSlnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtSlnameKeyTyped

    private void txtSreligionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSreligionKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtSreligionKeyTyped

    private void femaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_femaleActionPerformed

    }//GEN-LAST:event_femaleActionPerformed

    private void txtSmnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSmnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtSmnameKeyTyped

    private void txt_SnationalityKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SnationalityKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txt_SnationalityKeyTyped

    private void maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maleActionPerformed

    }//GEN-LAST:event_maleActionPerformed

    private void btnRankReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRankReportActionPerformed
        HashMap fp_p1 = new HashMap();
        //fp_p1.put("pstu", txtSPMSSID.getText());
        fp_p1.put("pclass", comboClassreport.getSelectedItem().toString());
        fp_p1.put("pyear", txtyearreport.getText());
        fp_p1.put("pterm", combotermreport.getSelectedItem().toString());
        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("C:\\xampp\\htdocs\\ITP\\IREPORTS\\Ranking.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_btnRankReportActionPerformed

    private void btnBarChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBarChartActionPerformed

        try {

            int pstuRegNo = StudentInformation.stid;
            String pclass = comboClassreport.getSelectedItem().toString();
            String pyear = txtyearreport.getText();
            String pterm = combotermreport.getSelectedItem().toString();
            obj1.getExamResults(pstuRegNo, pclass, pyear, pterm);
            stotal = String.valueOf(obj1.etotal);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {

            int pstuRegNo = StudentInformation.stid;
            String pclass = comboClassreport1.getSelectedItem().toString();
            String pyear = txtyearreport.getText();
            String pterm = comboReportterm2.getSelectedItem().toString();
            obj1.getExamResults(pstuRegNo, pclass, pyear, pterm);
            stotalT2 = String.valueOf(obj1.etotal);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(Double.parseDouble(stotal), "Total Marks", combotermreport.getSelectedItem().toString());
        dataset.setValue(Double.parseDouble(stotalT2), "Total Marks", comboReportterm2.getSelectedItem().toString());

        JFreeChart chart = ChartFactory.createBarChart("Student Marks", "Subjects", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar Chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 350);

    }//GEN-LAST:event_btnBarChartActionPerformed

    private void btnPieChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPieChartActionPerformed

        try {

            int pstuRegNo = StudentInformation.stid;
            String pclass = comboClassreport.getSelectedItem().toString();
            String pyear = txtyearreport.getText();
            String pterm = combotermreport.getSelectedItem().toString();
            obj1.getExamResults(pstuRegNo, pclass, pyear, pterm);

            subj1 = obj1.esub1;
            mark1 = String.valueOf(obj1.emark1);
            subj2 = obj1.esub2;
            mark2 = String.valueOf(obj1.emark2);
            subj3 = obj1.esub3;
            mark3 = String.valueOf(obj1.emark3);
            subj4 = obj1.esub4;
            mark4 = String.valueOf(obj1.emark4);
            subj5 = obj1.esub5;
            mark5 = String.valueOf(obj1.emark5);
            subj6 = obj1.esub6;
            mark6 = String.valueOf(obj1.emark6);
            subj7 = obj1.esub7;
            mark7 = String.valueOf(obj1.emark7);
            subj8 = obj1.esub8;
            mark8 = String.valueOf(obj1.emark8);
            subj9 = obj1.esub9;
            mark9 = String.valueOf(obj1.emark9);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        DefaultPieDataset piedataset = new DefaultPieDataset();
        piedataset.setValue(subj1, new Double(mark1));
        piedataset.setValue(subj2, new Double(mark2));
        piedataset.setValue(subj3, new Double(mark3));
        piedataset.setValue(subj4, new Double(mark4));
        piedataset.setValue(subj5, new Double(mark5));
        piedataset.setValue(subj6, new Double(mark6));
        piedataset.setValue(subj7, new Double(mark7));
        piedataset.setValue(subj8, new Double(mark8));
        piedataset.setValue(subj9, new Double(mark9));

        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", piedataset, true, true, true);
        PiePlot3D p = (PiePlot3D) chart.getPlot();

        ChartFrame frame = new ChartFrame("Pie chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);

    }//GEN-LAST:event_btnPieChartActionPerformed

    private void btnStuTermlyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStuTermlyReportActionPerformed

        HashMap fp_p1 = new HashMap();
        fp_p1.put("pstu", txtSPMSSID.getText());
        fp_p1.put("pyear", txtyearreport.getText());
        fp_p1.put("pclass", comboClassreport.getSelectedItem().toString());
        fp_p1.put("pterm", combotermreport.getSelectedItem().toString());
        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("src/IREPORTS/SPMS_StudentTermlyReport.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_btnStuTermlyReportActionPerformed

    private void btnclearstuDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearstuDetailsActionPerformed

        txtSfname.setText(" ");
        lblSPMSPersonalPic.setIcon(null);
        txtSmname.setText(" ");
        txtSlname.setText(" ");
        radioclear.setSelected(true);

        Sdob.setDate(null);
        txt_Snationality.setText(" ");
        txtSreligion.setText(" ");
        txtnewpw.setText(" ");
        txtcurrentpw.setText(null);

        txtSemail.setText(" ");
        txtSphone.setText(" ");
        txtSstreetNo.setText(" ");
        txtSstreet.setText(" ");
        txtScity.setText(" ");
        txtScountry.setText(" ");

        txtPnic.setText(" ");
        txtPfname.setText(" ");
        txtPlname.setText(" ");
        txtPemail.setText(" ");
        txtPphone.setText(" ");
        txtPoccupation.setText(" ");

        Sbio.setText(" ");

        txtSPhyname.setText(" ");
        txtSPhyPhone.setText(" ");
        txtSbloodgroup.setText(" ");
        txtSmedical.setText(" ");
        txtSrestr.setText(" ");
        txtSmediother.setText(" ");


    }//GEN-LAST:event_btnclearstuDetailsActionPerformed

    private void btnSPSMhomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPSMhomeActionPerformed

        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_btnSPSMhomeActionPerformed

    private void btnSPMSAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSAccountActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "dashBoard");
    }//GEN-LAST:event_btnSPMSAccountActionPerformed

    private void btnSPMSLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSLogoutActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_btnSPMSLogoutActionPerformed

    private void btnAddFeedbackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFeedbackActionPerformed
        int confirminsert = JOptionPane.showConfirmDialog(null, "Do you really want to add this user to the system?", "Insert", JOptionPane.YES_NO_OPTION);
        if (confirminsert == 0) {

            try {

                if (e.isSelected()) {
                    feedback = "Excellent";
                }
                if (g.isSelected()) {
                    feedback = "Good";
                }
                if (a.isSelected()) {
                    feedback = "average";
                }
                if (p.isSelected()) {
                    feedback = "Poor";
                }

                String pfeedback = feedback;
                String pdate = ((JTextField) feedDate.getDateEditor().getUiComponent()).getText();
                String pteacherFname = txtTfname.getText();
                String pteacherLname = txtTlname.getText();
                String pdescription = txtDes.getText();

                obj1.addFeedback(pfeedback, pdate, pteacherFname, pteacherLname, pdescription);

                JOptionPane.showMessageDialog(null, "Record Inserted Successfully !");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }


    }//GEN-LAST:event_btnAddFeedbackActionPerformed

    private void jButton77ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton77ActionPerformed
        txtTfname.setText(" ");
        txtTlname.setText(" ");
        txtDes.setText(" ");
        feedDate.setCalendar(null);
        radioclear2.setSelected(true);
    }//GEN-LAST:event_jButton77ActionPerformed

    private void sendInquiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendInquiryActionPerformed
        int confirminsert = JOptionPane.showConfirmDialog(null, "Do you really want to add this user to the system?", "Insert", JOptionPane.YES_NO_OPTION);
        if (confirminsert == 0) {
            if (validphoneInquiry() && validemailInquiry()) {
                try {

                    int pstuRegNo = StudentInformation.stid;
                    String pclass = txtIstuClass.getText();
                    String pdate = ((JTextField) inqDate.getDateEditor().getUiComponent()).getText();
                    String pemail = txtIstuemail.getText();
                    int pphoneNo = Integer.parseInt(txtIstuphone.getText());
                    String pinquiry = txtIstuInquiry.getText();

                    obj1.addInquiry(pstuRegNo, pclass, pdate, pemail, pphoneNo, pinquiry);
                    JOptionPane.showMessageDialog(null, "Record Inserted Successfully !");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
        }
    }//GEN-LAST:event_sendInquiryActionPerformed

    private void clearInquiryFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearInquiryFormActionPerformed
        txtInstudentID.setText(" ");
        txtIstuClass.setText(" ");
        txtIstuemail.setText(" ");
        txtIstuphone.setText(" ");
        inqDate.setCalendar(null);
        txtIstuInquiry.setText(" ");


    }//GEN-LAST:event_clearInquiryFormActionPerformed

    private void btnSPMSPrintProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSPMSPrintProfileActionPerformed

        HashMap fp_p1 = new HashMap();
        fp_p1.put("pstu", txtSPMSSID.getText());

        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("src/SPMS_IREPORTS/ProfileStudent.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_btnSPMSPrintProfileActionPerformed

    private void btnViewStuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStuInfoActionPerformed
        viewStudentInfo();
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "viewStuInfo");

    }//GEN-LAST:event_btnViewStuInfoActionPerformed

    private void btnUpdateStuInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStuInfoActionPerformed
        int confirmupdate = JOptionPane.showConfirmDialog(null, "Do you really want to update this record ?", "Update", JOptionPane.YES_NO_OPTION);

        if (confirmupdate == 0) {
            if (!lblSPMSLogedin.getText().isEmpty()) {
                if (!(txtSfname.getText().isEmpty() || txtSmname.getText().isEmpty() || txtSlname.getText().isEmpty() || txtSPMSPersonalImgPath.getText().isEmpty() || txt_Snationality.getText().isEmpty() || txtSreligion.getText().isEmpty() || txtSemail.getText().isEmpty() || txtSphone.getText().isEmpty() || txtSstreetNo.getText().isEmpty() || txtSstreet.getText().isEmpty() || txtScity.getText().isEmpty() || txtScountry.getText().isEmpty() || txtPnic.getText().isEmpty() || txtPfname.getText().isEmpty() || txtPlname.getText().isEmpty() || txtPemail.getText().isEmpty() || txtPphone.getText().isEmpty() || txtPoccupation.getText().isEmpty())) {

                    if (validnicParent() && validphoneStudentInfoManage() && validphoneParent() && validphonePhy() && validemailStudentInfoManage() && validemailParent()) {

                        try {

                            String pcurrentClass = txtSPMSCurrentClass.getText();
                            String pfirstName = txtSfname.getText();
                            String pmiddleName = txtSmname.getText();
                            String plastName = txtSlname.getText();
                            String pdateOfBirth = ((JTextField) Sdob.getDateEditor().getUiComponent()).getText();

                            if (female.isSelected()) {
                                Sgender = "Female";
                            }
                            if (male.isSelected()) {
                                Sgender = "Male";
                            }

                            String pgender = Sgender;
                            String preligion = txtSreligion.getText();
                            String pnationality = txt_Snationality.getText();
                            String pemail = txtSemail.getText();
                            int pphoneNo = Integer.parseInt(txtSphone.getText());
                            String pstreetNo = txtSstreetNo.getText();
                            String pstreet = txtSstreet.getText();
                            String pcity = txtScity.getText();
                            String pcountry = txtScountry.getText();
                            String pbio = Sbio.getText();
                            byte[] pprofilePic = profile_pic;
                            String ppassword = txtcurrentpw.getText();
                            String pphysicianName = txtSPhyname.getText();
                            int pphysicianPhoneNo = Integer.parseInt(txtSPhyPhone.getText());
                            String pbloodGroup = txtSbloodgroup.getText();
                            String pphysicalRestrictions = txtSrestr.getText();
                            String pmediAlert = txtSmedical.getText();
                            String potherConditions = txtSmediother.getText();
                            String pparentNIC = txtPnic.getText();
                            String pparentFName = txtPfname.getText();
                            String pparentLName = txtPlname.getText();
                            int pparentPhoneNo = Integer.parseInt(txtPphone.getText());
                            String pparentEmail = txtPemail.getText();
                            String poccupation = txtPoccupation.getText();
                            int pRegNo = StudentInformation.stid;

                            obj1.updateProfileInfo(pcurrentClass, pfirstName, pmiddleName, plastName, pdateOfBirth, pgender, preligion, pnationality, pemail, pphoneNo, pstreetNo, pstreet, pcity, pcountry, pbio, pprofilePic, ppassword, pphysicianName, pphysicianPhoneNo, pbloodGroup, pphysicalRestrictions, pmediAlert, potherConditions, pparentNIC, pparentFName, pparentLName, pparentPhoneNo, pparentEmail, poccupation, pRegNo);
                            JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex);
                        }

                    }

                } else {
                    getToolkit().beep();
                    JOptionPane.showMessageDialog(null, "Complete all the input fields!!");
                }
            }
        }

    }//GEN-LAST:event_btnUpdateStuInfoActionPerformed

    private void txtSearchsheduleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchsheduleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchsheduleActionPerformed

    private void txtyearreportKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyearreportKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Digits Only !");

        }
    }//GEN-LAST:event_txtyearreportKeyTyped

    private void btnchangepwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnchangepwActionPerformed
        lblnewpw.setVisible(true);
        txtnewpw.setVisible(true);
        btndone.setVisible(true);
    }//GEN-LAST:event_btnchangepwActionPerformed

    private void btndoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndoneActionPerformed
        try {

            int pRegNo = StudentInformation.stid;
            String ppassword = txtnewpw.getText();
            obj1.changePassword(pRegNo, ppassword);
            JOptionPane.showMessageDialog(null, "Your Password has Changed Successfully !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btndoneActionPerformed

    private void txtyrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyrKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Digits Only !");

        }
    }//GEN-LAST:event_txtyrKeyTyped

    private void btnViewStuInfo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStuInfo1ActionPerformed

        ViewTermlyReport();

    }//GEN-LAST:event_btnViewStuInfo1ActionPerformed

    private void btnViewStuInfo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStuInfo2ActionPerformed
        ViewExtraActivityTable();
    }//GEN-LAST:event_btnViewStuInfo2ActionPerformed

    private void btnChkAvailabilityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChkAvailabilityActionPerformed
        CheckDocumentAvailability();
        if (docAvailability == false) {
            lbldocError.setVisible(true);
        }


    }//GEN-LAST:event_btnChkAvailabilityActionPerformed

    private void btnRequestDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestDocActionPerformed

        GenerateOfficialDocuments();
    }//GEN-LAST:event_btnRequestDocActionPerformed

    private void txtOStuIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOStuIDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOStuIDKeyTyped

    private void txtOClassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOClassKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOClassKeyTyped

    private void txtOFullnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOFullnameKeyTyped


    }//GEN-LAST:event_txtOFullnameKeyTyped

    private void btnClearOfficialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearOfficialActionPerformed
        txtOStuID.setText(" ");
        txtOClass.setText(" ");
        txtOTeacherFname.setText(" ");
        txtOTeacherLname.setText(" ");
        txtOFullname.setText(" ");
        txtOPathImg.setText(" ");
        txtOBio.setText(" ");
        txtOSkills.setText(" ");
        txtOIndexOL.setText(" ");
        txtOyrOL.setText(" ");
        txtOExtra.setText(" ");
        lblSPMSPhotograph.setIcon(null);
        comboSub1.setSelectedItem("<<Select Subject>>");
        comboSub2.setSelectedItem("<<Select Subject>>");
        comboSub3.setSelectedItem("<<Select Subject>>");
        comboSub4.setSelectedItem("<<Select Subject>>");
        comboSub5.setSelectedItem("<<Select Subject>>");
        comboSub6.setSelectedItem("<<Select Subject>>");
        comboSub7.setSelectedItem("<<Select Subject>>");
        comboSub8.setSelectedItem("<<Select Subject>>");
        comboSub9.setSelectedItem("<<Select Subject>>");
        comboGrade1.setSelectedItem("<<Select Grade>>");
        comboGrade2.setSelectedItem("<<Select Grade>>");
        comboGrade3.setSelectedItem("<<Select Grade>>");
        comboGrade4.setSelectedItem("<<Select Grade>>");
        comboGrade5.setSelectedItem("<<Select Grade>>");
        comboGrade6.setSelectedItem("<<Select Grade>>");
        comboGrade7.setSelectedItem("<<Select Grade>>");
        comboGrade8.setSelectedItem("<<Select Grade>>");
        comboGrade9.setSelectedItem("<<Select Grade>>");
        radioclear3.setSelected(true);
        txtODocTypeDownload.setText(" ");


    }//GEN-LAST:event_btnClearOfficialActionPerformed

    private void btnOUploadPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOUploadPhotoActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();
        txtOPathImg.setText(filename);

        ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblSPMSPhotograph.getWidth(), lblSPMSPhotograph.getHeight(), Image.SCALE_DEFAULT));
        lblSPMSPhotograph.setIcon(imageIcon);

        try {

            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buff = new byte[1024];

            for (int readNum; (readNum = fis.read(buff)) != -1;) {
                bos.write(buff, 0, readNum);

            }
            Stuphotograph = bos.toByteArray();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
    }//GEN-LAST:event_btnOUploadPhotoActionPerformed

    private void txtOTeacherFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOTeacherFnameKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtOTeacherFnameKeyTyped

    private void txtOIndexOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOIndexOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOIndexOLActionPerformed

    private void txtOyrOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOyrOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOyrOLActionPerformed

    private void comboSub1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub1ActionPerformed

    private void comboSub2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub2ActionPerformed

    private void comboSub3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub3ActionPerformed

    private void comboSub4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub4ActionPerformed

    private void comboSub5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub5ActionPerformed

    private void comboSub6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub6ActionPerformed

    private void comboSub7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub7ActionPerformed

    private void comboSub8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub8ActionPerformed

    private void comboSub9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSub9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSub9ActionPerformed

    private void btnDownloadDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDownloadDocActionPerformed
        HashMap fp_p1 = new HashMap();
        fp_p1.put("pstu", txtSPMSSID.getText());

        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("C:\\xampp\\htdocs\\ITP\\IREPORTS\\StudentOfficialDoc.jasper", fp_p1);
        showReport_fp.setVisible(true);

    }//GEN-LAST:event_btnDownloadDocActionPerformed

    private void g8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g8KeyTyped

    private void g1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g1KeyTyped

    private void g7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g7KeyTyped

    private void txtOverallGradeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOverallGradeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOverallGradeKeyTyped

    private void g2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g2KeyTyped

    private void g4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g4KeyTyped

    private void g9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g9KeyTyped

    private void g3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g3KeyTyped

    private void txtm9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtm9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtm9ActionPerformed

    private void txtavgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtavgKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtavgKeyTyped

    private void g6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g6KeyTyped

    private void g5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g5KeyTyped

    private void txttotalmarksKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalmarksKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalmarksKeyTyped

    private void btnClearReports1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearReports1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearReports1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        ViewScheduleInfo();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ViewTeacherInfo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        ViewNotices();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txtOTeacherLnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOTeacherLnameKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtOTeacherLnameKeyTyped

    private void txtOIndexOLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOIndexOLKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtOIndexOLKeyTyped

    private void txtOyrOLKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOyrOLKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Digits Only !");

        }
    }//GEN-LAST:event_txtOyrOLKeyTyped

    private void txtODocTypeDownloadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtODocTypeDownloadKeyTyped


    }//GEN-LAST:event_txtODocTypeDownloadKeyTyped

    private void txtTfnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTfnameKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtTfnameKeyTyped

    private void txtTlnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTlnameKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isLetter(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtTlnameKeyTyped

    private void txtInstudentIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstudentIDKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Letters Only !");

        }
    }//GEN-LAST:event_txtInstudentIDKeyTyped

    private void jCalendarSPMSCalendar1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jCalendarSPMSCalendar1ComponentShown
       
    }//GEN-LAST:event_jCalendarSPMSCalendar1ComponentShown
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
      
        try {
            
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageStudent.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SPMS_StudentProfileManageStudent().setVisible(true);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SPMS_StudentProfileManageStudent.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(SPMS_StudentProfileManageStudent.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane DesktopPaneSPMSProfilePic;
    private javax.swing.JDesktopPane DesktopPaneSPMSProfilePic1;
    private javax.swing.JDesktopPane DesktopPaneSPMSProfilePic3;
    private javax.swing.JPanel DownloadDocument;
    private javax.swing.JPanel GenerateDoc;
    private javax.swing.JEditorPane Sbio;
    private com.toedter.calendar.JDateChooser Sdob;
    private javax.swing.JPanel Topic;
    private javax.swing.JRadioButton a;
    private javax.swing.JTabbedPane ac;
    private javax.swing.JPanel analyzePerformance;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnAddFeedback;
    private javax.swing.JButton btnBarChart;
    private javax.swing.JButton btnChkAvailability;
    private javax.swing.JButton btnClearOfficial;
    private javax.swing.JButton btnClearReports1;
    private javax.swing.JButton btnDownloadDoc;
    private javax.swing.JButton btnOUploadPhoto;
    private javax.swing.JButton btnPieChart;
    private javax.swing.JButton btnRankReport;
    private javax.swing.JButton btnRequestDoc;
    private javax.swing.JButton btnSPMSAccount;
    private javax.swing.JButton btnSPMSAnalyzePerformance;
    private javax.swing.JButton btnSPMSGenerateOfficialDocs;
    private javax.swing.JButton btnSPMSGenerateReports;
    private javax.swing.JButton btnSPMSLogout;
    private javax.swing.JButton btnSPMSMakeInquiry;
    private javax.swing.JButton btnSPMSManageProfile;
    private javax.swing.JButton btnSPMSPersonalAttachImg;
    private javax.swing.JButton btnSPMSPrintProfile;
    private javax.swing.JButton btnSPMSProvideFeedbacks;
    private javax.swing.JButton btnSPMSSearchScedule;
    private javax.swing.JButton btnSPMSSearchTeacherInfo;
    private javax.swing.JButton btnSPSMhome;
    private javax.swing.JButton btnStuTermlyReport;
    private javax.swing.JButton btnUpdateStuInfo;
    private javax.swing.JButton btnViewStuInfo;
    private javax.swing.JButton btnViewStuInfo1;
    private javax.swing.JButton btnViewStuInfo2;
    private javax.swing.JButton btnchangepw;
    private javax.swing.JButton btnclearstuDetails;
    private javax.swing.JButton btndone;
    private javax.swing.JRadioButton characterc;
    private javax.swing.JButton clearInquiryForm;
    private javax.swing.JComboBox<String> comboClass2;
    private javax.swing.JComboBox<String> comboClassreport;
    private javax.swing.JComboBox<String> comboClassreport1;
    private javax.swing.JComboBox<String> comboGrade1;
    private javax.swing.JComboBox<String> comboGrade2;
    private javax.swing.JComboBox<String> comboGrade3;
    private javax.swing.JComboBox<String> comboGrade4;
    private javax.swing.JComboBox<String> comboGrade5;
    private javax.swing.JComboBox<String> comboGrade6;
    private javax.swing.JComboBox<String> comboGrade7;
    private javax.swing.JComboBox<String> comboGrade8;
    private javax.swing.JComboBox<String> comboGrade9;
    private javax.swing.JComboBox<String> comboReportterm2;
    private javax.swing.JComboBox<String> comboSub1;
    private javax.swing.JComboBox<String> comboSub2;
    private javax.swing.JComboBox<String> comboSub3;
    private javax.swing.JComboBox<String> comboSub4;
    private javax.swing.JComboBox<String> comboSub5;
    private javax.swing.JComboBox<String> comboSub6;
    private javax.swing.JComboBox<String> comboSub7;
    private javax.swing.JComboBox<String> comboSub8;
    private javax.swing.JComboBox<String> comboSub9;
    private javax.swing.JComboBox<String> comboterm;
    private javax.swing.JComboBox<String> combotermreport;
    private javax.swing.JPanel dashBoard;
    private javax.swing.JRadioButton e;
    private com.toedter.calendar.JDateChooser feedDate;
    private javax.swing.JPanel feedbacks;
    private javax.swing.JRadioButton female;
    private javax.swing.JPanel forms;
    private javax.swing.JRadioButton g;
    private javax.swing.JTextField g1;
    private javax.swing.JTextField g2;
    private javax.swing.JTextField g3;
    private javax.swing.JTextField g4;
    private javax.swing.JTextField g5;
    private javax.swing.JTextField g6;
    private javax.swing.JTextField g7;
    private javax.swing.JTextField g8;
    private javax.swing.JTextField g9;
    private javax.swing.JPanel generateOfficialDoc;
    private javax.swing.JPanel generateReportsStat;
    private com.toedter.calendar.JDateChooser inqDate;
    private javax.swing.JPanel inquiry;
    private javax.swing.JPanel iuds;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton77;
    private com.toedter.calendar.JCalendar jCalendarSPMSCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
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
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JPanel jPanel10;
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
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane13;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JTabbedPane jTabbedPaneSPMSAnalyze;
    private javax.swing.JTabbedPane jTabbedPaneSPMSManageProfile;
    private javax.swing.JLabel lblSPMSEmail;
    private javax.swing.JLabel lblSPMSFname;
    private javax.swing.JLabel lblSPMSGender;
    private javax.swing.JLabel lblSPMSLname;
    private javax.swing.JLabel lblSPMSLogedin;
    private javax.swing.JLabel lblSPMSPersonalPic;
    private javax.swing.JLabel lblSPMSPersonalProfilePic;
    private javax.swing.JLabel lblSPMSPhotograph;
    private javax.swing.JLabel lblSPMSProfilePic;
    private javax.swing.JLabel lblSPMSSID;
    private javax.swing.JLabel lblSPMSSID1;
    private javax.swing.JLabel lblSPMSWelcome;
    private javax.swing.JLabel lbldocError;
    private javax.swing.JLabel lblnewpw;
    private javax.swing.JLabel lblnewpw1;
    private javax.swing.JRadioButton leavingc;
    private javax.swing.JRadioButton male;
    private javax.swing.JPanel manageStudentDetails;
    private javax.swing.JRadioButton p;
    private javax.swing.JPanel panelSPMSAnalyzeCover;
    private javax.swing.JPanel panelSPMSBio;
    private javax.swing.JPanel panelSPMSCalendar1;
    private javax.swing.JPanel panelSPMSContact;
    private javax.swing.JPanel panelSPMSGenerateOfficialDoc;
    private javax.swing.JPanel panelSPMSGenerateReports;
    private javax.swing.JPanel panelSPMSManageProfileCover;
    private javax.swing.JPanel panelSPMSMedical;
    private javax.swing.JPanel panelSPMSNotices;
    private javax.swing.JPanel panelSPMSParent;
    private javax.swing.JPanel panelSPMSPersonalDetails;
    private javax.swing.JPanel panelSPMSQuickView;
    private javax.swing.JPanel panelSPMSSideMenuCover;
    private javax.swing.JPanel panelSPMSTopLeftCover;
    private javax.swing.JPanel panelSPSPersonal;
    private javax.swing.JRadioButton radioclear;
    private javax.swing.JRadioButton radioclear2;
    private javax.swing.JRadioButton radioclear3;
    private javax.swing.JLabel reqStreet;
    private javax.swing.JLabel reqcity;
    private javax.swing.JLabel reqcountry;
    private javax.swing.JLabel reqemail;
    private javax.swing.JLabel reqfname;
    private javax.swing.JLabel reqlname;
    private javax.swing.JLabel reqmname;
    private javax.swing.JLabel reqnationality;
    private javax.swing.JLabel reqpemail;
    private javax.swing.JLabel reqpfname;
    private javax.swing.JLabel reqphoneno;
    private javax.swing.JLabel reqplname;
    private javax.swing.JLabel reqpnic;
    private javax.swing.JLabel reqpoccu;
    private javax.swing.JLabel reqpphone;
    private javax.swing.JLabel reqreligion;
    private javax.swing.JLabel reqstreetNo;
    private javax.swing.JRadioButton resultssheet;
    private javax.swing.JPanel searchShedule;
    private javax.swing.JPanel searchTeachersInfo;
    private javax.swing.JButton sendInquiry;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JTable tblExtraActivity;
    private javax.swing.JTable tblSheduleinfo;
    private javax.swing.JTable tblTeacherInfo;
    private javax.swing.JTable tblnotices;
    private javax.swing.JTextArea txtDes;
    private javax.swing.JTextField txtInstudentID;
    private javax.swing.JTextField txtIstuClass;
    private javax.swing.JTextArea txtIstuInquiry;
    private javax.swing.JTextField txtIstuemail;
    private javax.swing.JTextField txtIstuphone;
    private javax.swing.JTextArea txtOBio;
    private javax.swing.JTextField txtOClass;
    private javax.swing.JTextField txtODocTypeDownload;
    private javax.swing.JTextArea txtOExtra;
    private javax.swing.JTextField txtOFullname;
    private javax.swing.JTextField txtOIndexOL;
    private javax.swing.JTextField txtOPathImg;
    private javax.swing.JTextArea txtOSkills;
    private javax.swing.JTextField txtOStuID;
    private javax.swing.JTextField txtOTeacherFname;
    private javax.swing.JTextField txtOTeacherLname;
    private javax.swing.JTextField txtOverallGrade;
    private javax.swing.JTextField txtOyrOL;
    private javax.swing.JTextField txtPemail;
    private javax.swing.JTextField txtPfname;
    private javax.swing.JTextField txtPlname;
    private javax.swing.JTextField txtPnic;
    private javax.swing.JTextField txtPoccupation;
    private javax.swing.JTextField txtPphone;
    private javax.swing.JTextField txtSPMSCurrentClass;
    private javax.swing.JTextField txtSPMSEmail;
    private javax.swing.JTextField txtSPMSFname;
    private javax.swing.JTextField txtSPMSGender;
    private javax.swing.JTextField txtSPMSLname;
    private javax.swing.JTextField txtSPMSPersonalImgPath;
    private javax.swing.JTextField txtSPMSSID;
    private javax.swing.JTextField txtSPhyPhone;
    private javax.swing.JTextField txtSPhyname;
    private javax.swing.JTextField txtSbloodgroup;
    private javax.swing.JTextField txtScity;
    private javax.swing.JTextField txtScountry;
    private javax.swing.JTextField txtSearchTeachers;
    private javax.swing.JTextField txtSearchshedule;
    private javax.swing.JTextField txtSemail;
    private javax.swing.JTextField txtSfname;
    private javax.swing.JTextField txtSlname;
    private javax.swing.JTextField txtSmedical;
    private javax.swing.JTextArea txtSmediother;
    private javax.swing.JTextField txtSmname;
    private javax.swing.JTextField txtSphone;
    private javax.swing.JTextField txtSreligion;
    private javax.swing.JTextArea txtSrestr;
    private javax.swing.JTextField txtSstreet;
    private javax.swing.JTextField txtSstreetNo;
    private javax.swing.JTextField txtTfname;
    private javax.swing.JTextField txtTlname;
    private javax.swing.JTextField txt_Snationality;
    private javax.swing.JTextField txtavg;
    private javax.swing.JPasswordField txtcurrentpw;
    private javax.swing.JTextField txtm1;
    private javax.swing.JTextField txtm2;
    private javax.swing.JTextField txtm3;
    private javax.swing.JTextField txtm4;
    private javax.swing.JTextField txtm5;
    private javax.swing.JTextField txtm6;
    private javax.swing.JTextField txtm7;
    private javax.swing.JTextField txtm8;
    private javax.swing.JTextField txtm9;
    private javax.swing.JPasswordField txtnewpw;
    private javax.swing.JTextField txts1;
    private javax.swing.JTextField txts2;
    private javax.swing.JTextField txts3;
    private javax.swing.JTextField txts4;
    private javax.swing.JTextField txts5;
    private javax.swing.JTextField txts6;
    private javax.swing.JTextField txts7;
    private javax.swing.JTextField txts8;
    private javax.swing.JTextField txts9;
    private javax.swing.JTextField txtshowClass1;
    private javax.swing.JTextField txtshowStuNo1;
    private javax.swing.JTextField txtshowTerm1;
    private javax.swing.JTextField txtshowYear1;
    private javax.swing.JTextField txttotalmarks;
    private javax.swing.JTextField txtyearreport;
    private javax.swing.JTextField txtyr;
    // End of variables declaration//GEN-END:variables

}
