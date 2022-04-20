<%@page import="t0420.SungjukVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8"); // 한글처리(지금은 안해줘도됨)
	
	//String strVo = request.getParameter("vo");
	
	//SungjukVo vo = (SungjukVo) request.getParameter("vo"); // 강제 형변환(SungjukVo) 안됨
	
	SungjukVo vo = (SungjukVo) request.getAttribute("vo");
	
	System.out.println("vo : " + vo);
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>sungjukView.jsp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<p><br/></p>
<div class="container">

</div>
<p><br/></p>
</body>
</html>