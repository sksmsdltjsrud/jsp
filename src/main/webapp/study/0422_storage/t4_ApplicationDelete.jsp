<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t4_ApplicationSave.jsp -->
<%
	application.removeAttribute("aMid");
%>
<script>
	alert("Application에 아이디 정보를 삭제했습니다.");
	location.href="t4_ApplicationMain.jsp";
</script>