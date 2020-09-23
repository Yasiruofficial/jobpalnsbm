package servlets;

import Bean.UserBean;
import DAO.CompanyDao;
import DAO.UserJobsDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.common;

@WebServlet(name = "admin", urlPatterns = {"/admin"})
public class admin extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        if(CompanyDao.getSessionDetails(session) == null){
            response.sendError(401);
        }
        else{
            UserJobsDao userjobsdao = new UserJobsDao();
            
            String[] company = CompanyDao.getSessionDetails(session);
            int conpanyId = Integer.parseInt(company[0]);

            HashMap< Integer , ArrayList<UserBean>> dashboard = userjobsdao.getAdminDashboard(conpanyId);

            request.setAttribute("dashboard", dashboard);
            request.getRequestDispatcher(common.getLayout_path()+"admin.jsp").forward(request, response);
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
