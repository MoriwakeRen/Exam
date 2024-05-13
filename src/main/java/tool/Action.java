package tool;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public abstract class Action {
	public void execute(HttpServletRequest req,HttpServletResponse res)throws Exception {
}
}