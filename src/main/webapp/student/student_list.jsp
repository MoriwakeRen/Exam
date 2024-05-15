<%@page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

 <link rel="stylesheet" type="text/css" href="../css/student_list.css"> 
<%@include file="../header.jsp" %>
<%@include file="../aside.jsp"%> 

<div id="main-contet">
	<h2>学生管理</h2>
	<section>
		<ul>
			<li id="newregist"><a href="">新規登録</a></li>
		</ul>
	</section>
	<div id="search-container">
		<div id="row">
			<div id="col-4">
				<label for="f1">入学年度</label><br> <select title="選択してください"
					id="f1" name="f1" onchange="this.disabled=true;">
					<option selected>---------</option>
				</select>
			</div>
			<div id="col-4">
				<label for="f2">クラス</label><br> <select title="選択してください"
					id="f2" name="f2" onchange="this.disabled=true;">
					<option selected>---------</option>
				</select>
			</div>
			<div class="student-action">
				<label for="f3"><input type="checkbox" id="f3" name="f3">在学中</label>
			</div>
			<button class="button">絞込み</button>
		</div>

<table>
	<c:forEach var="student" items="${list}">
		<tr>
			<td>${student.entYear}</td>
			<td>${student.no}</td>
			<td>${student.name}</td>
			<td>${student.classNum}</td>
			<td>${student.isAttend ? '〇' : '×'}</td>
		</tr>
	</c:forEach>
</table>
</div>
