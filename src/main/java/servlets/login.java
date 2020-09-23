
package servlets;

import DAO.CompanyDao;
import DAO.UserDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.common;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class login extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        UserDao userDao = new UserDao();
        CompanyDao companyDao = new CompanyDao();
        
        if(request.getParameter("Login") == null ){
            
            if((CompanyDao.getSessionDetails(session) == null) && (UserDao.getSessionDetails(session) == null)){
                request.getRequestDispatcher(common.getLayout_path()+"login.jsp").forward(request, response);
            }
            else if(CompanyDao.getSessionDetails(session) != null){
                
                response.sendRedirect(common.getAdmin_servlet());
            }
            else{
                response.sendRedirect(common.getHome_servlet());
            }
        }
        else{
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            
            if(userDao.isValid(email, password)){
                
                userDao.setSessionDetails(session, email);
                response.sendRedirect(common.getHome_servlet());
                
            }
            else if(companyDao.isValid(email, password)){
                
                companyDao.setSessionDetails(session, email);
                response.sendRedirect(common.getAdmin_servlet());
                
            }
            else{
                
                session.setAttribute("Login", "Invalid Username / Password");
                response.setIntHeader("Refresh", 0);
                
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
