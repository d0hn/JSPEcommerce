<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add new tracks</title>
</head>
<body>
<%	String admin = (String)session.getAttribute("admin");  
	String m = (String)request.getParameter("m");
%>
<%if(m!=null) { %>
<p>Track submitted!</p>
<%} %>
<% if(admin != null) {  %>
<form method="get" action="add_tracks">
<input type="text" name="id" placeholder="id">
<input type="text" name="recording_id" placeholder="recording id">
<input type="text" name="title" placeholder="title">
<input type="text" name="duration" placeholder="duration">
<input type="submit" value="Submit">
</form>
<%} else if(admin == null) {%>
<h2>You are not logged in.</h2>
<%} %>
</body>
</html>