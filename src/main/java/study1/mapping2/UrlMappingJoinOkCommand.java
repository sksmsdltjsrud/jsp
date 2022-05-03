package study1.mapping2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.database.LoginDAO;
import study.database.LoginVO;

public class UrlMappingJoinOkCommand implements UrlInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginVO vo = new LoginVO(); // 생성
		
		// String mid = .. 앞에 한 번 받았으면 vo로 받아줘도 됨
		vo.setMid(request.getParameter("mid")==null ? "" : request.getParameter("mid")); // 받아오기
		vo.setPwd(request.getParameter("pwd")==null ? "" : request.getParameter("pwd"));
		vo.setName(request.getParameter("name")==null ? "" : request.getParameter("name"));
		
		LoginDAO dao = new LoginDAO();
		
		// 회원 중복체크하기
		int res = dao.getIdCheck(vo.getMid());
		if(res == 0) {	// 아이디가 중복되었으면...
			request.setAttribute("msg", "loginIdCheckNo");
			request.setAttribute("url", request.getContextPath()+"/urlMappingJoin.um");
		}
		else {
			// 메세지 쓰는 방법
			// 회원 가입하기
			res = dao.setLoginJoin(vo);
			
			if(res == 1) {
				request.setAttribute("msg", "loginJoinOk"); // 저장소는 request
			}
			else {
				request.setAttribute("msg", "loginJoinNo");
			}
			request.setAttribute("url", request.getContextPath()+"/urlMappingList.um"); // 컨트롤러 주소를 준다(jsp 안됨)
		}
		
	}

}
