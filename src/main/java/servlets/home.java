package servlets;

import Bean.JobBean;
import DAO.CompanyDao;
import DAO.JobDao;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.common;

@WebServlet(name = "home", urlPatterns = {"/home"})
public class home extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        JobDao jobdao = new JobDao(); 

        ArrayList<JobBean> tempJoblist = jobdao.getJobsResultsetByPageNo();
        ArrayList<JobBean> joblist = new ArrayList<>();
    
        int curruntPageInt = 1;
        int index = (curruntPageInt-1)*10;
        int count = 0;

        while(index < tempJoblist.size() && count < 10){
            joblist.add(tempJoblist.get(index));
            index++;
            count++;
        }
        System.out.println(joblist.size());
        request.setAttribute("joblist", joblist);
        request.getRequestDispatcher(common.getLayout_path()+"index.jsp").forward(request, response);

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
