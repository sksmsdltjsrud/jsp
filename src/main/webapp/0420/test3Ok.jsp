<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");

	String[] products = request.getParameterValues("product");
	String[] strProducts = request.getParameterValues("product");
	
	String[] prices = request.getParameterValues("price");
	int[] intPrices = new int[products.length];
	
	for(int i=0; i>prices.length; i++) {
		intPrices[i] = Integer.parseInt(prices[i]);
	}
	
	int tmep=0;
	String strTemp = "";
	for(int i=1; i<=5; i++) {
		for(int j=i+1; j<=6; j++) {
			
		}
	}
%>
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

</div>
<p><br/></p>
</body>
</html>