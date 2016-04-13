<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
            <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search results</title>
<link rel='stylesheet' href='scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->
</head>
<body>
<jsp:include page="header.jsp" />
<div class="searchresults">
<table>
<tr>
	<th>Artist</th>
	<th>Title</th>
	<th>Recording ID</th>
	<th>Category</th>
	<th>Number of Tracks</th>
	<th>Price</th>
	<th>Stock</th>
	<th></th>
</tr>
<c:forEach var="search" items="${requestScope.searches}">
<tr>
	<td>${search.artist }</td>
	<td>${search.title }</td>
	<td>${search.recordId }</td>
	<td>${search.catName }</td>
	<td>${search.tracks }</td>
	<td>${search.price }</td>
	<td>${search.stock }</td>
	<td>
	<c:if test="${search.stock == 0}">
	<input type="submit" value="Add to Cart" disabled>
	</c:if>
	<c:if test="${search.stock > 1}">
	<form action="addCartItems">
	<input type="text" hidden value="${search.recordId}" name="recordId">
	<input type="text" hidden value="${search.title}" name="title">
	<input type="submit" value="Add to Cart">
	</form>
	</c:if>
	</td>
</tr>
</c:forEach>
</table>

</div>
</body>
</html>