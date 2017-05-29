
package newsystem;
import java.sql.*;
import javax.swing.*;

public class DataBaseConnection {
    Connection conn = null;
    public static Connection ConnectDB(){
        try{
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:src\\Database\\NumberSystem(1).sqlite");
//            JOptionPane.showMessageDialog(null,"Connection Succeeded");
            
            return conn;
            
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"Connection Not Succeeded");
        }
        return null;        
    }
//    public static void main(String[] args) {
////        new DataBaseConnection();
//        DataBaseConnection.ConnectDB();
//        
//    }
}
