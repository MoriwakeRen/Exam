package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;
import bean.Student;

public class StudentDao extends Dao{
	private String baseSql="select from student where";
	
	public Student get(String no) throws Exception{
		Student student=null; // Product型の配列を作成

		Connection con=getConnection(); // DBに接続(DAOのgetConnectionメソッドを実行)

		// select文を実行
		PreparedStatement st=con.prepareStatement(
			"select * from student where no=?");
		st.setString(1, no); // 修正
		ResultSet rs=st.executeQuery();

		// データを順に取得
		while (rs.next()) {
			student=new Student();
			student.setNo(rs.getString("no"));
		}

		st.close();
		con.close(); // DB接続を閉じる

		return student; // listの値を返却する
	}
	
//	一覧表示
    public List<Student> searchAll() throws Exception{
    	List<Student> student=new ArrayList<>();
    	
    	Connection con=getConnection();
    	
    	PreparedStatement st=con.prepareStatement(
           "select * from student");
        ResultSet rs=st.executeQuery();
        
        while (rs.next()) {
        	Student p=new Student();
        	p.setNo(rs.getString("no"));
        	p.setName(rs.getString("name"));
        	p.setEntYear(rs.getInt("ent_year"));
        	p.setNo(rs.getString("class_num"));
        	p.setIsAttend(rs.getBoolean("is_attend"));
        	student.add(p);
        }
        st.close();
        con.close();
        
        return student;
    }
//	private List<Student> postFilter(ResultSet rSet, School school) throws Exception {
//	    List<Student> list = new ArrayList<>();
//
//	    Connection con = getConnection();
//
//	    // select文を実行
//	    PreparedStatement st = con.prepareStatement(baseSql);
//	    st.setObject(1, school);
//	    rSet = st.executeQuery();
//
//	    // データを順に取得
//	    while (rSet.next()) {
//	        Student s = new Student();
//	        s.setNo(rSet.getString("no"));
//	        s.setName(rSet.getString("name"));
//	        s.setEntYear(rSet.getInt("entYear"));
//	        list.add(s); // データを一件取得するごとにlistに追記する
//	    }
//
//	    st.close();
//	    con.close(); // DB接続を閉じる
//
//	    return list; // listの値を返却する
//	}
	public List<Student> filter(School school,int entYear,String classNum,boolean isAttend)throws Exception{
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			baseSql + "entYear=? and classNum=? and isAttend=?");
		st.setInt(1, entYear);
		st.setString(2, classNum);
		st.setBoolean(3, isAttend);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Student s=new Student();
			s.setEntYear(rs.getInt("entYear"));
			s.setClassNum(rs.getString("classNum"));
			s.setIsAttend(rs.getBoolean("isAttend"));
			list.add(s);		
		}

		st.close();
		con.close();
		return list;
	}
	
	public List<Student> filter(School school,int entYear,boolean isAttend)throws Exception{
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			baseSql + "entYear=? and isAttend=?");
		st.setInt(1, entYear);
		st.setBoolean(3, isAttend);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Student s=new Student();
			s.setEntYear(rs.getInt("entYear"));
			s.setIsAttend(rs.getBoolean("isAttend"));
			list.add(s);		
		}

		st.close();
		con.close();
		return list;
	}
	
	public List<Student> filter(School school,boolean isAttend)throws Exception{
		List<Student> list=new ArrayList<>();

		Connection con=getConnection();

		PreparedStatement st;
		st=con.prepareStatement(
			baseSql + "isAttend=?");
		st.setBoolean(3, isAttend);
		ResultSet rs=st.executeQuery();

		while (rs.next()) {
			Student s=new Student();
			s.setIsAttend(rs.getBoolean("isAttend"));
			list.add(s);		
		}

		st.close();
		con.close();
		return list;
	}
	
	public boolean save(Student student) throws Exception {
	    boolean success = false;
	    Connection con = getConnection(); // データベース接続を取得

	    try {
	        // INSERT INTO文を実行
	        PreparedStatement st = con.prepareStatement(
	            "INSERT INTO student (no, name, entYear, classNum, isAttend) VALUES (?, ?, ?, ?, ?)");
	        st.setString(1, student.getNo());
	        st.setString(2, student.getName());
	        st.setInt(3, student.getEntYear());
	        st.setString(4, student.getClassNum());
	        st.setBoolean(5, student.isAttend());
	        int rowsAffected = st.executeUpdate();

	        if (rowsAffected > 0) {
	            success = true; // データベースに追加成功
	        }
	    } finally {
	        con.close(); // データベース接続を閉じる
	    }

	    return success;
	}

	public boolean delete(Student student) throws Exception {
	    boolean success = false;
	    Connection con = getConnection(); // データベース接続を取得

	    try {
	        // DELETE FROM文を実行
	        PreparedStatement st = con.prepareStatement(
	            "DELETE FROM student WHERE no = ?");
	        st.setString(1, student.getNo());
	        int rowsAffected = st.executeUpdate();

	        if (rowsAffected > 0) {
	            success = true; // データベースから削除成功
	        }
	    } finally {
	        con.close(); // データベース接続を閉じる
	    }

	    return success;
	}

}
	

	

	

