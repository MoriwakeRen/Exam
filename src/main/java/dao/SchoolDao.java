package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class SchoolDao extends Dao{
	public School get(String no)throws Exception{
		List<School> list=new ArrayList<>(); // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from school where no=?");
		st.setString(1, no); // 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			School s=new School();
			s.setCd(rs.getString("cd"));
			s.setName(rs.getString("name"));
			list.add(s); // データを一件取得するごとにlistに追記する
			
		}

		st.close();
		con.close(); // DB接続を閉じる

		return list; // listの値を返却する
	};
}
