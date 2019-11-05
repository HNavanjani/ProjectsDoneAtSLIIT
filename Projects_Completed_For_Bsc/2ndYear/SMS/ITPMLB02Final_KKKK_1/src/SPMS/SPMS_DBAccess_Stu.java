/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPMS;

import DBConnection.DBConnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Himashi
 */
public class SPMS_DBAccess_Stu extends dbConnection {

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

    public List<String[]> notices = new ArrayList<>();
    
    public String esub1, esub2, esub3, esub4, esub5, esub6, esub7, esub8, esub9 = null;
    public String egrade1, egrade2, egrade3, egrade4, egrade5, egrade6, egrade7, egrade8, egrade9, eograde = null;
    public double emark1, emark2, emark3, emark4, emark5, emark6, emark7, emark8, emark9, etotal, eavg, activityMarks;
    public String requestedDocumentType = null;

    
    public SPMS_DBAccess_Stu(){
    
    
         conn = DBConnect.connect();
    
    }
    
    public ResultSet ViewScheduleInfo() {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT * FROM tms_classwise";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet ViewTeacherInfo() {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT firstName,lastName,gender,email,contact,position FROM ems_employeedetails";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public ResultSet ViewNotices() {
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
        return rs;
    }

    public ResultSet ViewTermlyReport(int pstuRegNo, String pclass, String pyear, String pterm) {
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

    public List<String> getAllSubjects() {
        //conn = dbConnection.connectToDb();
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

    public ResultSet ViewExtraActivityTable(int pstuRegNo) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);
            String sql = "SELECT date AS Date, activityName AS Activity, activityDescription AS Description, activityMarks AS Marks FROM spms_extracurricular WHERE stuRegNo='" + pstuRegNo + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (rs);
    }

    public boolean GenerateOfficialDocuments(String pdocumentType, String pdate, int pstuRegNo, String pStudentFullName, byte[] pphotograph, String pskillsAndInterests, String pbio, String pExtraActivities, String pclass, String pteacherFirstName, String pteacherLastName, int pOLIndex, String pOLYear, String pOLSubject1, String pOLGrade1, String pOLSubject2, String pOLGrade2, String pOLSubject3, String pOLGrade3, String pOLSubject4, String pOLGrade4, String pOLSubject5, String pOLGrade5, String pOLSubject6, String pOLGrade6, String pOLSubject7, String pOLGrade7, String pOLSubject8, String pOLGrade8, String pOLSubject9, String pOLGrade9) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_officialdocs"
                    + "(documentType,date,stuRegNo,StudentFullName,photograph,skillsAndInterests,bio"
                    + ",ExtraActivities,class,teacherFirstName,teacherLastName,OLIndex,OLYear"
                    + ",OLSubject1,OLGrade1,OLSubject2,OLGrade2,OLSubject3,OLGrade3,OLSubject4"
                    + ",OLGrade4,OLSubject5,OLGrade5,OLSubject6,OLGrade6,OLSubject7,OLGrade7"
                    + ",OLSubject8,OLGrade8,OLSubject9,OLGrade9)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            pst = conn.prepareStatement(sql);
            pst.setString(1, pdocumentType);
            pst.setString(2, pdate);
            pst.setString(3, String.valueOf(pstuRegNo));
            pst.setString(4, pStudentFullName);
            pst.setBytes(5, pphotograph);
            pst.setString(6, pskillsAndInterests);
            pst.setString(7, pbio);
            pst.setString(8, pExtraActivities);
            pst.setString(9, pclass);
            pst.setString(10, pteacherFirstName);
            pst.setString(11, pteacherLastName);
            pst.setString(12, String.valueOf(pOLIndex));
            pst.setString(13, pOLYear);
            pst.setString(14, pOLSubject1);
            pst.setString(15, pOLGrade1);
            pst.setString(16, pOLSubject2);
            pst.setString(17, pOLGrade2);
            pst.setString(18, pOLSubject3);
            pst.setString(19, pOLGrade3);
            pst.setString(20, pOLSubject4);
            pst.setString(21, pOLGrade4);
            pst.setString(22, pOLSubject5);
            pst.setString(23, pOLGrade5);
            pst.setString(24, pOLSubject6);
            pst.setString(25, pOLGrade6);
            pst.setString(26, pOLSubject7);
            pst.setString(27, pOLGrade7);
            pst.setString(28, pOLSubject8);
            pst.setString(29, pOLGrade8);
            pst.setString(30, pOLSubject9);
            pst.setString(31, pOLGrade9);

            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public ResultSet CheckDocumentAvailability(int pstuRegNo, String pdocumentType, String pdocStatus) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM spms_officialdocs WHERE stuRegNo='" + pstuRegNo + "' AND documentType='" + pdocumentType + "' AND docStatus='" + pdocStatus + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                requestedDocumentType = rs.getString("documentType");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return rs;
    }

    public ResultSet getTeacherInfo(String pfirstName) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM ems_employeedetails WHERE firstName='" + pfirstName + "' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return rs;
    }

    public ResultSet getScheduleInfo(String pclassName) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "SELECT * FROM tms_classwise WHERE className='" + pclassName + "' ";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return rs;
    }

    public ResultSet getExamResults(int pstuRegNo, String pclass, String pyear, String pterm) {
        //conn = dbConnection.connectToDb();
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

    public boolean addFeedback(String pfeedback, String pdate, String pteacherFname, String pteacherLname, String pdescription) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_feedback"
                    + "(feedback,date,teacherFname,teacherLname,description)"
                    + "VALUES ('" + pfeedback + "','" + pdate + "','" + pteacherFname + "','" + pteacherLname + "','" + pdescription + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean addInquiry(int pstuRegNo, String pclass, String pdate, String pemail, int pphoneNo, String pinquiry) {
        //conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "INSERT INTO spms_inquiry"
                    + "(stuRegNo,class,date,email,phoneNo,inquiry)"
                    + "VALUES ('" + pstuRegNo + "','" + pclass + "','" + pdate + "','" + pemail + "','" + pphoneNo + "','" + pinquiry + "')";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean changePassword(int pRegNo, String ppassword) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_studentinfo SET password= '" + ppassword + "' where RegNo='" + pRegNo + "' ";
            pst = conn.prepareStatement(sql);
            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

    public boolean updateProfileInfo(String pcurrentClass, String pfirstName, String pmiddleName, String plastName, String pdateOfBirth, String pgender, String preligion, String pnationality, String pemail, int pphoneNo, String pstreetNo, String pstreet, String pcity, String pcountry, String pbio, byte[] pprofilePic, String ppassword, String pphysicianName, int pphysicianPhoneNo, String pbloodGroup, String pphysicalRestrictions, String pmediAlert, String potherConditions, String pparentNIC, String pparentFName, String pparentLName, int pparentPhoneNo, String pparentEmail, String poccupation, int pRegNo) {
       // conn = dbConnection.connectToDb();
        try {
//            Class.forName(driver);
//            conn=DriverManager.getConnection(url, user, pw);

            String sql = "UPDATE spms_studentinfo SET currentClass =?,firstName=?, middleName=?, lastName=?, dateOfBirth=?, gender=?, religion=?, nationality=?, email=?, phoneNo=?, streetNo=?, street=?, city=?, country=?, bio=?,  profilePic=?, password=?, physicianName=?, physicianPhoneNo=?, bloodGroup=?, physicalRestrictions=?, mediAlert=?, otherConditions=?, parentNIC=?, parentFName=?, parentLName=?, parentPhoneNo=?, parentEmail=?, occupation=? where RegNo=?";
            pst = conn.prepareStatement(sql);

            pst.setString(30, String.valueOf(pRegNo));
            pst.setString(1, pcurrentClass);
            pst.setString(2, pfirstName);
            pst.setString(3, pmiddleName);
            pst.setString(4, plastName);
            pst.setString(5, pdateOfBirth);
            pst.setString(6, pgender);
            pst.setString(7, preligion);
            pst.setString(8, pnationality);
            pst.setString(9, pemail);
            pst.setString(10, String.valueOf(pphoneNo));
            pst.setString(11, pstreetNo);
            pst.setString(12, pstreet);
            pst.setString(13, pcity);
            pst.setString(14, pcountry);
            pst.setString(15, pbio);

            pst.setBytes(16, pprofilePic);

            pst.setString(17, ppassword);

            pst.setString(18, pphysicianName);
            pst.setString(19, String.valueOf(pphysicianPhoneNo));
            pst.setString(20, pbloodGroup);
            pst.setString(21, pphysicalRestrictions);
            pst.setString(22, pmediAlert);
            pst.setString(23, potherConditions);
            pst.setString(24, pparentNIC);
            pst.setString(25, pparentFName);
            pst.setString(26, pparentLName);
            pst.setString(27, String.valueOf(pparentPhoneNo));
            pst.setString(28, pparentEmail);
            pst.setString(29, poccupation);

            pst.executeUpdate();

            status = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            status = false;
        }
        return status;
    }

}
