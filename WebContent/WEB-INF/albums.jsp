<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Congo - Music Tracks</title>
<link rel='stylesheet' href='scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<!-- While the page is loading, display loading Div. -->
<script type="text/javascript">
$(window).load(function() {
	$(".loader").fadeOut("slow");
})
</script>
</head>
<body>
<div class="loader">
<p>
Fetching Results, please wait.
</p>
<img src="img/loading.gif"/>
</div>
<jsp:include page="header.jsp" />
<div class="cf"></div>
<div id="main">
<div class="container">


<c:forEach var="albums" items="${requestScope.albums}">
<div class="tablelayout">


<table>
  <tr>
    <th class="thtitle">Title</th> 
    <th class="thdesc">Duration</th>
    <th></th>
    <th></th>
  </tr>
  <tr>
    <td class="thtitle">${albums.title} by ${albums.artist}</td>
    <td class="thdesc">${albums.duration }</td> 
    <td><a href="singlelisting?id=${albums.recordId}&artist=${albums.artist}&title=${albums.title}">View more</a></td>
  	<td><form action="addCartItems">
<input type="text" hidden value="${albums.recordId}" name="recordId">
<input type="text" hidden value="${albums.title}" name="title">
<input type="submit" value="Add Album to Cart">
</form>
  </tr>
</table>
</div>
</c:forEach>
</div>
<jsp:include page="side.jsp" />

</body>
</html>