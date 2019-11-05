package SchoolInformationManagementSystem;
import DBConnection.DBConnect;
import SPMS.dbConnection;

import SPMS.SPMS_DBAccess;
import SPMS.TeachersInformation;
import SPMS.dbConnection;
import SPMS_IREPORTS.IREPORT_PARAMETERIZED;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class SPMS_StudentProfileManageTeacher extends javax.swing.JFrame {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
//    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    public String url="jdbc:sqlserver://localhost:24809;databaseName=smsDB";
//    public String user="adminK";
//    public String pw="admink";

    private ImageIcon formatT = null;
    String filenameT = null;
    int sT = 0;
    byte[] profile_picT = null;
    byte[] Tphotograph = null;
    private String Tgender;
    public String docID = null;

    public String selectedStudentRegNo, selectedStudentRegNo2, selectedStudentRegNo3 = null;
    public String selectedCurrentClass, selectedCurrentClass2, selectedCurrentClass3 = null;
    public String selectedbehaviourRecordID, selectedBehaviourID, selectedBehaviourType = null;

    public double termMark1, termMark2, termMark3, termMark4, termMark5, termMark6, termMark7, termMark8, termMark9;
    public double totalMark1, totalMark2, totalMark3, totalMark4, totalMark5, totalMark6, totalMark7, totalMark8, totalMark9;
    public String subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9;
    public double assignmentScore1, assignmentScore2, assignmentScore3, assignmentScore4, assignmentScore5, assignmentScore6, assignmentScore7, assignmentScore8, assignmentScore9;
    public String AssignmentSubject1, AssignmentSubject2, AssignmentSubject3, AssignmentSubject4, AssignmentSubject5, AssignmentSubject6, AssignmentSubject7, AssignmentSubject8, AssignmentSubject9;
    public double grandTotal, FINALMARKS, average, FINALAVERAGE, ActivityMarks, FinalExamMarks;
    public String FINALGRADE, Grade1, Grade2, Grade3, Grade4, Grade5, Grade6, Grade7, Grade8, Grade9, overallGrade;

    public String sub1, sub2, sub3, sub4, sub5, sub6, sub7, sub8, sub9, countBSub1, countBSub2, countBSub3, countStu;
    public String gr1, gr2, gr3, gr4, gr5, gr6, gr7, gr8, gr9;
    public String mk1, mk2, mk3, mk4, mk5, mk6, mk7, mk8, mk9, tm, avgm, ogr;

    public String tsub1, tsub2, tsub3, tsub4, tsub5, tsub6, tsub7, tsub8, tsub9;
    public String tmark1, tmark2, tmark3, tmark4, tmark5, tmark6, tmark7, tmark8, tmark9;

    public String selectedStudentRegNoA, selectedCurrentClassA, selectedSub1A, selectedMark1A, selectedSub2A, selectedMark2A, selectedSub3A, selectedMark3A, selectedSub4A, selectedMark4A, selectedSub5A, selectedMark5A, selectedSub6A, selectedMark6A, selectedSub7A, selectedMark7A, selectedSub8A, selectedMark8A, selectedSub9A, selectedMark9A;
    public String selectedActivityName, selectedActivityMarks, selectedStudentRegNoAc, selectedCurrentClassAc;

    public String countAstu, countAstu2, countBoxing, countBadminton, countBasketball, countBowling, countChess, countCricket, countHokey, countSwimming, countTableTennis, countVolleyball;

    public ArrayList<String> activities = new ArrayList<String>();
    public ArrayList<String> activitymarks = new ArrayList<String>();

    public String[] activitiesAr = new String[activities.size()];
    public String[] activitymarksAr = new String[activitymarks.size()];

    public SPMS_DBAccess obj = new SPMS_DBAccess();

    public SPMS_StudentProfileManageTeacher() throws SQLException, ClassNotFoundException {

        initComponents();
       // conn = dbConnection.connectToDb();
//        Class.forName(driver);
//        conn=DriverManager.getConnection(url, user, pw);

        conn = DBConnect.connect();
        ViewNotices();
        FillComboSubject();
        viewStudentInfo();
        viewBehaviourStuList();
        viewBehaviourInfoList();
        viewBehaviourShowAllStudents();
        FillComboActivity();
        FillComboBehaviourTypes();
        FillComboClass();
        
        
        
          tblnotices.getTableHeader().setUI(null);
          tblnotices.setRowHeight(30);
      

        lbl_TID.setText(String.valueOf(TeachersInformation.Tid).toString());
        quickTID.setText(String.valueOf(TeachersInformation.Tid).toString());
        //lbl_displayTpic.setIcon(new ImageIcon(TeachersInformation.TPhoto.getImage().getScaledInstance(lbl_displayTpic.getWidth(), lbl_displayTpic.getHeight(), Image.SCALE_DEFAULT)));
        txtTFname.setText(String.valueOf(TeachersInformation.Tfname).toString());
        txtTLname.setText(String.valueOf(TeachersInformation.Tlname).toString());
        txtTGender.setText(String.valueOf(TeachersInformation.Tgender).toString());
        txtTEmail.setText(String.valueOf(TeachersInformation.Temail).toString());

        tblnotices.setShowGrid(false);

    }

    public void ViewNotices() {
        obj.viewNotices();
        tblnotices.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    private void FillComboSubject() {
        try {
            obj.getAllSubjects();

            int len = obj.AllSubjects.size();

            for (int i = 0; i < len; i++) {

                comboSub1.addItem(obj.AllSubjects.get(i));
                comboSub2.addItem(obj.AllSubjects.get(i));
                comboSub3.addItem(obj.AllSubjects.get(i));
                comboSub4.addItem(obj.AllSubjects.get(i));
                comboSub5.addItem(obj.AllSubjects.get(i));
                comboSub6.addItem(obj.AllSubjects.get(i));
                comboSub7.addItem(obj.AllSubjects.get(i));
                comboSub8.addItem(obj.AllSubjects.get(i));
                comboSub9.addItem(obj.AllSubjects.get(i));
                comboSubA1.addItem(obj.AllSubjects.get(i));
                comboSubA2.addItem(obj.AllSubjects.get(i));
                comboSubA3.addItem(obj.AllSubjects.get(i));
                comboSubA4.addItem(obj.AllSubjects.get(i));
                comboSubA5.addItem(obj.AllSubjects.get(i));
                comboSubA6.addItem(obj.AllSubjects.get(i));
                comboSubA7.addItem(obj.AllSubjects.get(i));
                comboSubA8.addItem(obj.AllSubjects.get(i));
                comboSubA9.addItem(obj.AllSubjects.get(i));
                comboSubReport.addItem(obj.AllSubjects.get(i));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void FillComboActivity() {
        try {
            obj.getAllActivities();

            int len2 = obj.AllActivities.size();

            for (int j = 0; j < len2; j++) {
                comboTActivity.addItem(obj.AllActivities.get(j));
                comboTActivity1.addItem(obj.AllActivities.get(j));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    private void FillComboClass() {
        try {
            obj.getAllClasses();

            int len2 = obj.AllClasses.size();
            for (int j = 0; j < len2; j++) {
                comboclassReport.addItem(obj.AllClasses.get(j));
                comboclassAc1.addItem(obj.AllClasses.get(j));
                comboclassAc2.addItem(obj.AllClasses.get(j));
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    private void FillComboBehaviourTypes() {
        try {
            obj.getAllBehaviourTypes();
            int len2 = obj.AllBehaviours.size();
            for (int j = 0; j < len2; j++) {
                comboBehaviourType.addItem(obj.AllBehaviours.get(j));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void viewStudentInfo() {
        obj.getAllStudents();
        tblStudentinfo.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void viewBehaviourStuList() {
        obj.viewStudentBehaviourRecords();
        tblBehavioutStuList.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void viewBehaviourShowAllStudents() {
        obj.viewBehaviourShowAllStudents();
        tblBehavioutStuListshowAll.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void viewBehaviourInfoList() {
        obj.viewBehaviourInfo();
        tblBehaviourInfo.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void viewRequestedDocDetails() {
        obj.viewRequestedDocInfo();
        tblrequestedDocDetails.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void showStudentsList() {
        obj.showStudentInfo();
        tblStuLIST.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void showAcademicTable() {
        obj.showAcademicInfo();
        tblAcademicData.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void showExtraCurricularTable() {
        obj.showExtraCurricularInfo();
        tblExtraC.setModel(DbUtils.resultSetToTableModel(obj.rs));

    }

    public void GenerateStudentTermReport() {
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;
            String pyear = txtyr.getText();
            String pterm = comboterm1T.getSelectedItem().toString();
            obj.getTermTestMarks(pstuRegNo, pclasss, pyear, pterm);
            termMark1 = obj.ttmark1;
            termMark2 = obj.ttmark2;
            termMark3 = obj.ttmark3;
            termMark4 = obj.ttmark4;
            termMark5 = obj.ttmark5;
            termMark6 = obj.ttmark6;
            termMark7 = obj.ttmark7;
            termMark8 = obj.ttmark8;
            termMark9 = obj.ttmark9;

            subject1 = obj.ttsub1;
            subject2 = obj.ttsub2;
            subject3 = obj.ttsub3;
            subject4 = obj.ttsub4;
            subject5 = obj.ttsub5;
            subject6 = obj.ttsub6;
            subject7 = obj.ttsub7;
            subject8 = obj.ttsub8;
            subject9 = obj.ttsub9;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;
            obj.getAssignmentScores(pstuRegNo, pclasss);
            assignmentScore1 = obj.ascore1;
            assignmentScore2 = obj.ascore2;
            assignmentScore3 = obj.ascore3;;
            assignmentScore4 = obj.ascore4;;
            assignmentScore5 = obj.ascore5;;
            assignmentScore6 = obj.ascore6;
            assignmentScore7 = obj.ascore7;
            assignmentScore8 = obj.ascore8;
            assignmentScore9 = obj.ascore9;

            AssignmentSubject1 = obj.asub1;
            AssignmentSubject2 = obj.asub2;
            AssignmentSubject3 = obj.asub3;
            AssignmentSubject4 = obj.asub4;
            AssignmentSubject5 = obj.asub5;
            AssignmentSubject6 = obj.asub6;
            AssignmentSubject7 = obj.asub7;
            AssignmentSubject8 = obj.asub8;
            AssignmentSubject9 = obj.asub9;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        totalMark1 = (termMark1 * 0.7) + (assignmentScore1 * 0.3);
        totalMark2 = (termMark2 * 0.7) + (assignmentScore2 * 0.3);
        totalMark3 = (termMark3 * 0.7) + (assignmentScore3 * 0.3);
        totalMark4 = (termMark4 * 0.7) + (assignmentScore4 * 0.3);
        totalMark5 = (termMark5 * 0.7) + (assignmentScore5 * 0.3);
        totalMark6 = (termMark6 * 0.7) + (assignmentScore6 * 0.3);
        totalMark7 = (termMark7 * 0.7) + (assignmentScore7 * 0.3);
        totalMark8 = (termMark8 * 0.7) + (assignmentScore8 * 0.3);
        totalMark9 = (termMark9 * 0.7) + (assignmentScore9 * 0.3);

        DecimalFormat df = new DecimalFormat("#.00");

        txtTotalMarks1.setText(String.valueOf(df.format(totalMark1)));
        txtTotalMarks2.setText(String.valueOf(df.format(totalMark2)));
        txtTotalMarks3.setText(String.valueOf(df.format(totalMark3)));
        txtTotalMarks4.setText(String.valueOf(df.format(totalMark4)));
        txtTotalMarks5.setText(String.valueOf(df.format(totalMark5)));
        txtTotalMarks6.setText(String.valueOf(df.format(totalMark6)));
        txtTotalMarks7.setText(String.valueOf(df.format(totalMark7)));
        txtTotalMarks8.setText(String.valueOf(df.format(totalMark8)));
        txtTotalMarks9.setText(String.valueOf(df.format(totalMark9)));

        txtTotalSub1.setText(subject1);
        txtTotalSub2.setText(subject2);
        txtTotalSub3.setText(subject3);
        txtTotalSub4.setText(subject4);
        txtTotalSub5.setText(subject5);
        txtTotalSub6.setText(subject6);
        txtTotalSub7.setText(subject7);
        txtTotalSub8.setText(subject8);
        txtTotalSub9.setText(subject9);

        txtshowStuNo1.setText(selectedStudentRegNo);
        txtshowClass1.setText(selectedCurrentClass);
        txtshowYear1.setText(txtyr.getText());
        txtshowTerm1.setText(comboterm1T.getSelectedItem().toString());

        grandTotal = totalMark1 + totalMark2 + totalMark3 + totalMark4 + totalMark5 + totalMark6 + totalMark7 + totalMark8 + totalMark9;
        average = grandTotal / 9.0;

        txttotalmarks.setText(String.valueOf(df.format(grandTotal)));
        txtavg.setText(String.valueOf(df.format(average)));

        if (totalMark1 < 35.0) {
            Grade1 = "W";
        } else if (totalMark1 >= 35.0 && totalMark1 <= 54.9) {
            Grade1 = "S";
        } else if (totalMark1 >= 55.0 && totalMark1 <= 64.9) {
            Grade1 = "C";
        } else if (totalMark1 >= 65.0 && totalMark1 <= 74.9) {
            Grade1 = "B";
        } else if (totalMark1 >= 75.0 && totalMark1 <= 89.9) {
            Grade1 = "A";
        } else if (totalMark1 >= 90.0) {
            Grade1 = "A+";
        }
        if (totalMark2 < 35.0) {
            Grade2 = "W";
        } else if (totalMark2 >= 35.0 && totalMark2 <= 54.9) {
            Grade2 = "S";
        } else if (totalMark2 >= 55.0 && totalMark2 <= 64.9) {
            Grade2 = "C";
        } else if (totalMark2 >= 65.0 && totalMark2 <= 74.9) {
            Grade2 = "B";
        } else if (totalMark2 >= 75.0 && totalMark2 <= 89.9) {
            Grade2 = "A";
        } else if (totalMark2 >= 90.0) {
            Grade2 = "A+";
        }
        if (totalMark3 < 35.0) {
            Grade3 = "W";
        } else if (totalMark3 >= 35.0 && totalMark3 <= 54.9) {
            Grade3 = "S";
        } else if (totalMark3 >= 55.0 && totalMark3 <= 64.9) {
            Grade3 = "C";
        } else if (totalMark3 >= 65.0 && totalMark3 <= 74.9) {
            Grade3 = "B";
        } else if (totalMark3 >= 75.0 && totalMark3 <= 89.9) {
            Grade3 = "A";
        } else if (totalMark3 >= 90.0) {
            Grade3 = "A+";
        }
        if (totalMark4 < 35.0) {
            Grade4 = "W";
        } else if (totalMark4 >= 35.0 && totalMark4 <= 54.9) {
            Grade4 = "S";
        } else if (totalMark4 >= 55.0 && totalMark4 <= 64.9) {
            Grade4 = "C";
        } else if (totalMark4 >= 65.0 && totalMark4 <= 74.9) {
            Grade4 = "B";
        } else if (totalMark4 >= 75.0 && totalMark4 <= 89.9) {
            Grade4 = "A";
        } else if (totalMark4 >= 90.0) {
            Grade4 = "A+";
        }
        if (totalMark5 < 35.0) {
            Grade5 = "W";
        } else if (totalMark5 >= 35.0 && totalMark5 <= 54.9) {
            Grade5 = "S";
        } else if (totalMark5 >= 55.0 && totalMark5 <= 64.9) {
            Grade5 = "C";
        } else if (totalMark5 >= 65.0 && totalMark5 <= 74.9) {
            Grade5 = "B";
        } else if (totalMark5 >= 75.0 && totalMark5 <= 89.9) {
            Grade5 = "A";
        } else if (totalMark5 >= 90.0) {
            Grade5 = "A+";
        }
        if (totalMark6 < 35.0) {
            Grade6 = "W";
        } else if (totalMark6 >= 35.0 && totalMark6 <= 54.9) {
            Grade6 = "S";
        } else if (totalMark6 >= 55.0 && totalMark6 <= 64.9) {
            Grade6 = "C";
        } else if (totalMark6 >= 65.0 && totalMark6 <= 74.9) {
            Grade6 = "B";
        } else if (totalMark6 >= 75.0 && totalMark6 <= 89.9) {
            Grade6 = "A";
        } else if (totalMark6 >= 90.0) {
            Grade6 = "A+";
        }
        if (totalMark7 < 35.0) {
            Grade7 = "W";
        } else if (totalMark7 >= 35.0 && totalMark7 <= 54.9) {
            Grade7 = "S";
        } else if (totalMark7 >= 55.0 && totalMark7 <= 64.9) {
            Grade7 = "C";
        } else if (totalMark7 >= 65.0 && totalMark7 <= 74.9) {
            Grade7 = "B";
        } else if (totalMark7 >= 75.0 && totalMark7 <= 89.9) {
            Grade7 = "A";
        } else if (totalMark7 >= 90.0) {
            Grade7 = "A+";
        }
        if (totalMark8 < 35.0) {
            Grade8 = "W";
        } else if (totalMark8 >= 35.0 && totalMark8 <= 54.9) {
            Grade8 = "S";
        } else if (totalMark8 >= 55.0 && totalMark8 <= 64.9) {
            Grade8 = "C";
        } else if (totalMark8 >= 65.0 && totalMark8 <= 74.9) {
            Grade8 = "B";
        } else if (totalMark8 >= 75.0 && totalMark8 <= 89.9) {
            Grade8 = "A";
        } else if (totalMark8 >= 90.0) {
            Grade8 = "A+";
        }
        if (totalMark9 < 35.0) {
            Grade9 = "W";
        } else if (totalMark9 >= 35.0 && totalMark9 <= 54.9) {
            Grade9 = "S";
        } else if (totalMark9 >= 55.0 && totalMark9 <= 64.9) {
            Grade9 = "C";
        } else if (totalMark9 >= 65.0 && totalMark9 <= 74.9) {
            Grade9 = "B";
        } else if (totalMark9 >= 75.0 && totalMark9 <= 89.9) {
            Grade9 = "A";
        } else if (totalMark9 >= 90.0) {
            Grade9 = "A+";
        }

        if (average < 35.0) {
            overallGrade = "W";
        } else if (average >= 35.0 && average <= 54.9) {
            overallGrade = "S";
        } else if (average >= 55.0 && average <= 64.9) {
            overallGrade = "C";
        } else if (average >= 65.0 && average <= 74.9) {
            overallGrade = "B";
        } else if (average >= 75.0 && average <= 89.9) {
            overallGrade = "A";
        } else if (average >= 90.0) {
            overallGrade = "A+";
        }

        txtOverallGrade.setText(overallGrade);
        g1.setText(Grade1);
        g2.setText(Grade2);
        g3.setText(Grade3);
        g4.setText(Grade4);
        g5.setText(Grade5);
        g6.setText(Grade6);
        g7.setText(Grade7);
        g8.setText(Grade8);
        g9.setText(Grade9);

    }

    public boolean validMarkT() {
        String markentered = "^[0-9][0-9][.][0-9][0-9]";

        Pattern patternmark = Pattern.compile(markentered, Pattern.CASE_INSENSITIVE);

        Matcher regeMatchermark1 = patternmark.matcher(txtTAMarks1.getText());
        Matcher regeMatchermark2 = patternmark.matcher(txtTAMarks2.getText());
        Matcher regeMatchermark3 = patternmark.matcher(txtTAMarks3.getText());
        Matcher regeMatchermark4 = patternmark.matcher(txtTAMarks4.getText());
        Matcher regeMatchermark5 = patternmark.matcher(txtTAMarks5.getText());
        Matcher regeMatchermark6 = patternmark.matcher(txtTAMarks6.getText());
        Matcher regeMatchermark7 = patternmark.matcher(txtTAMarks7.getText());
        Matcher regeMatchermark8 = patternmark.matcher(txtTAMarks8.getText());
        Matcher regeMatchermark9 = patternmark.matcher(txtTAMarks9.getText());

        if (!(regeMatchermark1.matches() && regeMatchermark2.matches() && regeMatchermark3.matches() && regeMatchermark4.matches() && regeMatchermark5.matches() && regeMatchermark6.matches() && regeMatchermark7.matches() && regeMatchermark8.matches() && regeMatchermark9.matches())) {

            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid Mark!");
            return false;
        } else {
            return true;
        }
    }

    public boolean validMarkA() {
        String markentered = "^[0-9][0-9][.][0-9][0-9]";

        Pattern patternmark = Pattern.compile(markentered, Pattern.CASE_INSENSITIVE);

        Matcher regeMatchermark11 = patternmark.matcher(txtTAScore1.getText());
        Matcher regeMatchermark22 = patternmark.matcher(txtTAScore2.getText());
        Matcher regeMatchermark33 = patternmark.matcher(txtTAScore3.getText());
        Matcher regeMatchermark44 = patternmark.matcher(txtTAScore4.getText());
        Matcher regeMatchermark55 = patternmark.matcher(txtTAScore5.getText());
        Matcher regeMatchermark66 = patternmark.matcher(txtTAScore6.getText());
        Matcher regeMatchermark77 = patternmark.matcher(txtTAScore7.getText());
        Matcher regeMatchermark88 = patternmark.matcher(txtTAScore8.getText());
        Matcher regeMatchermark99 = patternmark.matcher(txtTAScore9.getText());

        if (!(regeMatchermark11.matches() && regeMatchermark22.matches() && regeMatchermark33.matches() && regeMatchermark44.matches() && regeMatchermark55.matches() && regeMatchermark66.matches() && regeMatchermark77.matches() && regeMatchermark88.matches() && regeMatchermark99.matches())) {

            getToolkit().beep();
            JOptionPane.showMessageDialog(null, "Enter a valid Mark!");
            return false;
        } else {
            return true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        forms = new javax.swing.JPanel();
        dashBoard = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel134 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        txtTFname = new javax.swing.JTextField();
        jLabel131 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        txtTGender = new javax.swing.JTextField();
        lbl_TID = new javax.swing.JLabel();
        quickTID = new javax.swing.JTextField();
        jLabel130 = new javax.swing.JLabel();
        txtTEmail = new javax.swing.JTextField();
        txtTLname = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        btnPrintTProfile = new javax.swing.JButton();
        panelSPMSCalendar1 = new javax.swing.JPanel();
        jCalendarSPMSCalendar1 = new com.toedter.calendar.JCalendar();
        panelSPMSNotices = new javax.swing.JPanel();
        jScrollPane17 = new javax.swing.JScrollPane();
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
        jButton10 = new javax.swing.JButton();
        TanalyzePerformance = new javax.swing.JPanel();
        jPanel31 = new javax.swing.JPanel();
        stuListTA = new javax.swing.JTabbedPane();
        jTabbedPane4 = new javax.swing.JTabbedPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane16 = new javax.swing.JScrollPane();
        tblStuLIST = new javax.swing.JTable();
        btnViewStudentsList = new javax.swing.JButton();
        jPanel45 = new javax.swing.JPanel();
        txtshowClass2 = new javax.swing.JTextField();
        txtshowStuNo2 = new javax.swing.JTextField();
        jLabel199 = new javax.swing.JLabel();
        comboterm1T = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        txtyr = new javax.swing.JTextField();
        jLabel200 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel151 = new javax.swing.JLabel();
        comboSub9 = new javax.swing.JComboBox<>();
        txtTAMarks1 = new javax.swing.JTextField();
        jLabel154 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel94 = new javax.swing.JLabel();
        comboSub8 = new javax.swing.JComboBox<>();
        jLabel155 = new javax.swing.JLabel();
        txtTAMarks7 = new javax.swing.JTextField();
        jLabel137 = new javax.swing.JLabel();
        comboSub3 = new javax.swing.JComboBox<>();
        comboSub7 = new javax.swing.JComboBox<>();
        txtTAMarks9 = new javax.swing.JTextField();
        comboSub5 = new javax.swing.JComboBox<>();
        txtTAMarks5 = new javax.swing.JTextField();
        txtTAMarks6 = new javax.swing.JTextField();
        comboSub6 = new javax.swing.JComboBox<>();
        jLabel96 = new javax.swing.JLabel();
        comboSub2 = new javax.swing.JComboBox<>();
        txtTAMarks8 = new javax.swing.JTextField();
        txtTAMarks3 = new javax.swing.JTextField();
        jLabel149 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jLabel158 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        comboSub1 = new javax.swing.JComboBox<>();
        comboSub4 = new javax.swing.JComboBox<>();
        jLabel152 = new javax.swing.JLabel();
        txtTAMarks4 = new javax.swing.JTextField();
        jLabel148 = new javax.swing.JLabel();
        jLabel150 = new javax.swing.JLabel();
        txtTAMarks2 = new javax.swing.JTextField();
        jLabel157 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel156 = new javax.swing.JLabel();
        jLabel153 = new javax.swing.JLabel();
        iuds9 = new javax.swing.JPanel();
        btnAddTMarks = new javax.swing.JButton();
        btnUpdateTermTestMarks = new javax.swing.JButton();
        btnDeleteTermTestMarks = new javax.swing.JButton();
        btnClearTermTestMarks = new javax.swing.JButton();
        btnViewTermTestMarks = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        iuds13 = new javax.swing.JPanel();
        btnAddTAssignment = new javax.swing.JButton();
        btnUpdateAssignmentScores = new javax.swing.JButton();
        btnDeleteAssignmentScores = new javax.swing.JButton();
        btnClearAssignmentScores = new javax.swing.JButton();
        btnViewAssignmentScores = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel171 = new javax.swing.JLabel();
        comboSubA9 = new javax.swing.JComboBox<>();
        txtTAScore1 = new javax.swing.JTextField();
        jLabel172 = new javax.swing.JLabel();
        jLabel102 = new javax.swing.JLabel();
        jLabel103 = new javax.swing.JLabel();
        comboSubA8 = new javax.swing.JComboBox<>();
        jLabel173 = new javax.swing.JLabel();
        txtTAScore7 = new javax.swing.JTextField();
        jLabel174 = new javax.swing.JLabel();
        comboSubA3 = new javax.swing.JComboBox<>();
        comboSubA7 = new javax.swing.JComboBox<>();
        txtTAScore9 = new javax.swing.JTextField();
        comboSubA5 = new javax.swing.JComboBox<>();
        txtTAScore5 = new javax.swing.JTextField();
        txtTAScore6 = new javax.swing.JTextField();
        comboSubA6 = new javax.swing.JComboBox<>();
        jLabel104 = new javax.swing.JLabel();
        comboSubA2 = new javax.swing.JComboBox<>();
        txtTAScore8 = new javax.swing.JTextField();
        txtTAScore3 = new javax.swing.JTextField();
        jLabel175 = new javax.swing.JLabel();
        jLabel105 = new javax.swing.JLabel();
        jLabel176 = new javax.swing.JLabel();
        jLabel106 = new javax.swing.JLabel();
        comboSubA1 = new javax.swing.JComboBox<>();
        comboSubA4 = new javax.swing.JComboBox<>();
        jLabel177 = new javax.swing.JLabel();
        txtTAScore4 = new javax.swing.JTextField();
        jLabel178 = new javax.swing.JLabel();
        jLabel179 = new javax.swing.JLabel();
        txtTAScore2 = new javax.swing.JTextField();
        jLabel180 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jLabel181 = new javax.swing.JLabel();
        jLabel182 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel35 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel43 = new javax.swing.JPanel();
        txtTotalMarks1 = new javax.swing.JTextField();
        txtTotalSub1 = new javax.swing.JTextField();
        g8 = new javax.swing.JTextField();
        txtTotalMarks2 = new javax.swing.JTextField();
        jLabel161 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        g1 = new javax.swing.JTextField();
        jLabel100 = new javax.swing.JLabel();
        g7 = new javax.swing.JTextField();
        txtTotalMarks6 = new javax.swing.JTextField();
        txtTotalMarks5 = new javax.swing.JTextField();
        txtTotalMarks3 = new javax.swing.JTextField();
        txtOverallGrade = new javax.swing.JTextField();
        g2 = new javax.swing.JTextField();
        txtTotalSub2 = new javax.swing.JTextField();
        txtTotalSub6 = new javax.swing.JTextField();
        g4 = new javax.swing.JTextField();
        g9 = new javax.swing.JTextField();
        txtTotalSub7 = new javax.swing.JTextField();
        jLabel164 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        g3 = new javax.swing.JTextField();
        txtTotalSub9 = new javax.swing.JTextField();
        txtTotalSub4 = new javax.swing.JTextField();
        txtTotalMarks9 = new javax.swing.JTextField();
        txtTotalSub8 = new javax.swing.JTextField();
        txtavg = new javax.swing.JTextField();
        g6 = new javax.swing.JTextField();
        txtTotalMarks4 = new javax.swing.JTextField();
        txtTotalMarks7 = new javax.swing.JTextField();
        txtTotalSub3 = new javax.swing.JTextField();
        g5 = new javax.swing.JTextField();
        txttotalmarks = new javax.swing.JTextField();
        jLabel108 = new javax.swing.JLabel();
        txtTotalSub5 = new javax.swing.JTextField();
        txtTotalMarks8 = new javax.swing.JTextField();
        jLabel191 = new javax.swing.JLabel();
        txtshowStuNo1 = new javax.swing.JTextField();
        jLabel192 = new javax.swing.JLabel();
        txtshowClass1 = new javax.swing.JTextField();
        jLabel193 = new javax.swing.JLabel();
        txtshowYear1 = new javax.swing.JTextField();
        jLabel194 = new javax.swing.JLabel();
        txtshowTerm1 = new javax.swing.JTextField();
        btnGenerateTermlyReport = new javax.swing.JButton();
        btnInsertTermlyReort = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        jPanel29 = new javax.swing.JPanel();
        sg4 = new javax.swing.JTextField();
        sg5 = new javax.swing.JTextField();
        jLabel188 = new javax.swing.JLabel();
        txtshowTerm = new javax.swing.JTextField();
        sm6 = new javax.swing.JTextField();
        jLabel189 = new javax.swing.JLabel();
        sg6 = new javax.swing.JTextField();
        jLabel190 = new javax.swing.JLabel();
        ssub8 = new javax.swing.JTextField();
        jLabel183 = new javax.swing.JLabel();
        txtshowStuNo = new javax.swing.JTextField();
        jLabel187 = new javax.swing.JLabel();
        sm3 = new javax.swing.JTextField();
        ssub2 = new javax.swing.JTextField();
        ssub9 = new javax.swing.JTextField();
        sm1 = new javax.swing.JTextField();
        txttotalmarks1 = new javax.swing.JTextField();
        txtavg1 = new javax.swing.JTextField();
        sm9 = new javax.swing.JTextField();
        ssub6 = new javax.swing.JTextField();
        jLabel186 = new javax.swing.JLabel();
        ssub1 = new javax.swing.JTextField();
        sm8 = new javax.swing.JTextField();
        sg7 = new javax.swing.JTextField();
        sm2 = new javax.swing.JTextField();
        jLabel185 = new javax.swing.JLabel();
        sg2 = new javax.swing.JTextField();
        txtshowYear = new javax.swing.JTextField();
        ssub4 = new javax.swing.JTextField();
        jLabel122 = new javax.swing.JLabel();
        sm5 = new javax.swing.JTextField();
        txtOverallGrade1 = new javax.swing.JTextField();
        ssub7 = new javax.swing.JTextField();
        sm7 = new javax.swing.JTextField();
        sg3 = new javax.swing.JTextField();
        sg9 = new javax.swing.JTextField();
        sg8 = new javax.swing.JTextField();
        ssub3 = new javax.swing.JTextField();
        sg1 = new javax.swing.JTextField();
        ssub5 = new javax.swing.JTextField();
        jLabel184 = new javax.swing.JLabel();
        txtshowClass = new javax.swing.JTextField();
        jLabel132 = new javax.swing.JLabel();
        sm4 = new javax.swing.JTextField();
        btnSearchTermlyReport = new javax.swing.JButton();
        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        comboTActivity = new javax.swing.JComboBox<>();
        jLabel59 = new javax.swing.JLabel();
        TActivityDate = new com.toedter.calendar.JDateChooser();
        jScrollPane8 = new javax.swing.JScrollPane();
        TActivityDes = new javax.swing.JTextArea();
        jLabel29 = new javax.swing.JLabel();
        TActivityMarks = new javax.swing.JTextField();
        btnAddActivityRecord = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel36 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        txtFinalAvg = new javax.swing.JTextField();
        txtOg = new javax.swing.JTextField();
        jLabel123 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        txtFinalTotal = new javax.swing.JTextField();
        btnviewOverallPerformance = new javax.swing.JButton();
        jLabel159 = new javax.swing.JLabel();
        txtECAM = new javax.swing.JTextField();
        jLabel160 = new javax.swing.JLabel();
        txtExM = new javax.swing.JTextField();
        btnADDOverallPerformance = new javax.swing.JButton();
        btnClearOverall = new javax.swing.JButton();
        jPanel44 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        TaccessStuinfo = new javax.swing.JPanel();
        jPanel50 = new javax.swing.JPanel();
        jTabbedPane8 = new javax.swing.JTabbedPane();
        jPanel27 = new javax.swing.JPanel();
        jPanel32 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSearchStudent = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblStudentinfo = new javax.swing.JTable();
        jPanel19 = new javax.swing.JPanel();
        ireportstudentlistALL1 = new javax.swing.JButton();
        ireportstudentlistALL = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel51 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        manageOfficialDoc = new javax.swing.JPanel();
        jPanel52 = new javax.swing.JPanel();
        iuds10 = new javax.swing.JPanel();
        btnClearOfficialDocRequests = new javax.swing.JButton();
        jTabbedPane13 = new javax.swing.JTabbedPane();
        jTabbedPane12 = new javax.swing.JTabbedPane();
        list = new javax.swing.JPanel();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblrequestedDocDetails = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jTabbedPane5 = new javax.swing.JTabbedPane();
        jPanel38 = new javax.swing.JPanel();
        jPanel39 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        txtOFullname = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        txtOClass = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        txtOStuID = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        txtOTeacherFname = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtOTeacherLname = new javax.swing.JTextField();
        DesktopPaneSPMSProfilePic5 = new javax.swing.JDesktopPane();
        lblSPMSPhotograph2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel40 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        txtOBio = new javax.swing.JTextArea();
        jPanel41 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        txtOSkills = new javax.swing.JTextArea();
        ac = new javax.swing.JTabbedPane();
        jPanel42 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel143 = new javax.swing.JLabel();
        txtTGrade3 = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        txtTSub1 = new javax.swing.JTextField();
        jLabel138 = new javax.swing.JLabel();
        txtTGrade4 = new javax.swing.JTextField();
        txtTSub9 = new javax.swing.JTextField();
        txtTGrade9 = new javax.swing.JTextField();
        txtTGrade1 = new javax.swing.JTextField();
        txtTSub2 = new javax.swing.JTextField();
        txtTSub7 = new javax.swing.JTextField();
        txtTGrade8 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        txtTSub5 = new javax.swing.JTextField();
        jLabel142 = new javax.swing.JLabel();
        txtTGrade2 = new javax.swing.JTextField();
        txtTGrade6 = new javax.swing.JTextField();
        jLabel140 = new javax.swing.JLabel();
        jLabel141 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        txtTSub4 = new javax.swing.JTextField();
        txtTGrade5 = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel145 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        txtTGrade7 = new javax.swing.JTextField();
        txtTSub3 = new javax.swing.JTextField();
        jLabel146 = new javax.swing.JLabel();
        jLabel144 = new javax.swing.JLabel();
        txtTSub8 = new javax.swing.JTextField();
        txtTSub6 = new javax.swing.JTextField();
        jLabel135 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        txtOIndexOL = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txtOyrOL = new javax.swing.JTextField();
        jPanel20 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        txtOExtra = new javax.swing.JTextArea();
        jPanel53 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnViewOfficialDocRequests = new javax.swing.JButton();
        btnVerifyDocDetails = new javax.swing.JButton();
        Tbehaviour = new javax.swing.JPanel();
        jPanel37 = new javax.swing.JPanel();
        jTabbedPane7 = new javax.swing.JTabbedPane();
        jPanel21 = new javax.swing.JPanel();
        jPanel22 = new javax.swing.JPanel();
        jPanel25 = new javax.swing.JPanel();
        btnDeleteBehaviourStu = new javax.swing.JButton();
        btnAddBehaviourStu = new javax.swing.JButton();
        btnClearBehaviourStu = new javax.swing.JButton();
        btnUpdateBehaviourStu = new javax.swing.JButton();
        jPanel33 = new javax.swing.JPanel();
        jLabel124 = new javax.swing.JLabel();
        incidentDate = new com.toedter.calendar.JDateChooser();
        behaviourNote = new javax.swing.JScrollPane();
        txtBehavoiurNote = new javax.swing.JTextArea();
        jLabel111 = new javax.swing.JLabel();
        jLabel125 = new javax.swing.JLabel();
        comboBehaviourType = new javax.swing.JComboBox<>();
        jLabel126 = new javax.swing.JLabel();
        txtNextAction = new javax.swing.JTextField();
        jLabel112 = new javax.swing.JLabel();
        actionDate = new com.toedter.calendar.JDateChooser();
        jScrollPane12 = new javax.swing.JScrollPane();
        tblBehavioutStuList = new javax.swing.JTable();
        jLabel162 = new javax.swing.JLabel();
        txtSTID = new javax.swing.JTextField();
        jScrollPane13 = new javax.swing.JScrollPane();
        tblBehavioutStuListshowAll = new javax.swing.JTable();
        jLabel167 = new javax.swing.JLabel();
        jLabel168 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jPanel23 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblBehaviourInfo = new javax.swing.JTable();
        btnAddBehaviourType = new javax.swing.JButton();
        btnUpdateBehaviourType = new javax.swing.JButton();
        btnDeleteBehaviourType = new javax.swing.JButton();
        btnClearBehaviourType = new javax.swing.JButton();
        jLabel163 = new javax.swing.JLabel();
        txtBehaviourId = new javax.swing.JTextField();
        jLabel165 = new javax.swing.JLabel();
        txtBehaviourType = new javax.swing.JTextField();
        jLabel166 = new javax.swing.JLabel();
        ChkBoxpositive = new javax.swing.JCheckBox();
        jLabel169 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jPanel54 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        TgenerateReportsnStat = new javax.swing.JPanel();
        jPanel28 = new javax.swing.JPanel();
        jTabbedPane9 = new javax.swing.JTabbedPane();
        jTabbedPane10 = new javax.swing.JTabbedPane();
        jTabbedPane6 = new javax.swing.JTabbedPane();
        jPanel47 = new javax.swing.JPanel();
        btnViewAcademicData = new javax.swing.JButton();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblAcademicData = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jPanel24 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        btn_update2 = new javax.swing.JButton();
        txtPrecentageReport = new javax.swing.JTextField();
        btnPieChart = new javax.swing.JButton();
        btn_update1 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        txtyrreport = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        combotermReport = new javax.swing.JComboBox<>();
        jLabel201 = new javax.swing.JLabel();
        comboclassReport = new javax.swing.JComboBox<>();
        sub1l = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel204 = new javax.swing.JLabel();
        jLabel205 = new javax.swing.JLabel();
        jLabel206 = new javax.swing.JLabel();
        btn_update15 = new javax.swing.JButton();
        btnColumnChart = new javax.swing.JButton();
        jLabel203 = new javax.swing.JLabel();
        txtStuRegReport1 = new javax.swing.JTextField();
        jLabel207 = new javax.swing.JLabel();
        txtStuRegReport3 = new javax.swing.JTextField();
        comboSubReport = new javax.swing.JComboBox<>();
        btnClearReports = new javax.swing.JButton();
        jTabbedPane11 = new javax.swing.JTabbedPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel48 = new javax.swing.JPanel();
        btnViewAcademicData1 = new javax.swing.JButton();
        jScrollPane19 = new javax.swing.JScrollPane();
        tblExtraC = new javax.swing.JTable();
        jButton6 = new javax.swing.JButton();
        jPanel30 = new javax.swing.JPanel();
        btn_update10 = new javax.swing.JButton();
        btn_update11 = new javax.swing.JButton();
        btn_update12 = new javax.swing.JButton();
        btnCompareActiVsParticp = new javax.swing.JButton();
        btnReportExramComapreclasses = new javax.swing.JButton();
        selectedActivityStuRegNo = new javax.swing.JTextField();
        comboTActivity1 = new javax.swing.JComboBox<>();
        comboclassAc1 = new javax.swing.JComboBox<>();
        comboclassAc2 = new javax.swing.JComboBox<>();
        jLabel208 = new javax.swing.JLabel();
        jLabel209 = new javax.swing.JLabel();
        jLabel210 = new javax.swing.JLabel();
        jLabel202 = new javax.swing.JLabel();
        jLabel211 = new javax.swing.JLabel();
        btnClearReports1 = new javax.swing.JButton();
        jPanel55 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Topic = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        sidemenu = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButton26 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        mngprofile = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jPanel34 = new javax.swing.JPanel();
        mngprofile1 = new javax.swing.JButton();
        mngprofile3 = new javax.swing.JButton();
        mngprofile2 = new javax.swing.JButton();

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

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "ProfileQuickView", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel134.setBackground(new java.awt.Color(255, 255, 255));
        jLabel134.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel134.setText("Email :");

        jLabel133.setBackground(new java.awt.Color(255, 255, 255));
        jLabel133.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel133.setText("Title :");

        txtTFname.setEditable(false);
        txtTFname.setBackground(new java.awt.Color(255, 255, 255));
        txtTFname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel131.setBackground(new java.awt.Color(255, 255, 255));
        jLabel131.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel131.setText("Last Name :");

        jLabel128.setBackground(new java.awt.Color(255, 255, 255));
        jLabel128.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel128.setText("Welcome user :");

        txtTGender.setEditable(false);
        txtTGender.setBackground(new java.awt.Color(255, 255, 255));
        txtTGender.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        lbl_TID.setBackground(new java.awt.Color(255, 255, 255));
        lbl_TID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        quickTID.setEditable(false);
        quickTID.setBackground(new java.awt.Color(255, 255, 255));
        quickTID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        quickTID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quickTIDActionPerformed(evt);
            }
        });

        jLabel130.setBackground(new java.awt.Color(255, 255, 255));
        jLabel130.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel130.setText("First Name :");

        txtTEmail.setEditable(false);
        txtTEmail.setBackground(new java.awt.Color(255, 255, 255));
        txtTEmail.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtTLname.setEditable(false);
        txtTLname.setBackground(new java.awt.Color(255, 255, 255));
        txtTLname.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel129.setBackground(new java.awt.Color(255, 255, 255));
        jLabel129.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel129.setText("Employee ID :");

        btnPrintTProfile.setBackground(new java.awt.Color(67, 130, 180));
        btnPrintTProfile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrintTProfile.setForeground(new java.awt.Color(255, 255, 255));
        btnPrintTProfile.setText("Print Complete Profile");
        btnPrintTProfile.setBorderPainted(false);
        btnPrintTProfile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPrintTProfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintTProfileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel134, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(txtTEmail))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel128)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_TID, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel129)
                            .addComponent(jLabel130)
                            .addComponent(jLabel131)
                            .addComponent(jLabel133, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTGender, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                            .addComponent(txtTFname, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(quickTID, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTLname))))
                .addGap(6, 6, 6))
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnPrintTProfile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_TID, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel128))
                .addGap(80, 80, 80)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel129)
                    .addComponent(quickTID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel130)
                    .addComponent(txtTFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel131))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel133)
                    .addComponent(txtTGender, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel134)
                    .addComponent(txtTEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(71, 71, 71)
                .addComponent(btnPrintTProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
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
                .addComponent(jCalendarSPMSCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelSPMSCalendar1Layout.setVerticalGroup(
            panelSPMSCalendar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jCalendarSPMSCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        panelSPMSNotices.setBackground(new java.awt.Color(255, 255, 255));
        panelSPMSNotices.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Notice Board", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jScrollPane17.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane17.setBorder(null);
        jScrollPane17.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane17.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

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
        jScrollPane17.setViewportView(tblnotices);

        jButton10.setBackground(new java.awt.Color(45, 203, 112));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/if_sync_126579.png"))); // NOI18N
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSPMSNoticesLayout = new javax.swing.GroupLayout(panelSPMSNotices);
        panelSPMSNotices.setLayout(panelSPMSNoticesLayout);
        panelSPMSNoticesLayout.setHorizontalGroup(
            panelSPMSNoticesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSNoticesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 529, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSPMSNoticesLayout.setVerticalGroup(
            panelSPMSNoticesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSPMSNoticesLayout.createSequentialGroup()
                .addComponent(jButton10)
                .addContainerGap(177, Short.MAX_VALUE))
            .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout dashBoardLayout = new javax.swing.GroupLayout(dashBoard);
        dashBoard.setLayout(dashBoardLayout);
        dashBoardLayout.setHorizontalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelSPMSNotices, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSPMSCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        dashBoardLayout.setVerticalGroup(
            dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashBoardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dashBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashBoardLayout.createSequentialGroup()
                        .addComponent(panelSPMSNotices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelSPMSCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(194, Short.MAX_VALUE))
        );

        forms.add(dashBoard, "dashBoard");

        TanalyzePerformance.setBackground(new java.awt.Color(255, 255, 255));
        TanalyzePerformance.setMaximumSize(new java.awt.Dimension(1200, 600));
        TanalyzePerformance.setMinimumSize(new java.awt.Dimension(1200, 600));
        TanalyzePerformance.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel31.setBackground(new java.awt.Color(255, 255, 255));
        jPanel31.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        stuListTA.setBackground(new java.awt.Color(255, 255, 255));
        stuListTA.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 3, true));

        tblStuLIST.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblStuLIST.setModel(new javax.swing.table.DefaultTableModel(
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
                "Title", "Title"
            }
        ));
        tblStuLIST.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tblStuLIST.getTableHeader().setReorderingAllowed(false);
        tblStuLIST.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStuLISTMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(tblStuLIST);

        btnViewStudentsList.setBackground(new java.awt.Color(67, 130, 180));
        btnViewStudentsList.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewStudentsList.setForeground(new java.awt.Color(255, 255, 255));
        btnViewStudentsList.setText("VIEW Students List");
        btnViewStudentsList.setBorderPainted(false);
        btnViewStudentsList.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewStudentsList.setMaximumSize(new java.awt.Dimension(119, 25));
        btnViewStudentsList.setMinimumSize(new java.awt.Dimension(119, 25));
        btnViewStudentsList.setPreferredSize(new java.awt.Dimension(119, 25));
        btnViewStudentsList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStudentsListActionPerformed(evt);
            }
        });

        txtshowClass2.setEditable(false);

        txtshowStuNo2.setEditable(false);
        txtshowStuNo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtshowStuNo2ActionPerformed(evt);
            }
        });

        jLabel199.setBackground(java.awt.Color.white);
        jLabel199.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel199.setText("Class :");

        comboterm1T.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Term>>", "First Term", "Second Term", "Third Term" }));

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Term :");

        txtyr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtyr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyrActionPerformed(evt);
            }
        });
        txtyr.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtyrKeyTyped(evt);
            }
        });

        jLabel200.setBackground(java.awt.Color.white);
        jLabel200.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel200.setText("Student No :");

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Year :");

        javax.swing.GroupLayout jPanel45Layout = new javax.swing.GroupLayout(jPanel45);
        jPanel45.setLayout(jPanel45Layout);
        jPanel45Layout.setHorizontalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtyr, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboterm1T, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel200)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtshowStuNo2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel199)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtshowClass2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel45Layout.setVerticalGroup(
            jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel45Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel199)
                        .addComponent(txtshowClass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel45Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(jLabel36)
                        .addComponent(txtyr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboterm1T, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtshowStuNo2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel200)))
                .addContainerGap())
        );

        jButton1.setBackground(new java.awt.Color(45, 203, 112));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("RefreshTable");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(107, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnViewStudentsList, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(162, 162, 162))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnViewStudentsList, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel45, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        jTabbedPane4.addTab("Select a Student and an Examination to Perform Functions", jPanel9);

        stuListTA.addTab("Select Required Record", jTabbedPane4);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Marks Obtained for each Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel151.setBackground(java.awt.Color.white);
        jLabel151.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel151.setText("Subject :");

        comboSub9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub9ActionPerformed(evt);
            }
        });

        txtTAMarks1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks1KeyTyped(evt);
            }
        });

        jLabel154.setBackground(java.awt.Color.white);
        jLabel154.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel154.setText("Marks :");

        jLabel90.setBackground(java.awt.Color.white);
        jLabel90.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel90.setText("Marks :");

        jLabel94.setBackground(java.awt.Color.white);
        jLabel94.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel94.setText("Marks :");

        comboSub8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub8ActionPerformed(evt);
            }
        });

        jLabel155.setBackground(java.awt.Color.white);
        jLabel155.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel155.setText("Subject :");

        txtTAMarks7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks7KeyTyped(evt);
            }
        });

        jLabel137.setBackground(java.awt.Color.white);
        jLabel137.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel137.setText("Subject :");

        comboSub3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub3ActionPerformed(evt);
            }
        });

        comboSub7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub7ActionPerformed(evt);
            }
        });

        txtTAMarks9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks9KeyTyped(evt);
            }
        });

        comboSub5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub5ActionPerformed(evt);
            }
        });

        txtTAMarks5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks5KeyTyped(evt);
            }
        });

        txtTAMarks6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks6KeyTyped(evt);
            }
        });

        comboSub6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub6ActionPerformed(evt);
            }
        });

        jLabel96.setBackground(java.awt.Color.white);
        jLabel96.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel96.setText("Subject :");

        comboSub2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub2ActionPerformed(evt);
            }
        });

        txtTAMarks8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks8KeyTyped(evt);
            }
        });

        txtTAMarks3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks3KeyTyped(evt);
            }
        });

        jLabel149.setBackground(java.awt.Color.white);
        jLabel149.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel149.setText("Subject :");

        jLabel93.setBackground(java.awt.Color.white);
        jLabel93.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel93.setText("Marks :");

        jLabel158.setBackground(java.awt.Color.white);
        jLabel158.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel158.setText("Marks :");

        jLabel95.setBackground(java.awt.Color.white);
        jLabel95.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel95.setText("Subject :");

        comboSub1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub1ActionPerformed(evt);
            }
        });

        comboSub4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSub4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSub4ActionPerformed(evt);
            }
        });

        jLabel152.setBackground(java.awt.Color.white);
        jLabel152.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel152.setText("Marks :");

        txtTAMarks4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks4KeyTyped(evt);
            }
        });

        jLabel148.setBackground(java.awt.Color.white);
        jLabel148.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel148.setText("Marks :");

        jLabel150.setBackground(java.awt.Color.white);
        jLabel150.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel150.setText("Marks :");

        txtTAMarks2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAMarks2KeyTyped(evt);
            }
        });

        jLabel157.setBackground(java.awt.Color.white);
        jLabel157.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel157.setText("Subject :");

        jLabel85.setBackground(java.awt.Color.white);
        jLabel85.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel85.setText("Subject :");

        jLabel156.setBackground(java.awt.Color.white);
        jLabel156.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel156.setText("Marks :");

        jLabel153.setBackground(java.awt.Color.white);
        jLabel153.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel153.setText("Subject :");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel96)
                            .addComponent(jLabel93))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSub4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTAMarks4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel95)
                            .addComponent(jLabel94)
                            .addComponent(jLabel85)
                            .addComponent(jLabel90))
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTAMarks1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTAMarks7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTAMarks8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel151)
                        .addGap(18, 18, 18)
                        .addComponent(comboSub8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel150)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel137)
                                    .addComponent(jLabel148))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTAMarks2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtTAMarks5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addComponent(jLabel149)
                            .addGap(18, 18, 18)
                            .addComponent(comboSub5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel152)))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel155)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboSub6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel153)
                                    .addComponent(jLabel154))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSub3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTAMarks3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel158)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtTAMarks9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel157)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboSub9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel10Layout.createSequentialGroup()
                                    .addComponent(jLabel156)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtTAMarks6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                        .addGap(0, 174, Short.MAX_VALUE)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboSub7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel85))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTAMarks7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel90))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboSub8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel151)
                                    .addComponent(jLabel157)
                                    .addComponent(comboSub9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTAMarks8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel152)
                                    .addComponent(jLabel158)
                                    .addComponent(txtTAMarks9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel153)
                                    .addComponent(comboSub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTAMarks3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel154)))
                            .addGroup(jPanel10Layout.createSequentialGroup()
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboSub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel137))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTAMarks2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel148)))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(jLabel95)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel94))
                                    .addGroup(jPanel10Layout.createSequentialGroup()
                                        .addComponent(comboSub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTAMarks1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel96)
                                    .addComponent(comboSub4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel149)
                                    .addComponent(comboSub5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel155)
                                    .addComponent(comboSub6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel93)
                                    .addComponent(txtTAMarks4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel150)
                                    .addComponent(txtTAMarks5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel156)
                                    .addComponent(txtTAMarks6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );

        iuds9.setBackground(new java.awt.Color(255, 255, 255));

        btnAddTMarks.setBackground(new java.awt.Color(34, 139, 34));
        btnAddTMarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddTMarks.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTMarks.setText("Add Record");
        btnAddTMarks.setBorderPainted(false);
        btnAddTMarks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddTMarks.setMaximumSize(new java.awt.Dimension(119, 25));
        btnAddTMarks.setMinimumSize(new java.awt.Dimension(119, 25));
        btnAddTMarks.setPreferredSize(new java.awt.Dimension(119, 25));
        btnAddTMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTMarksActionPerformed(evt);
            }
        });

        btnUpdateTermTestMarks.setBackground(new java.awt.Color(191, 17, 226));
        btnUpdateTermTestMarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateTermTestMarks.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateTermTestMarks.setText("Update Record");
        btnUpdateTermTestMarks.setBorderPainted(false);
        btnUpdateTermTestMarks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateTermTestMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTermTestMarksActionPerformed(evt);
            }
        });

        btnDeleteTermTestMarks.setBackground(new java.awt.Color(220, 19, 60));
        btnDeleteTermTestMarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteTermTestMarks.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteTermTestMarks.setText("Delete Record");
        btnDeleteTermTestMarks.setBorderPainted(false);
        btnDeleteTermTestMarks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteTermTestMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTermTestMarksActionPerformed(evt);
            }
        });

        btnClearTermTestMarks.setBackground(new java.awt.Color(251, 163, 4));
        btnClearTermTestMarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearTermTestMarks.setForeground(new java.awt.Color(255, 255, 255));
        btnClearTermTestMarks.setText("Clear");
        btnClearTermTestMarks.setBorderPainted(false);
        btnClearTermTestMarks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearTermTestMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearTermTestMarksActionPerformed(evt);
            }
        });

        btnViewTermTestMarks.setBackground(new java.awt.Color(67, 130, 180));
        btnViewTermTestMarks.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewTermTestMarks.setForeground(new java.awt.Color(255, 255, 255));
        btnViewTermTestMarks.setText("View Records");
        btnViewTermTestMarks.setBorderPainted(false);
        btnViewTermTestMarks.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewTermTestMarks.setMaximumSize(new java.awt.Dimension(119, 25));
        btnViewTermTestMarks.setMinimumSize(new java.awt.Dimension(119, 25));
        btnViewTermTestMarks.setPreferredSize(new java.awt.Dimension(119, 25));
        btnViewTermTestMarks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTermTestMarksActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout iuds9Layout = new javax.swing.GroupLayout(iuds9);
        iuds9.setLayout(iuds9Layout);
        iuds9Layout.setHorizontalGroup(
            iuds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iuds9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddTMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(btnViewTermTestMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnUpdateTermTestMarks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDeleteTermTestMarks)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearTermTestMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );
        iuds9Layout.setVerticalGroup(
            iuds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iuds9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(iuds9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateTermTestMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteTermTestMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearTermTestMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewTermTestMarks, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iuds9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iuds9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Term Test Marks", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        iuds13.setBackground(new java.awt.Color(255, 255, 255));

        btnAddTAssignment.setBackground(new java.awt.Color(34, 139, 34));
        btnAddTAssignment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddTAssignment.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTAssignment.setText("ADD");
        btnAddTAssignment.setBorderPainted(false);
        btnAddTAssignment.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddTAssignment.setMaximumSize(new java.awt.Dimension(119, 25));
        btnAddTAssignment.setMinimumSize(new java.awt.Dimension(119, 25));
        btnAddTAssignment.setPreferredSize(new java.awt.Dimension(119, 25));
        btnAddTAssignment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTAssignmentActionPerformed(evt);
            }
        });

        btnUpdateAssignmentScores.setBackground(new java.awt.Color(191, 17, 226));
        btnUpdateAssignmentScores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateAssignmentScores.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateAssignmentScores.setText("UPDATE");
        btnUpdateAssignmentScores.setBorderPainted(false);
        btnUpdateAssignmentScores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateAssignmentScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAssignmentScoresActionPerformed(evt);
            }
        });

        btnDeleteAssignmentScores.setBackground(new java.awt.Color(220, 19, 60));
        btnDeleteAssignmentScores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteAssignmentScores.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteAssignmentScores.setText("DELETE");
        btnDeleteAssignmentScores.setBorderPainted(false);
        btnDeleteAssignmentScores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteAssignmentScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteAssignmentScoresActionPerformed(evt);
            }
        });

        btnClearAssignmentScores.setBackground(new java.awt.Color(251, 163, 4));
        btnClearAssignmentScores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearAssignmentScores.setForeground(new java.awt.Color(255, 255, 255));
        btnClearAssignmentScores.setText("CLEAR");
        btnClearAssignmentScores.setBorderPainted(false);
        btnClearAssignmentScores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearAssignmentScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearAssignmentScoresActionPerformed(evt);
            }
        });

        btnViewAssignmentScores.setBackground(new java.awt.Color(67, 130, 180));
        btnViewAssignmentScores.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewAssignmentScores.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAssignmentScores.setText("View Records");
        btnViewAssignmentScores.setBorderPainted(false);
        btnViewAssignmentScores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAssignmentScores.setMaximumSize(new java.awt.Dimension(119, 25));
        btnViewAssignmentScores.setMinimumSize(new java.awt.Dimension(119, 25));
        btnViewAssignmentScores.setPreferredSize(new java.awt.Dimension(119, 25));
        btnViewAssignmentScores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAssignmentScoresActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout iuds13Layout = new javax.swing.GroupLayout(iuds13);
        iuds13.setLayout(iuds13Layout);
        iuds13Layout.setHorizontalGroup(
            iuds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iuds13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAddTAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnViewAssignmentScores, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnUpdateAssignmentScores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteAssignmentScores)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearAssignmentScores, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        iuds13Layout.setVerticalGroup(
            iuds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iuds13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(iuds13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTAssignment, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateAssignmentScores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteAssignmentScores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearAssignmentScores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewAssignmentScores, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Assignment Scores for each Subject", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        jLabel171.setBackground(java.awt.Color.white);
        jLabel171.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel171.setText("Subject :");

        comboSubA9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA9ActionPerformed(evt);
            }
        });

        txtTAScore1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore1KeyTyped(evt);
            }
        });

        jLabel172.setBackground(java.awt.Color.white);
        jLabel172.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel172.setText("Score :");

        jLabel102.setBackground(java.awt.Color.white);
        jLabel102.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel102.setText("Score :");

        jLabel103.setBackground(java.awt.Color.white);
        jLabel103.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel103.setText("Score :");

        comboSubA8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA8ActionPerformed(evt);
            }
        });

        jLabel173.setBackground(java.awt.Color.white);
        jLabel173.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel173.setText("Subject :");

        txtTAScore7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore7KeyTyped(evt);
            }
        });

        jLabel174.setBackground(java.awt.Color.white);
        jLabel174.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel174.setText("Subject :");

        comboSubA3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA3ActionPerformed(evt);
            }
        });

        comboSubA7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA7ActionPerformed(evt);
            }
        });

        txtTAScore9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore9KeyTyped(evt);
            }
        });

        comboSubA5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA5ActionPerformed(evt);
            }
        });

        txtTAScore5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore5KeyTyped(evt);
            }
        });

        txtTAScore6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore6KeyTyped(evt);
            }
        });

        comboSubA6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA6ActionPerformed(evt);
            }
        });

        jLabel104.setBackground(java.awt.Color.white);
        jLabel104.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel104.setText("Subject :");

        comboSubA2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA2ActionPerformed(evt);
            }
        });

        txtTAScore8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore8KeyTyped(evt);
            }
        });

        txtTAScore3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore3KeyTyped(evt);
            }
        });

        jLabel175.setBackground(java.awt.Color.white);
        jLabel175.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel175.setText("Subject :");

        jLabel105.setBackground(java.awt.Color.white);
        jLabel105.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel105.setText("Score :");

        jLabel176.setBackground(java.awt.Color.white);
        jLabel176.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel176.setText("Score :");

        jLabel106.setBackground(java.awt.Color.white);
        jLabel106.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel106.setText("Subject :");

        comboSubA1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA1ActionPerformed(evt);
            }
        });

        comboSubA4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubA4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubA4ActionPerformed(evt);
            }
        });

        jLabel177.setBackground(java.awt.Color.white);
        jLabel177.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel177.setText("Score :");

        txtTAScore4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore4KeyTyped(evt);
            }
        });

        jLabel178.setBackground(java.awt.Color.white);
        jLabel178.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel178.setText("Score :");

        jLabel179.setBackground(java.awt.Color.white);
        jLabel179.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel179.setText("Score :");

        txtTAScore2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTAScore2KeyTyped(evt);
            }
        });

        jLabel180.setBackground(java.awt.Color.white);
        jLabel180.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel180.setText("Subject :");

        jLabel107.setBackground(java.awt.Color.white);
        jLabel107.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel107.setText("Subject :");

        jLabel181.setBackground(java.awt.Color.white);
        jLabel181.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel181.setText("Score :");

        jLabel182.setBackground(java.awt.Color.white);
        jLabel182.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel182.setText("Subject :");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel104)
                            .addComponent(jLabel105))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(comboSubA4, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTAScore4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel106)
                            .addComponent(jLabel103)
                            .addComponent(jLabel107)
                            .addComponent(jLabel102))
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSubA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTAScore1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSubA7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTAScore7, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTAScore8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel171)
                        .addGap(18, 18, 18)
                        .addComponent(comboSubA8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel179)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel174)
                                    .addComponent(jLabel178))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSubA2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTAScore2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(txtTAScore5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel15Layout.createSequentialGroup()
                            .addComponent(jLabel175)
                            .addGap(18, 18, 18)
                            .addComponent(comboSubA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel177)))
                .addGap(18, 18, 18)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(jLabel173)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboSubA6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel182)
                                    .addComponent(jLabel172))
                                .addGap(14, 14, 14)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboSubA3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTAScore3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel176)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtTAScore9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel180)
                                    .addGap(18, 18, 18)
                                    .addComponent(comboSubA9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel15Layout.createSequentialGroup()
                                    .addComponent(jLabel181)
                                    .addGap(29, 29, 29)
                                    .addComponent(txtTAScore6, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                        .addGap(0, 174, Short.MAX_VALUE)
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboSubA7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel107))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTAScore7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel102))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(comboSubA8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel171)
                                    .addComponent(jLabel180)
                                    .addComponent(comboSubA9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTAScore8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel177)
                                    .addComponent(jLabel176)
                                    .addComponent(txtTAScore9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel182)
                                    .addComponent(comboSubA3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTAScore3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel172)))
                            .addGroup(jPanel15Layout.createSequentialGroup()
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(comboSubA2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel174))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTAScore2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel178)))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(jLabel106)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel103))
                                    .addGroup(jPanel15Layout.createSequentialGroup()
                                        .addComponent(comboSubA1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtTAScore1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel104)
                                    .addComponent(comboSubA4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel175)
                                    .addComponent(comboSubA5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel173)
                                    .addComponent(comboSubA6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel105)
                                    .addComponent(txtTAScore4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel179)
                                    .addComponent(txtTAScore5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel181)
                                    .addComponent(txtTAScore6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(40, 40, 40)))
                .addContainerGap())
        );

        jLabel109.setBackground(java.awt.Color.white);
        jLabel109.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel109.setText("Please Consider the Same Order for Subject Selection.");

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel109)))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel109, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iuds13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iuds13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Manage Assignment Scores", jPanel2);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel35.setBackground(new java.awt.Color(255, 255, 255));
        jPanel35.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Termly Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        txtTotalMarks1.setEditable(false);

        txtTotalSub1.setEditable(false);

        g8.setEditable(false);
        g8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g8KeyTyped(evt);
            }
        });

        txtTotalMarks2.setEditable(false);

        jLabel161.setBackground(java.awt.Color.white);
        jLabel161.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel161.setText("Grade :");

        jLabel110.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel110.setText("Average Marks :");

        g1.setEditable(false);
        g1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g1KeyTyped(evt);
            }
        });

        jLabel100.setBackground(java.awt.Color.white);
        jLabel100.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel100.setText("Subject :");

        g7.setEditable(false);
        g7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g7KeyTyped(evt);
            }
        });

        txtTotalMarks6.setEditable(false);

        txtTotalMarks5.setEditable(false);

        txtTotalMarks3.setEditable(false);

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

        txtTotalSub2.setEditable(false);

        txtTotalSub6.setEditable(false);

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

        txtTotalSub7.setEditable(false);

        jLabel164.setBackground(java.awt.Color.white);
        jLabel164.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel164.setText("Marks :");

        jLabel117.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel117.setText("Overall Grade :");

        g3.setEditable(false);
        g3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        g3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                g3KeyTyped(evt);
            }
        });

        txtTotalSub9.setEditable(false);

        txtTotalSub4.setEditable(false);

        txtTotalMarks9.setEditable(false);
        txtTotalMarks9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalMarks9ActionPerformed(evt);
            }
        });

        txtTotalSub8.setEditable(false);

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

        txtTotalMarks4.setEditable(false);

        txtTotalMarks7.setEditable(false);

        txtTotalSub3.setEditable(false);

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

        txtTotalSub5.setEditable(false);

        txtTotalMarks8.setEditable(false);

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
                    .addComponent(txtTotalSub4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSub3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSub5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSub6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSub7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSub8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSub9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTotalSub2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel100)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel164))
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTotalMarks6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalMarks8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalMarks9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtTotalMarks3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalMarks4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalMarks5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTotalMarks7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTotalMarks1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTotalMarks2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(77, 77, 77)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel161)
                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(g1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(g9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel43Layout.createSequentialGroup()
                            .addComponent(jLabel191)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtshowStuNo1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel43Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel110)
                                            .addComponent(jLabel108))
                                        .addGap(22, 22, 22)
                                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txttotalmarks)
                                            .addComponent(txtavg, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(jLabel117)
                                        .addGap(32, 32, 32)
                                        .addComponent(txtOverallGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                .addGap(20, 20, 20))
        );
        jPanel43Layout.setVerticalGroup(
            jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel43Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addComponent(jLabel164)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txtTotalMarks2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalMarks9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel43Layout.createSequentialGroup()
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel100)
                                .addComponent(jLabel161))
                            .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtshowStuNo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel191)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addComponent(txtTotalSub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txtTotalSub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSub4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSub5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSub6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSub7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSub8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTotalSub9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel43Layout.createSequentialGroup()
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel192)
                                    .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(g1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtshowClass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(g2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtshowYear1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel193))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(g3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtshowTerm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel194))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(g5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addComponent(g6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(g9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel43Layout.createSequentialGroup()
                                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel108)
                                            .addComponent(txttotalmarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(16, 16, 16)
                                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel110)
                                            .addComponent(txtavg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel43Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel117)
                                            .addComponent(txtOverallGrade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addComponent(jPanel43, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );

        btnGenerateTermlyReport.setBackground(new java.awt.Color(67, 130, 180));
        btnGenerateTermlyReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGenerateTermlyReport.setForeground(new java.awt.Color(255, 255, 255));
        btnGenerateTermlyReport.setText("Generate");
        btnGenerateTermlyReport.setBorderPainted(false);
        btnGenerateTermlyReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGenerateTermlyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerateTermlyReportActionPerformed(evt);
            }
        });

        btnInsertTermlyReort.setBackground(new java.awt.Color(34, 139, 34));
        btnInsertTermlyReort.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnInsertTermlyReort.setForeground(new java.awt.Color(255, 255, 255));
        btnInsertTermlyReort.setText("INSERT");
        btnInsertTermlyReort.setBorderPainted(false);
        btnInsertTermlyReort.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInsertTermlyReort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertTermlyReortActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel35Layout = new javax.swing.GroupLayout(jPanel35);
        jPanel35.setLayout(jPanel35Layout);
        jPanel35Layout.setHorizontalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGenerateTermlyReport)
                    .addComponent(btnInsertTermlyReort))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel35Layout.setVerticalGroup(
            jPanel35Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel35Layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(btnGenerateTermlyReport, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnInsertTermlyReort, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel35, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Analyze Overall Progress", jPanel3);

        jPanel29.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Student Termly Report", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        sg4.setEditable(false);

        sg5.setEditable(false);

        jLabel188.setBackground(java.awt.Color.white);
        jLabel188.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel188.setText("Class :");

        txtshowTerm.setEditable(false);

        sm6.setEditable(false);

        jLabel189.setBackground(java.awt.Color.white);
        jLabel189.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel189.setText("Year :");

        sg6.setEditable(false);

        jLabel190.setBackground(java.awt.Color.white);
        jLabel190.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel190.setText("Term :");

        ssub8.setEditable(false);

        jLabel183.setBackground(java.awt.Color.white);
        jLabel183.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel183.setText("Grade :");

        txtshowStuNo.setEditable(false);

        jLabel187.setBackground(java.awt.Color.white);
        jLabel187.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel187.setText("Student No :");

        sm3.setEditable(false);

        ssub2.setEditable(false);

        ssub9.setEditable(false);

        sm1.setEditable(false);

        txttotalmarks1.setEditable(false);
        txttotalmarks1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txttotalmarks1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttotalmarks1ActionPerformed(evt);
            }
        });
        txttotalmarks1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txttotalmarks1KeyTyped(evt);
            }
        });

        txtavg1.setEditable(false);
        txtavg1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtavg1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtavg1KeyTyped(evt);
            }
        });

        sm9.setEditable(false);

        ssub6.setEditable(false);

        jLabel186.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel186.setText("Overall Grade :");

        ssub1.setEditable(false);

        sm8.setEditable(false);

        sg7.setEditable(false);

        sm2.setEditable(false);

        jLabel185.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel185.setText("Average Marks :");

        sg2.setEditable(false);

        txtshowYear.setEditable(false);

        ssub4.setEditable(false);

        jLabel122.setBackground(java.awt.Color.white);
        jLabel122.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel122.setText("Subject :");

        sm5.setEditable(false);

        txtOverallGrade1.setEditable(false);
        txtOverallGrade1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOverallGrade1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOverallGrade1KeyTyped(evt);
            }
        });

        ssub7.setEditable(false);

        sm7.setEditable(false);

        sg3.setEditable(false);

        sg9.setEditable(false);

        sg8.setEditable(false);

        ssub3.setEditable(false);

        sg1.setEditable(false);

        ssub5.setEditable(false);

        jLabel184.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel184.setText("Total Marks :");

        txtshowClass.setEditable(false);

        jLabel132.setBackground(java.awt.Color.white);
        jLabel132.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel132.setText("Marks :");

        sm4.setEditable(false);

        javax.swing.GroupLayout jPanel29Layout = new javax.swing.GroupLayout(jPanel29);
        jPanel29.setLayout(jPanel29Layout);
        jPanel29Layout.setHorizontalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ssub1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel122)
                    .addComponent(ssub9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssub8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssub7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssub6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssub5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssub4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssub3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ssub2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sm1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel132)
                    .addComponent(sm9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sm2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sg9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sg8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sg7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sg6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sg1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel183)
                    .addComponent(sg3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sg2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sg4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sg5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel187)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtshowStuNo, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel188)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtshowClass, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel189)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtshowYear, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel190)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtshowTerm, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel185)
                            .addComponent(jLabel184)
                            .addComponent(jLabel186))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txttotalmarks1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtavg1)
                            .addComponent(txtOverallGrade1))))
                .addContainerGap())
        );
        jPanel29Layout.setVerticalGroup(
            jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel29Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel122)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ssub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ssub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ssub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ssub5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(ssub4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ssub6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ssub7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ssub8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ssub9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel132)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sm1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sm2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sm3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sm4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(sm5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sm6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sm7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sm8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sm9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel29Layout.createSequentialGroup()
                        .addComponent(jLabel183)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(sg2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(sg3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sg4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(sg5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel29Layout.createSequentialGroup()
                                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtshowStuNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel187))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtshowClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14))
                                    .addGroup(jPanel29Layout.createSequentialGroup()
                                        .addComponent(jLabel188)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtshowYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel189))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel190)
                                    .addComponent(txtshowTerm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addComponent(sg6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sg7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sg8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sg9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel29Layout.createSequentialGroup()
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel184)
                                    .addComponent(txttotalmarks1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(16, 16, 16)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel185)
                                    .addComponent(txtavg1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel29Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel186)
                                    .addComponent(txtOverallGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSearchTermlyReport.setBackground(new java.awt.Color(67, 130, 180));
        btnSearchTermlyReport.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSearchTermlyReport.setForeground(new java.awt.Color(255, 255, 255));
        btnSearchTermlyReport.setText("VIEW");
        btnSearchTermlyReport.setBorderPainted(false);
        btnSearchTermlyReport.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSearchTermlyReport.setMaximumSize(new java.awt.Dimension(119, 25));
        btnSearchTermlyReport.setMinimumSize(new java.awt.Dimension(119, 25));
        btnSearchTermlyReport.setPreferredSize(new java.awt.Dimension(119, 25));
        btnSearchTermlyReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchTermlyReportActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSearchTermlyReport, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel29, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnSearchTermlyReport, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("View Term Report Records", jPanel18);

        stuListTA.addTab("Manage Students' Academic Records", jTabbedPane1);

        jTabbedPane3.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Extracurricular Activities", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Activity :");

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Date:");

        comboTActivity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Activity>>" }));

        jLabel59.setBackground(new java.awt.Color(255, 255, 255));
        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setText("Description :");

        TActivityDate.setBackground(new java.awt.Color(255, 255, 255));
        TActivityDate.setDateFormatString("yyyy-MM-dd");

        TActivityDes.setColumns(20);
        TActivityDes.setRows(5);
        jScrollPane8.setViewportView(TActivityDes);

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Marks Obtained :");

        TActivityMarks.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TActivityMarksKeyTyped(evt);
            }
        });

        btnAddActivityRecord.setBackground(new java.awt.Color(34, 139, 34));
        btnAddActivityRecord.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddActivityRecord.setForeground(new java.awt.Color(255, 255, 255));
        btnAddActivityRecord.setText("ADD");
        btnAddActivityRecord.setBorderPainted(false);
        btnAddActivityRecord.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddActivityRecord.setMaximumSize(new java.awt.Dimension(119, 25));
        btnAddActivityRecord.setMinimumSize(new java.awt.Dimension(119, 25));
        btnAddActivityRecord.setPreferredSize(new java.awt.Dimension(119, 25));
        btnAddActivityRecord.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActivityRecordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(74, 74, 74)
                                .addComponent(comboTActivity, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel28))
                                .addGap(52, 52, 52)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(TActivityMarks, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TActivityDate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))))
                            .addComponent(jLabel29)))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(btnAddActivityRecord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(255, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(comboTActivity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel28)
                    .addComponent(TActivityDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(TActivityMarks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel59)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAddActivityRecord, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("Track Performance, Tallents & Achievements", jPanel4);

        stuListTA.addTab("Manage Students' Extacurricular Records", jTabbedPane3);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel36.setBackground(new java.awt.Color(255, 255, 255));
        jPanel36.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Overall Performance", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel121.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel121.setText("Average Marks :");

        txtFinalAvg.setEditable(false);
        txtFinalAvg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFinalAvg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFinalAvgKeyTyped(evt);
            }
        });

        txtOg.setEditable(false);
        txtOg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOgKeyTyped(evt);
            }
        });

        jLabel123.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel123.setText("Overall Grade :");

        jLabel127.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel127.setText("Final Marks :");

        txtFinalTotal.setEditable(false);
        txtFinalTotal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtFinalTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFinalTotalKeyTyped(evt);
            }
        });

        btnviewOverallPerformance.setBackground(new java.awt.Color(67, 130, 180));
        btnviewOverallPerformance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnviewOverallPerformance.setForeground(new java.awt.Color(255, 255, 255));
        btnviewOverallPerformance.setText("VIEW Overall Performance");
        btnviewOverallPerformance.setBorderPainted(false);
        btnviewOverallPerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnviewOverallPerformance.setMaximumSize(new java.awt.Dimension(119, 25));
        btnviewOverallPerformance.setMinimumSize(new java.awt.Dimension(119, 25));
        btnviewOverallPerformance.setPreferredSize(new java.awt.Dimension(119, 25));
        btnviewOverallPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnviewOverallPerformanceActionPerformed(evt);
            }
        });

        jLabel159.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel159.setText("ECA Marks :");
        jLabel159.setToolTipText("Extracurricular Activities Marks");

        txtECAM.setEditable(false);
        txtECAM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel160.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel160.setText("Exam Marks :");

        txtExM.setEditable(false);
        txtExM.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtExM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtExMKeyTyped(evt);
            }
        });

        btnADDOverallPerformance.setBackground(new java.awt.Color(34, 139, 34));
        btnADDOverallPerformance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnADDOverallPerformance.setForeground(new java.awt.Color(255, 255, 255));
        btnADDOverallPerformance.setText("ADD Overall Performance");
        btnADDOverallPerformance.setBorderPainted(false);
        btnADDOverallPerformance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnADDOverallPerformance.setMaximumSize(new java.awt.Dimension(119, 25));
        btnADDOverallPerformance.setMinimumSize(new java.awt.Dimension(119, 25));
        btnADDOverallPerformance.setPreferredSize(new java.awt.Dimension(119, 25));
        btnADDOverallPerformance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDOverallPerformanceActionPerformed(evt);
            }
        });

        btnClearOverall.setBackground(new java.awt.Color(251, 163, 4));
        btnClearOverall.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearOverall.setForeground(new java.awt.Color(255, 255, 255));
        btnClearOverall.setText("CLEAR");
        btnClearOverall.setBorderPainted(false);
        btnClearOverall.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearOverall.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearOverallActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel36Layout = new javax.swing.GroupLayout(jPanel36);
        jPanel36.setLayout(jPanel36Layout);
        jPanel36Layout.setHorizontalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel160, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(txtExM, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel159)
                                .addGap(34, 34, 34)
                                .addComponent(txtECAM, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel36Layout.createSequentialGroup()
                                .addComponent(jLabel121)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtFinalAvg))
                            .addComponent(jLabel127)
                            .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtFinalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel36Layout.createSequentialGroup()
                                    .addComponent(jLabel123)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtOg, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnClearOverall, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 56, Short.MAX_VALUE)
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnADDOverallPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnviewOverallPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(61, Short.MAX_VALUE))))
        );
        jPanel36Layout.setVerticalGroup(
            jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel36Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel160)
                    .addComponent(txtExM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtECAM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel159))
                .addGap(28, 28, 28)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel127)
                    .addComponent(txtFinalTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel121)
                    .addComponent(txtFinalAvg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addComponent(btnviewOverallPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnADDOverallPerformance, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel36Layout.createSequentialGroup()
                        .addGroup(jPanel36Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel123))
                        .addGap(26, 26, 26)
                        .addComponent(btnClearOverall, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(184, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jPanel36, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        stuListTA.addTab("Analyze  Overall Performance", jPanel5);

        jPanel44.setBackground(new java.awt.Color(0, 201, 208));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel3.setText("Analyze Performance");

        javax.swing.GroupLayout jPanel44Layout = new javax.swing.GroupLayout(jPanel44);
        jPanel44.setLayout(jPanel44Layout);
        jPanel44Layout.setHorizontalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel44Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel44Layout.setVerticalGroup(
            jPanel44Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel44Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel31Layout = new javax.swing.GroupLayout(jPanel31);
        jPanel31.setLayout(jPanel31Layout);
        jPanel31Layout.setHorizontalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel44, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel31Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stuListTA)
                .addContainerGap())
        );
        jPanel31Layout.setVerticalGroup(
            jPanel31Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel31Layout.createSequentialGroup()
                .addComponent(jPanel44, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(stuListTA, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout TanalyzePerformanceLayout = new javax.swing.GroupLayout(TanalyzePerformance);
        TanalyzePerformance.setLayout(TanalyzePerformanceLayout);
        TanalyzePerformanceLayout.setHorizontalGroup(
            TanalyzePerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TanalyzePerformanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        TanalyzePerformanceLayout.setVerticalGroup(
            TanalyzePerformanceLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TanalyzePerformanceLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel31, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(140, Short.MAX_VALUE))
        );

        forms.add(TanalyzePerformance, "Tanalyze");

        TaccessStuinfo.setBackground(new java.awt.Color(255, 255, 255));
        TaccessStuinfo.setMaximumSize(new java.awt.Dimension(1200, 600));
        TaccessStuinfo.setMinimumSize(new java.awt.Dimension(1200, 600));
        TaccessStuinfo.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel50.setBackground(new java.awt.Color(255, 255, 255));
        jPanel50.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPane8.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 3, true));

        jPanel27.setBackground(new java.awt.Color(255, 255, 255));

        jPanel32.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel32Layout = new javax.swing.GroupLayout(jPanel32);
        jPanel32.setLayout(jPanel32Layout);
        jPanel32Layout.setHorizontalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 472, Short.MAX_VALUE)
        );
        jPanel32Layout.setVerticalGroup(
            jPanel32Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 477, Short.MAX_VALUE)
        );

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Enter Student ID  search Student Info");

        txtSearchStudent.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtSearchStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchStudentKeyReleased(evt);
            }
        });

        jScrollPane7.setBackground(new java.awt.Color(255, 255, 255));

        tblStudentinfo.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(tblStudentinfo);

        ireportstudentlistALL1.setBackground(new java.awt.Color(67, 130, 180));
        ireportstudentlistALL1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ireportstudentlistALL1.setForeground(new java.awt.Color(255, 255, 255));
        ireportstudentlistALL1.setText("VIEW Student Details ");
        ireportstudentlistALL1.setIconTextGap(14);
        ireportstudentlistALL1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ireportstudentlistALL1ActionPerformed(evt);
            }
        });

        ireportstudentlistALL.setBackground(new java.awt.Color(67, 130, 180));
        ireportstudentlistALL.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ireportstudentlistALL.setForeground(new java.awt.Color(255, 255, 255));
        ireportstudentlistALL.setText("VIEW Student List Report ");
        ireportstudentlistALL.setIconTextGap(14);
        ireportstudentlistALL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ireportstudentlistALLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(ireportstudentlistALL)
                .addGap(58, 58, 58)
                .addComponent(ireportstudentlistALL1)
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ireportstudentlistALL1)
                    .addComponent(ireportstudentlistALL))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton3.setBackground(new java.awt.Color(45, 203, 112));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("RefreshTable");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel27Layout = new javax.swing.GroupLayout(jPanel27);
        jPanel27.setLayout(jPanel27Layout);
        jPanel27Layout.setHorizontalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel27Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel27Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton3))
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel27Layout.setVerticalGroup(
            jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel27Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3)
                    .addGroup(jPanel27Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtSearchStudent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(169, 169, 169)
                .addComponent(jPanel32, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane8.addTab("Search Record", jPanel27);

        jPanel51.setBackground(new java.awt.Color(0, 201, 208));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("Search Student Information");

        javax.swing.GroupLayout jPanel51Layout = new javax.swing.GroupLayout(jPanel51);
        jPanel51.setLayout(jPanel51Layout);
        jPanel51Layout.setHorizontalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel51Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel51Layout.setVerticalGroup(
            jPanel51Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel51Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel50Layout = new javax.swing.GroupLayout(jPanel50);
        jPanel50.setLayout(jPanel50Layout);
        jPanel50Layout.setHorizontalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel50Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );
        jPanel50Layout.setVerticalGroup(
            jPanel50Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel50Layout.createSequentialGroup()
                .addComponent(jPanel51, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TaccessStuinfoLayout = new javax.swing.GroupLayout(TaccessStuinfo);
        TaccessStuinfo.setLayout(TaccessStuinfoLayout);
        TaccessStuinfoLayout.setHorizontalGroup(
            TaccessStuinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaccessStuinfoLayout.createSequentialGroup()
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 210, Short.MAX_VALUE))
        );
        TaccessStuinfoLayout.setVerticalGroup(
            TaccessStuinfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaccessStuinfoLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(234, Short.MAX_VALUE))
        );

        forms.add(TaccessStuinfo, "TsearchStudent");

        manageOfficialDoc.setBackground(new java.awt.Color(255, 255, 255));
        manageOfficialDoc.setMaximumSize(new java.awt.Dimension(1200, 600));
        manageOfficialDoc.setMinimumSize(new java.awt.Dimension(1200, 600));
        manageOfficialDoc.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel52.setBackground(new java.awt.Color(255, 255, 255));
        jPanel52.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        iuds10.setBackground(new java.awt.Color(255, 255, 255));

        btnClearOfficialDocRequests.setBackground(new java.awt.Color(251, 163, 4));
        btnClearOfficialDocRequests.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearOfficialDocRequests.setForeground(new java.awt.Color(255, 255, 255));
        btnClearOfficialDocRequests.setText("CLEAR");
        btnClearOfficialDocRequests.setBorderPainted(false);
        btnClearOfficialDocRequests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearOfficialDocRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearOfficialDocRequestsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout iuds10Layout = new javax.swing.GroupLayout(iuds10);
        iuds10.setLayout(iuds10Layout);
        iuds10Layout.setHorizontalGroup(
            iuds10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iuds10Layout.createSequentialGroup()
                .addContainerGap(679, Short.MAX_VALUE)
                .addComponent(btnClearOfficialDocRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(117, 117, 117))
        );
        iuds10Layout.setVerticalGroup(
            iuds10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(iuds10Layout.createSequentialGroup()
                .addComponent(btnClearOfficialDocRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 47, Short.MAX_VALUE))
        );

        jTabbedPane13.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        jTabbedPane12.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane12.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 2, true));

        tblrequestedDocDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblrequestedDocDetails.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "Date", "Alert"
            }
        ));
        tblrequestedDocDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tblrequestedDocDetails.getTableHeader().setReorderingAllowed(false);
        tblrequestedDocDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblrequestedDocDetailsMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblrequestedDocDetails);

        jButton4.setBackground(new java.awt.Color(45, 203, 112));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("RefreshTable");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout listLayout = new javax.swing.GroupLayout(list);
        list.setLayout(listLayout);
        listLayout.setHorizontalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listLayout.createSequentialGroup()
                        .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, listLayout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addGap(37, 37, 37))))
        );
        listLayout.setVerticalGroup(
            listLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(listLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane12.addTab("List of Requested Documents", list);

        jTabbedPane5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel38.setBackground(new java.awt.Color(255, 255, 255));

        jPanel39.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Student's Full Name :");

        txtOFullname.setEditable(false);
        txtOFullname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOFullname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOFullnameKeyTyped(evt);
            }
        });

        jLabel31.setBackground(new java.awt.Color(255, 255, 255));
        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Class :");

        txtOClass.setEditable(false);
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

        jLabel32.setBackground(new java.awt.Color(255, 255, 255));
        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Class Teacher's First Name :");

        txtOTeacherFname.setEditable(false);
        txtOTeacherFname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtOTeacherFname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOTeacherFnameKeyTyped(evt);
            }
        });

        jLabel33.setBackground(new java.awt.Color(255, 255, 255));
        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel33.setText("Class Teacher's Last Name :");

        txtOTeacherLname.setEditable(false);
        txtOTeacherLname.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel39Layout = new javax.swing.GroupLayout(jPanel39);
        jPanel39.setLayout(jPanel39Layout);
        jPanel39Layout.setHorizontalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel39Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel30)
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel26)
                        .addGap(116, 116, 116)
                        .addComponent(txtOStuID))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addGap(27, 27, 27)
                        .addComponent(txtOTeacherLname))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31)
                            .addComponent(jLabel32))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtOTeacherFname)
                            .addComponent(txtOClass)))
                    .addGroup(jPanel39Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(txtOFullname, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel39Layout.setVerticalGroup(
            jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel39Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtOStuID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtOClass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtOTeacherFname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOTeacherLname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGap(12, 12, 12)
                .addGroup(jPanel39Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(txtOFullname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(120, 120, 120))
        );

        DesktopPaneSPMSProfilePic5.setLayer(lblSPMSPhotograph2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout DesktopPaneSPMSProfilePic5Layout = new javax.swing.GroupLayout(DesktopPaneSPMSProfilePic5);
        DesktopPaneSPMSProfilePic5.setLayout(DesktopPaneSPMSProfilePic5Layout);
        DesktopPaneSPMSProfilePic5Layout.setHorizontalGroup(
            DesktopPaneSPMSProfilePic5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePic5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSPhotograph2, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                .addContainerGap())
        );
        DesktopPaneSPMSProfilePic5Layout.setVerticalGroup(
            DesktopPaneSPMSProfilePic5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DesktopPaneSPMSProfilePic5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSPMSPhotograph2, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Student's Recent Photograph");

        javax.swing.GroupLayout jPanel38Layout = new javax.swing.GroupLayout(jPanel38);
        jPanel38.setLayout(jPanel38Layout);
        jPanel38Layout.setHorizontalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(DesktopPaneSPMSProfilePic5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(136, Short.MAX_VALUE))
        );
        jPanel38Layout.setVerticalGroup(
            jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel38Layout.createSequentialGroup()
                .addGroup(jPanel38Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel39, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel38Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9)
                        .addGap(15, 15, 15)
                        .addComponent(DesktopPaneSPMSProfilePic5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(54, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Student Details", jPanel38);

        jPanel40.setBackground(java.awt.Color.white);

        jScrollPane10.setBackground(java.awt.Color.white);

        txtOBio.setEditable(false);
        txtOBio.setColumns(20);
        txtOBio.setRows(5);
        jScrollPane10.setViewportView(txtOBio);

        javax.swing.GroupLayout jPanel40Layout = new javax.swing.GroupLayout(jPanel40);
        jPanel40.setLayout(jPanel40Layout);
        jPanel40Layout.setHorizontalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel40Layout.setVerticalGroup(
            jPanel40Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel40Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Bio", jPanel40);

        jPanel41.setBackground(java.awt.Color.white);

        jScrollPane11.setBackground(java.awt.Color.white);

        txtOSkills.setEditable(false);
        txtOSkills.setColumns(20);
        txtOSkills.setRows(5);
        jScrollPane11.setViewportView(txtOSkills);

        javax.swing.GroupLayout jPanel41Layout = new javax.swing.GroupLayout(jPanel41);
        jPanel41.setLayout(jPanel41Layout);
        jPanel41Layout.setHorizontalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel41Layout.setVerticalGroup(
            jPanel41Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel41Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane5.addTab("Skills and Interests", jPanel41);

        jTabbedPane12.addTab("Student Information", jTabbedPane5);

        ac.setBackground(java.awt.Color.white);

        jPanel42.setBackground(java.awt.Color.white);

        jPanel16.setBackground(java.awt.Color.white);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel143.setBackground(java.awt.Color.white);
        jLabel143.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel143.setText("Grade :");

        txtTGrade3.setEditable(false);

        jLabel84.setBackground(java.awt.Color.white);
        jLabel84.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel84.setText("Subject :");

        jLabel88.setBackground(java.awt.Color.white);
        jLabel88.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel88.setText("Grade :");

        txtTSub1.setEditable(false);

        jLabel138.setBackground(java.awt.Color.white);
        jLabel138.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel138.setText("Subject :");

        txtTGrade4.setEditable(false);

        txtTSub9.setEditable(false);

        txtTGrade9.setEditable(false);
        txtTGrade9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTGrade9ActionPerformed(evt);
            }
        });

        txtTGrade1.setEditable(false);

        txtTSub2.setEditable(false);

        txtTSub7.setEditable(false);

        txtTGrade8.setEditable(false);

        jLabel89.setBackground(java.awt.Color.white);
        jLabel89.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel89.setText("Grade :");

        txtTSub5.setEditable(false);

        jLabel142.setBackground(java.awt.Color.white);
        jLabel142.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel142.setText("Subject :");

        txtTGrade2.setEditable(false);

        txtTGrade6.setEditable(false);

        jLabel140.setBackground(java.awt.Color.white);
        jLabel140.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel140.setText("Subject :");

        jLabel141.setBackground(java.awt.Color.white);
        jLabel141.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel141.setText("Grade :");

        jLabel136.setBackground(java.awt.Color.white);
        jLabel136.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel136.setText("Subject :");

        jLabel139.setBackground(java.awt.Color.white);
        jLabel139.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel139.setText("Grade :");

        txtTSub4.setEditable(false);

        txtTGrade5.setEditable(false);

        jLabel87.setBackground(java.awt.Color.white);
        jLabel87.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel87.setText("Grade :");

        jLabel147.setBackground(java.awt.Color.white);
        jLabel147.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel147.setText("Grade :");

        jLabel91.setBackground(java.awt.Color.white);
        jLabel91.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel91.setText("Subject :");

        jLabel145.setBackground(java.awt.Color.white);
        jLabel145.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel145.setText("Grade :");

        jLabel92.setBackground(java.awt.Color.white);
        jLabel92.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel92.setText("Subject :");

        txtTGrade7.setEditable(false);

        txtTSub3.setEditable(false);

        jLabel146.setBackground(java.awt.Color.white);
        jLabel146.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel146.setText("Subject :");

        jLabel144.setBackground(java.awt.Color.white);
        jLabel144.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel144.setText("Subject :");

        txtTSub8.setEditable(false);

        txtTSub6.setEditable(false);

        jLabel135.setBackground(java.awt.Color.white);
        jLabel135.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel135.setText("Grade :");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel91)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTSub1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel89)
                                .addGap(18, 18, 18)
                                .addComponent(txtTGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel84)
                                    .addComponent(jLabel87, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTSub7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTGrade7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel88)
                                .addGap(18, 18, 18)
                                .addComponent(txtTGrade4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel136)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTSub2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel135)
                                .addGap(18, 18, 18)
                                .addComponent(txtTGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel138)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTSub5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel139)
                                .addGap(18, 18, 18)
                                .addComponent(txtTGrade5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel141)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTGrade8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel6Layout.createSequentialGroup()
                                    .addComponent(jLabel140)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtTSub8, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel92)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTSub4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(306, 306, 306)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addComponent(jLabel142)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTSub3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(8, 8, 8))
                        .addGroup(jPanel6Layout.createSequentialGroup()
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel146)
                                .addComponent(jLabel147))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTSub9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTGrade9, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel143)
                                .addGap(18, 18, 18)
                                .addComponent(txtTGrade3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel144)
                                    .addComponent(jLabel145))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTGrade6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTSub6, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel91)
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTSub1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel136)
                        .addComponent(txtTSub2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel142)
                        .addComponent(txtTSub3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTGrade3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTGrade6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel145)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel89)
                            .addComponent(txtTGrade1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel92)
                            .addComponent(txtTSub4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel138)
                            .addComponent(txtTSub5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel144)
                            .addComponent(txtTSub6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel88)
                            .addComponent(txtTGrade4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel84)
                                    .addComponent(txtTSub7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTGrade7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel87)))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel140)
                                    .addComponent(txtTSub8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel146)
                                    .addComponent(txtTSub9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtTGrade8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel141)
                                    .addComponent(jLabel147)
                                    .addComponent(txtTGrade9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel135)
                            .addComponent(txtTGrade2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel143))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel139)
                            .addComponent(txtTGrade5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(108, 108, 108))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
        );

        jLabel61.setBackground(java.awt.Color.white);
        jLabel61.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel61.setText("Exam Index No :");

        txtOIndexOL.setEditable(false);
        txtOIndexOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOIndexOLActionPerformed(evt);
            }
        });

        jLabel60.setBackground(java.awt.Color.white);
        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setText("Year :");

        txtOyrOL.setEditable(false);
        txtOyrOL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOyrOLActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel42Layout = new javax.swing.GroupLayout(jPanel42);
        jPanel42.setLayout(jPanel42Layout);
        jPanel42Layout.setHorizontalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel61)
                .addGap(4, 4, 4)
                .addComponent(txtOIndexOL, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtOyrOL, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel42Layout.setVerticalGroup(
            jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel42Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel42Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(jLabel60)
                    .addComponent(txtOIndexOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOyrOL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        ac.addTab("Ordinary Level Exam", jPanel42);

        jTabbedPane12.addTab("Academic Information", ac);

        jPanel20.setBackground(java.awt.Color.white);

        jScrollPane14.setBackground(java.awt.Color.white);

        txtOExtra.setEditable(false);
        txtOExtra.setColumns(20);
        txtOExtra.setRows(5);
        jScrollPane14.setViewportView(txtOExtra);

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
        );

        jTabbedPane12.addTab("Extracurricular Activities", jPanel20);

        jTabbedPane13.addTab("Requested  Document Details", jTabbedPane12);

        jPanel53.setBackground(new java.awt.Color(0, 201, 208));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("Manage Official Document Requests");

        javax.swing.GroupLayout jPanel53Layout = new javax.swing.GroupLayout(jPanel53);
        jPanel53.setLayout(jPanel53Layout);
        jPanel53Layout.setHorizontalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel53Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel53Layout.setVerticalGroup(
            jPanel53Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel53Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addContainerGap())
        );

        btnViewOfficialDocRequests.setBackground(new java.awt.Color(67, 130, 180));
        btnViewOfficialDocRequests.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewOfficialDocRequests.setForeground(new java.awt.Color(255, 255, 255));
        btnViewOfficialDocRequests.setText("VIEW Document Requests");
        btnViewOfficialDocRequests.setBorderPainted(false);
        btnViewOfficialDocRequests.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewOfficialDocRequests.setMaximumSize(new java.awt.Dimension(119, 25));
        btnViewOfficialDocRequests.setMinimumSize(new java.awt.Dimension(119, 25));
        btnViewOfficialDocRequests.setPreferredSize(new java.awt.Dimension(119, 25));
        btnViewOfficialDocRequests.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewOfficialDocRequestsActionPerformed(evt);
            }
        });

        btnVerifyDocDetails.setBackground(new java.awt.Color(34, 139, 34));
        btnVerifyDocDetails.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVerifyDocDetails.setForeground(new java.awt.Color(255, 255, 255));
        btnVerifyDocDetails.setText("Verify Details and UPDATE Document Status");
        btnVerifyDocDetails.setBorderPainted(false);
        btnVerifyDocDetails.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVerifyDocDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerifyDocDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel52Layout = new javax.swing.GroupLayout(jPanel52);
        jPanel52.setLayout(jPanel52Layout);
        jPanel52Layout.setHorizontalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel52Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnViewOfficialDocRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addComponent(btnVerifyDocDetails)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(iuds10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTabbedPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 831, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel52Layout.setVerticalGroup(
            jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel52Layout.createSequentialGroup()
                .addComponent(jPanel53, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iuds10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel52Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel52Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnVerifyDocDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnViewOfficialDocRequests, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout manageOfficialDocLayout = new javax.swing.GroupLayout(manageOfficialDoc);
        manageOfficialDoc.setLayout(manageOfficialDocLayout);
        manageOfficialDocLayout.setHorizontalGroup(
            manageOfficialDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageOfficialDocLayout.createSequentialGroup()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 984, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 216, Short.MAX_VALUE))
        );
        manageOfficialDocLayout.setVerticalGroup(
            manageOfficialDocLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(manageOfficialDocLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel52, javax.swing.GroupLayout.PREFERRED_SIZE, 551, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(134, Short.MAX_VALUE))
        );

        forms.add(manageOfficialDoc, "offivsilDoc");

        Tbehaviour.setBackground(new java.awt.Color(255, 255, 255));
        Tbehaviour.setMaximumSize(new java.awt.Dimension(1200, 600));
        Tbehaviour.setMinimumSize(new java.awt.Dimension(1200, 600));
        Tbehaviour.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel37.setBackground(new java.awt.Color(255, 255, 255));
        jPanel37.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPane7.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 3, true));

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));

        jPanel22.setBackground(new java.awt.Color(255, 255, 255));

        jPanel25.setBackground(new java.awt.Color(255, 255, 255));

        btnDeleteBehaviourStu.setBackground(new java.awt.Color(220, 19, 60));
        btnDeleteBehaviourStu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteBehaviourStu.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBehaviourStu.setText("DELETE");
        btnDeleteBehaviourStu.setBorderPainted(false);
        btnDeleteBehaviourStu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteBehaviourStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBehaviourStuActionPerformed(evt);
            }
        });

        btnAddBehaviourStu.setBackground(new java.awt.Color(34, 139, 34));
        btnAddBehaviourStu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddBehaviourStu.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBehaviourStu.setText("ADD");
        btnAddBehaviourStu.setBorderPainted(false);
        btnAddBehaviourStu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddBehaviourStu.setMaximumSize(new java.awt.Dimension(119, 25));
        btnAddBehaviourStu.setMinimumSize(new java.awt.Dimension(119, 25));
        btnAddBehaviourStu.setPreferredSize(new java.awt.Dimension(119, 25));
        btnAddBehaviourStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBehaviourStuActionPerformed(evt);
            }
        });

        btnClearBehaviourStu.setBackground(new java.awt.Color(251, 163, 4));
        btnClearBehaviourStu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearBehaviourStu.setForeground(new java.awt.Color(255, 255, 255));
        btnClearBehaviourStu.setText("CLEAR");
        btnClearBehaviourStu.setBorderPainted(false);
        btnClearBehaviourStu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearBehaviourStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBehaviourStuActionPerformed(evt);
            }
        });

        btnUpdateBehaviourStu.setBackground(new java.awt.Color(191, 17, 226));
        btnUpdateBehaviourStu.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateBehaviourStu.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBehaviourStu.setText("UPDATE");
        btnUpdateBehaviourStu.setBorderPainted(false);
        btnUpdateBehaviourStu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateBehaviourStu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBehaviourStuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(btnAddBehaviourStu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnUpdateBehaviourStu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDeleteBehaviourStu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClearBehaviourStu, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBehaviourStu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateBehaviourStu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteBehaviourStu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearBehaviourStu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        jPanel33.setBackground(new java.awt.Color(255, 255, 255));

        jLabel124.setBackground(new java.awt.Color(255, 255, 255));
        jLabel124.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel124.setText("Behavoiur Note :");

        incidentDate.setBackground(new java.awt.Color(255, 255, 255));
        incidentDate.setDateFormatString("yyyy-MM-dd");

        behaviourNote.setBackground(new java.awt.Color(255, 255, 255));

        txtBehavoiurNote.setColumns(20);
        txtBehavoiurNote.setRows(5);
        behaviourNote.setViewportView(txtBehavoiurNote);

        jLabel111.setBackground(new java.awt.Color(255, 255, 255));
        jLabel111.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel111.setText("Incident Date :");

        jLabel125.setBackground(new java.awt.Color(255, 255, 255));
        jLabel125.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel125.setText("Behaviour Type :");

        comboBehaviourType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Behavoiur Type>>" }));

        jLabel126.setBackground(new java.awt.Color(255, 255, 255));
        jLabel126.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel126.setText("Next Action :");

        jLabel112.setBackground(new java.awt.Color(255, 255, 255));
        jLabel112.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel112.setText("Action Date :");

        actionDate.setBackground(new java.awt.Color(255, 255, 255));
        actionDate.setDateFormatString("yyyy-MM-dd");

        jScrollPane12.setBackground(new java.awt.Color(255, 255, 255));

        tblBehavioutStuList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student Reg No", "First Name", "Middle Name", "Last Name"
            }
        ));
        tblBehavioutStuList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBehavioutStuListMouseClicked(evt);
            }
        });
        jScrollPane12.setViewportView(tblBehavioutStuList);

        jLabel162.setBackground(new java.awt.Color(255, 255, 255));
        jLabel162.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel162.setText("StudentID :");

        txtSTID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSTIDActionPerformed(evt);
            }
        });

        jScrollPane13.setBackground(new java.awt.Color(255, 255, 255));

        tblBehavioutStuListshowAll.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student Reg No", "First Name", "Middle Name", "Last Name"
            }
        ));
        tblBehavioutStuListshowAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBehavioutStuListshowAllMouseClicked(evt);
            }
        });
        jScrollPane13.setViewportView(tblBehavioutStuListshowAll);

        jLabel167.setBackground(new java.awt.Color(255, 255, 255));
        jLabel167.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel167.setText("Select Student to Enter a Behaviour Record");

        jLabel168.setBackground(new java.awt.Color(255, 255, 255));
        jLabel168.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel168.setText("Select Student to Update Or Delete a Behaviour Record");

        jButton8.setBackground(new java.awt.Color(45, 203, 112));
        jButton8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton8.setText("RefreshTables");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel33Layout = new javax.swing.GroupLayout(jPanel33);
        jPanel33.setLayout(jPanel33Layout);
        jPanel33Layout.setHorizontalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel111)
                    .addComponent(jLabel124)
                    .addComponent(jLabel125)
                    .addComponent(jLabel126)
                    .addComponent(jLabel112)
                    .addComponent(jLabel162))
                .addGap(18, 18, 18)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtSTID)
                    .addComponent(incidentDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBehaviourType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(behaviourNote, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtNextAction)
                    .addComponent(actionDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel168)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jLabel167)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel33Layout.setVerticalGroup(
            jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel33Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel162)
                    .addComponent(txtSTID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel167)
                    .addComponent(jButton8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addComponent(jLabel111)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel125))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel33Layout.createSequentialGroup()
                                .addComponent(incidentDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel124)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(behaviourNote, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel168)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel33Layout.createSequentialGroup()
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel126)
                            .addComponent(txtNextAction, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel33Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel33Layout.createSequentialGroup()
                                .addComponent(jLabel112)
                                .addGap(5, 5, 5))
                            .addComponent(actionDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(168, Short.MAX_VALUE))
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel33, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel33, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane7.addTab("Track Student Behavoiur", jPanel21);

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane6.setBackground(new java.awt.Color(255, 255, 255));

        tblBehaviourInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "BehavoiourID", "Behaoiur Type", "PositiveOrNegative"
            }
        ));
        tblBehaviourInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBehaviourInfoMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblBehaviourInfo);

        btnAddBehaviourType.setBackground(new java.awt.Color(34, 139, 34));
        btnAddBehaviourType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAddBehaviourType.setForeground(new java.awt.Color(255, 255, 255));
        btnAddBehaviourType.setText("ADD");
        btnAddBehaviourType.setBorderPainted(false);
        btnAddBehaviourType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddBehaviourType.setMaximumSize(new java.awt.Dimension(119, 25));
        btnAddBehaviourType.setMinimumSize(new java.awt.Dimension(119, 25));
        btnAddBehaviourType.setPreferredSize(new java.awt.Dimension(119, 25));
        btnAddBehaviourType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBehaviourTypeActionPerformed(evt);
            }
        });

        btnUpdateBehaviourType.setBackground(new java.awt.Color(191, 17, 226));
        btnUpdateBehaviourType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnUpdateBehaviourType.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateBehaviourType.setText("UPDATE");
        btnUpdateBehaviourType.setBorderPainted(false);
        btnUpdateBehaviourType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUpdateBehaviourType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBehaviourTypeActionPerformed(evt);
            }
        });

        btnDeleteBehaviourType.setBackground(new java.awt.Color(220, 19, 60));
        btnDeleteBehaviourType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDeleteBehaviourType.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteBehaviourType.setText("DELETE");
        btnDeleteBehaviourType.setBorderPainted(false);
        btnDeleteBehaviourType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeleteBehaviourType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBehaviourTypeActionPerformed(evt);
            }
        });

        btnClearBehaviourType.setBackground(new java.awt.Color(251, 163, 4));
        btnClearBehaviourType.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearBehaviourType.setForeground(new java.awt.Color(255, 255, 255));
        btnClearBehaviourType.setText("CLEAR");
        btnClearBehaviourType.setBorderPainted(false);
        btnClearBehaviourType.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearBehaviourType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBehaviourTypeActionPerformed(evt);
            }
        });

        jLabel163.setBackground(new java.awt.Color(255, 255, 255));
        jLabel163.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel163.setText("BehaviourID :");

        txtBehaviourId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBehaviourIdActionPerformed(evt);
            }
        });

        jLabel165.setBackground(new java.awt.Color(255, 255, 255));
        jLabel165.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel165.setText("Behaviour Type :");

        txtBehaviourType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBehaviourTypeActionPerformed(evt);
            }
        });

        jLabel166.setBackground(new java.awt.Color(255, 255, 255));
        jLabel166.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel166.setText("Positive ? :");

        ChkBoxpositive.setText("Positive Behaviour Type");

        jLabel169.setBackground(new java.awt.Color(255, 255, 255));
        jLabel169.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel169.setText("Select Behaviour to Update Or Delete  a Behaviour Type");

        jButton9.setBackground(new java.awt.Color(45, 203, 112));
        jButton9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton9.setText("RefreshTables");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addComponent(btnAddBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdateBehaviourType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDeleteBehaviourType)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnClearBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel165)
                            .addComponent(jLabel163)
                            .addComponent(jLabel166))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBehaviourId)
                                    .addComponent(txtBehaviourType))
                                .addGap(24, 24, 24))
                            .addGroup(jPanel23Layout.createSequentialGroup()
                                .addComponent(ChkBoxpositive)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel169)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel23Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9)
                .addGap(21, 21, 21))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel163)
                            .addComponent(txtBehaviourId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel165)
                            .addComponent(txtBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel166)
                            .addComponent(ChkBoxpositive)))
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel169)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnClearBehaviourType, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67))
        );

        jTabbedPane7.addTab("Manage Behavoiur Types", jPanel23);

        jPanel54.setBackground(new java.awt.Color(0, 201, 208));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Track Student Behaviour");

        javax.swing.GroupLayout jPanel54Layout = new javax.swing.GroupLayout(jPanel54);
        jPanel54.setLayout(jPanel54Layout);
        jPanel54Layout.setHorizontalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel54Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel7)
                .addContainerGap(689, Short.MAX_VALUE))
        );
        jPanel54Layout.setVerticalGroup(
            jPanel54Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel54Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel37Layout = new javax.swing.GroupLayout(jPanel37);
        jPanel37.setLayout(jPanel37Layout);
        jPanel37Layout.setHorizontalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel37Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel54, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel37Layout.setVerticalGroup(
            jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel37Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jTabbedPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
            .addGroup(jPanel37Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel37Layout.createSequentialGroup()
                    .addComponent(jPanel54, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 494, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout TbehaviourLayout = new javax.swing.GroupLayout(Tbehaviour);
        Tbehaviour.setLayout(TbehaviourLayout);
        TbehaviourLayout.setHorizontalGroup(
            TbehaviourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TbehaviourLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(216, Short.MAX_VALUE))
        );
        TbehaviourLayout.setVerticalGroup(
            TbehaviourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TbehaviourLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel37, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(145, Short.MAX_VALUE))
        );

        forms.add(Tbehaviour, "behavoiur");

        TgenerateReportsnStat.setBackground(new java.awt.Color(255, 255, 255));
        TgenerateReportsnStat.setMaximumSize(new java.awt.Dimension(1200, 600));
        TgenerateReportsnStat.setMinimumSize(new java.awt.Dimension(1200, 600));
        TgenerateReportsnStat.setPreferredSize(new java.awt.Dimension(1200, 600));

        jPanel28.setBackground(new java.awt.Color(255, 255, 255));
        jPanel28.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 201, 208), 1, true));

        jTabbedPane9.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(41, 48, 66), 3, true));

        jTabbedPane10.setBackground(new java.awt.Color(255, 255, 255));

        btnViewAcademicData.setBackground(new java.awt.Color(34, 139, 34));
        btnViewAcademicData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewAcademicData.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAcademicData.setText("VIEW Students List");
        btnViewAcademicData.setBorderPainted(false);
        btnViewAcademicData.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAcademicData.setMaximumSize(new java.awt.Dimension(119, 25));
        btnViewAcademicData.setMinimumSize(new java.awt.Dimension(119, 25));
        btnViewAcademicData.setPreferredSize(new java.awt.Dimension(119, 25));
        btnViewAcademicData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAcademicDataActionPerformed(evt);
            }
        });

        tblAcademicData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblAcademicData.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "Date", "Alert"
            }
        ));
        tblAcademicData.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tblAcademicData.getTableHeader().setReorderingAllowed(false);
        tblAcademicData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAcademicDataMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblAcademicData);

        jButton5.setBackground(new java.awt.Color(45, 203, 112));
        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setText("RefreshTable");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel47Layout = new javax.swing.GroupLayout(jPanel47);
        jPanel47.setLayout(jPanel47Layout);
        jPanel47Layout.setHorizontalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addComponent(btnViewAcademicData, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)
                        .addGap(42, 42, 42))))
        );
        jPanel47Layout.setVerticalGroup(
            jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel47Layout.createSequentialGroup()
                .addGroup(jPanel47Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel47Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnViewAcademicData, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel47Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane6.addTab("Select Record to Generate Statistics", jPanel47);

        jTabbedPane10.addTab("Select a Record", jTabbedPane6);

        jPanel24.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        btn_update2.setBackground(new java.awt.Color(67, 130, 180));
        btn_update2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_update2.setForeground(new java.awt.Color(255, 255, 255));
        btn_update2.setText("Generate Report for Specific Mark Range :");
        btn_update2.setIconTextGap(14);
        btn_update2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update2ActionPerformed(evt);
            }
        });

        txtPrecentageReport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPrecentageReport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecentageReportKeyTyped(evt);
            }
        });

        btnPieChart.setBackground(new java.awt.Color(67, 130, 180));
        btnPieChart.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnPieChart.setForeground(new java.awt.Color(255, 255, 255));
        btnPieChart.setText("Generate Pie Chart - Subjects Vs No of Students");
        btnPieChart.setIconTextGap(14);
        btnPieChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPieChartActionPerformed(evt);
            }
        });

        btn_update1.setBackground(new java.awt.Color(67, 130, 180));
        btn_update1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_update1.setForeground(new java.awt.Color(255, 255, 255));
        btn_update1.setText("Generate Marksheet for Selected Year, Class and Term");
        btn_update1.setIconTextGap(14);
        btn_update1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update1ActionPerformed(evt);
            }
        });

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("Year :");

        txtyrreport.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtyrreport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyrreportActionPerformed(evt);
            }
        });
        txtyrreport.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtyrreportKeyTyped(evt);
            }
        });

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Term :");

        combotermReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Term>>", "First Term", "Second Term", "Third Term" }));

        jLabel201.setBackground(java.awt.Color.white);
        jLabel201.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel201.setText("Class :");

        comboclassReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Class>>", " " }));

        sub1l.setBackground(java.awt.Color.white);
        sub1l.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        sub1l.setText("Subject :");

        jLabel38.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel38.setText("Select >>");

        jLabel204.setBackground(java.awt.Color.white);
        jLabel204.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel204.setText("Average Marks Greater than");

        jLabel205.setBackground(java.awt.Color.white);
        jLabel205.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel205.setText("Generate Charts");

        jLabel206.setBackground(java.awt.Color.white);
        jLabel206.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel206.setText("Generate Reports");

        btn_update15.setBackground(new java.awt.Color(67, 130, 180));
        btn_update15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_update15.setForeground(new java.awt.Color(255, 255, 255));
        btn_update15.setText("Generate Specific Stdent's Termly Report");
        btn_update15.setIconTextGap(14);
        btn_update15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update15ActionPerformed(evt);
            }
        });

        btnColumnChart.setBackground(new java.awt.Color(67, 130, 180));
        btnColumnChart.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnColumnChart.setForeground(new java.awt.Color(255, 255, 255));
        btnColumnChart.setText("Generate Column Chart - Subjects Vs Marks");
        btnColumnChart.setIconTextGap(14);
        btnColumnChart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnColumnChartActionPerformed(evt);
            }
        });

        jLabel203.setBackground(java.awt.Color.white);
        jLabel203.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel203.setText("Selected Student No:");

        txtStuRegReport1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtStuRegReport1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStuRegReport1KeyTyped(evt);
            }
        });

        jLabel207.setBackground(java.awt.Color.white);
        jLabel207.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel207.setText("Selected Student No:");

        txtStuRegReport3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtStuRegReport3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStuRegReport3KeyTyped(evt);
            }
        });

        comboSubReport.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Subject>>" }));
        comboSubReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSubReportActionPerformed(evt);
            }
        });

        btnClearReports.setBackground(new java.awt.Color(251, 163, 4));
        btnClearReports.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClearReports.setForeground(new java.awt.Color(255, 255, 255));
        btnClearReports.setText("CLEAR");
        btnClearReports.setBorderPainted(false);
        btnClearReports.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClearReports.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearReportsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel206)
                            .addComponent(jLabel205))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(btnPieChart)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sub1l)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboSubReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btn_update15)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel207)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStuRegReport3))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addComponent(btn_update2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel204)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrecentageReport, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btn_update1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                        .addComponent(jLabel38)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel37)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtyrreport, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel18)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(combotermReport, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel201)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(comboclassReport, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnColumnChart)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(236, 236, 236)
                                        .addComponent(btnClearReports, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel203)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtStuRegReport1)))
                        .addGap(32, 32, 32))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel206)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update15)
                    .addComponent(txtStuRegReport3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel207))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel37)
                    .addComponent(txtyrreport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combotermReport, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel201)
                    .addComponent(comboclassReport, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel38))
                .addGap(18, 18, 18)
                .addComponent(btn_update1)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update2)
                    .addComponent(txtPrecentageReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel204))
                .addGap(18, 18, 18)
                .addComponent(jLabel205)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnPieChart)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sub1l)
                        .addComponent(comboSubReport, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnColumnChart)
                    .addComponent(txtStuRegReport1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel203))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnClearReports, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 649, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane10.addTab("Exam Results Statistics", jPanel24);

        jTabbedPane9.addTab("Academic ", jTabbedPane10);

        jTabbedPane11.setBackground(new java.awt.Color(255, 255, 255));

        btnViewAcademicData1.setBackground(new java.awt.Color(34, 139, 34));
        btnViewAcademicData1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnViewAcademicData1.setForeground(new java.awt.Color(255, 255, 255));
        btnViewAcademicData1.setText("VIEW Students List");
        btnViewAcademicData1.setBorderPainted(false);
        btnViewAcademicData1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnViewAcademicData1.setMaximumSize(new java.awt.Dimension(119, 25));
        btnViewAcademicData1.setMinimumSize(new java.awt.Dimension(119, 25));
        btnViewAcademicData1.setPreferredSize(new java.awt.Dimension(119, 25));
        btnViewAcademicData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewAcademicData1ActionPerformed(evt);
            }
        });

        tblExtraC.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tblExtraC.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null}
            },
            new String [] {
                "Date", "Alert"
            }
        ));
        tblExtraC.setCursor(new java.awt.Cursor(java.awt.Cursor.MOVE_CURSOR));
        tblExtraC.getTableHeader().setReorderingAllowed(false);
        tblExtraC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblExtraCMouseClicked(evt);
            }
        });
        jScrollPane19.setViewportView(tblExtraC);

        jButton6.setBackground(new java.awt.Color(45, 203, 112));
        jButton6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton6.setText("RefreshTable");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel48Layout = new javax.swing.GroupLayout(jPanel48);
        jPanel48.setLayout(jPanel48Layout);
        jPanel48Layout.setHorizontalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(28, Short.MAX_VALUE))
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addComponent(btnViewAcademicData1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton6)
                        .addGap(43, 43, 43))))
        );
        jPanel48Layout.setVerticalGroup(
            jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel48Layout.createSequentialGroup()
                .addGroup(jPanel48Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel48Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnViewAcademicData1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel48Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane19, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Select Record to Generate Statistics", jPanel48);

        jTabbedPane11.addTab("Select a Record", jTabbedPane2);

        jPanel30.setBackground(new java.awt.Color(255, 255, 255));

        btn_update10.setBackground(new java.awt.Color(255, 255, 255));
        btn_update10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_update10.setForeground(new java.awt.Color(250, 188, 61));
        btn_update10.setText("Generate Full Extracurricular Activities Report");
        btn_update10.setIconTextGap(14);
        btn_update10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update10ActionPerformed(evt);
            }
        });

        btn_update11.setBackground(new java.awt.Color(255, 255, 255));
        btn_update11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_update11.setForeground(new java.awt.Color(250, 188, 61));
        btn_update11.setText("Generate Report for Specific Activity :");
        btn_update11.setIconTextGap(14);
        btn_update11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update11ActionPerformed(evt);
            }
        });

        btn_update12.setBackground(new java.awt.Color(255, 255, 255));
        btn_update12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_update12.setForeground(new java.awt.Color(250, 188, 61));
        btn_update12.setText("Generate Report for Specific Student :");
        btn_update12.setIconTextGap(14);
        btn_update12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_update12ActionPerformed(evt);
            }
        });

        btnCompareActiVsParticp.setBackground(new java.awt.Color(255, 255, 255));
        btnCompareActiVsParticp.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnCompareActiVsParticp.setForeground(new java.awt.Color(250, 188, 61));
        btnCompareActiVsParticp.setText("Generate Pie Chart - Activity Vs Participation");
        btnCompareActiVsParticp.setIconTextGap(14);
        btnCompareActiVsParticp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompareActiVsParticpActionPerformed(evt);
            }
        });

        btnReportExramComapreclasses.setBackground(new java.awt.Color(255, 255, 255));
        btnReportExramComapreclasses.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnReportExramComapreclasses.setForeground(new java.awt.Color(250, 188, 61));
        btnReportExramComapreclasses.setText("Generate Column Chart - Compare Class Vs Activity Participation");
        btnReportExramComapreclasses.setIconTextGap(14);
        btnReportExramComapreclasses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportExramComapreclassesActionPerformed(evt);
            }
        });

        comboTActivity1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Activity>>" }));

        comboclassAc1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Class>>", " " }));

        comboclassAc2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "<<Select Class>>", " " }));

        jLabel208.setBackground(java.awt.Color.white);
        jLabel208.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel208.setText("Generate Reports");

        jLabel209.setBackground(java.awt.Color.white);
        jLabel209.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel209.setText("Generate Charts");

        jLabel210.setBackground(java.awt.Color.white);
        jLabel210.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel210.setText("Selected Student No:");

        jLabel202.setBackground(java.awt.Color.white);
        jLabel202.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel202.setText("Select a Class :");

        jLabel211.setBackground(java.awt.Color.white);
        jLabel211.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel211.setText("Select another Class :");

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

        javax.swing.GroupLayout jPanel30Layout = new javax.swing.GroupLayout(jPanel30);
        jPanel30.setLayout(jPanel30Layout);
        jPanel30Layout.setHorizontalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel30Layout.createSequentialGroup()
                                .addComponent(btn_update11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboTActivity1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCompareActiVsParticp)
                            .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                                    .addComponent(btn_update12)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel210)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selectedActivityStuRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnReportExramComapreclasses, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(btn_update10))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel30Layout.createSequentialGroup()
                        .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel208)
                            .addComponent(jLabel209))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel30Layout.createSequentialGroup()
                        .addComponent(jLabel202)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(comboclassAc1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel211)
                        .addGap(15, 15, 15)
                        .addComponent(comboclassAc2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(btnClearReports1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel30Layout.setVerticalGroup(
            jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel30Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel208, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_update10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update11)
                    .addComponent(comboTActivity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_update12)
                    .addComponent(selectedActivityStuRegNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel210))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel209, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(btnCompareActiVsParticp)
                .addGap(18, 18, 18)
                .addComponent(btnReportExramComapreclasses)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel30Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboclassAc1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboclassAc2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel202)
                    .addComponent(jLabel211))
                .addGap(18, 18, 18)
                .addComponent(btnClearReports1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane11.addTab("Achievements", jPanel30);

        jTabbedPane9.addTab("Extacurricular ", jTabbedPane11);

        jPanel55.setBackground(new java.awt.Color(0, 201, 208));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setText("Generate Reports");

        javax.swing.GroupLayout jPanel55Layout = new javax.swing.GroupLayout(jPanel55);
        jPanel55.setLayout(jPanel55Layout);
        jPanel55Layout.setHorizontalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel55Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel55Layout.setVerticalGroup(
            jPanel55Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel55Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel28Layout = new javax.swing.GroupLayout(jPanel28);
        jPanel28.setLayout(jPanel28Layout);
        jPanel28Layout.setHorizontalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel28Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 675, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(261, Short.MAX_VALUE))
        );
        jPanel28Layout.setVerticalGroup(
            jPanel28Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel28Layout.createSequentialGroup()
                .addComponent(jPanel55, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout TgenerateReportsnStatLayout = new javax.swing.GroupLayout(TgenerateReportsnStat);
        TgenerateReportsnStat.setLayout(TgenerateReportsnStatLayout);
        TgenerateReportsnStatLayout.setHorizontalGroup(
            TgenerateReportsnStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TgenerateReportsnStatLayout.createSequentialGroup()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 215, Short.MAX_VALUE))
        );
        TgenerateReportsnStatLayout.setVerticalGroup(
            TgenerateReportsnStatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TgenerateReportsnStatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel28, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(138, Short.MAX_VALUE))
        );

        forms.add(TgenerateReportsnStat, "generateReportStat");

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
            .addComponent(forms, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        Topic.setBackground(new java.awt.Color(26, 56, 103));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("School Information Management System ");

        jLabel53.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
                    .addComponent(jLabel1)
                    .addGroup(TopicLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jLabel53)))
                .addContainerGap(128, Short.MAX_VALUE))
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
        sidemenu.setPreferredSize(new java.awt.Dimension(330, 755));

        jPanel11.setBackground(new java.awt.Color(41, 48, 66));

        jButton26.setBackground(new java.awt.Color(41, 48, 66));
        jButton26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton26.setForeground(new java.awt.Color(255, 255, 255));
        jButton26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/stat32.png"))); // NOI18N
        jButton26.setText(" Generate Reports & Statistics");
        jButton26.setBorderPainted(false);
        jButton26.setContentAreaFilled(false);
        jButton26.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton30.setBackground(new java.awt.Color(41, 48, 66));
        jButton30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton30.setForeground(new java.awt.Color(255, 255, 255));
        jButton30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/behaviour2.png"))); // NOI18N
        jButton30.setText("Track Student Behaviour & Discipline");
        jButton30.setBorderPainted(false);
        jButton30.setContentAreaFilled(false);
        jButton30.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        jButton27.setBackground(new java.awt.Color(41, 48, 66));
        jButton27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton27.setForeground(new java.awt.Color(255, 255, 255));
        jButton27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/doc.png"))); // NOI18N
        jButton27.setText(" Manage Official Document Requests");
        jButton27.setBorderPainted(false);
        jButton27.setContentAreaFilled(false);
        jButton27.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        mngprofile.setBackground(new java.awt.Color(41, 48, 66));
        mngprofile.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mngprofile.setForeground(new java.awt.Color(255, 255, 255));
        mngprofile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/profile.png"))); // NOI18N
        mngprofile.setText("View Student Information");
        mngprofile.setBorderPainted(false);
        mngprofile.setContentAreaFilled(false);
        mngprofile.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mngprofile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngprofileActionPerformed(evt);
            }
        });

        jButton31.setBackground(new java.awt.Color(41, 48, 66));
        jButton31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton31.setForeground(new java.awt.Color(255, 255, 255));
        jButton31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/analyse24.png"))); // NOI18N
        jButton31.setText(" Analyze Student Performance");
        jButton31.setBorderPainted(false);
        jButton31.setContentAreaFilled(false);
        jButton31.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mngprofile, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton31, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton31)
                .addGap(14, 14, 14)
                .addComponent(mngprofile)
                .addGap(18, 18, 18)
                .addComponent(jButton26)
                .addGap(18, 18, 18)
                .addComponent(jButton27)
                .addGap(18, 18, 18)
                .addComponent(jButton30)
                .addContainerGap())
        );

        jPanel34.setBackground(new java.awt.Color(41, 48, 66));

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

        mngprofile2.setBackground(new java.awt.Color(41, 48, 66));
        mngprofile2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        mngprofile2.setForeground(new java.awt.Color(255, 255, 255));
        mngprofile2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMG_SPMS/behaviour.png"))); // NOI18N
        mngprofile2.setToolTipText("MY ACCOUNT");
        mngprofile2.setBorderPainted(false);
        mngprofile2.setContentAreaFilled(false);
        mngprofile2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        mngprofile2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mngprofile2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel34Layout = new javax.swing.GroupLayout(jPanel34);
        jPanel34.setLayout(jPanel34Layout);
        jPanel34Layout.setHorizontalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mngprofile1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mngprofile2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mngprofile3)
                .addContainerGap())
        );
        jPanel34Layout.setVerticalGroup(
            jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel34Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel34Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(mngprofile2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mngprofile1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mngprofile3)))
        );

        javax.swing.GroupLayout sidemenuLayout = new javax.swing.GroupLayout(sidemenu);
        sidemenu.setLayout(sidemenuLayout);
        sidemenuLayout.setHorizontalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sidemenuLayout.createSequentialGroup()
                    .addGap(17, 17, 17)
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(17, Short.MAX_VALUE)))
        );
        sidemenuLayout.setVerticalGroup(
            sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sidemenuLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(335, Short.MAX_VALUE))
            .addGroup(sidemenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(sidemenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel34, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(695, Short.MAX_VALUE)))
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
                    .addComponent(Topic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Topic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bg, javax.swing.GroupLayout.DEFAULT_SIZE, 619, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(sidemenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchStudentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchStudentKeyReleased
        DefaultTableModel table = (DefaultTableModel) tblStudentinfo.getModel();
        String search = txtSearchStudent.getText();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(table);
        tblStudentinfo.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(search));


    }//GEN-LAST:event_txtSearchStudentKeyReleased

    private void txtFinalAvgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinalAvgKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalAvgKeyTyped

    private void txtOgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOgKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOgKeyTyped

    private void txtFinalTotalKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFinalTotalKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFinalTotalKeyTyped

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "Tanalyze");

    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed

        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "behavoiur");
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "offivsilDoc");
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed

        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "generateReportStat");
    }//GEN-LAST:event_jButton26ActionPerformed

    private void mngprofileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofileActionPerformed

        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "TsearchStudent");
    }//GEN-LAST:event_mngprofileActionPerformed

    private void mngprofile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofile1ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_mngprofile1ActionPerformed

    private void mngprofile3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofile3ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_mngprofile3ActionPerformed

    private void mngprofile2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngprofile2ActionPerformed
        CardLayout card = (CardLayout) forms.getLayout();
        card.show(forms, "dashBoard");
    }//GEN-LAST:event_mngprofile2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
        new SIMS_HomeScreen().setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnPrintTProfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintTProfileActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrintTProfileActionPerformed

    private void btnAddTMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTMarksActionPerformed

        try {
            if (validMarkT()) {

                int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
                String pclasss = selectedCurrentClass;
                String pyear = txtyr.getText();
                String pterm = comboterm1T.getSelectedItem().toString();
                String psubject1 = comboSub1.getSelectedItem().toString();
                double pmarks1 = Double.parseDouble(txtTAMarks1.getText());
                String psubject2 = comboSub2.getSelectedItem().toString();
                double pmarks2 = Double.parseDouble(txtTAMarks2.getText());
                String psubject3 = comboSub3.getSelectedItem().toString();
                double pmarks3 = Double.parseDouble(txtTAMarks3.getText());
                String psubject4 = comboSub4.getSelectedItem().toString();
                double pmarks4 = Double.parseDouble(txtTAMarks4.getText());
                String psubject5 = comboSub5.getSelectedItem().toString();
                double pmarks5 = Double.parseDouble(txtTAMarks5.getText());
                String psubject6 = comboSub6.getSelectedItem().toString();
                double pmarks6 = Double.parseDouble(txtTAMarks6.getText());
                String psubject7 = comboSub7.getSelectedItem().toString();
                double pmarks7 = Double.parseDouble(txtTAMarks7.getText());
                String psubject8 = comboSub8.getSelectedItem().toString();
                double pmarks8 = Double.parseDouble(txtTAMarks8.getText());
                String psubject9 = comboSub9.getSelectedItem().toString();
                double pmarks9 = Double.parseDouble(txtTAMarks9.getText());

                obj.addTermTestMarks(pstuRegNo, pclasss, pyear, pterm, psubject1, pmarks1, psubject2, pmarks2, psubject3, pmarks3, psubject4, pmarks4, psubject5, pmarks5, psubject6, pmarks6, psubject7, pmarks7, psubject8, pmarks8, psubject9, pmarks9);
                JOptionPane.showMessageDialog(null, "Record Inserted Successfully !");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnAddTMarksActionPerformed

    private void btnUpdateTermTestMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTermTestMarksActionPerformed
        try {
            if (validMarkT()) {

                int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
                String pclasss = selectedCurrentClass;
                String pyear = txtyr.getText();
                String pterm = comboterm1T.getSelectedItem().toString();
                String psubject1 = comboSub1.getSelectedItem().toString();
                double pmarks1 = Double.parseDouble(txtTAMarks1.getText());
                String psubject2 = comboSub2.getSelectedItem().toString();
                double pmarks2 = Double.parseDouble(txtTAMarks2.getText());
                String psubject3 = comboSub3.getSelectedItem().toString();
                double pmarks3 = Double.parseDouble(txtTAMarks3.getText());
                String psubject4 = comboSub4.getSelectedItem().toString();
                double pmarks4 = Double.parseDouble(txtTAMarks4.getText());
                String psubject5 = comboSub5.getSelectedItem().toString();
                double pmarks5 = Double.parseDouble(txtTAMarks5.getText());
                String psubject6 = comboSub6.getSelectedItem().toString();
                double pmarks6 = Double.parseDouble(txtTAMarks6.getText());
                String psubject7 = comboSub7.getSelectedItem().toString();
                double pmarks7 = Double.parseDouble(txtTAMarks7.getText());
                String psubject8 = comboSub8.getSelectedItem().toString();
                double pmarks8 = Double.parseDouble(txtTAMarks8.getText());
                String psubject9 = comboSub9.getSelectedItem().toString();
                double pmarks9 = Double.parseDouble(txtTAMarks9.getText());

                obj.updateTermTestMarks(pstuRegNo, pclasss, pyear, pterm, psubject1, pmarks1, psubject2, pmarks2, psubject3, pmarks3, psubject4, pmarks4, psubject5, pmarks5, psubject6, pmarks6, psubject7, pmarks7, psubject8, pmarks8, psubject9, pmarks9);
                JOptionPane.showMessageDialog(null, "Record Updated Successfully !");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnUpdateTermTestMarksActionPerformed

    private void btnDeleteTermTestMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTermTestMarksActionPerformed
        try {
            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;
            String pyear = txtyr.getText();
            String pterm = comboterm1T.getSelectedItem().toString();

            obj.deleteTermTestMarks(pstuRegNo, pclasss, pyear, pterm);
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnDeleteTermTestMarksActionPerformed

    private void btnClearTermTestMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearTermTestMarksActionPerformed
        comboSub1.setSelectedItem("<<Select Subject>>");
        comboSub2.setSelectedItem("<<Select Subject>>");
        comboSub3.setSelectedItem("<<Select Subject>>");
        comboSub4.setSelectedItem("<<Select Subject>>");
        comboSub5.setSelectedItem("<<Select Subject>>");
        comboSub6.setSelectedItem("<<Select Subject>>");
        comboSub7.setSelectedItem("<<Select Subject>>");
        comboSub8.setSelectedItem("<<Select Subject>>");
        comboSub9.setSelectedItem("<<Select Subject>>");

        txtTAMarks1.setText(" ");
        txtTAMarks2.setText(" ");
        txtTAMarks3.setText(" ");
        txtTAMarks4.setText(" ");
        txtTAMarks5.setText(" ");
        txtTAMarks6.setText(" ");
        txtTAMarks7.setText(" ");
        txtTAMarks8.setText(" ");
        txtTAMarks9.setText(" ");

    }//GEN-LAST:event_btnClearTermTestMarksActionPerformed

    private void btnViewOfficialDocRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewOfficialDocRequestsActionPerformed
        viewRequestedDocDetails();
    }//GEN-LAST:event_btnViewOfficialDocRequestsActionPerformed

    private void btnVerifyDocDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerifyDocDetailsActionPerformed
        try {
            int pdocumentID = Integer.parseInt(docID);
            String pdocStatus = "Is Ready";

            obj.verifyDocDetails(pdocumentID, pdocStatus);
            JOptionPane.showMessageDialog(null, "Document Status Updated Successfully !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnVerifyDocDetailsActionPerformed

    private void btnClearOfficialDocRequestsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearOfficialDocRequestsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearOfficialDocRequestsActionPerformed

    private void quickTIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quickTIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quickTIDActionPerformed

    private void txtOIndexOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOIndexOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOIndexOLActionPerformed

    private void txtOyrOLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOyrOLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOyrOLActionPerformed

    private void txtOTeacherFnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOTeacherFnameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOTeacherFnameKeyTyped

    private void txtOStuIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOStuIDKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOStuIDKeyTyped

    private void txtOClassKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOClassKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOClassKeyTyped

    private void txtOFullnameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOFullnameKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOFullnameKeyTyped

    private void tblrequestedDocDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblrequestedDocDetailsMouseClicked
        try {
            int row = tblrequestedDocDetails.getSelectedRow();
            String tblClick = (tblrequestedDocDetails.getModel().getValueAt(row, 0).toString());

            obj.showRequestedDetails(Integer.parseInt(tblClick));

            docID = obj.pdocID;
            txtOStuID.setText(obj.padd1);
            txtOClass.setText(obj.padd2);
            txtOTeacherFname.setText(obj.padd3);
            txtOTeacherLname.setText(obj.padd4);
            txtOFullname.setText(obj.padd5);
            txtOBio.setText(obj.padd6);
            txtOSkills.setText(obj.padd7);
            txtOIndexOL.setText(obj.padd8);
            txtOyrOL.setText(obj.padd9);
            txtOExtra.setText(obj.padd10);
            txtTSub1.setText(obj.padd11);
            txtTSub2.setText(obj.padd12);
            txtTSub3.setText(obj.padd13);
            txtTSub4.setText(obj.padd14);
            txtTSub5.setText(obj.padd15);
            txtTSub6.setText(obj.padd16);
            txtTSub7.setText(obj.padd17);
            txtTSub8.setText(obj.padd18);
            txtTSub9.setText(obj.padd19);
            txtTGrade1.setText(obj.padd20);
            txtTGrade2.setText(obj.padd21);
            txtTGrade3.setText(obj.padd22);
            txtTGrade4.setText(obj.padd23);
            txtTGrade5.setText(obj.padd24);
            txtTGrade6.setText(obj.padd25);
            txtTGrade7.setText(obj.padd26);
            txtTGrade8.setText(obj.padd27);
            txtTGrade9.setText(obj.padd28);

            byte[] photoTB = obj.pphotoTB;
            ImageIcon photoTIcon = new ImageIcon(photoTB);
            Image photoTImg = photoTIcon.getImage();
            Image photoTImg2 = photoTImg.getScaledInstance(lblSPMSPhotograph2.getWidth(), lblSPMSPhotograph2.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon photoTIcon2 = new ImageIcon(photoTImg2);
            lblSPMSPhotograph2.setIcon(photoTIcon2);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tblrequestedDocDetailsMouseClicked

    private void txtTGrade9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTGrade9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTGrade9ActionPerformed

    private void tblStuLISTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStuLISTMouseClicked
        try {
            int row = tblStuLIST.getSelectedRow();
            String tblClick = (tblStuLIST.getModel().getValueAt(row, 0).toString());

            obj.getSelectedStuInfo(Integer.parseInt(tblClick));

            selectedStudentRegNo = obj.pselectedStudentRegNo;
            selectedCurrentClass = obj.pselectedCurrentClass;

            txtshowStuNo2.setText(selectedStudentRegNo);
            txtshowClass2.setText(selectedCurrentClass);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tblStuLISTMouseClicked

    private void btnViewStudentsListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStudentsListActionPerformed
        showStudentsList();
    }//GEN-LAST:event_btnViewStudentsListActionPerformed

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

    private void combotermTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combotermTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_combotermTAActionPerformed

    private void btnAddTAssignmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTAssignmentActionPerformed
        try {
            if (validMarkA()) {

                int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
                String pclasss = selectedCurrentClass;
                String psubject1 = comboSubA1.getSelectedItem().toString();
                double ppscore1 = Double.parseDouble(txtTAScore1.getText());
                String psubject2 = comboSubA2.getSelectedItem().toString();
                double ppscore2 = Double.parseDouble(txtTAScore2.getText());
                String psubject3 = comboSubA3.getSelectedItem().toString();
                double ppscore3 = Double.parseDouble(txtTAScore3.getText());
                String psubject4 = comboSubA4.getSelectedItem().toString();
                double ppscore4 = Double.parseDouble(txtTAScore4.getText());
                String psubject5 = comboSubA5.getSelectedItem().toString();
                double ppscore5 = Double.parseDouble(txtTAScore5.getText());
                String psubject6 = comboSubA6.getSelectedItem().toString();
                double ppscore6 = Double.parseDouble(txtTAScore6.getText());
                String psubject7 = comboSubA7.getSelectedItem().toString();
                double ppscore7 = Double.parseDouble(txtTAScore7.getText());
                String psubject8 = comboSubA8.getSelectedItem().toString();
                double ppscore8 = Double.parseDouble(txtTAScore8.getText());
                String psubject9 = comboSubA9.getSelectedItem().toString();
                double ppscore9 = Double.parseDouble(txtTAScore9.getText());

                obj.addAssignmentScores(pstuRegNo, pclasss, psubject1, ppscore1, psubject2, ppscore2, psubject3, ppscore3, psubject4, ppscore4, psubject5, ppscore5, psubject6, ppscore6, psubject7, ppscore7, psubject8, ppscore8, psubject9, ppscore9);
                JOptionPane.showMessageDialog(null, "Record Inserted Successfully !");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddTAssignmentActionPerformed

    private void btnUpdateAssignmentScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAssignmentScoresActionPerformed
        try {
            if (validMarkA()) {

                int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
                String pclasss = selectedCurrentClass;

                String psubject1 = comboSubA1.getSelectedItem().toString();
                double ppscore1 = Double.parseDouble(txtTAScore1.getText());
                String psubject2 = comboSubA2.getSelectedItem().toString();
                double ppscore2 = Double.parseDouble(txtTAScore2.getText());
                String psubject3 = comboSubA3.getSelectedItem().toString();
                double ppscore3 = Double.parseDouble(txtTAScore3.getText());
                String psubject4 = comboSubA4.getSelectedItem().toString();
                double ppscore4 = Double.parseDouble(txtTAScore4.getText());
                String psubject5 = comboSubA5.getSelectedItem().toString();
                double ppscore5 = Double.parseDouble(txtTAScore5.getText());
                String psubject6 = comboSubA6.getSelectedItem().toString();
                double ppscore6 = Double.parseDouble(txtTAScore6.getText());
                String psubject7 = comboSubA7.getSelectedItem().toString();
                double ppscore7 = Double.parseDouble(txtTAScore7.getText());
                String psubject8 = comboSubA8.getSelectedItem().toString();
                double ppscore8 = Double.parseDouble(txtTAScore8.getText());
                String psubject9 = comboSubA9.getSelectedItem().toString();
                double ppscore9 = Double.parseDouble(txtTAScore9.getText());

                obj.updateAssignmentScores(pstuRegNo, pclasss, psubject1, ppscore1, psubject2, ppscore2, psubject3, ppscore3, psubject4, ppscore4, psubject5, ppscore5, psubject6, ppscore6, psubject7, ppscore7, psubject8, ppscore8, psubject9, ppscore9);
                JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnUpdateAssignmentScoresActionPerformed

    private void btnDeleteAssignmentScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteAssignmentScoresActionPerformed
        try {
            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;

            obj.deleteAssignmentScores(pstuRegNo, pclasss);
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnDeleteAssignmentScoresActionPerformed

    private void btnClearAssignmentScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearAssignmentScoresActionPerformed
        comboSubA1.setSelectedItem("<<Select Subject>>");
        comboSubA2.setSelectedItem("<<Select Subject>>");
        comboSubA3.setSelectedItem("<<Select Subject>>");
        comboSubA4.setSelectedItem("<<Select Subject>>");
        comboSubA5.setSelectedItem("<<Select Subject>>");
        comboSubA6.setSelectedItem("<<Select Subject>>");
        comboSubA7.setSelectedItem("<<Select Subject>>");
        comboSubA8.setSelectedItem("<<Select Subject>>");
        comboSubA9.setSelectedItem("<<Select Subject>>");

        txtTAScore1.setText(" ");
        txtTAScore2.setText(" ");
        txtTAScore3.setText(" ");
        txtTAScore4.setText(" ");
        txtTAScore5.setText(" ");
        txtTAScore6.setText(" ");
        txtTAScore7.setText(" ");
        txtTAScore8.setText(" ");
        txtTAScore9.setText(" ");
    }//GEN-LAST:event_btnClearAssignmentScoresActionPerformed

    private void txtTotalMarks9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalMarks9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalMarks9ActionPerformed

    private void comboSubA9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA9ActionPerformed

    private void comboSubA8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA8ActionPerformed

    private void comboSubA3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA3ActionPerformed

    private void comboSubA7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA7ActionPerformed

    private void comboSubA5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA5ActionPerformed

    private void comboSubA6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA6ActionPerformed

    private void comboSubA2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA2ActionPerformed

    private void comboSubA1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA1ActionPerformed

    private void comboSubA4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubA4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubA4ActionPerformed

    private void btnGenerateTermlyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerateTermlyReportActionPerformed
        GenerateStudentTermReport();
    }//GEN-LAST:event_btnGenerateTermlyReportActionPerformed

    private void txttotalmarksKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalmarksKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalmarksKeyTyped

    private void txtavgKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtavgKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtavgKeyTyped

    private void txtOverallGradeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOverallGradeKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOverallGradeKeyTyped

    private void btnInsertTermlyReortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertTermlyReortActionPerformed
        try {
            DecimalFormat df1 = new DecimalFormat("#.00");

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclass = selectedCurrentClass;
            String pterm = comboterm1T.getSelectedItem().toString();
            String pyear = txtyr.getText();
            String psubject1 = txtTotalSub1.getText();
            double pmarks1 = Double.parseDouble(df1.format(totalMark1));
            String pgrade1 = g1.getText();
            String psubject2 = txtTotalSub2.getText();
            double pmarks2 = Double.parseDouble(df1.format(totalMark2));;
            String pgrade2 = g2.getText();
            String psubject3 = txtTotalSub3.getText();
            double pmarks3 = Double.parseDouble(df1.format(totalMark3));;
            String pgrade3 = g3.getText();
            String psubject4 = txtTotalSub4.getText();
            double pmarks4 = Double.parseDouble(df1.format(totalMark4));;
            String pgrade4 = g4.getText();
            String psubject5 = txtTotalSub5.getText();
            double pmarks5 = Double.parseDouble(df1.format(totalMark5));;
            String pgrade5 = g5.getText();
            String psubject6 = txtTotalSub6.getText();
            double pmarks6 = Double.parseDouble(df1.format(totalMark6));;
            String pgrade6 = g6.getText();
            String psubject7 = txtTotalSub7.getText();
            double pmarks7 = Double.parseDouble(df1.format(totalMark7));;
            String pgrade7 = g7.getText();
            String psubject8 = txtTotalSub8.getText();
            double pmarks8 = Double.parseDouble(df1.format(totalMark8));;
            String pgrade8 = g8.getText();
            String psubject9 = txtTotalSub9.getText();
            double pmarks9 = Double.parseDouble(df1.format(totalMark9));;
            String pgrade9 = g9.getText();
            double ptotalMarks = Double.parseDouble(df1.format(grandTotal));
            double paverageMarks = Double.parseDouble(df1.format(average));
            String poverallGrade = overallGrade;

            obj.addTermlyReport(pstuRegNo, pclass, pyear, pterm, psubject1, pmarks1, pgrade1, psubject2, pmarks2, pgrade2, psubject3, pmarks3, pgrade3, psubject4, pmarks4, pgrade4, psubject5, pmarks5, pgrade5, psubject6, pmarks6, pgrade6, psubject7, pmarks7, pgrade7, psubject8, pmarks8, pgrade8, psubject9, pmarks9, pgrade9, ptotalMarks, paverageMarks, poverallGrade);
            JOptionPane.showMessageDialog(null, "Record Inserted Successfully !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnInsertTermlyReortActionPerformed

    private void btnSearchTermlyReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchTermlyReportActionPerformed

        DecimalFormat df2 = new DecimalFormat("#.00");
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclass = selectedCurrentClass;
            String pyear = txtyr.getText();
            String pterm = comboterm1T.getSelectedItem().toString();

            obj.getExamResults(pstuRegNo, pclass, pyear, pterm);
            txtshowStuNo.setText(selectedStudentRegNo);
            txtshowClass.setText(selectedCurrentClass);
            txtshowYear.setText(txtyr.getText());
            txtshowTerm.setText(comboterm1T.getSelectedItem().toString());

            ssub1.setText(obj.esub1);
            ssub2.setText(obj.esub2);
            ssub3.setText(obj.esub3);
            ssub4.setText(obj.esub4);
            ssub5.setText(obj.esub5);
            ssub6.setText(obj.esub6);
            ssub7.setText(obj.esub7);
            ssub8.setText(obj.esub8);
            ssub9.setText(obj.esub9);

            sm1.setText(String.valueOf(obj.emark1));
            sm2.setText(String.valueOf(obj.emark2));
            sm3.setText(String.valueOf(obj.emark3));
            sm4.setText(String.valueOf(obj.emark4));
            sm5.setText(String.valueOf(obj.emark5));
            sm6.setText(String.valueOf(obj.emark6));
            sm7.setText(String.valueOf(obj.emark7));
            sm8.setText(String.valueOf(obj.emark8));
            sm9.setText(String.valueOf(obj.emark9));

            sg1.setText(obj.egrade1);
            sg2.setText(obj.egrade2);
            sg3.setText(obj.egrade3);
            sg4.setText(obj.egrade4);
            sg5.setText(obj.egrade5);
            sg6.setText(obj.egrade6);
            sg7.setText(obj.egrade7);
            sg8.setText(obj.egrade8);
            sg9.setText(obj.egrade9);

            txttotalmarks1.setText(String.valueOf(df2.format((obj.etotal))));
            txtavg1.setText(String.valueOf(df2.format((obj.eavg))));
            txtOverallGrade1.setText(obj.eograde);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnSearchTermlyReportActionPerformed

    private void txttotalmarks1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txttotalmarks1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalmarks1KeyTyped

    private void txtavg1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtavg1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtavg1KeyTyped

    private void txtOverallGrade1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOverallGrade1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtOverallGrade1KeyTyped

    private void txttotalmarks1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttotalmarks1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttotalmarks1ActionPerformed

    private void g9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g9KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g9KeyTyped

    private void g8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g8KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g8KeyTyped

    private void g7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g7KeyTyped

    private void g6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g6KeyTyped

    private void g5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g5KeyTyped

    private void g4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g4KeyTyped

    private void g3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g3KeyTyped

    private void g2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g2KeyTyped

    private void g1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_g1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_g1KeyTyped

    private void btnAddActivityRecordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActivityRecordActionPerformed
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclass = selectedCurrentClass;
            String pdate = ((JTextField) TActivityDate.getDateEditor().getUiComponent()).getText();
            String pactivityName = comboTActivity.getSelectedItem().toString();
            String pactivityDescription = TActivityDes.getText();
            double pactivityMarks = Double.parseDouble(TActivityMarks.getText());

            obj.addActivityRecord(pstuRegNo, pclass, pdate, pactivityName, pactivityDescription, pactivityMarks);
            JOptionPane.showMessageDialog(null, "Record Inserted Succesfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddActivityRecordActionPerformed

    private void btnviewOverallPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnviewOverallPerformanceActionPerformed
        DecimalFormat df3 = new DecimalFormat("#.00");
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;
            obj.getExtracurricularStuMarks(pstuRegNo, pclasss);
            ActivityMarks = 0;
            int len3 = obj.AllActivitiesStuMarks.size();
            for (int k = 0; k < len3; k++) {
                ActivityMarks += Double.parseDouble(obj.AllActivitiesStuMarks.get(k));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
//            
            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;
            String pyear = txtyr.getText();
            String pterm = comboterm1T.getSelectedItem().toString();

            obj.getExamResults(pstuRegNo, pclasss, pyear, pterm);
            FinalExamMarks = obj.etotal;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        FINALMARKS = FinalExamMarks + ActivityMarks;
        txtFinalTotal.setText(String.valueOf(df3.format(FINALMARKS)));

        txtExM.setText(String.valueOf(df3.format(FinalExamMarks)));

        txtECAM.setText(String.valueOf(ActivityMarks));

        FINALAVERAGE = FINALMARKS / 9.0;

        txtFinalAvg.setText(String.valueOf(df3.format(FINALAVERAGE)));

        if (FINALAVERAGE < 35.0) {
            FINALGRADE = "W";
        } else if (FINALAVERAGE >= 35.0 && FINALAVERAGE <= 54.9) {
            FINALGRADE = "S";
        } else if (FINALAVERAGE >= 55.0 && FINALAVERAGE <= 64.9) {
            FINALGRADE = "C";
        } else if (FINALAVERAGE >= 65.0 && FINALAVERAGE <= 74.9) {
            FINALGRADE = "B";
        } else if (FINALAVERAGE >= 75.0 && FINALAVERAGE <= 89.9) {
            FINALGRADE = "A";
        } else if (FINALAVERAGE >= 90.0) {
            FINALGRADE = "A+";
        }
        txtOg.setText(FINALGRADE);

    }//GEN-LAST:event_btnviewOverallPerformanceActionPerformed

    private void txtExMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtExMKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtExMKeyTyped

    private void btnAddBehaviourStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBehaviourStuActionPerformed
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo2);
            String pclass = selectedCurrentClass2;
            String pincidentDate = ((JTextField) incidentDate.getDateEditor().getUiComponent()).getText();
            String pbehaviourType = comboBehaviourType.getSelectedItem().toString();
            String pbehaviourNote = txtBehavoiurNote.getText();
            String pnextAction = txtNextAction.getText();
            String pactionDate = ((JTextField) actionDate.getDateEditor().getUiComponent()).getText();

            obj.addBehaviourStuRecord(pstuRegNo, pclass, pincidentDate, pbehaviourType, pbehaviourNote, pnextAction, pactionDate);
            JOptionPane.showMessageDialog(null, "Record Inserted Successully !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnAddBehaviourStuActionPerformed

    private void btnUpdateBehaviourStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBehaviourStuActionPerformed
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo3);
            String pclass = selectedCurrentClass3;
            String pincidentDate = ((JTextField) incidentDate.getDateEditor().getUiComponent()).getText();
            String pbehaviourType = comboBehaviourType.getSelectedItem().toString();
            String pbehaviourNote = txtBehavoiurNote.getText();
            String pnextAction = txtNextAction.getText();
            String pactionDate = ((JTextField) actionDate.getDateEditor().getUiComponent()).getText();
            int pselectedbehaviourRecordID = Integer.parseInt(selectedbehaviourRecordID);

            obj.updateBehaviourStuRecord(pstuRegNo, pclass, pincidentDate, pbehaviourType, pbehaviourNote, pnextAction, pactionDate, pselectedbehaviourRecordID);
            JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnUpdateBehaviourStuActionPerformed

    private void btnDeleteBehaviourStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBehaviourStuActionPerformed
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo3);
            String pclass = selectedCurrentClass3;
            String pincidentDate = ((JTextField) incidentDate.getDateEditor().getUiComponent()).getText();
            String pbehaviourType = comboBehaviourType.getSelectedItem().toString();
            String pbehaviourNote = txtBehavoiurNote.getText();
            String pnextAction = txtNextAction.getText();
            String pactionDate = ((JTextField) actionDate.getDateEditor().getUiComponent()).getText();

            obj.deleteBehaviourStuRecord(pstuRegNo, pclass, pincidentDate, pbehaviourType, pbehaviourNote, pnextAction, pactionDate);
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnDeleteBehaviourStuActionPerformed

    private void btnClearBehaviourStuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBehaviourStuActionPerformed

        txtSTID.setText(" ");
        txtBehavoiurNote.setText(" ");
        txtNextAction.setText(" ");
        incidentDate.setDate(null);
        actionDate.setDate(null);
        comboBehaviourType.setSelectedItem("<<Select Behavoiur Type>>");
    }//GEN-LAST:event_btnClearBehaviourStuActionPerformed

    private void btnAddBehaviourTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBehaviourTypeActionPerformed

        String positive = null;
        String negative = null;
        try {

            int pbehaviourID = Integer.parseInt(txtBehaviourId.getText());
            String pbehavoiurType = txtBehaviourType.getText();
            String pOn = null;

            if (ChkBoxpositive.isSelected()) {
                positive = "Positive";
                pOn = positive;
            } else {
                pOn = "Negative";
            }
            String ppositiveOrNegative = pOn;
            obj.addBehaviourTypeRecord(pbehaviourID, pbehavoiurType, ppositiveOrNegative);
            JOptionPane.showMessageDialog(null, "Record Inserted Successully !");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnAddBehaviourTypeActionPerformed

    private void btnUpdateBehaviourTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBehaviourTypeActionPerformed

        String positiveU = null;
        try {

            int pbehaviourID = Integer.parseInt(txtBehaviourId.getText());
            String pbehavoiurType = txtBehaviourType.getText();
            String pOn = null;

            if (ChkBoxpositive.isSelected()) {
                positiveU = "Positive";
                pOn = positiveU;
            } else {
                pOn = "Negative";
            }
            String ppositiveOrNegative = pOn;

            obj.updateBehaviourTypeRecord(pbehaviourID, pbehavoiurType, ppositiveOrNegative);
            JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnUpdateBehaviourTypeActionPerformed

    private void btnDeleteBehaviourTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBehaviourTypeActionPerformed
        try {

            int pbehaviourID = Integer.parseInt(txtBehaviourId.getText());
            obj.deleteBehaviourTypeRecord(pbehaviourID);
            JOptionPane.showMessageDialog(null, "Record Deleted Successfully !");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btnDeleteBehaviourTypeActionPerformed

    private void btnClearBehaviourTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBehaviourTypeActionPerformed
        txtBehaviourId.setText(" ");
        txtBehaviourType.setText(" ");
        ChkBoxpositive.setSelected(false);
    }//GEN-LAST:event_btnClearBehaviourTypeActionPerformed

    private void tblBehavioutStuListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBehavioutStuListMouseClicked

        try {
            int row = tblBehavioutStuList.getSelectedRow();
            String tblClick = (tblBehavioutStuList.getModel().getValueAt(row, 0).toString());

            obj.getSelectedStuInfo(Integer.parseInt(tblClick));
            selectedStudentRegNo2 = obj.pselectedStudentRegNo;
            selectedCurrentClass2 = obj.pselectedCurrentClass;

            txtSTID.setText(selectedStudentRegNo2);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tblBehavioutStuListMouseClicked

    private void txtSTIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSTIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSTIDActionPerformed

    private void txtBehaviourIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBehaviourIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBehaviourIdActionPerformed

    private void txtBehaviourTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBehaviourTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBehaviourTypeActionPerformed

    private void tblBehaviourInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBehaviourInfoMouseClicked
        try {
            int row = tblBehaviourInfo.getSelectedRow();
            String tblClick = (tblBehaviourInfo.getModel().getValueAt(row, 0).toString());

            obj.getSelectedBehaviourInfo(Integer.parseInt(tblClick));
            selectedBehaviourID = obj.pselectedbehaviourID;
            selectedBehaviourType = obj.pselectedbehavoiurType;

            txtBehaviourId.setText(selectedBehaviourID);
            txtBehaviourType.setText(selectedBehaviourType);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_tblBehaviourInfoMouseClicked

    private void tblBehavioutStuListshowAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBehavioutStuListshowAllMouseClicked
        String inDate = null, BType = null, BNote = null, NextAction = null, ADate = null;
        try {
            int row = tblBehavioutStuListshowAll.getSelectedRow();
            String tblClick = (tblBehavioutStuListshowAll.getModel().getValueAt(row, 0).toString());

            obj.getStuBehaviourInfo(Integer.parseInt(tblClick));
            selectedStudentRegNo3 = obj.pselectedStudentRegNo3;
            selectedCurrentClass3 = obj.pselectedCurrentClass3;
            selectedbehaviourRecordID = obj.pselectedbehaviourRecordID;

            txtSTID.setText(obj.pselectedStudentRegNo3);
            incidentDate.setDate(Date.valueOf(obj.pincidentDate));
            comboBehaviourType.setSelectedItem(obj.pbehaviourType);
            txtBehavoiurNote.setText(obj.pbehaviourNote);
            txtNextAction.setText(obj.pnextAction);
            actionDate.setDate(Date.valueOf(obj.pactionDate));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tblBehavioutStuListshowAllMouseClicked

    private void btnViewTermTestMarksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewTermTestMarksActionPerformed
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;
            String pyear = txtyr.getText();
            String pterm = comboterm1T.getSelectedItem().toString();

            obj.getTermTestMarks(pstuRegNo, pclasss, pyear, pterm);
            comboSub1.setSelectedItem(obj.ttsub1);
            comboSub2.setSelectedItem(obj.ttsub2);
            comboSub3.setSelectedItem(obj.ttsub3);
            comboSub4.setSelectedItem(obj.ttsub4);
            comboSub5.setSelectedItem(obj.ttsub5);
            comboSub6.setSelectedItem(obj.ttsub6);
            comboSub7.setSelectedItem(obj.ttsub7);
            comboSub8.setSelectedItem(obj.ttsub8);
            comboSub9.setSelectedItem(obj.ttsub9);

            txtTAMarks1.setText(String.valueOf(obj.ttmark1));
            txtTAMarks2.setText(String.valueOf(obj.ttmark2));
            txtTAMarks3.setText(String.valueOf(obj.ttmark3));
            txtTAMarks4.setText(String.valueOf(obj.ttmark4));
            txtTAMarks5.setText(String.valueOf(obj.ttmark5));
            txtTAMarks6.setText(String.valueOf(obj.ttmark6));
            txtTAMarks7.setText(String.valueOf(obj.ttmark7));
            txtTAMarks8.setText(String.valueOf(obj.ttmark8));
            txtTAMarks9.setText(String.valueOf(obj.ttmark9));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnViewTermTestMarksActionPerformed

    private void txtshowStuNo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtshowStuNo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtshowStuNo2ActionPerformed

    private void txtyrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyrActionPerformed

    private void txtyrKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyrKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Digits Only !");

        }
    }//GEN-LAST:event_txtyrKeyTyped

    private void btnADDOverallPerformanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDOverallPerformanceActionPerformed
        DecimalFormat df3 = new DecimalFormat("#.00");
        if (ActivityMarks > 0) {

            try {

                int pStudentRegNo = Integer.parseInt(selectedStudentRegNo);
                String pclass = selectedCurrentClass;
                String pyear = txtyr.getText();
                String pterm = comboterm1T.getSelectedItem().toString();
                double pextracurricularActivitiesMarks = ActivityMarks;
                double ptotalMarks = Double.parseDouble(txtFinalTotal.getText());
                double paverageMarks = Double.parseDouble(df3.format(FINALAVERAGE));
                String poverallGrade = FINALGRADE;

                obj.updateExamResults(pStudentRegNo, pclass, pyear, pterm, pextracurricularActivitiesMarks, ptotalMarks, paverageMarks, poverallGrade);
                JOptionPane.showMessageDialog(null, "Record Updated Successfully !");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }

        } else if (ActivityMarks <= 0) {
            JOptionPane.showMessageDialog(null, "No Need to Update the Reocrd");
        }
    }//GEN-LAST:event_btnADDOverallPerformanceActionPerformed

    private void ireportstudentlistALLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ireportstudentlistALLActionPerformed

        try {
            String studentList = "src/SPMS_IREPORTS/StudentsList.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(studentList);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_ireportstudentlistALLActionPerformed

    private void btnReportExramComapreclassesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportExramComapreclassesActionPerformed

        try {

            String pclass = comboclassAc1.getSelectedItem().toString();
            obj.getExtracurricularStu(pclass);
            countAstu = String.valueOf(obj.pExtracurricularStuCount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {

            String pclass = comboclassAc2.getSelectedItem().toString();
            obj.getExtracurricularStu(pclass);
            countAstu2 = String.valueOf(obj.pExtracurricularStuCount);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

       
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        dataset.setValue(Integer.parseInt(countAstu), "Participattion", comboclassAc1.getSelectedItem().toString());
        dataset.setValue(Integer.parseInt(countAstu2), "Participattion", comboclassAc2.getSelectedItem().toString());

        JFreeChart chart = ChartFactory.createBarChart("Student Participation", "Class", "No of Students", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar Chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_btnReportExramComapreclassesActionPerformed

    private void btnCompareActiVsParticpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompareActiVsParticpActionPerformed

        try {
            String sqlA1 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA1);
            pst.setString(1, "Boxing");
            rs = pst.executeQuery();
            if (rs.next()) {
                countBoxing = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA2 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA2);
            pst.setString(1, "Badminton");
            rs = pst.executeQuery();
            if (rs.next()) {
                countBadminton = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA3 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA3);
            pst.setString(1, "Basket ball");
            rs = pst.executeQuery();
            if (rs.next()) {
                countBasketball = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA4 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA4);
            pst.setString(1, "Bowling");
            rs = pst.executeQuery();
            if (rs.next()) {
                countBowling = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA5 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA5);
            pst.setString(1, "Chess");
            rs = pst.executeQuery();
            if (rs.next()) {
                countChess = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA6 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA6);
            pst.setString(1, "Cricket");
            rs = pst.executeQuery();
            if (rs.next()) {
                countCricket = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA7 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA7);
            pst.setString(1, "Hokey");
            rs = pst.executeQuery();
            if (rs.next()) {
                countHokey = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA8 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA8);
            pst.setString(1, "Swimming");
            rs = pst.executeQuery();
            if (rs.next()) {
                countSwimming = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA9 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA9);
            pst.setString(1, "Table Tennis");
            rs = pst.executeQuery();
            if (rs.next()) {
                countTableTennis = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        try {
            String sqlA10 = "SELECT count(*) FROM spms_extracurricular WHERE activityName=? ";
            pst = conn.prepareStatement(sqlA10);
            pst.setString(1, "Volleyball");
            rs = pst.executeQuery();
            if (rs.next()) {
                countVolleyball = String.valueOf(rs.getInt(1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        DefaultPieDataset piedataset = new DefaultPieDataset();
        piedataset.setValue("Badminton", new Integer(countBadminton));
        piedataset.setValue("Basketball", new Integer(countBasketball));
        piedataset.setValue("Bowling", new Integer(countBowling));
        piedataset.setValue("Boxing", new Integer(countBoxing));
        piedataset.setValue("Chess", new Integer(countChess));
        piedataset.setValue("Cricket", new Integer(countCricket));
        piedataset.setValue("Hokey", new Integer(countHokey));
        piedataset.setValue("Swimming", new Integer(countSwimming));
        piedataset.setValue("TableTennis", new Integer(countTableTennis));
        piedataset.setValue("Volleyball", new Integer(countVolleyball));

        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", piedataset, true, true, true);
        PiePlot3D p = (PiePlot3D) chart.getPlot();

        ChartFrame frame = new ChartFrame("Pie chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
        
    }//GEN-LAST:event_btnCompareActiVsParticpActionPerformed

    private void btn_update12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update12ActionPerformed
        HashMap fp_p1 = new HashMap();
        fp_p1.put("pstu", selectedActivityStuRegNo.getText());

        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("src/SPMS_IREPORTS/StudentExtracurricularActivity.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_btn_update12ActionPerformed

    private void btn_update11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update11ActionPerformed
        HashMap fp_p1 = new HashMap();
        fp_p1.put("pactivity", comboTActivity1.getSelectedItem().toString());

        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("C:\\xampp\\htdocs\\ITP\\IREPORTS\\SpecificExtracurricularActivity.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_btn_update11ActionPerformed

    private void btn_update10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update10ActionPerformed

        try {
            String studentList = "src/SPMS_IREPORTS/AllExtracurricularActivities.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(studentList);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
            JasperViewer.viewReport(jp, false);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_update10ActionPerformed

    private void btnClearReportsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearReportsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearReportsActionPerformed

    private void comboSubReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSubReportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSubReportActionPerformed

    private void txtStuRegReport3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStuRegReport3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStuRegReport3KeyTyped

    private void txtStuRegReport1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStuRegReport1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStuRegReport1KeyTyped

    private void btnColumnChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnColumnChartActionPerformed

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(Double.parseDouble(selectedMark1A), "Marks", selectedSub1A);
        dataset.setValue(Double.parseDouble(selectedMark2A), "Marks", selectedSub2A);
        dataset.setValue(Double.parseDouble(selectedMark3A), "Marks", selectedSub3A);
        dataset.setValue(Double.parseDouble(selectedMark4A), "Marks", selectedSub4A);
        dataset.setValue(Double.parseDouble(selectedMark5A), "Marks", selectedSub5A);
        dataset.setValue(Double.parseDouble(selectedMark6A), "Marks", selectedSub6A);
        dataset.setValue(Double.parseDouble(selectedMark7A), "Marks", selectedSub7A);
        dataset.setValue(Double.parseDouble(selectedMark8A), "Marks", selectedSub8A);
        dataset.setValue(Double.parseDouble(selectedMark9A), "Marks", selectedSub9A);

        JFreeChart chart = ChartFactory.createBarChart("Student Marks", "Subjects", "Marks", dataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot p = chart.getCategoryPlot();
        p.setRangeGridlinePaint(Color.black);
        ChartFrame frame = new ChartFrame("Bar Chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 350);
    }//GEN-LAST:event_btnColumnChartActionPerformed

    private void btn_update15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update15ActionPerformed

        HashMap fp_p1 = new HashMap();
        fp_p1.put("stuRegNo", txtStuRegReport3.getText());

        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("src/SPMS_IREPORTS/StudentReport.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_btn_update15ActionPerformed

    private void txtyrreportKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtyrreportKeyTyped
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Digits Only !");

        }
    }//GEN-LAST:event_txtyrreportKeyTyped

    private void txtyrreportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyrreportActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyrreportActionPerformed

    private void btn_update1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update1ActionPerformed

        HashMap fp_p1 = new HashMap();
        fp_p1.put("pyear", txtyrreport.getText());
        fp_p1.put("pclass", comboclassReport.getSelectedItem().toString());
        fp_p1.put("pterm", combotermReport.getSelectedItem().toString());

        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("src/SPMS_IREPORTS/Marking.jasper", fp_p1);
        showReport_fp.setVisible(true);

    }//GEN-LAST:event_btn_update1ActionPerformed

    private void btnPieChartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPieChartActionPerformed

        try {

            String psubject1 = comboSubReport.getSelectedItem().toString();
            String psubject2 = comboSubReport.getSelectedItem().toString();
            String psubject3 = comboSubReport.getSelectedItem().toString();
            String psubject4 = comboSubReport.getSelectedItem().toString();
            String psubject5 = comboSubReport.getSelectedItem().toString();
            String psubject6 = comboSubReport.getSelectedItem().toString();
            String psubject7 = comboSubReport.getSelectedItem().toString();
            String psubject8 = comboSubReport.getSelectedItem().toString();
            String psubject9 = comboSubReport.getSelectedItem().toString();

            obj.countSpecificStu(psubject1, psubject2, psubject3, psubject4, psubject5, psubject6, psubject7, psubject8, psubject9);
            countBSub1 = String.valueOf(obj.specificStudentCount);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        try {

            obj.countAllStu();
            countStu = String.valueOf(obj.allStudentCount);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        DefaultPieDataset piedataset = new DefaultPieDataset();
        piedataset.setValue(comboSubReport.getSelectedItem().toString(), new Double(countBSub1));
        piedataset.setValue("No Of Students", new Integer(countStu));

        JFreeChart chart = ChartFactory.createPieChart3D("Pie Chart", piedataset, true, true, true);
        PiePlot3D p = (PiePlot3D) chart.getPlot();

        ChartFrame frame = new ChartFrame("Pie chart", chart);
        frame.setVisible(true);
        frame.setSize(450, 500);
    }//GEN-LAST:event_btnPieChartActionPerformed

    private void txtPrecentageReportKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecentageReportKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecentageReportKeyTyped

    private void btn_update2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_update2ActionPerformed
        HashMap fp_p1 = new HashMap();
        fp_p1.put("pyear", txtyrreport.getText());
        fp_p1.put("pclass", comboclassReport.getSelectedItem().toString());
        fp_p1.put("pterm", combotermReport.getSelectedItem().toString());
        fp_p1.put("pavg", txtPrecentageReport.getText());
        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("C:\\xampp\\htdocs\\ITP\\IREPORTS\\SPMS_AVgMarksGreaterP.jasper", fp_p1);
        showReport_fp.setVisible(true);

    }//GEN-LAST:event_btn_update2ActionPerformed

    private void tblAcademicDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAcademicDataMouseClicked

        try {
            int row = tblAcademicData.getSelectedRow();
            String tblClick = (tblAcademicData.getModel().getValueAt(row, 0).toString());
            String tblClick2 = (tblAcademicData.getModel().getValueAt(row, 1).toString());
            String tblClick3 = (tblAcademicData.getModel().getValueAt(row, 2).toString());
            String tblClick4 = (tblAcademicData.getModel().getValueAt(row, 3).toString());

            int pstuRegNo = Integer.parseInt(tblClick);
            String pclass = tblClick2;
            String pyear = tblClick3;
            String pterm = tblClick4;

            selectedStudentRegNoA = tblClick;
            selectedCurrentClassA = tblClick2;

            obj.getExamResults(pstuRegNo, pclass, pyear, pterm);
            selectedSub1A = obj.esub1;
            selectedSub2A = obj.esub2;
            selectedSub3A = obj.esub3;
            selectedSub4A = obj.esub4;
            selectedSub5A = obj.esub5;
            selectedSub6A = obj.esub6;
            selectedSub7A = obj.esub7;
            selectedSub8A = obj.esub8;
            selectedSub9A = obj.esub9;

            selectedMark1A = String.valueOf(obj.emark1);
            selectedMark2A = String.valueOf(obj.emark2);
            selectedMark3A = String.valueOf(obj.emark3);
            selectedMark4A = String.valueOf(obj.emark4);
            selectedMark5A = String.valueOf(obj.emark5);
            selectedMark6A = String.valueOf(obj.emark6);
            selectedMark7A = String.valueOf(obj.emark7);
            selectedMark8A = String.valueOf(obj.emark8);
            selectedMark9A = String.valueOf(obj.emark9);

            txtStuRegReport1.setText(selectedStudentRegNoA);
            txtStuRegReport3.setText(selectedStudentRegNoA);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tblAcademicDataMouseClicked

    private void btnViewAcademicDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAcademicDataActionPerformed
        showAcademicTable();
    }//GEN-LAST:event_btnViewAcademicDataActionPerformed

    private void btnViewAcademicData1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAcademicData1ActionPerformed

        showExtraCurricularTable();
    }//GEN-LAST:event_btnViewAcademicData1ActionPerformed

    private void tblExtraCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblExtraCMouseClicked

        try {
            int row = tblExtraC.getSelectedRow();
            String tblClick = (tblExtraC.getModel().getValueAt(row, 0).toString());

            obj.getExtracurricularStuRecords(tblClick);

            selectedStudentRegNoAc = obj.pselectedStudentRegNoAc;
            selectedCurrentClassAc = obj.pselectedCurrentClassAc;

            obj.getExtracurricularStuATypes(Integer.parseInt(selectedStudentRegNoAc), selectedCurrentClassAc);
            obj.getExtracurricularStuMarks(Integer.parseInt(selectedStudentRegNoAc), selectedCurrentClassAc);

            int len = obj.AllActivitiesStuATypes.size();
            for (int i = 0; i < len; i++) {
                activities.add(String.valueOf(obj.AllActivitiesStuATypes.get(i)));
            }

            int len2 = obj.AllActivitiesStuMarks.size();
            for (int j = 0; j < len2; j++) {
                activitymarks.add(String.valueOf(obj.AllActivitiesStuMarks.get(j)));
            }

            selectedActivityStuRegNo.setText(selectedStudentRegNoAc);
            activitiesAr = activities.toArray(activitiesAr);
            activitymarksAr = activitymarks.toArray(activitymarksAr);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_tblExtraCMouseClicked

    private void btnClearReports1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearReports1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnClearReports1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        showStudentsList();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        viewStudentInfo();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        viewRequestedDocDetails();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        showAcademicTable();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        showExtraCurricularTable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void ireportstudentlistALL1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ireportstudentlistALL1ActionPerformed

        HashMap fp_p1 = new HashMap();
        fp_p1.put("pstu", txtSearchStudent.getText());

        IREPORT_PARAMETERIZED showReport_fp = new IREPORT_PARAMETERIZED("src/SPMS_IREPORTS/ProfileStudent.jasper", fp_p1);
        showReport_fp.setVisible(true);
    }//GEN-LAST:event_ireportstudentlistALL1ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        viewBehaviourShowAllStudents();
        viewBehaviourStuList();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

        viewBehaviourInfoList();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void txtTAMarks1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks1KeyTyped

//        char c = evt.getKeyChar();
//        
//        if(!(Character.isDigit(c)||(c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }

    }//GEN-LAST:event_txtTAMarks1KeyTyped

    private void txtTAMarks2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks2KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks2KeyTyped

    private void txtTAMarks3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks3KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks3KeyTyped

    private void txtTAMarks4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks4KeyTyped

//       char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks4KeyTyped

    private void txtTAMarks5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks5KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks5KeyTyped

    private void txtTAMarks6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks6KeyTyped

//       char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks6KeyTyped

    private void txtTAMarks7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks7KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks7KeyTyped

    private void txtTAMarks8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks8KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks8KeyTyped

    private void txtTAMarks9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAMarks9KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAMarks9KeyTyped

    private void txtTAScore1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore1KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore1KeyTyped

    private void txtTAScore2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore2KeyTyped

//       char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore2KeyTyped

    private void txtTAScore3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore3KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore3KeyTyped

    private void txtTAScore4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore4KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore4KeyTyped

    private void txtTAScore5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore5KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore5KeyTyped

    private void txtTAScore6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore6KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore6KeyTyped

    private void txtTAScore7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore7KeyTyped

//       char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore7KeyTyped

    private void txtTAScore8KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore8KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore8KeyTyped

    private void txtTAScore9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTAScore9KeyTyped

//        char c = evt.getKeyChar();
//        if(!(Character.isDigit(c)|| (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
//            getToolkit().beep();
//            evt.consume();
//            JOptionPane.showMessageDialog(null, "Enter Digits Only !");
//        
//        }
    }//GEN-LAST:event_txtTAScore9KeyTyped

    private void TActivityMarksKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TActivityMarksKeyTyped

        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(null, "Enter Digits Only !");

        }
    }//GEN-LAST:event_TActivityMarksKeyTyped

    private void btnViewAssignmentScoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewAssignmentScoresActionPerformed
        try {

            int pstuRegNo = Integer.parseInt(selectedStudentRegNo);
            String pclasss = selectedCurrentClass;

            obj.getAssignmentScores(pstuRegNo, pclasss);
            comboSubA1.setSelectedItem(obj.asub1);
            comboSubA2.setSelectedItem(obj.asub2);
            comboSubA3.setSelectedItem(obj.asub3);
            comboSubA4.setSelectedItem(obj.asub4);
            comboSubA5.setSelectedItem(obj.asub5);
            comboSubA6.setSelectedItem(obj.asub6);
            comboSubA7.setSelectedItem(obj.asub7);
            comboSubA8.setSelectedItem(obj.asub8);
            comboSubA9.setSelectedItem(obj.asub9);

            txtTAScore1.setText(String.valueOf(obj.ascore1));
            txtTAScore2.setText(String.valueOf(obj.ascore2));
            txtTAScore3.setText(String.valueOf(obj.ascore3));
            txtTAScore4.setText(String.valueOf(obj.ascore4));
            txtTAScore5.setText(String.valueOf(obj.ascore5));
            txtTAScore6.setText(String.valueOf(obj.ascore6));
            txtTAScore7.setText(String.valueOf(obj.ascore7));
            txtTAScore8.setText(String.valueOf(obj.ascore8));
            txtTAScore9.setText(String.valueOf(obj.ascore9));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btnViewAssignmentScoresActionPerformed

    private void btnClearOverallActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearOverallActionPerformed
        txtExM.setText(null);
        txtECAM.setText(null);
        txtFinalTotal.setText(null);
        txtFinalAvg.setText(null);
        txtOg.setText(null);

    }//GEN-LAST:event_btnClearOverallActionPerformed

    private void jCalendarSPMSCalendar1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jCalendarSPMSCalendar1ComponentShown

    }//GEN-LAST:event_jCalendarSPMSCalendar1ComponentShown

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed

        ViewNotices();
    }//GEN-LAST:event_jButton10ActionPerformed

    //private ImageIcon format = null;
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
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SPMS_StudentProfileManageTeacher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SPMS_StudentProfileManageTeacher().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(SPMS_StudentProfileManageTeacher.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SPMS_StudentProfileManageTeacher.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ChkBoxpositive;
    private javax.swing.JDesktopPane DesktopPaneSPMSProfilePic5;
    private com.toedter.calendar.JDateChooser TActivityDate;
    private javax.swing.JTextArea TActivityDes;
    private javax.swing.JTextField TActivityMarks;
    private javax.swing.JPanel TaccessStuinfo;
    private javax.swing.JPanel TanalyzePerformance;
    private javax.swing.JPanel Tbehaviour;
    private javax.swing.JPanel TgenerateReportsnStat;
    private javax.swing.JPanel Topic;
    private javax.swing.JTabbedPane ac;
    private com.toedter.calendar.JDateChooser actionDate;
    private javax.swing.JScrollPane behaviourNote;
    private javax.swing.JPanel bg;
    private javax.swing.JButton btnADDOverallPerformance;
    private javax.swing.JButton btnAddActivityRecord;
    private javax.swing.JButton btnAddBehaviourStu;
    private javax.swing.JButton btnAddBehaviourType;
    private javax.swing.JButton btnAddTAssignment;
    private javax.swing.JButton btnAddTMarks;
    private javax.swing.JButton btnClearAssignmentScores;
    private javax.swing.JButton btnClearBehaviourStu;
    private javax.swing.JButton btnClearBehaviourType;
    private javax.swing.JButton btnClearOfficialDocRequests;
    private javax.swing.JButton btnClearOverall;
    private javax.swing.JButton btnClearReports;
    private javax.swing.JButton btnClearReports1;
    private javax.swing.JButton btnClearTermTestMarks;
    private javax.swing.JButton btnColumnChart;
    private javax.swing.JButton btnCompareActiVsParticp;
    private javax.swing.JButton btnDeleteAssignmentScores;
    private javax.swing.JButton btnDeleteBehaviourStu;
    private javax.swing.JButton btnDeleteBehaviourType;
    private javax.swing.JButton btnDeleteTermTestMarks;
    private javax.swing.JButton btnGenerateTermlyReport;
    private javax.swing.JButton btnInsertTermlyReort;
    private javax.swing.JButton btnPieChart;
    private javax.swing.JButton btnPrintTProfile;
    private javax.swing.JButton btnReportExramComapreclasses;
    private javax.swing.JButton btnSearchTermlyReport;
    private javax.swing.JButton btnUpdateAssignmentScores;
    private javax.swing.JButton btnUpdateBehaviourStu;
    private javax.swing.JButton btnUpdateBehaviourType;
    private javax.swing.JButton btnUpdateTermTestMarks;
    private javax.swing.JButton btnVerifyDocDetails;
    private javax.swing.JButton btnViewAcademicData;
    private javax.swing.JButton btnViewAcademicData1;
    private javax.swing.JButton btnViewAssignmentScores;
    private javax.swing.JButton btnViewOfficialDocRequests;
    private javax.swing.JButton btnViewStudentsList;
    private javax.swing.JButton btnViewTermTestMarks;
    private javax.swing.JButton btn_update1;
    private javax.swing.JButton btn_update10;
    private javax.swing.JButton btn_update11;
    private javax.swing.JButton btn_update12;
    private javax.swing.JButton btn_update15;
    private javax.swing.JButton btn_update2;
    private javax.swing.JButton btnviewOverallPerformance;
    private javax.swing.JComboBox<String> comboBehaviourType;
    private javax.swing.JComboBox<String> comboSub1;
    private javax.swing.JComboBox<String> comboSub2;
    private javax.swing.JComboBox<String> comboSub3;
    private javax.swing.JComboBox<String> comboSub4;
    private javax.swing.JComboBox<String> comboSub5;
    private javax.swing.JComboBox<String> comboSub6;
    private javax.swing.JComboBox<String> comboSub7;
    private javax.swing.JComboBox<String> comboSub8;
    private javax.swing.JComboBox<String> comboSub9;
    private javax.swing.JComboBox<String> comboSubA1;
    private javax.swing.JComboBox<String> comboSubA2;
    private javax.swing.JComboBox<String> comboSubA3;
    private javax.swing.JComboBox<String> comboSubA4;
    private javax.swing.JComboBox<String> comboSubA5;
    private javax.swing.JComboBox<String> comboSubA6;
    private javax.swing.JComboBox<String> comboSubA7;
    private javax.swing.JComboBox<String> comboSubA8;
    private javax.swing.JComboBox<String> comboSubA9;
    private javax.swing.JComboBox<String> comboSubReport;
    private javax.swing.JComboBox<String> comboTActivity;
    private javax.swing.JComboBox<String> comboTActivity1;
    private javax.swing.JComboBox<String> comboclassAc1;
    private javax.swing.JComboBox<String> comboclassAc2;
    private javax.swing.JComboBox<String> comboclassReport;
    private javax.swing.JComboBox<String> comboterm1T;
    private javax.swing.JComboBox<String> combotermReport;
    private javax.swing.JPanel dashBoard;
    private javax.swing.JPanel forms;
    private javax.swing.JTextField g1;
    private javax.swing.JTextField g2;
    private javax.swing.JTextField g3;
    private javax.swing.JTextField g4;
    private javax.swing.JTextField g5;
    private javax.swing.JTextField g6;
    private javax.swing.JTextField g7;
    private javax.swing.JTextField g8;
    private javax.swing.JTextField g9;
    private com.toedter.calendar.JDateChooser incidentDate;
    private javax.swing.JButton ireportstudentlistALL;
    private javax.swing.JButton ireportstudentlistALL1;
    private javax.swing.JPanel iuds10;
    private javax.swing.JPanel iuds13;
    private javax.swing.JPanel iuds9;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private com.toedter.calendar.JCalendar jCalendarSPMSCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel151;
    private javax.swing.JLabel jLabel152;
    private javax.swing.JLabel jLabel153;
    private javax.swing.JLabel jLabel154;
    private javax.swing.JLabel jLabel155;
    private javax.swing.JLabel jLabel156;
    private javax.swing.JLabel jLabel157;
    private javax.swing.JLabel jLabel158;
    private javax.swing.JLabel jLabel159;
    private javax.swing.JLabel jLabel160;
    private javax.swing.JLabel jLabel161;
    private javax.swing.JLabel jLabel162;
    private javax.swing.JLabel jLabel163;
    private javax.swing.JLabel jLabel164;
    private javax.swing.JLabel jLabel165;
    private javax.swing.JLabel jLabel166;
    private javax.swing.JLabel jLabel167;
    private javax.swing.JLabel jLabel168;
    private javax.swing.JLabel jLabel169;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel171;
    private javax.swing.JLabel jLabel172;
    private javax.swing.JLabel jLabel173;
    private javax.swing.JLabel jLabel174;
    private javax.swing.JLabel jLabel175;
    private javax.swing.JLabel jLabel176;
    private javax.swing.JLabel jLabel177;
    private javax.swing.JLabel jLabel178;
    private javax.swing.JLabel jLabel179;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel180;
    private javax.swing.JLabel jLabel181;
    private javax.swing.JLabel jLabel182;
    private javax.swing.JLabel jLabel183;
    private javax.swing.JLabel jLabel184;
    private javax.swing.JLabel jLabel185;
    private javax.swing.JLabel jLabel186;
    private javax.swing.JLabel jLabel187;
    private javax.swing.JLabel jLabel188;
    private javax.swing.JLabel jLabel189;
    private javax.swing.JLabel jLabel190;
    private javax.swing.JLabel jLabel191;
    private javax.swing.JLabel jLabel192;
    private javax.swing.JLabel jLabel193;
    private javax.swing.JLabel jLabel194;
    private javax.swing.JLabel jLabel199;
    private javax.swing.JLabel jLabel200;
    private javax.swing.JLabel jLabel201;
    private javax.swing.JLabel jLabel202;
    private javax.swing.JLabel jLabel203;
    private javax.swing.JLabel jLabel204;
    private javax.swing.JLabel jLabel205;
    private javax.swing.JLabel jLabel206;
    private javax.swing.JLabel jLabel207;
    private javax.swing.JLabel jLabel208;
    private javax.swing.JLabel jLabel209;
    private javax.swing.JLabel jLabel210;
    private javax.swing.JLabel jLabel211;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JPanel jPanel1;
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
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel28;
    private javax.swing.JPanel jPanel29;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel30;
    private javax.swing.JPanel jPanel31;
    private javax.swing.JPanel jPanel32;
    private javax.swing.JPanel jPanel33;
    private javax.swing.JPanel jPanel34;
    private javax.swing.JPanel jPanel35;
    private javax.swing.JPanel jPanel36;
    private javax.swing.JPanel jPanel37;
    private javax.swing.JPanel jPanel38;
    private javax.swing.JPanel jPanel39;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel40;
    private javax.swing.JPanel jPanel41;
    private javax.swing.JPanel jPanel42;
    private javax.swing.JPanel jPanel43;
    private javax.swing.JPanel jPanel44;
    private javax.swing.JPanel jPanel45;
    private javax.swing.JPanel jPanel47;
    private javax.swing.JPanel jPanel48;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel50;
    private javax.swing.JPanel jPanel51;
    private javax.swing.JPanel jPanel52;
    private javax.swing.JPanel jPanel53;
    private javax.swing.JPanel jPanel54;
    private javax.swing.JPanel jPanel55;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane10;
    private javax.swing.JTabbedPane jTabbedPane11;
    private javax.swing.JTabbedPane jTabbedPane12;
    private javax.swing.JTabbedPane jTabbedPane13;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JTabbedPane jTabbedPane4;
    private javax.swing.JTabbedPane jTabbedPane5;
    private javax.swing.JTabbedPane jTabbedPane6;
    private javax.swing.JTabbedPane jTabbedPane7;
    private javax.swing.JTabbedPane jTabbedPane8;
    private javax.swing.JTabbedPane jTabbedPane9;
    private javax.swing.JLabel lblSPMSPhotograph2;
    private javax.swing.JLabel lbl_TID;
    private javax.swing.JPanel list;
    private javax.swing.JPanel manageOfficialDoc;
    private javax.swing.JButton mngprofile;
    private javax.swing.JButton mngprofile1;
    private javax.swing.JButton mngprofile2;
    private javax.swing.JButton mngprofile3;
    private javax.swing.JPanel panelSPMSCalendar1;
    private javax.swing.JPanel panelSPMSNotices;
    private javax.swing.JTextField quickTID;
    private javax.swing.JTextField selectedActivityStuRegNo;
    private javax.swing.JTextField sg1;
    private javax.swing.JTextField sg2;
    private javax.swing.JTextField sg3;
    private javax.swing.JTextField sg4;
    private javax.swing.JTextField sg5;
    private javax.swing.JTextField sg6;
    private javax.swing.JTextField sg7;
    private javax.swing.JTextField sg8;
    private javax.swing.JTextField sg9;
    private javax.swing.JPanel sidemenu;
    private javax.swing.JTextField sm1;
    private javax.swing.JTextField sm2;
    private javax.swing.JTextField sm3;
    private javax.swing.JTextField sm4;
    private javax.swing.JTextField sm5;
    private javax.swing.JTextField sm6;
    private javax.swing.JTextField sm7;
    private javax.swing.JTextField sm8;
    private javax.swing.JTextField sm9;
    private javax.swing.JTextField ssub1;
    private javax.swing.JTextField ssub2;
    private javax.swing.JTextField ssub3;
    private javax.swing.JTextField ssub4;
    private javax.swing.JTextField ssub5;
    private javax.swing.JTextField ssub6;
    private javax.swing.JTextField ssub7;
    private javax.swing.JTextField ssub8;
    private javax.swing.JTextField ssub9;
    private javax.swing.JTabbedPane stuListTA;
    private javax.swing.JLabel sub1l;
    private javax.swing.JTable tblAcademicData;
    private javax.swing.JTable tblBehaviourInfo;
    private javax.swing.JTable tblBehavioutStuList;
    private javax.swing.JTable tblBehavioutStuListshowAll;
    private javax.swing.JTable tblExtraC;
    private javax.swing.JTable tblStuLIST;
    private javax.swing.JTable tblStudentinfo;
    private javax.swing.JTable tblnotices;
    private javax.swing.JTable tblrequestedDocDetails;
    private javax.swing.JTextField txtBehaviourId;
    private javax.swing.JTextField txtBehaviourType;
    private javax.swing.JTextArea txtBehavoiurNote;
    private javax.swing.JTextField txtECAM;
    private javax.swing.JTextField txtExM;
    private javax.swing.JTextField txtFinalAvg;
    private javax.swing.JTextField txtFinalTotal;
    private javax.swing.JTextField txtNextAction;
    private javax.swing.JTextArea txtOBio;
    private javax.swing.JTextField txtOClass;
    private javax.swing.JTextArea txtOExtra;
    private javax.swing.JTextField txtOFullname;
    private javax.swing.JTextField txtOIndexOL;
    private javax.swing.JTextArea txtOSkills;
    private javax.swing.JTextField txtOStuID;
    private javax.swing.JTextField txtOTeacherFname;
    private javax.swing.JTextField txtOTeacherLname;
    private javax.swing.JTextField txtOg;
    private javax.swing.JTextField txtOverallGrade;
    private javax.swing.JTextField txtOverallGrade1;
    private javax.swing.JTextField txtOyrOL;
    private javax.swing.JTextField txtPrecentageReport;
    private javax.swing.JTextField txtSTID;
    private javax.swing.JTextField txtSearchStudent;
    private javax.swing.JTextField txtStuRegReport1;
    private javax.swing.JTextField txtStuRegReport3;
    private javax.swing.JTextField txtTAMarks1;
    private javax.swing.JTextField txtTAMarks2;
    private javax.swing.JTextField txtTAMarks3;
    private javax.swing.JTextField txtTAMarks4;
    private javax.swing.JTextField txtTAMarks5;
    private javax.swing.JTextField txtTAMarks6;
    private javax.swing.JTextField txtTAMarks7;
    private javax.swing.JTextField txtTAMarks8;
    private javax.swing.JTextField txtTAMarks9;
    private javax.swing.JTextField txtTAScore1;
    private javax.swing.JTextField txtTAScore2;
    private javax.swing.JTextField txtTAScore3;
    private javax.swing.JTextField txtTAScore4;
    private javax.swing.JTextField txtTAScore5;
    private javax.swing.JTextField txtTAScore6;
    private javax.swing.JTextField txtTAScore7;
    private javax.swing.JTextField txtTAScore8;
    private javax.swing.JTextField txtTAScore9;
    private javax.swing.JTextField txtTEmail;
    private javax.swing.JTextField txtTFname;
    private javax.swing.JTextField txtTGender;
    private javax.swing.JTextField txtTGrade1;
    private javax.swing.JTextField txtTGrade2;
    private javax.swing.JTextField txtTGrade3;
    private javax.swing.JTextField txtTGrade4;
    private javax.swing.JTextField txtTGrade5;
    private javax.swing.JTextField txtTGrade6;
    private javax.swing.JTextField txtTGrade7;
    private javax.swing.JTextField txtTGrade8;
    private javax.swing.JTextField txtTGrade9;
    private javax.swing.JTextField txtTLname;
    private javax.swing.JTextField txtTSub1;
    private javax.swing.JTextField txtTSub2;
    private javax.swing.JTextField txtTSub3;
    private javax.swing.JTextField txtTSub4;
    private javax.swing.JTextField txtTSub5;
    private javax.swing.JTextField txtTSub6;
    private javax.swing.JTextField txtTSub7;
    private javax.swing.JTextField txtTSub8;
    private javax.swing.JTextField txtTSub9;
    private javax.swing.JTextField txtTotalMarks1;
    private javax.swing.JTextField txtTotalMarks2;
    private javax.swing.JTextField txtTotalMarks3;
    private javax.swing.JTextField txtTotalMarks4;
    private javax.swing.JTextField txtTotalMarks5;
    private javax.swing.JTextField txtTotalMarks6;
    private javax.swing.JTextField txtTotalMarks7;
    private javax.swing.JTextField txtTotalMarks8;
    private javax.swing.JTextField txtTotalMarks9;
    private javax.swing.JTextField txtTotalSub1;
    private javax.swing.JTextField txtTotalSub2;
    private javax.swing.JTextField txtTotalSub3;
    private javax.swing.JTextField txtTotalSub4;
    private javax.swing.JTextField txtTotalSub5;
    private javax.swing.JTextField txtTotalSub6;
    private javax.swing.JTextField txtTotalSub7;
    private javax.swing.JTextField txtTotalSub8;
    private javax.swing.JTextField txtTotalSub9;
    private javax.swing.JTextField txtavg;
    private javax.swing.JTextField txtavg1;
    private javax.swing.JTextField txtshowClass;
    private javax.swing.JTextField txtshowClass1;
    private javax.swing.JTextField txtshowClass2;
    private javax.swing.JTextField txtshowStuNo;
    private javax.swing.JTextField txtshowStuNo1;
    private javax.swing.JTextField txtshowStuNo2;
    private javax.swing.JTextField txtshowTerm;
    private javax.swing.JTextField txtshowTerm1;
    private javax.swing.JTextField txtshowYear;
    private javax.swing.JTextField txtshowYear1;
    private javax.swing.JTextField txttotalmarks;
    private javax.swing.JTextField txttotalmarks1;
    private javax.swing.JTextField txtyr;
    private javax.swing.JTextField txtyrreport;
    // End of variables declaration//GEN-END:variables

}
