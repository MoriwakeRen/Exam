package certification;

import bean.Teacher;
import dao.TeacherDao;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Action;

public class LoginExecuteAction extends Action{
	public void execute(
			HttpServletRequest req,HttpServletResponse res
		) throws Exception{
//			HttpSession session=req.getSession();
			
			String id=req.getParameter("id");
			String password=req.getParameter("password");
			TeacherDao dao=new TeacherDao();
			Teacher teacher=dao.login(id,password);
			
			if(teacher!=null) {
				RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
				rd.forward(req, res);
//				session.setAttribute("teacher", teacher);
//				return "menu.jsp";
			}else {
				req.setAttribute("message", "IDまたはパスワードが確認できませんでした");

				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.forward(req, res);
			}
			RequestDispatcher rd = req.getRequestDispatcher("error.jsp");
			rd.forward(req, res);
	}
}

