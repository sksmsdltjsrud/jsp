package study.t0418;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *******클래스로 만들기
@WebServlet("/T08_2") // 컨트롤러
public class Test08_2 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글 처리
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		PrintWriter out = response.getWriter();
		
		out.println("아이디3 : "+mid+"<br/>");
		out.println("비밀번호3 : "+pwd+"<br/>");
		/* out.println("<a href='/javagreenJ/0418/test08.jstp'>돌아가기</a>"); */
		// 주소를 줘서 들어가는 방법 ↓
		out.println("<a href='"+request.getContextPath()+"/0418/test08.jsp'>돌아가기</a>");
		
	}
}
