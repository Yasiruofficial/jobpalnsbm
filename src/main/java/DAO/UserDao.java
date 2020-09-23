
package DAO;

import Bean.UserBean;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DBConnection;

import java.sql.Connection;
import java.util.Arrays;

import javax.servlet.http.HttpSession;

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

    public final void setSessionDetails(HttpSession session,String userEmail) {
        
        try{
            String sql = "SELECT * FROM user WHERE email=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, userEmail);
            ResultSet rs = stmt.executeQuery();
            
            rs.next();
              
            int userId = rs.getInt("userid");
            String userName = rs.getString("fname");
            
            String[] userDetails = new String[3];
            userDetails[0] = Integer.toString(userId);
            userDetails[1] = userName;
            userDetails[2] = userEmail;
                
            session.setAttribute("user", userDetails);
            
        }catch(SQLException ex){
            System.out.println("Exeption By setSessionDetails : UserDao");
            
        }
        
    }//Set user details to session


    public final int add(UserBean UB) {
        
        if( !isAlreadyIn( UB.getEmail() ) ){
      
            try {
                
                String sql = "INSERT INTO user(email,fname,lname,password,address,mnumber,gender,bday,exyears,experience,photo) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                
                stmt.setString(1, UB.getEmail());
                stmt.setString(2, UB.getFname());
                stmt.setString(3, UB.getLname());
                stmt.setString(4, UB.getPassword());
                stmt.setString(5, UB.getAddress());
                stmt.setString(6, UB.getMnumber());
                stmt.setString(7, UB.getGender());
                stmt.setString(8, UB.getBday() );
                stmt.setString(9, UB.getExyears());
                stmt.setString(10, Arrays.toString(UB.getExperience()));
                stmt.setString(11, UB.getPhoto());                
                
                int rs = stmt.executeUpdate();

                
                if( rs == 1){
                    
                    return 1;
                }
                else{
                    
                    return 2;
                }
                
            } catch (SQLException ex) {
                System.out.println(ex);
                return 3;
            }  
        }
        else{
            return 4;
        }

    }//user register
    
    
    
}
