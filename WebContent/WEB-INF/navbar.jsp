<%@page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
  <script src="https://code.jquery.com/jquery-1.11.1.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="https://bootswatch.com/cosmo/bootstrap.min.css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
.mainbody {
    background:#f0f0f0;
}
/* Special class on .container surrounding .navbar, used for positioning it into place. */
.navbar-wrapper {
  position: fixed;
  top: 0;
  left: 0;
  right: 0;
  z-index: 20;
  margin-left: -15px;
  margin-right: -15px;
}

/* Flip around the padding for proper display in narrow viewports */
.navbar-wrapper .container {
  padding-left: 0;
  padding-right: 0;
}
.navbar-wrapper .navbar {
  padding-left: 15px;
  padding-right: 15px;
}

.navbar-content
{
    width:320px;
    padding: 15px;
    padding-bottom:0px;
}
.navbar-content:before, .navbar-content:after
{
    display: table;
    content: "";
    line-height: 0;
}
.navbar-nav.navbar-right:last-child {
    margin-right: 15px !important;
}
.navbar-footer
{
    background-color:#DDD;
}
.navbar-footer-content { padding:15px 15px 15px 15px; }
.dropdown-menu {
padding: 0px;
overflow: hidden;
}

.brand_network {
    color: #9D9D9D;
    float: left;
    position: absolute;
    left: 70px;
    top: 30px;
    font-size: smaller;
}

.post-content {
    margin-left:58px;
}

.badge-important {
    margin-top: 3px;
    margin-left: 25px;
    position: absolute;
}
a.navbar-brand {
    font-size: 30px;
    padding-top: 20px;
    color: black ! important;
}
body {
    background-color: #e8e8e8;
}
</style>
<meta charset="ISO-8859-1">
<body>
  <div class="mainbody container-fluid">
    <div class="row">
        <div class="navbar-wrapper">
            <div class="container-fluid">
                <div class="navbar navbar-default navbar-static-top" role="navigation">
                    <div class="container-fluid">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                                <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span><span
                                    class="icon-bar"></span><span class="icon-bar"></span>
                            </button>
                            <a class="navbar-brand" href="<%= request.getContextPath() %>/showposts.jsp" style="margin-right:-8px; margin-top:-5px;">
                                Social Spark
                            </a>

                        </div>
                        <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav navbar-right">
                                <li><a href="<%= request.getContextPath() %>/showposts.jsp">Home</a></li>
                                <li><a href="<%= request.getContextPath() %>/home">My Profile</a></li>
                                <li><a href="<%= request.getContextPath() %>/AllUsers">Search</a></li>
                                <li><a href="<%= request.getContextPath() %>/settings.jsp">Settings</a></li>
                                <li><a href="<%= request.getContextPath() %>/logout">LogOut</a></li>
                                <li><a href="<%= request.getContextPath() %>/notifications"><i class="fa fa-bell-o fa-lg" aria-hidden="true"></i></a></li>
                                                                
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
           </div>
        </div>
</body>
</html>