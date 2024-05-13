<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン後のユーザー名表示</title>
</head>
<body>
	<header>
		<h1>得点管理システム</h1>
		<span style="color: blue;"><%= getName() %></span>
	
	<%
	    HttpSession session = request.getSession(false);
	    if (session != null && session.getAttribute("name") != null) {
	    %>
	        <form action="Logout.action" method="post">
	            <button type="submit">ログアウト</button>
	        </form>
	    <%
	    }
	    %>
	
	
	<%
	// セッションからユーザー名を取得するメソッド
	private String getName() {
	    HttpSession session = request.getSession(false);
	    if (session != null) {
	        return (String) session.getAttribute("name");
	    }
	    return null; // セッションが存在しない場合はゲストとして表示
	}
	%>
	</header>
</body>
</html>