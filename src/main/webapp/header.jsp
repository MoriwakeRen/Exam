<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="../css/header.css">
<%@include file="header.html" %>


<header>
	<h1>得点管理システム</h1>
	<c:if test="${not empty teacher}">
		<form action="Logout.action">
            <button type="submit">ログアウト</button>
        </form>
    </c:if>
</header>
	
	
