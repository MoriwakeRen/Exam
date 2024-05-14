package certification;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class LoginAction extends Action{
	public void execute(
			HttpServletRequest req,HttpServletResponse res
		) throws Exception{
			
			RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, res);
	}
}
