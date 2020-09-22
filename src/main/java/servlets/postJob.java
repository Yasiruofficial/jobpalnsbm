/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Bean.JobBean;
import DAO.CompanyDao;
import DAO.JobDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.EmailUtility;
import util.common;

@WebServlet(name = "postJob", urlPatterns = {"/postJob"})
public class postJob extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();    
        String[] company = CompanyDao.getSessionDetails(session);
        
        if(company == null){
            
            response.sendError(401);      
        }
        else{

            if(request.getParameter("submit") == null){
                
                request.getRequestDispatcher(common.getLayout_path()+"post-job.jsp").forward(request, response);
            }
            else{
                    String name = request.getParameter("name");
                    String image = "/images/jobs/job.jpg";
                    String street = request.getParameter("street");
                    String district = request.getParameter("district");
                    String type = request.getParameter("type");
                    String category = request.getParameter("category");
                    String publisheddate = request.getParameter("publisheddate");
                    String vacancy = request.getParameter("vacancy");
                    String salary = request.getParameter("salary");
                    String gender = request.getParameter("gender");
                    String applicationdeadline = request.getParameter("applicationdeadline");
                    String description = request.getParameter("description");
                    String responsibility1 = request.getParameter("responsibility1");
                    String responsibility2 = request.getParameter("responsibility2");
                    String responsibility3 = request.getParameter("responsibility3");
                    String responsibility4 = request.getParameter("responsibility4");
                    String eduexperience1 = request.getParameter("eduexperience1");
                    String eduexperience2 = request.getParameter("eduexperience2");
                    String eduexperience3 = request.getParameter("eduexperience3");
                    String eduexperience4 = request.getParameter("eduexperience4");
                    int cid = Integer.parseInt(company[0]);
                    
                    JobBean jobbean = new JobBean(name, image, street, district, type, category, publisheddate, vacancy, salary, gender, applicationdeadline, description, responsibility1, responsibility2, responsibility3, responsibility4, eduexperience1, eduexperience2, eduexperience3, eduexperience4, cid);
                    JobDao jobdao = new JobDao();
                    
                    if(jobdao.add(jobbean) == 1){
                        session.setAttribute("postJob", "1");
                        
                        try {
                            EmailUtility.sendEmail(company[2], name , "Your job has been succesfully updated \n\nBest Regurds \njobpalnsbm.com");
                        } catch (MessagingException ex) {
                            Logger.getLogger(postJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        
                        response.setIntHeader("Refresh", 0);
                        
                    }
                    else{
                        session.setAttribute("postJob", "0");
                        try {
                            EmailUtility.sendEmail(company[2], name , "Error of updating Your job \n\nBest Regurds \njobpalnsbm.com");
                        } catch (MessagingException ex) {
                            Logger.getLogger(postJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        response.setIntHeader("Refresh", 0);
                    }
            }
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
