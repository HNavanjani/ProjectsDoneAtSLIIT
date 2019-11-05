
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
public class Librarian {
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    public Librarian(){
    
         conn = DBConnection.DBConnect.connect();
    
    }
    
    public void addSettings(int noOfBooks, double finePerDay, double lostBookFine, int timelimit) throws SQLException{
    
        String sql_addSettings = "INSERT INTO lms_settings "
                + "values('"+noOfBooks+"', '"+finePerDay+"', '"+lostBookFine+"', '"+timelimit+"')";
        pst = conn.prepareStatement(sql_addSettings);
        pst.execute();
        
        JOptionPane.showMessageDialog(null,"Entered Successfully!!");
    
    }
    
}
