<%@page import="util.common"%>
<%@page import="DAO.CompanyDao"%>
<%@page import="Bean.JobBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="DAO.JobDao"%>
<%  
    CompanyDao company = new CompanyDao();
    
    int curruntPage = Integer.parseInt((String)request.getAttribute("page"));
    String queryString = (String)request.getAttribute("queryString");
    ArrayList<JobBean> joblist = (ArrayList<JobBean>)request.getAttribute("joblist");
    int arrayCount = (Integer)request.getAttribute("arrayCount");


%>
<!doctype html>
<html lang="en">
  <head>
    <title>JobBoard &mdash; Website Template by Colorlib</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    
    <link rel="stylesheet" href="css/custom-bs.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="fonts/line-icons/style.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/animate.min.css">
    <link rel="stylesheet" href="css/quill.snow.css">
    

    <!-- MAIN CSS -->
    <link rel="stylesheet" href="css/style.css">    
  </head>
  <body id="top">

  <div id="overlayer"></div>
  <div class="loader">
    <div class="spinner-border text-primary" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div>
    

<div class="site-wrap">

    <div class="site-mobile-menu site-navbar-target">
      <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
          <span class="icon-close2 js-menu-toggle"></span>
        </div>
      </div>
      <div class="site-mobile-menu-body"></div>
    </div> <!-- .site-mobile-menu -->
    

    <!-- NAVBAR -->
    <jsp:include page="/WEB-INF/headers/header.jsp"/>

    
    <section class="site-section" id="next">
      <div class="container">

        <div class="row mb-5 justify-content-center">
          <div class="col-md-7 text-center">
            <h2 class="section-title mb-2">43,167 Job Listed</h2>
          </div>
        </div>
        
        <ul class="job-listings mb-5">

          
        
        <% 
            int i = 0;
            while(i < joblist.size()) 
            {
                
                JobBean job = joblist.get(i);
                String[] myCompany = company.getCompanyDetailsById(job.getCid());
        %>
          <li class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center">
              <a href="<%=common.getJob_servlet()+ "?jobid=" + job.getJobid() %>"></a>
            <div class="job-listing-logo">
                <%System.out.println("Company logo is + " + myCompany[4]);%>
                <img src="<%=myCompany[4] %>" alt="Image" class="img-fluid">
            </div>

            <div class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
              <div class="job-listing-position custom-width w-50 mb-3 mb-sm-0">
                <h2><%=job.getName() %></h2>
                <strong><%=myCompany[0] %></strong>
              </div>
              <div class="job-listing-location mb-3 mb-sm-0 custom-width w-25">
                <span class="icon-room"></span> <%=job.getStreet() %>, <%=job.getDistrict()%> 
              </div>
              <div class="job-listing-meta">
                <span class="badge badge-success"><%=job.getType() %></span>
              </div>
            </div>
          </li>
          
        <% 
                i++;
            } 
        %>

        </ul>

        <div class="row pagination-wrap">
          <div class="col-md-6 text-center text-md-left mb-4 mb-md-0">
            <span>Showing <%=curruntPage %> - <%=common.getPaginationInt(arrayCount) %> Of <%=arrayCount %></span>
          </div>
          <div class="col-md-6 text-center text-md-right">
            <div class="custom-pagination ml-auto">

                <%=common.getprevPage(queryString,curruntPage) %>
              <div class="d-inline-block">
                  
                  <%=common.getPagination(queryString, arrayCount, curruntPage) %>
                    
              </div>
                  <%=common.getnextPage(queryString,arrayCount,curruntPage) %>
            </div>
          </div>
        </div>

      </div>
    </section>

    <section class="py-5 bg-image overlay-primary fixed overlay" style="background-image: url('images/hero_1.jpg');">
      <div class="container">
        <div class="row align-items-center">
          <div class="col-md-8">
            <h2 class="text-white">Looking For A Job?</h2>
            <p class="mb-0 text-white lead">Lorem ipsum dolor sit amet consectetur adipisicing elit tempora adipisci impedit.</p>
          </div>
          <div class="col-md-3 ml-auto">
            <a href="#" class="btn btn-warning btn-block btn-lg">Sign Up</a>
          </div>
        </div>
      </div>
    </section>

    <jsp:include page="/WEB-INF/headers/footer.jsp"/>
  
  </div>

    <!-- SCRIPTS -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/isotope.pkgd.min.js"></script>
    <script src="js/stickyfill.min.js"></script>
    <script src="js/jquery.fancybox.min.js"></script>
    <script src="js/jquery.easing.1.3.js"></script>
    
    <script src="js/jquery.waypoints.min.js"></script>
    <script src="js/jquery.animateNumber.min.js"></script>
    <script src="js/owl.carousel.min.js"></script>
    <script src="js/quill.min.js"></script>
    
    
    <script src="js/bootstrap-select.min.js"></script>
    
    <script src="js/custom.js"></script>
   
   
     
  </body>
</html>