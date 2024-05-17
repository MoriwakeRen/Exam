package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;


public class TeacherDao extends Dao{
//	public Teacher get(String id) throws Exception{
//		Teacher teacher=null;
//		
//		Connection con=getConnection();
//		
//		PreparedStatement st=con.prepareStatement(
//				"select * from teacher where id=?");
//		st.setString(1, id);
//		ResultSet rs=st.executeQuery();
//		
//		while(rs.next()) {
//			teacher=new Teacher();
//			teacher.setId(rs.getString("id"));
//			teacher.setPassword(rs.getString("password"));
//			teacher.setName(rs.getString("name"));
//			teacher.setSchool((School) rs.getObject("school"));
//			}
//		
//		st.close();
//		con.close();
//		return teacher;
//	}
	
	public Teacher login(String id, String password) throws Exception {
	    Teacher teacher = null;

	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement(
	            "SELECT * FROM teacher WHERE id = ? AND password = ?");
	    st.setString(1, id);
	    st.setString(2, password);
	    ResultSet rs = st.executeQuery();

	    while (rs.next()) {
	        String storedPassword = rs.getString("password");
	        if (storedPassword.equals(password)) {
	            teacher = new Teacher();
	            teacher.setId(rs.getString("id"));
	            teacher.setPassword(storedPassword);
	            teacher.setName(rs.getString("name"));

	            SchoolDao schoolDao =new SchoolDao();
	            teacher.setSchool(schoolDao.get(rs.getString("school_cd")));
//	            この一行をわかりやすくすると↓
//	            String cd=rs.getString("school_cd");
//	            School school=schoolDao.get(cd);
//	            teacher.setSchool(school);
	        }
	    }

	    st.close();
	    con.close();
	    return teacher;
	}

}
