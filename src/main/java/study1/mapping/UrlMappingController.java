package study1.mapping;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.url")
public class UrlMappingController extends HttpServlet {
	@Override // 옛날꺼
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	@Override // 옛날꺼
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request, response);
	}
	
	// actionDo를 내가 만들어버린다(service로 해도됨 -> Override)
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuffer url = request.getRequestURL();
		System.out.println("url : " + url);
		
		String uri = request.getRequestURI(); // URI : 내가 만든 경로만 나옴(/javagreenJ/urlMapping.url)
		System.out.println("uri : " + uri);
		
//		String com = uri.substring(12,uri.lastIndexOf("."));// command객체(urlMapping)
		String com = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));// command객체(urlMapping)
		System.out.println("commmand Object name : " + com);
		
		
		// 메세지 띄우려고 한거
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('콘솔창을 확인해 보세요...')");
//		out.println("location.href='/WEB-INF/study1/mapping/urlMapping.jsp';"); // get방식을 통해서는 '/WEB-INF'폴더를 접근할 수 없다.
		out.println("location.href='"+request.getContextPath()+"/study1/urlMapping';");
		out.println("</script>");
	}
}
