<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String mid = "hkd1234";
	Cookie cookieMid = new Cookie("cMid",mid); // 앞:변수, 뒤:값(변수면 "" 없애주기), 쿠키는 앞에 c 써주기
	cookieMid.setMaxAge(24*60*60); // ()쿠키의 만료시간 설정 : 단위는 '초' - 1일(24*60*60)
	
	String pwd = "1234";
	Cookie cookiePwd = new Cookie("cPwd",pwd); // 앞:변수, 뒤:값(변수면 "" 없애주기), 쿠키는 앞에 c 써주기
	cookiePwd.setMaxAge(2*60); // ()쿠키의 만료시간 설정 : 단위는 '초' - 1일(24*60*60)
	
	String Gender = "male";
	Cookie cookieGender = new Cookie("cMale",Gender); // 앞:변수, 뒤:값(변수면 "" 없애주기), 쿠키는 앞에 c 써주기
	cookiePwd.setMaxAge(2*60); // ()쿠키의 만료시간 설정 : 단위는 '초' - 1일(24*60*60)
	
	// 쿠키를 클라이언트에 저장하기(사용자 컴퓨터에 저장된다.)
	response.addCookie(cookieMid);
	response.addCookie(cookiePwd);
	response.addCookie(cookieGender);
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>t1_CookiesSave.jsp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>쿠키 저장 완료......</h2>
	<hr/>
	<br/>
	<div>
		<a href="t1_CookiesMain.jsp" class="btn btn-success form-control">돌아가기</a>
	</div>
</div>
<p><br/></p>
</body>
</html>