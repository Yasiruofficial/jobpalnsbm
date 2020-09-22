/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import Bean.CompanyBean;
import Bean.UserBean;
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

@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        
        if(request.getParameter("Signup") == null){
         
            if((CompanyDao.getSessionDetails(session) == null) && (UserDao.getSessionDetails(session) == null)){
                
                request.getRequestDispatcher(common.getLayout_path()+"register.jsp").forward(request, response);
            }
            else if(CompanyDao.getSessionDetails(session) != null){
                
                response.sendRedirect(common.getAdmin_servlet());
            }
            else{
                response.sendRedirect(common.getHome_servlet());
            }
            
        }else{

            if(request.getParameter("iscompany").equals("true")){
    
                String name = request.getParameter("name");
                String email = request.getParameter("email");      
                String password = request.getParameter("password");      
                String address = request.getParameter("address");        
                String mnumber = request.getParameter("mnumber");        
                String logo = "/images/company/company.jpg"; 
                
                CompanyBean companyBean = new CompanyBean(name, email, password, address, mnumber, logo);
                
                CompanyDao companyDeo = new CompanyDao();
                
                int res = companyDeo.add(companyBean);
                
                switch (res) {
                    case 1:
                        session.setAttribute("Register", "Register Success");
                        break;
                    case 2:
                        session.setAttribute("Register", "Register Fail");
                        break;
                    case 3:
                        session.setAttribute("Register", "Register Exeption");
                        break;
                    case 4:
                        session.setAttribute("Register", "Account already Exist");
                        break;
                    default:
                        break;
                }
                
                response.setIntHeader("Refresh", 0);
                        
            }else{
            
                String fname = request.getParameter("fname");
                String lname = request.getParameter("lname");
                String email = request.getParameter("email");      
                String password = request.getParameter("password");      
                String address = request.getParameter("address");        
                String mnumber = request.getParameter("mnumber"); 
                String gender = request.getParameter("gender"); 
                String bday = request.getParameter("bday"); 
                String exyears = request.getParameter("exyears"); 
                String[] experience = request.getParameterValues("experience"); 
                String logo;
                if(gender.equals("Male")){
                    logo = "images/user/male.jpg"; 
                }
                else{
                    logo = "images/user/female.jpg"; 
                }
                

                UserBean userBean = new UserBean(email, fname, lname, password, address, mnumber, gender, bday, exyears,experience, logo);
                UserDao userDao = new UserDao();
                
                int res = userDao.add(userBean);
                
                switch (res) {
                    case 1:
                        session.setAttribute("Register", "Register Success");
                        break;
                    case 2:
                        session.setAttribute("Register", "Register Fail");
                        break;
                    case 3:
                        session.setAttribute("Register", "Register Exeption");
                        break;
                    case 4:
                        session.setAttribute("Register", "Account already Exist");
                        break;
                    default:
                        break;
                }
                
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
