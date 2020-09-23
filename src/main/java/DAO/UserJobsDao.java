/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.UserBean;
import Bean.UserJobsBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
        
    public final boolean Apply(UserJobsBean userjobsbean){
        
        if(!isApplied(userjobsbean.getUserid(),userjobsbean.getJobid())){
            
            try {
                String sql = "INSERT INTO userjobs(userid,jobid) VALUES(?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                stmt.setInt(1, userjobsbean.getUserid());
                stmt.setInt(2, userjobsbean.getJobid());
                int rs = stmt.executeUpdate();
                
                return rs ==1;
                
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Apply Error");
                return false;
            }
            
        }
        return false;

    }
    
    public HashMap< Integer , ArrayList<UserBean>> getAdminDashboard(int companyId){
        
        try {
            HashMap< Integer , ArrayList<UserBean> > dashboard = new HashMap<>();
            HashMap< Integer , UserBean > user = new HashMap<>();
            
            String sql = " SELECT userjobs.jobid , userjobs.userid FROM userjobs JOIN job ON job.jobid = userjobs.jobid AND job.cid = ? ORDER BY userjobs.jobid";
 
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, companyId);
            ResultSet rs = stmt.executeQuery();
         
            UserDao userdao = new UserDao();
       
            while(rs.next()){
           
                ArrayList<UserBean> templist = new ArrayList<>();

                int jobid = rs.getInt("userjobs.jobid");
                int userid = rs.getInt("userjobs.userid");
        
                if(user.containsKey(userid)){
            
                    UserBean userbean = user.get(userid);
             
                    if(dashboard.containsKey(jobid)){

                      dashboard.get(jobid).add(userbean);  
                    }
                    else{

                        templist.add(userbean);
                        dashboard.put(jobid,templist);
                    }
                }
                else{
                    

                    UserBean userbean = userdao.getUserDetailsById(userid);
                    
                    if(dashboard.containsKey(jobid)){
 
                      dashboard.get(jobid).add(userbean);  
                    }
                    else{

                        templist.add(userbean);
                        dashboard.put(jobid,templist);
                    }
        
                    user.put(userid, userbean);
                    
                }
                                                
            }
            
            return dashboard;
            
        } catch (SQLException ex) {
            Logger.getLogger(UserJobsDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
