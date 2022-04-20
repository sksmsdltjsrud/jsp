<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- test1FormOk.jsp -->
<%
	request.setCharacterEncoding("utf-8");

	String name = request.getParameter("name");
	int price = request.getParameter("price")==null ? 0 : Integer.parseInt(request.getParameter("price"));
%>
<p>성명 : <%=name %></p>
<p>가격 : <%=price %></p>
<p><a href="test1Form.jsp">돌아가기</a></p>
<%
/* get방식=직렬화(sendRedirect) */
	//response.sendRedirect("test1FormResult.jsp?name=김말숙&price=1500");
%>
<!-- admin으로 갔을 때 관리자로 들어가기 -->
<!-- if문 한 줄 일때도 중괄호 해주기 -->
<%if(name.equals("admin")) {%>
	<!-- jsp액션태그, jsp뒤에 내용 적을게 없을 때 />로 마무리 해줌 -->
	<!-- 앞에 있는 거 연장해준다 -->
	<jsp:forward page="test1FormAdmin.jsp"></jsp:forward>
<% } else { %>
	<jsp:forward page="test1FormResult.jsp"></jsp:forward>
<% } %>