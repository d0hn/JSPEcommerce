<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Login</title>
<link rel='stylesheet' href='../scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>

</head>
<body>
<div class="admin-home">

<div class="admin-base">
<div class="logo-area">
<a href="../index.jsp"><img class="logo" src="../img/logo.png"></a>
<h3>Admin Panel login</h3>
</div>
<div class="admin-login">


<form method="post" class="form-admin" action="../admin">
<i class="iconz fa fa-user"></i> <input type="text" placeholder="Username" name="username" required>
<i class="iconz fa fa-unlock-alt"></i> <input type="password" placeholder="Password" name="password" required>
<input type="text" hidden name="type" value="admin">

<br/><br/>
<input class="btn-submit" type="submit" value="login">
</form>


</div>
</div>
</div>
</body>
</html>