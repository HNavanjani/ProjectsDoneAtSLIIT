/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iuds;

import java.sql.*;
import javax.swing.*;


/**
 *
 * @author Himashi
 */
public class dbConnect {
    
    Connection conn = null;
    public static Connection connectToDb(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sims_db","root","");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sims_db_1111","root","");

            JOptionPane.showMessageDialog(null, "Connction Established...");
            
            return conn;
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
    
}
