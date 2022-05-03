<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String msg = (String) request.getAttribute("msg");// 객체니까 String으로 바꿔줌
	String url = (String) request.getAttribute("url");
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>message.jsp</title>
  <script>
  	'use strict';
  	
  	let msg = '<%=msg%>'; /* 거꾸로 쓰는건 안됨 */
  	let url = '<%=url%>';
  	
  	if(msg == "loginJoinOk") msg = "회원에 가입되었습니다.";
  	else if(msg == "loginJoinNo") msg = "회원 가입 실패^^";
  	else if(msg == "loginDeleteOk") msg = "회원 탈퇴 성공^^";
  	else if(msg == "loginDeleteNo") msg = "회원 탈퇴 실패ㅠ3ㅠ";
  	else if(msg == "loginIdCheckNo") msg = "중복 회원이 존재합니다.";
  	else if(msg == "loginUpdateOk") msg = "회원정보가 수정되었습니다.";
  	else if(msg == "loginUpdateNo") msg = "회원정보 수정이 되지 않았습니다.";
  	else if(msg == "guestInputOk") msg = "방명록에 글이 접수되었습니다.";
  	else if(msg == "guestInputNo") msg = "방명록에 글이 입력되지 않았습니다.";
  	else if(msg == "adminOk") msg = "관리자 인증 확인~!";
  	else if(msg == "adminNo") msg = "관리자 인증 실패ㅠㅠ";
  	else if(msg == "adminLogOutOk") msg = "관리자 로그아웃 되었습니다.";
  	else if(msg == "guestDeleteOk") msg = "게시글이 삭제되었습니다.";
  	else if(msg == "guestDeleteNo") msg = "게시글이 삭제되지 않았습니다.";
  	
  	alert(msg);
  	if (url != "") location.href = url;
  	
  </script>
</head>
<body>

</body>
</html>