package study1.mapping2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.um")
public class UrlController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 인터페이스 만들기
		UrlInterface command = null; // 미리 선언해서 만든다
		String viewPage = "";
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1, uri.lastIndexOf(".")); // 복사해서 써도 됨
		
		if(com.equals("urlMapping")) { // 로직단이 없어서 뷰로만..(처리할 게 없음), 보여주기만함
			viewPage = "/WEB-INF/study1/mapping/urlMapping.jsp";
		}
		else if(com.equals("urlMappingList")) {
			command = new UrlMappingListCommand(); // 자동으로 만들어준다(마우스 올려서 class)
			command.execute(request, response); // 실행
			viewPage = "/WEB-INF/study1/mapping/urlMappingList.jsp";
		}
		else if(com.equals("urlMappingJoin")) {
			viewPage = "/WEB-INF/study1/mapping/urlMappingJoin.jsp";
		}
		else if(com.equals("urlMappingJoinOk")) {
			command = new UrlMappingJoinOkCommand();
			command.execute(request, response);
			viewPage = "/message/message.jsp"; // 메세지 먼저 띄워줄거임
		}
		else if(com.equals("urlMappingDelete")) {
			command = new UrlMappingDeleteCommand();
			command.execute(request, response);
			viewPage = "/message/message.jsp";
		}
		else if(com.equals("urlMappingUpdate")) {
			command = new UrlMappingUpdateCommand();
			command.execute(request, response);
			viewPage = "/WEB-INF/study1/mapping/urlMappingUpdate.jsp";
		}
		else if(com.equals("urlMappingUpdateOk")) {
			command = new UrlMappingUpdateOkCommand();
			command.execute(request, response);
			viewPage = "/message/message.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
