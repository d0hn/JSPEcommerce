<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login details incorrect!</title>
<link rel='stylesheet' href='scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->

</head>
<body>
<jsp:include page="WEB-INF/header.jsp" />
<div class="logerr">
Login details incorrect! Please try again.<br/>
<button onclick="goBack()">Go Back</button>
</div>
<script>
function goBack() {
    window.history.back();
}
</script>
</body>
</html>