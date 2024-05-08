package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bean.School;

public class classNumDao extends Dao{
	public List<String> filter(School school)throws Exception{
		Connection con = getConnection();
        List<String> filteredClassNums = new ArrayList<>();

        try {
            PreparedStatement st = con.prepareStatement(
                    "SELECT DISTINCT class_num FROM test WHERE school_cd = ?");
            st.setString(1, school.getCd());

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                String classNum = rs.getString("class_num");
                filteredClassNums.add(classNum);
            }

            rs.close();
            st.close();
        } finally {
            con.close();
        }

        return filteredClassNums;
    }
}
