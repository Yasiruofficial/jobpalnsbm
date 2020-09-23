<%-- 
    Document   : admin
    Created on : Sep 15, 2020, 10:04:25 PM
    Author     : yasir
--%>
<%@page import="Bean.UserBean"%>
<%@page import="DAO.JobDao"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%

    HashMap< Integer , ArrayList<UserBean>> dashboard = (HashMap< Integer , ArrayList<UserBean>>)request.getAttribute("dashboard");
    int jobslength = dashboard.size();
    
    ArrayList<Integer> intKeys = new ArrayList<>(dashboard.keySet());
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/headers/header.jsp"/>
    <br>
    <br>
    <hr>
   <div class="container">
    <div class="row">
      <div class="col-md-12">
        <div class="panel panel-primary">
          <div class="panel-heading">
            <span class="glyphicon glyphicon-user"></span>Sortable Lists
          </div>
          <div class="panel-body">
            <ul class="list-group">
                
                
        <% 
            JobDao jobdao = new JobDao();
            
            int i = 0;
            while(i < jobslength) 
            {     
        %>
                    
              <li class="list-group-item">
                  <%=jobdao.findName(intKeys.get(i)) %>
                <div class="pull-right action-buttons">
                    <a ><span class="glyphicon glyphicon-eye-open" data-toggle="modal" data-target="#basicExampleModal<%=i %>"></span></a>
                  <a class="trash"><span class="glyphicon glyphicon-trash"></span></a>
                </div>
              </li>
              
              <% ArrayList<UserBean> users = dashboard.get(intKeys.get(i));%>
              <!-- Modal -->
              <div class="modal fade" id="basicExampleModal<%=i %>" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
                aria-hidden="true">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-header">
                      <h4 class="modal-title" id="exampleModalLabel">Applied Candidates</h4>
                      <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </div>
                    <div class="modal-body">
                      <ol>
                       <% 
                       int j = 0;
                       while(j < users.size())
                       { 
                          UserBean user = users.get(j);
                          String fname = user.getFname().toUpperCase();
                          String lname = user.getLname().toUpperCase();
                          String email = user.getEmail().toLowerCase();
                       %>
                       
                       <a href="profile?userid=<%=user.getId() %>"><li><%=fname + " " + lname + " : " + email %></li></a>
                          
                       <% 
                           j++ ; 
                        } 
                       %>
                      </ol>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                      <button type="button" class="btn btn-primary">Save changes</button>
                    </div>
                  </div>
                </div>
              </div>

        <% 
                i++; 
            }

        %>
            </ul>
          </div>
          <div class="panel-footer">
            <div class="row">
              <div class="col-md-6">
                <h6>
                  Total Count <span class="label label-info">25</span></h6>
              </div>
              <div class="col-md-6">
                <ul class="pagination pagination-sm pull-right">
                  <li class="disabled"><a href="javascript:void(0)">«</a></li>
                  <li class="active"><a href="javascript:void(0)">1 <span class="sr-only">(current)</span></a></li>
                  <li><a href="http://www.jquery2dotnet.com">2</a></li>
                  <li><a href="http://www.jquery2dotnet.com">3</a></li>
                  <li><a href="http://www.jquery2dotnet.com">4</a></li>
                  <li><a href="http://www.jquery2dotnet.com">5</a></li>
                  <li><a href="javascript:void(0)">»</a></li>
                </ul>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
    
    <jsp:include page="/WEB-INF/headers/footer.jsp"/>
        
    <!-- SCRIPTS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    
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
