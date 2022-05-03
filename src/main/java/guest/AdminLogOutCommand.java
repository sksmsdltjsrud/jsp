package guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AdminLogOutCommand implements GuestInterface {

	// 관리자 로그아웃
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		session.removeAttribute("sAdmin"); // 세션끊기
		
		request.setAttribute("msg", "adminLogOutOk");
		request.setAttribute("url", request.getContextPath()+"/guestList.gu");
	}

}
