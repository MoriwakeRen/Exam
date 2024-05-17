package subject;

import java.util.List;

import bean.School;
import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectListAction extends Action{
	
	@Override
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		HttpSession session=request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
//		System.out.println(teacher.getSchool().getCd()); 
//		↑セッションで学校コードが取得できているかの確認
		
		School school = teacher.getSchool();
		SubjectDao dao = new SubjectDao();
		
		List<Subject> list = dao.filter(school);
		
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("subject_list.jsp").forward(request, response);
	}
}