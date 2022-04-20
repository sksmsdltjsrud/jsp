package t0418;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/T11Ok")
public class Test11Ok extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
				
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String no = request.getParameter("no");
		String hakyun = request.getParameter("hakyun");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int mat = Integer.parseInt(request.getParameter("mat"));
		String[] sports = request.getParameterValues("sports"); // 앞에서 배열로 넘기면 알아서 배열로 넣어준다(getParameterValues)
		// null 이면 ? "" 공백으로 처리하고, 아니면 앞에꺼 다시 받아준다
		String otherSports = request.getParameter("otherSports")==null ? "" : request.getParameter("otherSports");
		String[] language = request.getParameterValues("language");
		
		String strLanguage = "";
		String strSports = "";
		
		if(sports != null) {
			for(String sport : sports) {
				if(sport.equals("기타")) {
					if(otherSports.trim().length() <= 0) {
						out.println("<script>");
						out.println("alert('기타항목을 선택하셨으면 기타란에 입력하세요.')");
						out.println("history.back();");
						out.println("</script>");
						return;
					}
					strSports += otherSports;
				}
				if(!sport.equals("기타")) strSports += sport + " / ";
			}
		}
		else {
			out.println("<script>");
			out.println("alert('좋아하는 스포츠를 1개 이상 입력하세요.')");
			out.println("history.back();");
			out.println("</script>");
			return;
		}
		if(language == null) {
			out.println("<script>");
			out.println("alert('사용가능언어를 선택하세요.')");
			out.println("history.back();");
			out.println("</script>");
			return;
		}
		else {
			strLanguage = "";
			for(String lang : language) {
				strLanguage += lang + " / ";
			}
		}
		
		int tot;
		double avg;
		String grade;
		
		tot = kor + eng + mat;
		avg = tot / 3.0;
		
		switch ((tot / 3) / 10) {
			case 10:
			case 9:
				grade = "A";
				break;
			case 8:
				grade = "B";
				break;
			case 7:
				grade = "C";
				break;
			case 6:
				grade = "D";
				break;
			default:
				grade = "F";
		}
		
		out.println("<br/>성명 : " + name);
		out.println("<br/>성별 : " + gender);
		out.println("<br/>학번 : " + no);
		out.println("<br/>학년 : " + hakyun);
		out.println("<br/>국어 : " + kor);
		out.println("<br/>영어 : " + eng);
		out.println("<br/>수학 : " + mat);
		out.println("<br/>총점 : " + tot);
		out.println("<br/>평균 : " + avg);
		out.println("<br/>학점 : " + grade);
		out.println("<br/>좋아하는 스포츠 : " + strLanguage);
		out.println("<br/>사용 가능한 컴퓨터 언어 : " + strSports);
		out.println("<br/><a href='"+request.getContextPath()+"/0418/test11.jsp'>돌아가기</>");
	}
}