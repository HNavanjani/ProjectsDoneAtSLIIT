///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package SchoolInformationManagementSystem;
//
///**
// *
// * @author Admin
// */
//public class CMS_irepot {
//    
//import java.awt.Container;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.HashMap;
//import javax.swing.JFrame;
//import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.view.JRViewer;
//
///**
// *
// * @author Hashini
// */
//public class ireporthms extends JFrame{
//     public  ireporthms(String fp_fileName, HashMap fp_parameter){
//    super("Parameterized iReport");
//        try{
//            Class.forName("com.mysql.jdbc.Driver").newInstance();
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/itp_mlb_02_db","root","");
//            
//            JasperPrint fp_print = JasperFillManager.fillReport(fp_fileName,fp_parameter,conn);
//            
//            JRViewer fp_viewer = new JRViewer(fp_print);
//            
//            Container c=getContentPane();
//            c.add(fp_viewer);
//            
//            
//        }
//        catch(Exception e){
//            
//        }
//        
//        setBounds(10,10,1350,720);
//        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//    
//}
//}
//    
//}
