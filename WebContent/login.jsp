<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel='stylesheet' href='scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

<script>

</script>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp" />

<div class="welcomelogin">
<% String req = request.getParameter("m");
if(req != null) {
	%>
	<div class="success">Thank you for registering! Log in now!</div>
	<%
}

%>
<div class="formlogin">

<h2 class="logtitle">Returning Customer</h2></a>
<form class ="formlog" action="log" method="post">  
<i class="iconz fa fa-user"></i> <input type="text" name="username" placeholder="Username"/><br/><br/>  
<i class="iconz fa fa-unlock-alt"></i><input type="password" name="password" placeholder="Password"/><br/><br/>  
<input type="submit" value="Login"/>  
</form>  
<a class="adminloginhref" href="admin/">Admin Login</a>
</div>
<br/>
<br/>
<div class="formreg">
<h2 class="headtitle">New Customer</h2>

<form class="formreg-form" action="reg" method="post">  

<i class="iconz fa fa-user"></i> <input type="text" required name="username" placeholder="Username"/><br/><br/>  
<i class="iconz fa fa-unlock-alt"></i><input type="password" required name="password" placeholder="Password"/><br/><br/>  
<i class="iconz fa fa-user"></i> <input type="text" required name="firstname" placeholder="First Name"/><br/><br/>  
<i class="iconz fa fa-user"></i> <input type="text" required name="lastname" placeholder="Last Name"/><br/><br/>  
<i class="iconz fa fa-map-marker"></i> <input type="text" required name="address" placeholder="Address"/><br/><br/>  
<i class="iconz fa"></i> <input type="text" required name="postcode" placeholder="Postcode"/><br/><br/>  
<i class="iconz fa fa-phone"></i> <input type="text"  required name="telephone" placeholder="Telephone"/><br/><br/>  
<i class="iconz fa fa-envelope"></i> <input type="text" required  name="email" placeholder="Email"/><br/><br/>  
<input type="text" hidden name="type" value="Customer">

<input type="submit" value="Register"/>  
</form> 
</div>
</div>
</body>
</html>