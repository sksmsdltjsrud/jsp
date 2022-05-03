package guest;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GuestInterface {
	// 메소드 정해주기(execute)
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
