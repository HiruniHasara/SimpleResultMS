/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resultmanagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author acer
 */
public class DBMS {
     private static Connection con ;
    
    public static synchronized Connection getConnection(){
        
        if (con == null) {
            try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecttrial","root","1234");
            } catch (ClassNotFoundException | SQLException e) {
            }
        }
        
        return con;
        
    }
    public static void iud(String query) throws Exception{
        getConnection();
        con.createStatement().executeUpdate(query);
    }
    
    public static ResultSet search(String query) throws Exception{
        getConnection();
        return con.createStatement().executeQuery(query);
    }
}
