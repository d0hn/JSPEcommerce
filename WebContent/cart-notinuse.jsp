<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="java.io.*" %>
    <%@ page import = "javax.servlet.*" %>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Congo - Shopping Cart</title>
</head>
<body>


<%
	Cookie[] cookies = request.getCookies(); 
	String cookieName = "track";
	ArrayList<String> storeCookies = new ArrayList<String>();
	ArrayList<String> storeNames = new ArrayList<String>();
    String cookieValue = "";
    Cookie cookie;
    if (cookies != null)
    {
      for (int i=0; i<cookies.length; i++)
      {
    	String check = Integer.toString(i+1);
    	String cooks = cookieName;
    	cooks = cooks + "" + check;
        cookie = cookies[i];
        String searchCookieName = cookie.getName();
        if (cooks.equals(searchCookieName))
        {
          cookieValue = cookie.getValue();
          storeNames.add(cooks);
          storeCookies.add(cookieValue);
        }
        System.out.println(storeCookies);
        cooks = "";
        searchCookieName = "";
      }
    }

    response.setContentType("text/html");
    request.setAttribute("storeCookies", storeCookies);
    request.setAttribute("storeNames", storeNames);
    RequestDispatcher view = request.getRequestDispatcher("cart.jsp");
%>

<form action="getCartItems" method="post" name="carter">
<input type="text" value="${storeCookies}" hidden name="cookiearray">

<c:if test="${not empty storeCookies }">
<input type="submit" value="Get your cart items">
</c:if>

<c:if test="${empty storeCookies }">
<p>Your Shopping cart is empty!</p>
</c:if>
</form>
<h2>Cart Items</h2>
<table>
	<tr>
		<th>Title </th>
		<th>Artist </th>
		<th>Price </th>
		<th>Tracks </th>
		<th>Available Stock</th>
		<th>ID</th>
	</tr>

<c:forEach var="listing" items="${requestScope.cartItems}">
	<tr>
<td>${listing.title}</td>
<td>${listing.price }</td>
<td>${listing.artist }</td>
<td>${listing.tracks }</td>
<td>${listing.stock }</td>
<td>${listing.recordId }</td>
</tr>
</c:forEach>

</table>
</body>
</html>