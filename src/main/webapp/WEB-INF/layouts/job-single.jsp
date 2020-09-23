<%@page import="DAO.UserJobsDao"%>
<%@page import="DAO.JobDao"%>
<%@page import="util.common"%>
<%@page import="DAO.CompanyDao"%>
<%@page import="Bean.JobBean"%>
<%
    JobDao jobdao = new JobDao();
    JobBean job = (JobBean)request.getAttribute("job");
    CompanyDao company = new CompanyDao();
    
    String[] companyDetails = company.getCompanyDetailsById(job.getCid());
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

    <section class="site-section">
      <div class="container">
        <div class="row align-items-center mb-5">
          <div class="col-lg-8 mb-4 mb-lg-0">
            <%
 
            if(session.getAttribute("jobApply") != null){

                if(session.getAttribute("jobApply").equals("1")){
                    out.print("<span style='color:green;'>Applyed Successful</span>");
                }
                else{
                    out.print("<span style='color:red;'>Alredy Applied</span>");
                }         
                             
            session.removeAttribute("jobApply");
            }
            %>
            <div class="d-flex align-items-center">
              <div class="border p-2 d-inline-block mr-3 rounded">
                  <img src="<%=companyDetails[4] %>" alt="Image" style="width: 150px;height: 150px;">
              </div>
              <div>
                <h2><%=job.getName() %></h2>
                <div>
                  <span class="ml-0 mr-2 mb-2"><span class="icon-briefcase mr-2"></span><%=companyDetails[0] %></span>
                  <span class="m-2"><span class="icon-room mr-2"></span><%=job.getDistrict()%></span>
                  <span class="m-2"><span class="icon-clock-o mr-2"></span><%=common.getJobType(job.getType()) %></span>
                </div>
              </div>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-lg-8">
            <div class="mb-5">
                <figure class="mb-5"><img src="<%=job.getImage()%>" alt="Image" class="img-fluid rounded"></figure>
              <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-align-left mr-3"></span>Job Description</h3>
              <p><%=job.getDescription() %></p>
              
            </div>
            <div class="mb-5">
              <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-rocket mr-3"></span>Responsibilities</h3>
              <ul class="list-unstyled m-0 p-0">
                <%=common.getEduorRes(job.getResponsibility1()) %>  
                <%=common.getEduorRes(job.getResponsibility2()) %>  
                <%=common.getEduorRes(job.getResponsibility3()) %>  
                <%=common.getEduorRes(job.getResponsibility4()) %>  
              </ul>
            </div>

            <div class="mb-5">
              <h3 class="h5 d-flex align-items-center mb-4 text-primary"><span class="icon-book mr-3"></span>Education + Experience</h3>
              <ul class="list-unstyled m-0 p-0">
                
                  <%=common.getEduorRes(job.getEduexperience1()) %>
                  <%=common.getEduorRes(job.getEduexperience2()) %>
                  <%=common.getEduorRes(job.getEduexperience3()) %>
                  <%=common.getEduorRes(job.getEduexperience4()) %>                  
                  
              </ul>
            </div>

                  <% UserJobsDao userjobs = new UserJobsDao(); %>
                  <%=common.getApplyBtn(session,job.getJobid()) %>
                  
                  

          </div>
          <div class="col-lg-4">
            <div class="bg-light p-3 border rounded mb-4">
              <h3 class="text-primary  mt-3 h5 pl-3 mb-3 ">Job Summary</h3>
              <ul class="list-unstyled pl-3 mb-0">
                  <li class="mb-2"><strong class="text-black">Published on:</strong> <%=job.getPublisheddate() %></li>
                <li class="mb-2"><strong class="text-black">Vacancy:</strong> <%=job.getVacancy()%></li>
                <li class="mb-2"><strong class="text-black">Employment Status:</strong> <%=job.getType()%></li>
                <li class="mb-2"><strong class="text-black">Job Location:</strong> <%=job.getDistrict() %></li>
                <li class="mb-2"><strong class="text-black">Salary:</strong> <%=job.getSalary() %></li>
                <li class="mb-2"><strong class="text-black">Gender:</strong> <%=job.getGender() %></li>
                <li class="mb-2"><strong class="text-black">Application Deadline:</strong> <%=job.getApplicationdeadline() %></li>
              </ul>
            </div>

            <div class="bg-light p-3 border rounded">
              <h3 class="text-primary  mt-3 h5 pl-3 mb-3 ">Share</h3>
              <div class="px-3">
                <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-facebook"></span></a>
                <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-twitter"></span></a>
                <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-linkedin"></span></a>
                <a href="#" class="pt-3 pb-3 pr-3 pl-0"><span class="icon-pinterest"></span></a>
              </div>
            </div>

          </div>
        </div>
      </div>
    </section>

    <section class="bg-light pt-5 testimony-full">
        
        <div class="owl-carousel single-carousel">

        
          <div class="container">
            <div class="row">
              <div class="col-lg-6 align-self-center text-center text-lg-left">
                <blockquote>
                  <p>&ldquo;Soluta quasi cum delectus eum facilis recusandae nesciunt molestias accusantium libero dolores repellat id in dolorem laborum ad modi qui at quas dolorum voluptatem voluptatum repudiandae.&rdquo;</p>
                  <p><cite> &mdash; Corey Woods, @Dribbble</cite></p>
                </blockquote>
              </div>
              <div class="col-lg-6 align-self-end text-center text-lg-right">
                <img src="images/person_transparent_2.png" alt="Image" class="img-fluid mb-0">
              </div>
            </div>
          </div>

          <div class="container">
            <div class="row">
              <div class="col-lg-6 align-self-center text-center text-lg-left">
                <blockquote>
                  <p>&ldquo;Soluta quasi cum delectus eum facilis recusandae nesciunt molestias accusantium libero dolores repellat id in dolorem laborum ad modi qui at quas dolorum voluptatem voluptatum repudiandae.&rdquo;</p>
                  <p><cite> &mdash; Chris Peters, @Google</cite></p>
                </blockquote>
              </div>
              <div class="col-lg-6 align-self-end text-center text-lg-right">
                <img src="images/person_transparent.png" alt="Image" class="img-fluid mb-0">
              </div>
            </div>
          </div>

      </div>

    </section>

    <section class="pt-5 bg-image overlay-primary fixed overlay" style="background-image: url('images/hero_1.jpg');">
      <div class="container">
        <div class="row">
          <div class="col-md-6 align-self-center text-center text-md-left mb-5 mb-md-0">
            <h2 class="text-white">Get The Mobile Apps</h2>
            <p class="mb-5 lead text-white">Lorem ipsum dolor sit amet consectetur adipisicing elit tempora adipisci impedit.</p>
            <p class="mb-0">
              <a href="#" class="btn btn-dark btn-md px-4 border-width-2"><span class="icon-apple mr-3"></span>App Store</a>
              <a href="#" class="btn btn-dark btn-md px-4 border-width-2"><span class="icon-android mr-3"></span>Play Store</a>
            </p>
          </div>
          <div class="col-md-6 ml-auto align-self-end">
            <img src="images/apps.png" alt="Image" class="img-fluid">
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
    
    <script src="js/bootstrap-select.min.js"></script>
    
    <script src="js/custom.js"></script>

     
  </body>
</html>