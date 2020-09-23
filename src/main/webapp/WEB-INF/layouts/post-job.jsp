<%@page import="util.common"%>
<%@page import="DAO.JobDao"%>
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
      <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
      <script src="js/imageViewOnUpload.js"></script>
      <style>
         #previewImg1,
         #previewImg2 {
         width: 150px;
         height: 150px;
         border: 2px solid #89ba16;
         }
      </style>
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
         </div>
      </div>
      <!-- .site-mobile-menu -->
      <!-- NAVBAR -->
      <jsp:include page="/WEB-INF/headers/header.jsp"/>

      <section class="site-section">
         <div class="container">
                    <%
            if(session.getAttribute("postJob") != null){

                if(session.getAttribute("postJob").equals("1")){
                    out.print("<span style='color:green;'>Job Post Successful</span>");
                }
                else{
                    out.print("<span style='color:red;'>Job Post Error</span>");
                }         
                             
            session.removeAttribute("postJob");
            }
        %>
            <form class="p-4 p-md-5 border rounded" method="post" action="postJob"/>
               <h3 class="text-black mb-5 border-bottom pb-2">Job Details</h3>
               <div class="row align-items-center mb-5">
                  <div class="col-lg-8 mb-4 mb-lg-0">
                     <div class="d-flex align-items-center">
                        <div>
                           <h2>Post A Job</h2>
                        </div>
                     </div>
                  </div>
               </div>
               <div class="form-group">
                  <label for="category">Job Category</label>
                  <select class="selectpicker border rounded" data-size="5" id="category" data-style="btn-black" data-width="100%" data-live-search="true" title="Select Category" name="category" required="" >
                  
                      <%=common.getCatList() %>
                      
                  </select>
               </div>
               <div class="form-group">
                  <label for="name">Job Title</label>
                  <input type="text" class="form-control" name="name" id="name" placeholder="Account Assistant" required=""/>
               </div>
                  
               <div class="form-group">
                  <label for="type">Job Type</label>
                  <select class="selectpicker border rounded" data-size="5" id="type" data-style="btn-black" data-width="100%" data-live-search="true" title="Select Type" name="type" required="" >              
                      <option>Part Time</option>
                      <option>Full Time</option>
                  </select>
               </div>
                  
               <div class="form-group">
                  <label for="job-description">Job Description</label>
                  <textarea name="description" class="form-control" id="description" required=""></textarea>
               </div>
                  
                <div class="form-group">
                  <label for="salary">Salary (Sri-lankan Rupee)</label>
                  <input type="number" class="form-control" name="salary" id="salary" placeholder="50000" required=""/>
               </div>  
                  
               <div class="form-group">
                  <label for="gender">Accept Gender</label>
                  <select class="selectpicker border rounded" id="gender" data-style="btn-black" data-width="100%" data-live-search="true" title="Select Gender" name="gender" required="">
                     <option>Male</option>
                     <option>FeMale</option>
                     <option>Any</option>
                  </select>
               </div>
                  
               <div class="form-group">
                  <label for="vacancy">Number Of Vacancy</label>
                  <input type="number" class="form-control" name="vacancy" id="vacancy" placeholder="1" required=""/>
               </div>

               <div class="form-group">
                  <label for="street">Street - Address</label>
                  <input type="text" class="form-control" name="street" id="street" placeholder="XX/XX XXXX" required=""/>
               </div>
                  
               <div class="form-group">
                  <label for="district">District - Address</label>
                  <select class="selectpicker border rounded" data-size="5" id="district" data-style="btn-black" data-width="100%" data-live-search="true" title="Select District" name="district" required="">
                     
                      <%=common.getDisList()%>
                     
                  </select>
               </div>
               <div class="form-group">
                  <label for="publisheddate">Published Date</label>
                  <input type="date" class="form-control" name="publisheddate" id="publisheddate" required=""/>
               </div>
               <div class="form-group">
                  <label for="applicationdeadline">Application Deadline</label>
                  <input type="date" class="form-control" name="applicationdeadline" id="applicationdeadline" required=""/>
               </div>
               <br>
               <label for="responsibility1">RESPONSIBILITIES</label>
               <hr>
               <div class="form-group">
                  <input type="text" class="form-control" name="responsibility1" id="responsibility1" placeholder="Responsibility 1" required=""/>
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" name="responsibility2" id="responsibility2" placeholder="Responsibility 2" required=""/>
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" name="responsibility3" id="responsibility3" placeholder="Responsibility 3" required=""/>
               </div>
               <div class="form-group">
                  <input type="text" class="form-control" name="responsibility4" id="responsibility4" placeholder="Responsibility 4" required=""/>
               </div>
               <br>
               <label for="responsibility1">EDUCATION</label>
               <hr>
               <div class="form-check">
                  <input class="form-check-input" type="checkbox" name="eduexperience1" value="Ordinary Level" id="eduexperience1"/>
                  <label class="form-check-label" for="eduexperience1">
                  Ordinary Level
                  </label>
               </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" name="eduexperience2" value="Advance Level" id="eduexperience2" />
                  <label class="form-check-label" for="eduexperience2">
                  Advance Level
                  </label>
               </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" name="eduexperience3" value="Diploma" id="eduexperience3" />
                  <label class="form-check-label" for="eduexperience3">
                  Diploma
                  </label>
               </div>
                <div class="form-check">
                  <input class="form-check-input" type="checkbox" name="eduexperience4" value="Degree" id="eduexperience4"/>
                  <label class="form-check-label" for="eduexperience4">
                  Degree
                  </label>
               </div>
               <div class="row">
                  <div class="col-12">
                     <input type="submit" name="submit" class="btn btn-block btn-primary btn-md" value="SAVE"/>
                  </div>
               </div>
            </form>
         </div>
      </section>
                      
    <jsp:include page="/WEB-INF/headers/footer.jsp"/>
    
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
