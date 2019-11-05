
package TMS;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author I.L.Basnayake
 */
public class timetableDB {
    public static Connection GetConnection() throws ClassNotFoundException{
        Connection conn=null;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url="jdbc:sqlserver://localhost:24809;databaseName=smsDB;username=adminK,password=admink";
        
        try{
            conn=DriverManager.getConnection(url);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
            
        }
        return conn;
    }
    
//     public static Connection getConnection()
//  {
//         
//             Connection conn = null;
//             try { 
//             Class.forName("com.mysql.jdbc.Driver");
//            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/itp_mlb_02_db","root","");
//             
//                     } catch (Exception e) {
//            System.out.println(e.getMessage());
//         }
//         
//         return conn;
//  }
}

         
        

     
    
   /*public static Connection connect()
  {
   Connection conn = null;
   
   
   //series process
   try{
       
       Class.forName("com.mysql.jdbc.Driver");
       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/itp","root","");
   }
   catch (ClassNotFoundException | SQLException e)
   {
       System.out.println(e);
   
   }
   return conn;

}*/
    
  
    

