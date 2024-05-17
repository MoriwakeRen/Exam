<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <meta charset="UTF-8">
    <title>Test</title>
    <link rel="stylesheet" href="../css/subject_list.css">
</head>
<body>
<%@include file="../header.jsp" %>
    <!-- 科目表示するところ -->
    <div id="wrapper">
        <div id="main">
            <h2>科目管理</h2>
            <p><a href="../subject/SubjectCreate.action">新規登録</a></p>
            <table>
                <tr>
                    <th class="normal">科目コード</th>
                    <th class="normal">科目名</th>
                    <th class="ikenie">変更行</th>
                    <br>
                </tr>
                <c:forEach var="subject" items="${list}">
	            	<tr>
	                	<td class="normal">${subject.cd}</td>
	                	<td class="normal">${subject.name}</td>
	                	<td class="actions">
	                        <a href="">変更</a>
	                        <a href="">削除</a>
	                    </td>
	                </tr>
	            </c:forEach>
            </table>
        </div>
        
		<%@include file="../aside.jsp" %>
	</div>
	<%@include file="../footer.jsp" %>
</body>