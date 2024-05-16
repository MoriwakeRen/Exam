package student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentUpdateExecuteAction extends Action{
	public void execute(
			HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
		HttpSession session=request.getSession();

		request.getRequestDispatcher("student_update_done.jsp").
	    forward(request, response);

	}
}
