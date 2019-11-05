/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPMS;

import DBConnection.DBConnect;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Himashi
 */
public class SPMS_DBAccess extends dbConnection {

    public Connection conn = null;
    public ResultSet rs = null;
    public PreparedStatement pst = null;
    
//    public String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
//    public String url="jdbc:sqlserver://localhost:24809;databaseName=sms_";
//    public String user="adminK";
//    public String pw="admink";
    

    public boolean status;

    public List<String> AllSubjects = new ArrayList<String>();
    public List<String> AllActivities = new ArrayList<String>();
    public List<String> AllClasses = new ArrayList<String>();
    public List<String> AllBehaviours = new ArrayList<String>();
    public List<String> AllActivitiesStuMarks = new ArrayList<String>();
    public List<String> AllActivitiesStuATypes = new ArrayList<String>();

    public String pselectedStudentRegNo = null;
    public String pselectedCurrentClass = null;
    public String pselectedbehaviourID = null;
    public String pselectedbehavoiurType = null;

    public String pselectedbehaviourRecordID, pselectedStudentRegNo3, pselectedCurrentClass3, pincidentDate, pbehaviourType, pbehaviourNote, pnextAction, pactionDate = null;
    public String pselectedStudentRegNoAc, pselectedCurrentClassAc, pactivities, pactivitymarks = null;
    public String pdocID, padd1, padd2, padd3, padd4, padd5, padd6, padd7, padd8, padd9, padd10, padd11, padd12, padd13, padd14, padd15, padd16, padd17, padd18, padd19, padd20, padd21, padd22, padd23, padd24, padd25, padd26, padd27, padd28 = null;
    public byte[] pphotoTB;

    public String ttsub1, ttsub2, ttsub3, ttsub4, ttsub5, ttsub6, ttsub7, ttsub8, ttsub9 = null;
    public double ttmark1, ttmark2, ttmark3, ttmark4, ttmark5, ttmark6, ttmark7, ttmark8, ttmark9;
    public String selectedAStu, selectedAClass, selectedAStuA, selectedAClassA, selectedATerm, selectedAYear, asub1, asub2, asub3, asub4, asub5, asub6, asub7, asub8, asub9 = null;
    public double ascore1, ascore2, ascore3, ascore4, ascore5, ascore6, ascore7, ascore8, ascore9;
    public String esub1, esub2, esub3, esub4, esub5, esub6, esub7, esub8, esub9 = null;
    public String egrade1, egrade2, egrade3, egrade4, egrade5, egrade6, egrade7, egrade8, egrade9, eograde = null;
    public double emark1, emark2, emark3, emark4, emark5, emark6, emark7, emark8, emark9, etotal, eavg, activityMarks;
    public int pExtracurricularStuCount, specificStudentCount, allStudentCount,allTeachersCount,allStaffCount;

    
    public SPMS_DBAccess(){
    
     conn = DBConnect.connect();
    
    
    }
    
    public ResultSet getAllStudents() {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT RegNo,firstName,middleName,lastName,dateOfBirth,gender,email FROM spms_studentinfo";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet viewNotices() {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT top 7 notice FROM spms_notices ORDER BY noticeID DESC";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet viewStudentBehaviourRecords() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT RegNo,firstName,middleName,lastName FROM spms_studentinfo";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet viewBehaviourShowAllStudents() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT behaviourRecordID,stuRegNo,incidentDate,behaviourType FROM spms_stu_behaviourinfo";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet viewBehaviourInfo() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * FROM spms_behavoiurinfo ORDER BY behaviourID";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet viewRequestedDocInfo() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT documentID,documentType,date,stuRegNo FROM spms_officialdocs WHERE docStatus=?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "Is Not Ready");
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet showStudentInfo() {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT RegNo,currentClass,firstName,middleName,lastName FROM spms_studentinfo";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet showAcademicInfo() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT StudentRegNo,class,year,term FROM spms_exam_results";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet showExtraCurricularInfo() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT StuRegNo,class FROM spms_extracurricular";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public List<String> getAllSubjects() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * from tms_subject";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

            while (rs.next()) {
                AllSubjects.add(rs.getString("subject"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return AllSubjects;
    }

    public List<String> getAllActivities() {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * from spms_extra_activities";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                AllActivities.add(rs.getString("activityName"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (AllActivities);
    }

    public List<String> getAllClasses() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * from tms_class";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                AllClasses.add(rs.getString("class"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (AllClasses);
    }

    public List<String> getAllBehaviourTypes() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * from spms_behavoiurInfo";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                AllBehaviours.add(rs.getString("behavoiurType"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (AllBehaviours);
    }

    public ResultSet getTermTestMarks(int pstuRegNo, String pclass, String pyear, String pterm) {
      //  conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sqlTermTestMarks = "SELECT * FROM spms_termtestmarks WHERE stuRegNo='" + pstuRegNo + "' and class='" + pclass + "' and year='" + pyear + "' and term='" + pterm + "'";
            pst = conn.prepareStatement(sqlTermTestMarks);
            rs = pst.executeQuery();
            while (rs.next()) {
                selectedAStu = rs.getString("stuRegNo");
                selectedAClass = rs.getString("class");
                selectedAYear = rs.getString("year");
                selectedATerm = rs.getString("term");

                ttsub1 = rs.getString("subject1");
                ttsub2 = rs.getString("subject2");
                ttsub3 = rs.getString("subject3");
                ttsub4 = rs.getString("subject4");
                ttsub5 = rs.getString("subject5");
                ttsub6 = rs.getString("subject6");
                ttsub7 = rs.getString("subject7");
                ttsub8 = rs.getString("subject8");
                ttsub9 = rs.getString("subject9");

                ttmark1 = rs.getDouble("marks1");
                ttmark2 = rs.getDouble("marks2");
                ttmark3 = rs.getDouble("marks3");
                ttmark4 = rs.getDouble("marks4");
                ttmark5 = rs.getDouble("marks5");
                ttmark6 = rs.getDouble("marks6");
                ttmark7 = rs.getDouble("marks7");
                ttmark8 = rs.getDouble("marks8");
                ttmark9 = rs.getDouble("marks9");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet getAssignmentScores(int pstuRegNo, String pclass) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sqlAssignmentScores = "SELECT * FROM spms_assignmentscore WHERE stuRegNo='" + pstuRegNo + "' and class='" + pclass + "'";
            pst = conn.prepareStatement(sqlAssignmentScores);
            rs = pst.executeQuery();
            while (rs.next()) {
                selectedAStuA = rs.getString("stuRegNo");
                selectedAClassA = rs.getString("class");

                asub1 = rs.getString("subject1");
                asub2 = rs.getString("subject2");
                asub3 = rs.getString("subject3");
                asub4 = rs.getString("subject4");
                asub5 = rs.getString("subject5");
                asub6 = rs.getString("subject6");
                asub7 = rs.getString("subject7");
                asub8 = rs.getString("subject8");
                asub9 = rs.getString("subject9");

                ascore1 = rs.getDouble("score1");
                ascore2 = rs.getDouble("score2");
                ascore3 = rs.getDouble("score3");
                ascore4 = rs.getDouble("score4");
                ascore5 = rs.getDouble("score5");
                ascore6 = rs.getDouble("score6");
                ascore7 = rs.getDouble("score7");
                ascore8 = rs.getDouble("score8");
                ascore9 = rs.getDouble("score9");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public List<String> getExtracurricularStuATypes(int pstuRegNo, String pclass) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * FROM  spms_extracurricular WHERE stuRegNo ='" + pstuRegNo + "' and class='" + pclass + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {

                AllActivitiesStuATypes.add(rs.getString("activityName"));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return (AllActivitiesStuATypes);
    }

    public List<String> getExtracurricularStuMarks(int pstuRegNo, String pclass) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * FROM  spms_extracurricular WHERE stuRegNo ='" + pstuRegNo + "' and class='" + pclass + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                AllActivitiesStuMarks.add(String.valueOf(rs.getDouble("activityMarks")));

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (AllActivitiesStuMarks);

    }

    public boolean addTermTestMarks(int pstuRegNo, String pclass, String pyear, String pterm, String psubject1, double pmarks1, String psubject2, double pmarks2, String psubject3, double pmarks3, String psubject4, double pmarks4, String psubject5, double pmarks5, String psubject6, double pmarks6, String psubject7, double pmarks7, String psubject8, double pmarks8, String psubject9, double pmarks9) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_termtestmarks"
                    + "(stuRegNo,class,year,term,subject1,marks1,subject2,marks2,subject3,marks3"
                    + ",subject4,marks4,subject5,marks5,subject6,marks6,subject7,marks7"
                    + ",subject8,marks8,subject9,marks9)"
                    + "VALUES ('" + pstuRegNo + "','" + pclass + "','" + pyear + "','" + pterm + "','" + psubject1 + "','" + pmarks1 + "','" + psubject2 + "','" + pmarks2 + "','" + psubject3 + "','" + pmarks3 + "','" + psubject4 + "','" + pmarks4 + "','" + psubject5 + "','" + pmarks5 + "','" + psubject6 + "','" + pmarks6 + "','" + psubject7 + "','" + pmarks7 + "','" + psubject8 + "','" + pmarks8 + "','" + psubject9 + "','" + pmarks9 + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean updateTermTestMarks(int pstuRegNo, String pclass, String pyear, String pterm, String psubject1, double pmarks1, String psubject2, double pmarks2, String psubject3, double pmarks3, String psubject4, double pmarks4, String psubject5, double pmarks5, String psubject6, double pmarks6, String psubject7, double pmarks7, String psubject8, double pmarks8, String psubject9, double pmarks9) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_termtestmarks SET class='" + pclass + "',year='" + pyear + "',term='" + pterm + "',subject1='" + psubject1 + "',marks1='" + pmarks1 + "',subject2='" + psubject2 + "',marks2='" + pmarks2 + "',subject3='" + psubject3 + "',marks3='" + pmarks3 + "',subject4='" + psubject4 + "',marks4='" + pmarks4 + "',subject5='" + psubject5 + "',marks5='" + pmarks5 + "',subject6='" + psubject6 + "',marks6='" + pmarks6 + "',subject7='" + psubject7 + "',marks7='" + pmarks7 + "',subject8='" + psubject8 + "',marks8='" + pmarks8 + "',subject9='" + psubject9 + "',marks9='" + pmarks9 + "' WHERE stuRegNo='" + pstuRegNo + "' ";

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean deleteTermTestMarks(int pstuRegNo, String pclass, String pyear, String pterm) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "DELETE FROM spms_termtestmarks WHERE stuRegNo='" + pstuRegNo + "' and class='" + pclass + "' and year='" + pyear + "' and term='" + pterm + "'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean addAssignmentScores(int pstuRegNo, String pclass, String psubject1, double pscore1, String psubject2, double pscore2, String psubject3, double pscore3, String psubject4, double pscore4, String psubject5, double pscore5, String psubject6, double pscore6, String psubject7, double pscore7, String psubject8, double pscore8, String psubject9, double pscore9) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_assignmentscore"
                    + "(stuRegNo,class,subject1,score1,subject2,score2,subject3,score3"
                    + ",subject4,score4,subject5,score5,subject6,score6,subject7,score7"
                    + ",subject8,score8,subject9,score9)"
                    + "VALUES ('" + pstuRegNo + "','" + pclass + "','" + psubject1 + "','" + pscore1 + "','" + psubject2 + "','" + pscore2 + "','" + psubject3 + "','" + pscore3 + "','" + psubject4 + "','" + pscore4 + "','" + psubject5 + "','" + pscore5 + "','" + psubject6 + "','" + pscore6 + "','" + psubject7 + "','" + pscore7 + "','" + psubject8 + "','" + pscore8 + "','" + psubject9 + "','" + pscore9 + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean updateAssignmentScores(int pstuRegNo, String pclass, String psubject1, double pscore1, String psubject2, double pscore2, String psubject3, double pscore3, String psubject4, double pscore4, String psubject5, double pscore5, String psubject6, double pscore6, String psubject7, double pscore7, String psubject8, double pscore8, String psubject9, double pscore9) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_assignmentscore SET class='" + pclass + "',subject1='" + psubject1 + "',score1='" + pscore1 + "',subject2='" + psubject2 + "',score2='" + pscore2 + "',subject3='" + psubject3 + "',score3='" + pscore3 + "',subject4='" + psubject4 + "',score4='" + pscore4 + "',subject5='" + psubject5 + "',score5='" + pscore5 + "',subject6='" + psubject6 + "',score6='" + pscore6 + "',subject7='" + psubject7 + "',score7='" + pscore7 + "',subject8='" + psubject8 + "',score8='" + pscore8 + "',subject9='" + psubject9 + "',score9='" + pscore9 + "' WHERE stuRegNo='" + pstuRegNo + "' ";

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean deleteAssignmentScores(int pstuRegNo, String pclass) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "DELETE FROM spms_assignmentscore WHERE stuRegNo='" + pstuRegNo + "' and class='" + pclass + "'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean addTermlyReport(int pstuRegNo, String pclass, String pyear, String pterm, String psubject1, double pmarks1, String pgrade1, String psubject2, double pmarks2, String pgrade2, String psubject3, double pmarks3, String pgrade3, String psubject4, double pmarks4, String pgrade4, String psubject5, double pmarks5, String pgrade5, String psubject6, double pmarks6, String pgrade6, String psubject7, double pmarks7, String pgrade7, String psubject8, double pmarks8, String pgrade8, String psubject9, double pmarks9, String pgrade9, double ptotalMarks, double paverageMarks, String poverallGrade) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_exam_results"
                    + "(StudentRegNo,class,year,term"
                    + ",subject1,mark1,grade1"
                    + ",subject2,mark2,grade2,subject3,mark3,grade3,subject4,mark4,grade4,subject5,mark5,grade5"
                    + ",subject6,mark6,grade6,subject7,mark7,grade7,subject8,mark8,grade8,subject9,mark9,grade9"
                    + ",totalMarks,averageMarks,overallGrade)"
                    + "VALUES ('" + pstuRegNo + "','" + pclass + "','" + pyear + "','" + pterm + "','" + psubject1 + "','" + pmarks1 + "','" + pgrade1 + "','" + psubject2 + "','" + pmarks2 + "','" + pgrade2 + "','" + psubject3 + "','" + pmarks3 + "','" + pgrade3 + "','" + psubject4 + "','" + pmarks4 + "','" + pgrade4 + "','" + psubject5 + "','" + pmarks5 + "','" + pgrade5 + "','" + psubject6 + "','" + pmarks6 + "','" + pgrade6 + "','" + psubject7 + "','" + pmarks7 + "','" + pgrade7 + "','" + psubject8 + "','" + pmarks8 + "','" + pgrade8 + "','" + psubject9 + "','" + pmarks9 + "','" + pgrade9 + "','" + ptotalMarks + "','" + paverageMarks + "','" + poverallGrade + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public ResultSet getExamResults(int pstuRegNo, String pclass, String pyear, String pterm) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * FROM spms_exam_results WHERE StudentRegNo='" + pstuRegNo + "' and class='" + pclass + "' and year='" + pyear + "' and term='" + pterm + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                esub1 = rs.getString("subject1");
                emark1 = rs.getDouble("mark1");
                egrade1 = rs.getString("grade1");

                esub2 = rs.getString("subject2");
                emark2 = rs.getDouble("mark2");
                egrade2 = rs.getString("grade2");

                esub3 = rs.getString("subject3");
                emark3 = rs.getDouble("mark3");
                egrade3 = rs.getString("grade3");

                esub4 = rs.getString("subject4");
                emark4 = rs.getDouble("mark4");
                egrade4 = rs.getString("grade4");

                esub5 = rs.getString("subject5");
                emark5 = rs.getDouble("mark5");
                egrade5 = rs.getString("grade5");

                esub6 = rs.getString("subject6");
                emark6 = rs.getDouble("mark6");
                egrade6 = rs.getString("grade6");

                esub7 = rs.getString("subject7");
                emark7 = rs.getDouble("mark7");
                egrade7 = rs.getString("grade7");

                esub8 = rs.getString("subject8");
                emark8 = rs.getDouble("mark8");
                egrade8 = rs.getString("grade8");

                esub9 = rs.getString("subject9");
                emark9 = rs.getDouble("mark9");
                egrade9 = rs.getString("grade9");

                etotal = rs.getDouble("totalMarks");
                eavg = rs.getDouble("averageMarks");
                eograde = rs.getString("overallGrade");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public boolean updateExamResults(int pStudentRegNo, String pclass, String pyear, String pterm, double pextracurricularActivitiesMarks, double ptotalMarks, double paverageMarks, String poverallGrade) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_exam_results SET extracurricularActivitiesMarks='" + pextracurricularActivitiesMarks + "' "
                    + " ,totalMarks ='" + ptotalMarks + "' , averageMarks='" + paverageMarks + "' , overallGrade='" + poverallGrade + "'"
                    + "WHERE StudentRegNo='" + pStudentRegNo + "' AND class='" + pclass + "' AND year='" + pyear + "' AND term='" + pterm + "'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean addActivityRecord(int pstuRegNo, String pclass, String pdate, String pactivityName, String pactivityDescription, double pactivityMarks) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO  spms_extracurricular(stuRegNo,class,date,activityName,activityDescription,activityMarks)"
                    + "VALUES('" + pstuRegNo + "','" + pclass + "','" + pdate + "','" + pactivityName + "','" + pactivityDescription + "','" + pactivityMarks + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean addBehaviourStuRecord(int pstuRegNo, String pclass, String pincidentDate, String pbehaviourType, String pbehaviourNote, String pnextAction, String pactionDate) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_stu_behaviourinfo "
                    + "(stuRegNo,class,incidentDate,behaviourType,behaviourNote,nextAction,actionDate)"
                    + "VALUES('" + pstuRegNo + "','" + pclass + "','" + pincidentDate + "','" + pbehaviourType + "','" + pbehaviourNote + "','" + pnextAction + "','" + pactionDate + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean updateBehaviourStuRecord(int pstuRegNo, String pclass, String pincidentDate, String pbehaviourType, String pbehaviourNote, String pnextAction, String pactionDate, int pbehaviourRecordID) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_stu_behaviourinfo SET stuRegNo= '" + pstuRegNo + "',class='" + pclass + "',incidentDate='" + pincidentDate + "',behaviourType='" + pbehaviourType + "',behaviourNote='" + pbehaviourNote + "',nextAction='" + pnextAction + "',actionDate='" + pactionDate + "' WHERE behaviourRecordID ='" + pbehaviourRecordID + "'";

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean deleteBehaviourStuRecord(int pstuRegNo, String pclass, String pincidentDate, String pbehaviourType, String pbehaviourNote, String pnextAction, String pactionDate) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "DELETE FROM spms_stu_behaviourinfo WHERE  stuRegNo= '" + pstuRegNo + "' and class='" + pclass + "' and incidentDate='" + pincidentDate + "' and behaviourType='" + pbehaviourType + "' and behaviourNote='" + pbehaviourNote + "' and nextAction='" + pnextAction + "' and actionDate='" + pactionDate + "'";

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean addBehaviourTypeRecord(int pbehaviourID, String pbehavoiurType, String ppositiveOrNegative) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_behavoiurinfo "
                    + "(behaviourID,behavoiurType,positiveOrNegative)"
                    + "VALUES('" + pbehaviourID + "','" + pbehavoiurType + "','" + ppositiveOrNegative + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean updateBehaviourTypeRecord(int pbehaviourID, String pbehavoiurType, String ppositiveOrNegative) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_behavoiurinfo SET behavoiurType='" + pbehavoiurType + "',positiveOrNegative='" + ppositiveOrNegative + "' WHERE behaviourID='" + pbehaviourID + "'";

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean deleteBehaviourTypeRecord(int pbehaviourID) {
      //  conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "DELETE FROM spms_behavoiurinfo WHERE behaviourID='" + pbehaviourID + "'";

            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean verifyDocDetails(int pdocumentID, String pdocStatus) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_officialdocs SET docStatus ='" + pdocStatus + "' WHERE documentID='" + pdocumentID + "'";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public ResultSet showRequestedDetails(int pdocumentID) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM spms_officialdocs WHERE documentID = '" + pdocumentID + "' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                pdocID = rs.getString("documentID");
                padd1 = rs.getString("stuRegNo");
                padd2 = rs.getString("class");
                padd3 = rs.getString("teacherFirstName");
                padd4 = rs.getString("teacherLastName");
                padd5 = rs.getString("StudentFullName");
                padd6 = rs.getString("bio");
                padd7 = rs.getString("skillsAndInterests");
                padd8 = rs.getString("OLIndex");
                padd9 = rs.getString("OLYear");
                padd10 = rs.getString("ExtraActivities");
                padd11 = rs.getString("OLSubject1");
                padd12 = rs.getString("OLSubject2");
                padd13 = rs.getString("OLSubject3");
                padd14 = rs.getString("OLSubject4");
                padd15 = rs.getString("OLSubject5");
                padd16 = rs.getString("OLSubject6");
                padd17 = rs.getString("OLSubject7");
                padd18 = rs.getString("OLSubject8");
                padd19 = rs.getString("OLSubject9");
                padd20 = rs.getString("OLGrade1");
                padd21 = rs.getString("OLGrade2");
                padd22 = rs.getString("OLGrade3");
                padd23 = rs.getString("OLGrade4");
                padd24 = rs.getString("OLGrade5");
                padd25 = rs.getString("OLGrade6");
                padd26 = rs.getString("OLGrade7");
                padd27 = rs.getString("OLGrade8");
                padd28 = rs.getString("OLGrade9");
                pphotoTB = rs.getBytes("photograph");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet getSelectedStuInfo(int pstuRegNo) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM spms_studentinfo WHERE RegNo='" + pstuRegNo + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                pselectedStudentRegNo = rs.getString("RegNo");
                pselectedCurrentClass = rs.getString("currentClass");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet getSelectedBehaviourInfo(int pbehaviourID) {
      //  conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM spms_behavoiurinfo WHERE behaviourID='" + pbehaviourID + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                pselectedbehaviourID = rs.getString("behaviourID");
                pselectedbehavoiurType = rs.getString("behavoiurType");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet getStuBehaviourInfo(int pbehaviourRecordID) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM spms_stu_behaviourinfo WHERE behaviourRecordID='" + pbehaviourRecordID + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                pselectedbehaviourRecordID = rs.getString("behaviourRecordID");
                pselectedStudentRegNo3 = rs.getString("stuRegNo");
                pselectedCurrentClass3 = rs.getString("class");
                pincidentDate = rs.getString("incidentDate");
                pbehaviourType = rs.getString("behaviourType");
                pbehaviourNote = rs.getString("behaviourNote");
                pnextAction = rs.getString("nextAction");
                pactionDate = rs.getString("actionDate");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet getExtracurricularStu(String pclass) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT count(*) FROM spms_extracurricular WHERE class='" + pclass + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                pExtracurricularStuCount = rs.getInt(1);
                
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;
    }

    public ResultSet getExtracurricularStuRecords(String pStuRegNo) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM spms_extracurricular WHERE StuRegNo='" + pStuRegNo + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                pselectedStudentRegNoAc = rs.getString("StuRegNo");
                pselectedCurrentClassAc = rs.getString("class");

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet countSpecificStu(String psubject1, String psubject2, String psubject3, String psubject4, String psubject5, String psubject6, String psubject7, String psubject8, String psubject9) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT count(*) FROM spms_exam_results WHERE subject1 ='" + psubject1 + "' OR subject2 ='" + psubject2 + "' OR subject3 ='" + psubject3 + "' OR subject4 ='" + psubject4 + "' OR subject5 ='" + psubject5 + "' OR subject6 ='" + psubject6 + "' OR subject7 ='" + psubject7 + "' OR subject8='" + psubject8 + "' OR subject9='" + psubject9 + "' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                specificStudentCount = rs.getInt(1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }

    public ResultSet countAllStu() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT count(*) FROM spms_studentinfo";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                allStudentCount = rs.getInt(1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }
    
    
    public ResultSet countAllTeachers() {
      //  conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT count(*) FROM ems_employeedetails";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                allTeachersCount = rs.getInt(1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }
    
    public ResultSet countAllStaff() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT count(*) FROM [user]";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                allStaffCount = rs.getInt(1);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

        return rs;
    }
    
    
    
    
    

}
