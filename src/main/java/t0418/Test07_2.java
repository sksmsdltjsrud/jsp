package t0418;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// HttpServlet 무조건 상속 받아야됨
@WebServlet("/T07_2") // 컨트롤러 이름으로 온다
public class Test07_2 extends HttpServlet {
	// post 컨트롤 스페이스 -> 노란색으로 import 해주기
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		PrintWriter out = response.getWriter();
		
		out.println("아이디2 : "+mid+"<br/>");
		out.println("비밀번호2 : "+pwd+"<br/>");
		out.println("<a href='/javagreenJ/0418/test07.jsp'>돌아가기</a>");
	}
}
