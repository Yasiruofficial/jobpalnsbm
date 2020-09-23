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
         </div>
         <!-- .site-mobile-menu -->
         <!-- NAVBAR -->
         <jsp:include page="/WEB-INF/headers/header.jsp"/>
         
         <section class="site-section">
            <div class="container">
               <div class="row">
                  <div class="col-lg-6 mb-5">
                     <h2 class="mb-4">Sign Up To JobBoard</h2>

                     <%
                         if(session.getAttribute("Register") != null){
                             if(session.getAttribute("Register").equals("Register Success")){
                                 out.print("<span style='color:green;'>Register Successful</span>");
                             }
                             else if(session.getAttribute("Register").equals("Register Fail")){               
                                 out.print("<span style='color:red;'>Register Fail</span>");
                             }
                             else if(session.getAttribute("Register").equals("Register Exeption")){            
                                 out.print("<span style='color:red;'>Register Exeption</span>");
                             }
                             else if(session.getAttribute("Register").equals("Account already Exist")){            
                                 out.print("<span style='color:red;'>Account already Exist</span>");
                             }
                             
                             session.removeAttribute("Register");
                         }
                         

                     %>
                     <form action="register" class="p-4 border rounded" method="post">
                        <div class="row form-group">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="iscompany">Select The type</label>
                              <br> User <input type="radio" id="iscompany" name="iscompany" class="iscompany"  value="false" checked="true">
                              Company <input type="radio" id="iscompany" name="iscompany" class="iscompany"  value="true"><br>
                           </div>
                        </div>
                        <div class="row form-group">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="email">Email</label>
                              <input type="email" name="email" id="email" class="form-control" placeholder="Email address" required="" >
                           </div>
                        </div>
                        <div class="row form-group">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="password">Password</label>
                              <input type="password" name="password" id="password" class="form-control" placeholder="Password" required="" >
                           </div>
                        </div>
                        <div class="row form-group">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="rpassword">Re-type Password</label>
                              <input type="password" name="rpassword" id="rpassword" class="form-control" placeholder="Re-type Password" required="" >
                           </div>
                        </div>
                        <div class="row form-group user">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="fname">First Name</label>
                              <input type="text" name="fname" id="fname" class="form-control" placeholder="First Name" >
                           </div>
                        </div>
                        <div class="row form-group user">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="lname">Last Name</label>
                              <input type="text" name="lname" id="lname" class="form-control" placeholder="Last Name" >
                           </div>
                        </div>
                        <div class="row form-group company">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="lname">Company Name</label>
                              <input type="text" name="name" id="name" class="form-control" placeholder="Company Name" >
                           </div>
                        </div>
                        <div class="row form-group">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="address">Address</label>
                              <textarea type="text" name="address" id="address" class="form-control" placeholder="Home Address" style="min-height:100px;max-height:100px;" required=""></textarea>
                           </div>
                        </div>
                        <div class="row form-group">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="mnumber">Mobile Number</label>
                              <input type="text" id="mnumber" name="mnumber" class="form-control" placeholder="Mobile Number" required="">
                           </div>
                        </div>
                        <div class="row form-group mb-4 user">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="gender">Gender</label>
                              <select class="form-control " id="gender" name="gender" >
                                 <option>Male</option>
                                 <option>FeMale</option>
                              </select>
                           </div>
                        </div>
                        <div class="row form-group user">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="bday">Birthday</label>
                              <input type="date" id="bday" name="bday" class="form-control" >
                           </div>
                        </div>
                        <div class="row form-group user">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <label class="text-black" for="exyears">Experience Years</label>
                              <input type="number" id="exyears" name="exyears" class="form-control" placeholder="Experience Years" >
                           </div>
                        </div>
                        <!-- checkboxes -->
                        <div class="row form-group user">
                           <div class="col-md-12 mb-3 mb-md-0">
                              <table cellpadding="10">
                                 <label class="text-black" for="job">Education</label>
                                 <tr>
                                    <td><label class="text-black" for="experience">Ordinary Level</label></td>
                                    <td><input type="checkbox" name="experience" id="experience" value="Ordinary Level"></td>
                                 </tr>
                                 <tr>
                                    <td><label class="text-black" for="experience">Advanced Level</label></td>
                                    <td><input type="checkbox" name="experience" id="experience" value="Advanced Level"></td>
                                 </tr>
                                 <tr>
                                    <td><label class="text-black" for="experience">Diploma</label></td>
                                    <td><input type="checkbox" name="experience" id="experience" value="Diploma"></td>
                                 </tr>
                                 <tr>
                                    <td><label class="text-black" for="experience">Degree</label></td>
                                    <td><input type="checkbox" name="experience" id="experience" value="Degree"></td>
                                 </tr>
                              </table>
                           </div>
                        </div>
                        <!-- checkboxes -->
                        <div class="row form-group">
                           <div class="col-md-12">
                              <input type="submit" value="SignUp" name="Signup" class="btn px-4 btn-primary text-white">
                           </div>
                        </div>
                     </form>
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
      <script src="js/common.js"></script>
   </body>
</html>