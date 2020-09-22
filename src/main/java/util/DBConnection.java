package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnection {
    
    public static Connection getConnection(){
        try {
            
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/jobpal", "root", "admin");
            
            return con;
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            System.out.println("Exeption By DBConnection");
            
        }
        return null;
    }
    
}
