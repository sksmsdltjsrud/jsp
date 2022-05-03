package guest;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 프론트 컨트롤러
@WebServlet("*.gu")
public class GuestController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestInterface command = null;// command의 대장(interface)
		String viewPage = "/WEB-INF"; // jsp 경로(다음 경로부터 적게)
		
		String uri = request.getRequestURI();
		String com = uri.substring(uri.lastIndexOf("/")+1,uri.lastIndexOf("."));// command 객체
		
		if(com.equals("guestList")) {
			command = new GuestListCommand();
			command.execute(request, response);
			viewPage +="/guest/guestList.jsp"; // 누적
		}
		else if(com.equals("guestInput")) {
			viewPage +="/guest/guestInput.jsp"; // 보여주는 폼만 있으면 되니까 끝
		}
		else if(com.equals("guestInputOk")) {
			command = new GuestInputOkCommand();
			command.execute(request, response);
			viewPage ="/message/message.jsp";
		}
		else if(com.equals("adminLogin")) {
			viewPage +="/guest/adminLogin.jsp"; // 보여주는 폼만 있으면 되니까 끝
		}
		else if(com.equals("adminLoginOk")) {
			command = new AdminLoginOkCommand();
			command.execute(request, response);
			viewPage ="/message/message.jsp";	// 메세지 처리
		}
		else if(com.equals("adminLogOut")) {
			command = new AdminLogOutCommand();
			command.execute(request, response);
			viewPage ="/message/message.jsp";
		}
		else if(com.equals("guestDelete")) {
			command = new GuestDeleteCommand();
			command.execute(request, response);
			viewPage ="/message/message.jsp";
		}
		
		// 앞에서 받은거 forward 시키기
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
