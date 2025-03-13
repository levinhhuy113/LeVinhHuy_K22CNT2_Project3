
<!--Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html lang="en">
<head>
<title>Clean Login Form a Flat Responsive Widget Template :: w3layouts</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Clean Login Form Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design" />

<!-- css files -->
<link href="web/css/font-awesome.min.css" rel="stylesheet" type="text/css" media="all">
<link href="web/css/style.css" rel="stylesheet" type="text/css" media="all" />
<!-- /css files -->

<!-- online fonts -->
<link href="//fonts.googleapis.com/css?family=Sirin+Stencil" rel="stylesheet">
<!-- online fonts -->

<body>
<div class="container demo-1">
	<div class="content">
        <div id="large-header" class="large-header">
			<h1>Clean Login Form</h1>
				<div class="main-agileits">
				<!--form-stars-here-->
						<div class="form-w3-agile">
							<h2>login Now</h2>
							<% String errorMessage = (String) request.getAttribute("errorMessage"); %>
								<% if (errorMessage != null) { %>
								    <div style="color: red; text-align: center; margin-bottom: 10px;">
								        <%= errorMessage %>
								    </div>
								<% } %>
							
							<h2 style="color: #2c3e50; text-align: center; font-size: 26px; margin-bottom: 15px;">Đăng ký tài khoản</h2>

<% String message = (String) request.getAttribute("message"); %>
<% if (message != null) { %>
    <p style="color: red; text-align: center; font-weight: bold;"><%= message %></p>
<% } %>

<form action="RegisterServlet" method="post">
    <label style="font-weight: bold; color: white;">Tên đăng nhập:</label>
    <input type="text" name="username" required style="width: 100%; padding: 8px; margin-bottom: 10px; border-radius: 5px; border: 1px solid #ccc; background-color: white;">

    <label style="font-weight: bold; color: white;">Email:</label>
    <input type="email" name="email" style="width: 100%; padding: 8px; margin-bottom: 10px; border-radius: 5px; border: 1px solid #ccc; background-color: white;">

    <label style="font-weight: bold; color: white;">Họ và tên:</label>
    <input type="text" name="fullname" required style="width: 100%; padding: 8px; margin-bottom: 10px; border-radius: 5px; border: 1px solid #ccc; background-color: white;">

    <label style="font-weight: bold; color: white;">Mật khẩu:</label>
    <input type="password" name="password" required style="width: 100%; padding: 8px; margin-bottom: 10px; border-radius: 5px; border: 1px solid #ccc; background-color: white;">
	
	<label style="font-weight: bold; color: white;">Nhập lại mật khẩu:</label>
    <input type="password" name="confirmPassword" required style="width: 100%; padding: 8px; margin-bottom: 10px; border-radius: 5px; border: 1px solid #ccc; background-color: white; color: black;">
    
    <button type="submit" style="width: 100%; padding: 10px; border: none; border-radius: 5px; background-color: #3498db; color: white; font-size: 16px; cursor: pointer;">
        Đăng ký
    </button>
</form>


<p style="text-align: center; margin-top: 15px; color: white">Đã có tài khoản? <a href="login.jsp" style="color: #3498db; text-decoration: none; font-weight: bold;">Đăng nhập</a></p>

							<div class="social w3layouts">
								<div class="heading">
									<h5>Or Login with</h5>
									<div class="clear"></div>
								</div>
								<div class="icons">
									<a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-pinterest-p" aria-hidden="true"></i></a>
									<a href="#"><i class="fa fa-linkedin" aria-hidden="true"></i></a>
									<div class="clear"></div>
								</div>
								<div class="clear"></div>
							</div>
						</div>
				<!--//form-ends-here-->
				</div><!-- copyright -->
					<div class="copyright w3-agile">
						<p> © 2017 Clean Login Form . All rights reserved | Design by <a href="http://w3layouts.com/" target="_blank">W3layouts</a></p>
					</div>
					<!-- //copyright --> 
        </div>
	</div>
</div>	

</body>
</html>
