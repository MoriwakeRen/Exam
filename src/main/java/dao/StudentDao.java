package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao{
	private String baseSql;
	
	public Student get(String no) throws Exception{
		List<Student> list=new ArrayList<>(); // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from student where no=?");
		st.setString(1, no); // 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			Student s=new Student();
			s.setNo(rs.getString("no"));
			list.add(s); // データを一件取得するごとにlistに追記する
		}

		st.close();
		con.close(); // DB接続を閉じる

		return list; // listの値を返却する
	};
	private List<Student> postFilter(ResultSet rSet,School school) throws Exception{};
	
}
