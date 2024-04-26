package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import bean.School;
import bean.Subject;
import bean.TestListSubject;

public class TestListSubjectDao extends Dao{
	private String baseSql="select * from test ";
		
	public List<TestListSubject> filter(int entYear,String classNum,Subject subject,School school)throws Exception{
		 Connection con = getConnection();
	        List<TestListSubject> list = new ArrayList<>();

	        try {
	            PreparedStatement st = con.prepareStatement(
	                    baseSql + "WHERE ent_year = ? AND class_num = ? AND subject_cd = ? AND school_cd = ?");
	            st.setInt(1, entYear);
	            st.setString(2, classNum);
	            st.setString(3, subject.getCd());
	            st.setString(4, school.getCd());

	            ResultSet rs = st.executeQuery();
	            Map<Integer, Integer> pointsMap = new HashMap<>();
	            while (rs.next()) {
	                int testNo = rs.getInt("no");
	                int testPoint = rs.getInt("point");
	                pointsMap.put(testNo, testPoint);
	            }

	            TestListSubject testListSubject = new TestListSubject();
	            testListSubject.setEntYear(entYear);
	            testListSubject.setStudentNo(school.getCd()); // Assuming school code is used as student number
	            testListSubject.setStudentName(school.getName()); // Assuming school name is used as student name
	            testListSubject.setClassNum(classNum);
	            testListSubject.setPoints(pointsMap);
	            list.add(testListSubject);

	            rs.close();
	            st.close();
	        } finally {
	            con.close();
	        }

	        return list;
	    }
	
}
