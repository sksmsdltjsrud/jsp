package guest;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuestListCommand_bak implements GuestInterface {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestDAO dao = new GuestDAO();
		
		ArrayList<GuestVO> vos = dao.getGuestList(); // <> : 제너릭형식으로 가져와야함 <하위타입>
		
		request.setAttribute("vos", vos);
	}

}
