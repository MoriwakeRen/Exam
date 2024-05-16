<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/header.css">
<%@include file="header.html" %>


<header>
<div class="row">
	<div class="col-9"><h1>得点管理システム</h1></div>
	<c:if test="${not empty teacher}">
		<div class="col-2">${teacher.name} 様</div>
		<div class="col-1"><a href="Logout.action">ログアウト</a><div>
    </c:if>
</div>
</header>


	
	