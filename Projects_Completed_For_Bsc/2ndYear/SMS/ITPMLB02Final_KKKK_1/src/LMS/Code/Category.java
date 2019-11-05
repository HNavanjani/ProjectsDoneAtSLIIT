package LMS.code;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sanjalee
 */
public class Category {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public Category(){
    
         conn = DBConnection.DBConnect.connect();
        
    }
    
    public void addCategory(String category) throws SQLException{
    
        String sql_addCategory = "INSERT INTO lms_category(category) values('"+ category +"')";
        pst = conn.prepareStatement(sql_addCategory);
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Successfully Entered!!");
    
    }
    
    public String[] get() throws SQLException{
        
        int all = 0;
        
        String sql_countall = "SELECT count(*) as count FROM lms_category";
        pst = conn.prepareStatement(sql_countall);
        //System.out.println(pst);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            all = rs.getInt("count");
        
        }
        
        String[] categories = new String[all];
        int count = 0;
        
        String sql_getCategories = "SELECT * FROM lms_category";
        pst = conn.prepareStatement(sql_getCategories);
        //System.out.println(pst);
        rs = pst.executeQuery();
        
        
        while(rs.next()){
        
            categories[count] = rs.getString("category");
            //System.out.println(categories[count]);
            count++;
        
        }
        //JOptionPane.showMessageDialog(null,categories);
        return categories;
    
    
    }
    
    public int getOne(String category) throws SQLException{
    
        int categoryid = 0;

        String sql_getcategory = "SELECT id FROM lms_category WHERE category = '"+ category +"' ";
        
            pst = conn.prepareStatement(sql_getcategory);
            rs = pst.executeQuery();
        
        
        while(rs.next()){

                categoryid = rs.getInt("id");

        }
        
        return categoryid;
    
    }
    
    public void update(String category,int id){
    
        String sql_updateCategory = "UPDATE lms_category SET category = '"+ category +"' WHERE id = '"+ id +"' ";
        try {
            pst = conn.prepareStatement(sql_updateCategory);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null,"Successfully Updated!!");
        
    }
    
    
    
}
