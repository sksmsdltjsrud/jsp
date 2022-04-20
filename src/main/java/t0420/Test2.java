package t0420;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/tt02Ok")
public class Test2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		int su = Integer.parseInt(request.getParameter("su"));
		int gudep = Integer.parseInt(request.getParameter("gudep"));
		
		double su2 = Math.pow(su, gudep);
		
		if(su == 0 || gudep == 0) {
			out.println("<script>");
			out.println("alert('0 이상의 수를 입력해주세요.')");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
			out.println(su+"의 "+gudep+"제곱 : " + su2);
		}
		out.println("<br/>");
		out.println("<a href='/javagreenJ/0420/test2.jsp'>돌아가기</a>");
	}
}
