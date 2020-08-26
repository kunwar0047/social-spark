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
<link href="<%= request.getContextPath() %>/WEB-INF/css/chat.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
<title>Chat</title>
<style>
body {
	background: #E5DDD5 ;
}
.page-header {
	background: #006A4E;
	margin: 0;
  padding: 16px 0 16px;
	color: #FFFFFF;
	position: fixed;
	width: 100%;
  z-index: 1
}
.main {
	height: 100vh;
	padding-top: 70px;
}

.chat-log {
	padding: 40px 0 114px;
	height: auto;
	overflow: auto;
}
.chat-log__item {
	background: #fafafa;
	padding: 10px;
	margin: 0 auto 20px;
	max-width: 80%;
	float: left;
	border-radius: 4px;
	box-shadow: 0 1px 2px rgba(0,0,0,.1);
	clear: both;
}

.chat-log__item.chat-log__item--own {
	float: right;
	background: #DCF8C6;
	text-align: right;
}

.chat-form {
	background: #DDDDDD;
	padding: 5px ;
	position: fixed;
	bottom: 0;
	width: 100%;
}

.chat-log__author {
	margin: 0 auto .5em;
	font-size: 14px;
	font-weight: bold;
}
.profile-link{
color:white;}
.profile-link:hover{
color:white;}
h1, .h1, h2, .h2, h3, .h3 {
    margin-top: -0px !important;
    margin-bottom: 10px;
}
</style>
<script> 
        $(document).ready(function() { 
           
                $(document).scrollTop($(document).height()); 
             
        }); 
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
<header class="page-header">
  <div class="container ">
    <h2><a href="<%=request.getContextPath()%>/profile?fname=${receiver}" class="profile-link">${receiver.toUpperCase()} </a></h2>
  </div>
</header>
<div class="main">
  <div class="container ">
    <div class="chat-log">
 <c:forEach var="obj" items="${chatlist}">   

      
      <div class="chat-log__item">
        <h3 class="chat-log__author">${obj.sender.toUpperCase()}</h3>
        <div class="chat-log__message">${obj.message}</div>
      </div>
      
      
      

     </c:forEach>
    </div>
  </div>
  <div class="chat-form">
    <div class="container ">
      <form class="form-horizontal" action="<%= request.getContextPath()%>/message" METHOD="post">
        <div class="row">
          <div class="col-sm-10 col-xs-8">
          <input type="text" class="form-control" name="receiver"  value="${receiver}" style="display:none;"/>
            <input type="text" class="form-control" name="message"  />
          </div>
          <div class="col-sm-2 col-xs-4">
            <button type="submit" class="btn btn-success btn-block">Send</button>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>