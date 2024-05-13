package certification;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LogoutAction extends Action{
	public void execute(
			HttpServletRequest req,HttpServletResponse res
	)throws Exception{
		
		HttpSession session=req.getSession();
		
		if(session.getAttribute("teacher")!=null) {
			session.removeAttribute("teacher");
		}
		RequestDispatcher rd=req.getRequestDispatcher("logout.jsp");
		rd.forward(req, res);
	}
}
