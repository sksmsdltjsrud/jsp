<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- t2_LoginOk -->
<%
	//request.setCharacterEncoding("utf-8");

	String mid = request.getParameter("mid")==null ? "" : request.getParameter("mid");
	String pwd = request.getParameter("pwd")==null ? "" : request.getParameter("pwd");
	
	// 체크박스 만들어야됨, 우리는 조건부 저장으로 해야됨
	if(mid.equals("admin") && pwd.equals("1234")) {
		Cookie cookie = new Cookie("cMid", mid);
		cookie.setMaxAge(5*60);
		response.addCookie(cookie);
		
		// 사용자가 입력한 거 불러오기
		session.setAttribute("sMid", mid); // 로그인 성공한 사용자의 아이디를 세션으로 저장시킨다.
		
		out.println("<script>");
		out.println("alert('"+mid+"님 로그인 되셨습니다.')");
		out.println("location.href='t2_LoginMember.jsp';");
		out.println("</script>");
		
	}
	else {
		out.println("<script>");
		out.println("alert('아이디/비밀번호를 확인하세요')");
		out.println("history.back();"); // 돌려보내기
		out.println("</script>");
	}
%>