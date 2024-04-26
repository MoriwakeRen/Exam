<%@page contentType="text/html; charset=UTF-8" %>

<head>
    <meta charset="UTF-8">
    <title>Test</title>
    <link rel="stylesheet" href="../css/subject_list.css">
</head>
<body>
    <header>
        <h1>得点管理システム</h1>
    </header>
    <!-- 科目表示するところ -->
    <div id="wrapper">
        <div id="main">
            <h2>科目管理</h2>
            <p><a href="">新規登録</a></p>
            <table>
                <tr>
                    <th class="normal">科目コード</th>
                    <th class="normal">科目名</th>
                    <th class="ikenie">変更行</th>
                    <br>
                </tr>
                <tr>
                    <td class="normal">A01</td>
                    <td class="normal">国語</td>
                    <td class="actions">
                        <a href="">変更</a>
                        <a href="">削除</a>
                    </td>
                </tr>
            </table>
        </div>
        <!-- さいどばー -->
        <aside id="sidebar">
            <section id="side_banner">
                <ul>
                    <li class="ue"><a href="">メニュー</a></li>
                    <li class="naka"><a href="">学生管理</a></li>
                    <li>成績管理</li>
                    <li class="naka2"><a href="">成績登録</a></li>
                    <li class="naka2"><a href="">成績参照</a></li>
                    <li class="naka"><a href="">科目管理</a></li>
                </ul>
            </section>
        </aside>
    </div>
    <footer>
        <h5>ふったー</h5>
    </footer>
</body>