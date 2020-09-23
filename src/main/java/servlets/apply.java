/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Bean.JobBean;
import Bean.UserJobsBean;
import DAO.JobDao;
import DAO.UserDao;
import DAO.UserJobsDao;
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

@WebServlet(name = "apply", urlPatterns = {"/apply"})
public class apply extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(UserDao.getSessionDetails(session) == null){
            response.sendError(401);
        }
        else{
            try{
                String[] userdetails = UserDao.getSessionDetails(session);
                
                int userid = Integer.parseInt(userdetails[0]);
                
                int jobid = Integer.parseInt(request.getParameter("jobid"));
            
                UserJobsDao userjobsdao = new UserJobsDao();
                UserJobsBean userjobsbean = new UserJobsBean();
                
                userjobsbean.setUserid(userid);
                userjobsbean.setJobid(jobid);
                               
                if(userjobsdao.Apply(userjobsbean)){
                    session.setAttribute("jobApply", "1");
                    try {
                            EmailUtility.sendEmail(userdetails[2], "Job Application Verify"  , "Your Application has been successfully sent to the company. \n\nBest Regurds \njobpalnsbm.com");
                        } catch (MessagingException ex) {
                            Logger.getLogger(postJob.class.getName()).log(Level.SEVERE, null, ex);
                        }
                }
                else{
                    session.setAttribute("jobApply", "0");
                }
                  
                JobDao jobdao = new JobDao();
                JobBean job = jobdao.find(jobid);
                
                request.setAttribute("job", job);
                request.getRequestDispatcher(common.getLayout_path()+"job-single.jsp").forward(request, response);
            }
            catch(NumberFormatException ex){
                response.sendError(500);
            }
        }
            
 
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
