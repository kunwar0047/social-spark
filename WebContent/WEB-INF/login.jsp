<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style><%@include file="/WEB-INF/css/login.css"%></style>
<style>

</style>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

      <div class="container">
          <div class="row">
              <div class="col-lg-3 col-md-2"></div>
              <div class="col-lg-6 col-md-8 login-box">
                  <div class="col-lg-12 login-title">
                      Social Spark
                  </div>

                  <div class="col-lg-12 login-form">
                      <div class="col-lg-12 login-form">
                          <form class="form"  action="<%= request.getContextPath() %>/login" method="post">
                              <div class="form-group">
                                  <label class="form-control-label">USERNAME</label>
                                  <input name="username" type="text" class="form-control">
                              </div>
                              <div class="form-group">
                                  <label class="form-control-label">PASSWORD</label>
                                  <input  name="password" type="password" class="form-control" i>
                              </div>

                              <div class="col-lg-12 loginbttm">
                                  <div class="col-lg-6 login-btm login-text">
                                      <a href="<%=request.getContextPath()%>/register">Register Here</a>
                                  </div>
                                  <div class="col-lg-6 login-btm login-button">
                                      <button type="submit" class="btn btn-outline-primary">LOGIN</button>
                                  </div>
                              </div>
                          </form>
                      </div>
                  </div>
                  <div class="col-lg-3 col-md-2"></div>
              </div>
          </div>





</body>
</html>
