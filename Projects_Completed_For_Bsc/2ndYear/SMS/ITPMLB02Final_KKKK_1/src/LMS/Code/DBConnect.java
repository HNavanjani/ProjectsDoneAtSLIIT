package LMS.code;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author sanjalee
 */
public class DBConnect {
    
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://localhost:24809;databaseName=smsDB";
    public static String user ="adminK";
    public static String pw ="adminK";
    
    
    public static Connection connect(){
    
        Connection conn = null;
        
        
        try{
            
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pw);
        
        }
        catch(Exception e){
        
            System.out.println(e);
        
        }
        
        return conn;
        
    }
    
}
