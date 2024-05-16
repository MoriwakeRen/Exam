package student;

import java.util.List;

import bean.Classnum;
import bean.Student;
import bean.Teacher;
import bean.Year;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; // HttpSessionをインポート
import tool.Action;

public class StudentListAction extends Action{
    public  void execute(
        HttpServletRequest request, HttpServletResponse response
        ) throws Exception {
        HttpSession session = request.getSession();
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        String school = teacher.school();
        StudentDao dao=new StudentDao();
        List<Student> list=dao.searchBySchool(school);      
        session.setAttribute("list", list);
        
        // 同じdaoインスタンスを再利用
        List<Year> yearlist=dao.yearSearch();
        session.setAttribute("yearlist", yearlist);
        
        List<Classnum> classnumlist =dao.classnumSearch();
        session.setAttribute("classnumlist", classnumlist);
        
        request.getRequestDispatcher("student_list.jsp").
        forward(request, response);
    }
}
