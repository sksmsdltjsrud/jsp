<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>title</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
<p><br/></p>
<div class="container">
  <pre>
    수를 폼태그에서 입력받아 입력받은수의 거듭제곱값을 출력하시오?(서블릿으로 구현하여 출력하시오)
    서블릿파일명 : t0420.Test2
    컨트롤러경로명 : tt02Ok
  </pre>
  <form name="myForm" method="post" action="<%=request.getContextPath()%>/tt02Ok">
    <div class="row">
      <div class="col text-center">수를 입력하세요 :</div>
      <div class="col"><input type="number" name="su" value="10" autofocus /></div>
	    <div class="col"><input type="submit" value="거듭제곱" class="btn btn-success"/></div>
    </div>
  </form>
</div>
<p><br/></p>
</body>
</html>