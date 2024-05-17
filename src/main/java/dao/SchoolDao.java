package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.School;

public class SchoolDao extends Dao{
	public School get(String no)throws Exception{
		School school=null; // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from school where cd=?");
		st.setString(1, no); // 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			school=new School();
			school.setCd(rs.getString("cd"));
			school.setName(rs.getString("name"));			
		}

		st.close();
		con.close(); // DB接続を閉じる

		return school; // listの値を返却する
	};
}
