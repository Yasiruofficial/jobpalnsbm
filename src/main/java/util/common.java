
package util;

import DAO.CompanyDao;
import DAO.JobDao;
import DAO.UserDao;
import DAO.UserJobsDao;
import javax.servlet.http.HttpSession;

public class common {

    private final static String domain = "/";
    private final static String about_servlet = domain+"about";
    private final static String admin_servlet = domain+"admin";
    private final static String contact_servlet = domain+"contact";
    private final static String home_servlet = domain+"home";
    private final static String job_servlet = domain+"job";
    private final static String job_listing_servlet = domain+"jobListing";
    private final static String login_servlet = domain+"login";
    private final static String post_job_servlet = domain+"postJob";
    private final static String register_servlet = domain+"register";
    private final static String layout_path = domain+"WEB-INF/layouts/";
    private final static String logout_path = domain+"logout";

    public final static String getDomain() {
        
        return "";
    }

    public final static String getAbout_servlet() {
        return about_servlet;
    }

    public final static String getAdmin_servlet() {
        return admin_servlet;
    }

    public final static String getContact_servlet() {
        return contact_servlet;
    }

    public final static String getHome_servlet() {
        return home_servlet;
    }

    public final static String getJob_servlet() {
        return job_servlet;
    }

    public final static String getJob_listing_servlet() {
        return job_listing_servlet;
    }

    public final static String getLogin_servlet() {
        return login_servlet;
    }

    public final static String getPost_job_servlet() {
        return post_job_servlet;
    }

    public final static String getRegister_servlet() {
        return register_servlet;
    }

    public final static String getLayout_path() {
        return layout_path;
    }

    public final static String getLogout_path() {
        return logout_path;
    }

    
    public final static void LogOut(HttpSession session) {
        
        session.invalidate();
        
    }//Logout user
    
    public final static String getCatList(){
        return "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>"
                + "<option>Accounts</option>";
    }
    public final static String getDisList(){
                return "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>"
                + "<option>Kaluthara</option>";
    }
    
    
        
    public final static int getPaginationInt(int arrayCount) {
       
        int getalljobsint = arrayCount;
        
        if((getalljobsint%10) == 0 ){
            
            return getalljobsint/10;
        }
        else{
            
            return (getalljobsint/10) + 1;
        }

    }
    
    public final static String getPagination(String queryString,int arrayCount,int currentPage){

        int pages = getPaginationInt(arrayCount);
        String links = "";
        
        for(int i = currentPage-1; i<=pages ; i++){
            
            
            if(!(i>(currentPage+1) && i<pages)){
                
                if(i==0){
                    continue;
                }
                if(i==currentPage){
                    links += "<a class='active' href='"+getJob_listing_servlet()+queryString+"page=" + i + "'>" + i + "</a>" ;
                }
                else{
                    links += "<a href='"+getJob_listing_servlet()+queryString+"page=" + i + "'>" + i + "</a>" ;
                }
                
            }
        }
        return links;
    }//For Job Listing Page
       
    public final static String getprevPage(String queryString,int currentpage){
         
        if(currentpage != 1){
                return "<a href='" +getJob_listing_servlet()+queryString+"page=" + (currentpage-1) + "' class='prev'>Prev</a>" ;
        }
        else{
          return "";
      }
  
    }
      
    public final static String getnextPage(String queryString,int arrayCount,int currentpage){
        
        if(currentpage != getPaginationInt(arrayCount)){ 
                return "<a href=' " +getJob_listing_servlet()+queryString+ "page=" + (currentpage+1) + " ' class='next'>Next</a>" ;
        }
        else{
          return "";
      }
  
    }
    
    public final static String getJobType(String type){
        if(type.equals("Part Time")){
            return "<span class=\"text-danger\">Part Time</span>";
        }
        else{
            return "<span class=\"text-primary\">Full Time</span>";
        }
    }
    
    public final static String getEduorRes(String string){
        if(string == null || string.equals("")){
            return "";
        }
        else{
            return "<li class=\"d-flex align-items-start mb-2\"><span class=\"icon-check_circle mr-2 text-muted\"></span><span>"+ string +"</span></li>";
        }
    }
    
    public final static String getPagination(){
        
        int pages = getPaginationInt();
        String links = "";
        
        for(int i = 1 ; i<=pages ; i++){
            
            
            if(!(i>3 && i<pages)){
                
                
                if(i==1){
                    links += "<a class='active' href='"+getJob_listing_servlet()+"?page=" + i + "'>" + i + "</a>" ;
                }
                else{
                    links += "<a href='"+getJob_listing_servlet()+"?page=" + i + "'>" + i + "</a>" ;
                }
                
            }
        }
        return links;
    }//For Index Page
    
    public final static int getPaginationInt() {
            
        JobDao jobdao = new JobDao();
        int getalljobsint = jobdao.getAllJobsInt();
        
        if((getalljobsint%10) == 0 ){
            
            return getalljobsint/10;
        }
        else{
            
            return (getalljobsint/10) + 1;
        }

    }
    
    
    public final static String getApplyBtn(HttpSession session,int jobid){
        
        if(UserDao.isLogged(session)){
            String[] userdetails =  UserDao.getSessionDetails(session);
            int userid = Integer.parseInt(userdetails[0]);
            
            UserJobsDao userjobsdao = new UserJobsDao();
            
            if( userjobsdao.isApplied(userid, jobid) ){
                return "           <div class=\"row mb-5\">\n" +
                        "              <div class=\"col-6\">\n" +
                        "                <a href=\"#\" class=\"btn btn-block btn-secondary disabled btn-md\">Applyed</a>\n" +
                        "              </div>\n" +
                        "            </div>";
            }
            else
            {
                
                
                return "           <div class=\"row mb-5\">\n" +
                        "              <div class=\"col-6\">\n" +
                        "                <a href=\"apply?jobid="+jobid+"\" class=\"btn btn-block btn-primary btn-md\">Apply Now</a>\n" +
                        "              </div>\n" +
                        "            </div>";
                
            }
        }
        else{
            if(CompanyDao.isLogged(session)){
                return "";
            } else {
                return "           <div class=\"row mb-5\">\n" +
                        "              <div class=\"col-6\">\n" +
                        "                <a href=\"login\" class=\"btn btn-block btn-primary btn-md\">Login to Apply</a>\n" +
                        "              </div>\n" +
                        "            </div>";
            }
           
        }

    }
    
}
