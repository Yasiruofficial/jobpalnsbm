package util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DBConnection {
    
    public static Connection getConnection(){
        
        String dbauth = "root";
        String dbpassword = "admin"; 
        try {
            
            Class.forName("org.mariadb.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/jobpal", dbauth, dbpassword);
                       
            return con;
            
        } catch (ClassNotFoundException | SQLException ex) {
            
            System.out.println("Exeption By DBConnection");
            
        }
        return null;
    }
    
}
