<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logged Out</title>
</head>
<body>
<%

            session.invalidate();

        %>
<h1><font color="Red">You are Sucessfully logged out...</font></h1>
        <a href="home.jsp">Go-Back To Home Page</a>
</body>
</html>