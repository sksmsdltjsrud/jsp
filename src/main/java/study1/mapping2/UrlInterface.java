package study1.mapping2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 인터페이스 만들기(선언만 함) 파일명(메소드명) : execute
public interface UrlInterface {
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException; // throws : 예외처리
}
