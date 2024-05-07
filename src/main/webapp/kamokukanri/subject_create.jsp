<%@page contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html"%>
<%@include file="menu.jsp"%>

<h2>科目情報登録</h2>
<form action="SubjectCreate.action" method="post">
	<label>科目コード</label>
	<input type="text" name="cd" values=${cd} placeholder="科目コードを入力してください" required>
	<label>科目名</label>
	<input type="text" name="name" values=${name} placeholder="科目名を入力してください" required>
	<input type="button" name="regist" value="登録">
</form>

<%@include file="../footer.html"%>