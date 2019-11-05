
package LMS.code;

import LMS.LMS_ManageBook_1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author sanjalee
 */
public class Book {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Book(){
    
         conn = DBConnection.DBConnect.connect();
    
    }
    
    public void add(String isbn, String name, double price, String author, String category) throws SQLException{
    
        int vendorid = 0;
        int authorid = 0;
        int categoryid = 0;
        String book = null;
        
        String sql_getBook = "SELECT name FROM lms_book WHERE name like '"+ name +"'";
        pst = conn.prepareStatement(sql_getBook);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            book = rs.getString("name");
        
        }
        
        if(book == null){

            Author authorinstance = new Author();
            authorid = authorinstance.getOne(author);
        
        
            Category categoryinstance = new Category();
            categoryid = categoryinstance.getOne(category);
        
            
            String sql_addBook = "INSERT INTO lms_book values"
                    + "('"+isbn+"', '"+name+"', '"+price+"', 1, '"+authorid+"', '"+categoryid+"')";
            
            pst = conn.prepareStatement(sql_addBook);
            pst.execute();
        
            JOptionPane.showMessageDialog(null,"Entered Successfully!!");
        
        
        }
        else{
        
            String sql_updateStock = "Update lms_book set stock = stock + 1 where name like '"+ name +"' ";
            pst = conn.prepareStatement(sql_updateStock);
            pst.execute();
        
            JOptionPane.showMessageDialog(null,"Book is already available!! Stock successfully updated!!");
        
        
        
        }   
        
    
    }
    
    public void update(String isbn, String name, double price, String author, String category) throws SQLException{
    
        int authorid, categoryid;
        
        Author authorinstance = new Author();
        authorid = authorinstance.getOne(author);
        
        Category categoryinstance = new Category();
        categoryid = categoryinstance.getOne(category);
        
        
        String sql_updateBook = "UPDATE lms_book "
                                + "SET isbn = '"+ isbn +"', name = '"+ name +"', price = '"+ price +"', "
                                + "author_id = '"+ authorid +"', category_id = '"+ categoryid +"' WHERE isbn = '"+ isbn +"'";
        
        pst = conn.prepareStatement(sql_updateBook);
        pst.execute();
    
    }
    
    public ResultSet search(String option, String value) throws SQLException{
        
        //System.out.println(option);
        //System.out.println(value);
    
        if(option.equalsIgnoreCase("isbn")){
        
            String sql_searchbyISBN = "SELECT lb.ISBN, lb.name, lb.price, lb.stock, la.name as author, lc.category "
                                 + "FROM lms_book lb, lms_author la, lms_category lc "
                                 + "WHERE lb.author_id = la.id AND lb.category_id = lc.id AND lb.ISBN = '"+ value +"'";
        
            pst = conn.prepareStatement(sql_searchbyISBN);
            rs = pst.executeQuery();
            
        }
        else if(option.equalsIgnoreCase("name")){
    
          String sql_searchbyName = "SELECT lb.ISBN, lb.name, lb.price, lb.stock, la.name as author, lc.category "
                                 + "FROM lms_book lb, lms_author la, lms_category lc "
                                 + "WHERE lb.author_id = la.id AND lb.category_id = lc.id AND lb.name LIKE '%"+ value +"%'";
        
            pst = conn.prepareStatement(sql_searchbyName);
            rs = pst.executeQuery();  
    
        }
        else if(option.equalsIgnoreCase("author")){
    
          String sql_searchbyName = "SELECT lb.ISBN, lb.name, lb.price, lb.stock, la.name as author, lc.category "
                                 + "FROM lms_book lb, lms_author la, lms_category lc "
                                 + "WHERE lb.author_id = la.id AND lb.category_id = lc.id AND la.name LIKE '%"+ value +"%'";
        
            pst = conn.prepareStatement(sql_searchbyName);
            rs = pst.executeQuery();  
    
        }
        
        
        return rs;
    }
}

