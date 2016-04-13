<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="topbar">
<%

	String name = (String)session.getAttribute("user");
	String admin = (String)session.getAttribute("admin");
	
	
if(name != null && admin == null) {
	%>
		<span class="logged">Welcome, <% out.print(name); %></span>
		<a class="logout" href="logout">Logout <i class="fa fa-sign-out"></i></a>
		<a class="profile" href="profile">Your Profile <i class="fa fa-user"></i></a>
		
		
	<%
	
} else {
	%>
	<a class="login" href="login.jsp">Login <i class="fa fa-sign-in"></i> </a>
	<%
} 
if(admin != null) {
	%>
	<span class="logged">Howdy, <% out.print(admin); %>?</span>
	<a class="profile" href="admin-panel.jsp">Admin Panel <i class="fa fa-users"></i></a>
	<a class="logout" href="logout">Logout <i class="fa fa-sign-out"></i></a>
		
<%
}
%>

</div>
<nav>
<div class="logo"><img src="img/logo.png"/></div>
<ul>
<li><a href="index.jsp">Home</a></li>
<li><a href="albums">Tracks</a></li>
<li><a href="category">Categories</a></li>
<li><a href="prices">Prices</a></li>
</ul>
<form action ="Musicsearch">Search <input type = "text" name ="search"/><button type= "submit"><i class ="fa fa-search"></i></button></form>
</nav>