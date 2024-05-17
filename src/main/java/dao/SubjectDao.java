package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Subject;


public class SubjectDao extends Dao{
	public Subject get(String cd,School school)throws Exception{

//		Subject subject=null; // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)
		Subject subject = new Subject();
		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from subject where cd=? and school_cd = ?");
		st.setString(1, cd);
		st.setString(2, school.getCd());// 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			subject=new Subject();
			subject.setSchool(school);		
			subject.setCd(cd);
			subject.setName(rs.getString("name"));	
		}

		st.close();
		con.close(); // DB接続を閉じる

		return subject; // listの値を返却する
	};
	
	
	public List<Subject> filter(School school)throws Exception{
		List<Subject> list=new ArrayList<>();
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
				"select * from subject where school_cd = ?");
			st.setString(1,school.getCd());
			ResultSet rs=st.executeQuery();

			// データを順に取得
			while (rs.next()) {
				Subject s=new Subject();
				s.setCd(rs.getString("cd"));
				s.setName(rs.getString("name"));
				list.add(s); // データを一件取得するごとにlistに追記する
			}

			st.close();
			con.close(); // DB接続を閉じる

			return list; // listの値を返却する
		
	}
		
		
	
	public boolean save(Subject subject)throws Exception{
		Connection con = getConnection(); // データベース接続を取得
		
		if(get(subject.getCd(), subject.getSchool()).getCd() == null) {
			PreparedStatement st = con.prepareStatement(
				"insert into subject values(?, ?, ?)"
			);
			st.setString(1,subject.getSchool().getCd());
			st.setString(2,subject.getCd());
			st.setString(3,subject.getName());
			
			st.executeUpdate();
			st.close();
			con.close();
		} else {
			PreparedStatement st = con.prepareStatement(
				"update subject set name = ? where cd = ? and school_cd = ?"
			);
			st.setString(1, subject.getName());
			st.setString(2, subject.getCd());
			st.setString(3, subject.getSchool().getCd());
			
			st.executeUpdate();
			st.close();
			con.close();
		}
		
		return true;
	}
	public boolean delete(Subject subject)throws Exception{
		boolean success = false;
	    Connection con = getConnection(); // データベース接続を取得

	    try {
	        // DELETE FROM文を実行
	        PreparedStatement st = con.prepareStatement(
	            "DELETE FROM subject WHERE cd = ?");
	        st.setString(1, subject.getCd());
	        int rowsAffected = st.executeUpdate();

	        if (rowsAffected > 0) {
	            success = true; // データベースから削除成功
	        }
	    } finally {
	        con.close(); // データベース接続を閉じる
	    }

	    return success;
	};
}
