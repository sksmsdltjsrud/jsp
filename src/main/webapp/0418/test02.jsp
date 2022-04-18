<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>test02.jsp</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<p><br/></p>
<div class="container">
	<h2>JSP 주석</h2>
	<!-- 이곳은 HTML 주석 입니다. -->
	<%-- 이곳은 jsp 주석 입니다.(소스코드에도 안보임) --%>
	<%		// 이곳은 스크립틀릿 입니다. - 자바코드를 작성할 수 있는 공간입니다.
				// 자바 한 줄 주석입니다.
				/*
					자바 여러줄 주석입니다.
				*/
				
				System.out.println("이곳은 JSP에서 콘솔로 출력하고 있습니다."); // 중간중간 결과 보기 위함(개발자위함)
				out.println("1.이곳은 jsp에서 출력하고 있습니다.<br/>"); // 내가 적어준 위치에 잘 나옴
				out.println("<p>2.이곳은 jsp에서 출력하고 있습니다.</p>"); // out.println 과, 표현식은 같다
	%>
	<hr/>
	
	<%="1.이곳은 표현식으로 출력된 곳입니다." %><br/>
	<%="<font size='5' color='blue'>2.이곳은 표현식으로 출력된 곳입니다.</font>" %><br/>
	
	<hr/>
	<h2>이곳은 jsp 본문의 마지막입니다.</h2>
</div>
<p><br/></p>
</body>
</html>