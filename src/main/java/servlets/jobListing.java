package servlets;

import Bean.JobBean;
import DAO.JobDao;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import util.common;

@WebServlet(name = "jobListing", urlPatterns = {"/jobListing"})
public class jobListing extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ArrayList<String[]> paramList = new ArrayList();
        Enumeration list = request.getParameterNames();
        
        String page = request.getParameter("page");
        String queryString = "?";
        
        while(list.hasMoreElements()){
            
            String[] temp = new String[2];
            temp[0] = (String)list.nextElement();
            temp[1] = request.getParameter(temp[0]);
            
            if(!(temp[0].equals("category") || temp[0].equals("district") ||temp[0].equals("type")) ){
                continue;
            }
            if(temp[0].equals("page")){
                continue;
            }
            if(temp[1].equals("")){
                continue;
            }
            queryString += temp[0] +"="+temp[1]+"&";
            paramList.add(temp);
        }
        
        if(page == null){

            response.sendRedirect(common.getJob_listing_servlet()+queryString+"page=1");
            
        }
        else{
            try{
                
                JobDao jobdao = new JobDao();  
                
                ArrayList<JobBean> tempJoblist = jobdao.getJobsResultsetByPageNo(paramList);
                ArrayList<JobBean> joblist = new ArrayList<>();
                
                int intPage = Integer.parseInt(page);//casting
  
                int minimumItemsMustHave = ((intPage-1)*10)+1;
                if(tempJoblist.size() < minimumItemsMustHave){
                    
                    System.out.println("Empty Array");
                    response.sendRedirect(common.getHome_servlet());
                }
                else{
                    
                    int index = (intPage-1)*10;
                    int count = 0; 
    
                    while(index < tempJoblist.size() && count < 10){
                        joblist.add(tempJoblist.get(index));
                        index++;
                        count++;
                    }
                    int arrayCount = tempJoblist.size();

                    request.setAttribute("joblist", joblist);
                    request.setAttribute("page", page);
                    request.setAttribute("queryString", queryString);
                    request.setAttribute("arrayCount", arrayCount);
                    request.getRequestDispatcher(common.getLayout_path()+"job-listings.jsp").forward(request, response);  
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
