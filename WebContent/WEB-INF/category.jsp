<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Congo - Music Categories</title>
<link rel='stylesheet' href='scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->

</head>
<body>
<jsp:include page="header.jsp" />

<div class="cf"></div>
<div id="main">
<div class="container">

<div class="formcat">
<form action="SelectCat">
<select name="CatName">
<c:forEach var="cat" items="${requestScope.cat}">

<option value="${cat.catName}">${cat.catName}</option>

</c:forEach>
</select>
<input type="submit" value="Submit">
</form>
</div>
</div>
<jsp:include page="side.jsp" />

<div class="cf"></div>
</div>
</body>
</html>