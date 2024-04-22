<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../mainmenu/menu.jsp"%>

<head>

<link rel="stylesheet" type="text/css" href="../css/test.css">
</head>
<div class="sidebar">
  <!-- メニュー部分 -->
  <ul>
    <li><a href="mainMenu.jsp">メニュー</a></li>
    <!-- ...他のリストアイテム... -->
  </ul>
</div>

	<div class="container title-container">
		<h2>学生管理</h2>
	</div>
	<div class="right-align">
		<ul>
			<li><a href="../gakuseikanri/StudentList.action">新規登録</a></li>
		</ul>
	</div>

	<div class="search-container">
		<div class="flex-container flex-column">
			<div class="flex-item">

				<label for="year-of-admission">入学年度</label> <select
					id="year-of-admission" class="select">
					<option>------------</option>
					<!-- 入学年度のオプションをここに追加 -->
				</select>
			</div>
			<div class="flex-item">
				<label for="class">クラス</label> <select id="class" class="select">
					<option>------------</option>
					<!-- クラスのオプションをここに追加 -->
				</select>
			</div>

			<div class="flex-item checkbox-container">
				<label> <input type="checkbox" name="checkbox-name">
					在学中
				</label>
			</div>
			<div class="flex-item">
				<button class="button">絞込み</button>
			</div>
		</div>
	</div>
</div>

<%@ include file="../footer.html"%>



