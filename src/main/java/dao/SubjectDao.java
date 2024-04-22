package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import bean.School;
import bean.Subject;


public class SubjectDao extends Dao{
	public Subject get(String cd,School school)throws Exception{

		Subject subject=new Subject(); // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from subject where cd=? and school=?");
		st.setString(1, cd);
		st.setObject(2, school);// 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			Subject s=new Subject();
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			s.setSchool((School) rs.getObject("school"));			
		}

		st.close();
		con.close(); // DB接続を閉じる

		return subject; // listの値を返却する
	};
	
	
	public List<Subject> filter(School school)throws Exception{
		List<Subject> list=new AllayList<>();
		
		Connection con=getConnection();}
		
		
	
	public boolean save(Subject subject)throws Exception{};
	
	public boolean delete(Subject subject)throws Exception{};
}
