<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%= request.getParameter("CatName") %> Results</title>
<link rel='stylesheet' href='scss/default.css' type='text/css'/> <!-- Compiled using Sass -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"> <!-- Icons only -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<script>
function imgError(image) { //check if image exists
    image.onerror = "";
    image.src = "img/150x150error.png"; //return placeholder if not
    return true;
}
</script>
</head>
<body>
<jsp:include page="header.jsp" />
<div class="cf"></div>
<div id="main">
<div class="container">
<c:forEach var="listing" items="${requestScope.listing}">
<div class="listing"><p class="genre">${listing.catName}</p>
<a href="singlelisting?id=${listing.recordId}&artist=${listing.artist}&title=${listing.title}"><div class="title"><p class="listleft">${listing.title }</p>

<p class="listid">by ${listing.artist }</p>
</div></a>
<div class="cf"></div>
<img onerror="imgError(this);" alt="${listing.artist}"src="${listing.img }"/> <!-- Catch error if image doesn't exists, add Alt tag of an artist(SEO purposes), if image exists add url -->
<div class="description">
<div class="info">
<c:if test="${listing.stock > 10}">
<p>Available stock: ${listing.stock }</p>

<form action="addCartItems">
<input type="text" hidden value="${listing.recordId}" name="recordId">
<input type="text" hidden value="${listing.title}" name="title">
<input type="submit" value="Add to Cart">
</form>
</c:if>
<c:if test="${listing.stock <= 10} && ${listing.stock >= 1 }">
<p>Only ${listing.stock } available! Order now</p>
<form action="addCartItems">
<input type="text" hidden value="${listing.recordId}" name="recordId">
<input type="text" hidden value="${listing.title}" name="title">
<input type="submit" value="Add to Cart">
</form>
</c:if>
<c:if test="${listing.stock == 0}">
<p>Not available at this moment</p>
<input type="submit" value="Add to Cart" disabled>
</c:if>

<p>Number of tracks: ${listing.tracks }</p>
<p class="price">Price: £${listing.price }</p>

</div>
</div>
</div>
</c:forEach>
</div>
<jsp:include page="side.jsp" />

<div class="cf"></div>
</div>
</body>
</html>