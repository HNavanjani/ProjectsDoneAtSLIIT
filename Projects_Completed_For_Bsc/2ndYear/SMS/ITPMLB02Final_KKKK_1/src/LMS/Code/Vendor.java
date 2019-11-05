/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LMS.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author sanjalee
 */
public class Vendor {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public Vendor(){
    
         conn = DBConnection.DBConnect.connect();
       
    }
    
    public void addVendor(String name, String address, String email, String contact) throws SQLException{
        
        
        //JOptionPane.showMessageDialog(null,"'"+name+"','"+address+"','"+email+"','"+contact+"'");
    
       String sql_addVendor = "INSERT INTO lms_vendor(name, address, email, contact) values('"+ name +"','"+ address +"','"+ email +"','"+ contact +"')"; 
       pst = conn.prepareStatement(sql_addVendor);
       pst.execute();
       
       
       JOptionPane.showMessageDialog(null,"Successfully Entered!!");
       
      
    
    }
    
    public String[] get() throws SQLException{
    
        String[] vendors = new String[50];
        int count = 0;
        
        String sql_getVendors = "SELECT * FROM lms_category";
        pst = conn.prepareStatement(sql_getVendors);
        rs = pst.executeQuery();
        
        
        while(rs.next()){
        
            vendors[count] = rs.getString("name");
            count++;
        
        }
        //JOptionPane.showMessageDialog(null,authors);
        return vendors;
    
    
    }
}
