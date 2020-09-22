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
import util.DBConnection;

/**
 *
 * @author ASUS
 */
public class UserJobsDao {
    
    private final Connection con = DBConnection.getConnection();

    
    public final boolean isApplied(int userid , int jobid){

        try {
            int rowCount=0;
            
            String sql = "SELECT * FROM userjobs WHERE userid=? AND jobid=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, userid);
            stmt.setInt(2, jobid);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                rowCount++;
            }
            
            return rowCount == 1;
            
        } catch (SQLException ex) {
            System.out.println("isApplied Error ");
            return false;
        }
    }
    
}
