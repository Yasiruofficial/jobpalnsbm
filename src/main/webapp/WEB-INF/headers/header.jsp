<%--
    Document   : header
    Created on : Sep 10, 2020, 7:15:07 AM
    Author     : yasir
--%>

<%@page import="util.common"%>
<%@page import="DAO.UserDao"%>
<%@page import="DAO.CompanyDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    
    <header class="site-navbar mt-3">
      <div class="container-fluid">
        <div class="row align-items-center">
          <div class="site-logo col-6">
              <a href="<%=common.getHome_servlet() %>">JobBoard</a>
          </div>

          <nav class="mx-auto site-navigation">
            <ul class="site-menu js-clone-nav d-none d-xl-block ml-0 pl-0">
              <li>
                <a href="<%=common.getHome_servlet() %>" class="nav-link">Home</a>
              </li>
              <li>
                <a href="<%=common.getAbout_servlet()%>" class="active">About</a>
              </li>
              <li>
                <a href="<%=common.getContact_servlet()%>">Contact</a>
              </li>
              
              <% if(UserDao.isLogged(session) || CompanyDao.isLogged(session)){  %>
              
                <li class="has-children">
                    <a>My Account</a>
                    <ul class="dropdown">
                        <li>
                            <a href="settings">Settings</a>
                        </li>
                        <li>
                            <a href="editcv">Edit CV</a>
                        </li>
                        <li>
                            <a href="<%=common.getLogout_path() +"?logout=1"%>" >Logout</a>
                        </li>
                    </ul>
                </li>
                
              <% } %>
              
              <% if(CompanyDao.isLogged(session)){  %>
              
              <li class="d-lg-none">
                <a href="<%=common.getPost_job_servlet() %>">
                  <span class="mr-2">+</span>
                  Post a Job</a>
              </li>
              
              <% } %>
              
              <% if(!( UserDao.isLogged(session) || CompanyDao.isLogged(session) ) ){  %>
              
              <li class="d-lg-none">
                <a href="<%=common.getLogin_servlet()%>">Log In</a>
              </li>
              
              <% } %>
              
              
            </ul>
          </nav>

          <div class="right-cta-menu text-right d-flex aligin-items-center col-6">
            <div class="ml-auto">
                
              <% if(CompanyDao.isLogged(session)){  %>
              
              <a href="<%=common.getPost_job_servlet() %>" class="btn btn-outline-white border-width-2 d-none d-lg-inline-block">
                <span class="mr-2 icon-add"></span>Post a Job</a>
                
              <% }  %>
              
              <% if(!( UserDao.isLogged(session) || CompanyDao.isLogged(session) ) ){  %>
              
              <a href="<%=common.getLogin_servlet()%>" class="btn btn-primary border-width-2 d-none d-lg-inline-block">
                <span class="mr-2 icon-lock_outline"></span>Log In</a>
                
              <% } %>
            </div>
            <a href="#" class="site-menu-toggle js-menu-toggle d-inline-block d-xl-none mt-lg-2 ml-3">
              <span class="icon-menu h3 m-0 p-0 mt-2"></span>
            </a>
          </div>

        </div>
      </div>
    </header>
            
    <section class="section-hero home-section overlay inner-page bg-image" style="background-image: url('images/hero_1.jpg');" id="home-section">

      <div class="container">
        <div class="row align-items-center justify-content-center">
          <div class="col-md-12">
            <div class="mb-5 text-center">
              <h1 class="text-white font-weight-bold">The Easiest Way To Get Your Dream Job</h1>
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Cupiditate, quas fugit ex!</p>
            </div>
            <form method="get" class="search-jobs-form" action="<%=common.getJob_listing_servlet()%>">
              <div class="row mb-5">
                  
                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                    <select class="selectpicker" data-style="btn-white btn-lg" data-width="100%" data-size="5" data-live-search="true" title="Select Category" name="category">
                        
                        <%=common.getCatList() %>
                        
                  </select>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                  <select class="selectpicker" data-style="btn-white btn-lg" data-width="100%" data-size="5" data-live-search="true" title="Select Region" name="district">
                    
                      <%=common.getDisList() %>
                      
                  </select>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                  <select class="selectpicker" data-style="btn-white btn-lg" data-width="100%" data-size="5" data-live-search="true" title="Select Job Type" name="type">
                    <option>Part Time</option>
                    <option>Full Time</option>
                  </select>
                </div>
                <div class="col-12 col-sm-6 col-md-6 col-lg-3 mb-4 mb-lg-0">
                  <button type="submit" class="btn btn-primary btn-lg btn-block text-white btn-search"><span class="icon-search icon mr-2"></span>Search Job</button>
                </div>
              </div>
            </form>
          </div>
        </div>
      </div>

      <a href="#next" class="scroll-button smoothscroll">
        <span class=" icon-keyboard_arrow_down"></span>
      </a>
    </section>
                      