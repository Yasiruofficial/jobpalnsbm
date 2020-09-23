<%@page import="Bean.UserBean"%>
<!doctype html>
<%
    UserBean UB = (UserBean)request.getAttribute("userbean");
%>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="icon" href="/profile/img/favicon.png" type="image/png">
        <title>MeetMe Personal</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="/profile/css/bootstrap.css">
        <link rel="stylesheet" href="/profile/vendors/linericon/style.css">
        <link rel="stylesheet" href="/profile/css/font-awesome.min.css">
        <link rel="stylesheet" href="/profile/vendors/owl-carousel/owl.carousel.min.css">
        <link rel="stylesheet" href="/profile/vendors/lightbox/simpleLightbox.css">
        <link rel="stylesheet" href="/profile/vendors/nice-select//profile/css/nice-select.css">
        <link rel="stylesheet" href="/profile/vendors/animate-/profile/css/animate.css">
        <link rel="stylesheet" href="/profile/vendors/popup/magnific-popup.css">
        <link rel="stylesheet" href="/profile/vendors/flaticon/flaticon.css">
        <!-- main css -->
        <link rel="stylesheet" href="/profile/css/style.css">
        <link rel="stylesheet" href="/profile/css/responsive.css">
        
            
    
    <link rel="stylesheet" href="css/custom-bs.css">
    <link rel="stylesheet" href="css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="css/bootstrap-select.min.css">
    <link rel="stylesheet" href="fonts/icomoon/style.css">
    <link rel="stylesheet" href="fonts/line-icons/style.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/animate.min.css">

    <!-- MAIN CSS -->
    <link rel="stylesheet" href="css/style.css">   
    
      <link rel="stylesheet" href="css/style.css">
      <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
      <script src="js/imageViewOnUpload.js"></script>
    
    </head>
    <body>

       <jsp:include page="/WEB-INF/headers/header.jsp"/>
       
        <!--================Home Banner Area =================-->
        <section class="home_banner_area">
           	<div class="container box_1620">
           		<div class="banner_inner d-flex align-items-center">
					<div class="banner_content">
						<div class="media">
							<div class="d-flex">
                                                            <img src="<%=UB.getPhoto() %>" width="500" height="500" alt="">
							</div>
							<div class="media-body">
								<div class="personal_text">
									<h6>Hello Everybody, i am</h6>
									<h3> <%=UB.getFname().toUpperCase() + " " + UB.getLname().toUpperCase() %></h3>
									<h4>Junior UI/UX Developer</h4>
									<p>You will begin to realise why this exercise is called the Dickens Pattern (with reference to the ghost showing Scrooge some different futures)</p>
									<ul class="list basic_info">
										<li><i class="lnr lnr-calendar-full"></i> <%=UB.getBday() %></li>
										<li><i class="lnr lnr-phone-handset"></i> <%=UB.getMnumber() %></li>
										<li><i class="lnr lnr-envelope"></i> <%=UB.getEmail() %></li>
										<li><i class="lnr lnr-home"></i> <%=UB.getAddress() %></li>
                                                                                <li><i class="lnr lnr-user"></i> <%=UB.getGender() %></li>
                                                         
									</ul>
									<ul class="list personal_social">
										<li><a href="#"><i class="fa fa-facebook"></i></a></li>
										<li><a href="#"><i class="fa fa-twitter"></i></a></li>
										<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
									</ul>
								</div>
							</div>
						</div>
					</div>
				</div>
            </div>
        </section>
        <!--================End Home Banner Area =================-->
       

        <jsp:include page="/WEB-INF/headers/footer.jsp"/>
        
        
        
        
        
        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="/profile/js/jquery-3.3.1.min.js"></script>
        <script src="/profile/js/popper.js"></script>
        <script src="/profile/js/bootstrap.min.js"></script>
        <script src="/profile/js/stellar.js"></script>
        <script src="/profile/vendors/lightbox/simpleLightbox.min.js"></script>
        <script src="/profile/vendors/nice-select//profile/js/jquery.nice-select.min.js"></script>
        <script src="/profile/vendors/isotope/imagesloaded.pkgd.min.js"></script>
        <script src="/profile/vendors/isotope/isotope.pkgd.min.js"></script>
        <script src="/profile/vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="/profile/vendors/popup/jquery.magnific-popup.min.js"></script>
        <script src="/profile/js/jquery.ajaxchimp.min.js"></script>
        <script src="/profile/vendors/counter-up/jquery.waypoints.min.js"></script>
        <script src="/profile/vendors/counter-up/jquery.counterup.min.js"></script>
        <script src="/profile/js/mail-script.js"></script>
        <script src="/profile/js/theme.js"></script>
        
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