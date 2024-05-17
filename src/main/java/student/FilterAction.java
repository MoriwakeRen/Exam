package student;

import java.util.List;

import bean.Student;
import bean.Teacher;
import dao.StudentDao;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; // HttpSessionをインポート
import tool.Action;

public class FilterAction extends Action {
	public void execute(
		HttpServletRequest request, HttpServletResponse response
	) throws Exception {		
		HttpSession session=request.getSession();		
        String entYear = request.getParameter("f1");
        String classNum = request.getParameter("f2");
        String isAttendStr = request.getParameter("f3");
        Boolean isAttend = null;
        if (isAttendStr != null) {
            isAttend = Boolean.valueOf(isAttendStr); // 文字列をBooleanに変換
        }
        // 文字列を整数に変換
        int entYearInt = 0;
        if (entYear != null && !entYear.equals("0")) {
            try {
                entYearInt = Integer.parseInt(entYear);
            } catch (NumberFormatException e) {
                // 数値に変換できない場合のエラーハンドリング
                throw new Exception("年度が正しくありません。");
            }
        }        
		StudentDao dao=new StudentDao();
		List<Student> list;
		// クラスが指定されているが入学年度が指定されていない場合、エラーメッセージを表示
		if (classNum != null && !classNum.equals("0") && (entYear == null || entYear.equals("0"))) {
			request.setAttribute("errorMessage", "クラスを指定する場合は入学年度も指定してください");
			request.getRequestDispatcher("student_list.jsp").
        	forward(request, response);
			return;
		}
		// フィルタリングの条件が指定されていない場合、ログインしているユーザーの学生を表示
		else if ((entYear == null || entYear.equals("0")) && (classNum == null || classNum.equals("0")) && isAttend == null) {
			Teacher teacher = (Teacher)session.getAttribute("teacher");
			String school = teacher.school();
			list = dao.searchBySchool(school);
		} else {
			// 入学年度だけが指定されている場合、ログインしているユーザーの所属している学校かつ指定された入学年度の学生を表示
			if (entYear != null && !entYear.equals("0") && classNum == null && isAttend == null) {
				Teacher teacher = (Teacher) session.getAttribute("teacher");
				String school = teacher.school();
				list = dao.searchBySchoolAndYear(school, entYearInt);
			}
			// 入学年度と在学中が指定されている場合、ログインしているユーザーの所属している学校かつ指定された入学年度と在学中の学生を表示
			else if (entYear != null && !entYear.equals("0") && isAttend != null && classNum == null) {
				Teacher teacher = (Teacher) session.getAttribute("teacher");
				String school = teacher.school();
				list = dao.searchBySchoolAndYearAndIsAttend(school, entYearInt, isAttend);
			} 
			// 入学年度とクラスが指定されている場合、ログインしているユーザーの所属している学校かつ指定された入学年度とクラスの学生を表示
			else if (entYear != null && !entYear.equals("0") && classNum != null && !classNum.equals("0") && isAttend == null) {
				Teacher teacher = (Teacher) session.getAttribute("teacher");
				String school = teacher.school();
				list = dao.searchBySchoolAndYearAndClass(school, entYearInt, classNum);
			} else {
				list = dao.search(entYearInt, classNum, isAttend);
			}
		}
		session.setAttribute("list", list);
        request.getRequestDispatcher("student_list.jsp").
        forward(request, response);
	}
}









