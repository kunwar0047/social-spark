<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.io.PrintWriter"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

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
<meta charset="ISO-8859-1">
<title>HomeFeed</title>
<script>
function submitForm()
{
   document.getElementById("form").submit();
}
window.onload=submitForm;
</script>
   <% String name="";
					    if(session.getAttribute("username") != null) {
					    name = (String)session.getAttribute("username");
					    name=name.toUpperCase();
					} else {
					    response.sendRedirect(request.getContextPath()+"/login");
					}%>
</head>
<body>
<%@ include file="/WEB-INF/navbar.jsp" %>
        <div style="padding-top:50px;">&nbsp;
        </div>
        <c:if test = "${msg.length()>1}">
<div class="alert alert-success" >${msg}</div>
</c:if>
        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <span>
             
                    <h1 class="panel-title pull-left" style="font-size:30px;">Settings </h1>
                    </div>
                </span>

            </div>
        
        <hr>

        <div class="panel panel-default">
            <div class="panel-body">
            <form action="<%= request.getContextPath()%>/passwordchanger" METHOD="post">
                 
                <div class="form-group" >
                <label for="body" class="text-info">Change Password:</label><br>
                  <input type="password" class="form-control" name="password" >
                </div>
                 <button type="submit" class="btn btn-primary">Update Password</button>
              </form>
              <br/>

            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-body">
            <a href="<%=request.getContextPath()%>/deleteAccount">
            <button type="button" class="btn btn-primary">Delete Account</button></a>
              <br/>

            </div>
        </div>



                </div>

</body>
</html>
