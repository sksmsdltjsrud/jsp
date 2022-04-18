package t0418;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Test08
 */
@WebServlet("/T08")
public class Test08 extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		request.setCharacterEncoding("utf-8");
		
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		PrintWriter out = response.getWriter();
		
		out.println("아이디 : "+mid+"<br/>");
		out.println("비밀번호 : "+pwd+"<br/>");
		out.println("이름 : "+name+"<br/>");
		out.println("<a href='javagreenJ/0418/test09.jstp'>돌아가기</a>");
	}

}
