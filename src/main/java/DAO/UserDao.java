/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
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
    
}
