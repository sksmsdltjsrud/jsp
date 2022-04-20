package t0418;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 서버
@WebServlet("/T10_22")
public class Test10_22 extends HttpServlet {
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=uft-8");
		
		PrintWriter out = response.getWriter(); // 뷰에서 출력할 때 PrintWriter 필요
		
		String mid = request.getParameter("mid") == null ? "" : request.getParameter("mid");
		String hostIp = request.getParameter("hostIp");
		/*
		 * String pwd = request.getParameter("pwd") == null ? "" :
		 * request.getParameter("pwd");
		 */
		if(mid.equals("")) {
		/* if(mid.equals("") || pwd.equals("")) { */
			out.println("<script>"); // 항상 시작과 끝을 주는게 좋음
			out.println("alert('아이디를 입력하세요');"); // 프론트에서 혹시나 안했을까봐 해줌(좋은방법X)
			out.println("history.back();"); // history.back() : 돌아가기() 1 생략
			out.println("</script>");
			return;
		}
		
		String pwd = request.getParameter("pwd") == null ? "" : request.getParameter("pwd");
		if(pwd.equals("")) {
			out.println("<script>");
			out.println("alert('비밀번호를 입력하세요');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		String name = request.getParameter("name");
		
		
		out.println("<br/>아이디 : " + mid);
		out.println("<br/>비밀번호 : " + pwd);
		out.println("<br/>성명 : " + name);
		out.println("<br/>접속사용자 IPp : " + hostIp);
		out.println("<br/>");
		out.println("<br/>");
		out.println("<br/>");
		out.println("<br/>");
		out.println("<br/>");
		out.println("<br/>");
		out.println("<br/>");
		out.println("<br/>");
		out.println("<br/><a href='"+request.getContextPath()+"/0418/test10.jsp'>돌아가기</a>");
	}

}
