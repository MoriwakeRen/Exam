<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<link rel="stylesheet" type="text/css" href="../css/login.css">
<html>
<head>
    <meta charset="UTF-8">
    <title>ログイン後のユーザー名表示</title>
</head>
<body>
	<h1>得点管理システム</h1>
	<c:if test="${not empty teacher}">
		<form action="Logout.action">
            <button type="submit">ログアウト</button>
        </form>
    </c:if>
	
</body>
</html>