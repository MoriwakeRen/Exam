package subject;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/subject/SUBJECT"})
public class SUBJECT extends HttpServlet {
	public void doGet(
		HttpServletRequest request, HttpServletResponse response
	) throws ServletException, IOException {
		String url="";
		String user="sa";
		String password="";
		
		List<String> subjects = new ArrayList<>();
		
		try {
			Class.forName("org.h2.Driver");
			
			try (Connection con = DriverManager.getConnection(url, user, password);
					Statement st = con.createStatement();){
				ResultSet res = st.executeQuery("SELECT * FROM SUBJECT");
				
				while(res.next()) {
					subjects.add(res.getString("title"));
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("subjects", subjects);
		
		request.getRequestDispatcher("../subject/subject.jsp").forward(request, response);
	}
}
