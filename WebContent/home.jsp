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
        <div class="col-lg-3 col-md-3 hidden-sm hidden-xs">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="media">
						
                        <div class="media-body">
                            <hr>
                            <h3><strong>Friends Chat List</strong></h3>
                            <c:forEach var="objf" items="${listOfFriends}">
                            <a href="<%= request.getContextPath() %>/message?receiver=${objf.username}&sender=<%=name%>"><p>${objf.username.toUpperCase()}</p></a>                            
                            <hr>
                            </c:forEach>
                        </div>
                        
                    </div>
                </div>
            </div>
        </div>
        <div class="col-lg-9 col-md-9 col-sm-12 col-xs-12">
        <div class="panel panel-default">
            <div class="panel-body">
                <span>
             
                    <h1 class="panel-title pull-left" style="font-size:30px;">Welcome <%= name %> </h1>
                    </div>
                </span>

            </div>
        
        <hr>

        <div class="panel panel-default">
            <div class="panel-body">
            <form action="<%= request.getContextPath()%>/PostServlet" METHOD="post">
                 <div class="form-group" >
                 <label for="title" class="text-info">Post Title:</label><br>
                  <input type="text" class="form-control" name="ptitle" >
                </div>
                <div class="form-group" >
                <label for="body" class="text-info">Post Body:</label><br>
                  <input type="text" class="form-control" name="pbody" >
                </div>
                 <button type="submit" class="btn btn-primary">Post</button>
              </form>
              <br/>

            </div>
        </div>
            <!-- Simple post content example. -->
            <c:forEach var="objPost" items="${listOfAllPosts}">
            <div class="panel panel-default">
                <div class="panel-body">

                    <h4><a href="#" style="text-decoration:none;"><strong>${objPost.ptitle.toUpperCase() }</strong></a> <small><small><a href="#" style="text-decoration:none; color:grey;"></a></small></small></h4>
                    <hr>                    
                    <div class="post-content">
                        <p>${objPost.pbody }</p>

                    </div>
                    <hr>
                    <div>
                      <div class="pull-left btn-group-xs">
                          <a class="btn btn-default btn-xs" href="<%= request.getContextPath() %>/likepost?likeid=${objPost.pid}" ><i class="fa fa-heart" ></i> ${objPost.plikes } Likes</a>
                          <a class="btn btn-default btn-xs" href="<%= request.getContextPath() %>/editpost.jsp?id=${objPost.pid}&title=${objPost.ptitle }&body=${objPost.pbody }">Edit</a>
                          <a class="btn btn-default btn-xs" href="<%= request.getContextPath() %>/deletepost.jsp?id=${objPost.pid}">Delete</a>  
                          <a class="btn btn-default btn-xs" >Posted By- ${objPost.uname }</a>
                      </div>
                        <br>
                    </div>

                </div>
            </div>
            </c:forEach>



                </div>

</body>
</html>
