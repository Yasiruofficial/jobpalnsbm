/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Bean.UserBean;
import DAO.CompanyDao;
import DAO.UserDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import util.common;

/**
 *
 * @author yasir
 */
@WebServlet(name = "profile", urlPatterns = {"/profile"})
public class profile extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("GetRequest");
        HttpSession session = request.getSession();
        
        if(CompanyDao.isLogged(session)){
            
            try{
                int userid = Integer.parseInt(request.getParameter("userid"));
                
                UserDao userdao = new UserDao();
                UserBean userbean = userdao.getUserDetailsById(userid);
                
                request.setAttribute("userbean", userbean );
           
                request.getRequestDispatcher(common.getLayout_path()+"profile.jsp").forward(request, response);
                
            }catch(NumberFormatException ex){
                System.out.println(ex);
            }
            
            
        }
        else{
            response.sendError(401);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
