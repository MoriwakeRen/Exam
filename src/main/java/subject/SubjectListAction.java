package subject;

import java.util.List;

import bean.School;
import bean.Subject;
import dao.SubjectDao;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

@WebServlet(urlPatterns="/SubjectListAction")
public class SubjectListAction extends Action{
	
	@Override
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		HttpSession session=request.getSession();
		
		String schoolId=request.getParameter("id");
		School school = new School();
		school.setCd(schoolId);
		
		SubjectDao dao=new SubjectDao();
		
		List<Subject> subjectList=dao.filter(school);
		
		session.setAttribute("list", subjectList);
		
		request.getRequestDispatcher("subject_list.jsp").forward(request, response);
	}
}