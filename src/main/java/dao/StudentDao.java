package dao;

import java.sql.ResultSet;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao{
	private String baseSql;
	
	public Student get(String no) throws Exception{
		return no;
	};
	private List<Student> postFilter(ResultSet rSet,School school) throws Exception{};
	
}