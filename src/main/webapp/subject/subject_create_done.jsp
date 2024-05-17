<%@page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <title>2Test</title>
    <link rel="stylesheet" href="../css/subject_create_done.css">
</head>
<body>
<%@include file="../header.jsp" %>
    <!-- 科目表示するところ -->
    <div id="wrapper">
        <div id="main">
            <h2>科目情報登録</h2>
            <p class="done" style="text-align:center">登録が完了しました</p>

            <table>
                <tr>
                    <th class="back"><a href="../subject/SubjectCreate.action">戻る</a></th>
                    <th><a href="../subject/SubjectList.action">科目一覧</a></th>
                </tr>
            </table>
            <!-- <nobr>
                <p class="back"><a href="#">戻る</a></p>
                <p><a href="#">科目一覧</a></p>
            </nobr> -->
        </div>
        <%@include file="../aside.jsp" %>
<%@include file="../footer.jsp" %>
</body>
