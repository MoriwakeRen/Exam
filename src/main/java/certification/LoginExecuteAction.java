package certification;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class LoginExecuteAction extends Action{
	public String execute(
			HttpServletRequest request,HttpServletResponse response
		) throws Exception{
			HttpSession session=request.getSession();
			
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			StudentDAO dao=new StudentDAO();
			Student studentr=dao.search(id, password);
			
			if(student!=null) {
				session.setAttribute("student", student);
				return "menu.jsp";
			}else {
				request.setAttribute("message", "IDまたはパスワードが確認できませんでした");
				return "login.jsp";

			}
			return "error.jsp";
	}
}

