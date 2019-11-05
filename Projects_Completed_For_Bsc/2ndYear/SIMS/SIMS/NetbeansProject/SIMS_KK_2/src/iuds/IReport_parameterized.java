/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuds;

import java.awt.*;
import java.sql.*;
import java.io.*;
import javax.swing.*;
import java.util.*;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.view.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;







/**
 *
 * @author Himashi
 */
public class IReport_parameterized extends JFrame {
    
    
    public  IReport_parameterized(String fp_fileName, HashMap fp_parameter){
        super("Parameterized iReport");
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sims_db_1111","root","");
            
            JasperPrint fp_print = JasperFillManager.fillReport(fp_fileName,fp_parameter,conn);
            
            JRViewer fp_viewer = new JRViewer(fp_print);
            
            Container c=getContentPane();
            c.add(fp_viewer);
            
            
        }
        catch(Exception e){
            
        }
        
        setBounds(10,10,600,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    
    public  IReport_parameterized(){
        
    }
    
    /*
    public static void main(String args[]){
        HashMap fp_p1 = new HashMap();
        fp_p1.put("frm_date","2017-05-01");
        fp_p1.put("to_date","2017-09-31");
        
        IReport_feePayment_parameterized showReport_fp = new IReport_feePayment_parameterized("C:\\xampp\\htdocs\\SIMS\\JavaFiles\\NEW_IUDS_COPY\\Reports\\filterFeePaymentRecords.jasper",fp_p1);
        showReport_fp.setVisible(true);
        
    }
*/
}
