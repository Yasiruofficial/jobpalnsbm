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

    <section class="site-section">
      <div class="container">
        <div class="row">
          <div class="col-lg-6">
            <h2 class="mb-4">Log In To JobBoard</h2>
            
            <%
                if(session.getAttribute("Login") != null){
                    if(session.getAttribute("Login") == "Invalid Username / Password"){
                        out.print("<span style='color:red;'>Invalid Username / Password</span>");
                        session.removeAttribute("Login");
                    }
                }
            
            %>
            <form action="login" class="p-4 border rounded" method="post">

              <div class="row form-group">
                <div class="col-md-12 mb-3 mb-md-0">
                  <label class="text-black" for="email">Email</label>
                  <input type="email" name="email" class="form-control" placeholder="Email address">
                </div>
              </div>
              <div class="row form-group mb-4">
                <div class="col-md-12 mb-3 mb-md-0">
                  <label class="text-black" for="password">Password</label>
                  <input type="password" name="password" class="form-control" placeholder="Password">
                </div>
              </div>

              <div class="row form-group">
                <div class="col-md-12">
                  <input type="submit" value="LogIn" name="Login" class="btn px-4 btn-primary text-white">
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



</body>

</html>
