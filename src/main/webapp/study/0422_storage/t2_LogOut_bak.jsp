<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t2_LogOut.jsp -->
<%
	Cookie[] cookies = request.getCookies();
	String mid = "";
	
	for(int i=0; i<cookies.length; i++) {
		if(cookies[i].getName().equals("cMid")) {
			mid = cookies[i].getValue();
			break;
		}
	}
%>
<script>
	alert("<%=mid%>님 로그아웃 되셨습니다.");
	location.href="t2_Login.jsp";
</script>