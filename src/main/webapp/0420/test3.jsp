<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>title</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<!--   <script>
  	function fCheckAsc {
  		
  		myForm.submit();
  	}
  </script> -->
</head>
<body>
<p><br/></p>
<div class="container">
	<pre>
		폼을 통해서 상품명과 가격을 6개 입력받아서 가격순으로 오름차순/내림차순 정렬처리후 출력하시오.
		구현 파일 : jsp
		파일명 : test3Ok.jsp
		폼태그의 내용은 미리 value값에 저장시켜놓는다.
		버튼 : '오름차순'/'내림차순'/'돌아가기'
		출력시에는 원본자료와 정렬된 자료를 모두 출력시켜주시오.
		완성후 화면을 예쁘게 꾸며보세요.(bs4사용...)
	</pre>
	<hr/>
	<h2>상품명과 가격 입력</h2><br/>
	<form name="myForm" method="post" action="test3Ok.jsp">
		<p class="s1">상품1 : <input type="text" name="product" value="냉장고"/>&nbsp; 가격 : <input type="number" name="price" value="2000000"/></p>
		<p class="s1">상품2 : <input type="text" name="product" value="곰인형"/>&nbsp; 가격 : <input type="number" name="price" value="10000"/></p>
		<p class="s1">상품3 : <input type="text" name="product" value="아이폰12프로맥스"/>&nbsp; 가격 : <input type="number" name="price" value="900000"/></p>
		<p class="s1">상품4 : <input type="text" name="product" value="노트북"/>&nbsp; 가격 : <input type="number" name="price" value="1800000"/></p>
		<p class="s1">상품5 : <input type="text" name="product" value="목걸이"/>&nbsp; 가격 : <input type="number" name="price" value="700000"/></p>
		<p class="s1">상품6 : <input type="text" name="product" value="키보드"/>&nbsp; 가격 : <input type="number" name="price" value="100000"/></p>

		<p>
			<input type="button" value="오름차순 출력" onclick="fCheckAsc"/> &nbsp;
			<input type="button" value="내림차순 출력" onclick="fCheckDesc"/> &nbsp;
			<input type="reset" value="다시 입력" /> &nbsp;
		</p>
	</form>
	
</div>
<p><br/></p>
</body>
</html>