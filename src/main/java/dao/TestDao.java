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
	private String baseSql = "select from test where ";
	
	public Test get(Student student,Subject subject,School school,int no)throws Exception{
		Test test=null;

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			baseSql + "no=?");
		st.setInt(1, no); // 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			test=new Test();
			test.setStudent((Student) rs.getObject("student"));
			test.setSubject((Subject) rs.getObject("subject"));
			test.setSchool((School) rs.getObject("student"));
			test.setNo(rs.getInt("no"));
		}

		st.close();
		con.close(); // DB接続を閉じる

		return test; // listの値を返却
	}
	
	
	public List<Test> filter(int entYear, String classNum, Subject subject, int num, School school) throws Exception {
	       List<Test> list = new ArrayList<>();

	        Connection con = getConnection();

	        // Construct the query based on filtering conditions
	        boolean isFirstCondition = true;

	        if (entYear > 0) {
	            baseSql += (isFirstCondition ? "" : " AND ") + "entYear = ?";
                isFirstCondition = false;
	        }

	       if (classNum != null && !classNum.isEmpty()) {
	           baseSql += (isFirstCondition ? "" : " AND ") + "classNum = ?";
	           isFirstCondition = false;
	        }

	       if (subject != null) {
	           baseSql += (isFirstCondition ? "" : " AND ") + "subject = ?";
	           isFirstCondition = false;
	        }

	       if (num > 0) {
	           baseSql += (isFirstCondition ? "" : " AND ") + "num = ?";
	           isFirstCondition = false;
	       }
	       if (school != null) {
	           baseSql += (isFirstCondition ? "" : " AND ") + "school = ?";
	       }
           PreparedStatement st = con.prepareStatement(baseSql);

	       int paramIndex = 1;
	       if (entYear > 0) {
	           st.setInt(paramIndex++, entYear);
	       }

	       if (classNum != null && !classNum.isEmpty()) {
	           st.setString(paramIndex++, classNum);
	       }
	       if (subject != null) {
	           st.setString(paramIndex++, subject.getCd());
	       }
	       if (num > 0) {
	           st.setInt(paramIndex++, num);
	       }
	       if (school != null) {
	            st.setString(paramIndex, school.getCd());	        }

	       ResultSet rs = st.executeQuery();
	       while (rs.next()) {
	           Test test = new Test();
	           test.setStudent((Student) rs.getObject("student"));
	           test.setSubject((Subject) rs.getObject("subject"));
	           test.setSchool((School) rs.getObject("school"));
	           test.setNo(rs.getInt("no"));
	           list.add(test);
	        }
	       st.close();
	       con.close();

	       return list;
	   }
	
	public boolean save(List<Test> list)throws Exception{
		Connection con = getConnection();

	    try {
	        con.setAutoCommit(false); // 自動コミットを無効にしてトランザクションを確立

	        for (Test test : list) {
	            PreparedStatement st = con.prepareStatement(
	                    "INSERT INTO test (student_no, subject_cd, school_cd, no, point, class_num) VALUES (?, ?, ?, ?, ?, ?)");

	            st.setString(1, test.getStudent().getNo());
	            st.setString(2, test.getSubject().getCd());
	            st.setString(3, test.getSchool().getCd());
	            st.setInt(4, test.getNo());
	            st.setInt(5, test.getPoint());
	            st.setString(6, test.getClassNum());

	            int rowsAffected = st.executeUpdate();
	            st.close();

	            if (rowsAffected <= 0) {
	                con.rollback(); // 1つでもテストの保存に失敗した場合はロールバック
	                return false;
	            }
	        }

	        con.commit(); // すべてのテストが正常に保存された場合はコミット
	        return true;
	    } catch (Exception e) {
	        con.rollback(); // 例外が発生した場合はロールバック
	        throw e;
	    } finally {
	        con.setAutoCommit(true); // 自動コミットモードに戻す
	        con.close();
	    }
	}
	
	
	public boolean delete(List<Test> list)throws Exception{
		Connection con = getConnection();

	    try {
	        con.setAutoCommit(false); // 自動コミットを無効にしてトランザクションを確立

	        for (Test test : list) {
	            PreparedStatement st = con.prepareStatement(
	                    "DELETE FROM test WHERE student_no = ? AND subject_cd = ? AND school_cd = ?");

	            st.setString(1, test.getStudent().getNo());
	            st.setString(2, test.getSubject().getCd());
	            st.setString(3, test.getSchool().getCd());

	            int rowsAffected = st.executeUpdate();
	            st.close();

	            if (rowsAffected <= 0) {
	                con.rollback(); // 1つでもテストの削除に失敗した場合はロールバック
	                return false;
	            }
	        }

	        con.commit(); // すべてのテストが正常に削除された場合はコミット
	        return true;
	    } catch (Exception e) {
	        con.rollback(); // 例外が発生した場合はロールバック
	        throw e;
	    } finally {
	        con.setAutoCommit(true); // 自動コミットモードに戻す
	        con.close();
	    }
	}
	
}
