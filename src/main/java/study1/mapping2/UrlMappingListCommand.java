package study1.mapping2;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.database.LoginDAO;
import study.database.LoginVO;

public class UrlMappingListCommand implements UrlInterface {

	// 스프링에서는 서비스 구현객체라고 함
	// 회원 list 가져오기(데이터베이스), command객체가 할 일
	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginDAO dao = new LoginDAO(); // 데이터베이스 연결
		
		ArrayList<LoginVO> vos = dao.getLoginList(); // 만들어서 쓸 수 있는거임
		
		request.setAttribute("vos", vos);
	}

}
