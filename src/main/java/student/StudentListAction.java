package student;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentListAction extends Action{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws exception {
		HttpSession session=request.getSession();
	}
}
