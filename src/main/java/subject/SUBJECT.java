package subject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import tool.Page;

@WebServlet(urlPatterns= {"/subject/test"})
public class SUBJECT extends HttpServlet {
	public void doGet (
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Page.header(out);
		try {
			InitialContext ic=new InitialContext();
			DataSource ds=(DataSource)ic.lookup("java:/comp/env/jdbc/school");
			Connection con=ds.getConnection();
			
			PreparedStatement st=con.prepareStatement("select * from SUBJECT");
			ResultSet rs=st.executeQuery();
			
			while (rs.next()) {
				out.println(rs.getString("SCHOOL_CD"));
				out.println(":");
				out.println(rs.getString("CD"));
				out.println(":");
				out.println(rs.getString("NAME"));
				out.println("<br>");
			}
			
			st.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace(out);
		}
		Page.footer(out);
	}
}
