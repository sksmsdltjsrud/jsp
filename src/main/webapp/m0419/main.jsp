<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String flag = request.getParameter("flag")==null ? "" : request.getParameter("flag");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>main</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <style>
  	body {
	  	width: 1000px;
	  	margin: 0px auto;
	  	padding: 0px;
  	}
  	#header {
	  	background-color: lightgray;
	  	text-align: center;
	  	height: 90px;
  	}
  	#content {
  		text-align: center;
  		height: 600px;
  	}
  	#footer {
  		background-color: lightgray;
  		height: 60px;
  	}
  </style>
</head>
<body>
<div class="container">
	<div id="header">
	<%@ include file="menu.jsp" %>
	</div>
	<div id="content">
<% if(flag.equals("nation")) { %>
	<%@ include file="nation.jsp" %>
<% } else if(flag.equals("expert")) {%>
	<%@ include file="expert.jsp" %>
<% } else if(flag.equals("check")) {%>
	<%@ include file="check.jsp" %>
<% } else if(flag.equals("mypage")) {%>
	<%@ include file="mypage.jsp" %>
<% } else if(flag.equals("customers")) {%>
	<%@ include file="customers.jsp" %>
<% } else {%>
<% } %>
		
	</div>
	<div id="footer">
		<%@ include file="footer.jsp" %>
	</div>
</div>
</body>
</html>