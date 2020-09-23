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
 * @author ABANCE
 */
public class JobDao {
    
    private final Connection con = DBConnection.getConnection();
    
    
    public final int getAllJobsInt(){
        try{
            int rowCount = 0;
            ResultSet rs;

                String sql = "SELECT * FROM job";
                PreparedStatement stmt = con.prepareStatement(sql);
                rs = stmt.executeQuery();

            while(rs.next()){
                   rowCount++;
                }
 
            return rowCount;
            
        }catch(SQLException ex){
            System.out.println("Exeption By getAllJobsInt : JobDao");
            return 0;
        }
    }
    
}
