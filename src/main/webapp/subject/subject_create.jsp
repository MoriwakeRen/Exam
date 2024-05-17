<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
	<meta charset="UTF-8">
	<title>2Test</title>
	<link rel="stylesheet" href="../css/subject_create.css">
</head>
<body>
	<%@include file="../header.jsp" %>
    <!-- 科目表示するところ -->
    <div id="wrapper">
        <div id="main">
            <h2>科目情報登録</h2>
            <form method="post" action="SubjectCreateExecute.action">
                <p>科目コード</p>
            <!-- テキストボックス入力エラーで検索すると、いろいろ出てくる -->
                <div class="search-container">
                    <input type="text" name="cd" class="search-input" id="searchInput" required>
                    	<label for="searchInput" class="default-text">科目コードを入力してください</label>
                </div>
            	<c:if test="${error1 == 101 }">
            	<p class="error">科目コードは3文字で入力してください</p></c:if>
            	<c:if test="${error2 == 202 }">
            	<p class="error">科目コードが重複しています</p></c:if>
                <p>科目名</p>
                <div class="search-container">
                    <input type="text" name="name" class="search-input" id="searchInput" required>
                    	<label for="searchInput" class="default-text">科目名を入力してください</label>
                </div>
                
                <p><input type="submit" value="登録" id="subscribe"></p>
            </form>
        <h5><a href="subject_list.jsp">戻る</a></h5>
        </div>
        
		<%@include file="../aside.jsp" %>
	</div>
	<%@include file="../footer.jsp" %>
</body>