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
<title>Edit Post</title>
</head>
<body>
<%@ include file="/WEB-INF/navbar.jsp" %>
        <div style="padding-top:50px;">&nbsp;
        </div>

        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <span>
             
                    <h1 class="panel-title pull-left" style="font-size:30px;">Edit Post </h1>
                    </div>
                </span>

            </div>
        
        <hr>

<%String pbody,ptitle;
	int pid;
	ptitle=request.getParameter("title");
	pbody=request.getParameter("body");
	String num = request.getParameter("id");
	pid=Integer.parseInt(num);
%>
<div class="panel panel-default">
            <div class="panel-body">
            <form action="EditPost" METHOD="post">
                 <div class="form-group" >
                 <label for="title" class="text-info">Post Title:</label><br>
                 <input type="text" class="form-control" name="pid" style="display: none !important;" value=<%=pid %>>
                  <input type="text" class="form-control" name="ptitle" value=<%=ptitle %>>
                </div>
                <div class="form-group" >
                <label for="body" class="text-info">Post Body:</label><br>
                  <input type="text" class="form-control" name="pbody" height="30px" value=<%=pbody %>>
                </div>
                 <button type="submit" class="btn btn-primary">Update Post</button>
              </form>
              <br/>

            </div>
        </div>
</div>
</body>
</html>
