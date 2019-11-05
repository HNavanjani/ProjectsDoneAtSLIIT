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
public class LendBook {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public LendBook(){
    
         conn = DBConnection.DBConnect.connect();
        
    }
    
    public void borrowBook(String isbn,int mem_id) throws SQLException{
    
        int count = 0;
        int book = 0;
        int bkStock = 0;
        int borrowedBK = 0;
        
        String sql_chkStock = "SELECT stock FROM lms_book WHERE ISBN = '"+ isbn +"'";
        pst = conn.prepareStatement(sql_chkStock);
        rs = pst.executeQuery();
        
         while(rs.next()){
        
            bkStock = rs.getInt(1);
             
        }
         
        String sql_chkBorrowedBK = "SELECT count(ISBN) FROM lms_transaction WHERE ISBN = '"+ isbn +"' and returnDate is NULL and status like 'borrowed'";
        pst = conn.prepareStatement(sql_chkBorrowedBK);
        rs = pst.executeQuery();
        
         while(rs.next()){
        
            borrowedBK = rs.getInt(1);
             
        }
        
        if(bkStock == borrowedBK){
            
            JOptionPane.showMessageDialog(null,"This Book is not available!!");
            
        } 
        else {
            String sql_bkCount = "SELECT count(mem_id)  FROM lms_transaction where mem_id = '"+ mem_id +"' and returnDate is NULL";
            pst = conn.prepareStatement(sql_bkCount);
            rs = pst.executeQuery();
       
            while(rs.next()){
        
                count = rs.getInt(1);
             
            }
            String sql_settings = "SELECT noOfBooks FROM lms_settings";
            pst = conn.prepareStatement(sql_settings);
            rs = pst.executeQuery();
       
            while(rs.next()){
        
                book = rs.getInt(1);
             
            }
       
            count = count + 1;
            if(count > book){
            
                JOptionPane.showMessageDialog(null,"Can't borrow more than "+ book +" books.");
            }
            else{
           
                String sql_insertLB ="INSERT INTO lms_transaction(mem_id,ISBN) values('"+ mem_id +"','"+ isbn +"') ";
                pst = conn.prepareStatement(sql_insertLB);
                pst.execute(); 
           
                String sql_updateLB ="UPDATE lms_transaction SET status = 'borrowed' WHERE mem_id ='"+ mem_id +"' and ISBN = '"+ isbn +"'";
                pst = conn.prepareStatement(sql_updateLB);
                pst.execute(); 
                
                JOptionPane.showMessageDialog(null,"Entered Successfully!!");
            }
        }
    
    }
    
    
    
    
    public void returnBook(String isbn,int mem_id) throws SQLException{
    
        int diff = 0;
        int time =0;
        int fine =0;
        
        String sql_datediff = "SELECT DATEDIFF(NOW(),borrowedDate) FROM lms_transaction";
        pst = conn.prepareStatement(sql_datediff);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            diff =rs.getInt(1);
            
        }
        
        String sql_settings = "SELECT s.timelimit,s.finePerDay FROM lms_settings s";
        pst = conn.prepareStatement(sql_settings);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            time = rs.getInt("timelimit");
            fine = rs.getInt("finePerDay");
        }
        
        
        if (diff <= time){
            String sql_updateLB ="UPDATE lms_transaction lb SET lb.returnDate = NOW(),lb.status = 'returned' WHERE lb.mem_id = '"+ mem_id +"' and lb.ISBN = '"+ isbn +"'";
            pst = conn.prepareStatement(sql_updateLB);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Thank you!!!");
        
        }    
        
        else {
            fine = fine * diff;
            String f = Integer.toString(fine);
        
            JOptionPane.showMessageDialog(null, "Time Exceeded pay Rs."+f+"/= fine.");
        
        }
    }
    
    
    
    
    public void confirmReturnbkPayment(String isbn,int mem_id) throws SQLException{
    
        int diff = 0;
        
        
        String sql_dateDiff = "Select DATEDIFF(NOW(),borrowedDate) from lms_transaction";
        pst = conn.prepareStatement(sql_dateDiff);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            diff =rs.getInt(1);
        }
        
        int fine =0;
            String sql_getFine = "Select finePerDay from lms_settings";
            pst = conn.prepareStatement(sql_getFine);
            rs = pst.executeQuery();
        
            while(rs.next()){
        
                fine =rs.getInt(1);
            }
            
            
            fine = fine * diff;
            
         
        String sql_updateStatus ="UPDATE lms_transaction lb SET lb.returnDate = NOW(),lb.status = 'returned' WHERE lb.mem_id = '"+ mem_id +"' and lb.ISBN = '"+ isbn +"'";
        pst = conn.prepareStatement(sql_updateStatus);
        pst.execute();
         
        String sql_updateFine ="UPDATE lms_transaction SET fine = '"+ fine +"' WHERE ISBN = '"+ isbn +"' and mem_id = '"+ mem_id +"' ";
        pst = conn.prepareStatement(sql_updateFine);
        pst.execute();
    
        JOptionPane.showMessageDialog(null,"Thank you!!!");  
    
    }
    
    
    public void addLostBook(String isbn, int mem_id) throws SQLException{
    
        int diff = 0;
        int time =0;
        double fine =0;
        double price = 0;
        int lostfine = 0;
        
        String sql_datediff = "SELECT DATEDIFF(month,GETDATE(),borrowedDate) FROM lms_transaction";
        pst = conn.prepareStatement(sql_datediff);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            diff =rs.getInt(1);
            
        }
        
        String sql_settings = "SELECT s.timelimit,s.finePerDay, s.lostBookFIne FROM lms_settings s";
        pst = conn.prepareStatement(sql_settings);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            time = rs.getInt("timelimit");
            fine = rs.getInt("finePerDay");
            lostfine = rs.getInt("lostBookFine");
        }
        
        
        if (diff <= time){
            
            String sql_getBookPrice = "SELECT price FROM lms_book WHERE ISBN = '"+ isbn +"'";
            pst = conn.prepareStatement(sql_getBookPrice);
            rs = pst.executeQuery();
        
            while(rs.next()){
        
                price = rs.getInt("price");
            
            }
            
            fine = lostfine + price;
            String f = Double.toString(fine);
        
            JOptionPane.showMessageDialog(null, "Please pay Rs."+f+"/= fine.");
            
        }    
        
        else {
            
            String sql_getBookPrice = "SELECT price FROM lms_book WHERE ISBN = '"+ isbn +"'";
            pst = conn.prepareStatement(sql_getBookPrice);
            rs = pst.executeQuery();
        
            while(rs.next()){
        
                price = rs.getInt("price");
            
            }
            
            fine = fine * diff + price +lostfine;
            String f = Double.toString(fine);
        
            JOptionPane.showMessageDialog(null, "Please pay Rs."+f+"/= fine.");
        
        }
    
    
    
    
    
    }
    
    
    public void confirmLostBKPayment(String isbn, int mem_id) throws SQLException{
    
        int diff = 0;
        int time =0;
        double fine =0;
        double price = 0;
        int lostfine = 0;
        
        
        String sql_getBookPrice = "SELECT price FROM lms_book WHERE ISBN = '"+ isbn +"'";
        pst = conn.prepareStatement(sql_getBookPrice);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            price = rs.getInt("price");
            
        }
        
        String sql_datediff = "SELECT DATEDIFF(GETDATE(),borrowedDate) FROM lms_transaction";
        pst = conn.prepareStatement(sql_datediff);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            diff =rs.getInt(1);
            
        }
        
        String sql_settings = "SELECT s.timelimit,s.finePerDay, s.lostBookFIne FROM lms_settings s";
        pst = conn.prepareStatement(sql_settings);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            time = rs.getInt("timelimit");
            fine = rs.getInt("finePerDay");
            lostfine = rs.getInt("lostBookFine");
        }
        
        if(diff <= time){
            
            fine = lostfine + price;
        
            String sql_updateFine ="UPDATE lms_transaction SET fine = '"+ fine +"' WHERE ISBN = '"+ isbn +"' and mem_id = '"+ mem_id +"' ";
            pst = conn.prepareStatement(sql_updateFine);
            pst.execute();
            
            String sql_updateStatus ="UPDATE lms_transaction lb SET lb.status = 'lost' WHERE lb.mem_id = '"+ mem_id +"' and lb.ISBN = '"+ isbn +"'";
            pst = conn.prepareStatement(sql_updateStatus);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Thank you!!!");
        
        }
        else{
        
            fine =fine * diff + lostfine + price;
        
            String sql_updateFine ="UPDATE lms_transaction SET fine = '"+ fine +"' WHERE ISBN = '"+ isbn +"' and mem_id = '"+ mem_id +"' ";
            pst = conn.prepareStatement(sql_updateFine);
            pst.execute();
            
            String sql_updateStatus ="UPDATE lms_transaction lb SET lb.status = 'lost' WHERE lb.mem_id = '"+ mem_id +"' and lb.ISBN = '"+ isbn +"'";
            pst = conn.prepareStatement(sql_updateStatus);
            pst.execute();
            
            JOptionPane.showMessageDialog(null,"Thank you!!!");
        
        }
    
    
    }
}
    

