<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="ctp" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>loginJoin.jsp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
  	function fCheck() {
  		// Front 체크....후 전송한다.(유효성검사)
  		myForm.submit();
  	}
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>회 원 가 입</h2>
	<form name="myForm" method="post" action="${ctp}/loginJoin">
		<table class="table">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="mid" autofocus class="form-control"/></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd" class="form-control"/></td>
			</tr>
			<tr>
				<th>성명</th>
				<td><input type="text" name="name" class="form-control"/></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" value="회원가입" onclick="fCheck()" class="btn btn-success"/> &nbsp;
					<input type="button" value="돌아가기" onclick="location.href='login.jsp';" class="btn btn-success"/> &nbsp;
				</td>
			</tr>
		</table>
	</form>
</div>
<p><br/></p>
</body>
</html>