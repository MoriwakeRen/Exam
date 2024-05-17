package subject;

import bean.Subject;
import bean.Teacher;
import dao.SubjectDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import tool.Action;

public class SubjectCreateExecuteAction extends Action {
	
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {
		try {
			HttpSession session = request.getSession();
			Teacher teacher = (Teacher)session.getAttribute("teacher");
			
			Subject sub = new Subject();
			sub.setCd(request.getParameter("cd"));
			sub.setName(request.getParameter("name"));
			sub.setSchool(teacher.getSchool());
			
			SubjectDao dao = new SubjectDao();
			System.out.println(sub.getCd());
			System.out.println(sub.getName());
			System.out.println("test");
			
			if(sub.getCd().length() != 3) {
				request.setAttribute("error1","101");
				System.out.println("test2");
	//			return "subject_create.jsp";
				request.getRequestDispatcher("../subject/subject_create.jsp").forward(request,response);
			}
			
			if(dao.get(sub.getCd(), sub.getSchool()).getCd() != null) {
				request.setAttribute("error2", "202");
				System.out.println("test3");
	//			return "subject_create.jsp";
				request.getRequestDispatcher("../subject/subject_create.jsp").forward(request, response);
			}
			
			
			System.out.println("test5");
			dao.save(sub);
			System.out.println("test4");
			
//			return "../subject_create_done.jsp";
			request.getRequestDispatcher("subject_create_done.jsp").forward(request,response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
