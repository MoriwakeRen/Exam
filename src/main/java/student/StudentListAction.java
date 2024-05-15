package student;

import java.util.List;

import bean.Student;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class StudentListAction extends Action{
	public  void execute(
			HttpServletRequest request, HttpServletResponse response
			) throws Exception {
		
		HttpSession session=request.getSession();
		StudentDao dao=new StudentDao();
		List<Student> list=dao.searchAll();
		
		session.setAttribute("list", list);
		request.getRequestDispatcher("student_list.jsp").
	    forward(request, response);
	}
}
