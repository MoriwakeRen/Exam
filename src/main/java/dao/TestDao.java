package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;
import bean.Subject;
import bean.Test;

public class TestDao extends Dao{
	private String baseSql;
	
	public Test get(Student student,Subject subject,School school,int no)throws Exception{
		List<Test> list=new ArrayList<>(); // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from test where no=?");
		st.setInt(1, no); // 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			Test t=new Test();
			t.setStudent((Student) rs.getObject("student"));
			t.setSubject((Subject) rs.getObject("subject"));
			t.setSchool((School) rs.getObject("student"));
			t.setNo(rs.getInt("no"));
			list.add(t); // データを一件取得するごとにlistに追記する
		}

		st.close();
		con.close(); // DB接続を閉じる

		return list; // listの値を返却
	};
	
	private List<Test> postFilter(ResultSet rSet,School school)throws Exception{};
	
	public List<Test> filter(int entYear,String classNum,Subject subject,int num,School school)throws Exception{};
	
	public boolean save(List<Test> list)throws Exception{};
	
	private boolean save(Test test,Connection connection)throws Exception{};
	
	public boolean delete(List<Test> list)throws Exception{};
	
	private boolean delete(Test test,Connection connection)throws Exception{};
}
