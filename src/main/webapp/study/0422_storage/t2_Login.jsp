<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	Cookie[] cookies = request.getCookies();
	String mid = "";
	
	if(cookies != null) {
		for(int i=0; i<cookies.length; i++) {
			if(cookies[i].getName().equals("cMid")) {
				mid = cookies[i].getValue();
				break;
			}
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>t2_Login.jsp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script>
  	function fCheck() {
  		myForm.submit(); // 실제 로그인 할 때에는 받아오기
  	}
  </script>
</head>
<body>
<p><br/></p>
<div class="container">
  <form name="myForm" method="post" action="t2_LoginOk.jsp">
  	<table class="table table-bordered text-center">
  	  <tr>
  	    <td colspan="2"><h3>로 그 인</h3></td>
  	  </tr>
  	  <tr>
  	  	<th class="bg-secondary text-white">아이디</th>
  	  	<td><input type="text" name="mid" value="<%=mid%>" autofocus class="form-control"/></td>
  	  </tr>
  	  <tr>
  	  	<th class="bg-secondary text-white">비밀번호</th>
  	  	<td><input type="password" name="pwd" class="form-control"/></td>
  	  </tr>
  	  <tr>
  	    <td colspan="2">
  	      <button type="button" onclick="fCheck()" class="btn btn-success">로그인</button> &nbsp;&nbsp;
  	      <button type="reset" class="btn btn-success">다시입력</button>
  	    </td>
  	  </tr>
  	</table>
  </form>
</div>
<p><br/></p>
</body>
</html>