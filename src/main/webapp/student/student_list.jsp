<%@page contentType="text/html; charset=UTF-8"%>
<%-- <%@include file="../test.jsp"%>
 --%>
 <%@include file="../header.jsp" %>
 <%@include file="../aside.jsp"%>

<div id="main-content">
	<h2>学生管理</h2>
<section>
	<ul>
		<li id="newregist"><a href="">新規登録</a></li>
	</ul>
</section>
<div id="search-container">
<div id="row">
		<div id="col-4">
			<label for="f1">入学年度</label><br> <select title="選択してください" id="f1" name="f1" onchange="this.disabled=true;">
					<option selected>---------</option>
				</select>
		</div>
		<div id="col-4">
			<label for="f2">クラス</label><br> <select title="選択してください" id="f2" name="f2" onchange="this.disabled=true;">
				<option selected>---------</option>
			</select>
		</div>
		<div class="student-action">
            <label for="f3"><input type="checkbox" id="f3" name="f3">在学中</label>
		</div>
			<button class="button">絞込み</button>
	</div>
</div>
<div></div>
</div>
</div>

<%@include file="../footer.jsp"%>