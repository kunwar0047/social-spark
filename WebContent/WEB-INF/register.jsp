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
                        <form id="registration-form" class="form"  action="<%= request.getContextPath() %>/register" method="post">
                          <h3 class="text-center text-info">Registration Form</h3>
                          <div class="form-group">
                              <label for="username" class="text-info">First name</label><br>
                              <input type="text" name="firstName" id="firstName" class="form-control">
                          </div>
                          <div class="form-group">
                              <label for="username" class="text-info">Last Name</label><br>
                              <input type="text" name="lastName" id="lastName" class="form-control">
                          </div>
                          <div class="form-group">
                              <label for="username" class="text-info">Username</label><br>
                              <input type="text" name="username" id="username" class="form-control">
                          </div>
                          <div class="form-group">
                              <label for="password" class="text-info">Password</label><br>
                              <input type="text" name="password" id="password" class="form-control">
                          </div>
                          <div class="form-group">
                              <label for="username" class="text-info">Address</label><br>
                              <input type="text" name="address" id="address" class="form-control">
                          </div>
                          <div class="form-group">
                              <label for="username" class="text-info">Contact No</label><br>
                              <input type="text" name="contact" id="contact" class="form-control">
                          </div>
                            <center><input type="submit" name="submit" class="btn btn-info btn-md" value="submit"></center>
                      </form>
                      </div>
                  </div>
                  <div class="col-lg-3 col-md-2"></div>
              </div>
          </div>





</body>
</html>
