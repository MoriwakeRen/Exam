package tool;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/kamokukanri/subject_create"})

public class SubjectCreateExecuteAction extends Action{
	public void doPost (
			HttpServletRequest req, HttpServletResponse res
		) throws ServletException, IOException {
			PrintWriter out=res.getWriter();
			Page.header(out);
			try {
				InitialContext ic=new InitialContext();
				DataSource ds=(DataSource)ic.lookup(
					"java:/comp/env/jdbc/school");
				Connection con=ds.getConnection(); // DBに接続
				
				String SCHOOL_CD=req.getParameter("SCHOOL_CD");
				String CD=req.getParameter("CD");
				String NAME=req.getParameter("NAME");
				
				PreparedStatement st=con.prepareStatement(
					"insert into subject values(?, ?, ?)");
				st.setString(1, SCHOOL_CD);
				st.setString(2, CD);
				st.setString(3, NAME);
				int line=st.executeUpdate(); // sqlの実行。処理した行数を取得
				
				if (line>0) {
					RequestDispatcher rd = req.getRequestDispatcher("menu.jsp");
					rd.forward(req, res);
				}
				
				
				
				st.close();
				con.close(); // DBを閉じる
			// 例外発生時の処理
			} catch (Exception e) {
				e.printStackTrace(out);
			}
			Page.footer(out); // tool/Page.javaのfooterメソッドを実行
		}
}
