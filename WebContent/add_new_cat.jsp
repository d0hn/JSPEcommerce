<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%	String admin = (String)session.getAttribute("admin");  %>
<% if(admin != null) {  %>
<a href="admin-panel.jsp">Admin home</a>
<a href="add_new_cat.jsp">Add new category</a>
<a href="add_new_track.jsp">Add new tracks</a>
<a href="add_new_track.jsp">Add new user</a>


<form method="get" action="add_category">
<input type="text" name="categoryname">
<input type="submit" value="Submit">
</form>
<%} else if(admin == null) {%>
<h2>You are not logged in.</h2>
<%} %>
</body>
</html>