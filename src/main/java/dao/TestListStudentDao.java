package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import bean.TestListStudent;

public class TestListStudentDao extends Dao{
	private String baseSql="select * from test ";
	
	public List<TestListStudent> filter(Student student)throws Exception{
		Connection con = getConnection();
        List<TestListStudent> list = new ArrayList<>();

        try {
            PreparedStatement st = con.prepareStatement(
                    baseSql + "WHERE student_no = ?");
            st.setString(1, student.getNo());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                TestListStudent test = new TestListStudent();
                test.setSubjectName(rs.getString("subject_name"));
                test.setSubjectCd(rs.getString("subject_cd"));
                test.setNum(rs.getInt("no"));
                test.setPoint(rs.getInt("point"));
                list.add(test);
            }

            rs.close();
            st.close();
        } finally {
            con.close();
        }

        return list;
    }
}
