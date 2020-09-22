/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Bean.JobBean;
import DAO.JobDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.common;


@WebServlet(name = "job", urlPatterns = {"/job","/job?jobid=*"})
public class job extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String jobid = request.getParameter("jobid");
        
        if(jobid == null){
            
            response.sendRedirect(common.getHome_servlet());
            
        }
        else{
            try{
                JobDao jobdao = new JobDao();

                JobBean job = jobdao.find(Integer.parseInt(jobid));
                
                if(job != null){
                    request.setAttribute("job", job);
                    request.getRequestDispatcher(common.getLayout_path()+"job-single.jsp").forward(request, response);
                }
                else{
                    response.sendRedirect(common.getHome_servlet());
                }
                
            }
            catch(NumberFormatException ex){
                
                response.sendError(500);
               
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
