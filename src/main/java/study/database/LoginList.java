package study.database;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 코맨드 블럭
@WebServlet("/loginList")
public class LoginList extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 보안처리(비로그인시에 처리한다.) 시작
		HttpSession session = request.getSession();
		String mid = (String) session.getAttribute("sMid");
		if(mid == null) {
			response.sendRedirect(request.getContextPath()+"/log");
			return;
		}
		// 보안처리 끝
		
		LoginDAO dao = new LoginDAO();
		
		ArrayList<LoginVO> vos = dao.getLoginList(); // 여러개 가져오기 위해서 ArrayList 사요해줌
		
		// 바로 쓰고 바로 버리는게 좋음(request), application은 일반사용자는 사용하면안됨
		request.setAttribute("vos", vos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/study/database/loginList.jsp");
		dispatcher.forward(request, response);
	}
}
