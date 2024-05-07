<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<%@include file="menu.jsp"%>

<h2>科目情報登録</h2>
<form action="SubjectCreate.action" method="post">
	<label>科目コード</label>
	<input type="text" name="cd" placeholder="科目コードを入力してください">

<%@include file="../footer.html"%>