/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import DAO.CompanyDao;
import DAO.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
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

@WebServlet(name = "sendmail", urlPatterns = {"/sendmail"})
public class sendmail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
              
        String subject  = request.getParameter("subject");
        String body  = request.getParameter("msgbody");
        
        if(subject != null && body != null){
            
            if(UserDao.isLogged(session)){
            
            String[] userdetails = UserDao.getSessionDetails(session);
            String name = userdetails[1];
            String email = userdetails[2];
            
            String userMsg = "Dear "+ name + ". Thanks For the Contacting Us. We Will Respond you as soon as possible. \nBest Regurds, \nJobPal.com";
            String userHeader = "JobPal - Customer Service";
            
            String adminmsg = "User ID : " + userdetails[0] + "\nUSer Name : " + name +" \n\n"+body+"\n\n reply to : " + email;
            String adminHedder = "User Response";
            
                try {
                    
                    EmailUtility.sendEmail(email, userHeader, userMsg);
                    EmailUtility.sendEmail("yasiruswaris@gmail.com", adminHedder, adminmsg);
                    response.sendRedirect(common.getHome_servlet());
                } catch (MessagingException ex) {
                    Logger.getLogger(sendmail.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
            else if(CompanyDao.isLogged(session)){
            
                String[] companydetails = CompanyDao.getSessionDetails(session);
                String name = companydetails[1];
                String email = companydetails[2];
                
                String companyMsg = "Dear "+ name + ". Thanks For the Contacting Us. We Will Respond you as soon as possible. \nBest Regurds, \nJobPal.com";
                String companyHeader = "JobPal - Customer Service";
                
                String adminmsg = "Company ID : " + companydetails[0] + "\nCompany Name : " + name +" \n\n"+body+"\n\n reply to : " + email;
                String adminHedder = "Company Response";
                
                try {
                    
                EmailUtility.sendEmail(email, companyHeader, companyMsg);
                EmailUtility.sendEmail("yasiruswaris@gmail.com", adminHedder, adminmsg);
                response.sendRedirect(common.getHome_servlet());
                
                } catch (MessagingException ex) {
                    Logger.getLogger(sendmail.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{
                response.sendRedirect(common.getHome_servlet());
            } 
        }
        else{
            response.sendRedirect(common.getHome_servlet());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
