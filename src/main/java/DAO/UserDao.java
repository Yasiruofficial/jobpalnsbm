/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.http.HttpSession;
import util.DBConnection;
/**
 *
 * @author WCT
 */
public class UserDao {
    
    private final Connection con = DBConnection.getConnection();        
                
    public final static boolean isLogged(HttpSession session){
        
        return getSessionDetails(session) != null;
        
    }//Check Logging
    
    public static final String[] getSessionDetails(HttpSession session) {
        
        String[] userDetails = (String[])session.getAttribute("user");
        return userDetails;
        
    }//Get user details from session
    
    public final boolean isValid(String userEmail,String password) {
        
        try{
            int rowCount=0;
            
            String sql = "SELECT * FROM user WHERE email=? AND password=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userEmail);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
                
            while(rs.next()){
                 rowCount++;
            }
               
           return rowCount == 1 ;
            
        }catch(SQLException ex){
            System.out.println("Exeption By isValidUserLogin : UserDao");
            System.out.println(ex);
            return false;
        }
        
    }//Check The Availability Of the user
    
    public final boolean isAlreadyIn(String userEmail) {
        
        try{
            int rowCount=0;
            
            String sql = "SELECT * FROM user WHERE email=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userEmail);
            ResultSet rs = stmt.executeQuery();
                
            while(rs.next()){
                 rowCount++;
            }

            String sql2 = "SELECT * FROM company WHERE email=?";
            PreparedStatement stmt2 = con.prepareStatement(sql2);
            stmt2.setString(1, userEmail);
            ResultSet rs2 = stmt2.executeQuery();
                
            while(rs2.next()){
                 rowCount++;
            }

           return rowCount >= 1 ;
            
        }catch(SQLException ex){
            System.out.println("Exeption By isAlreadyIn : UserDao");
            return false;
        }
        
    }//Check The already in
    
}
