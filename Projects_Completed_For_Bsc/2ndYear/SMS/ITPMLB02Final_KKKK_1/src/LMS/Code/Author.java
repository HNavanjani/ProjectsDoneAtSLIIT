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
public class Author {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public Author(){
    
         conn = DBConnection.DBConnect.connect();
        
    }
    
    public void addAuthor(String name) throws SQLException{
    
        String sql_addAuthor = "INSERT INTO lms_author(name) values('"+ name +"')";
        pst = conn.prepareStatement(sql_addAuthor);
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Successfully Entered!!");
    
    }
    
    public String[] get() throws SQLException{
    
        int all = 0;
        
        String sql_countall = "SELECT count(*) as count FROM lms_author";
        pst = conn.prepareStatement(sql_countall);
        //System.out.println(pst);
        rs = pst.executeQuery();
        
        while(rs.next()){
        
            all = rs.getInt("count");
        
        }
        
        String[] authors = new String[all];
        int count = 0;
        
        String sql_getAuthors = "SELECT * FROM lms_author";
        pst = conn.prepareStatement(sql_getAuthors);
        rs = pst.executeQuery();
        
        
        while(rs.next()){
        
            authors[count] = rs.getString("name");
            count++;
        
        }
        //JOptionPane.showMessageDialog(null,authors);
        return authors;
    
    
    }
    
    public int getOne(String author) throws SQLException{
    
        int authorid = 0;

        String sql_getauthor = "SELECT id FROM lms_author WHERE name = '"+ author +"' ";
        
            pst = conn.prepareStatement(sql_getauthor);
            System.out.println(pst);
            rs = pst.executeQuery();
        
        
        while(rs.next()){

                authorid = rs.getInt("id");
                System.out.println(authorid);

        }
        
        return authorid;
    
    }
    
    public void update(String author,int id){
        
        System.out.println(author);
        System.out.println(id);
    
        String sql_updateAuthor = "UPDATE lms_author SET name = '"+ author +"' WHERE id = '"+ id +"' ";
        try {
            pst = conn.prepareStatement(sql_updateAuthor);
            System.out.println(pst);
            pst.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JOptionPane.showMessageDialog(null,"Successfully Updated!!");
        
    }
}
