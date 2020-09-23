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
 * @author dinusha thilini
 */
public class CompanyDao {
    
    private final Connection con = DBConnection.getConnection();   
                
    public final static boolean isLogged(HttpSession session){
        
        return getSessionDetails(session) != null;
        
    }//Check Logging
    
    public static final String[] getSessionDetails(HttpSession session) {
        
        String[] companyDetails = (String[])session.getAttribute("company");
        return companyDetails;
        
    }//Get company details from session
    
    public final boolean isValid(String companyEmail,String password) {
        
        try{
            int rowCount=0;
            
            String sql = "SELECT * FROM company WHERE email=? AND password=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, companyEmail);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
                
            while(rs.next()){
                 rowCount++;
            }
               
           return rowCount == 1 ;
            
        }catch(SQLException ex){
            System.out.println(ex + " : Exeption By isValidCompanyLogin");
            return false;
        }
        
    }//Check The Availability Of the Company
    
    



}
