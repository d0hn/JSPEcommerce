<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page session="true" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Congo - Shopping Cart</title>
</head>
<body>
<jsp:include page="WEB-INF/header.jsp" />


<c:choose>
<c:when test="${not empty cartI }">
<c:forEach items="${cartI}" var="cart">
<table>
<tr>
	<th>Title</th>
	<th>Record ID</th>
	<th></th>
</tr>
<tr>
    <td>${cart.key}</td>
    <td>${cart.value}</td>
    <td><form action="removeCartItems"><input type="text" name="title" value="${cart.key}" hidden><input type="text" name="recordId" value="${cart.value}" hidden>
    <input type="submit" value="Remove">
    </form></td>
</tr>
</c:forEach>
</c:when>
<c:otherwise>
	<p>Your Cart is empty! Start shopping now :)</p>
</c:otherwise>
</c:choose>
</table>
<%	String name = (String)session.getAttribute("user");
String pw = (String)session.getAttribute("pw"); %>
<% if(name != null) { %>
<form action="CheckoutShop" method="post">
<input type="text" value="<%=name %>" hidden name="user">
<input type="text" value="<%=pw %>" hidden name="pw">
<c:forEach items="${cartI}" var="cart">
<input type="text" value="${cart.value}" hidden name="recording">
</c:forEach>
<input type="submit" value="Go to a checkout now">
<%} %>
</form>
<%if (name == null) { %>
<p>You need to <a href="login.jsp">register or login</a> to checkout!</p>
<%} %>
</body>
</html>