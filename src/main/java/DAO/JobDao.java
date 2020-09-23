/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.JobBean;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
    
    public final ArrayList<JobBean> getJobsResultsetByPageNo(ArrayList<String[]> paramList){
        
        ArrayList<JobBean> list = new ArrayList();
        
        
        String sql = "SELECT * FROM job";
        if(paramList.size() > 0){
            sql += " WHERE";
            for(int i = 0 ; i< paramList.size() ; i++){
                
                
                String[] parameters = paramList.get(i);
                
                String name = parameters[0];
                String value = parameters[1];
                String temp;
     
                if(name.equals("category")){
                    temp = " ( " + name + " LIKE '%" + value +"%' )";
                }
                else{
                    temp = " ( " + name + " = '" + value +"' )";
                }
                sql += temp;
                
                if(i < paramList.size()-1){
                    sql+=" AND";
                }
            }
            sql+=" ORDER BY jobid";
            
        }


        try{
            
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                JobBean job = new JobBean();

                job.setJobid(rs.getInt("jobid"));
                job.setName(rs.getString("name"));
                job.setImage(rs.getString("image"));
                job.setStreet(rs.getString("street"));
                job.setDistrict(rs.getString("district"));
                job.setType(rs.getString("type"));
                job.setCategory(rs.getString("category"));
                job.setPublisheddate(rs.getString("publisheddate"));
                job.setVacancy(rs.getString("vacancy"));
                job.setSalary(rs.getString("salary"));
                job.setGender(rs.getString("gender"));
                job.setApplicationdeadline(rs.getString("applicationdeadline"));
                job.setDescription(rs.getString("description"));
                job.setResponsibility1(rs.getString("responsibility1"));
                job.setResponsibility2(rs.getString("responsibility2"));
                job.setResponsibility3(rs.getString("responsibility3"));
                job.setResponsibility4(rs.getString("responsibility4"));
                job.setEduexperience1(rs.getString("eduexperience1"));
                job.setEduexperience2(rs.getString("eduexperience2"));
                job.setEduexperience3(rs.getString("eduexperience3"));
                job.setEduexperience4(rs.getString("eduexperience4"));
                job.setCid(rs.getInt("cid"));
                
                list.add(job);
                
            }
            return list;
            
            
        }catch(SQLException ex){
            System.out.println(ex);
            System.out.println("Exeption By getJobsResultSetByPageNo : JobDao");
            return list;
        }
    }
    
    
    
    public final ArrayList<JobBean> getJobsResultsetByPageNo(){
        
        ArrayList<JobBean> list = new ArrayList();
  
        String sql = "SELECT * FROM job";

        try{
            
            
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                
                JobBean job = new JobBean();

                job.setJobid(rs.getInt("jobid"));
                job.setName(rs.getString("name"));
                job.setImage(rs.getString("image"));
                job.setStreet(rs.getString("street"));
                job.setDistrict(rs.getString("district"));
                job.setType(rs.getString("type"));
                job.setCategory(rs.getString("category"));
                job.setPublisheddate(rs.getString("publisheddate"));
                job.setVacancy(rs.getString("vacancy"));
                job.setSalary(rs.getString("salary"));
                job.setGender(rs.getString("gender"));
                job.setApplicationdeadline(rs.getString("applicationdeadline"));
                job.setDescription(rs.getString("description"));
                job.setResponsibility1(rs.getString("responsibility1"));
                job.setResponsibility2(rs.getString("responsibility2"));
                job.setResponsibility3(rs.getString("responsibility3"));
                job.setResponsibility4(rs.getString("responsibility4"));
                job.setEduexperience1(rs.getString("eduexperience1"));
                job.setEduexperience2(rs.getString("eduexperience2"));
                job.setEduexperience3(rs.getString("eduexperience3"));
                job.setEduexperience4(rs.getString("eduexperience4"));
                job.setCid(rs.getInt("cid"));
                
                list.add(job);
                
            }
            System.out.println("Okay");
            return list;
            
            
        }catch(SQLException ex){
            System.out.println(ex);
            System.out.println("Exeption By getJobsResultSetByPageNo : JobDao");
            return list;
        }
    }
    
    
    public final int add(JobBean JB){
        
            try {
                
                String sql = "INSERT INTO job( name, image, street, district, type,category, publisheddate, vacancy, salary, gender, applicationdeadline, description, responsibility1, responsibility2, responsibility3, responsibility4, eduexperience1, eduexperience2, eduexperience3, eduexperience4, cid) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement stmt = con.prepareStatement(sql);
                
                stmt.setString(1, JB.getName());
                stmt.setString(2, JB.getImage());
                stmt.setString(3, JB.getStreet());
                stmt.setString(4, JB.getDistrict());
                stmt.setString(5, JB.getType());
                stmt.setString(6, JB.getCategory());
                stmt.setString(7, JB.getPublisheddate() );
                stmt.setString(8, JB.getVacancy());
                stmt.setString(9, JB.getSalary());
                stmt.setString(10, JB.getGender());
                stmt.setString(11, JB.getApplicationdeadline() );
                stmt.setString(12, JB.getDescription());
                stmt.setString(13, JB.getResponsibility1());
                stmt.setString(14, JB.getResponsibility2());
                stmt.setString(15, JB.getResponsibility3());
                stmt.setString(16, JB.getResponsibility4());
                stmt.setString(17, JB.getEduexperience1());
                stmt.setString(18, JB.getEduexperience2());
                stmt.setString(19, JB.getEduexperience3());
                stmt.setString(20, JB.getEduexperience4());
                stmt.setInt(21, JB.getCid());
                
                if(stmt.executeUpdate() == 1){
                    
                    return 1;
                }
                else{
                    return 2;
                }
                
            } catch (SQLException ex) {
                
                System.out.println("Exeption By add : JobDao");
                System.out.println(ex);
                return 3;
                
            }  
    }
    
    
        public final boolean remove(int jobid){
        return false;
    }
    
    public final JobBean find(int jobid){
        
        int rowCount = 0;
        try{
            String sql = "SELECT * FROM job WHERE jobid=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, jobid);
            ResultSet rs = stmt.executeQuery();
            
            JobBean job = new JobBean();
            
            while(rs.next()){
                
                job.setJobid(rs.getInt("jobid"));
                job.setName(rs.getString("name"));
                job.setImage(rs.getString("image"));
                job.setStreet(rs.getString("street"));
                job.setDistrict(rs.getString("district"));
                job.setType(rs.getString("type"));
                job.setCategory(rs.getString("category"));
                job.setPublisheddate(rs.getString("publisheddate"));
                job.setVacancy(rs.getString("vacancy"));
                job.setSalary(rs.getString("salary"));
                job.setGender(rs.getString("gender"));
                job.setApplicationdeadline(rs.getString("applicationdeadline"));
                job.setDescription(rs.getString("description"));
                job.setResponsibility1(rs.getString("responsibility1"));
                job.setResponsibility2(rs.getString("responsibility2"));
                job.setResponsibility3(rs.getString("responsibility3"));
                job.setResponsibility4(rs.getString("responsibility4"));
                job.setEduexperience1(rs.getString("eduexperience1"));
                job.setEduexperience2(rs.getString("eduexperience2"));
                job.setEduexperience3(rs.getString("eduexperience3"));
                job.setEduexperience4(rs.getString("eduexperience4"));
                job.setCid(rs.getInt("cid"));
                
                rowCount++;
                
            }
                
            if(rowCount == 1){
                return job;
            }
            else{
                return null;
            }
        

            
        }catch(SQLException ex){
            System.out.println(ex);
            System.out.println("Exeption By isValidJobId : JobDao");
            return null;
        }
        
    }
    
}
