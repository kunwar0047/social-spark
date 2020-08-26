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
<title>All Users</title>
<style>body{
    margin-top:20px;
    background:#FAFAFA;    
}
/*==================================================
  Nearby People CSS
  ==================================================*/

.people-nearby .google-maps{
  background: #f8f8f8;
  border-radius: 4px;
  border: 1px solid #f1f2f2;
  padding: 20px;
  margin-bottom: 20px;
}

.people-nearby .google-maps .map{
  height: 300px;
  width: 100%;
  border: none;
}

.people-nearby .nearby-user{
  padding: 20px 0;
  border-top: 1px solid #f1f2f2;
  border-bottom: 1px solid #f1f2f2;
  margin-bottom: 20px;
}

img.profile-photo-lg{
  height: 80px;
  width: 80px;
  border-radius: 50%;
  </style>
<script>
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
<c:if test = "${error.length()>1}">
<div class="alert alert-danger" >${error}</div>
</c:if>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="people-nearby">
              <c:forEach var="objPost" items="${listOfAllFriends}">
              <div class="nearby-user">
                <div class="row">
                  <div class="col-md-2 col-sm-2">
                    <img src="<%=request.getContextPath() %>/userlogo.png" alt="user" class="profile-photo-lg">
                  </div>
                  <div class="col-md-7 col-sm-7">
                    <h2><a href="<%=request.getContextPath()%>/profile?fname=${objPost.username}" class="profile-link">${objPost.username.toUpperCase()}</a></h2>
                  </div>
                  
                  <div class="btn-group">
                  <a href="<%=request.getContextPath()%>/AddFriend?fid=${objPost.username}">                  
                    <button class="btn btn-primary ">Follow</button></a>
                  <a href="<%=request.getContextPath()%>/removeFriend?fid=${objPost.username}">                  
                    <button class="btn btn-danger ">UnFollow</button></a>
                    <a href="<%=request.getContextPath()%>/blockFriend?fid=${objPost.username}">                  
                    <button class="btn btn-warning ">Block</button></a>
                  </div>
                  </div>
                </div>                
              </div>
              </c:forEach>
             </div>
                </div>
              </div>
              
</body>
</html>
