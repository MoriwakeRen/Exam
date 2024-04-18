package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Teacher;


public class TeacherDAO extends DAO{
	public Teacher get(String id) throws Exception{
		Teacher teacher=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from teacher where id=?");
		st.setString(1, id);
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			Teacher t=new Teacher();
			t.setId(rs.getString("id"));
			t.setPassword(rs.getString("password"));
			t.setName(rs.getString("password"));
			}
		
		st.close();
		con.close();
		return teacher;
	}
	
	public Teacher login(String id,String password)throws Exception{
		
	}
}
