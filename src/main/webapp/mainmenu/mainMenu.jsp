<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../header.html"%>

<%@include file="menu.jsp"%>

<ul></ul>
<li><a>メニュー</a></li>
<ul></ul>
<div class="row">
	<div class="col-4">
		<li><a href="../student/StudentList.action">学生管理</a></li>
		
		<!-- "../student/student_list/student_list.jsp" -->
	</div>
	<div class="col-4">
		<ul></ul>
		<a>成績管理</a>
		<li><a>成績登録</a></li>
		<li><a>成績参照</a></li>
	</div>
	<div class="col-4">
		<ul></ul>
		<li><a>科目管理</a></li>
	</div>
</div>



<%@include file="../footer.html"%>