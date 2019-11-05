/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SPMS;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Himashi
 */
public class dbConnection {
    //Connection conn = null;
    public static Connection GetConnection() throws ClassNotFoundException{
        Connection conn=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //String url="jdbc:sqlserver::/localhost:24809;databaseName=smsDB;username=adminK,password=admink";
        String url="jdbc:sqlserver://localhost:24809;databaseName=sms_;username=adminK,password=admink";

        try{
            conn=DriverManager.getConnection(url);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        return conn;
    }
//    public static Connection connectToDb(){
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/itp_mlb_02_db","root","");
//
//            //JOptionPane.showMessageDialog(null, "Connction Established...");
//            
//            return conn;
//            
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null, e);
//            System.exit(0);
//            return null;
//            
//        }
//    }
    
}


















